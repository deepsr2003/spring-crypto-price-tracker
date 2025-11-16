# Real-Time Crypto Price Tracker

A professional-grade backend application built on Spring Boot that fetches cryptocurrency prices and streams them to connected clients in real-time using WebSockets.

## 🚀 Key Features

*   **Real-Time Data Streaming:** Uses **Spring WebSockets (STOMP)** to push price updates to all subscribed web clients, demonstrating low-latency, bi-directional communication.
*   **Asynchronous Scheduling:** Implements **Spring `@Scheduled`** to periodically fetch data from an external provider (CoinMarketCap API).
*   **External API Integration:** Utilizes **Spring WebClient** for non-blocking and efficient interaction with a third-party RESTful API.
*   **Production Readiness:** Includes **Spring Boot Actuator** for health monitoring and **Springdoc-OpenAPI** for API documentation (Actuator endpoints).
*   **Containerized Deployment:** Packaged with **Docker** for easy, portable, and reproducible deployment.

## 🛠️ Technology Stack

*   **Backend:** Java 21 (LTS), Spring Boot 3.x
*   **Data/API:** Spring WebFlux (WebClient), CoinMarketCap API
*   **Real-Time:** Spring WebSockets (STOMP), SockJS
*   **Build/Deployment:** Maven, Docker

## ▶️ How to Run

### Option 1: Run Locally (Recommended for Development)

1.  **Set Environment Variable:** Set your CoinMarketCap API key as an environment variable.
    ```bash
    export CMC_API_KEY="YOUR_API_KEY" 
    ```
2.  **Run:** Execute the Spring Boot application:
    ```bash
    ./mvnw spring-boot:run
    ```

### Option 2: Run with Docker (Recommended for Demonstration)

1.  **Set Environment Variable:** Ensure the `CMC_API_KEY` is set in your shell (as above).
2.  **Build Docker Image:**
    ```bash
    docker build -t crypto-tracker:latest .
    ```
3.  **Run Container:**
    ```bash
    docker run -d -p 8080:8080 --name crypto-app -e CMC_API_KEY="${CMC_API_KEY}" crypto-tracker:latest
    ```

## 🌐 Demonstration

Once the application is running, access the following URLs:

*   **Real-Time UI:** `http://localhost:8080/`
*   **API Documentation:** `http://localhost:8080/swagger-ui.html`
*   **Health Check (Actuator):** `http://localhost:8080/actuator/health`

**Demo Screenshot (Prices update automatically every 5 seconds):**

*(Insert your first successful screenshot here)*

---
**This project is a complete demonstration of modern backend development principles.**
