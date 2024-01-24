# Translator AI Application

This Spring Boot application provides endpoints for AI-assisted language processing, including spelling and grammar correction and text translation. It utilizes the services provided by `CorrectorService` and `TranslatorService` to interact with an AI assistant.

## Table of Contents
- [Installation](#installation)
- [Launching the Application locally](#launching-the-application)
- [Endpoints](#endpoints)
    - [Corrector Endpoint](#corrector-endpoint)
    - [Translator Endpoint](#translator-endpoint)
    - [Health Check Endpoint](#health-check-endpoint)

## Installation

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/miharyjoe/translator-ai-api
    ```
2. Go to the file :
      ```bash
   cd translator-ai-api
   ```
3. Compile to jar the application:   
      ```bash
      mvn clean install
   ```
4. Launch the application:
      ```bash
      java -jar target/springai-0.0.1-SNAPSHOT.jar
   ```

 ## Endpoints
#### This is the URL of the application:
    ```bash
    https://translator-corrector-ai.onrender.com
    ```
#### To do the translation:
    ```bash
    GET https://translator-corrector-ai.onrender.com/ai/translator?translate=french
    ```
* Endpoint: /ai/translator
* Method: GET
###### Parameters:
* in request param: translate (required): The target language into which the text should be translated.
* in request body: sentences (required): The sentences to be translated into the specified language.


#### To do the Corrector:
    ```bash
    GET https://translator-corrector-ai.onrender.com/ai/corrector?language=english
    ```

* Endpoint: /ai/corrector
* Method: GET
###### Parameters:
* In request param: language (required): The language in which the correction response should be provided. (Default value: "english" if not specified)
* in request body: sentences (required): The sentences containing spelling and grammar mistakes to be corrected.

#### Health Check Endpoint
* Endpoint: /ping

* Method: GET

* Description: A simple health check endpoint that returns "pong" to indicate that the application is running.