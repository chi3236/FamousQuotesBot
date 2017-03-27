import java.util.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Datamanager{
    private JSONObject jsonObj;
    private JSONObject item;
    private JSONArray quotes;
    private int select;
    public Datamanager(){
        Readfile();
        setSelect();
        setItem();
    }
    private void Readfile(){
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader("Quotes.json"));
            jsonObj = (JSONObject)obj;
            quotes = (JSONArray)jsonObj.get("Quotes");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    public String getQuote(){
        return (String)item.get("Quote");
    }
    public String getSpeaker(){
        return (String)item.get("Speaker");
    }
    public String getFrom(){
        return (String)item.get("From");
    }
    
    public void setSelect(){
        Random random = new Random();
        select = random.nextInt(quotes.size());
    }
    
    public void setItem(){
        item = (JSONObject)quotes.get(select);
    }
    public int getSelect(){
        return select;
    }
}
