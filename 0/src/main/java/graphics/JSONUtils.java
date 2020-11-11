package graphics;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

public class JSONUtils {
    static String json = "{\"column 0\":{ \"row 0\": { \"square 0\":\"square0\", \"square 1\":\"square1\", \"square 2\":\"square2\"}, \"row 1\": { \"square 0\":\"square0\", \"square 1\":\"square1\", \"square 2\":\"square2\" }, \"row 2\": { \"square 0\":\"square0\", \"square 1\":\"square1\", \"square 2\":\"square2\" }},\"column 1\":{ \"row 0\": { \"square 0\":\"square0\", \"square 1\":\"square1\", \"square 2\":\"square2\" }, \"row 1\": { \"square 0\":\"square0\", \"square 1\":\"square1\", \"square 2\":\"square2\" }, \"row 2\": { \"square 0\":\"square0\", \"square 1\":\"square1\", \"square 2\":\"square2\" }},\"column 2\":{ \"row 0\": { \"square 0\":\"square0\", \"square 1\":\"square1\", \"square 2\":\"square2\" }, \"row 1\": { \"square 0\":\"square0\", \"square 1\":\"square1\", \"square 2\":\"square2\" }, \"row 2\": { \"square 0\":\"square0\", \"square 1\":\"square1\", \"square 2\":\"square2\" }  }}";
    static String testJSON = "{\"hello\":\"world\"}";
    static JSONParser parser = new JSONParser();

    public JSONUtils(Object layout) {
    }

    public static void main(String[] args) {
            Object obj = getJSONObject(json);
            //System.out.println(obj);
            String[] keys = {"column 0", "row 0", "square 1"};
            System.out.println(getFromJSON(obj, keys));
        
    }
    public static Object getJSONObject(String json){
        try {
            return parser.parse(json);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    static Object getFromJSON(Object jsonObject, String[] keyArray){
        JSONObject obj = (JSONObject)jsonObject;
        for (String key : keyArray) {
            try{
                obj = (JSONObject)(obj.get(key));
            }catch(Exception e) {
                return obj.get(key);
            }
        }
        return obj;
    }
    static JSONObject getFromJSON(Object jsonObject, String key){
        try {
            return (JSONObject)(((JSONObject)jsonObject).get(key));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}