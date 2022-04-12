/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpooavance;

import MyClass.etudiant;
import MyClass.pfe;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class deposerSujetController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Stage stage;
    private Scene scene;
    private Parent parent;
    
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    Connection con;
    
    private int id;
    
    @FXML
    Button btn;
    @FXML
    TextField sujet;
    @FXML
    TextField enA;
    @FXML
    CheckBox binomeCheck;
    @FXML
    ComboBox<Integer> listeID;
    
    
    
    @FXML
    private void deposer(ActionEvent event){
        
        int numP = 0;
        try {
            String ur = "jdbc:mysql://localhost:3306/projetjava";
            con = DriverManager.getConnection(ur,"root","");
            st = con.createStatement();
            rs = st.executeQuery("select max(num_PFE) max from pfe");
            
            rs.next();
            numP = rs.getInt(1);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        pfe pfe = new pfe();
        pfe.setSujet(sujet.getText());
        pfe.setEntraprise_A(enA.getText());
        pfe.setNum_PFE(numP + 1);
        pfe.getEtudiants().add(id);
        if(binomeCheck.isSelected()){
            pfe.getEtudiants().add(listeID.getSelectionModel().getSelectedItem());
        }
        pfe.setEtat("en attente E");
        
        Boolean test = false;
        for(int i=0;i<pfe.getEtudiants().size();i++){
            etudiant e = new etudiant();
            e.setId(pfe.getEtudiants().get(i));
            if ((!test)&&(e.isHavePfe())){
                test = true;
            }
        }
        
        if (!test){
            pfe.deposer();

            for(int i=0;i<pfe.getEtudiants().size();i++){
                etudiant e = new etudiant();
                e.setId(pfe.getEtudiants().get(i));
                e.setNum_PFE(numP+1);
                e.affecterPFE();
            }
                Alert alert1 = new Alert(AlertType.INFORMATION);
		alert1.setTitle("Test Connection");
		alert1.setHeaderText("Results:");
		alert1.setContentText("sujet deposé avec success");

		alert1.showAndWait();
        }else{
                Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Test Connection");
		alert.setHeaderText("Results:");
		alert.setContentText("étudiant avoir déja pfe !");

		alert.showAndWait();
        }
        
        
        
    }
    
    @FXML
    private void back(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("espaceEtudiant.fxml"));
        
        Parent root = loader.load();
        
        espaceEtudiantController esE = loader.getController();
        esE.getID(id);
        Stage stage = new Stage();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/CSS/espaceEtudiantStyle.css");
        
        stage.setScene(scene);
        stage.show();
        ((Stage)btn.getScene().getWindow()).close();
    }
    
    @FXML
    private void charger(ActionEvent event){
        ObservableList<Integer> lst = FXCollections.observableArrayList();

        try {
            String ur = "jdbc:mysql://localhost:3306/projetjava";
            con = DriverManager.getConnection(ur,"root","");
            st = con.createStatement();
            rs = st.executeQuery("select * from etudiant where id_E !="+id);
            while (rs.next()) {                
                lst.add(rs.getInt("id_E"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        listeID.setItems(lst);
    }
    
    public void getID(int id){
        this.id = id;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
