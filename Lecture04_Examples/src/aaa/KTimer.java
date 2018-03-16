package aaa;

import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class KTimer extends Application{

	private VBox vBox = new VBox();
	private HBox hBox = new HBox();
	private Label label = new Label("STOPWATCH");
	private DigitalClock clock = new DigitalClock();
	private boolean running = false;


	public void start(Stage stage) throws Exception {
		BorderPane bp = new BorderPane();
		vBox.getChildren().addAll(label,clock);
		vBox.setAlignment(Pos.CENTER);
		Button startStop = new Button("Start/Stop");
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().add(startStop);
		bp.setCenter(vBox);
		bp.setBottom(hBox);

		startStop.setOnAction(new EnlargeHandler());
		Scene scene = new Scene(bp);
		stage.setScene(scene);
		stage.show();


		class EnlargeHandler implements EventHandler<ActionEvent> {
			@Override // Override the handle method
			public void handle(ActionEvent e) {
				runClock();
			}
		}
		startStop.setOnAction(new EnlargeHandler());
		
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent arg0) {
				running = false;
				stage.close();
			}
			
		});	
		

	}
	private void runClock() {
		if(running == true) {
			running = false;
		}

		else {
			running = true;
			new Thread() {
				public void run() {
					long last = System.nanoTime();
					double delta = 0;
					double ns = 1000000000.0/1;
					int count = 0;

					while(running) {
						long now = System.nanoTime();
						delta += (now - last) /ns;
						last = now;

						while(delta >= 1) {
							count = (count +1) % 100;
							System.out.println("pulse ......"+count);
							DecimalFormat df = new DecimalFormat("00");
							clock.refreshDigit(df.format(count));
							delta--;
						}
					}
				}
			}.start();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
