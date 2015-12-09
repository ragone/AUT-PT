package aut.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;

/**
 * TODO: Description of Program.
 *
 * @author ragone.
 * @version 9/12/15
 */
public class Program {
    private String id;
    private String description;
    private LocalDate dateCreated, lastModified;
    private HashMap<String, Exercise> exercises;

    public Program(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.dateCreated = LocalDate.now();
        this.lastModified = LocalDate.now();
        this.exercises = new HashMap<>();
    }

    /** Getters **/

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public LocalDate getLastModified() {
        return lastModified;
    }

    public HashMap<String, Exercise> getExercises() {
        return exercises;
    }

    /** Setters **/

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExercises(HashMap<String, Exercise> exercises) {
        this.exercises = exercises;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLastModified(LocalDate lastModified) {
        this.lastModified = lastModified;
    }

    /** Methods **/

    public void addExercise(Exercise exercise) {
        exercises.put(exercise.getId(), exercise);
    }

    public void deleteExercise(Exercise exercise) {
        exercises.remove(exercise.getId());
    }

    @Override
    public String toString() {
        return "Program{"+ id + ":" + description + "}";
    }
}
