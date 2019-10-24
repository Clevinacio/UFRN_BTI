package br.imd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Principal extends Application {
    private Stage primeiro;
    private BorderPane tlPrincipal;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primeiro = primaryStage;
        primeiro.setTitle("Sistema Teste");
        initPrincipal();
    }

    private void initPrincipal() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Principal.class.getResource("visao/TelaPrincipal.fxml"));
            tlPrincipal = (BorderPane) loader.load();

            Scene scene = new Scene(tlPrincipal);
            primeiro.setScene(scene);
            primeiro.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
