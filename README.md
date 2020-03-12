# full-stack-credit-card-managment-web-application
This is a full-stack Web Application for managing a Credit Card System.

## Technologies

Front-end:
- Javascript (EcmaScript 6)
- React
- Ajax Jquery
- CSS

Back-end:
- Java 8
- Spring Boot (DI, MVC, JdbcTemplate)
- H2 in-memory Database
- Junit
- Maven

## Getting started

To get the Front-end App running locally:

- Clone the repo
- `npm install` to install all required dependencies
- `npm start` to start the local server 

This project uses create-react-app.
The Application should run on `http://localhost:3000/`.

To get the Back-end App running locally:

- Clone/Download the Java Spring/Maven project
- You can import the project on your favorite IDE.
   - On Eclipse: File -> Import -> Existing Maven Project
   - Right Click on the directory and Run as Java Application
- Another option is to create an executable jar.
  - On CMD/Terminal: java -jar path/backend-credit-card-system-marco-furone-publicis-sapient/target/backend-credit-card-system-marco-furone-publicis-sapient-0.0.1-SNAPSHOT.jar

Java Application should run on `http://localhost:8080/`.

## Functionality overview

This application allows to perform Create/Read operations.

Users can add new Credit Cards in the System and each credit card has 3 attributes: User Name, Card Number, withdrawal Limit.
The User will be able to the added credit cards as a list in a table.

The Application allows to insert 16 to 19 digit card numbers, and also allows users to write such numbers in full or by writing the digits separated by spaces or dashes. It will be then the App to elaborate and format the card's numbers.
All the Card Numbers must work against the Luhn 10 algorithm, otherwise validation errors will displayed.

## Technology overview

Spring MVC has ben used to expose Rest Web Services (POST and GET in these case).
All the data are stored into H2, which is an in-memory Database.
React was used to create a dynamic UI.
Ajax JQuery to handle the REST requests from front-end to back-end.
