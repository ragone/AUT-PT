package aut.controller;

import aut.model.Member;
import aut.model.Program;
import aut.model.Exercise;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * TODO: Description of ProgramController.
 *
 * @author ragone.
 * @version 12/12/15
 */
public class ProgramController implements Initializable {
    public Button mondayAddExerciseBtn;
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
    private List<Object> mondayExercises = new ArrayList<>();


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

    public void addExerciseAction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        GridPane pane = (GridPane) button.getParent();
        int lastRow = GridPane.getRowIndex(button);

        pane.getChildren().remove(button);
        pane.addRow(lastRow + 1, button);

        TitledPane tp = (TitledPane) pane.getParent().getParent();
        String title = tp.getText();
        Exercise exercise = new Exercise(program, DayOfWeek.valueOf(title));

        switch (exercise.getDay()) {
            case MONDAY: mondayExercises.add(exercise);
                break;
            case TUESDAY:
                break;
        }
        addRow(pane, lastRow, exercise);
    }

    public void addRow(GridPane pane, int row, Exercise exercise) {
    }

    public void saveAsTemplateAction(ActionEvent actionEvent) {

    }
}
