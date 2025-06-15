# AutomationOrder

## Opis projektu

AutomationOrder to prosty system zamówień (Order Management System) stworzony w Spring Boot.  
Aplikacja umożliwia zarządzanie klientami, produktami oraz składanie i przeglądanie zamówień wraz z pozycjami zamówienia (Order Items).  

Projekt demonstruje m.in.:  
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
- MapStruct  
- Hibernate Validator (Bean Validation)  
- Mockito, JUnit 5  
- Maven  

---

## Funkcjonalności

- **Zarządzanie klientami:** dodawanie, pobieranie listy klientów  
- **Zarządzanie produktami:** dodawanie, pobieranie listy produktów  
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
- `test/` — testy jednostkowe

---

## Uruchomienie projektu

1. Sklonuj repozytorium:
   
   ```bash
   git clone https://github.com/edelta27/AutomationOrder.git
   cd AutomationOrder
3. Skonfiguruj bazę PostgreSQL w application.properties (lub application.yml):
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/automationorderdb
   spring.datasource.username=postgres
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
5. Uruchom aplikację:
   ```bash
   ./mvnw spring-boot:run
6. Testuj API np. przez Postmana lub curl:
   
   POST /customers — dodaj klienta
   
   POST /products — dodaj produkt
   
   POST /orders — stwórz zamówienie
   
   GET /orders/{id} — pobierz zamówienie po numerze
