package com.phonepe.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import com.phonepe.alertconfig.AlertConfig;
import com.phonepe.alertconfig.AlertConfigItem;
import com.phonepe.db.Storage;
import com.phonepe.exceptions.IllegalConfigType;
import com.phonepe.exceptions.UnknownDispatchType;
import com.phonepe.model.limiters.RateLimiter;
import com.phonepe.model.limiters.SimpleCount;
import com.phonepe.model.limiters.SlidingWindow;
import com.phonepe.model.limiters.TumbleWindow;
import com.phonepe.model.limiters.builder.SimpleCountBuilder;
import com.phonepe.model.limiters.builder.SlidingWindonBuilder;

/*
 * code by Akash Mishra (akash.mish97@gmail.com)
 */
public class AlertService {

    private final HashMap<String,RateLimiter> rateLimiterMap= Storage.getClientRules();

    public void alertIfApplicable(String alertType, List<AlertConfigItem> alertConfigItems) throws IllegalConfigType {
    
        AlertConfig clientAlertConfig = null; 
        AlertConfigItem clientDetails = null;
        
        //check which eventType matches with given eventType
        for(var it: alertConfigItems){
           if( it.getEventType().equals(alertType)){
                clientAlertConfig = it.getAlertConfig();
                clientDetails=it;
           }
        }

        //based on above details insert into the hasmap and execute the requests
        InsertInMapAndCheck(clientAlertConfig, alertConfigItems,alertType ,clientDetails);
    }

        public void InsertInMapAndCheck(AlertConfig clientAlertConfig,List<AlertConfigItem> alertConfigItems,String alertType,AlertConfigItem clientDetails  ){
            if(clientAlertConfig.getType().equals("TUMBLING_WINDOW")){
                if(!rateLimiterMap.containsKey(alertConfigItems.get(0).getClient()+":"+alertType)){
                    //If this is first time calling the execute then put this value into hashmap/db
                    TumbleWindow tumbleWindow = new TumbleWindow(clientAlertConfig.getCount(), clientAlertConfig.getWindowSizeInSecs(), System.currentTimeMillis(),clientDetails.getClient(),clientDetails.getEventType());
                    rateLimiterMap.put(alertConfigItems.get(0).getClient()+":"+alertType,tumbleWindow);
                }
            }else if(clientAlertConfig.getType().equals("SIMPLE_COUNT")){
                if(!rateLimiterMap.containsKey(alertConfigItems.get(0).getClient()+":"+alertType)){
                    // SimpleCount simpleCount = new SimpleCount(3,client,exceptionType);
                    SimpleCount simpleCount = new SimpleCountBuilder()
                                                    .setLimit(clientAlertConfig.getCount())
                                                    .setClient(clientDetails.getClient())
                                                    .setExceptionType(clientDetails.getEventType())
                                                    .build();
                    rateLimiterMap.put(alertConfigItems.get(0).getClient()+":"+alertType,simpleCount);
                }
            }else if(clientAlertConfig.getType().equals("SLIDING_WINDOW")){
                if(!rateLimiterMap.containsKey(alertConfigItems.get(0).getClient()+":"+alertType)){
                    long bucketSize = clientAlertConfig.getCount();
                    long timeWindowInSeconds = clientAlertConfig.getWindowSizeInSecs();
                    // SlidingWindow slidingWindow = new SlidingWindow(bucketSize, timeWindowInSeconds,client,exceptionType);
                    SlidingWindow slidingWindow = new SlidingWindonBuilder()
                                                    .setBucketSize(bucketSize)
                                                    .setClient(clientDetails.getClient())
                                                    .setExceptionType(clientDetails.getEventType())
                                                    .setTimeWindowInSeconds(timeWindowInSeconds)
                                                    .build();
                    rateLimiterMap.put(alertConfigItems.get(0).getClient()+":"+alertType,slidingWindow);
                }
            }else{
                throw new RuntimeException("Please Enter a valid value for alertConfig type");
            }

            //otherwise we've seen it already then call the allow function on its rateLimiter
            boolean isWithinThreshold = rateLimiterMap.get(alertConfigItems.get(0).getClient()+":"+alertType).allow();
    
            //logic to check if threshold is reached
            verifyThreshold(isWithinThreshold,clientDetails);
        }

        public void verifyThreshold(boolean isWithinThreshold,AlertConfigItem clientDetails ){
            //if threshold reached throw alerts
            if(isWithinThreshold==false){
                System.out.println('\n'+"[INFO] MonitoringService: Client "+
                    clientDetails.getClient()+" "+clientDetails.getEventType()+
                    " threshold breached"+'\n');
                    clientDetails.getDispatchStrategyList()
                        .forEach(n ->
                            {
                                try {
                                    System.out.println(n.dispatch()+" at "+
                                        new Timestamp(System.currentTimeMillis())
                                        );
                                } catch (UnknownDispatchType e) {
                                    e.printStackTrace();
                                }
                            });
            }else{
                // allow the alerts
                System.out.println('\n'+"[INFO] Alert Accepted within threshold for "+ clientDetails.getClient()+
                            ", "+clientDetails.getEventType()+ " at "+
                         new Timestamp(System.currentTimeMillis())+'\n');
            }
        }
        
    
}
