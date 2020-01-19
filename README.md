# Jetty server monitoring (using Prometheus) 
This project gives a simple overview of how HTTP requests to a simple Jetty based web server can be monitored using Prometheus.  



### Dependencies

* Java 8 should be installed and available in the system. JAVA_HOME environment variable should be set and pointing to the location of Java 8.
* Maven should be installed in the system and set in PATH.
* Prometheus should be installed in the system.
* Also Grafana should be installed in the system  

### Compiling

 `mvn clean compile `

### Running program

The below command runs the program            

`mvn exec:java -Dexec.mainClass="prometheus_java.JettyBasedServer" `

