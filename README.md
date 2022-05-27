# Spring Boot multi-module application example  
This project shows how to get a request, send it to kafka , listen kafka and writes to db

**System requirements**  
- JDK 8      
- Maven 
- kafka server 
      
## How to build and run   

 *Without docker*:
 
 Build and generate the artifact file with the maven command `mvn clean package` and then run the maven spring boot plugin     
 `mvn spring-boot:run` (or the java command `java -jar <jar file location>`).  
   
The application will be accessible at [http:localhost:8080/api/v1/sendMessageToKafka](http:localhost:8080) (note that the configured application context path is /api).
