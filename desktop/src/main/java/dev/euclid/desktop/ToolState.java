package dev.euclid.desktop;

public class ToolState {
    public enum Tool {
        NONE, POINT, LINE, CIRCLE
    }

    private Tool activeTool = Tool.NONE;

    public Tool getActiveTool() {
        return activeTool;
    }

    public void setActiveTool(Tool tool) {
        activeTool = tool;
    }
}
