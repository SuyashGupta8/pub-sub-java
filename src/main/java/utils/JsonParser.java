package utils;


import com.google.appengine.repackaged.com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

/**
 * @author Crunchify.com
 * How to Read JSON Object From File in Java?
 */

public class JsonParser {

    public static void main(String[] args) {


    }

    public static Configurations getConfigurations(){

        Configurations configurations = new Configurations();

        String filePath = new File("").getAbsolutePath();
        JSONParser parser = new JSONParser();


        try(FileReader fr = new FileReader(filePath+ "/src/main/resources/pubsub.json")) {

            Object obj = parser.parse(fr);
            JSONObject jsonObject = (JSONObject) obj;

            configurations.setProjectId((String) jsonObject.get("projetcId"));
            configurations.setTopic((String) jsonObject.get("topic"));

            System.out.print("JSON parsed data is "+  configurations.getTopic() + " project id: " + configurations.getProjectId());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return configurations;
    }

    public static String toJson(Object obj){
        return new Gson().toJson(obj);
    }
}