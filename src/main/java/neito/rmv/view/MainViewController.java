package neito.rmv.view;

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
		artwork.setImage(i);
	}
	public void setMain(App main)
	{
		this.main = main;
	}
}
