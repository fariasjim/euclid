package dev.euclid.desktop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import dev.euclid.core.Point;

public class App extends Application {
  @Override
  public void start(Stage stage){
    Point center = new Point(400, 300);
    BorderPane root = new BorderPane();
    Scene scene = new Scene(root, 800, 600);

    stage.setTitle("Euclid Geometry");
    stage.setScene(scene);
    stage.show();
  }
  public static void main(String[] args){
    launch();
  }
}

