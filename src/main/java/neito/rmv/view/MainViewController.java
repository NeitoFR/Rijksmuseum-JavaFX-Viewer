package neito.rmv.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import neito.rmv.App;
import neito.rmv.museumAPI;

public class MainViewController {
	private App main;

	@FXML
	private ImageView artwork;
	
	public MainViewController() {
		
	}
	
	@FXML
    private void initialize() {
		Image i = new Image(museumAPI.getImage());
		//Image i = new Image();
		artwork.setImage(i);
		//System.out.println(new File(museumAPI.class.getClassLoader().getResource("anissa.jpg").getPath()).getAbsolutePath());
	}
		
	public void setMain(App main)
	{
		this.main = main;
	}
}
