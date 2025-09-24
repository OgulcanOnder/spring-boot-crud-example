# Spring Boot CRUD API

Clean Code prensiplerine uygun olarak geliştirilmiş, PostgreSQL veritabanı ile entegre çalışan bir CRUD API örneği.

## Teknolojiler

- **Backend:** Spring Boot 3.5.6
- **Mapper:** MapStruct 1.6.3
- **Database:** PostgreSQL
- **Build Tool:** Maven 3.11.0
- **Java:** 17

  ## Özellikler

  Temiz ve okunabilir kod yapısı (Clean Code prensipleri uygulanmıştır)
- CRUD işlemleri:
  - **Create:** Yeni veri ekleme
  - **Read:** Tekli ve çoklu veri sorgulama
  - **Update:** Mevcut veriyi güncelleme
  - **Delete:** Veri silme
- DTO ve Entity ayrımı
- MapStruct ile mapper kullanımı

  ## Kurulum
  1. **Repository’yi klonlayın:** 
  ```bash
  git clone https://github.com/OgulcanOnder/spring-boot-crud-example.git
  cd <spring-boot-crud-example>
  ```
  
2. **PostgreSQL veri tabanı oluşturun:**
   ```sql
   CREATE DATABASE crud_db;
   ```

3. **application.properties veya application.yml dosyasını güncelleyin:**
   spring.datasource.url=jdbc:postgresql://localhost:5432/crud_example
   spring.datasource.username=postgres
   spring.datasource.password=1
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

4. **Projeyi Maven ile build edin:**
   ```bash
   mvn clean install
   ```

5. **Projeyi çalıştırın:**
   ```bash
   mvn spring-boot:run
   ```
