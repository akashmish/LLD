package com.phonepe.model.limiters;

import java.sql.Timestamp;

public class TumbleWindow implements RateLimiter{
    private long requestsAllowed;
    private final long windowSize;
    private long windowStartTime;
    private long maxCapacity;
    private final String client;
    private final String exceptionType;

    public TumbleWindow(long limit, long windowSizeInSecs, long windowStartTime,String client,String exceptionType) {
        this.requestsAllowed = limit;
        this.windowSize = windowSizeInSecs*1000;
        this.windowStartTime = windowStartTime;
        this.maxCapacity = limit;
        this.client = client;
        this.exceptionType = exceptionType;
        printHeader(client,exceptionType);
    }

    @Override
    public synchronized boolean allow() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - windowStartTime > windowSize) {
          // Reset counter if window has passed
          System.out.println('\n'+"[INFO] MonitoringService: Client "+client+
                " "+ exceptionType+ " TUMBLING_WINDOW ends "+
                new Timestamp(System.currentTimeMillis()
                +'\n'));

          windowStartTime = windowStartTime+windowSize;
          this.requestsAllowed = maxCapacity-1;
          System.out.println("[INFO] MonitoringService: Client "+client+
                " "+ exceptionType+ " TUMBLING_WINDOW starts "+
                 new Timestamp(System.currentTimeMillis()
                 +'\n'));                 
          return true;
        }
        
        return (currentTime - windowStartTime) < windowSize && --requestsAllowed >= 0;
      }

      private void printHeader(String client, String exceptionType) {
        System.out.println('\n'+"[INFO] MonitoringService: Client "+
                  client+" "+ exceptionType + " TUMBLING_WINDOW "
                  +" starts at "+
                  new Timestamp(System.currentTimeMillis())+'\n'
          ); 
      }
  
}
