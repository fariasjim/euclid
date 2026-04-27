package dev.euclid.desktop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

  @Override
  public void start(Stage stage) {
    ToolState toolstate = new ToolState();
    BorderPane root = new BorderPane();
    root.setRight(new Toolbar(toolstate));
    root.setCenter(new MainCanvas(toolstate));
    root.setStyle("-fx-background-color: #1e1e1e;");
    Scene scene = new Scene(root, 600, 400);

    stage.setTitle("Euclid");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
