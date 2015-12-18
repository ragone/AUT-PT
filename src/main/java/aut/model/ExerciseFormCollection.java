package aut.model;


import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

/**
 * TODO: Description of ExerciseFormCollection.
 *
 * @author ragone.
 * @version 18/12/15
 */
public class ExerciseFormCollection {
    private TextField descriptionTF;
    private TextField formTF;
    private Spinner weightSpinner;
    private Spinner setsSpinner;
    private Spinner repsSpinner;
    private Spinner restSpinner;
    private Button deleteButton;

    public ExerciseFormCollection(TextField descriptionTF, Spinner weightSpinner, Spinner setsSpinner, Spinner repsSpinner, Spinner restSpinner, TextField formTF, Button deleteButton) {
        this.deleteButton = deleteButton;
        this.descriptionTF = descriptionTF;
        this.formTF = formTF;
        this.repsSpinner = repsSpinner;
        this.restSpinner = restSpinner;
        this.setsSpinner = setsSpinner;
        this.weightSpinner = weightSpinner;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public TextField getDescriptionTF() {
        return descriptionTF;
    }

    public TextField getFormTF() {
        return formTF;
    }

    public Spinner getRepsSpinner() {
        return repsSpinner;
    }

    public Spinner getRestSpinner() {
        return restSpinner;
    }

    public Spinner getSetsSpinner() {
        return setsSpinner;
    }

    public Spinner getWeightSpinner() {
        return weightSpinner;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    public void setDescriptionTF(TextField descriptionTF) {
        this.descriptionTF = descriptionTF;
    }

    public void setFormTF(TextField formTF) {
        this.formTF = formTF;
    }

    public void setRepsSpinner(Spinner repsSpinner) {
        this.repsSpinner = repsSpinner;
    }

    public void setRestSpinner(Spinner restSpinner) {
        this.restSpinner = restSpinner;
    }

    public void setSetsSpinner(Spinner setsSpinner) {
        this.setsSpinner = setsSpinner;
    }

    public void setWeightSpinner(Spinner weightSpinner) {
        this.weightSpinner = weightSpinner;
    }
}
