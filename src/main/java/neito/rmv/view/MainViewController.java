package neito.rmv.view;

import java.io.File;
import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import neito.rmv.App;
import neito.rmv.museumAPI;
import neito.rmv.model.Oeuvre;

public class MainViewController {
	private App main;
	private ArrayList<Oeuvre> listOeuvres;
	//private int imageCount;
	private IntegerProperty cpt = new SimpleIntegerProperty(); 
	@FXML
	private ImageView artwork;
	@FXML
	private Button next, prev;
	@FXML
	private Label Lartiste, Ltitre, Ldate;
	
	public MainViewController() {
		
	}
	
	@FXML
    private void initialize() {
		cpt.set(0);
		prev.setDisable(true);
		cpt.addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
				System.out.println("Old value : "+oldValue+"new value : "+newValue+" Obs : "+ observable.toString());
				if(newValue.intValue() == 0)
				{
					prev.setDisable(true);
				}
				else
				{
					prev.setDisable(false);
				}
				if(newValue.intValue() == listOeuvres.size() -1)
				{
					next.setDisable(true);
				}
				else
				{
					next.setDisable(false);
				}
			}); 
		//System.out.println(imageCount.get());
		listOeuvres = museumAPI.getListOeuvres();
		Image i = new Image(listOeuvres.get(cpt.intValue()).getUrl());
		setDetails(listOeuvres.get(cpt.intValue()));
		artwork.setImage(i);
	}
	@FXML
	private void handleSuivant() {
		cpt.set(cpt.get()+1);
		System.out.println(cpt.get());
		Image i = new Image(listOeuvres.get(cpt.intValue()).getUrl());
		setDetails(listOeuvres.get(cpt.intValue()));
		artwork.setImage(i);
	}
	@FXML
	private void handlePrecedent() {
		cpt.set(cpt.get()-1);
		System.out.println(cpt.get());
		Image i = new Image(listOeuvres.get(cpt.intValue()).getUrl());
		setDetails(listOeuvres.get(cpt.intValue()));
		artwork.setImage(i);
	}
	private void setDetails(Oeuvre o) {
		Lartiste.setText(o.getArtiste());
		Ltitre.setText(o.getTitre());
		Ldate.setText(o.getDate());
	}
	public void setMain(App main)
	{
		this.main = main;
	}
}
