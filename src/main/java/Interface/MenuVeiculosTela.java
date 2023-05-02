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

public class MenuVeiculosTela implements Initializable {

    @FXML
    private TextField placaVeiculo;

    @FXML
    private TextField anoVeiculo;

    @FXML
    private TextField lugaresVeiculo;

    @FXML
    private TextField modeloVeiculo;

    @FXML
    private TextField potenciaVeiculo;

    @FXML
    private TextField marcaVeiculo;

    @FXML
    private TextField categoriaVeiculo;

    @FXML
    private Button removerVeiculo;

    @FXML
    private Button cadastrarVeiculo;

    @FXML
    private Button verificarVeiculo;

    @FXML
    private Button dadosVeiculos;

    @FXML
    private Button voltarMenu;

    @FXML
    private VBox rootVBox2;

    private VetorVeiculos vetorVeiculos;
    private VetorCategoria vetorCategoria;
    private ListaLocacoes listaLocacoes;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        listaLocacoes = LocadoraVeiculos.getListaLocacoes();
        vetorCategoria = LocadoraVeiculos.getVetorCategoria();
        vetorVeiculos = LocadoraVeiculos.getVetorVeiculos();
        limparCampos(null);
    }

    @FXML
    void cadastrarVeiculo(ActionEvent event) {
        String placa = null;
        String modelo = null;
        int ano = 0;
        int potencia = 0;
        int lugares = 0;
        String marca = null;
        Categoria categoria = null;

        try {
            placa = Utility.lerPlaca(placaVeiculo.getText());
            if (vetorVeiculos.contemPlaca(placa)) {
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Placa inválida ou já cadastrada!");
            alert.showAndWait();
        }

        try {
            modelo = Utility.lerNome(modeloVeiculo.getText());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Modelo inválido!");
            alert.showAndWait();
        }

        try {
            ano = Utility.lerInteiro(anoVeiculo.getText());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Ano do veículo inválido (APENAS NÚMEROS)!");
            alert.showAndWait();
        }

        try {
            potencia = Utility.lerInteiro(potenciaVeiculo.getText());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Potência inválida (APENAS NÚMEROS)!");
            alert.showAndWait();
        }

        try {
            lugares = Utility.lerInteiro(lugaresVeiculo.getText());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Número de lugares inválido (APENAS NÚMEROS)!");
            alert.showAndWait();
        }

        try {
            marca = Utility.lerNome(marcaVeiculo.getText());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Modelo inválido!");
            alert.showAndWait();
        }

        try {
            categoria = Utility.lerCategoria(categoriaVeiculo.getText(), vetorCategoria);
        } catch (InputMismatchException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Categoria inválida!");
            alert.showAndWait();
        }

        Veiculo veiculo = new Veiculo(placa, modelo, marca, ano, potencia, lugares, categoria);
        if (placa != null && ano == 0 && modelo != null && categoria != null && marca != null && potencia == 0 && lugares == 0) {
            vetorVeiculos.adiciona(veiculo);
        }

        if (vetorVeiculos.contemPlaca(placa)) {
            limparCampos(null);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Operação concluída!");
            alert.setHeaderText(null);
            alert.setContentText(
                    "Veículo de placa " + Utility.escreverPlaca(placa) + " adicionado com sucesso!");
            alert.showAndWait();
        }  
    }

    /**
     * @param event Define a ação do botão.
     * Método para remover veículo do sistema pela placa.
     * Caso o veículo seja removido, é exibida uma mensagem de sucesso.
     * Se não, é lançada uma exceção.
     * Nesta exceção, é exibida uma mensagem para o adm informando que
     * a placa é inválida ou não contemPlacante no sistema.
     */
    @FXML
    void removerVeiculo(ActionEvent event) {
        String placa = null;

        try {
            placa = Utility.lerPlaca(placaVeiculo.getText());
            if (!(listaLocacoes.contemPlaca(placa))) {
                if (vetorVeiculos.removePlaca(placa)) {
                    limparCampos(null);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Operação concluída!");
                    alert.setHeaderText(null);
                    alert.setContentText("Veículo removido com sucesso!");
                    alert.showAndWait();
                }
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Placa inválida, não existente no sistema ou atrelada à uma locação!");
            alert.showAndWait();
        }
    }

    /**
     * @param event Define a ação do botão.
     * Método feito para verificar um veículo a partir da placa
     * fornecida pelo admin.
     * Caso a placa já esteja cadastrada no sistema, é exibida uma
     * mensagem informando isto.
     * Se não, é exibida uma mensagem informando que ela não esta no
     * sistema.
     * Caso o valor informado não seja válido, é exibido uma mensagem
     * avisando.
     */
    @FXML
    void verificarVeiculo(ActionEvent event) {
        String placa = null;

        try {
            placa = Utility.lerPlaca(placaVeiculo.getText());
            if (vetorVeiculos.contemPlaca(placa)) {
                limparCampos(null);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Operação concluída!");
                alert.setHeaderText(null);
                alert.setContentText(
                        "O veículo de placa: " + Utility.escreverPlaca(placa) + ", está cadastrado no sistema!");
                alert.showAndWait();
            } else {
                limparCampos(null);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Operação concluída!");
                alert.setHeaderText(null);
                alert.setContentText(
                        "A placa: " + Utility.escreverPlaca(placa) + ", não encontra-se cadastrada no sistema!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Placa inválida!");
            alert.showAndWait();
        }
    }

    /**
     * @param event
     * Limpa os campos dos valores digitados anteriormente nas caixas
     * de texto.
     */
    @FXML
    void limparCampos(ActionEvent event) {
        placaVeiculo.clear();
        anoVeiculo.clear();
        modeloVeiculo.clear();
        potenciaVeiculo.clear();
        categoriaVeiculo.clear();
        lugaresVeiculo.clear();
        marcaVeiculo.clear();
    }

    /**
     * @param event Determina a ação de acessar o MenuClientes
     * Carrega o arquivo "MenuVeiculos.fxml" e o atribui ao objeto           
     * "VBoxMenuVeiculos"             
     * Remove os elementos filhos do objeto "rootVBox" e adiciona o            
     * "VBoxMenuVeiculos como um novo filho"
     */
    @FXML
    void menuDadosVeiculos(ActionEvent event) {
        try {
            VBox VBoxMenuDadosVeiculos = FXMLLoader.load(getClass().getResource("MenuDadosVeiculos.fxml"));
            rootVBox2.getChildren().setAll(VBoxMenuDadosVeiculos);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * @param event 
     * Determina a ação de voltar ao menu principal
     * Carrega o arquivo "Interface.fxml" e o atribui ao objeto
     * "VBoxInterface"
     * Remove os elementos filhos do objeto "rootVBox" e adiciona o
     * "VBoxInterface como um novo filho"
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
