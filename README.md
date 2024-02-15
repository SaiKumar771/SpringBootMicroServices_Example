"# SpringBootMicroServices_Example" 

I implemented micro-service based architecture in spring boot.I took employee-service and department-service where employee needs to communicate to department service.Here I used Gateway to get and post data from one port by using respected 'url's'.I register these services in eureka-server for maintence.I implemented circuitbreaker using resilience4J for FallBack issues.I implemented zipkin-server for tracing mechanism using java -jar file.I used config-server for configuring all service i.e employee-service,department-service,gateway-service.
