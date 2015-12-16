package aut.controller;

import aut.model.Member;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
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
    @FXML
    private Button addBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button deleteBtn;

    /**
     * My variables
     */
    public final ObservableList<Member> members = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addBtn.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.PLUS));
        editBtn.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.EDIT));
        deleteBtn.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.TRASH));

        List<Object> dbMembers = HibernateUtil.getObject("Member");

        for (Object obj : dbMembers) {
            Member member = (Member) obj;
            members.add(member);

        }

        setupMemberTable();
    }

    private void setupMemberTable() {
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        personalTrainerCol.setCellValueFactory(new PropertyValueFactory<>("personalTrainer"));
        dateAddedCol.setCellValueFactory(new PropertyValueFactory<>("dateAdded"));
        memberTable.setItems(members);
        memberTable.setOnMousePressed(event -> {
            if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                editMemberAction();
            }
        });
        memberTable.setPlaceholder(new ImageView(new Image("images/bg.jpg")));
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/member.fxml"));
            root = fxmlLoader.load();
            MemberController controller = fxmlLoader.<MemberController>getController();
            controller.setupMemberController(null, this);
            Stage stage = new Stage();
            controller.setStage(stage);
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
    public void editMemberAction() {
        Member selectedMember = memberTable.getSelectionModel().getSelectedItem();
        if (selectedMember != null) {
            Parent root;
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/member.fxml"));
                root = fxmlLoader.load();
                MemberController controller = fxmlLoader.<MemberController>getController();
                controller.setupMemberController(selectedMember, this);

                Stage stage = new Stage();
                controller.setStage(stage);
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
        HibernateUtil.deleteObject(selectedMember);
    }

    public void updateTable() {
        memberTable.getColumns().get(0).setVisible(false);
        memberTable.getColumns().get(0).setVisible(true);
    }

}
