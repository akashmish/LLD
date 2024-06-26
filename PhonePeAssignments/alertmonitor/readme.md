# Alert Monitor

## Problem Statement

Consider a microservice env where several systems use 1 central system for all their alert use cases: Design and implement a system which can capture events generated by any system or user triggered (for simplicity), and raise an alert according to alert configuration.


## Specification

Type of configurations:
```
SIMPLE_COUNT (which consists of count)
TUMBLING_WINDOW (which consists of count and windowSizeInSecs)
SLIDING_WINDOW (which consists of count and windowSizeInSecs)
```
● Alert will be dispatched if the config thresholds are met\
● You can design your own config.\
● You need to keep a placeholder for defining different dispatch mechanisms.\
● Simulate the dispatch of alerts by generating events in a main class / test case\


## Requirements
* Maven : apache-maven-3.8.X
* Java : version 21
* Jackson Core : version 2.13.3
* Junit : 5.9.1

## My configuration :
```
Apache Maven 3.9.6 (bc0240f3c744dd6b6ec2920b3cd08dcc295161ae)
Maven home: /opt/homebrew/Cellar/maven/3.9.6/libexec
Java version: 21.0.1, vendor: Homebrew
Default locale: en_IN, platform encoding: UTF-8
OS name: "mac os x", version: "14.3", arch: "aarch64", family: "mac"
```

## How to run?

1. Download the code, navigate to the directory where pom.xml is present
2. Install the required dependencies, generate doc, generate uml, run unit tests:  
	#### navigate to dir having *pom.xml* file and run
	```
	mvn clean install
	```
3. Once successfully built, you can do one of the two below options to run 
	```
   1. Simple run Alert Monitor's  main class which includes 8 manual test cases
   2. Run Junit present in /src/main/test

4. Make sure you run the code from directory where pom.xml is present otherwise it will throw exception

## Testing of code 

I have implemented 8 unique testcases for my personal testing which I exposed for the person assessing this assignment, these 8 testcases cover differnet part of program. Along which I have given the explanation of what I am doing in that test and what is expceted output.

I also have implemented basic JNUIT testcases.

## Assumptions made 

1. That one Event type has just one alertConfigType(e.g SLIDING_WINDOW OR TUMBLING_WINDOW)
2. The threshold message should be printed in the console for all requests that are being rejected
3. Each onboarding service/client will have its own alertConfigList defined for them. This is stored under /src/main/resources

## Design Patterns used
```
1. Strategy Design Pattern (for Dispatch of alerts)
2. Singleton (for creating db/storage class)
3. Builder (for creating object of different configurations like SLIDING_WINDOW OR TUMBLING_WINDOW)
```

## Approach

1. For each client I am reading their json config and mapping them to objects using jackson and storing them in classes defined under alertconfig module. 
2. For a client I am storing for each client and eventtype what specific configuration is he using. which I am storing in my db/hashmap (e.g "X:PAYMENT_EXCEPTION",TUMBLING_WINDOW  will be stored in db)
3. If the request is coming for the first time store it in db otherwise fetch the configuration client is using for this specific event and call its allow() function.
4. Allow function will return a true if request is within threshold otherwise return false
5. If false then for all dispatch modes i have to print messages. 
6. Each Client will have to call executeEvent(String alertType) method along with the event type it is triggering.

For any questions or feedback, please contact Akash Mishra. Email: akash.mish97@gmail.com