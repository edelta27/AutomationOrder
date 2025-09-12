# AutomationOrder

## Opis projektu

AutomationOrder to prosty system zamówień (Order Management System) stworzony w Spring Boot.  
Aplikacja umożliwia przeglądanie produktów w formie kafelków z obrazkami, wyszukiwanie i filtrowanie, a w przyszłości będzie zawierać logowanie, koszyk i składanie zamówień. 

Projekt demonstruje m.in.:  
- Wyświetlanie danych z bazy w frontendzie (Thymeleaf)
- Logowanie admin i użytkownik(Spring Security)
- Modelowanie relacji w bazie PostgreSQL (Entity, DTO, MapStruct)  
- Budowę REST API ze Spring Web  
- Walidację danych wejściowych (Bean Validation)  
- Obsługę wyjątków (Exception Handling)  
- Testy jednostkowe z Mockito i JUnit  
- Mapowanie encji na rekordy DTO i odwrotnie z MapStruct  

---

## Technologie

- Java 17  
- Spring Boot 3.x
- PostgreSQL  
- Thymeleaf (frontend)
- MapStruct  
- Hibernate Validator (Bean Validation)  
- Spring Security
- Mockito, JUnit 5  
- Maven  

---
## Screen of Products Page

<img width="800" height="626" alt="automation-shop" src="https://github.com/user-attachments/assets/e4e24cde-c742-4572-8640-d039f4bdbb20" />

## Funkcjonalności

- **Zarządzanie klientami:** dodawanie, pobieranie listy klientów  
- **Zarządzanie produktami:** dodawanie, pobieranie listy produktów z kafelkami i zdjęciami
- **Zamówienia:** tworzenie zamówień z wieloma pozycjami, pobieranie szczegółów zamówienia po numerze  
- Walidacja danych (np. poprawność pól, niepustość, wartości numeryczne)  
- Obsługa błędów i czytelne komunikaty  

---

## Struktura projektu

- `controller/` — REST API (CustomerController, ProductController, OrderController)  
- `service/` — logika biznesowa (CustomerServiceImpl, ProductServiceImpl, OrderServiceImpl)  
- `repository/` — warstwa dostępu do bazy (Spring Data JPA)  
- `mapper/` — mapowanie encji <-> DTO z MapStruct  
- `dto/` — rekordy DTO (CustomerDto, ProductDto, OrderDto, OrderItemDto)  
- `entity/` — encje JPA (Customer, Product, Order, OrderItem)  
- `exception/` — klasy wyjątków i globalny handler (RestControllerAdvice)  
- `templates/` — widoki Thymeleaf (index.html, produkty)
- `static/` — zasoby statyczne (obrazy, CSS)
- `test/` — testy jednostkowe

---

## Uruchomienie projektu

1. Sklonuj repozytorium:
   
   ```bash
   git clone https://github.com/edelta27/AutomationOrder.git
   cd AutomationOrder
2. Skonfiguruj bazę PostgreSQL w application.properties (lub application.yml):
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/automationorderdb
   spring.datasource.username=postgres
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=create
   spring.jpa.defer-datasource-initialization=true
   spring.sql.init.mode=always
3. Uruchom aplikację:
   ```bash
   ./mvnw spring-boot:run
4. Testuj API np. przez Postmana lub curl:
   
   POST /customers — dodaj klienta
   
   POST /products — dodaj produkt
   
   POST /orders — stwórz zamówienie
   
   GET /orders/{id} — pobierz zamówienie po numerze
5. Otwórz w przeglądarce: http://localhost:8081
