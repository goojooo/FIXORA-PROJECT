# Fixora — Local Service Booking Platform

Fixora is a full-stack service booking platform that connects customers with local service providers.

The application allows users to discover services, view service providers, book available services, make payments, and manage their bookings. Service providers can register and manage booking requests, while administrators can manage and approve service providers.

---

## 🚀 Project Overview

### Problem

Finding and booking reliable local service providers can be difficult because customers often need to search through multiple sources, contact providers individually, and manually coordinate service availability.

### Solution

Fixora provides a centralized platform where:

- Customers can register and log in.
- Customers can browse available services.
- Customers can view service providers.
- Customers can select a date/time and create bookings.
- Customers can make online payments.
- Customers can view their booking history.
- Service providers can register and wait for admin approval.
- Approved providers can log in and manage booking requests.
- Administrators can manage service providers and platform operations.

---

## ✨ Key Features

### Customer

- User registration and login
- Browse available services
- View service provider profiles
- Select booking date and time
- Create service bookings
- Online payment integration using Razorpay
- Payment verification
- View booking history
- Submit reviews
- Submit complaints

### Service Provider

- Provider registration
- Admin approval workflow
- Provider login
- Provider dashboard
- View booking requests
- Manage service requests
- Provider profile management

### Admin

- Admin authentication
- Admin dashboard
- Service provider approval
- Manage platform data
- Monitor users, providers and bookings

---

## 🛠️ Technology Stack

### Frontend

- React
- JavaScript
- HTML
- CSS
- Bootstrap / CSS-based UI

### Backend

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- REST APIs

### Database

- MySQL

### Payment

- Razorpay Test API

### Tools

- Eclipse / Java IDE
- Maven
- Postman
- Git & GitHub

---

## 🏗️ Application Architecture

