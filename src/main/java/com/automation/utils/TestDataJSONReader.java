package com.automation.utils;

import com.automation.stepDefinitions.Hooks;
import org.json.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TestDataJSONReader {

    public static  List<HashMap<String,String>> readJsonArray(String requestKey){
        List<HashMap<String,String>> mydata = new ArrayList<>();
        JSONArray arr = Hooks.testDataJsonObject.getJSONArray(requestKey);
        for (int i = 0; i < arr.length(); i++) {
            JSONObject jObject = arr.getJSONObject(i);
            HashMap<String,String> currentHash = new HashMap<String,String>();
            Iterator iter = jObject.keys();
            while(iter.hasNext()){
                String key = (String)iter.next();
                String value = jObject.getString(key);
                currentHash.put(key,value);
            }
            mydata.add(currentHash);
        }
        return mydata;
    }

    public static HashMap<String,String> readJsonObject(String requestKey) {
        JSONObject jObject = Hooks.testDataJsonObject.getJSONObject(requestKey);
        HashMap<String,String> currentHash = new HashMap<String,String>();
        Iterator iter = jObject.keys();
        while(iter.hasNext()){
            String key = (String)iter.next();
            String value = jObject.getString(key);
            currentHash.put(key,value);
        }
        return currentHash;
    }
}
