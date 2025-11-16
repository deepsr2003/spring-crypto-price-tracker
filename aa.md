This is a great approach for a quick build! Based on the required complete structure, here is the list of files to be **EDITED** and **CREATED** within your current folder structure.

*(Note: The `target` folder and its contents are generated build artifacts, not source files, and should be ignored for these instructions.)*

---

## 1. Files to **EDIT** (4 Files)

| Path | Purpose of Edit | Phase |
| :--- | :--- | :--- |
| `pom.xml` | Add dependencies: **WebSocket, WebFlux, Lombok, Actuator**. | 1 |
| `src/main/resources/application.properties` | Add **CMC API key, URL, and scheduler rate**. | 2 |
| `src/main/java/com/example/demo/DemoApplication.java` | Add **`@EnableScheduling`** annotation. | 2 |
| `src/main/resources/static/` | **(Implicit directory creation)** Create the necessary folders before adding the file. | 3 |

## 2. Files to **CREATE** (9 Files)

### Phase 1: Data Models (4 Files)

Create these files under the new folder structure:
`src/main/java/com/example/demo/model/` and `src/main/java/com/example/demo/model/cmc/`

| Path | File Name | Purpose |
| :--- | :--- | :--- |
| `src/main/java/com/example/demo/model/` | `CryptoPrice.java` | Internal simple POJO for price data. |
| `src/main/java/com/example/demo/model/cmc/` | `CmcResponse.java` | CMC API top-level response model. |
| `src/main/java/com/example/demo/model/cmc/` | `CmcCurrencyData.java` | Maps the data block for a single currency. |
| `src/main/java/com/example/demo/model/cmc/` | `CmcQuote.java` | Maps the price and `last_updated` fields. |

### Phase 2: Services and Scheduler (2 Files)

Create these files under the new folder structures:
`src/main/java/com/example/demo/service/` and `src/main/java/com/example/demo/scheduler/`

| Path | File Name | Purpose |
| :--- | :--- | :--- |
| `src/main/java/com/example/demo/service/` | `CoinMarketCapService.java` | Contains **WebClient** logic to call CMC and map the response. |
| `src/main/java/com/example/demo/scheduler/` | `PriceFetcherScheduler.java` | Contains the **`@Scheduled`** method to fetch prices and push via WebSocket. |

### Phase 3: WebSockets & Client (3 Files)

Create these files under the new folder structure:
`src/main/java/com/example/demo/config/` and `src/main/resources/static/`

| Path | File Name | Purpose |
| :--- | :--- | :--- |
| `src/main/java/com/example/demo/config/` | `WebSocketConfig.java` | Configures the WebSocket STOMP endpoint (`/ws-tracker`) and broker (`/topic`). |
| `src/main/resources/static/` | `index.html` | Simple **HTML/JavaScript client** to connect to the WebSocket and display real-time updates. |

---

## Action Plan (Summary of Code Changes)

You can now proceed by implementing the code snippets from the previous response, following these steps:

1.  **EDIT** `pom.xml` (Add dependencies).
2.  **CREATE** all 4 **Model** files (Phase 1).
3.  **EDIT** `application.properties` (Add config).
4.  **EDIT** `DemoApplication.java` (Add `@EnableScheduling`).
5.  **CREATE** `CoinMarketCapService.java` (Phase 2).
6.  **CREATE** `PriceFetcherScheduler.java` (Phase 2 & 3 logic).
7.  **CREATE** `WebSocketConfig.java` (Phase 3).
8.  **CREATE** `index.html` (Phase 3 client demo).

Once this is complete, the project will be ready to run and demo.
