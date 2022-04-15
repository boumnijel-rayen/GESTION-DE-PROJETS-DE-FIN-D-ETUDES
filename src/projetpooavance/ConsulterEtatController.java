/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpooavance;

import MyClass.etudiant;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ConsulterEtatController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private int id;
    
    @FXML
    Button btn;
    @FXML
    Label etat;
    @FXML
    Label encadrant;
    @FXML
    Label rapporteur;
    @FXML
    Label note;
    
    @FXML
    private void showID(ActionEvent event){
        System.out.println(id);
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
    
    public void getID(int id){
        this.id = id;
    }
    
    @FXML
    private void showNote(ActionEvent event){
        String etat1 ;
        etudiant e = new etudiant();
        e.setId(id);
        etat1 = e.recupererEtat();
        if (etat1.equals("evalue")){
            note.setText(e.showNote().toString());
        }else{
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("ERROR");
            alert1.setHeaderText("Results:");
            alert1.setContentText("Vous ne pouvez pas faire ça dans cette etape !");
            alert1.showAndWait();
        }
    }
    
    @FXML
    private void showRapporteur(ActionEvent event){
        String etat1 ;
        etudiant e = new etudiant();
        e.setId(id);
        etat1 = e.recupererEtat();
        if( (etat1.equals("en cours")) || (etat1.equals("evalue")) ){
            rapporteur.setText(e.showInfosRapporteur());
        }else{
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("ERROR");
            alert1.setHeaderText("Results:");
            alert1.setContentText("Vous ne pouvez pas faire ça dans cette etape !");
            alert1.showAndWait();
        }
    }
    
    @FXML
    private void showEncadrant(ActionEvent event){
        String etat1 ;
        etudiant e = new etudiant();
        e.setId(id);
        etat1 = e.recupererEtat();
        if ( (etat1.equals("en attente R")) || (etat1.equals("encadre")) || (etat1.equals("en cours")) || (etat1.equals("evalue")) ){
            encadrant.setText(e.showInfosEncadrant());       
        }else{
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("ERROR");
            alert1.setHeaderText("Results:");
            alert1.setContentText("Vous ne pouvez pas faire ça dans cette etape !");
            alert1.showAndWait();
        }
    }
    
    @FXML
    private void showEtat(ActionEvent event){
        etudiant e = new etudiant();
        e.setId(id);
        switch(e.recupererEtat()){
            case "en attente E" : 
                etat.setText("en attente d’encadrement");
                break;
            case "encadre" :
                etat.setText("encadré");
                break;
            case "en attente R" :
                etat.setText("en attente de rapporteur");
                break;
            case "en cours":
                etat.setText("en cours d’évaluation");
                break;
            case "evalue":
                etat.setText("évalué");
                break;    
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
