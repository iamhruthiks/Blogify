# 📁 Project Title: Blogify

## 💡 Overview

**Blogify** is a feature-rich blog platform built to empower users to create, manage, and explore blog posts seamlessly. With user authentication, intuitive post management, rich text editing, and a responsive UI, Blogify provides both authors and readers a smooth experience.

---

## ✨ Features

- **User Authentication**: Secure sign-up, login, and logout using Spring Security.
- **Blog CRUD Operations**: Create, Read, Update, and Delete blog posts with rich formatting.
- **Sorting & Pagination**: Sort blogs by creation and last updated time, and display them with pagination, including sorting by the number of blogs per page, for a better reading experience.
- **Profile Management**: Users can update their personal information, including uploading a profile picture.
- **Rich Text Editor**: Provides a better blog writing experience.
- **Email Integration**: Email functionality for resetting the password securely.
- **Responsive Design**: Fully optimized for all screen sizes using Bootstrap.
- **Form Validation**: Spring Boot validation used across forms for data integrity.
- **Date Formatting**: Displays post dates using `thymeleaf-extras-java8time`.
- **Developer-Friendly**: Uses Devtools for hot-reloading and a modular project structure.

---

## 🛠️ Tech Stack Used

- **Backend**: Spring Boot, Spring MVC, Spring Data JPA
- **Security**: Spring Security + Thymeleaf Extras
- **Templating Engine**: Thymeleaf
- **Database**: H2 Console (in-memory)
- **Frontend UI**: Bootstrap, Thymeleaf
- **Other Tools & Libraries**:
  - Lombok
  - Apache Commons Lang3
  - Spring Boot Validation
  - Spring Boot Mail
  - Maven

---

## 🚀 How to Run the Application

### Prerequisites

- Java 17 or later (Java 23 specified in pom.xml)
- Maven (v3.8+)

### **Open your terminal or command prompt.**

### Clone the Repository

```bash
git clone https://github.com/iamhruthiks/Blogify.git
```

### Email Configuration

The application uses Gmail SMTP to send password reset emails. To enable this functionality, you need to provide your Gmail credentials securely.

1. Create a secret.properties file inside the src/main/resources directory.
2. Add the following properties to the file:

```
spring.mail.username=your_gmail_address@gmail.com
spring.mail.password=your_gmail_app_password
```

_💡 Use an App Password if you're using a Google account with 2-Step Verification enabled. Do not use your actual Gmail login password._

### Navigate inside Blogify

```bash
cd Blogify
```

### Start the Application

```bash
./mvnw spring-boot:run
```

Or, if Maven is globally installed:

```bash
mvn spring-boot:run
```

### Access the Application

- App: `http://localhost:8080`
- H2 Console (Database): `http://localhost:8080/db-console`
  - Username: `admin`, Password: `password`

---

## 📁 Project Structure

- `com.example.blogify`
  - `controller`: Web endpoints
  - `service`: Business logic
  - `model`: JPA entities
  - `repository`: Spring Data interfaces
  - `config`: Seed data and Email config
  - `security`: Security setup and Application config

---

## 📦 Dependencies Used

- `spring-boot-starter-web`
- `spring-boot-starter-thymeleaf`
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-security`
- `spring-boot-starter-validation`
- `spring-boot-starter-mail`
- `thymeleaf-extras-springsecurity6`
- `thymeleaf-extras-java8time`
- `com.h2database:h2`
- `org.apache.commons:commons-lang3`
- `lombok`

---

## 📜 Acknowledgements

_This project was developed as one of my the **capstone projects** for the course **"FULL STACK JAVA DEV: JAVA + JSP + SPRING + BOOT + JS + REACT"**._

_I extend my heartfelt thanks to **Chand Sheikh** and the **StudyEasy Organization** for creating such a comprehensive and engaging learning experience. The course's practical, project-driven approach and clear explanations were instrumental in equipping me with the skills and confidence to bring this application to life. It has been a pivotal step in my journey to becoming a full-stack Java developer._

---

## 📷 Screenshots

<img width="959" alt="home" src="https://github.com/user-attachments/assets/0053c273-9432-46f7-9fd2-31937b29fe37"><hr>
<img width="959" alt="pagination" src="https://github.com/user-attachments/assets/52f21055-156d-43c4-91cc-b2d2730ca1cf"><hr>
<img width="959" alt="register" src="https://github.com/user-attachments/assets/d47ff8c8-38b0-4e41-a035-15ce88cf8976"><hr>
<img width="959" alt="login" src="https://github.com/user-attachments/assets/324efa06-a635-4368-83ad-201dfa600f69"><hr>
<img width="959" alt="profile" src="https://github.com/user-attachments/assets/64d21572-cd23-4f8b-b493-41b78eed792f"><hr>
<img width="959" alt="forgot-password" src="https://github.com/user-attachments/assets/6f522254-4200-4d6d-8ae8-0ca9fb79914a"><hr>
<img width="959" alt="reset-email" src="https://github.com/user-attachments/assets/4751193c-c1ba-4e58-a790-1dd950d0f485"><hr>
<img width="959" alt="email-message" src="https://github.com/user-attachments/assets/e8bcfd27-1f3d-4072-8c2e-ebe654ede2a0"><hr>
<img width="959" alt="change-password" src="https://github.com/user-attachments/assets/43bbd454-2901-490e-8e96-3a76748648ee"><hr>
<img width="959" alt="responsive-design-1" src="https://github.com/user-attachments/assets/c034b487-bc7a-461f-808a-2a5deae1c4bb"><hr>
<img width="959" alt="responsive-design-2" src="https://github.com/user-attachments/assets/e9ed88e8-490f-4949-ba0b-47537bb0fa93"><hr>
