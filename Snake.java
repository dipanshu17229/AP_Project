package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Snake extends Application {
	ArrayList<Rectangle> rect = new ArrayList<Rectangle>();
	//ArrayList<Text> text = new ArrayList<Text>();
	ArrayList<Circle> cir = new ArrayList<Circle>();
	Random rand = new Random();

	@Override
	public void start(Stage primaryStage) {
		//ArrayList<Rectangle> rect = new ArrayList<Rectangle>();
		//ArrayList<Text> text = new ArrayList<Text>();
		cir.add(new Circle(170, 300, 8));
		cir.add(new Circle(170, 318, 8));
		cir.add(new Circle(170, 337, 8));
		cir.add(new Circle(170, 356, 8));
		cir.add(new Circle(170, 375, 8));
		for(int i=0;i<cir.size();i++) {
			cir.get(i).setFill(Color.GREENYELLOW);
		}
		//initialize(rect, text);
		//transition(rect,text);
		//Pane root = new Pane();
		//root.getChildren().addAll(rect.get(0),rect.get(1), rect.get(2), rect.get(3), rect.get(4), text.get(0), text.get(1), text.get(2), text.get(3), text.get(4));
		//Scene scene = new Scene(root, 345, 500);
		//primaryStage.setResizable(false);
		//primaryStage.setTitle("Snake Vs Block");
		//primaryStage.setScene(scene);
		//primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
