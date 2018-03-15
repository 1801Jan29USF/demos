#First line is FROM what base image
FROM openjdk:8

#Copy file from our machine into the docker container
COPY discovery-service.jar discovery-service.jar

#Port this is just specifing what ports should be accessible
#the -p command while running the container to publish the port
EXPOSE 8761

#execute this line when instance is created form the image
#could also use ENTRYPOINT
CMD ["java", "-jar", "discovery-service.jar"]