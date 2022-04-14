/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpooavance;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    
    @FXML
    Button btn;
    
    @FXML
    private void showID(ActionEvent event){
        System.out.println(id);
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
