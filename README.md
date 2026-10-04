# Placement Management System

A web-based **Placement Management System** developed using Spring Boot, MySQL, HTML, CSS, JavaScript, and Docker.

The system manages students, companies, placement drives, and student applications.

## Features

* Student management
* Company management
* Placement drive management
* Student application management
* JOIN query to display student applications with company information
* Subquery to find companies receiving applications above average
* Stored procedure to register a student for a placement drive
* Function to count applications by company
* Trigger to update student placement status
* REST APIs
* Web-based frontend
* Docker containerization

## Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL 8
* HTML, CSS, JavaScript
* Maven
* Docker
* Docker Compose

## Database

The project uses four main tables:

1. **STUDENTS** – Stores student details and placement status.
2. **COMPANIES** – Stores company details and job information.
3. **DRIVES** – Stores placement drive details.
4. **APPLICATIONS** – Stores student applications for placement drives.

## SQL Features

### JOIN

Displays student application details along with company information.

```sql
SELECT s.name,
       s.email,
       c.company_name,
       d.job_role,
       a.application_date,
       a.status
FROM applications a
JOIN students s ON a.student_id = s.student_id
JOIN drives d ON a.drive_id = d.drive_id
JOIN companies c ON d.company_id = c.company_id;
```

### Subquery

Finds companies receiving applications above the average number of applications.

### Stored Procedure

```sql
CALL register_student_for_drive(101, 201);
```

Registers a student for a placement drive.

### Function

```sql
SELECT count_applications_by_company(1);
```

Returns the number of applications received by a company.

### Trigger

When an application status becomes `SELECTED`, the student's placement status is automatically updated to `PLACED`.

## REST API

### Students

```text
GET    /api/students
POST   /api/students
GET    /api/students/{id}
PUT    /api/students/{id}
DELETE /api/students/{id}
```

### Companies

```text
GET    /api/companies
POST   /api/companies
GET    /api/companies/{id}
GET    /api/companies/above-average
GET    /api/companies/{id}/application-count
```

### Drives

```text
GET    /api/drives
POST   /api/drives
GET    /api/drives/{id}
```

### Applications

```text
GET  /api/applications
POST /api/applications
GET  /api/applications/student-company
GET  /api/applications/student/{studentId}
GET  /api/applications/company/{companyId}
POST /api/applications/register
```

## Frontend

The frontend is available through:

```text
http://localhost:8081
```

The frontend is located at:

```text
src/main/resources/static/index.html
```

## Docker

The application is containerized using Docker and Docker Compose.

Start the application:

```bash
docker compose up --build
```

Access the application:

```text
http://localhost:8081
```

Check containers:

```bash
docker ps
```

## Docker Hub

Docker image:

```text
loshnipm/placementmanagementsystem:latest
```

[Docker Hub Repository](https://hub.docker.com/r/loshnipm/placementmanagementsystem?utm_source=chatgpt.com)

## GitHub

[GitHub Repository](https://github.com/loshnipalani/PlacementManagementSystem?utm_source=chatgpt.com)

## Project Structure

```text
PlacementManagementSystem
├── src/main/java
│   └── com.example.placementmanagementsystem
│       ├── controller
│       ├── entity
│       ├── repository
│       └── service
│
├── src/main/resources
│   ├── application.properties
│   └── static
│       └── index.html
│
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

## Author

**Loshni P.M**

Department of Computer Science and Engineering
