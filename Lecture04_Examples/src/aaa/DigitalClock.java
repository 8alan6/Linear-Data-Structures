package aaa;

import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class DigitalClock extends Parent {
	
	private final int boxHeight = 10;
	private final int boxWidth = boxHeight * 5 / 8;
	private final int scale = 5;
	
	private Font FONT = new Font(10*scale);
	private HBox hBox = new HBox();
	private Text[] digit = new Text[2];
	private Group[] digitGroup = new Group[2];
	
	public DigitalClock() {
		configureDigit();
		configureHBox();
		getChildren().add(hBox);
	}

	private void configureHBox() {
		// TODO Auto-generated method stub
		hBox.getChildren().addAll(digitGroup);
		hBox.setSpacing(2);
	}

	private void configureDigit() {
		// TODO Auto-generated method stub
		for(int i =0; i<digit.length; i++) {
			digit[i] = new Text("0");
			digit[i].setFont(FONT);
			digit[i].setTextOrigin(VPos.TOP);
			digit[i].setLayoutY(-10);
			Rectangle rectangle = null;
				rectangle = createBackground(Color.BLACK, Color.ANTIQUEWHITE);
				digit[i].setFill(Color.ANTIQUEWHITE);
			
			digitGroup[i] = new Group(rectangle,digit[i]);
		}
	}

	private Rectangle createBackground(Color fill, Color stroke) {
		Rectangle rectangle = new Rectangle(boxWidth * scale,boxHeight * scale,fill); 
		rectangle.setStroke(stroke);
		rectangle.setStrokeWidth(3);
		rectangle.setEffect(new Lighting());
		return rectangle;
	}
	
	public void refreshDigit(String number) {
		for(int i=0; i<digit.length; i++) {
			digit[i].setText(number.substring(i, i+1));
		}
	}
}
