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
    private LocalDate dateOfBirth, dateAdded, dateModified;
    private boolean male, usedGym, usedWeights, haveDiseases, doneGroupFitness, usedPersonalTrainer,
            doneSports, haveActiveProgram;
    private ArrayList<Boolean> checkBoxes;
    private Double availableDays, workoutTime;

    public HealthCheck() {
        this.dateAdded = LocalDate.now();
        this.dateModified = LocalDate.now();
        this.availableDays = null;
        this.bmi = null;
        this.bp = null;
        this.checkBoxes = new ArrayList<>();
        this.dateOfBirth = null;
        this.dislikes = null;
        this.doneGroupFitness = false;
        this.doneSports = false;
        this.goal = null;
        this.goalTarget = null;
        this.haveActiveProgram = false;
        this.haveDiseases = false;
        this.likes = null;
        this.male = false;
        this.personalTrainer = null;
        this.programUsed = null;
        this.rhr = null;
        this.sports = null;
        this.usedGym = false;
        this.usedPersonalTrainer = false;
        this.usedWeights = false;
        this.weight = null;
        this.whichDiseases = null;
        this.workoutTime = null;
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

    public LocalDate getDateModified() {
        return dateModified;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
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

    public boolean isMale() {
        return male;
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

    public void setBp(String bp) {
        this.bp = bp;
    }

    public void setCheckBoxes(ArrayList<Boolean> checkBoxes) {
        this.checkBoxes = checkBoxes;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setDateModified(LocalDate dateModified) {
        this.dateModified = dateModified;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public void setMale(boolean male) {
        this.male = male;
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
