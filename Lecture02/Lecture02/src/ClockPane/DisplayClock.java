package ClockPane;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class DisplayClock extends Application {
  // Override the start method in the Application class
	 ClockPane clock = new ClockPane();
	 ClockPane clock2 = new ClockPane();
  public void start(Stage primaryStage) {
    // Create a clock and a label  
	Label lblCurrentTime = new Label(update());
	lblCurrentTime = clock2.setDigitalTime();
    
    // Create a handler for animation
    EventHandler<ActionEvent> eventHandler = e -> {
      clock.setCurrentTime(); // Set a new clock time
      
      //digitalClock.setDigitalClock();
    };
  
    // Create an animation for a running clock
    Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation    

    
    
    
    
    
    // Place clock and label in border pane
    BorderPane pane = new BorderPane();
    pane.setCenter(clock);
    pane.setBottom(clock2);
    BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 250, 250);
    primaryStage.setTitle("DisplayClock"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  
 
  public String update() {
	  String update = clock.getHour() + ":" + clock.getMinute() 
      + ":" + clock.getSecond();
	  return update;
  }
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
  
}