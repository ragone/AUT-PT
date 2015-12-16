package aut.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO: Description of HealthCheck.
 *
 * @author ragone.
 * @version 9/12/15
 */
@Entity
public class HealthCheck {
    @Id
    @GeneratedValue
    private long id;
    private String goal;
    private String goalTarget;
    private String programUsed;
    private String likes;
    private String dislikes;
    private String bmi;
    private String weight;
    private String rhr;
    private String whichDiseases;
    private String bp;
    private String sports;
    private String notes;
    private String personalTrainer;
    private LocalDate dateAdded;
    private LocalDate lastModified;
    private boolean usedGym;
    private boolean usedWeights;
    private boolean haveDiseases;
    private boolean doneGroupFitness;
    private boolean usedPersonalTrainer;
    private boolean doneSports;
    private boolean haveActiveProgram;
    @ElementCollection
    private List<Boolean> checkBoxes = new ArrayList<>();
    private Double availableDays, workoutTime;
    @ManyToOne
    private Member member;

    @OneToMany(mappedBy = "healthCheck")
    private List<BodyMarker> bodyMarkers = new LinkedList<>();

    public HealthCheck() {
        this(null);
        // used by hibernate
    }

    public HealthCheck(Member member) {
        this.dateAdded = LocalDate.now();
        this.lastModified = LocalDate.now();
        this.availableDays = 3.0;
        this.bmi = "";
        this.bp = "";
        this.dislikes = "";
        this.doneGroupFitness = false;
        this.doneSports = false;
        this.goal = "";
        this.goalTarget = "";
        this.haveActiveProgram = false;
        this.haveDiseases = false;
        this.likes = "";
        this.personalTrainer = "";
        this.programUsed = "";
        this.rhr = "";
        this.sports = "";
        this.usedGym = false;
        this.usedPersonalTrainer = false;
        this.usedWeights = false;
        this.weight = "";
        this.whichDiseases = "";
        this.workoutTime = 60.0;
        this.member = member;
    }

    /** Getters **/

    public Member getMember() {
        return member;
    }

    public long getId() {
        return id;
    }

    public Double getAvailableDays() {
        return availableDays;
    }

    public String getBmi() {
        return bmi;
    }

    public List<BodyMarker> getBodyMarkers() {
        return bodyMarkers;
    }

    public String getBp() {
        return bp;
    }

    public List<Boolean> getCheckBoxes() {
        return checkBoxes;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public String getDislikes() {
        return dislikes;
    }

    public boolean isDoneGroupFitness() {
        return doneGroupFitness;
    }

    public boolean isDoneSports() {
        return doneSports;
    }

    public String getGoal() {
        return goal;
    }

    public String getGoalTarget() {
        return goalTarget;
    }

    public boolean isHaveActiveProgram() {
        return haveActiveProgram;
    }

    public boolean isHaveDiseases() {
        return haveDiseases;
    }

    public LocalDate getLastModified() {
        return lastModified;
    }

    public String getLikes() {
        return likes;
    }

    public String getNotes() {
        return notes;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public String getProgramUsed() {
        return programUsed;
    }

    public String getRhr() {
        return rhr;
    }

    public String getSports() {
        return sports;
    }

    public boolean isUsedGym() {
        return usedGym;
    }

    public boolean isUsedPersonalTrainer() {
        return usedPersonalTrainer;
    }

    public boolean isUsedWeights() {
        return usedWeights;
    }

    public String getWeight() {
        return weight;
    }

    public String getWhichDiseases() {
        return whichDiseases;
    }

    public Double getWorkoutTime() {
        return workoutTime;
    }

    /** Setters **/

    public void setAvailableDays(Double availableDays) {
        this.availableDays = availableDays;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public void setBodyMarkers(List<BodyMarker> bodyMarkers) {
        this.bodyMarkers = bodyMarkers;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public void setCheckBoxes(List<Boolean> checkBoxes) {
        this.checkBoxes = checkBoxes;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setDislikes(String dislikes) {
        this.dislikes = dislikes;
    }

    public void setDoneGroupFitness(boolean doneGroupFitness) {
        this.doneGroupFitness = doneGroupFitness;
    }

    public void setDoneSports(boolean doneSports) {
        this.doneSports = doneSports;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setGoalTarget(String goalTarget) {
        this.goalTarget = goalTarget;
    }

    public void setHaveActiveProgram(boolean haveActiveProgram) {
        this.haveActiveProgram = haveActiveProgram;
    }

    public void setHaveDiseases(boolean haveDiseases) {
        this.haveDiseases = haveDiseases;
    }

    public void setLastModified(LocalDate lastModified) {
        this.lastModified = lastModified;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setPersonalTrainer(String personalTrainer) {
        this.personalTrainer = personalTrainer;
    }

    public void setProgramUsed(String programUsed) {
        this.programUsed = programUsed;
    }

    public void setRhr(String rhr) {
        this.rhr = rhr;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public void setUsedGym(boolean usedGym) {
        this.usedGym = usedGym;
    }

    public void setUsedPersonalTrainer(boolean usedPersonalTrainer) {
        this.usedPersonalTrainer = usedPersonalTrainer;
    }

    public void setUsedWeights(boolean usedWeights) {
        this.usedWeights = usedWeights;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setWhichDiseases(String whichDiseases) {
        this.whichDiseases = whichDiseases;
    }

    public void setWorkoutTime(Double workoutTime) {
        this.workoutTime = workoutTime;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
