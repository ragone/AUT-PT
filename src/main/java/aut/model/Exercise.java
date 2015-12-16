package aut.model;

import java.util.UUID;

/**
 * TODO: Description of Exercise.
 *
 * @author ragone.
 * @version 9/12/15
 */
class Exercise {
    private int reps;
    private int sets;
    private int weight;
    private int restTime;
    private long id;
    private String notes;
    private Program program;

    public Exercise() {
        this(null, 0, 0);
        // used by hibernate
    }

    public Exercise(Program program, int reps, int sets) {
        this.program = program;
        this.notes = "";
        this.reps = reps;
        this.restTime = 0;
        this.sets = sets;
        this.weight = 0;
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

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