```text
                ┌─────────────────────┐
                │     React UI        │
                │   HTML / CSS / JS   │
                └──────────┬──────────┘
                           │
                           │ HTTP / REST
                           ▼
                ┌─────────────────────┐
                │ Spring Boot Backend │
                │                     │
                │   Controllers       │
                │        ↓            │
                │   Services          │
                │        ↓            │
                │   Repositories      │
                └──────────┬──────────┘
                           │
                           │ JPA / Hibernate
                           ▼
                ┌─────────────────────┐
                │       MySQL         │
                └─────────────────────┘

                           │
                           ▼
                ┌─────────────────────┐
                │      Razorpay       │
                │   Payment Gateway   │
                └─────────────────────┘


📂 Project Structure
src/
├── main/
│   ├── java/com/localservice/
│   │
│   ├── config/
│   │
│   ├── controller/
│   │   ├── AdminAuthController.java
│   │   ├── AdminController.java
│   │   ├── AuthController.java
│   │   ├── BookingController.java
│   │   ├── ComplaintController.java
│   │   ├── PaymentController.java
│   │   ├── ReviewController.java
│   │   ├── ServiceController.java
│   │   ├── ServicePartnerController.java
│   │   └── UserController.java
│   │
│   ├── model/
│   │   ├── User.java
│   │   ├── Booking.java
│   │   ├── ServicePartner.java
│   │   ├── ServiceRequest.java
│   │   ├── Review.java
│   │   └── Complaint.java
│   │
│   ├── repository/
│   │   ├── UserRepository.java
│   │   ├── BookingRepository.java
│   │   ├── ServicePartnerRepository.java
│   │   └── ...
│   │
│   ├── service/
│   │   ├── UserService.java
│   │   ├── BookingService.java
│   │   ├── ServicePartnerService.java
│   │   └── AdminService.java
│   │
│   └── LocalServicePlatformApplication.java
│
├── resources/
│   ├── static/
│   │   └── React frontend build
│   │
│   ├── templates/
│   │   └── application pages/templates
│   │
│   └── application.properties
│
└── test/
    └── LocalServicePlatformApplicationTests.java

🔄 Main Application Flow
Customer Booking Flow

Register / Login
       ↓
Browse Services
       ↓
Select Service Provider
       ↓
Select Date & Time
       ↓
Create Booking
       ↓
Create Razorpay Order
       ↓
Complete Payment
       ↓
Verify Payment
       ↓
Booking Confirmed
       ↓
View Booking History

Service Provider Flow
Provider Registration
       ↓
Waiting for Admin Approval
       ↓
Admin Approval
       ↓
Provider Login
       ↓
Provider Dashboard
       ↓
View Booking Requests
       ↓
Manage Service Requests

Admin Flow
Admin Login
     ↓
Admin Dashboard
     ↓
View Provider Requests
     ↓
Approve / Manage Providers
     ↓
Platform Management

💳 Payment Integration

Fixora integrates Razorpay for online payment processing.

The payment flow is:

Booking
   ↓
Create Razorpay Order
   ↓
Razorpay Checkout
   ↓
Payment
   ↓
Payment Signature
   ↓
Backend Verification
   ↓
Booking Payment Status = PAID

Razorpay credentials are loaded through environment variables rather than being hard-coded into the Java payment controller.

The relevant implementation is:

PaymentController.java

Important endpoints include:

POST /payment/create-order/{bookingId}

POST /payment/verify
🔐 Configuration

Before running the application, configure:

MySQL
Database name
Database username/password
Razorpay test credentials

Razorpay credentials are expected through environment variables:

RAZORPAY_KEY_ID
RAZORPAY_KEY_SECRET

Do not commit real API secrets, production credentials, or private keys to the repository.

▶️ How to Run the Project
Prerequisites

Install:

Java 17
MySQL
Eclipse or another Java IDE
Git

Maven Wrapper files are included in the repository.

1. Clone the repository
git clone https://github.com/goojooo/FIXORA-PROJECT.git

Then open the project in Eclipse/IDE.

2. Configure MySQL

Create the required MySQL database according to the database configuration in:

src/main/resources/application.properties
3. Configure environment variables

Configure the following environment variables in the IDE/run configuration:

RAZORPAY_KEY_ID
RAZORPAY_KEY_SECRET

Use Razorpay test credentials for local testing.

4. Run the Spring Boot application

Run:

LocalServicePlatformApplication.java

The application runs on:

http://localhost:7070/
📌 Important: Frontend Setup

The React frontend has already been built and included inside the Spring Boot application's:

src/main/resources/static/

Therefore, a reviewer does not need Node.js or npm just to run the submitted application.

The application can be started from the Spring Boot project after configuring MySQL and the required environment variables.

🔍 How to Review the Code

If you are reviewing this project, the recommended starting points are:

1. Main Application
LocalServicePlatformApplication.java
2. Controllers

Start with:

BookingController.java
PaymentController.java
ServiceController.java
ServicePartnerController.java
UserController.java
AdminController.java

These demonstrate how HTTP requests are handled.

3. Business Logic

Check:

service/

The service layer contains application/business logic between controllers and repositories.

4. Database Layer

Check:

repository/

These interfaces use Spring Data JPA for database operations.

5. Entities / Models

Check:

model/

These classes represent the application's main domain objects such as:

User
Booking
ServicePartner
ServiceRequest
Review
Complaint
6. Payment Integration

Check:

PaymentController.java

This demonstrates:

Razorpay order creation
Payment response handling
HMAC-SHA256 signature verification
Updating booking payment status
🧪 Testing the APIs

Postman can be used to test the backend REST APIs.

Example areas to test:

Authentication
Users
Services
Bookings
Service Providers
Payments
Reviews
Complaints

The frontend can also be used to test the complete user flow.

👨‍💻 What This Project Demonstrates

This project demonstrates practical experience with:

Java 17
Spring Boot
REST API development
Spring Data JPA
Hibernate
MySQL
Layered architecture
CRUD operations
Authentication and authorization concepts
Payment gateway integration
Database relationships
Exception handling
Frontend/backend integration
Git and GitHub
API testing using Postman
📈 Future Improvements

Possible improvements include:

JWT-based authentication and refresh tokens
Role-based authorization improvements
Better validation and exception handling
Automated unit and integration testing
Improved payment transaction management
Provider availability management
Notification system
Production deployment
Docker-based deployment
Cloud database integration
Improved security configuration
👤 Developer

Nayan Dahare

B.Tech — Information Technology

Interested in:

Java
Spring Boot
Full-Stack Development
REST APIs
MySQL
Software Development
📄 Repository

GitHub:

https://github.com/goojooo/FIXORA-PROJECT
