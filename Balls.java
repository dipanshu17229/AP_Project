package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Balls extends Tokens {
	Circle cir = new Circle();
	Random rand = new Random();
	Image image;
	ImageView imageView;
	//Stage primaryStage = new Stage();
	
	public void position() {
		super.position();
	}

	//@Override
	public void start(Stage primaryStage) {
		//int val = rand.nextInt(2)+0;
		//if(val==1) {
			position();
			if(list_x.size()!=0) {
				cir.setLayoutX(tf_x);
				cir.setLayoutY(tf_y);
				//list_x.remove(new Integer(tf_x));
				//list_y.remove(new Integer(tf_y));
				cir.setRadius(8);
				cir.setFill(Color.GREENYELLOW);
				transition(cir);
			}
		//}
	}
	
	public void transition(Circle cir) {
		ParallelTransition pt = new ParallelTransition();
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(2));
		transition.setToX(0);
		transition.setToY(500);
		transition.setNode(cir);
		pt.getChildren().addAll(transition);
		pt.setCycleCount(Animation.INDEFINITE);
		/*pt.setOnFinished(event -> {
			list_x.clear();
			list_y.clear();
			start(primaryStage);
		}); */
		pt.play();
	}
}
