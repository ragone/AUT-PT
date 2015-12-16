package aut.model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

/**
 * TODO: Description of BodyMarker.
 *
 * @author ragone.
 * @version 11/12/15
 */
public class BodyMarker {

    private double x;
    private double y;
    private Color color;

    public BodyMarker() {
        this(0 , 0, Color.BLACK);
    }

    public BodyMarker(double x, double y, Color color) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
