package dev.euclid.desktop;

import dev.euclid.core.Point;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
        if (points.size() >= 26)
          return; // limit to 26 points max
        String name = String.valueOf((char) ('A' + points.size()));
        points.add(new Point(name, e.getX(), e.getY()));
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
    // Clear and draw grid
    gc.setStroke(Color.web("#2e2e2e"));
    gc.setLineWidth(1);
    int grid = 40;
    for (double x = 0; x < w; x += grid)
      gc.strokeLine(x, 0, x, h);
    for (double y = 0; y < h; y += grid)
      gc.strokeLine(0, y, w, y);
    // Draw points
    gc.setFill(Color.web("#ffffff"));
    // Draw points
    for (Point p : points) {
      // dot
      gc.setFill(Color.web("#ffffff"));
      gc.fillOval(p.x - 4, p.y - 4, 8, 8);

      // smart label position
      double labelX, labelY;

      if (p.x < w / 2 && p.y < h / 2) {
        // top-left zone → label bottom-right
        labelX = p.x + 10;
        labelY = p.y + 16;
      } else if (p.x >= w / 2 && p.y < h / 2) {
        // top-right zone → label bottom-left
        labelX = p.x - 20;
        labelY = p.y + 16;
      } else if (p.x < w / 2 && p.y >= h / 2) {
        // bottom-left zone → label top-right
        labelX = p.x + 10;
        labelY = p.y - 8;
      } else {
        // bottom-right zone → label top-left
        labelX = p.x - 20;
        labelY = p.y - 8;
      }

      gc.setFill(Color.web("#00d4ff"));
      gc.setFont(Font.font("Monospace", 13));
      gc.fillText(p.name, labelX, labelY);
    }
  }
}
