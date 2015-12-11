package aut.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * TODO: Description of HealthCheck.
 *
 * @author ragone.
 * @version 9/12/15
 */
public class HealthCheck {
    private String goal, goalTarget, programUsed, likes, dislikes, bmi, weight, rhr,
            whichDiseases, bp, sports;
    private PersonalTrainer personalTrainer;
    private LocalDate dateAdded, lastModified;
    private boolean usedGym, usedWeights, haveDiseases, doneGroupFitness, usedPersonalTrainer,
            doneSports, haveActiveProgram;
    private ArrayList<Boolean> checkBoxes;
    private Double availableDays, workoutTime;

    public HealthCheck() {
        this.dateAdded = LocalDate.now();
        this.lastModified = LocalDate.now();
        this.availableDays = 3.0;
        this.bmi = "";
        this.bp = "";
        this.checkBoxes = new ArrayList<>();
        this.dislikes = "";
        this.doneGroupFitness = false;
        this.doneSports = false;
        this.goal = "";
        this.goalTarget = "";
        this.haveActiveProgram = false;
        this.haveDiseases = false;
        this.likes = "";
        this.personalTrainer = null;
        this.programUsed = "";
        this.rhr = "";
        this.sports = "";
        this.usedGym = false;
        this.usedPersonalTrainer = false;
        this.usedWeights = false;
        this.weight = "";
        this.whichDiseases = "";
        this.workoutTime = 60.0;
    }

    /** Getters **/

    public Double getAvailableDays() {
        return availableDays;
    }

    public String getBmi() {
        return bmi;
    }

    public String getBp() {
        return bp;
    }

    public ArrayList<Boolean> getCheckBoxes() {
        return checkBoxes;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public LocalDate getLastModified() {
        return lastModified;
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

    public String getLikes() {
        return likes;
    }

    public PersonalTrainer getPersonalTrainer() {
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

    public boolean usedGym() {
        return usedGym;
    }

    public boolean usedPersonalTrainer() {
        return usedPersonalTrainer;
    }

    public boolean usedWeights() {
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

    public void setBp(String bp) {
        this.bp = bp;
    }

    public void setCheckBoxes(ArrayList<Boolean> checkBoxes) {
        this.checkBoxes = checkBoxes;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setLastModified(LocalDate lastModified) {
        this.lastModified = lastModified;
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

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public void setPersonalTrainer(PersonalTrainer personalTrainer) {
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

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setWhichDiseases(String whichDiseases) {
        this.whichDiseases = whichDiseases;
    }

    public void setWorkoutTime(Double workoutTime) {
        this.workoutTime = workoutTime;
    }
}
