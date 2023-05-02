package Interface;

import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import ClassesBase.*;
import Bib.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;


public class MenuCategoriaTela implements Initializable{
   @FXML
    private TextField identificadorCategoria;

    @FXML
    private TextField nomeCategoria;

    @FXML
    private Button removerCategoria;

    @FXML
    private Button cadastrarCategoria;

    @FXML
    private Button verificarCategoria;

    @FXML
    private Button dadosCategorias;

    @FXML
    private Button voltarMenu;

    @FXML
    private VBox rootVBox2;

    private VetorCategoria vetorCategoria;
    private VetorVeiculos vetorVeiculos;

    
    /** 
     * Atribui a variável "vetorClientes" o vetor que está sendo retornada pelo método getVetorClientes
     * Adiciona os elementos do array ao vetor de itens do objeto "estados"
     * Chama o método limaparCampos que realiza o clear das textfield
     * @param arg0 objeto que representa localização da fonte de dados da interface
     * @param arg1 objeto que representa os recursos usados na interface, como textos e imagens 
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        vetorCategoria = LocadoraVeiculos.getVetorCategoria();
        vetorVeiculos = LocadoraVeiculos.getVetorVeiculos();
        limparCampos(null);
    }

    
    /** 
     * Declara as variáveis que serão usadas para armazenar as informações do cliente
     * Tenta realizar a leitura do CPF a partir do componente gráfico "CPFCliente", se for inválido ou já existir gera uma mensagem de erro
     * Tenta realizar a leitura do CNH a partir do componente gráfico "CNHCliente", se for inválido ou já existir gera uma mensagem de erro
     * Tenta realizar a leitura do nome do cliente a partir do componente gráfico "nomeCliente", se for inválido ou já existir gera uma mensagem de erro
     * Tenta realizar a leitura do telefone a partir do componente gráfico "telefoneCliente", se for inválido ou já existir gera uma mensagem de erro
     * Cria um cliente utilizando os dados das variáveis 
     * Adiciona o cliente a lista
     * Verifica se o cliente foi adicionado à lista de clientes. Se sim, exibe uma mensagem de sucesso e chama o método limparCampos passando null como argumento.
     * @see javafx.fxml.FXML
     * @param event
     */
    @FXML
    void cadastrarCategoria(ActionEvent event) {
        String nome = null;
        int identificador = 0;

        try {
            identificador = Utility.lerInteiro(identificadorCategoria.getText());
            if (vetorCategoria.tamanho() != 0) {
                if (vetorCategoria.contemId(identificador)) {
                    throw new InputMismatchException();
                }
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Identificador inválido ou já existente!");
            alert.showAndWait();
        }

        try {
            nome = Utility.lerNome(nomeCategoria.getText());
        } catch (InputMismatchException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Nome inválido (APENAS LETRAS)!");
            alert.showAndWait();
        }

        Categoria categoria = new Categoria(identificador, nome);

        if(nome != null && identificador == 0) {
            vetorCategoria.adiciona(categoria);
        }

        if (vetorCategoria.contemId(identificador)) {
            limparCampos(null);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Operação concluída!");
            alert.setHeaderText(null);
            alert.setContentText("Cliente adicionado com sucesso!");
            alert.showAndWait();
        }
    }

    
    /** 
     * @see javafx.fxml.FXML
     * @param event
     * Método que realiza a exclusão do cliente a partir do CPF do mesmo.
     * Caso o CPF não esteja cadastrado no sistema, é lançada uma exceção.
     * Se o cliente for excluído com sucesso, é exibida uma mensagem avisando o administrador.
     * Caso não encontre o PCF, é exibida uma mensagem de erro.
     */
    @FXML
    void removerCategoria(ActionEvent event) {
        int identificador = 0;
        
        try {
            identificador = Utility.lerInteiro(identificadorCategoria.getText());
            if (!(vetorVeiculos.contemCategoria(identificador))) {
                if (vetorCategoria.removeId(identificador)) {
                    limparCampos(null);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Operação concluída!");
                    alert.setHeaderText(null);
                    alert.setContentText("Categoria removida com sucesso!");
                    alert.showAndWait();
                }
            } else {
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Identificador inválido, não existente no sistema ou possui veículo atrelado!");
            alert.showAndWait();
        }
    }

    
    /** 
     * @see javafx.fxml.FXML
     * @param event
     * Método que realiza a verificação do cliente a partir do CPF do mesmo.
     * Se o cliente existir, é exibida uma mensagem avisando o administrador.
     * Caso não encontre o CPF, é exibida uma mensagem de erro avisando o adm que o CPF não está cadastrado no sistema.
     * Se o CPF digitado for inválido, é exibida uma mensagem de erro avisando o adm.
     *
     */
    @FXML
    void verificarCategoria(ActionEvent event) {
        int identificador = 0;

        try {
            identificador = Utility.lerInteiro(identificadorCategoria.getText());
            if (vetorCategoria.contemId(identificador)) {
                limparCampos(null);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Operação concluída!");
                alert.setHeaderText(null);
                alert.setContentText("A categoria de identificador: " + identificador + ", está cadastrada no sistema! Nome da Categoria: " + 
                vetorCategoria.getCategoriaID(identificador).getNome());
                alert.showAndWait();
            } else {
                limparCampos(null);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Operação concluída!");
                alert.setHeaderText(null);
                alert.setContentText("A categoria de identificador: " + identificador + ", não encontra-se cadastrada no sistema!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Categoria inválida! (APENAS NÚMEROS)");
            alert.showAndWait();
        }
    }

    
    /** 
     * @see javafx.fxml.FXML
     * @param event
     * Esse método "limpa" os valores contidos nas caixas de texto. 
     *
     *
     */
    @FXML
    void limparCampos(ActionEvent event) {
            identificadorCategoria.clear();
            nomeCategoria.clear();
    }

    
    /** 
     * @see javafx.fxml.FXML
     * @param event
     * Carrega o arquivo FXML que contém o código XML que define a estrutura da interface para o usuário.
     * Caso tenha uma exceção durante o processo, é capturada e exibida ao usuário.
      *
     */
    @FXML
    void menuDadosCategorias(ActionEvent event) {
        try {
            VBox VBoxMenuDadosClientes = FXMLLoader.load(getClass().getResource("MenuDadosCategorias.fxml"));
            rootVBox2.getChildren().setAll(VBoxMenuDadosClientes);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    /** 
     * @see javafx.fxml.FXML
     * @param event
     * Carrega o arquivo FXML que contém o código XML que define a estrutura da interface para o usuário.
     * Caso tenha uma exceção durante o processo, é capturada e exibida ao usuário.
     */
    @FXML
    void voltarMenu(ActionEvent event) {
        try {
            VBox VBoxInterface = FXMLLoader.load(getClass().getResource("Interface.fxml"));
            rootVBox2.getChildren().setAll(VBoxInterface);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}