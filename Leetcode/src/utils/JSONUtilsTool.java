package utils;

import jdk.nashorn.internal.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
public class JSONUtilsTool {

    public Map<String,Object> getJSONMap(String path){
        Map<String,Object> map = new HashMap<>();
        try{
            FileReader fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return map;
    }
}
