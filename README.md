# Jetty server monitoring (using Prometheus) 
This project gives a simple overview of how HTTP requests to a simple Jetty based web server can be monitored using Prometheus.  



### Dependencies

* Java 8 should be installed and available in the system. JAVA_HOME environment variable should be set and pointing to the location of Java 8.
* Maven should be installed in the system and set in PATH.
* Prometheus should be installed in the system.
 

### Compiling

 `mvn clean compile `

### Starting prometheus

Assuming prometheus is already installed in the system, start it using the below command:
`prometheus.exe --config.file prometheus_jetty.yml`

Content of the yml file is as below:
```
     global:
       scrape_interval:     5s # Set the scrape interval to every 15 seconds. Default is every 1 minute.
       evaluation_interval: 5s # Evaluate rules every 15 seconds. The default is every 1 minute.

     alerting:
       alertmanagers:
       - static_configs:
         - targets:

     rule_files:

     scrape_configs:
       - job_name: 'prometheus'
         static_configs:
         - targets: ['localhost:8082']
```

### Running program

The below command runs the program            

`mvn exec:java -Dexec.mainClass="prometheus_java.JettyBasedServer" `

