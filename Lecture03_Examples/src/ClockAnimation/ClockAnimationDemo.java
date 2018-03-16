package ClockAnimation;

import javafx.application.Application;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class ClockAnimationDemo extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    BorderPane bPane = new BorderPane();
    ClockPane clock = new ClockPane(); // Create a clock
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	DateFormat stopWatch = new SimpleDateFormat("HH:mm:ss");
    Date date = new Date();
    TextField tf1 = new TextField(dateFormat.format(date));
    
    
    Label digitalDate = new Label(dateFormat.format(date));
    Label stopStart = new Label(dateFormat.format(date));
    
    digitalDate.setPrefWidth(80);
    bPane.setCenter(clock);
    
    GridPane gPane = new GridPane();
    gPane.add(new Label("Date: "), 0, 0);
    gPane.add(digitalDate, 1, 0);
    
    gPane.setAlignment(Pos.CENTER);
    digitalDate.setAlignment(Pos.CENTER);

    bPane.setTop(gPane);
    
    
    // Create a handler for animation
    EventHandler<ActionEvent> eventHandler = e -> {
      clock.setCurrentTime(); // Set a new clock time
      //digitalClock.setDigitalClock();
    };
    
    // Create an animation for a running clock
    Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation    
    
    
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(bPane, 250, 250);
    primaryStage.setTitle("ClockAnimation"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
