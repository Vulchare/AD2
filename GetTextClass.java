package getTextClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class GetTextClass {
	public String kanalen = "";
	public String[] rawDataArray;
	public ArrayList<Zender> Zenders = new ArrayList();
	
public GetTextClass(){
	try {
		rawDataArrayCase();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	//System.out.println(kanalen);
	kanalen = kanalen.replace("[", "").replace("]","");
	rawDataArray = kanalen.split(Pattern.quote("{"));
	
	for (int i = 0; i < rawDataArray.length;i++){
		rawDataArray[i] = rawDataArray[i].replace("},","").replace("}","").replace("\"","");
	}
	
	while(Zenders.size()<500){ 
		Zenders.add(new Zender("0", "leeg", "leeg"));
		}
	
	for (String s : rawDataArray){
		if (s.length() > 0){
		Zenders.set(Integer.parseInt(getID(s)), new Zender(getID(s), getNaam(s), getNaamKort(s)));
		}
	}
	
	System.out.println(Zenders.get(27).getNaam());


}
	public static void main(String[] args) {
		new GetTextClass();
	}

	public  void rawDataArrayCase() throws IOException{
		URL u = new URL("http://www.tvgids.nl/json/lists/channels.php");
		URLConnection c = u.openConnection();
		InputStream r = c.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(r));
		for(String line; (line = reader.readLine()) != null;) kanalen = line;
	}
	
	public  String getID(String s){
		String id = s.substring(3, s.indexOf(",")); //id
		return id;
	}
	
	public  String getNaam(String s){
		String naam = s.substring(s.indexOf("name", 0)+5, s.indexOf(",",s.indexOf("name", 0))); //naam
		return naam;
	}
	
	public  String getNaamKort(String s){
		String naamKort = s.substring(s.indexOf("name_short", 0)+11, s.length()); //naamkort
		return naamKort;	
	}
	
	
	
	public  String[] splitsen(String s){
		String[] strArray = new String[3];
		String noQuotes = s.replace("\"","");
		
		strArray[0] = noQuotes.substring(3, noQuotes.indexOf(",")); //id
		strArray[1] = noQuotes.substring(noQuotes.indexOf("name", 0)+5, noQuotes.indexOf(",",noQuotes.indexOf("name", 0))); //naam
		strArray[2] = noQuotes.substring(noQuotes.indexOf("name_short", 0)+11, noQuotes.length()); //naamkort
		
		/* Testcase
		System.out.println("id = " + strArray[0]);
		System.out.println("naam = " + strArray[1]);
		System.out.println("naamkort = " + strArray[2]);
		*/
		
		return strArray; // id, naam, naamkort
	}
	

	

}

