package com.example.demo.service;

import com.example.demo.model.CryptoPrice;
import com.example.demo.model.cmc.CmcResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoinMarketCapService {

  @Value("${cmc.api.key}")
  private String apiKey;

  @Value("${cmc.api.url}")
  private String apiUrl;

  private static final String SYMBOLS = "BTC,ETH,XRP";
  private WebClient webClient;

  @PostConstruct
  public void init() {
    this.webClient = WebClient.builder()
        .baseUrl(apiUrl)
        .defaultHeader("X-CMC_PRO_API_KEY", apiKey)
        .build();
  }

  public Mono<List<CryptoPrice>> fetchLatestPrices() {
    return webClient.get()
        .uri(uriBuilder -> uriBuilder
            .queryParam("symbol", SYMBOLS)
            .queryParam("convert", "USD")
            .build())
        .retrieve()
        .bodyToMono(CmcResponse.class)
        .map(this::mapCmcResponseToCryptoPrices)
        .onErrorResume(e -> {
          // Log error but continue
          System.err.println("Error fetching prices from CMC: " + e.getMessage());
          return Mono.just(List.of());
        });
  }

  private List<CryptoPrice> mapCmcResponseToCryptoPrices(CmcResponse response) {
    if (response == null || response.getData() == null) {
      return List.of();
    }

    return response.getData().values().stream()
        .filter(data -> data.getQuote().containsKey("USD")) // Ensure USD quote exists
        .map(data -> {
          double price = data.getQuote().get("USD").getPrice();
          // Convert Instant to epoch milliseconds for easy JS consumption
          long timestamp = data.getQuote().get("USD").getLastUpdated()
              .toEpochMilli();

          return new CryptoPrice(data.getSymbol(), price, timestamp);
        })
        .collect(Collectors.toList());
  }
}
