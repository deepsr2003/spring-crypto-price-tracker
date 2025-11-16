# Real-Time Crypto Price Tracker

A professional-grade backend application built on Spring Boot that fetches cryptocurrency prices and streams them to connected clients in real-time using WebSockets.

## 🚀 Key Features

*   **Real-Time Data Streaming:** Uses **Spring WebSockets (STOMP)** to push price updates to all subscribed web clients, demonstrating low-latency, bi-directional communication.
*   **Asynchronous Scheduling:** Implements **Spring `@Scheduled`** to periodically fetch data from an external provider (CoinMarketCap API).
*   **External API Integration:** Utilizes **Spring WebClient** for non-blocking and efficient interaction with a third-party RESTful API.
*   **Production Readiness:** Includes **Spring Boot Actuator** for health monitoring and **Springdoc-OpenAPI** for API documentation (Actuator endpoints).
*   **Containerized Deployment:** Packaged with **Docker** for easy, portable, and reproducible deployment.

## 🛠️ Technology Stack

*   **Backend:** Java 25 (LTS), Spring Boot 3.x
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
<img width="1436" height="871" alt="Screenshot 2025-11-16 at 7 55 47 PM" src="https://github.com/user-attachments/assets/9e1638b0-126a-417c-bea4-d7198e383667" />

<img width="1440" height="876" alt="Screenshot 2025-11-16 at 7 55 57 PM" src="https://github.com/user-attachments/assets/7ec1265d-2c7d-4f81-ab43-fde62a00d0a2" />

<img width="1439" height="871" alt="Screenshot 2025-11-16 at 7 56 37 PM" src="https://github.com/user-attachments/assets/15753f0c-cbff-4114-a4ab-99634f7930bc" />


<img width="1440" height="878" alt="Screenshot 2025-11-16 at 7 56 45 PM" src="https://github.com/user-attachments/assets/6292575b-ad4f-4f90-9ee7-723ee5f0120e" />


   


## 🌐 Demonstration

Once the application is running, access the following URLs:

*   **Real-Time UI:** `http://localhost:8080/`
*   **API Documentation:** `http://localhost:8080/swagger-ui.html`
*   **Health Check (Actuator):** `http://localhost:8080/actuator/health`

**Demo Screenshot (Prices update automatically every 5 seconds):**
<img width="1328" height="872" alt="Screenshot 2025-11-16 at 7 56 57 PM" src="https://github.com/user-attachments/assets/a740de61-c82c-4655-888f-8769df44cd3c" />
<img width="1323" height="871" alt="Screenshot 2025-11-16 at 7 57 06 PM" src="https://github.com/user-attachments/assets/668cb0ed-a2d6-47b7-96bf-07136296c0db" />


---
