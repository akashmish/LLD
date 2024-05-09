package com.phonepe.db;

import java.util.HashMap;
import java.util.Objects;

import com.phonepe.model.limiters.RateLimiter;

/*
 * code by Akash Mishra (akash.mish97@gmail.com)
 */
public class Storage {
    /*
     * This is a singleton class to manage Database/storage
     */
    private static HashMap<String,RateLimiter> rateLimiterMapInstance;

    private Storage(){
    }

        public static HashMap<String, RateLimiter> getClientRules() {
            synchronized(Storage.class){
                if (Objects.isNull(rateLimiterMapInstance)) {
                    rateLimiterMapInstance = new HashMap<>();
                }
            }
        return rateLimiterMapInstance;
    }


}
