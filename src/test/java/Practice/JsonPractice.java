package Practice;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.*;

import com.fasterxml.jackson.core.JsonParser;

public class JsonPractice {
@Test
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
 
			JSONParser p=new JSONParser();
			
			Object obj = p.parse(new FileReader("C:\\Users\\Dell\\Desktop\\TY_Supply_Chain_Testing_Docs/commondata.json"));
			JSONObject map=(JSONObject)obj;
			System.out.println(map.get("browser"));
			
	}

}
