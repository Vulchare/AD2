import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.*;
import org.json.simple.*;

public class TestJSONApi {

	public TestJSONApi() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int indexChannel = 8; //index for get on line 43-45 to test
		String channels = "";
		
		//shit i found to extract string from url
		URL urlchannels = new URL("http://www.tvgids.nl/json/lists/channels.php");
		URLConnection c = urlchannels.openConnection();
		InputStream r = c.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(r));
		channels = reader.readLine();

		  System.out.println(channels); //all channels
          System.out.println();
          
		  Object obj = JSONValue.parse(channels);
		  JSONArray array = (JSONArray) obj;
		  
		  System.out.println("======the " + indexChannel + "th element of array (name,id,name_short)======");
		  
		  System.out.println(array.get(indexChannel));
		  System.out.println();
		               
		  JSONObject obj2 = (JSONObject) array.get(indexChannel);

		  System.out.println("id: " + obj2.get("id"));
		  System.out.println("name: " + obj2.get("name"));   
		  System.out.println("name_short: " + obj2.get("name_short")); 
		  

			  
		  }

	}


