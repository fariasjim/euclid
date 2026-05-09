package dev.euclid.core;

public class Line {
  private Point startPoint;
  private Point endPoint;
  private boolean isArc;

  private double highPointValue;
  private double lowPointValue;

  public Line(Point start, Point end) {
    this.startPoint = start;
    this.endPoint = end;
    this.isArc = false; // Default value for isArc is false. need to manually config for enabling arc.
  }

  public void setArc(boolean arc, double high, double low) {
    this.isArc = arc;
    this.highPointValue = high;
    this.lowPointValue = low;
  }
}
