import twitter4j.Status;
import twitter4j.Twitter; 
import twitter4j.TwitterException; 
import twitter4j.TwitterFactory;
import java.io.*;
import java.util.*;

public class twitbot{

    static private Datamanager dataManager;
	public static void main(String[] args){
        
        dataManager = new Datamanager();
   
        final long timeInterval = 3600000;
        Runnable runnable = new Runnable(){
            public void run(){
                while(true){
                    Twitter twitter = TwitterFactory.getSingleton();
                    dataManager.setSelect();
                    dataManager.setItem();
                    String mention = new String("\"" + dataManager.getQuote() + "\" - " + dataManager.getSpeaker()  + ", 「" + dataManager.getFrom() + "」中");
                    
                    try{
                        Status status = twitter.updateStatus(mention);
                    } catch(TwitterException e){
                        e.printStackTrace();
                    }
                    System.out.println("Done with quote " + dataManager.getSelect());
                    try{
                        Thread.sleep(timeInterval);
                    } catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
	}
} 
