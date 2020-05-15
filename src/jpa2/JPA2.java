/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa2;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Maram Tanani
 */
public class JPA2 extends Application{

    /**
     * @param args the command line arguments
     */
    public void start(Stage primaryStage) throws Exception {
        Pane jpaPane = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(jpaPane);
        primaryStage.setTitle("JPA App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
