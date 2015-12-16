package aut.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * TODO: Description of Program.
 *
 * @author ragone.
 * @version 9/12/15
 */
@Entity
public class Program {
    @ManyToOne
    private Member member;
    @Id
    @GeneratedValue
    private long id;
    private String description;
    private LocalDate dateAdded;
    private LocalDate lastModified;
    @OneToMany(mappedBy = "program")
    private List<Exercise> exercises = new ArrayList<>();
    private String personalTrainer;

    public Program() {
        this(null, "");
        // used by hibernate
    }

    public Program(Member member, String description) {
        this.member = member;
        this.description = description;
        this.dateAdded = LocalDate.now();
        this.lastModified = LocalDate.now();
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

    public Member getMember() {
        return member;
    }

    public long getId() {
        return id;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public LocalDate getLastModified() {
        return lastModified;
    }


    /** Setters **/

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void setPersonalTrainer(String personalTrainer) {
        this.personalTrainer = personalTrainer;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLastModified(LocalDate lastModified) {
        this.lastModified = lastModified;
    }

    /** Methods **/

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public void deleteExercise(Exercise exercise) {
        exercises.remove(exercise);
    }

    @Override
    public String toString() {
        return "Program{"+ id + ":" + description + "}";
    }
}
