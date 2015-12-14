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
    private LocalDate dateAdded, lastModified;
    private HashMap<String, Exercise> exercises;
    private String personalTrainer;

    public Program(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.dateAdded = LocalDate.now();
        this.lastModified = LocalDate.now();
        this.exercises = new HashMap<>();
        this.personalTrainer = null;
    }

    /** Getters **/

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
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

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExercises(HashMap<String, Exercise> exercises) {
        this.exercises = exercises;
    }

    public void setPersonalTrainer(String personalTrainer) {
        this.personalTrainer = personalTrainer;
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
