package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LeaderBoard extends Application {

	@Override
	public void start(Stage primaryStage) {
		ArrayList<Text> text = new ArrayList<Text>();
		text.add(new Text(25,45, "1"));
		text.get(0).setFill(Color.BLACK);
		text.get(0).setFont(new Font(20));
		text.add(new Text(65,45,"Pranshu"));
		text.get(1).setFill(Color.BLACK);
		text.get(1).setFont(new Font(20));
		text.add(new Text(195,45,"12-Oct-2018"));
		text.get(2).setFill(Color.BLACK);
		text.get(2).setFont(new Font(12));
		text.add(new Text(295,45,"35"));
		text.get(3).setFill(Color.BLACK);
		text.get(3).setFont(new Font(20));
		//String s = "1";
		//String name = "Pranshu";
		//String Date = "12-Oct-2018";
		int Score = 400;
		Button back = new Button("BACK");
		TableView table = new TableView();
		table.setStyle("-fx-background-color: DodgerBlue");
		table.prefHeightProperty().bind(primaryStage.heightProperty().multiply(0.85));
		table.prefWidthProperty().bind(primaryStage.widthProperty());
		TableColumn sno = new TableColumn("S.No.");
		//sno
		//sno.setCellValueFactory(new MapValueFactory(text.get(0)));
		TableColumn player = new TableColumn("Player");
		sno.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
		player.prefWidthProperty().bind(table.widthProperty().multiply(0.38));
        TableColumn date = new TableColumn("Date");
		TableColumn score = new TableColumn("Score");
		        
		table.getColumns().addAll(sno, player, date, score);
		back.setLayoutX(150);
		back.setLayoutY(462);
		AnchorPane root = new AnchorPane(back, table, text.get(0),text.get(1), text.get(2), text.get(3));
		root.setStyle("-fx-background-color: DodgerBlue");
		back.setOnAction(e -> {
			Main ma = new Main();
			ma.start(primaryStage);
		});
		//back.setOnAction(e -> Stage.primaryStage.show());
		Scene scene = new Scene(root,340,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("LeaderBoard");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
