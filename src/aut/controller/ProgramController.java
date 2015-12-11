package aut.controller;

import aut.model.Member;
import aut.model.Program;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * TODO: Description of ProgramController.
 *
 * @author ragone.
 * @version 12/12/15
 */
public class ProgramController implements Initializable {
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

    private Program program;
    private MemberController controller;
    private Member member;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
            program = new Program(descriptionTF.getText());
            member.addProgram(program);
            controller.programs.add(program);
        }
        program.setDescription(descriptionTF.getText());
        program.setPersonalTrainer(personalTrainerTF.getText());

        controller.updateTables();
        saveBtn.setDisable(true);
    }

    public void setupProgramController(Program program, Member member, MemberController memberController) {
        this.program = program;
        this.controller = memberController;
        this.member = member;

        if (program != null) {
            descriptionTF.setText(program.getDescription());
            personalTrainerTF.setText(program.getPersonalTrainer().toString());
        }
        saveBtn.setDisable(true);
    }

    public void setupListeners() {
        MyChangeListener listener = new MyChangeListener(saveBtn);

        descriptionTF.textProperty().addListener(listener);
        personalTrainerTF.textProperty().addListener(listener);
    }
}
