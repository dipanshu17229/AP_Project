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

public class GamePlay extends Application {
	Random rand = new Random();

	@Override
	public void start(Stage primaryStage) {
		Snake snake = new Snake();
		snake.start(primaryStage);
		Blocks block = new Blocks();
		block.start(primaryStage);
		Button backk = new Button("RESTART");
		backk.setLayoutX(1);
		backk.setLayoutY(1);
		backk.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #ff0000; -fx-font: 14 arial; -fx-font-weight: bold");
		/*ArrayList<Rectangle> rect = new ArrayList<Rectangle>();
		ArrayList<Circle> cir = new ArrayList<Circle>();
		ArrayList<Text> text = new ArrayList<Text>();
		
		cir.add(new Circle(170, 300, 8));
		cir.add(new Circle(170, 318, 8));
		cir.add(new Circle(170, 337, 8));
		cir.add(new Circle(170, 356, 8));
		cir.add(new Circle(170, 375, 8));
		for(int i=0;i<cir.size();i++) {
			cir.get(i).setFill(Color.GREENYELLOW);
		}
		initialize(rect, text);
		transition(rect,text); */
		Pane root = new Pane();
		root.getChildren().addAll(backk, block.rect.get(0),block.rect.get(1), block.rect.get(2), block.rect.get(3), block.rect.get(4), block.text.get(0), block.text.get(1), block.text.get(2), block.text.get(3), block.text.get(4),snake.cir.get(1), snake.cir.get(2), snake.cir.get(3), snake.cir.get(4));
		Scene scene = new Scene(root, 345, 500);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Snake Vs Block");
		primaryStage.setScene(scene);
		primaryStage.show();
		backk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Main ma = new Main();
				ma.start(primaryStage);
			}
		});
	}
	
	public void initialize(ArrayList<Rectangle> rect, ArrayList<Text> text) {
		text.add(new Text(25,40, Integer.toString(rand.nextInt(20))));
		text.add(new Text(95,40, Integer.toString(rand.nextInt(20))));
		text.add(new Text(165,40, Integer.toString(rand.nextInt(20))));
		text.add(new Text(235,40, Integer.toString(rand.nextInt(20))));
		text.add(new Text(305,40, Integer.toString(rand.nextInt(20))));
		rect.add(new Rectangle(1, 0, 70, 70));
		rect.add(new Rectangle(71, 0, 70, 70));
		rect.add(new Rectangle(141, 0, 70, 70));
		rect.add(new Rectangle(211, 0, 70, 70));
		rect.add(new Rectangle(281, 0, 70, 70));
		for(int i=0;i<rect.size();i++) {
			text.get(i).setFont(new Font(20));
			text.get(i).setFill(Color.BLACK);
			rect.get(i).setArcHeight(12);
			rect.get(i).setArcWidth(12);
			rect.get(i).setFill(Color.DODGERBLUE);
		}
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
