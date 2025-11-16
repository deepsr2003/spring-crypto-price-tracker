package com.example.demo.model.cmc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CmcCurrencyData {
  private String symbol;
  private Map<String, CmcQuote> quote; // Key is the converted currency (e.g., "USD")
}
