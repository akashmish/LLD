# Welcome to SuperStore !

This Java / Maven based LLD project is to demonstrate usage of both SQL and NoSQL databases in a single Spring Boot Application.

This README provides an overview of the **SuperStore**, including, technical considerations, and potential improvements.

<p align="center">
  <img src="https://i.gifer.com/BH4Z.gif" alt="animated" />
</p>

## Title

* [Requirements](#requirements)
* [How to run?](#how-to-run)
* [Java doc](#java-doc)
* [UML diagram](#uml-diagram)
* [About service & choices made](#about-service--choices-made)
* [Future improvements](#future-improvements)
* [Contact](#contact)

## Requirements

* Spring boot : version 3.2.0
* Maven : apache-maven-3.8.X
* Java : version 17

My configuration :

```
akasmish@akasmish-mac store % mvn --version
Apache Maven 3.9.6 (bc0240f3c744dd6b6ec2920b3cd08dcc295161ae)
Maven home: /opt/homebrew/Cellar/maven/3.9.6/libexec
Java version: 21.0.1, vendor: Homebrew, runtime: /opt/homebrew/Cellar/openjdk/21.0.1/libexec/openjdk.jdk/Contents/Home
Default locale: en_IN, platform encoding: UTF-8
OS name: "mac os x", version: "14.1.2", arch: "aarch64", family: "mac"
```
```
java version "17.0.8" 2023-07-18 LTS
Java(TM) SE Runtime Environment (build 17.0.8+9-LTS-211)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.8+9-LTS-211, mixed mode, sharing)
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
    Simple run StoreApplication main class
	```




## About Service & choices made

* Service uses **lombok** to get basic functionality in a cleaner way.
 
## Future Improvements

The project can be further improved in the following ways:

* Conduct thorough testing.
* Add security
* Add ErrorHandling
* Making code more modular. Breaking service functions into smaller units so that it is easy to test.
* Improving logging.
* Focus on making things rigid and complete before adding new functionality.

## Contact

For any questions or feedback, please contact Akash Mishra. Email: akash.mish97@gmail.com