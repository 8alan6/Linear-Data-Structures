package lab2;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Shape{

	public Rectangle rectangle(int i) {				//Rectangle method returns rectangle. (int i, used to create different rectangles)
		Rectangle rectangle = new Rectangle();		//Create Rectangle called 'rectangle'
		
		if(i < 1) {																			//if 'i' is less than 1
		    rectangle.setWidth(150);														//set rectangle width to 150
		    rectangle.setHeight(200);														//set rectangle height to 200
			rectangle.setFill(Color.color(Math.random(), Math.random(), Math.random()));	//set fill colour
			return rectangle;																//return rectangle
	}
	else if(i > 0) {																		//if 'i' is greater than 0 
		rectangle.setWidth(300);															//set rectangle width
		rectangle.setHeight(100);															//set rectangle height
	    rectangle.setArcWidth(20);															//set rectangle	arc width
	    rectangle.setArcHeight(20);															//set rectangle arc height		
		rectangle.setStroke(Color.color(Math.random(), Math.random(),Math.random()));		//set rectangle	stroke colour
	    rectangle.setFill(Color.WHITE);														//set rectangle	fill colour
	    rectangle.setStrokeWidth(10);														//set rectangle	stroke width
	    return rectangle;																	//return rectangle
		}
	return null;																			//if i is not less than 1 or greater...	
	}																						//...than 0. return null 	
	
	public Rectangle square() {																
		Rectangle square = new Rectangle();													//Create Rectangle 'square'
	    square.setWidth(200);																//set square width
	    square.setHeight(200);																//set square height
	    square.setArcWidth(20);																//set square arc width
	    square.setArcHeight(20);															//set square arc height
		square.setFill(Color.color(Math.random(), Math.random(), Math.random()));			//set square fill colour
		return square;																		//return square
	}
	
	public Polygon polygon(int numOfSides) {												//Polygon method
		Polygon polygon = new Polygon();													//creates Polygon 'polygon'
	    polygon.setFill(Color.color(Math.random(), Math.random(), Math.random()));			//sets polygon fill colour
	    ObservableList<Double> list = polygon.getPoints();									//Ob..List 'list' created
	    
	    double centerX = 100 / 2, centerY = 100 / 2;										//creates Double 'centerX' & 'centerY'	
	    double radius = Math.min(100, 100) * 0.4;											//creares Double 'radius'

	    // Add points to the polygon list
	    for (int i = 0; i < numOfSides; i++) {												//for loop, loops 'numOfSides' times
	      list.add(centerX + radius * Math.cos(2 * i * Math.PI / numOfSides)); 				//adds points to the polygon
	      list.add(centerY - radius * Math.sin(2 * i * Math.PI / numOfSides));
	    }
	    if(numOfSides==6) {																	//if numOfSides is 6	
	    	polygon.setRotate(90);															//rotate polygon 90deg
	    }
	    else if(numOfSides==5){																//if numOfSides is 5
	    	polygon.setRotate(54);															//rotate polygon
	    	}
	    return polygon;																		//return polygon
	}
	
	public LinePane xCross() {																//LinePane method 'xCross'
		LinePane cross = new LinePane();													//Creates LinePane cross;
		return cross;																		//returns cross
	}

	class LinePane extends Pane {
		  public LinePane() {
		    Line line1 = new Line();														//creates Line 'line1'
		    line1.setEndX(150);																//set End X for 'line1'
		    line1.setEndY(150);																//set End Y for 'line1'
		    line1.setStrokeWidth(30);														//set stroke width for 'line1'
		    line1.setStroke(Color.RED);														//set stroke colour for 'line1'
		    getChildren().add(line1);														//add 'line1' to LinePane
		    
		    Line line2 = new Line();														//creates Line 'line2'
		    line2.setStartX(150);															//set Start X for 'line2'	
		    line2.setEndY(150);																//set End y for 'line2'
		    line2.setStrokeWidth(30);														//set stroke width for 'line2'
		    line2.setStroke(Color.RED);														//set stroke colour for 'line2'
		    getChildren().add(line2);														//add 'line2' to linePane
		  }
		}

	public Ellipse elipse() {																//elipse method 
	
	Ellipse e1 = new Ellipse(200, 100, 200 - 50, 100 - 50);									//create ellipse 'e1'
	      e1.setStroke(Color.color(Math.random(), Math.random(),Math.random()));			//set stroke colour for 'e1'
	      e1.setFill(Color.WHITE);															//set fill colour for 'e1'
	      e1.setStrokeWidth(10);															//set stroke width for 'e1'		
		return e1;																			//return 'e1'
	}
}
