# rpsgameservice
follow below instruction to install and run with Docker
  - Docker build command 
    docker build -t rpsgame/rps-rest-service-docker .
  - Docker run command
    docker run -p 8081:8081 rpsgame/rps-rest-service-docker
    
follow below instruction to run with Maven
  ./mvnw spring-boot:run
  
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
 
