package Interface;

import ClassesBase.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InterfaceGrafica extends Application {
    
    /** 
     * Classe que executa o sistema.
     * @author Grupo Felipe Cardoso, João Medina, Vinicius Santa Catarina e Antônio Francisco.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        launch(args);

    }

    
    /** 
     * Método que carrega o arquivo fxml que corresponde a interface gráfica da aplicação
     * Atribui a cena ao objeto "scene"
     * Cria objetos das classes "List" e atribui às variáveis da classe "LocadoraVeículos"
     * @param primaryStage Representa a tela pricipal da aplicação JavaFx 
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Interface.fxml"));
        Scene scene = new Scene(root);
        VetorCategoria vetorCategoria = new VetorCategoria(15);
        VetorClientes vetorClientes = new VetorClientes(15);
        ListaLocacoes listaLocacoes = new ListaLocacoes();
        VetorVeiculos vetorVeiculos = new VetorVeiculos(15);
        // a leitura fica aqui embaixo


        LocadoraVeiculos.setVetorCategoria(vetorCategoria);
        LocadoraVeiculos.setVetorClientes(vetorClientes);
        LocadoraVeiculos.setVetorVeiculos(vetorVeiculos);
        LocadoraVeiculos.setListaLocacoes(listaLocacoes);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}



