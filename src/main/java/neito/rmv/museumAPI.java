package neito.rmv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import javafx.scene.image.Image;
import javafx.scene.image.ImageViewBuilder;

public class museumAPI {
	private final static String token = "MvDNbZD9";
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
		Image i = null;
		String url = "taggle";
		HttpURLConnection c =  initConnection("https://www.rijksmuseum.nl/api/en/collection?key="+token+"&ps=100&format=json&principalMaker=Rembrandt%20van%20Rijn");
		
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
				// System.out.println(jres);
				url = jres.getJSONArray("artObjects").getJSONObject(0).getJSONObject("webImage").getString("url");
				System.out.println(url);
			} catch (IOException e) {e.printStackTrace();}
		}
		else{
			System.out.println("Image non récupéré");
		}
		
		return url;
	}
}
