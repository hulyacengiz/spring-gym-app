🏋️‍♀️ Spring Gym App

Bu proje, kullanıcıların bir spor salonuna günde yalnızca bir kez giriş yapabilmesini sağlayan bir Spring Boot REST API uygulamasıdır.

🚀 Teknolojiler

Java 17

Spring Boot 3.2.4

Spring Web

Spring Data JPA

PostgreSQL

Docker & Docker Compose

Spring Security (şifre hashleme için)

Lombok

Swagger (API dökümantasyonu)

⚙️ Kurulum
1. Projeyi klonla:
   git clone https://github.com/hulyaedanur/spring-gym-app.git
   cd spring-gym-app
2. Docker ile PostgreSQL başlat:
   docker-compose up -d
3. Uygulamayı başlat
   IntelliJ ile açıp çalıştırabilirsin, ya da terminalden: 
./mvnw spring-boot:run

 
📂 API Endpoint’leri

Yöntem	   Endpoint             Açıklama

POST	  /api/users/register	Yeni kullanıcı kaydı

POST	  /api/entry	        Kullanıcının salona giriş denemesi

🔐 Swagger UI
Uygulama çalıştıktan sonra Swagger’a tarayıcıdan eriş:

📎 http://localhost:8080/swagger-ui.html

📌 Notlar

Kullanıcı şifreleri BCrypt ile hash’lenmektedir.

Aynı kullanıcı bir günde yalnızca 1 kez giriş yapabilir.

spring.jpa.hibernate.ddl-auto=update sayesinde tablolar otomatik oluşur.

👩‍💻 Geliştirici

Hülya Cengiz