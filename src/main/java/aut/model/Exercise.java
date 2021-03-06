package aut.model;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.DayOfWeek;
import java.util.UUID;

/**
 * TODO: Description of Exercise.
 *
 * @author ragone.
 * @version 9/12/15
 */
@Entity
public class Exercise {
    private String name;
    private int reps;
    private int sets;
    private int weight;
    private int restTime;
    private DayOfWeek day;
    @Id
    @GeneratedValue
    private long id;
    private String notes;
    @ManyToOne
    private Program program;

    public Exercise() {
        this(null, DayOfWeek.MONDAY);
        // used by hibernate
    }

    public Exercise(Program program, DayOfWeek day) {

        this.day = day;
        this.name = "";
        this.program = program;
        this.notes = "";
        this.weight = 0;
        this.reps = 0;
        this.sets = 0;
        this.restTime = 0;
    }

    /** Getters **/

    public long getId() {
        return id;
    }

    public String getNotes() {
        return notes;
    }

    public Program getProgram() {
        return program;
    }

    public int getReps() {
        return reps;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getRestTime() {
        return restTime;
    }

    public int getSets() {
        return sets;
    }

    /** Setters **/

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setRestTime(int restTime) {
        this.restTime = restTime;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }
}
