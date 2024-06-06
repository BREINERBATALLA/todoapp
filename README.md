# Descripción del Proyecto

Este es un proyecto de backend que implementa ciertos endpoints. Para acceder a estos endpoints, debes utilizar un cliente HTTP y apuntar a la URL base `http://ec2-34-207-93-122.compute-1.amazonaws.com:8080`. Asegúrate de consultar la documentación para obtener información detallada sobre los endpoints disponibles.

## Infraestructura en AWS

El backend de este proyecto está desplegado en Amazon Web Services (AWS):

- **Servidor EC2:** La infraestructura del backend está alojada en un servidor EC2 en AWS. Puedes acceder a la aplicación utilizando la URL base `http://ec2-34-207-93-122.compute-1.amazonaws.com:8080`.

- **Base de Datos MySQL en RDS:** La base de datos de este proyecto está alojada en Amazon RDS. Se utiliza MySQL como el motor de base de datos.

## Requisitos

- Cliente HTTP (por ejemplo, cURL, Postman)
- URL base: `http://ec2-34-207-93-122.compute-1.amazonaws.com:8080`

## Registro de Usuario

Para registrar un nuevo usuario, utiliza el siguiente endpoint:

- **Método:** POST
- **URL:** `http://ec2-34-207-93-122.compute-1.amazonaws.com:8080/api/linktic/v1/auth/register`
- **Cuerpo de la solicitud:** JSON con los datos del usuario a registrar (revisa doc/Documentación)

## Documentación de Endpoints
Puedes revisar en doc/ la collections de los api request en postman, para que puedas hacer las peticiones, recuerda la url base y los métodos http.
Para el registro y login Http:POST, ya que postman en las colecciones no los actualiza
Así mismo para acutualizar PUT, eliminar DELETE 
Puedes encontrar la documentación detallada de los endpoints en la carpeta `doc/` de este repositorio. La documentación incluye descripciones de los endpoints, sus parámetros y ejemplos de uso.

Por favor, consulta la documentación para obtener más información sobre cómo utilizar los endpoints disponibles.
