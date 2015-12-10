package aut.controller;

import aut.model.Member;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * TODO: Description of MemberController.
 *
 * @author ragone.
 * @version 9/12/15
 */
public class MemberController implements Initializable {

    /** FXML variables **/

    @FXML
    private TextField firstNameTF;
    @FXML
    private TextField lastNameTF;
    @FXML
    private DatePicker dateOfBirthDP;
    @FXML
    private RadioButton male;
    @FXML
    private ToggleGroup gender;
    @FXML
    private RadioButton female;
    @FXML
    private TextArea goalTA;
    @FXML
    private TextArea goalTargetTA;
    @FXML
    private RadioButton usedGymYes;
    @FXML
    private ToggleGroup gymUsed;
    @FXML
    private RadioButton usedGymNo;
    @FXML
    private TextField programUsedTF;
    @FXML
    private RadioButton doneWeightsYes;
    @FXML
    private ToggleGroup doneWeights;
    @FXML
    private RadioButton doneWeightsNo;
    @FXML
    private TextField likesTF;
    @FXML
    private TextField dislikesTF;
    @FXML
    private RadioButton doneSportsYes;
    @FXML
    private ToggleGroup doneSports;
    @FXML
    private RadioButton doneSportsNo;
    @FXML
    private TextField sportsTF;
    @FXML
    private TextField bpTF;
    @FXML
    private TextField weightTF;
    @FXML
    private TextField rhrTF;
    @FXML
    private TextField bmiTF;
    @FXML
    private RadioButton haveDiseasesYes;
    @FXML
    private ToggleGroup diseases;
    @FXML
    private RadioButton haveDiseasesNo;
    @FXML
    private TextField diseasesTF;
    @FXML
    private Slider availableDaysSlider;
    @FXML
    private Slider workoutTimeSlider;
    @FXML
    private RadioButton groupFitnessYes;
    @FXML
    private ToggleGroup groupFitness;
    @FXML
    private RadioButton groupFitnessNo;
    @FXML
    private RadioButton personalTrainerYes;
    @FXML
    private ToggleGroup personalTrainer;
    @FXML
    private RadioButton personalTrainerNo;
    @FXML
    private Button exitBtn;
    @FXML
    private Button saveBtn;
    @FXML
    private Label ageLabel;
    @FXML
    private CheckBox CB1;
    @FXML
    private CheckBox CB2;
    @FXML
    private CheckBox CB3;
    @FXML
    private CheckBox CB4;
    @FXML
    private CheckBox CB5;
    @FXML
    private CheckBox CB6;
    @FXML
    private CheckBox CB7;
    @FXML
    private CheckBox CB8;
    @FXML
    private CheckBox CB9;
    @FXML
    private CheckBox CB10;
    @FXML
    private CheckBox CB11;
    @FXML
    private CheckBox CB12;
    @FXML
    private CheckBox CB13;
    @FXML
    private CheckBox CB14;
    @FXML
    private CheckBox CB15;
    @FXML
    private CheckBox CB16;
    @FXML
    private CheckBox CB17;
    @FXML
    private CheckBox CB18;
    @FXML
    private Canvas canvas;
    @FXML
    private VBox container;
    @FXML
    private ToolBar bodyToolBar;

    /** My variables **/

    private final int CIRCLE_DIA = 30;

    private Member member;
    private ColorPicker bodyCP;
    private HashMap<Point2D, Color> bodyMarkers;
    private boolean changed = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bodyCP = new ColorPicker(Color.BLACK);
        bodyCP.setMaxHeight(21.0);
        bodyCP.setMaxWidth(50.0);
        bodyToolBar.getItems().add(bodyCP);

        bodyMarkers = new HashMap<>();
        saveBtn.setDisable(true);
        ageLabel.setText("");
        canvas.getGraphicsContext2D().drawImage(new Image("file:images/body.png"), 0, 0);

