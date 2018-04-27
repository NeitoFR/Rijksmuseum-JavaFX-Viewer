package neito.rmv;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import neito.rmv.view.MainViewController;

public class App extends Application
{
	private Stage app_base;
	private BorderPane rootLayout;
	
	public App(){
	
	}
    public static void main( String args[] )
    {
		launch();
    }
	@Override
	public void start(Stage app_base) throws Exception {
		this.app_base = app_base;
		this.app_base.setTitle("Rijksmuseum Art Viewer");
		initRoot();
		showMainView();
	}
	private void initRoot() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource("view/Root.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			app_base.setScene(scene);
			app_base.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void showMainView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource("view/MainView.fxml"));
			AnchorPane mainViewLayout = (AnchorPane) loader.load();
			rootLayout.setCenter(mainViewLayout);
			MainViewController ctrl = loader.getController();
			ctrl.setMain(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
