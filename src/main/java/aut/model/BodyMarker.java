package aut.model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * TODO: Description of BodyMarker.
 *
 * @author ragone.
 * @version 11/12/15
 */
@Entity
public class BodyMarker {

    @Id
    @GeneratedValue
    private long id;
    private double x;
    private double y;
    private String color;
    @ManyToOne
    private HealthCheck healthCheck;

    public BodyMarker() {
        this(null, 0 , 0, "000000");
    }

    public BodyMarker(HealthCheck healthCheck, double x, double y, String color) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.healthCheck = healthCheck;
    }

    public String getColor() {
        return color;
    }

    public HealthCheck getHealthCheck() {
        return healthCheck;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setHealthCheck(HealthCheck healthCheck) {
        this.healthCheck = healthCheck;
    }

    public void setColor(String color) {
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
