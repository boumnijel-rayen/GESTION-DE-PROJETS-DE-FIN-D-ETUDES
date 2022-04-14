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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author asus
 */
public class espaceEtudiantController implements Initializable {

    
    private int id;
    
    @FXML
    Button btn;
    
    
    @FXML
    private void openDeposer(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("deposerSujet.fxml"));
        
        Parent root = loader.load();
        
        deposerSujetController ds = loader.getController();
        ds.getID(id);
        Stage stage = new Stage();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/CSS/deposerSujetStyle.css");
        
        stage.setScene(scene);
        stage.show();
        ((Stage)btn.getScene().getWindow()).close();
    }
    
    
    @FXML
    private void deconnecter(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        
        Parent root = loader.load();
        
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        ((Stage)btn.getScene().getWindow()).close();
    }
    
    @FXML
    private void openDeposerRapport(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("deposerRapport.fxml"));
        
        Parent root = loader.load();
        
        DeposerRapportController dr = loader.getController();
        dr.getID(id);
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/CSS/deposerRapportStyle.css");
        
        stage.setScene(scene);
        stage.show();
        ((Stage)btn.getScene().getWindow()).close();
    }
    
    @FXML
    private void openConsulterEtat(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("consulterEtat.fxml"));
        
        Parent root = loader.load();
        
        ConsulterEtatController ce = loader.getController();
        ce.getID(id);
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/CSS/consulterEtatStyle.css");
        
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
