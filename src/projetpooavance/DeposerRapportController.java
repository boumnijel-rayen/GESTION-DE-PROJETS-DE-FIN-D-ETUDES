/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpooavance;

import MyClass.etudiant;
import java.awt.Image;
import java.io.File;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class DeposerRapportController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private int id;
    private static String path="";
    
    @FXML
    Button btn;
    
    
    final FileChooser fc = new FileChooser();
    
    @FXML
    private void diposerFile(ActionEvent event){
        fc.setTitle("choisir votre rapport");
        File file = fc.showOpenDialog(null);
        path = file.getPath();
    }
    
    @FXML
    private void deposerRapport(ActionEvent event){
        etudiant e = new etudiant();
        e.setId(id);
        if (path != ""){
            if (e.isHavePfe()){
                if (e.isEtatEncadre()){
                    e.ajouterRapport(path);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Test Connection");
                    alert.setHeaderText("Results:");
                    alert.setContentText("rapport deposé avec success !");
                    alert.showAndWait();
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Test Connection");
                    alert.setHeaderText("Results:");
                    alert.setContentText("vous ne pouvez pas faire ça dans cette etape !");
                    alert.showAndWait();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Test Connection");
                alert.setHeaderText("Results:");
                alert.setContentText("étudiant n'a pas encore un pfe");
                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Test Connection");
            alert.setHeaderText("Results:");
            alert.setContentText("choisissez votre rapport");
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
    
    public void getID(int id){
        this.id = id;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
