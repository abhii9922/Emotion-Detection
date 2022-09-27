package Standalone;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.paralleldots.paralleldots.App;

import db.DAOQuires;

public class Emotion {
public static void main(String a[]) throws Exception{
	//public void setEmotions(String imagelocation) throws Exception{
		App pd = new App("vHm3xRnZ6d9DjpG2dj7xZcZxwy3cll1LpiMU2C0VaJs");
		
	//String facial_emotion ="{\"facial_emotion\":[{\"tag\":\"Neutral\",\"score\":0.4819515646},{\"tag\":\"Happy\",\"score\":0.1474868059},{\"tag\":\"Sad\",\"score\":0.0889687464},{\"tag\":\"Angry\",\"score\":0.0738124475},{\"tag\":\"Surprise\",\"score\":0.0692601278},{\"tag\":\"Fear\",\"score\":0.0692601278},{\"tag\":\"Disgust\",\"score\":0.0692601278}]}";
		//facial_emotion = facial_emotion.replace("{\"facial_emotion\":", "");
		//facial_emotion = facial_emotion.substring(0,facial_emotion.length()-1);
		//facial_emotion = facial_emotion.substring(1,facial_emotion.length()-2);
		
		
		String facial_emotion = pd.facial_emotion("D:\\image.png");
		System.out.println(facial_emotion);
		//String facial_emotion = pd.facial_emotion_url("https://image.shutterstock.com/image-photo/close-beauty-portrait-laughing-beautiful-600w-763618693.jpg");
		//facial_emotion = facial_emotion.replace("{\"facial_emotion\":", "");
		//List emotions = new ObjectMapper().readValue(facial_emotion,new TypeReference<List>(){});
		//List<facial_emotion> emotion = new ObjectMapper().readValue(facial_emotion, new TypeReference<List<facial_emotion>>(){});
		//System.out.println(emotions);
		DAOQuires db = new DAOQuires();
		String lecturename=   "MAD";
		//db.insertFaceEmotion(emotion,lecturename);
		


}

}