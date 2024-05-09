# Welcome to Trello !

This Java / Maven based LLD project is an application like Trello which is a project management application, where you can manage your project by tracking smaller tasks. For reference : https://trello.com/

![trell.png](trell.png)


## Title

* [Requirements](#requirements)
* [How to run?](#how-to-run)
* [About service & choices made](#about-service--choices-made)
* [Future improvements](#future-improvements)
* [Contact](#contact)

## Requirements

* Spring boot : version 3.2.0
* Maven : apache-maven-3.8.X
* Java : version 17

My configuration :

```
Apache Maven 3.8.6 (84538c9988a25aec085021c365c560670ad80f63)
Maven home: /usr/local/Cellar/maven/3.8.6/libexec
Java version: 21, vendor: XXXX, runtime: /Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home
Default locale: en_IN, platform encoding: UTF-8
OS name: "mac os x", version: "13.5.1", arch: "x86_64", family: "mac"
```
```
java version "21" 2023-09-19 LTS
Java(TM) SE Runtime Environment (build 21+35-LTS-2513)
Java HotSpot(TM) 64-Bit Server VM (build 21+35-LTS-2513, mixed mode, sharing)
```
## How to run?

1. Clone this repository
2. Install the required dependencies, generate doc, generate uml, run unit tests:  
	#### navigate to dir having *pom.xml* file and run
	```
	mvn clean install
	```
3. Once successfully built, you can run the service by one of these two methods:
	```
	mvn spring-boot:run 
    or
    Simple run  TrelloTest test
	```


## About Service & choices made

* Service uses **lombok** to get basic functionality in a cleaner way.

 
## Future Improvements

The project can be further improved in the following ways:

* Conduct thorough testing.
* Making code more modular. Breaking service functions into smaller units so that it is easy to test.
* Improving logging.
* Focus on making things rigid and complete before adding new functionality.
* Improve Exception Handling
* Adding more extensive logic

## Contact

For any questions or feedback, please contact Akash Mishra. Email: akash.mish97@gmail.com