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
    private void switchToScean2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
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
