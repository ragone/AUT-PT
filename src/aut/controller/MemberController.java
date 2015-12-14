package aut.controller;

import aut.model.Gender;
import aut.model.HealthCheck;
import aut.model.Member;
import aut.model.Program;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
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
    private ToolBar healthCheckToolbar;
    @FXML
    private ToolBar programToolbar;
    @FXML
    private TableColumn<HealthCheck, String> lastModifiedHCCol;
    @FXML
    private TableColumn<Program, String> lastModifiedCol;
    @FXML
    private TableView<Program> programTable;
    @FXML
    private TableView<HealthCheck> healthCheckTable;
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
    private Button exitBtn;
    @FXML
    private Button saveBtn;
    @FXML
    private Label ageLabel;
    @FXML
    private VBox container;
    @FXML
    private TableColumn<Program, String> descriptionCol;
    @FXML
    private TableColumn<HealthCheck, String> dateAddedCol;
    @FXML
    private TableColumn<Program, String> personalTrainerCol;
    @FXML
    private TableColumn<HealthCheck, String> dateAddedHCCol;

    /** My variables **/

    public ObservableList<Program> programs = FXCollections.observableArrayList();
    public ObservableList<HealthCheck> healthChecks = FXCollections.observableArrayList();
    private Member member;
    private MainController controller;
    private Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveBtn.setDisable(true);
        ageLabel.setText("");
        exitBtn.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.CLOSE));
        saveBtn.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.SAVE));

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                firstNameTF.requestFocus();
            }
        });

        setupListeners();
        setupTables();
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
    private void editHealthCheckAction(ActionEvent event) {
        HealthCheck hc = healthCheckTable.getSelectionModel().getSelectedItem();

        if(hc != null) {
            Parent root;
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/healthCheck.fxml"));
                root = fxmlLoader.load();
                HealthCheckController controller = fxmlLoader.<HealthCheckController>getController();
                controller.setupHealthCheckController(hc, member, this);
                Stage stage = new Stage();
                stage.setTitle("Health Check");
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void editProgramAction(ActionEvent actionEvent) {
        Program program = programTable.getSelectionModel().getSelectedItem();
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/program.fxml"));
            root = fxmlLoader.load();
            ProgramController controller = fxmlLoader.<ProgramController>getController();
            controller.setupProgramController(program, member, this);
            Stage stage = new Stage();
            stage.setTitle("Program");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteProgramAction(ActionEvent actionEvent) {
        Program program = programTable.getSelectionModel().getSelectedItem();

        member.deleteProgram(program);
        programs.remove(program);
    }

    @FXML
    private void addNewProgram(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/program.fxml"));
            root = fxmlLoader.load();
            ProgramController controller = fxmlLoader.<ProgramController>getController();
            controller.setupProgramController(null, member, this);
            Stage stage = new Stage();
            stage.setTitle("Program");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteHealthCheckAction(ActionEvent actionEvent) {
        HealthCheck hc = healthCheckTable.getSelectionModel().getSelectedItem();

        member.deleteHealthCheck(hc);
        healthChecks.remove(hc);
    }

    @FXML
    public void addNewHealthCheck(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/healthCheck.fxml"));
            root = fxmlLoader.load();
            HealthCheckController controller = fxmlLoader.<HealthCheckController>getController();
            controller.setupHealthCheckController(null, member, this);
            Stage stage = new Stage();
            stage.setTitle("Health Check");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void close(ActionEvent event) {
        if(!saveBtn.isDisabled()) {
            showSaveDialog();
        } else {
            stage.close();
        }
    }

    private void showSaveDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Save?");
        alert.setHeaderText("Would you like to save outstanding changes?");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");
        ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(yes, no, cancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == yes){
            save(null);
            stage.close();
            alert.close();
        } else if (result.get() == no) {
            stage.close();
            alert.close();
        } else {
            alert.close();
        }
    }

    @FXML
    private void save(ActionEvent event) {
        if(member == null) {
            member = new Member(firstNameTF.getText(), lastNameTF.getText());
            controller.addMember(member);
        }
        member.setFirstName(firstNameTF.getText());
        member.setLastName(lastNameTF.getText());
        member.setDateOfBirth(dateOfBirthDP.getValue());
        member.setGender(gender.getSelectedToggle() == female ? Gender.FEMALE : Gender.MALE);

        controller.updateTable();

        programToolbar.setDisable(false);
        healthCheckToolbar.setDisable(false);
        stage.setTitle(member.toString());
        saveBtn.setDisable(true);

    }
    /** Methods **/

    private void setupTables() {
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        dateAddedCol.setCellValueFactory(new PropertyValueFactory<>("dateAdded"));
        lastModifiedCol.setCellValueFactory(new PropertyValueFactory<>("lastModified"));
        programTable.setItems(programs);

        personalTrainerCol.setCellValueFactory(new PropertyValueFactory<>("Personal Trainer"));
        dateAddedHCCol.setCellValueFactory(new PropertyValueFactory<>("dateAdded"));
        lastModifiedHCCol.setCellValueFactory(new PropertyValueFactory<>("lastModified"));
        healthCheckTable.setItems(healthChecks);

        healthCheckTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    editHealthCheckAction(null);
                }
            }
        });

        programTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    editProgramAction(null);
                }
            }
        });

        programTable.setPlaceholder(new Label("No programs added"));
        healthCheckTable.setPlaceholder(new Label("No health checks added"));
    }

    private String getAge() {

        LocalDate dob = dateOfBirthDP.getValue();
        LocalDate now = LocalDate.now();
        Long age = ChronoUnit.YEARS.between(dob, now);

        return age.toString();
    }

    private void setupListeners() {
        MyChangeListener listener = new MyChangeListener(saveBtn);
        firstNameTF.textProperty().addListener(listener);
        lastNameTF.textProperty().addListener(listener);
        dateOfBirthDP.armedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (dateOfBirthDP.getValue() != null) {
                    ageLabel.setText("(Age: " + getAge() + ")");
                }
                    saveBtn.setDisable(false);
            }
        });
        gender.selectedToggleProperty().addListener(listener);
    }

    public void setupMemberController(Member member, MainController controller) {
        this.controller = controller;

        if(member != null) {
            this.member = member;
            firstNameTF.setText(member.getFirstName());
            lastNameTF.setText(member.getLastName());
            if(member.getDateOfBirth() != null) {
                dateOfBirthDP.setValue(member.getDateOfBirth());
                ageLabel.setText("(Age: " + getAge() + ")");
            }
            gender.selectToggle(member.getGender() == Gender.MALE ? male : female);
            programs.addAll(member.getPrograms());
            healthChecks.addAll(member.getHealthChecks());
        } else {
            programToolbar.setDisable(true);
            healthCheckToolbar.setDisable(true);
        }
        saveBtn.setDisable(true);
    }

    public void updateTables() {
        healthCheckTable.getColumns().get(0).setVisible(false);
        healthCheckTable.getColumns().get(0).setVisible(true);
        programTable.getColumns().get(0).setVisible(false);
        programTable.getColumns().get(0).setVisible(true);
    }

    public void setStage(Stage stage) {
        this.stage = stage;

        if(member != null) {
            stage.setTitle(member.toString());
        } else {
            stage.setTitle("New Member");
        }

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                if(!saveBtn.isDisabled()) {
                    showSaveDialog();
                } else {
                    stage.close();
                }
            }
        });
    }

}
