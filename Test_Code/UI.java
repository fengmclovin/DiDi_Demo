import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RiderApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Uber-like Rider App");

        Button requestRideButton = new Button("Request Ride");
        Button cancelRideButton = new Button("Cancel Ride");

        VBox vbox = new VBox(requestRideButton, cancelRideButton);
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
