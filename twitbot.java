import twitter4j.Status; 
import twitter4j.Twitter; 
import twitter4j.TwitterException; 
import twitter4j.TwitterFactory;

public class twitbot{
// 무언가 잘못되면
// TwitterException을 확인합니다.
	public static void main(String[] args) throws TwitterException{

		// twitter4j.properties를 이용해 트위터 API에 접근합니다.
		Twitter twitter = TwitterFactory.getSingleton();

		// 트윗을 보냅니다.
		Status status = twitter.updateStatus("hello world1");

		//잘 보내졌으면 메시지를 하나 띄웁니다.
		System.out.println("Done.");
	} 
} 