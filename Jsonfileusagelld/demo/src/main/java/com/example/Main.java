package com.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import netscape.javascript.JSObject;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        /* Method 1 
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("jsonfiles/emp.json");
        Object o = jsonParser.parse(reader);

        JSONObject empObj = (JSONObject)(o);
        String name = (String)empObj.get("firstname");
        String clas =(String)empObj.get("lstName");

        JSONArray array = (JSONArray)empObj.get("address");

        for(int i=0;i<array.size();i++){
            JSONObject ob = (JSONObject)array.get(i);
            String street=(String)ob.get("street");
            System.out.println(street);
        }
   */

//    Method 2
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("jsonfiles/emp.json");
        JSONObject empObj = (JSONObject)jsonParser.parse(reader);

        String name = (String)empObj.get("firstname");
        String clas =(String)empObj.get("lstName");

        JSONArray array = (JSONArray)empObj.get("address");

        for(int i=0;i<array.size();i++){
            JSONObject ob = (JSONObject)array.get(i);
            String street=(String)ob.get("street");
            System.out.println(street);
        }




    }   
}