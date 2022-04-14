/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpooavance;


import java.io.IOException;
import java.net.URL;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.sql.*;
import java.sql.SQLException;
import javafx.scene.control.Button;


/**
 * FXML Controller class
 *
 * @author asus
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    

    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    Connection con;
    
    @FXML
    Button button;
    

    
    @FXML
    private void connexion(ActionEvent event) throws IOException{
        int id=0;
        try {
            String url="jdbc:mysql://localhost:3306/projetjava";
            con = DriverManager.getConnection(url,"root","");
            st = con.createStatement();
            rs = st.executeQuery("select * from etudiant");
            
            rs.next();
            rs.next();
            rs.next();
            id = rs.getInt("id_E");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("espaceEtudiant.fxml"));
        
        Parent root = loader.load();
        
        espaceEtudiantController esE = loader.getController();
        esE.getID(id);
        Stage stage = new Stage();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/CSS/espaceEtudiantStyle.css");
        
        stage.setScene(scene);
        stage.show();
        ((Stage)button.getScene().getWindow()).close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