        setupListeners();
    }

    /** Getters **/

    public Member getMember() {
        return member;
    }

    public Label getAgeLabel() {
        return ageLabel;
    }

    public Slider getAvailableDaysSlider() {
        return availableDaysSlider;
    }

    public TextField getBmiTF() {
        return bmiTF;
    }

    public ColorPicker getBodyCP() {
        return bodyCP;
    }

    public HashMap<Point2D, Color> getBodyMarkers() {
        return bodyMarkers;
    }

    public ToolBar getBodyToolBar() {
        return bodyToolBar;
    }

    public TextField getBpTF() {
        return bpTF;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public CheckBox getCB10() {
        return CB10;
    }

    public CheckBox getCB11() {
        return CB11;
    }

    public CheckBox getCB12() {
        return CB12;
    }

    public CheckBox getCB13() {
        return CB13;
    }

    public CheckBox getCB14() {
        return CB14;
    }

    public CheckBox getCB15() {
        return CB15;
    }

    public CheckBox getCB16() {
        return CB16;
    }

    public CheckBox getCB17() {
        return CB17;
    }

    public CheckBox getCB18() {
        return CB18;
    }

    public CheckBox getCB1() {
        return CB1;
    }

    public CheckBox getCB2() {
        return CB2;
    }

    public CheckBox getCB3() {
        return CB3;
    }

    public CheckBox getCB4() {
        return CB4;
    }

    public CheckBox getCB5() {
        return CB5;
    }

    public CheckBox getCB6() {
        return CB6;
    }

    public CheckBox getCB7() {
        return CB7;
    }

    public CheckBox getCB8() {
        return CB8;
    }

    public CheckBox getCB9() {
        return CB9;
    }

    public boolean isChanged() {
        return changed;
    }

    public int getCIRCLE_DIA() {
        return CIRCLE_DIA;
    }

    public VBox getContainer() {
        return container;
    }

    public DatePicker getDateOfBirthDP() {
        return dateOfBirthDP;
    }

    public ToggleGroup getDiseases() {
        return diseases;
    }

    public TextField getDiseasesTF() {
        return diseasesTF;
    }

    public TextField getDislikesTF() {
        return dislikesTF;
    }

    public ToggleGroup getDoneSports() {
        return doneSports;
    }

    public RadioButton getDoneSportsNo() {
        return doneSportsNo;
    }

    public RadioButton getDoneSportsYes() {
        return doneSportsYes;
    }

    public ToggleGroup getDoneWeights() {
        return doneWeights;
    }

    public RadioButton getDoneWeightsNo() {
        return doneWeightsNo;
    }

    public RadioButton getDoneWeightsYes() {
        return doneWeightsYes;
    }

    public Button getExitBtn() {
        return exitBtn;
    }

    public RadioButton getFemale() {
        return female;
    }

    public TextField getFirstNameTF() {
        return firstNameTF;
    }

    public ToggleGroup getGender() {
        return gender;
    }

    public TextArea getGoalTA() {
        return goalTA;
    }

    public TextArea getGoalTargetTA() {
        return goalTargetTA;
    }

    public ToggleGroup getGroupFitness() {
        return groupFitness;
    }

    public RadioButton getGroupFitnessNo() {
        return groupFitnessNo;
    }

    public RadioButton getGroupFitnessYes() {
        return groupFitnessYes;
    }

    public ToggleGroup getGymUsed() {
        return gymUsed;
    }

    public RadioButton getHaveDiseasesNo() {
        return haveDiseasesNo;
    }

    public RadioButton getHaveDiseasesYes() {
        return haveDiseasesYes;
    }

    public TextField getLastNameTF() {
        return lastNameTF;
    }

    public TextField getLikesTF() {
        return likesTF;
    }

    public RadioButton getMale() {
        return male;
    }

    public ToggleGroup getPersonalTrainer() {
        return personalTrainer;
    }

    public RadioButton getPersonalTrainerNo() {
        return personalTrainerNo;
    }

    public RadioButton getPersonalTrainerYes() {
        return personalTrainerYes;
    }

    public TextField getProgramUsedTF() {
        return programUsedTF;
    }

    public TextField getRhrTF() {
        return rhrTF;
    }

    public Button getSaveBtn() {
        return saveBtn;
    }

    public TextField getSportsTF() {
        return sportsTF;
    }

    public RadioButton getUsedGymNo() {
        return usedGymNo;
    }

    public RadioButton getUsedGymYes() {
        return usedGymYes;
    }

    public TextField getWeightTF() {
        return weightTF;
    }

    public Slider getWorkoutTimeSlider() {
        return workoutTimeSlider;
    }

    /** Setters **/

    public void setMember(Member member) {
        this.member = member;
    }

    /** FXML methods **/

    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void save(ActionEvent event) {
        if(member == null) {
            member = new Member(firstNameTF.getText(), lastNameTF.getText());
            MainController.members.add(member);
        } else {
            member.setFirstName(firstNameTF.getText());
            member.setLastName(lastNameTF.getText());
            // update member array in view
        }


        saveBtn.setDisable(true);
        changed = false;
    }

    @FXML
    private void drawCanvas(MouseEvent event) {
        bodyMarkers.put(new Point2D(event.getX(), event.getY()), bodyCP.getValue());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(bodyCP.getValue());
        gc.setLineWidth(1.0);
        gc.setTextBaseline(VPos.CENTER);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.strokeText("" + bodyMarkers.size(), event.getX(), event.getY(), CIRCLE_DIA);
        gc.setLineWidth(5.0);
        gc.strokeOval(event.getX() - CIRCLE_DIA / 2, event.getY() - CIRCLE_DIA / 2, CIRCLE_DIA, CIRCLE_DIA);
    }

    @FXML
    private void clearCanvas(ActionEvent event) {
        bodyMarkers.clear();
        canvas.getGraphicsContext2D().clearRect(0, 0, 600, 510);
        canvas.getGraphicsContext2D().drawImage(new Image("file:images/body.png"), 0, 0);
    }

    /** Methods **/

    private String getAge() {
        String result = "";

        LocalDate dob = dateOfBirthDP.getValue();
        LocalDate now = LocalDate.now();
        Long age = ChronoUnit.YEARS.between(dob, now);

        result = "" + age;
        return result;
    }

    private void setupListeners() {
        MyChangeListener listener = new MyChangeListener();
        firstNameTF.textProperty().addListener(listener);
        lastNameTF.textProperty().addListener(listener);
//        dateOfBirthDP.armedProperty().addListener(new ChangeListener<Boolean>() {
//            @Override
//            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
//                if (dateOfBirthDP.getValue() != null) {
//                    ageLabel.setText("(Age: " + getAge() + ")");
//                }
//                if (!changed) {
//                    changed = true;
//                    saveBtn.setDisable(false);
//                }
//            }
//        });
        gender.selectedToggleProperty().addListener(listener);
        goalTA.textProperty().addListener(listener);
        goalTargetTA.textProperty().addListener(listener);
        gymUsed.selectedToggleProperty().addListener(listener);
        programUsedTF.textProperty().addListener(listener);
        doneWeights.selectedToggleProperty().addListener(listener);
        likesTF.textProperty().addListener(listener);
        dislikesTF.textProperty().addListener(listener);
        bmiTF.textProperty().addListener(listener);
        weightTF.textProperty().addListener(listener);
        rhrTF.textProperty().addListener(listener);
        diseasesTF.textProperty().addListener(listener);
        diseases.selectedToggleProperty().addListener(listener);
        CB1.armedProperty().addListener(listener);
        CB2.armedProperty().addListener(listener);
        CB3.armedProperty().addListener(listener);
        CB4.armedProperty().addListener(listener);
        CB5.armedProperty().addListener(listener);
        CB6.armedProperty().addListener(listener);
        CB7.armedProperty().addListener(listener);
        CB8.armedProperty().addListener(listener);
        CB9.armedProperty().addListener(listener);
        CB10.armedProperty().addListener(listener);
        CB11.armedProperty().addListener(listener);
        CB12.armedProperty().addListener(listener);
        CB13.armedProperty().addListener(listener);
        CB14.armedProperty().addListener(listener);
        CB15.armedProperty().addListener(listener);
        CB16.armedProperty().addListener(listener);
        CB17.armedProperty().addListener(listener);
        CB18.armedProperty().addListener(listener);
        availableDaysSlider.valueProperty().addListener(listener);
        workoutTimeSlider.valueProperty().addListener(listener);
        groupFitness.selectedToggleProperty().addListener(listener);
        personalTrainer.selectedToggleProperty().addListener(listener);
        doneSports.selectedToggleProperty().addListener(listener);
        bpTF.textProperty().addListener(listener);
        sportsTF.textProperty().addListener(listener);
    }

    /** Inner class **/

    class MyChangeListener implements ChangeListener, EventHandler {

        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            if (!changed) {
                changed = true;
                saveBtn.setDisable(false);
            }
        }

        @Override
        public void handle(Event event) {
            if (!changed) {
                changed = true;
                saveBtn.setDisable(false);
            }
        }

    }

}
