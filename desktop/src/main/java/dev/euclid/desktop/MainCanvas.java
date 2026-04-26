package dev.euclid.desktop;

import dev.euclid.core.Point;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class MainCanvas extends Pane {
  private final Canvas canvas;
  private final List<Point> points = new ArrayList<>();
  private final ToolState toolState;

  public MainCanvas(ToolState toolState) {
    this.toolState = toolState;
    canvas = new Canvas();

    canvas.widthProperty().bind(widthProperty());
    canvas.heightProperty().bind(heightProperty());
    canvas.widthProperty().addListener(e -> draw());
    canvas.heightProperty().addListener(e -> draw());

    canvas.setOnMouseClicked(e -> {
      if (toolState.getActiveTool() == ToolState.Tool.POINT) {
        points.add(new Point(e.getX(), e.getY()));
        draw();
      }
    });

    getChildren().add(canvas);
  }

  private void draw() {
    GraphicsContext gc = canvas.getGraphicsContext2D();
    double w = canvas.getWidth();
    double h = canvas.getHeight();

    gc.setFill(Color.web("#1e1e1e"));
    gc.fillRect(0, 0, w, h);

    gc.setStroke(Color.web("#2e2e2e"));
    gc.setLineWidth(1);
    int grid = 40;
    for (double x = 0; x < w; x += grid)
      gc.strokeLine(x, 0, x, h);
    for (double y = 0; y < h; y += grid)
      gc.strokeLine(0, y, w, y);
    // Draw points
    gc.setFill(Color.web("#ffffff"));
    for (Point p : points) {
      gc.fillOval(p.x - 4, p.y - 4, 8, 8);
    }
  }
}
