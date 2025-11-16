package com.example.demo.model.cmc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CmcResponse {
  private Map<String, CmcCurrencyData> data;
}
