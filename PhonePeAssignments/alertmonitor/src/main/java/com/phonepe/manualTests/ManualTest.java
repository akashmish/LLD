package com.phonepe.manualTests;

import com.phonepe.exceptions.IllegalConfigType;
import com.phonepe.model.Client;
import com.phonepe.service.AlertService;


/*
 * code by Akash Mishra (akash.mish97@gmail.com)
 */
public class ManualTest {
    //have two client run paralelly
    private final Client clientX;
    private final Client clientY;
    private final Client clientTest;
    private final Client clientTestExcep;

    private final AlertService alertService;

    public ManualTest() throws Exception{
        this.alertService = new AlertService();
        this.clientX= new Client("X", "src/main/resources/clientjson/ClientX.json",alertService);
        this.clientY= new Client("Y", "src/main/resources/clientjson/ClientY.json",alertService);
        this.clientTest = new Client("Test", "src/main/resources/clientjson/ClientTest.json",alertService);
        this.clientTestExcep = new Client("Test", "src/main/resources/clientjson/ClientExceptionTest.json",alertService);
    }

    public void runManualTest1(){
        /*
        * I will run the loop for 12 seconds
        * MaxRequestAllowed = 10
        * windowSizeInSecs = 10
        * I am hitting 5 requests per second
        * that means after 2 seconds of startI should reach threshold and till next 8 seconds I will display rejected text
        * just after that for 2 seconds I will show allowed
        */
        Thread threadX_Payment = new Thread(()->{
            for (int i = 0; i <58; i++) {
                try {
                    clientX.executeEvent("PAYMENT_EXCEPTION");
                } catch (IllegalConfigType e) {
                    e.printStackTrace();
                }
                try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        });

        threadX_Payment.start();
    }

    public void runManualTest2(){
        /*
        * I will run the loop for 12 seconds
        * MaxRequestAllowed = 10
        * windowSizeInSecs = 10  sliding window
        * I am hitting 2 requests per second
        * that means after 5 seconds of start I should reach threshold and till next 5 seconds I will display rejected text
        * 
        * Result 
            in a span of 12 seconds It accepted initially 10 requests within 5 sec
            then rejected for next 5 second, 
            till now we passed 10 seconds so as we move ahead values from start will be removed
            this means we can accept one request
            which is true as for next 2 seconds it accpets 4 requests.
            PASSED
        */
        Thread threadX_Payment = new Thread(()->{
            for (int i = 0; i <24; i++) {
                try {
                    clientX.executeEvent("USERSERVICE_EXCEPTION");
                } catch (IllegalConfigType e) {
                    e.printStackTrace();
                }
                try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        });

        threadX_Payment.start();
    }

    public void runManualTest3(){
        /*
        * For Payment I will run loop for 13 seconds
        * MaxRequestAllowed = 10 Payment / Tumbling
        * windowSizeInSecs = 10  
          I am hitting 10 requests in 8 second (rate = 10/8 req per sec)
          EXPECTED:
                10 req allowed within ~8sec, the 3 are rejected 
                then 3 are allowed again
                total 13 requests

        * For UserService Thread I will run loop for 12 seconds
        * MaxRequestAllowed = 10 sliding window / UserService
        * windowSizeInSecs = 10  
        I am hitting 4 requests in 1 second 
            EXPECTED :
                threshold breached within 2.5 seconds
                should be breached for another 7.5 secs
                then 8 requests will be accpeted in next 2 seconds
                PASSED
         */

        Thread threadX_Payment = new Thread(()->{
            for (int i = 0; i <16; i++) {
                try {
                    clientX.executeEvent("PAYMENT_EXCEPTION");
                } catch (IllegalConfigType e) {
                    e.printStackTrace();
                }
                try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        });
        Thread threadX_UserService = new Thread(()->{
            for (int i = 0; i <48; i++) {
                try {
                    clientX.executeEvent("USERSERVICE_EXCEPTION");
                } catch (IllegalConfigType e) {
                     
                    e.printStackTrace();
                }
                try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        });

        threadX_Payment.start();
        threadX_UserService.start();
    }

    public void runManualTest4(){
        /*
        * For Payment I will run loop for 20 seconds
        * MaxRequestAllowed = 2 Payment / Tumbling
        * windowSizeInSecs = 10  
          I am hitting 1 requests in 1 second (rate = 1 req per sec)
          EXPECTED:
                2 requests will be full in 2 seconds
                for next 8 seconds we will breach threshold 8 times
                again after 10th seconds 2 request will be allowed
                again 8 request will reach thresshold
                total accept = 4
                total threahold reache = 16
                PASSED
        */

        Thread threadTest_Payment = new Thread(()->{
            for (int i = 0; i <20; i++) {
                try {
                    clientTest.executeEvent("PAYMENT_EXCEPTION");
                } catch (IllegalConfigType e) {
                    e.printStackTrace();
                }
                try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        });

        threadTest_Payment.start();
    }

    public void runManualTest5(){
        /*
        *
            Testing a new "eventType"
            "eventType": "AKASH_EXCEPTION",
            "alertConfig": {
                "type": "SLIDING_WINDOW",
                "count": 4,

             Expected: 
                4 accpet, 6 reject with AKASH_EXCEPTION excpetion
                PASSED
        */

        Thread threadTest_Payment = new Thread(()->{
            for (int i = 0; i <10; i++) {
                try {
                    clientTest.executeEvent("AKASH_EXCEPTION");
                } catch (IllegalConfigType e) {
                    e.printStackTrace();
                }
                try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        });

        threadTest_Payment.start();
    }

    public void runManualTest6(){
        /*
        *
            Testing a new Dispatch type
            {
                "type": "MOBILE",
                "message": "Akash will send this notification to mobile"
            }
        */
        Thread threadTest_Payment = new Thread(()->{
            for (int i = 0; i <10; i++) {
                try {
                    clientTest.executeEvent("AKASH_EXCEPTION");
                } catch (IllegalConfigType e) {
                     
                    e.printStackTrace();
                }
                try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        });

        threadTest_Payment.start();
    }

    public void runManualTest7(){
        /*
            Testing SIMPLE_COUNT 
            PASSED
        */
        Thread threadTest_Payment = new Thread(()->{
            for (int i = 0; i <10; i++) {
                try {
                    clientTest.executeEvent("AKASH_EXCEPTION");
                } catch (IllegalConfigType e) {
                    e.printStackTrace();
                }
                try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        });

        threadTest_Payment.start();
    }

    public void runManualTest8(){
        /*
            Testing Exception 
            PASSED
        */
        Thread threadTest_Payment = new Thread(()->{
            for (int i = 0; i <10; i++) {
                try {
                    clientTestExcep.executeEvent("PAYMENT_EXCEPTION");
                } catch (IllegalConfigType e) {
                    e.printStackTrace();
                }
                try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        });
        threadTest_Payment.start();
    }
}
