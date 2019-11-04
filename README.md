## Deploy Spring Boot application in Google Kubernetes Engine (GKE)

## Steps to Deploying Spring Boot in Google Kubernetes Engine


## 1. Clone and Build and run application in local check everything is working
	git clone https://github.com/Anandsingh1011/spring-boot-kubernetes.git
	java -jar spring-boot-example-0.0.1-SNAPSHOT.jar
	
	
## 2. GO to Google cloud console and open cloud shell. 


## 3. Checkout application from cloud shell. Build and run application in cloud check everything is working.
	git clone https://github.com/Anandsingh1011/spring-boot-kubernetes.git
	java -jar spring-boot-example-0.0.1-SNAPSHOT.jar


## 4. Create a Kubernetes standard cluster of 3 nodes.Use Google cloud UI to create Kubernetes cluster.


## 5. In cloud shell application root directory run this command.
	./mvnw com.google.cloud.tools:jib-maven-plugin:build -Dimage=gcr.io/$GOOGLE_CLOUD_PROJECT/spring-boot-kubernetes:v1

	
	
## 6. Login to Kubernetes cluster
	gcloud auth login
	gcloud config set project <PROJECT_NAME>
	gcloud container clusters get-credentials <CLUSTER_NAME> --zone <ZONE_NAME> 
	
	
## 7. Check Kubernetes cluster status
	kubectl get pods
	kubectl get services
	kubectl get deployment
	
	
	
## 8.	Before deploying image to Kubernetes cluster Run Docket Image locally and check its working or not.
	docker run -ti --rm -p 8080:8080 gcr.io/$GOOGLE_CLOUD_PROJECT/spring-boot-kubernetes:v1
	
	
## 9. Deploy application to Kubernetes pod and it will be running
	kubectl run spring-boot-rest --image=gcr.io/$GOOGLE_CLOUD_PROJECT/spring-boot-kubernetes:v1 --port=8080
	
	
## 10. Check status of deployment

	kubectl get pods
	kubectl get deployment
	
	Still we do not have any services running , you can check it

	kubectl get services

## 11. To access this deployment we need a load balancer service, let create a new service
	
	kubectl expose deployment spring-boot-rest --type=LoadBalancer
	
11. Run below command and get external IP address. Using this and port number you can access you application 
	kubectl get services
	
	http://<EXTERNAL_TP>:8080/hello/status
	
12. Now we can scale application to run many instance it will create many replicas of application 
	kubectl scale deployment spring-boot-rest --replicas=3
	
	
	http://<EXTERNAL_TP>:8080/hello/status
	
	
	
