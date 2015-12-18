package aut.controller;

import aut.model.ExerciseFormCollection;
import aut.model.Member;
import aut.model.Program;
import com.jfoenix.controls.JFXToggleButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

/**
 * TODO: Description of ProgramController.
 *
 * @author ragone.
 * @version 12/12/15
 */
public class ProgramController implements Initializable {
    public Button mondayAddExerciseBtn;
    public JFXToggleButton mondayToggle;
    public JFXToggleButton tuesdayToggle;
    public JFXToggleButton wednesdayToggle;
    public JFXToggleButton thursdayToggle;
    public JFXToggleButton fridayToggle;
    public JFXToggleButton saturdayToggle;
    public JFXToggleButton sundayToggle;
    public TitledPane sundayTP;
    public TitledPane saturdayTP;
    public TitledPane fridayTP;
    public TitledPane thursdayTP;
    public TitledPane wednesdayTP;
    public TitledPane tuesdayTP;
    @FXML
    private VBox container;

    @FXML
    private Button exitBtn;

    @FXML
    private Button saveBtn;

    @FXML
    private TextField descriptionTF;

    @FXML
    private TextField personalTrainerTF;

    @FXML
    private TitledPane mondayTP;

    private Program program;
    private MemberController controller;
    private Member member;
    private List<ExerciseFormCollection> mondayExerciseFormCollections = new ArrayList<>();
    private List<ExerciseFormCollection> tuesdayExerciseFormCollections = new ArrayList<>();
    private List<ExerciseFormCollection> wednesdayExerciseFormCollections = new ArrayList<>();
    private List<ExerciseFormCollection> thursdayExerciseFormCollections = new ArrayList<>();
    private List<ExerciseFormCollection> fridayExerciseFormCollections = new ArrayList<>();
    private List<ExerciseFormCollection> saturdayExerciseFormCollections = new ArrayList<>();
    private List<ExerciseFormCollection> sundayExerciseFormCollections = new ArrayList<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exitBtn.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.CLOSE));
        saveBtn.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.SAVE));

        Platform.runLater(() -> descriptionTF.requestFocus());
        setupListeners();
    }

    @FXML
    void close(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void save(ActionEvent event) {
        if(program == null) {
            program = new Program(member, descriptionTF.getText());
            member.addProgram(program);
            controller.programs.add(program);
        }
        program.setDescription(descriptionTF.getText());
        program.setPersonalTrainer(personalTrainerTF.getText());

        controller.updateTables();
        saveBtn.setDisable(true);
        HibernateUtil.saveUpdateObject(program);
    }

    public void setupProgramController(Program program, Member member, MemberController memberController) {
        this.program = program;
        this.controller = memberController;
        this.member = member;

        if (program != null) {
            descriptionTF.setText(program.getDescription());
            personalTrainerTF.setText(program.getPersonalTrainer());
        }
        saveBtn.setDisable(true);
    }

    public void setupListeners() {
        MyChangeListener listener = new MyChangeListener(saveBtn);

        descriptionTF.textProperty().addListener(listener);
        personalTrainerTF.textProperty().addListener(listener);
    }

    public void addMondayExerciseAction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        GridPane pane = (GridPane) button.getParent();
        int lastRow = GridPane.getRowIndex(button);

        pane.getChildren().remove(button);
        pane.addRow(lastRow + 1, button);

        mondayExerciseFormCollections.add(addExerciseRow(pane, lastRow));
    }

    public ExerciseFormCollection addExerciseRow(GridPane pane, int row) {

        TextField descriptionTF = new TextField();
        pane.addRow(row, descriptionTF);

        Spinner weightSpinner = new Spinner(0, 100, 0, 1);
        weightSpinner.setEditable(true);
        pane.addRow(row, weightSpinner);

        Spinner setsSpinner = new Spinner(0, 100, 0, 1);
        setsSpinner.setEditable(true);
        pane.addRow(row, setsSpinner);

        Spinner repsSpinner = new Spinner(0, 100, 0, 1);
        repsSpinner.setEditable(true);
        pane.addRow(row, repsSpinner);

        Spinner restSpinner = new Spinner(0, 100, 0, 1);
        restSpinner.setEditable(true);
        pane.addRow(row, restSpinner);

        TextField formTF = new TextField();
        pane.addRow(row, formTF);

        Button button = new Button();
        button.setMinWidth(27);
        button.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.TRASH_ALT));
        ExerciseFormCollection efc = new ExerciseFormCollection(descriptionTF, weightSpinner, setsSpinner, repsSpinner, restSpinner, formTF, button);
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                deleteRow(pane, efc);
            }
        });
        pane.addRow(row, button);

        return efc;
    }

    public void deleteRow(GridPane pane, ExerciseFormCollection efc) {
        pane.getChildren().remove(efc.getDeleteButton());
        pane.getChildren().remove(efc.getDescriptionTF());
        pane.getChildren().remove(efc.getFormTF());
        pane.getChildren().remove(efc.getWeightSpinner());
        pane.getChildren().remove(efc.getRepsSpinner());
        pane.getChildren().remove(efc.getRestSpinner());
        pane.getChildren().remove(efc.getSetsSpinner());
    }

    public void saveAsTemplateAction(ActionEvent actionEvent) {

    }

    public void addTuesdayExerciseAction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        GridPane pane = (GridPane) button.getParent();
        int lastRow = GridPane.getRowIndex(button);

        pane.getChildren().remove(button);
        pane.addRow(lastRow + 1, button);

        tuesdayExerciseFormCollections.add(addExerciseRow(pane, lastRow));
    }

    public void addWednesdayExerciseAction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        GridPane pane = (GridPane) button.getParent();
        int lastRow = GridPane.getRowIndex(button);

        pane.getChildren().remove(button);
        pane.addRow(lastRow + 1, button);

        wednesdayExerciseFormCollections.add(addExerciseRow(pane, lastRow));
    }

    public void addThursdayExerciseAction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        GridPane pane = (GridPane) button.getParent();
        int lastRow = GridPane.getRowIndex(button);

        pane.getChildren().remove(button);
        pane.addRow(lastRow + 1, button);

        thursdayExerciseFormCollections.add(addExerciseRow(pane, lastRow));
    }

    public void addFridayExerciseAction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        GridPane pane = (GridPane) button.getParent();
        int lastRow = GridPane.getRowIndex(button);

        pane.getChildren().remove(button);
        pane.addRow(lastRow + 1, button);

        fridayExerciseFormCollections.add(addExerciseRow(pane, lastRow));
    }

    public void addSaturdayExerciseAction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        GridPane pane = (GridPane) button.getParent();
        int lastRow = GridPane.getRowIndex(button);

        pane.getChildren().remove(button);
        pane.addRow(lastRow + 1, button);

        saturdayExerciseFormCollections.add(addExerciseRow(pane, lastRow));
    }

    public void addSundayExerciseAction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        GridPane pane = (GridPane) button.getParent();
        int lastRow = GridPane.getRowIndex(button);

        pane.getChildren().remove(button);
        pane.addRow(lastRow + 1, button);

        sundayExerciseFormCollections.add(addExerciseRow(pane, lastRow));
    }

    public void mondayToggleAction(ActionEvent actionEvent) {
        mondayTP.setCollapsible(true);
        mondayTP.setExpanded(mondayToggle.isSelected());
        mondayTP.setCollapsible(false);
    }

    public void tuesdayToggleAction(ActionEvent actionEvent) {
        tuesdayTP.setCollapsible(true);
        tuesdayTP.setExpanded(tuesdayToggle.isSelected());
        tuesdayTP.setCollapsible(false);
    }

    public void wednesdayToggleAction(ActionEvent actionEvent) {
        wednesdayTP.setCollapsible(true);
        wednesdayTP.setExpanded(wednesdayToggle.isSelected());
        wednesdayTP.setCollapsible(false);
    }

    public void thursdayToggleAction(ActionEvent actionEvent) {
        thursdayTP.setCollapsible(true);
        thursdayTP.setExpanded(thursdayToggle.isSelected());
        thursdayTP.setCollapsible(false);
    }

    public void fridayToggleAction(ActionEvent actionEvent) {
        fridayTP.setCollapsible(true);
        fridayTP.setExpanded(fridayToggle.isSelected());
        fridayTP.setCollapsible(false);
    }


    public void saturdayToggleAction(ActionEvent actionEvent) {
        saturdayTP.setCollapsible(true);
        saturdayTP.setExpanded(saturdayToggle.isSelected());
        saturdayTP.setCollapsible(false);
    }

    public void sundayToggleAction(ActionEvent actionEvent) {
        sundayTP.setCollapsible(true);
        sundayTP.setExpanded(sundayToggle.isSelected());
        sundayTP.setCollapsible(false);
    }
}
