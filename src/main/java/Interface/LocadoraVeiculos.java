package Interface;

import ClassesBase.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LocadoraVeiculos {

    private static VetorClientes vetorClientes;
    private static VetorVeiculos vetorVeiculos;
    private static ListaLocacoes listaLocacoes;

   
    @FXML
    private Button campo_MenuClientes;

    @FXML
    private Button campo_MenuVeiculos;

    @FXML
    private Button campo_MenuLocacoes;

    @FXML
    private VBox rootVBox;

    
    
    /** 
     * Carrega o arquivo "MenuClientes.fxml" e o atribui ao objeto "VBoxMenuClientes"
     * Remove os elementos filhos do objeto "rootVBox" e adiciona o "VBoxMenuClientes como um novo filho"
     * @param event Determina a a��o de acessar o MenuClientes
     */
    @FXML
    void AcessarMenuClientes(ActionEvent event) {
        try {
            VBox VBoxMenuClientes = FXMLLoader.load(getClass().getResource("MenuClientes.fxml"));
            rootVBox.getChildren().setAll(VBoxMenuClientes);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    /** 
     * Carrega o arquivo "MenuLocacoes.fxml" e o atribui ao objeto "VBoxMenuLocacoes"
     * Remove os elementos filhos do objeto "rootVBox" e adiciona o "VBoxMenuLocacoes como um novo filho"
     * @param event Determina a a��o de acessar o MenuLocacoes
     */
    @FXML
    void AcessarMenuLocacoes(ActionEvent event) {
        try {
            VBox VBoxMenuLocacoes = FXMLLoader.load(getClass().getResource("MenuLocacoes.fxml"));
            rootVBox.getChildren().setAll(VBoxMenuLocacoes);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    /** 
     * Carrega o arquivo "MenuVeiculos.fxml" e o atribui ao objeto "VBoxMenuVeiculos"
     * Remove os elementos filhos do objeto "rootVBox" e adiciona o "VBoxMenuVeiculos como um novo filho"
     * @param event Determina a a��o de acessar o MenuVeiculos
     */
    @FXML
    void AcessarMenuVeiculos(ActionEvent event) {
        try {
            VBox VBoxMenuVeiculos = FXMLLoader.load(getClass().getResource("MenuVeiculos.fxml"));
            rootVBox.getChildren().setAll(VBoxMenuVeiculos);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    /** 
     * Atribui um novo valor � uma vari�vel est�tica chamada "vetorClientes"
     * @param vetorClientesNova
     */
    public static void setVetorClientes(VetorClientes vetorClientesNova) {
        vetorClientes = vetorClientesNova;
    }

    
    /** 
     * Retorna o valor de uma vari�vel est�tica chamada "vetorClientes"
     * @return VetorClientes
     */
    public static VetorClientes getVetorClientes() {
        return vetorClientes;
    }

    
    /** 
     * Atribui um novo valor � uma vari�vel est�tica chamada "vetorVeiculos"
     * @param vetorVeiculosNova
     */
    public static void setVetorVeiculos(VetorVeiculos vetorVeiculosNova) {
        vetorVeiculos = vetorVeiculosNova;
    }

    
    /** 
     * Retorna o valor de uma vari�vel est�tica chamada "vetorVeiculos"
     * @return VetorVeiculos
     */
    public static VetorVeiculos getVetorVeiculos() {
        return vetorVeiculos;
    }

    
    /** 
     * Atribui um novo valor � uma vari�vel est�tica chamada "listaLocacoes"
     * @param listaLocacoesNova
     */
    public static void setListaLocacoes(ListaLocacoes listaLocacoesNova) {
        listaLocacoes = listaLocacoesNova;
    }

    
    /** 
     * Retorna o valor de uma vari�vel est�tica chamada "listaLocacoes"
     * @return ListLocacoes
     */
    public static ListaLocacoes getListaLocacoes() {
        return listaLocacoes;
    }

}
