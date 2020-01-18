# Spring Data JPA
This project gives a simple overview of the power and the simplicity of the Spring Data JPA.
Spring data JPA still requires a JPA implemetor (like Hibernate) but it reduces the boilerplate code that the developer has to write. 

For more details on the advantages of Spring data JPA, please refer to my blog here [Soumik's blog on Spring data JPA](https://msoumik78.github.io/java/2019/05/25/why-use-spring-data-jpa.html)


### Dependencies

* Java 8 should be installed and available in the system. JAVA_HOME environment variable should be set and pointing to the location of Java 8.
* Maven should be installed in the system and set in PATH.
* A database like MySQL should be installed and accessible in the system.
* Please go to the file **resources/META-INF/persistence.xml** and update the properties with details of the MySQL database.
* Also a table named **Customer** should be created in the database.

### Compiling

 `mvn clean compile `

### Running program

The below command runs the program            

`mvn exec:java -Dexec.mainClass="org.experiment.spring_data_jpa_without_springboot.CustomerTest" `

