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
		Pane root = new Pane();
		int r1 = rand.nextInt(2)+0;
		int r2 = rand.nextInt(2)+0;
		int r3 = rand.nextInt(2)+0;
		int r4 = rand.nextInt(2)+0;
		String text = "Score : 0";
		Text t = new Text();
		t.setText(text);
		t.setFont(new Font(20));
		t.setX(250);
		t.setY(20);
		Snake snake = new Snake();
		snake.start(primaryStage);
		for(int i=0;i<snake.cir.size();i++) {
			root.getChildren().addAll(snake.cir.get(i));
		}
		Blocks block = new Blocks();
		block.start(primaryStage);
		for(int i=0;i<block.rect.size();i++) {
			root.getChildren().addAll(block.rect.get(i));
			root.getChildren().addAll(block.text.get(i));
		}
		if(r2==1) {
			Magnet magnet = new Magnet();
			magnet.start(primaryStage);
			root.getChildren().addAll(magnet.imageView);
		}
		if(r3==1) {
			Shield shield = new Shield();
			shield.start(primaryStage);
			root.getChildren().addAll(shield.imageView);
		}
		if(r4==1) {
			DestroyBlocks db = new DestroyBlocks();
			db.start(primaryStage);
			root.getChildren().addAll(db.imageView);
		}
		if(r1==1) {
			Balls ball = new Balls();
			ball.start(primaryStage);
			root.getChildren().addAll(ball.cir);
		}
		Button backk = new Button("RESTART");
		backk.setLayoutX(1);
		backk.setLayoutY(1);
		backk.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #ff0000; -fx-font: 14 arial; -fx-font-weight: bold");

		root.getChildren().addAll(t, backk);
		//root.getChildren().addAll(t, backk, block.rect.get(0),block.rect.get(1), block.rect.get(2), block.rect.get(3), block.rect.get(4), block.text.get(0), block.text.get(1), block.text.get(2), block.text.get(3), block.text.get(4),snake.cir.get(1), snake.cir.get(2), snake.cir.get(3), snake.cir.get(4));
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
