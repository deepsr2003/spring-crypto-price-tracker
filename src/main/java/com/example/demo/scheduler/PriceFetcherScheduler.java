package com.example.demo.scheduler;

import com.example.demo.service.CoinMarketCapService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PriceFetcherScheduler {

  private final CoinMarketCapService cmcService;
  private final SimpMessagingTemplate messagingTemplate;

  public PriceFetcherScheduler(CoinMarketCapService cmcService, SimpMessagingTemplate messagingTemplate) {
    this.cmcService = cmcService;
    this.messagingTemplate = messagingTemplate;
  }

  // Runs every 5000ms as defined in application.properties
  @Scheduled(fixedRateString = "${app.schedule.fetch-rate}")
  public void fetchAndPushPrices() {
    // Fetch data reactively
    cmcService.fetchLatestPrices()
        .doOnSuccess(prices -> {
          if (prices != null && !prices.isEmpty()) {
            System.out.println("--- PUSHING " + prices.size() + " NEW PRICES ---");
            // PUSH THE DATA TO THE WEB SOCKET TOPIC /topic/prices
            messagingTemplate.convertAndSend("/topic/prices", prices);
          }
        })
        .subscribe(); // Subscribe to trigger the WebClient execution
  }
}
