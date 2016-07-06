#ChatClient in Java

[![Coverage Status](https://coveralls.io/repos/github/nickbdyer/chatClient/badge.svg)](https://coveralls.io/github/nickbdyer/chatClient) [![Build Status](https://travis-ci.org/nickbdyer/chatClient.svg?branch=master)](https://travis-ci.org/nickbdyer/chatClient)

###Clone

```shell
$ cd <folder where you want to store the project>

$ git clone https://github.com/nickbdyer/chatClient.git

$ cd chatClient/
```

This project has a Gradle Wrapper embedded, so you can run the project and tests without having Gradle on your path.

###Compile
```shell
$ ./gradlew build
```

###Run Program
With no defined input, this will default to `localhost 4444`.
```shell
$ java -jar build/libs/chatClient.jar <hostname> <port_number>
```

###Test Program
To see the results in the command line:
```shell
$ ./gradlew cleanTest test
```
Or in your browser:
```shell
$ open reports/tests/index.html
```