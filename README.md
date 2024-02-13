# AshutoshMishra_BED_Lab6
AshutoshMishra_BED_Lab6

# Student Management MVC

## Overview

This application provides endpoints for managing students within an Student management system based on roles, and users

## Endpoints

### Students

#### Retrieve all students

- **Method:** `GET`
- **Endpoint:** `/StudentManagement/student/list`
- **Description:** Returns a list of all students.

#### Add a new student

- **Method:** `POST`
- **Endpoint:** `/StudentManagement/student/showFormForAdd`
- **Description:** Creates a new student with the provided details.

#### Update an student

- **Method:** `POST`
- **Endpoint:** `/StudentManagement/student/showFormForAdd`
- **Description:** Updates the student with the specified ID with the provided details.

#### Delete an student 

- **Method:** `DELETE`
- **Endpoint:** `/StudentManagement/student/delete`
- **Description:** Deletes the student with the specified ID.

## Security

The API endpoints are secured using Spring Security with the following configuration:

- Certain endpoints such as login, logout, roles, and users are accessible without authentication.
- Access to student-related endpoints requires authentication with appropriate roles (ADMIN or USER).
- Cross-Origin Resource Sharing (CORS) and Cross-Site Request Forgery (CSRF) protection are disabled.
- Basic authentication and form-based login are enabled for authentication.
- Frame options are disabled to allow embedding the H2 Database Console in iframes.


