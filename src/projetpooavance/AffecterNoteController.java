/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpooavance;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AffecterNoteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private int id;
    
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    Connection con;
    
    @FXML
    Button btn;
    
    @FXML
    private TextField note;
    
    @FXML
    private ComboBox<Integer> liste;
    
    ObservableList<Integer> lst = FXCollections.observableArrayList();
    
    @FXML
    private void showID(ActionEvent event){
        System.out.println(id);
    }
    
    @FXML
    private void affecterNote(ActionEvent event){
        if (liste.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("erreur");
            alert.setHeaderText("Results:");
            alert.setContentText("choisissez la PFE à évalué");
            alert.showAndWait();
        }else{
            if (note.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("erreur");
                alert.setHeaderText("Results:");
                alert.setContentText("saisir la note");
                alert.showAndWait();
            }else{
                Double n=0.0;
                try{
                    n = Double.parseDouble(note.getText());
                }catch(Exception e){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("erreur");
                    alert.setHeaderText("Results:");
                    alert.setContentText("note invalide !");
                    alert.showAndWait();
                }
                if( (n<0) || (n>20) ){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("erreur");
                    alert.setHeaderText("Results:");
                    alert.setContentText("note invalide !");
                    alert.showAndWait();
                }else{
                    pfe p = new pfe();
                    p.setNum_PFE(liste.getSelectionModel().getSelectedItem());
                    p.setNote(n);
                    p.affecterNote();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("success");
                    alert.setHeaderText("Results:");
                    alert.setContentText("note affecté avec success!");
                    alert.showAndWait();
                } 
            }
        }
    }
    
    @FXML
    private void chargerPFEs(ActionEvent event){
        try {
            String ur = "jdbc:mysql://localhost:3306/projetjava";
            con = DriverManager.getConnection(ur,"root","");
            st = con.createStatement();
            rs = st.executeQuery("select * from pfe where etat='en cours' and id_R="+id);
            
            while(rs.next()){
                lst.add(rs.getInt("num_PFE"));
            }
            
            
            } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        liste.setItems(lst);
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
