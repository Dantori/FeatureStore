# 🗃️ Feature Store — Spring Boot Application

Feature Store — это микросервис на основе **Spring Boot**, предназначенный для хранения и управления признаками (*features*) в формате CRUD (*Create, Read, Update, Delete*).

---

## 🚀 **Запуск проекта**

### 🔹 **Сборка и запуск:**

```bash
./mvnw clean spring-boot:run
```

### 🔹 **Swagger UI:**

* Перейдите в браузере по адресу: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* Полная документация API с возможностью отправлять запросы прямо из интерфейса.

### 🔹 **H2 Console (Интерфейс для работы с базой данных):**

* Адрес: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
* **JDBC URL:** `jdbc:h2:file:./data/featurestore`
* **User Name:** `sa`
* **Password:** (пусто)

## 📌 **API Endpoints**

| **Метод** | **Endpoint**           | **Описание**                 |
| --------- | ---------------------- | ---------------------------- |
| `GET`     | `/api/features`        | Получение списка всех фич    |
| `GET`     | `/api/features/{id}`   | Получение фичи по ID         |
| `GET`     | `/api/features/search` | Поиск фичи по имени и версии |
| `POST`    | `/api/features`        | Создание новой фичи          |
| `PUT`     | `/api/features/{id}`   | Обновление существующей фичи |
| `DELETE`  | `/api/features/{id}`   | Удаление фичи по ID          |

---

## 🔄 **Миграции базы данных (Liquibase)**

Миграции базы данных управляются с помощью **Liquibase**.
Файл миграции: `src/main/resources/liquibase/changelog/001-init-schema.xml`.

Чтобы запустить миграцию вручную:

```bash
./mvnw liquibase:update
```

---

## 📝 **Примеры запросов**

### ➡️ **POST /api/features**

Создание новой фичи:

```json
{
  "name": "Feature A",
  "version": "1.0",
  "value": "Some value"
}
```

### ➡️ **PUT /api/features/1**

Обновление существующей фичи:

```json
{
  "name": "Updated Feature",
  "version": "1.1",
  "value": "New value"
}
```

### ➡️ **GET /api/features/search?name=Feature A\&version=1.0**

Поиск фичи по имени и версии.

---

## ⚠️ **Тестирование**

Запуск модульных тестов:

```bash
./mvnw test
```

---

## 🤝 **Контрибьюция**

1. Сделайте форк проекта.
2. Создайте новую ветку: `git checkout -b feature/my-feature`.
3. Внесите изменения и закоммитьте: `git commit -m 'Добавил новую фичу'`.
4. Запушьте в ветку: `git push origin feature/my-feature`.
5. Создайте Pull Request.

---

## 📌 **Дополнительно**

* Swagger UI предоставляет удобный интерфейс для тестирования API.
* Liquibase упрощает управление миграциями базы данных.
* H2 Console позволяет просматривать структуру и данные в базе.
* MapStruct обеспечивает удобное преобразование между моделями и DTO.

---

**🔥 Проект готов к расширению и доработкам!**
