package cantor;

import cantor.library.Constance;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static cantor.library.Constance.*;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/main-screen.fxml"));
        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane,400,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Application Cantor v.1.0.0");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/main-screen.fxml"));
        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle(APP_VERSION);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
