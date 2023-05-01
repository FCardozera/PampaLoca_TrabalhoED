package Interface;

import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import ClassesBase.BibMetodos;
import ClassesBase.Caminhao;
import ClassesBase.Carro;
import ClassesBase.ListVeiculos;
import ClassesBase.Onibus;
import ClassesBase.Veiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MenuVeiculosTela implements Initializable {

    @FXML
    private TextField placaVeiculo;

    @FXML
    private TextField anoVeiculo;

    @FXML
    private TextField diariaVeiculo;

    @FXML
    private MenuButton tipoVeiculo;

    @FXML
    private MenuItem carro;

    @FXML
    private MenuItem onibus;

    @FXML
    private MenuItem caminhao;

    @FXML
    private TextField numPortasVeiculo;

    @FXML
    private TextField numPassageirosCarro;

    @FXML
    private TextField mediaKmVeiculo;

    @FXML
    private ChoiceBox<String> opcaoArCondCarro;

    @FXML
    private TextField numPassageirosOnibus;

    @FXML
    private ChoiceBox<String> categoriaOnibus;

    private String[] categorias = { "Leito", "Executivo", "Convencional" };

    @FXML
    private ChoiceBox<String> opcaoArCondOnibus;

    @FXML
    private ChoiceBox<String> opcaoInternetOnibus;

    @FXML
    private TextField numeroEixosCaminhao;

    @FXML
    private TextField cargaMaxCaminhao;

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
    private Pane paneCarro;

    @FXML
    private Pane paneOnibus;

    @FXML
    private Pane paneCaminhao;

    @FXML
    private VBox rootVBox2;

    private String[] opcoes = { "Sim", "Não" };

    private ListVeiculos listaVeiculos;

    /**
     * Inicializa a lista de veículos da locadora de veículos.
     * Esconde os componentes da interface gráfica "paneCarro", "paneCaminhao", e
     * "paneOnibus".
     * Limpa os campos da interface gráfica chamando o método limparCampos.
     * Adiciona opções às listas de opções dos componentes "opcaoArCondCarro",
     * "opcaoArCondOnibus", e "opcaoInternetOnibus".
     * Adiciona categorias à lista de categorias do componente "categoriaOnibus".
     * Esse código parece fazer parte de um sistema de gerenciamento de locações de
     * veículos. Ele inicializa a interface gráfica e prepara os componentes para
     * serem usados pelo usuário.
     * 
     * @param arg0
     * @param arg1
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        listaVeiculos = LocadoraVeiculos.getListaVeiculos();
        paneCarro.setVisible(false);
        paneCaminhao.setVisible(false);
        paneOnibus.setVisible(false);
        limparCampos(null);
        opcaoArCondCarro.getItems().addAll(opcoes);
        opcaoArCondOnibus.getItems().addAll(opcoes);
        opcaoInternetOnibus.getItems().addAll(opcoes);
        categoriaOnibus.getItems().addAll(categorias);
    }

    /**
     * @param event
     * Este método cadastra veículos pela placa dele, caso a placa já
     * exista no sistema, é lançada uma exceção.
     * Após a exceção ser lançada, é exibida uma mensagem avisando ao
     * adm que a placa é inválida ou já esta cadastrada.
     * Também, caso tente utilizar letras no ano ou valor da diária, o
     * sistema exibe uma mensagem de erro.
     * Esta mensagem avisa o adm que só podem ser utilizados números.
     * Após isso, é especificado o tipo de veículo que o adm deseja
     * cadastrar no sistema.
     */
    @FXML
    void cadastrarVeiculo(ActionEvent event) {

        String placa = null;
        String opcaoVeiculo = null;
        int ano = 0;
        double valorDiaria = 0;

        try {
            placa = BibMetodos.lerPlaca(placaVeiculo.getText());
            if (listaVeiculos.existe(placa)) {
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
            ano = BibMetodos.lerInteiro(anoVeiculo.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Ano do veículo inválido (APENAS NÚMEROS)!");
            alert.showAndWait();
        }

        try {
            valorDiaria = BibMetodos.lerDouble(diariaVeiculo.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Valor da Diária do veículo inválido (APENAS NÚMEROS)!");
            alert.showAndWait();
        }

        opcaoVeiculo = tipoVeiculo.getText();

        switch (opcaoVeiculo) {
            case "Carro":
                int numeroPortas = 0, numeroPassageirosCarro = 0;
                float mediaKm = 0;
                String opcaoArCarro = null;
                boolean arCondicionado = false;

                try {
                    numeroPortas = BibMetodos.lerInteiro(numPortasVeiculo.getText());
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro!");
                    alert.setHeaderText(null);
                    alert.setContentText("Número de portas inválido (APENAS NÚMEROS)!");
                    alert.showAndWait();
                }

                try {
                    numeroPassageirosCarro = BibMetodos.lerInteiro(numPassageirosCarro.getText());
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro!");
                    alert.setHeaderText(null);
                    alert.setContentText("Número de passageiros inválido (APENAS NÚMEROS)!");
                    alert.showAndWait();
                }

                try {
                    mediaKm = BibMetodos.lerFloat(mediaKmVeiculo.getText());
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro!");
                    alert.setHeaderText(null);
                    alert.setContentText("Média de Km/l inválido (APENAS NÚMEROS)!");
                    alert.showAndWait();
                }

                opcaoArCarro = opcaoArCondCarro.getValue();

                try {
                    if (opcaoArCarro.equals("Selecione...")) {
                        throw new NullPointerException();
                    }
                } catch (NullPointerException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro!");
                    alert.setHeaderText(null);
                    alert.setContentText("Selecione a opção de Ar Condicionado!");
                    alert.showAndWait();
                }

                if (opcaoArCarro.equals("Sim")) {
                    arCondicionado = true;
                }

                Veiculo carro = new Carro(placa, ano, valorDiaria, numeroPassageirosCarro, numeroPortas, mediaKm,
                        arCondicionado);
                if (!(placa.equals("null") || ano == 0 || valorDiaria == 0 || numeroPassageirosCarro == 0
                        || numeroPortas == 0 || mediaKm == 0 || opcaoArCarro.equals("Selecione..."))) {
                    listaVeiculos.add(carro);
                }

                if (listaVeiculos.existe(placa)) {
                    limparCampos(null);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Operação concluída!");
                    alert.setHeaderText(null);
                    alert.setContentText(
                            "Veículo de placa " + BibMetodos.escreverPlaca(placa) + " adicionado com sucesso!");
                    alert.showAndWait();
                }
                break;

            case "Ônibus":
                int numeroPassageirosOnibus = 0;
                String categoria = null;
                String opcaoArOnibus = null, opcaoInternet = null;
                boolean arCondicionadoOnibus = false, internetOnibus = false;

                try {
                    numeroPassageirosOnibus = BibMetodos.lerInteiro(numPassageirosOnibus.getText());
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro!");
                    alert.setHeaderText(null);
                    alert.setContentText("Número de passageiros inválido (APENAS NÚMEROS)!");
                    alert.showAndWait();
                }

                categoria = categoriaOnibus.getValue();
                opcaoArOnibus = opcaoArCondOnibus.getValue();
                opcaoInternet = opcaoInternetOnibus.getValue();

                try {
                    if (categoria.equals("Selecione...")) {
                        throw new NullPointerException();
                    }
                } catch (NullPointerException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro!");
                    alert.setHeaderText(null);
                    alert.setContentText("Selecione a categoria!");
                    alert.showAndWait();
                }

                try {
                    if (opcaoArOnibus.equals("Selecione...")) {
                        throw new NullPointerException();
                    }
                } catch (NullPointerException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro!");
                    alert.setHeaderText(null);
                    alert.setContentText("Selecione a opção de Ar Condicionado!");
                    alert.showAndWait();
                }

                try {
                    if (opcaoInternet.equals("Selecione...")) {
                        throw new NullPointerException();
                    }
                } catch (NullPointerException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro!");
                    alert.setHeaderText(null);
                    alert.setContentText("Selecione a opção de Internet!");
                    alert.showAndWait();
                }

                if (opcaoArOnibus.equals("Sim")) {
                    arCondicionadoOnibus = true;
                }

                if (opcaoInternet.equals("Sim")) {
                    internetOnibus = true;
                }

                Veiculo onibus = new Onibus(placa, ano, valorDiaria, numeroPassageirosOnibus, categoria, internetOnibus,
                        arCondicionadoOnibus);
                if (!(placa.equals("null") || ano == 0 || valorDiaria == 0 || numeroPassageirosOnibus == 0
                        || categoria.equals("Selecione...") || opcaoArOnibus.equals("Selecione...")
                        || opcaoInternet.equals("Selecione..."))) {
                    listaVeiculos.add(onibus);
                }

                if (listaVeiculos.existe(placa)) {
                    limparCampos(null);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Operação concluída!");
                    alert.setHeaderText(null);
                    alert.setContentText(
                            "Veículo de placa " + BibMetodos.escreverPlaca(placa) + " adicionado com sucesso!");
                    alert.showAndWait();
                }
                break;

            case "Caminhão":
                int numEixos = 0;
                double cargaMax = 0;

                try {
                    numEixos = BibMetodos.lerInteiro(numeroEixosCaminhao.getText());
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro!");
                    alert.setHeaderText(null);
                    alert.setContentText("Número de eixos inválido (APENAS NÚMEROS)!");
                    alert.showAndWait();
                }

                try {
                    cargaMax = BibMetodos.lerDouble(cargaMaxCaminhao.getText());
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro!");
                    alert.setHeaderText(null);
                    alert.setContentText("Carga máxima inválida (APENAS NÚMEROS)!");
                    alert.showAndWait();
                }

                Veiculo caminhao = new Caminhao(placa, ano, valorDiaria, numEixos, cargaMax);
                if (!(placa.equals("null") || ano == 0 || valorDiaria == 0 || numEixos == 0 || cargaMax == 0)) {
                    listaVeiculos.add(caminhao);
                }

                if (listaVeiculos.existe(placa)) {
                    limparCampos(null);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Operação concluída!");
                    alert.setHeaderText(null);
                    alert.setContentText(
                            "Veículo de placa " + BibMetodos.escreverPlaca(placa) + " adicionado com sucesso!");
                    alert.showAndWait();
                }
                break;

            default:
                break;
        }
    }

    /**
     * @param event Define a ação do botão.
     * Método para remover veículo do sistema pela placa.
     * Caso o veículo seja removido, é exibida uma mensagem de sucesso.
     * Se não, é lançada uma exceção.
     * Nesta exceção, é exibida uma mensagem para o adm informando que
     * a placa é inválida ou não existente no sistema.
     */
    @FXML
    void removerVeiculo(ActionEvent event) {
        String placa = null;

        try {
            placa = BibMetodos.lerPlaca(placaVeiculo.getText());
            if (listaVeiculos.remove(placa)) {
                limparCampos(null);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Operação concluída!");
                alert.setHeaderText(null);
                alert.setContentText("Veículo removido com sucesso!");
                alert.showAndWait();
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Placa inválida ou não existente no sistema!");
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
            placa = BibMetodos.lerPlaca(placaVeiculo.getText());
            if (listaVeiculos.existe(placa)) {
                limparCampos(null);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Operação concluída!");
                alert.setHeaderText(null);
                alert.setContentText(
                        "O veículo de placa: " + BibMetodos.escreverPlaca(placa) + ", está cadastrado no sistema!");
                alert.showAndWait();
            } else {
                limparCampos(null);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Operação concluída!");
                alert.setHeaderText(null);
                alert.setContentText(
                        "A placa: " + BibMetodos.escreverPlaca(placa) + ", não encontra-se cadastrada no sistema!");
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
        diariaVeiculo.clear();
        numPortasVeiculo.clear();
        numPassageirosCarro.clear();
        mediaKmVeiculo.clear();
        opcaoArCondCarro.setValue("Selecione...");
        numPassageirosOnibus.clear();
        categoriaOnibus.setValue("Selecione...");
        opcaoInternetOnibus.setValue("Selecione...");
        opcaoArCondOnibus.setValue("Selecione...");
        numeroEixosCaminhao.clear();
        cargaMaxCaminhao.clear();
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

    /**
     * @param event Determina a ação da seleção do veículo carro
     * Deixa invisível as informações relacionadas ao Caminhão e Ônibus 
     * Mantem o paneCarro visível
     * Muda o texto do botão para caminhão
     */
    @FXML
    void itemCarro(ActionEvent event) {
        if (!paneCarro.isVisible()) {
            paneCarro.setVisible(true);
            paneCaminhao.setVisible(false);
            paneOnibus.setVisible(false);
            tipoVeiculo.setText("Carro");
        }
    }

    /**
     * @param event Determina a ação da seleção do veículo Caminhão
     * Deixa invisível as informações relacionadas ao Carro e Ônibus 
     * Mantem o paneCaminhao visível
     * Muda o texto do botão para Caminhão
     */
    @FXML
    void itemCaminhao(ActionEvent event) {
        if (!paneCaminhao.isVisible()) {
            paneCaminhao.setVisible(true);
            paneOnibus.setVisible(false);
            paneCarro.setVisible(false);
            tipoVeiculo.setText("Caminhão");
        }
    }

    /**
     * @param event Determina a ação da seleção do veículo Ônibus
     * Deixa invisível as informações relacionadas ao Carro e Caminhão 
     * Mantem o paneOnibus visível
     * Muda o texto do botão para Ônibus
     */
    @FXML
    void itemOnibus(ActionEvent event) {
        if (!paneOnibus.isVisible()) {
            paneOnibus.setVisible(true);
            paneCarro.setVisible(false);
            paneCaminhao.setVisible(false);
            tipoVeiculo.setText("Ônibus");
        }
    }
}