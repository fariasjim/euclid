package dev.euclid.desktop;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class Toolbar extends VBox {

  public Toolbar(ToolState toolState) {
    setSpacing(8);
    setStyle("-fx-padding: 12; -fx-background-color: #2b2b2b;");
    setPrefWidth(80);

    ToggleGroup group = new ToggleGroup();

    ToggleButton pointBtn = toolButton("Point", group);
    ToggleButton lineBtn = toolButton("Line", group);
    ToggleButton circleBtn = toolButton("Circle", group);

    pointBtn.setOnAction(e -> toolState.setActiveTool(ToolState.Tool.POINT));
    lineBtn.setOnAction(e -> toolState.setActiveTool(ToolState.Tool.LINE));
    circleBtn.setOnAction(e -> toolState.setActiveTool(ToolState.Tool.NONE));

    getChildren().addAll(pointBtn, lineBtn, circleBtn);
  }

  private ToggleButton toolButton(String label, ToggleGroup group) {
    ToggleButton btn = new ToggleButton(label);
    btn.setToggleGroup(group);
    btn.setMaxWidth(Double.MAX_VALUE);
    return btn;
  }
}
