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
public class HealthCheckController implements Initializable {

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
        canvas.getGraphicsContext2D().drawImage(new Image("file:images/body.png"), 0, 0);

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



    private void setupListeners() {
        MyChangeListener listener = new MyChangeListener();
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
