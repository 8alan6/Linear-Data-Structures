package lab2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Layout extends Application {

	@Override
	public void start(Stage primaryStage){

		BorderPane topPane = new BorderPane(); 				//Creates a BorderPane named 'topPane'.
		GridPane bottomPane = new GridPane();				//Creates a GridPane named 'bottomPane'.
		BorderPane total = new BorderPane();				//Creates a BroderPane named 'total'.
		total.setTop(topPane);								//sets 'topPane' to the top of BorderPane 'total'.
		total.setBottom(bottomPane);						//sets 'bottomPane' to the bottom of BorderPane 'total'.
		Scene scene = new Scene(total, 1200,700);			//Creates a Scene named 'scene' using BorderPane 'total. Size 1200 x 700

		primaryStage.setTitle("Alan_Walsh_LAB 2 : Borderpane & Shapes");	//Title given to the primaryStage
		primaryStage.setScene(scene);										//sets the Scene 'scene' to the primaryStage
		primaryStage.show();												//shows the primaryStage

		Shape pickShape = new Shape();										//Creates Shape 'pickShape' using Shape Class.
																			//Shape Class has methods to generate all required shapes.

		/*
		Shapes generated below are used in BorderPane 'topPane'
		 */
		
		HBox topBox = new HBox(pickShape.polygon(6));		//Creates HBox 'topBox' and creates a 6 sided polygon inside 'topBox'
		topBox.setStyle("-fx-border-color: black");			//generates a border for 'topBox'
		topBox.setAlignment(Pos.CENTER);					//sets the position of 'topBox'	
		topBox.setPadding(new Insets(5,10,5,10));			//sets padding of 'topBox' (top,right,bottom,left)
		topPane.setTop(topBox);								//sets HBox 'topBox' to the top of BorderPane 'topPane' 


		VBox leftBox = new VBox(pickShape.rectangle(0));	//Creates VBox 'leftBox' and creates a rectangle inside 'leftBox'
		leftBox.setMaxWidth(200);							//sets the max width of 'leftBox'
		leftBox.setPadding(new Insets(5,10,5,10));			//sets padding of 'leftBox'
		leftBox.setStyle("-fx-border-color: black");		//creates a black border
		leftBox.setAlignment(Pos.CENTER);					//sets the position of 'leftBox'		
		topPane.setLeft(leftBox);							//sets VBox 'leftBox' to the left of BorderPane 'topPane'

		HBox centerBox = new HBox(pickShape.square());		//Creates HBox 'centerBox' and creates a square inside 'centerBox'
		centerBox.setStyle("-fx-border-color: black");		//creates a black border for 'centerBox'
		centerBox.setAlignment(Pos.CENTER);					//sets the position of 'centerBox'
		topPane.setCenter(centerBox);						//sets HBox 'centerBox' to the center of BorderPane 'topPane'

		VBox rightBox = new VBox(pickShape.xCross());		//Creates VBox 'rightBox' and creates a cross inside 'rightBox'
		rightBox.setPadding(new Insets(60,25,25,25));		//sets padding of 'rightBox'
		rightBox.setStyle("-fx-border-color: black");		//creates a black border for 'rightBox'
		rightBox.setMaxWidth(200);							//sets max width of 'rightBox' to 200.
		rightBox.setAlignment(Pos.CENTER);					//sets the position of 'rightBox'
		topPane.setRight(rightBox);							//sets VBox 'rightBox' to the top of BorderPane 'topPane'


		HBox bottomBox = new HBox(pickShape.polygon(5));	//Creates HBox 'bottomBox' and creates a 5 sided polygon inside 'bottomBox'
		bottomBox.setStyle("-fx-border-color: black");		//creates a black border for 'bottomBox'
		bottomBox.setAlignment(Pos.CENTER);					//sets the position of 'bottomBox'
		bottomBox.setMaxHeight(20);							//sets max height of 'bottomBox' to 20
		bottomBox.setPadding(new Insets(5,10,5,10));		//sets padding of 'bottomBox'
		topPane.setBottom(bottomBox);						//sets HBox 'bottomBox' to the top of BorderPane 'topPane'
		
		
		/*
		Shapes generated below are used in GridPane 'bottomPane'
		 */
		
		bottomPane.setAlignment(Pos.CENTER);				//sets the position of GridPane 'bottomPane'
		bottomPane.setVgap(10);								//sets the Vgap of GridPane 'bottomPane'


		// Place nodes in the pane
		bottomPane.add(pickShape.elipse(), 1, 0);			//adds Shape 'elipse' to GridPane 'bottomPane'
		Label circle = new Label("Circle");					//creates Label 'circle'
		circle.setPadding(new Insets(0,0,0,130));			//sets padding of Label 'circle'
		bottomPane.add(circle, 1, 0);						//adds Label 'circle' to GridPane 'bottomPane'

		bottomPane.add(pickShape.rectangle(1), 1, 1);		//adds Shape 'rectangle' to GridPane 'bottomPane'
		Label square = new Label("Square");					//creates Label 'square'
		square.setPadding(new Insets(0,0,0,130));			//sets padding of Label 'square'
		bottomPane.add(square, 1, 1);						//adds Label 'square' to GridPane 'bottomPane'
	}


	public void start(String[] args) {
		launch(args);
	}
}