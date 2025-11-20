Available Endpoints with Full URLs

Public Endpoints (No authentication required)
GET http://localhost:8080/ - Home page, redirects to /login
GET http://localhost:8080/login - Login page
GET http://localhost:8080/register - Registration page (shows registration form)

POST http://localhost:8080/register - Register new user (form submission)

Protected Endpoints (Authentication required)
GET http://localhost:8080/main - Main dashboard page (accessible after login)

Security Endpoints (Configured in SecurityConfig)
POST http://localhost:8080/login - Login form submission (Spring Security handles this)

POST http://localhost:8080/logout - Logout (redirects to /login?logout)

Static Resources (Public)
http://localhost:8080/css/** - CSS files (e.g., http://localhost:8080/css/style.css)

http://localhost:8080/js/** - JavaScript files (e.g., http://localhost:8080/js/script.js)

H2 Console (Development only)
GET http://localhost:8080/h2-console - H2 database console (when enabled in properties)

Note: Port is configured as 8080 in application.properties. Change server.port to use a different port.