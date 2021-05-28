# rpsgameservice
Below instruction descript how to run with Maven (mvnw)

  linux/unix:  ./mvnw spring-boot:run
  Windows: mvnw.cmd spring-boot:run
  
Below instruction descript how to package and run with Maven (mvnw)

  linux/unix:  ./mvnw package && java -jar target/rps-rest-service-docker-0.0.1.jar
  Windows: mvnw.cmd package && java -jar target\rps-rest-service-docker-0.0.1.jar
  

follow below instruction to in order to install and run with Docker, assuming you have local Docker container
  - Docker build command 
    docker build -t rpsgame/rps-rest-service-docker .
  - Docker run command
    docker run -p 8081:8081 rpsgame/rps-rest-service-docker
    
  
there are four REST APIs built in this application,
1 initialize player data. The initial player data contains two users as below, 
  username: user1 password pass1
  username: user2 password pass2
  
  Endpoint URL: http://localhost:8081
  
2 list all players
  Endpoint URL: http://localhost:8081/players
  
3 Playing Game
  Endpoint URL: http://localhost:8081/game?playerChoice=Rock
            or  http://localhost:8081/game?playerChoice=Paper
            or  http://localhost:8081/game?playerChoice=Scissor
  Basic Authentication required for this service, user and credential are referred above step 1
 
4 List Games by User
  Endpoint URL: http://localhost:8081/games
  Basic Authentication required for this service, user and credential are referred above step 1
 
