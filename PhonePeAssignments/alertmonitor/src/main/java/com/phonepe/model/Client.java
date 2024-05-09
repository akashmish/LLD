package com.phonepe.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phonepe.alertconfig.AlertConfigItem;
import com.phonepe.exceptions.IllegalConfigType;
import com.phonepe.exceptions.InvalidThresholdCountValue;
import com.phonepe.service.AlertService;

/*
 * code by Akash Mishra (akash.mish97@gmail.com)
 */
public class Client {
    String name;
    String configPath;
    List<AlertConfigItem> alertConfigItems;
    AlertService alertService;

    public Client(String name, String configPath,AlertService alertService) throws Exception{
        this.name = name;
        this.configPath = configPath;
        alertConfigItems = new ArrayList<>();
        setConfigItem();
        this.alertService=alertService;
    }

    void setConfigItem(){
        File file = new File(configPath);
        try {
            alertConfigItems = mapJsonToAlertConfigList(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static List<AlertConfigItem> mapJsonToAlertConfigList(File file) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, AlertConfigItem.class));
	}

    public void executeEvent(String alertType) throws IllegalConfigType,InvalidThresholdCountValue,RuntimeException {
        alertService.alertIfApplicable(alertType,alertConfigItems);
    }
    
}
