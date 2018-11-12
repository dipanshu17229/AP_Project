package application;
	
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.event.*;


public class Main extends Application {
	Random rand = new Random();
	@Override
	public void start(Stage primaryStage) {
		try {
			//Stage secondaryStage = new Stage();
			Image image = new Image(new FileInputStream("C:\\Users\\Prince\\Downloads\\Snake.png"));
			ImageView imageView = new ImageView(image);
			//imageView.setX(25); 
		    //imageView.setY(25); 
		    //imageView.setFitHeight(800); 
		    //imageView.setFitWidth(900);
		    //imageView.setPreserveRatio(true);
		    Button start = new Button("START");
		    Button score = new Button("LEADERBOARD");
			Button exit = new Button("EXIT");
		    start.setLayoutX(120);
		    start.setLayoutY(190);
		    score.setLayoutX(110);
		    score.setLayoutY(285);
		    exit.setLayoutX(150);
		    exit.setLayoutY(325);
		    start.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff; -fx-font: 24 arial; -fx-font-weight: bold");
		    score.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #ff0000; -fx-font: 14 arial; -fx-font-weight: bold");
		    exit.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #ff0000; -fx-font: 14 arial; -fx-font-weight: bold");
		    AnchorPane root = new AnchorPane(imageView, start, score, exit);
			//root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
			//root.getChildren().addAll(imageView);
			//root.getChildren().addAll(imageView, start, score, exit);
			//root.setAlignment(Pos.CENTER);
			exit.setOnAction(e -> System.exit(0));
			start.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					GamePlay game = new GamePlay();
					game.start(primaryStage);
					
				}
			});
			score.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					//start1(secondaryStage);
					LeaderBoard le = new LeaderBoard();
					le.start(primaryStage);
				}
			});
			Scene scene = new Scene(root,340,500);
			scene.setFill(Color.BLACK);
			scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Snake Vs Block");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start1(Stage primaryStage) {
		try {
			Button back = new Button("BACK");
			Text text = new Text("S.No.");
			text.setFont(Font.font("arial", 22));
			back.setLayoutX(150);
			back.setLayoutY(450);
			text.setX(0);
			text.setY(20);
			text.setFill(Color.BLACK);
			//text.setStrokeWidth(2); 
		    //text.setStroke(Color.DARKSLATEBLUE);
			//but.setAlignment(Pos.BOTTOM_CENTER);
			AnchorPane root = new AnchorPane(back, text);
			back.setOnAction(e -> {
				start(primaryStage);
			});
			//back.setOnAction(e -> Stage.primaryStage.show());
			//StackPane root = new StackPane();
			//root.getChildren().addAll(back, text);
			//root.setPadding(new Insets(10));
			//root.setAlignment(Pos.TOP_LEFT);
			Scene scene = new Scene(root,340,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("LeaderBoard");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
