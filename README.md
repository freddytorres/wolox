# Spring Boot - PostgreSql - Maven  [wolox]
Ejemplo de API Spring Rest CRUD con Maven que usa Spring Data JPA para interactuar con la base de datos PostgreSQL.
### Users
| Métodos | Url|Comportamiento |
| --- | --- | --- |
| GET | http://localhost:8080/users | show users |
| POST |http://localhost:8080/users| create users|
| PUT |http://localhost:8080/users/2| update users|
| DELETE |http://localhost:8080/users/3| delete users|

### Albums
| Métodos | Url|Comportamiento |
| --- | --- | --- |
| GET | http://localhost:8080/albums | show albums |
| POST |http://localhost:8080/albums| create albums|
| PUT |http://localhost:8080/albums/2| update albums|
| DELETE |http://localhost:8080/albums/3| delete albums|

### Photos
| Métodos | Url|Comportamiento |
| --- | --- | --- |
| GET | http://localhost:8080/photos | show photos |
| POST |http://localhost:8080/photos| create photos|
| PUT |http://localhost:8080/photos/2| update photos|
| DELETE |http://localhost:8080/photos/3| delete photos|

### Permits
| Métodos | Url|Comportamiento |
| --- | --- | --- |
| GET | http://localhost:8080/permits | show permits |
| GET | http://localhost:8080/permitsUsers/1 | show permits associates users |
| POST |http://localhost:8080/permits| create permits|
| PUT |http://localhost:8080/permits/2| update permits|
| DELETE |http://localhost:8080/permits/3| delete permits|

### Tecnología
- Java 8
- Spring Boot 2.2.1 (con Spring Web MVC, Spring Data JPA)
- PostgreSQL
- Maven 3.6.1

### Estructura del proyecto
![Latest Version on Packagist](https://github.com/freddytorres/wolox/blob/master/src/main/resources/imagenes/proyecto.png?raw=true)


## Test
La aplicación se encuentra publicada en HEROKU

### Añadir permiso
https://wolox.herokuapp.com/permits
```json
{
    "id": 1,
    "users":{"id": 1},
    "albums":{"id":1}
 }

```
![Latest Version on Packagist](https://github.com/freddytorres/wolox/blob/master/src/main/resources/imagenes/asignapermisousuario.png?raw=true)


### Álbum por usuario
https://wolox.herokuapp.com/permitsUsers/1

![Latest Version on Packagist](https://github.com/freddytorres/wolox/blob/master/src/main/resources/imagenes/permisousuario.png?raw=true)
## Autor
Ing. Freddy Rubén Torres T.

