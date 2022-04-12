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

    private Stage stage;
    private Scene scene;
    private Parent parent;
    
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
        
        stage.setScene(new Scene(root));
        stage.show();
        ((Stage)btn.getScene().getWindow()).close();
    }
    
    @FXML
    private void showID(ActionEvent event) throws IOException{
        System.out.println(this.id);
    }
    
    public void getID(int id){
        this.id = id;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
