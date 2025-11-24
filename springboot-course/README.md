# Spring Boot Course

## О проекте

`springboot-course` — это демонстрационный проект, созданный для изучения основ разработки на Spring Boot. Проект реализует базовое веб-приложение с использованием **Spring Boot**, **Spring Data JPA** и **PostgreSQL**, позволяющее взаимодействовать с базой данных.

## Функциональность

Проект реализует следующие функции:

1. **RESTful API**:
    - Прием и обработка HTTP-запросов (GET, POST, PUT, DELETE) для работы с ресурсами.

2. **Работа с базой данных**:
    - Использование Spring Data JPA для взаимодействия с PostgreSQL.
    - Автоматическое создание и обновление схемы базы данных при запуске приложения.

3. **Валидация данных**:
    - Валидация входящих данных с помощью аннотаций Spring Validation.

4. **Логирование SQL-запросов**:
    - Включение вывода SQL-запросов в консоль для упрощения отладки.

## Технологии

- **Java 21**
- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**

## Установка

Чтобы запустить проект на вашем компьютере, выполните следующие шаги:

1. **Клонируйте репозиторий**:

   ```bash
   git clone https://github.com/yourusername/springboot-course.git
   ```

2. **Перейдите в директорию проекта:**

```bash
cd springboot-course
```

3. Убедитесь, что у вас установлен JDK 21 и Maven.

4. **Создайте базу данных:**

Запустите PostgreSQL и создайте базу данных:
```sql
CREATE DATABASE your_database;
CREATE USER postgres WITH PASSWORD 'root';
GRANT ALL PRIVILEGES ON DATABASE your_database TO postgres;
```

5. Настройте файл application.properties:

В файле src/main/resources/application.properties укажите настройки подключения к базе данных:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=postgres
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

6. Запустите приложение:

Выполните команду:

```bash
./mvnw clean spring-boot:run
```

## Использование
После запуска приложения вы можете протестировать его функциональность с помощью **Postman** или любого другого HTTP-клиента, отправляя запросы к вашему API.

- Создать новый ресурс (**POST**): `/api/your-resource`
- Получить все ресурсы (**GET**): `/api/your-resource`
- Обновить ресурс (**PUT**): `/api/your-resource/{id}`
- Удалить ресурс (**DELETE**): `/api/your-resource/{id}`

## Тестирование
Чтобы запустить тесты проекта, используйте команду:

```bash
./mvnw test
```