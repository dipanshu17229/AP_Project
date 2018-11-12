package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LeaderBoard extends Application {

	@Override
	public void start(Stage primaryStage) {
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
