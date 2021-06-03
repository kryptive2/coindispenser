How to compile and run the application

#Prerequisite
jdk >= 8
maven
terminal window/ cmd
browser for gui

#Compile and create and executatable JAR file from current directory with below command
    mvn clean install
        An executable jar is generated, usually located in ./target/*
        default should be ./target/coindispenser-0.0.1-SNAPSHOT.jar
        Hopefully everything went fine till this point

#Running the application
    Locate the compile jar.
    Run below command to execute the jar
    java -jar  <jar file>

#Testing the application
    Amount = 11
    Coins = 6, 5, 4, 3, 1
    Run below command for:
        To test least number of coins for amount given
            *command:  curl -X GET "http://localhost:8080/coinCounter?amount=11&coins=6&coins=5&coins=4&coins=3&coins=1"
            expected results: 2

        To test getting actual minimum coins for given amount and coins
            *command:  curl -X GET "http://localhost:8080/dispenseCoin?amount=11&coins=6&coins=5&coins=4&coins=3&coins=1"
            expected results: [5,6]

#GUI/ Front end
    Swagger UI, :)
    url : http://localhost:8080/swagger-ui/#/coin-dispenser-controller
    Refer to Screen short.