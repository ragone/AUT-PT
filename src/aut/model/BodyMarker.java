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

    private Point2D point;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point2D getPoint() {
        return point;
    }

    public void setPoint(Point2D point) {
        this.point = point;
    }

    private Color color;

    public BodyMarker(Point2D point, Color color) {
        this.color = color;
        this.point = point;
    }
}
