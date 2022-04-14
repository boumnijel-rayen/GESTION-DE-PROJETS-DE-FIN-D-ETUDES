/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpooavance;

import MyClass.tableViewStructure;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ConsulterPfeEncadrantController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private int id;
    
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    Statement st1;
    ResultSet rs1;
    Connection con;
    
    @FXML
    Button btn;
    
    @FXML
    private TableView<tableViewStructure> table;
    
    @FXML
    private TableColumn<tableViewStructure, Integer> num_PFE;

    @FXML
    private TableColumn<tableViewStructure, String> sujet;

    @FXML
    private TableColumn<tableViewStructure, String> entreprise_A;

    @FXML
    private TableColumn<tableViewStructure, String> nom;

    @FXML
    private TableColumn<tableViewStructure, String> prenom;

    @FXML
    private TableColumn<tableViewStructure, String> email;
    
    @FXML
    private TableColumn<tableViewStructure, String> emailB;
    
    ObservableList<tableViewStructure> lst = FXCollections.observableArrayList();
    
    @FXML
    private void showID(ActionEvent event){
        System.out.println(id);
    }
    
    @FXML
    private void showPfesList(ActionEvent event){
        num_PFE.setCellValueFactory(new PropertyValueFactory<tableViewStructure, Integer>("num"));
        sujet.setCellValueFactory(new PropertyValueFactory<tableViewStructure, String>("sujet"));
        entreprise_A.setCellValueFactory(new PropertyValueFactory<tableViewStructure, String>("enreprise"));
        nom.setCellValueFactory(new PropertyValueFactory<tableViewStructure, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<tableViewStructure, String>("prenom"));
        email.setCellValueFactory(new PropertyValueFactory<tableViewStructure, String>("email"));
        emailB.setCellValueFactory(new PropertyValueFactory<tableViewStructure, String>("emailB"));
        
        try {
            String ur = "jdbc:mysql://localhost:3306/projetjava";
            con = DriverManager.getConnection(ur,"root","");
            st = con.createStatement();
            rs = st.executeQuery("select * from pfe where id_EN="+id);
            
            while(rs.next()){
                tableViewStructure t = new tableViewStructure();
                t.setNum(rs.getInt("num_PFE"));
                t.setSujet(rs.getString("sujet"));
                t.setEnreprise(rs.getString("entreprise_A"));

                    int i=0;
                    st1 = con.createStatement();
                    rs1 = st1.executeQuery("select nom,prenom,email from etudiant where num_PFE="+rs.getInt("num_PFE"));

                    while(rs1.next()){
                        if (i==0){
                            t.setNom(rs1.getString("nom"));
                            t.setPrenom(rs1.getString("prenom"));
                            t.setEmail(rs1.getString("email"));
                            i++;
                        }else{
                            t.setEmailB(rs1.getString("email"));
                        }
                    }
                    

                lst.add(t);
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        table.setItems(lst);
    }
    
    @FXML
    private void back(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("espaceEnseignant.fxml"));
        
        Parent root = loader.load();
        
        EspaceEnseignantController esEn = loader.getController();
        esEn.getID(id);
        Stage stage = new Stage();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/CSS/espaceEtudiantStyle.css");
        
        stage.setScene(scene);
        stage.show();
        ((Stage)btn.getScene().getWindow()).close();
    }
    
    public void getID(int id){
        this.id = id;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
