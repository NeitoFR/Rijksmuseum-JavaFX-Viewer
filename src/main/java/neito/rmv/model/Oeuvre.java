package neito.rmv.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import neito.rmv.museumAPI;

public class Oeuvre {
	private StringProperty artiste;
	private StringProperty titre;
	private StringProperty date;
	private StringProperty url;
	private IntegerProperty index;
	
	public Oeuvre(String artiste, String titre, String date, String url, int index)
	{
		this.artiste = new SimpleStringProperty(artiste);
		this.titre = new SimpleStringProperty(titre);
		this.date = new SimpleStringProperty(date);
		this.url = new SimpleStringProperty(url);
		this.index = new SimpleIntegerProperty(index);
	}
	/*public Oeuvre()
	{
		this("No Artist", "No Title", "No Date", museumAPI.class.getClassLoader().getResource("Hearthstone.jpg").toString(), 9999);
	}*/
	//Getters
	public String getArtiste() {
		return artiste.get();
	}
	public String getTitre() {
		return titre.get();
	}
	public String getDate() {
		return date.get();
	}
	public String getUrl() {
		return url.get();
	}
	public int getIndex() {
		return index.get();
	}
	
	//Property Getters
	public StringProperty artisteProperty() {
		return artiste;
	}
	public StringProperty titreProperty() {
		return titre;
	}
	public StringProperty dateProperty() {
		return date;
	}
	public StringProperty urlProperty() {
		return url;
	}
	public IntegerProperty indexProperty() {
		return index;
	}
	//Setters
	public void setArtiste(String s) {
		this.artiste.set(s);
	}
	public void setTitre(String s) {
		this.titre.set(s);
	}
	public void setDate(String s) {
		this.date.set(s);
	}
	public void setUrl(String s) {
		this.url.set(s);
	}
	public void setIndex(int i) {
		this.index.set(i);
	}
}
