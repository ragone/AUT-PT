package aut.model;

import java.util.UUID;

/**
 * TODO: Description of Exercise.
 *
 * @author ragone.
 * @version 9/12/15
 */
class Exercise {
    private int reps, sets, restTime;
    private String id, notes;

    public Exercise(int reps, int sets) {
        this.id = UUID.randomUUID().toString();
        this.notes = "";
        this.reps = reps;
        this.restTime = 0;
        this.sets = sets;
    }

    /** Getters **/

    public String getId() {
        return id;
    }

    public String getNotes() {
        return notes;
    }

    public int getReps() {
        return reps;
    }

    public int getRestTime() {
        return restTime;
    }

    public int getSets() {
        return sets;
    }

    /** Setters **/

    public void setId(String id) {
        this.id = id;
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
