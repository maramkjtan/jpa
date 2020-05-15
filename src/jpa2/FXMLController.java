/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa2;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
/**
 * FXML Controller class
 *
 * @author Maram Tanani
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField tfid;
    @FXML
    private TextField tfname;
    @FXML
    private TextField tfmajor;
    @FXML
    private TextField tfgrade;
    @FXML
    private TableView<Students> tableview;
    @FXML
    private TableColumn<Students, Integer> tcid;
    @FXML
    private TableColumn<Students, String> tcname;
    @FXML
    private TableColumn<Students, String> tcmajor;
    @FXML
    private TableColumn<Students, Double> tcgrade;
    @FXML
    private Button Viewbtn;
    @FXML
    private Button addbtn;
    @FXML
    private Button editbtn;
    @FXML
    private Button deletebtn;
    @FXML
    private Button addcousebtn;
    private EntityManagerFactory emf;
    private Students s;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       tcid.setCellValueFactory(new PropertyValueFactory("id"));
        tcname.setCellValueFactory(new PropertyValueFactory("name"));
        tcmajor.setCellValueFactory(new PropertyValueFactory("dept_id"));
        tcmajor.setCellValueFactory(new PropertyValueFactory("salary"));
        this.emf = Persistence.createEntityManagerFactory("JPA2PU");
    }    

    @FXML
    private void buttonViewHandle(ActionEvent event) {
        EntityManager em = emf.createEntityManager();
        List<Students> s = em.createNamedQuery("student.findAll").getResultList();
        tableview.getItems().setAll(s);
        em.close();
    }

    @FXML
    private void buttonAddHandle(ActionEvent event) {
        Students students = new Students();
        students.setName(tfname.getText());
        students.setMajor(tfmajor.getText());
        students.setGrade(Double.parseDouble(tfgrade.getText()));
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(students);
        em.getTransaction().commit();
        em.close();
    }

    @FXML
    private void buttonEditHandle(ActionEvent event) {
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) {
        EntityManager em = emf.createEntityManager();
        Student s = em.find(Students.class, tableView.getSelectionModel().getSelctionItem().getId());
        em.getTransaction().begin();
        em.remove(s);
        em.getTransaction().commit();
    }

    @FXML
    private void buttonAddcourceHandle(ActionEvent event) {
    }
    
    @FXML
    void textfieldGradeHandle(ActionEvent event) {

    }

    @FXML
    void textfieldIdHandle(ActionEvent event) {
       
    }

    @FXML
    void textfieldMajorHandle(ActionEvent event) {

    }

    @FXML
    void textfieldNameHandle(ActionEvent event) {

    }

    
}
