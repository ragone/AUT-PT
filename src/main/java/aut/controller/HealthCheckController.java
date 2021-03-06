package aut.controller;

import aut.model.BodyMarker;
import aut.model.HealthCheck;
import aut.model.Member;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * TODO: Description of MemberController.
 *
 * @author ragone.
 * @version 9/12/15
 */
public class HealthCheckController implements Initializable {

    public TextArea notesTA;
    /** FXML variables **/

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
    private List<BodyMarker> bodyMarkers = new LinkedList<>();
    private MemberController controller;
    private HealthCheck healthCheck;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bodyCP = new ColorPicker(Color.BLACK);
        bodyToolBar.getItems().add(bodyCP);

        exitBtn.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.CLOSE));
        saveBtn.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.SAVE));

        Platform.runLater(() -> goalTA.requestFocus());

        saveBtn.setDisable(true);
        canvas.getGraphicsContext2D().drawImage(new Image("images/body.png"), 0, 0);

        setupListeners();
    }

    /** Getters **/

    public Member getMember() {
        return member;
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
        if(healthCheck == null) {
            healthCheck = new HealthCheck(member);
            member.addHealthCheck(healthCheck);
            controller.healthChecks.add(healthCheck);
        }
        healthCheck.setBodyMarkers(bodyMarkers);
        healthCheck.setGoal(goalTA.getText());
        healthCheck.setGoalTarget(goalTargetTA.getText());
        healthCheck.setUsedGym(usedGymYes.isSelected());
        healthCheck.setProgramUsed(programUsedTF.getText());
        healthCheck.setUsedWeights(doneWeightsYes.isSelected());
        healthCheck.setLikes(likesTF.getText());
        healthCheck.setDislikes(dislikesTF.getText());
        healthCheck.setBmi(bmiTF.getText());
        healthCheck.setWeight(weightTF.getText());
        healthCheck.setRhr(rhrTF.getText());
        healthCheck.setWhichDiseases(diseasesTF.getText());
        healthCheck.setHaveDiseases(haveDiseasesYes.isSelected());
        healthCheck.setNotes(notesTA.getText());

        ArrayList<Boolean> cb = new ArrayList<>();
        cb.add(CB1.isSelected());
        cb.add(CB2.isSelected());
        cb.add(CB3.isSelected());
        cb.add(CB4.isSelected());
        cb.add(CB5.isSelected());
        cb.add(CB6.isSelected());
        cb.add(CB7.isSelected());
        cb.add(CB8.isSelected());
        cb.add(CB9.isSelected());
        cb.add(CB10.isSelected());
        cb.add(CB11.isSelected());
        cb.add(CB12.isSelected());
        cb.add(CB13.isSelected());
        cb.add(CB14.isSelected());
        cb.add(CB15.isSelected());
        cb.add(CB16.isSelected());
        cb.add(CB17.isSelected());
        cb.add(CB18.isSelected());
        healthCheck.setCheckBoxes(cb);

        healthCheck.setAvailableDays(availableDaysSlider.getValue());
        healthCheck.setWorkoutTime(workoutTimeSlider.getValue());
        healthCheck.setDoneGroupFitness(groupFitnessYes.isSelected());
        healthCheck.setUsedPersonalTrainer(personalTrainerYes.isSelected());
        healthCheck.setDoneSports(doneSportsYes.isSelected());
        healthCheck.setBp(bpTF.getText());
        healthCheck.setSports(sportsTF.getText());

        controller.updateTables();
        saveBtn.setDisable(true);

        HibernateUtil.saveUpdateObject(healthCheck);
    }

    @FXML
    private void drawCanvas(MouseEvent event) {
        bodyMarkers.add(new BodyMarker(healthCheck, event.getX(), event.getY(), bodyCP.getValue().toString()));
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(bodyCP.getValue());
        gc.setLineWidth(1.0);
        gc.setTextBaseline(VPos.CENTER);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.strokeText("" + bodyMarkers.size(), event.getX(), event.getY(), CIRCLE_DIA);
        gc.setLineWidth(5.0);
        gc.strokeOval(event.getX() - CIRCLE_DIA / 2, event.getY() - CIRCLE_DIA / 2, CIRCLE_DIA, CIRCLE_DIA);
        saveBtn.setDisable(false);
        notesTA.appendText("Note " + bodyMarkers.size() + " - \n");
    }

    @FXML
    private void clearCanvas(ActionEvent event) {
        bodyMarkers.clear();
        canvas.getGraphicsContext2D().clearRect(0, 0, 600, 510);
        canvas.getGraphicsContext2D().drawImage(new Image("images/body.png"), 0, 0);
        notesTA.clear();
    }

    /** Methods **/

    private void setupListeners() {
        MyChangeListener listener = new MyChangeListener(saveBtn);
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
        notesTA.textProperty().addListener(listener);

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

    public void setupHealthCheckController(HealthCheck healthCheck, Member member, MemberController memberController) {
        this.controller = memberController;
        this.member = member;
        this.healthCheck = healthCheck;

        if (healthCheck != null) {
            goalTA.setText(healthCheck.getGoal());
            goalTargetTA.setText(healthCheck.getGoalTarget());
            gymUsed.selectToggle(healthCheck.isUsedGym() ? usedGymYes : usedGymNo);
            programUsedTF.setText(healthCheck.getProgramUsed());
            doneWeights.selectToggle(healthCheck.isUsedWeights() ? doneWeightsYes : doneWeightsNo);
            likesTF.setText(healthCheck.getLikes());
            dislikesTF.setText(healthCheck.getDislikes());
            bmiTF.setText(healthCheck.getBmi());
            weightTF.setText(healthCheck.getWeight());
            rhrTF.setText(healthCheck.getRhr());
            diseasesTF.setText(healthCheck.getWhichDiseases());
            diseases.selectToggle(healthCheck.isHaveDiseases() ? haveDiseasesYes : haveDiseasesNo);

            List<Boolean> cb = healthCheck.getCheckBoxes();
            CB1.setSelected(cb.get(0));
            CB2.setSelected(cb.get(1));
            CB3.setSelected(cb.get(2));
            CB4.setSelected(cb.get(3));
            CB5.setSelected(cb.get(4));
            CB6.setSelected(cb.get(5));
            CB7.setSelected(cb.get(6));
            CB8.setSelected(cb.get(7));
            CB9.setSelected(cb.get(8));
            CB10.setSelected(cb.get(9));
            CB11.setSelected(cb.get(10));
            CB12.setSelected(cb.get(11));
            CB13.setSelected(cb.get(12));
            CB14.setSelected(cb.get(13));
            CB15.setSelected(cb.get(14));
            CB16.setSelected(cb.get(15));
            CB17.setSelected(cb.get(16));
            CB18.setSelected(cb.get(17));

            availableDaysSlider.setValue(healthCheck.getAvailableDays());
            workoutTimeSlider.setValue(healthCheck.getWorkoutTime());
            groupFitness.selectToggle(healthCheck.isDoneGroupFitness() ? groupFitnessYes : groupFitnessNo);
            personalTrainer.selectToggle(healthCheck.isUsedPersonalTrainer() ? personalTrainerYes : personalTrainerNo);
            doneSports.selectToggle(healthCheck.isDoneSports() ? doneSportsYes : doneSportsNo);
            bpTF.setText(healthCheck.getBp());
            sportsTF.setText(healthCheck.getSports());
            notesTA.setText(healthCheck.getNotes());
            setupCanvas();
        }
        saveBtn.setDisable(true);

    }

    private void setupCanvas() {
        bodyMarkers = healthCheck.getBodyMarkers();
        for(int i = 0 ; i < bodyMarkers.size() ; i++){
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setStroke(Color.valueOf(bodyMarkers.get(i).getColor()));
            gc.setLineWidth(1.0);
            gc.setTextBaseline(VPos.CENTER);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("" + (i + 1), bodyMarkers.get(i).getX(), bodyMarkers.get(i).getY(), CIRCLE_DIA);
            gc.setLineWidth(5.0);
            gc.strokeOval(bodyMarkers.get(i).getX() - CIRCLE_DIA / 2, bodyMarkers.get(i).getY() - CIRCLE_DIA / 2, CIRCLE_DIA, CIRCLE_DIA);
        }
    }

}
