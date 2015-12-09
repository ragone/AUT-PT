package aut.controller;

import aut.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    public static ObservableList<Member> members = FXCollections.observableArrayList();

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

    /**
     * Add new member and update database
     */
    public void addMember(ActionEvent actionEvent) {
    }

    /**
     * Edit member and update database
     */
    public void editMember(ActionEvent actionEvent) {
    }

    /**
     * Delete member and update database
     */
    public void deleteMember(ActionEvent actionEvent) {
    }
}
