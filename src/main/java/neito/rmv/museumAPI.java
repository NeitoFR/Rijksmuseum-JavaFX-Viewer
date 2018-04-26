package neito.rmv;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.scene.image.Image;

public class museumAPI {
	private final static String token = "MvDNbZD9";
	private static ArrayList<String> imagesURL = new ArrayList<String>();
	
	public static void main(String[] args) {
		getImage();
	}
	
	private static HttpURLConnection initConnection(String s) {
		HttpURLConnection c = null; 
		
		try {
			URL url = new URL(s);
			c = (HttpURLConnection) url.openConnection();
			int responseCode = c.getResponseCode();
			
			System.out.println("status : "+ responseCode);
			if(responseCode != 200 && responseCode != 204)
			{
				c = null;
				System.out.println("Echec");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	public static String getImage() {
		Image i = null;;
		String url = museumAPI.class.getClassLoader().getResource("Hearthstone.jpg").toString();
		HttpURLConnection c =  initConnection("https://www.rijksmuseum.nl/api/en/collection?key="+token+"&ps=1000&format=json&principalMaker=Rembrandt%20van%20Rijn");
		
		if(c != null) {
			try {
				c.connect();
				InputStream in = c.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				StringBuilder res = new StringBuilder();
				String line; 
				
				while((line = reader.readLine()) != null) {
					res.append(line+"\r");
				}
				
				JSONObject jres = new JSONObject(res.toString());
				if(jres.getInt("count") != 0){
					//url = jres.getJSONArray("artObjects").getJSONObject(0).getJSONObject("webImage").getString("url");
					//System.out.println(url);
					//System.out.println(jres.getJSONArray("artObjects").getJSONObject(64).get("webImage").equals(null));
					for(int j = 0; j < jres.getJSONArray("artObjects").length()-1; j++) {
						System.out.println(imagesURL);
						if(!jres.getJSONArray("artObjects").getJSONObject(j).get("webImage").equals(null)){
							imagesURL.add(jres.getJSONArray("artObjects").getJSONObject(j).getJSONObject("webImage").getString("url"));
						}
						else
						{
							System.out.println("Pas d'url");
						}
						System.out.println(j);
					}
				}
				else {
					System.out.println(jres.getInt("count"));
					System.out.println("Pas d'image");
				}
			} catch (IOException e) {e.printStackTrace();}
		}
		else{
			System.out.println("Image non récupéré");
//			url = museumAPI.class.getClassLoader().getResource("anissa.jpg");
//			System.out.println(museumAPI.class.getClassLoader().getResource("anissa.jpg"));	
		}
		
		return url;
	}
}
