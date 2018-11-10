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
					Button backk = new Button("RESTART");
					backk.setLayoutX(1);
					backk.setLayoutY(1);
					backk.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #ff0000; -fx-font: 14 arial; -fx-font-weight: bold");
					ArrayList<Rectangle> rect = new ArrayList<Rectangle>();
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
					transition(rect,text);
					Pane root = new Pane();
					root.getChildren().addAll(backk, rect.get(0),rect.get(1), rect.get(2), rect.get(3), rect.get(4), text.get(0), text.get(1), text.get(2), text.get(3), text.get(4), cir.get(0), cir.get(1), cir.get(2), cir.get(3), cir.get(4));
					Scene scene = new Scene(root, 345, 500);
					primaryStage.setResizable(false);
					primaryStage.setTitle("Transition");
					primaryStage.setScene(scene);
					primaryStage.show();
					backk.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							start(primaryStage);
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
			});
			score.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					//start1(secondaryStage);
					Button back = new Button("BACK");
					TableView table = new TableView();
					table.setStyle("-fx-background-color: DodgerBlue");
					table.prefHeightProperty().bind(primaryStage.heightProperty().multiply(0.85));
					table.prefWidthProperty().bind(primaryStage.widthProperty());
					TableColumn sno = new TableColumn("S.No.");
					TableColumn player = new TableColumn("Player");
					sno.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
					player.prefWidthProperty().bind(table.widthProperty().multiply(0.38));
			        TableColumn date = new TableColumn("Date");
					TableColumn score = new TableColumn("Score");
					        
					table.getColumns().addAll(sno, player, date, score);
					back.setLayoutX(150);
					back.setLayoutY(462);
					AnchorPane root = new AnchorPane(back, table);
					root.setStyle("-fx-background-color: DodgerBlue");
					back.setOnAction(e -> {
						start(primaryStage);
					});
					//back.setOnAction(e -> Stage.primaryStage.show());
					Scene scene = new Scene(root,340,500);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setTitle("LeaderBoard");
					primaryStage.setScene(scene);
					primaryStage.show();
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
