package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Blocks extends Application {
	Random rand = new Random();
	ArrayList<Rectangle> rect = new ArrayList<Rectangle>();
	ArrayList<Text> text = new ArrayList<Text>();
	
	@Override
	public void start(Stage primaryStage) {
		initialize(rect, text);
		transition(rect,text);
	}
	
	public void initialize(ArrayList<Rectangle> rect, ArrayList<Text> text) {
		int y = -45;
		for(int i=0;i<5;i++) {
			text.add(new Text(y+70,40, Integer.toString(rand.nextInt(20)+1)));
			y+=70;
		}
//		text.add(new Text(25,40, Integer.toString(rand.nextInt(20)+1)));
//		text.add(new Text(95,40, Integer.toString(rand.nextInt(20)+1)));
//		text.add(new Text(165,40, Integer.toString(rand.nextInt(20)+1)));
//		text.add(new Text(235,40, Integer.toString(rand.nextInt(20)+1)));
//		text.add(new Text(305,40, Integer.toString(rand.nextInt(20)+1)));
		int x = -69;
		//rect.add(new Rectangle(x, 0, 70, 70));
		for(int i=0;i<5;i++) {
			rect.add(i,new Rectangle(x+70, 0, 70, 70));
			x+=70;
//			rect.get(rand.nextInt(i+1)+0).setFill(Color.DODGERBLUE);
//			rect.get(rand.nextInt(i+1)+0).setFill(Color.GREEN);
//			rect.get(rand.nextInt(i+1)+0).setFill(Color.PURPLE);
//			rect.get(rand.nextInt(i+1)+0).setFill(Color.ORANGE);
//			rect.get(rand.nextInt(i+1)+0).setFill(Color.RED);
//			rect.get(rand.nextInt(i+1)+0).setFill(Color.CRIMSON);
		}
//		rect.add(new Rectangle(1, 0, 70, 70));
//		rect.add(new Rectangle(71, 0, 70, 70));
//		rect.add(new Rectangle(141, 0, 70, 70));
//		rect.add(new Rectangle(211, 0, 70, 70));
//		rect.add(new Rectangle(281, 0, 70, 70));
		for(int i=0;i<rect.size();i++) {
			text.get(i).setFont(new Font(20));
			text.get(i).setFill(Color.BLACK);
			rect.get(i).setArcHeight(12);
			rect.get(i).setArcWidth(12);
			rect.get(i).setFill(Color.DODGERBLUE);
			//rect.get(rand.nextInt(i+1)+0).setFill(Color.DODGERBLUE);
			rect.get(rand.nextInt(i+1)+0).setFill(Color.GREEN);
			rect.get(rand.nextInt(i+1)+0).setFill(Color.PURPLE);
			rect.get(rand.nextInt(i+1)+0).setFill(Color.ORANGE);
			rect.get(rand.nextInt(i+1)+0).setFill(Color.RED);
			rect.get(rand.nextInt(i+1)+0).setFill(Color.CRIMSON);
		}
		//rect.get(0).setFill(Color.GREEN);
		//rect.get(3).setFill(Color.GRAY);
		//rect.get(4).setFill(Color.YELLOW);
	}
	
	public void transition(ArrayList<Rectangle> rect, ArrayList<Text> text) {
		ParallelTransition pt = new ParallelTransition();
		for(int i=0;i<rect.size();i++) {
			TranslateTransition transition = new TranslateTransition();
			TranslateTransition transition2 = new TranslateTransition();
			transition.setDuration(Duration.seconds(2));
			transition2.setDuration(Duration.seconds(2));
			transition.setToX(0);
			transition.setToY(500);
			transition2.setToY(500);
			transition.setNode(rect.get(i));
			transition2.setNode(text.get(i));
			pt.getChildren().addAll(transition, transition2);
		}
		pt.setCycleCount(Animation.INDEFINITE);
		pt.play();
		pt.setOnFinished(event -> {
			initialize(rect, text);
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
