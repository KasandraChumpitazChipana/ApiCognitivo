# API de Servicio Cognitivo en un proyecto spring boot con GorqCloud

Gracias alas Apis podremos tener un mejor servicio la cual ahora nos llevara a usarlo con Sping Boot.

## Introducción

Cómo aprovechar las APIs de Inteligencia Artificial de GorqCloud utilizando Postman. GorqCloud nos ofrece servicios avanzados en procesamiento de lenguaje natural, análisis de datos y aprendizaje automático.
Esta guía mostrará cómo configurar y utilizar el API en Postman, permitiéndote realizar solicitudes con el  HTTP, gestionar endpoints y comprender las respuestas del API de manera eficiente llevandolo tambein con Sping Boot.

## Usamos las siguientes herramientas:

 - [Posmant](https://www.postman.com/downloads/)
 - [GorqCloud](https://console.groq.com/keys)
 - [Intellij Idea](https://www.jetbrains.com/idea/download/?section=windows)
 - [Mongodb](https://www.mongodb.com/es)

## 1. Creación de nuestro GroqCloud:
 - Crearemos nuestra cuenta con el correo Institucional:
 ![image](https://github.com/user-attachments/assets/1bde04fc-7258-4caf-8010-6d03912ba129)
 - Ya creada nuestra cuenta, nos dirigimos a la sección de Documentación de GorqCloud, donde podremos encontrar toda la información referente al uso del API:
 ![image](https://github.com/user-attachments/assets/fab5515e-6d7e-440e-91cb-f75e49eec225)
 - GorqCloud ofrece diferentes opciones, para lo que realizaremos usaremos Chat:
 ![image](https://github.com/user-attachments/assets/e05818d3-a55f-49b9-95e0-55ee99111e9a)
 - Para poder usar el API, necesitarás una clave de uso personal. Esta se puede generar en la parte inferior de la documentación, donde GorqCloud te ofrece la opción de crear una nueva clave:
 ![image](https://github.com/user-attachments/assets/460ac3cc-c798-4e00-a3eb-7fbf765b1e60)
 - Crearemos una Nueva Clave:
![image](https://github.com/user-attachments/assets/667983ca-54d9-4bff-9ddb-ae47ecb5b9e9)
 - Una vez ya creada, esta nos dara una clave única tendremos que guardar esta clave ya que la necesitarás para configurarla en Postman:
 ![image](https://github.com/user-attachments/assets/39642307-a521-498b-9734-173b46b40225)

## 2. La coneccion con Mongodb:
Mongodb la usarems como nuestra base de datos donde se almacenaran odas neustras consultas que ejecutaremos en nuetsro Posmant.
 - Una vez descargada Mongodb:
![image](https://github.com/user-attachments/assets/37695268-e2fc-4000-b6eb-61af4f64b02d)
 - Daremos una inicializacion a mongo db por la terminal, ejecutando el siguiente comando:
  ```bash
  mongod
  ```
  ![image](https://github.com/user-attachments/assets/6548dc2a-d72d-40da-a828-587138c96e08)
 - Esta es la Creación que la usaremos como nuestra base de datos localmente.
![Captura de pantalla (220)](https://github.com/user-attachments/assets/d62525cc-2812-44bf-9d55-4bc16a5043fe)
## 3. Corremos nuestro proyecto de Sping Boot:
Una vez creada nuestra base de datos ene l portal de Mongodb, podremos conectarala en nuestro proyecto de Spirng Boot usando el localhost y puerto que nos da el mongodb al crearlo.

![Captura de pantalla (221)](https://github.com/user-attachments/assets/1c75401f-8afb-4809-ae24-4ab0ba1e5637)
## 4. Probamos en el Posmant:
- Realizaremos una pregunta en nuestro Posmant con un "POST" para crear la pegunta en nuestro body ingresando:
  ```bash
  {
    "query": "¿Cuál es la capital de Rusia?"
  }
  ```
 ![image](https://github.com/user-attachments/assets/a2f6752d-d7b2-45d9-a41b-80a834896fd8)
- Listaremos la base de datos
 ![image](https://github.com/user-attachments/assets/4104f299-aa34-4ecd-b0fe-37337ddb53e0)

## 5. Observar la platafroma de base de datos "Mongodb":
Aqui podremos Observar como nuestra pregunta realizada esta almacenada en nuetsro SpringBoot en MongoDB.

![image](https://github.com/user-attachments/assets/efc0ad7b-e24b-4dfa-8208-ec1db535e871)

## 6. Video de Logro de la Construccion de nuestro proyecto de Spring Boot con API:
Este Video Mostrara como logramos realizar todo nuestro funcionamiento.

[![youtube](https://img.shields.io/badge/youtube-FF0000?style=for-the-badge&logo=youtube&logoColor=white)](https://youtu.be/ndfrxTnuY34?si=dBjnMVbrpVct7EWG)

![image](https://github.com/user-attachments/assets/57d71e69-00b3-498d-83b2-782fdefee2db)
