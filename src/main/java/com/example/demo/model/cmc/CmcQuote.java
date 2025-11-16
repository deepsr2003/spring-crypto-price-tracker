package com.example.demo.model.cmc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.Instant;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CmcQuote {
  @JsonProperty("price")
  private double price;

  @JsonProperty("last_updated")
  private Instant lastUpdated; // CMC returns an ISO 8601 timestamp that Jackson can map to Instant
}
