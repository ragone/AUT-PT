package aut.controller;

import aut.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * TODO: Description of MemberController.
 *
 * @author ragone.
 * @version 9/12/15
 */
public class MainController implements Initializable {
    /**
    * FXML variables
    */
    @FXML
    private TableView<Member> memberTable;
    @FXML
    private TableColumn<Member, String> firstNameCol;
    @FXML
    private TableColumn<Member, String> lastNameCol;
    @FXML
    private TableColumn<Member, String> personalTrainerCol;
    @FXML
    private TableColumn<Member, Date> dateAddedCol;

    /**
     * My variables
     */
    public ObservableList<Member> members = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupMemberTable();
    }

    private void setupMemberTable() {
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        personalTrainerCol.setCellValueFactory(new PropertyValueFactory<>("personalTrainer"));
        dateAddedCol.setCellValueFactory(new PropertyValueFactory<>("dateAdded"));
        memberTable.setItems(members);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    /**
     * Open new window to add member
     */
    @FXML
    public void addMemberAction(ActionEvent actionEvent) {
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/member.fxml"));
            root = fxmlLoader.load();
            MemberController controller = fxmlLoader.<MemberController>getController();
            controller.setupMemberController(null, this);
            Stage stage = new Stage();
            stage.setTitle("Member");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Edit selected Member from table in new window
     */
    @FXML
    public void editMemberAction(ActionEvent actionEvent) {
        Member selectedMember = memberTable.getSelectionModel().getSelectedItem();
        if (selectedMember != null) {
            Parent root;
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/member.fxml"));
                root = fxmlLoader.load();
                MemberController controller = fxmlLoader.<MemberController>getController();
                controller.setupMemberController(selectedMember, this);
                Stage stage = new Stage();
                stage.setTitle("Member");
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Delete selected Member from table
     */
    @FXML
    public void deleteMemberAction(ActionEvent actionEvent) {
        Member selectedMember = memberTable.getSelectionModel().getSelectedItem();
        members.remove(selectedMember);
    }

    public void updateTable() {
        memberTable.getColumns().get(0).setVisible(false);
        memberTable.getColumns().get(0).setVisible(true);
    }
}
