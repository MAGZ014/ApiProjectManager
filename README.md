# ApiProjectManager

# Project Manager API

Una API RESTful basica para gestión de proyectos desarrollada con Spring Boot y autenticación JWT.


##  Características
-  Autenticación con JWT 
-  Gestión completa de usuarios y roles
-  CRUD para tareas con:
    - Prioridades (Alta, Media, Baja)
    - Estados (Pendiente, En progreso, Completada)
-  Validación de datos integrada

## Tecnologías
| Categoría       | Tecnologías                                                                 |
|-----------------|----------------------------------------------------------------------------|
| **Backend**     | Spring Boot 3.x, Spring Security                                           |
| **Base Datos**  | H2 (desarrollo), PostgreSQL (producción)                                   |
| **JWT**         | jjwt 0.12.6                                                                |
| **Herramientas**| Lombok, Spring Data JPA, Validation API                                    |

##  Estructura del Proyecto
```plaintext
com.projectmanager.projectmanager
├── config/       # Configuraciones
├── controller/   # Controladores REST
├── dto/          # Data Transfer Objects
├── exception/    # Manejo de errores
├── model/        # Entidades
├── repository/   # Repositorios JPA
├── security/     # Config JWT
└── service/      # Lógica de negocio