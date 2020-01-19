# Jetty server monitoring (using Prometheus) 

This is a very simple which gives an  overview of how HTTP requests to a simple Jetty based web server can be monitored using Prometheus. This project will be enhanced shortly with below features:
* Adding Grafana dashboards
* Load testing different REST endpoints using Gatling 

For starters - Prometheus is a time series database which also serves as a real time monitoring and alerting tool which scrapes endpoints to find out details. In this example - we have a simple endpoint and as soon as that is hit, a counter is increased in Prometheus. This is how we can monitor the load on any endpoint. 

### Dependencies

* Java 8 should be installed and available in the system. JAVA_HOME environment variable should be set and pointing to the location of Java 8.
* Maven should be installed in the system and set in PATH.
* Prometheus should be installed in the system.
 

### Compiling

 `mvn clean compile `

### Starting prometheus

Assuming prometheus is already installed in the system, start it using the below command:
`prometheus.exe --config.file prometheus_jetty.yml`

Content of the above yml file is as below:
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


### Testing with Prometheus

Once the above command runs, it starts a Jetty based web server at port 8082. You can then reach the endpoint : http://localhost:8082/.
When you hit the endpoint - a greeting message is displayed and a prometheus counter named 'test_prometheus_count1' is incremented.

Now open the Prometheus at this URL: http://localhost:9090/
and search for the counter named 'test_prometheus_count1' in the textbox at top left. Once selected - hit the 'Execute' button. And then you can choose to see the outputs either in Console or in Graphical mode.
