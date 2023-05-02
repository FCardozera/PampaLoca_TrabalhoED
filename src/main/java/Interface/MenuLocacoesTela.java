package Interface;

import java.net.URL;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import ClassesBase.*;
import Bib.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class MenuLocacoesTela implements Initializable {

    @FXML
    private TextField cpfCliente;

    @FXML
    private TextField placaVeiculo;

    @FXML
    private TextField previaTotal;

    @FXML
    private TableView<Veiculo> tabelaVeiculos;

    @FXML
    private TableColumn<Veiculo, Integer> colunaAno;

    @FXML
    private TableColumn<Veiculo, String> colunaCategoria;

    @FXML
    private TableColumn<Veiculo, Integer> colunaLugares;

    @FXML
    private TableColumn<Veiculo, String> colunaMarca;

    @FXML
    private TableColumn<Veiculo, String> colunaModelo;

    @FXML
    private TableColumn<Veiculo, String> colunaPlaca;

    @FXML
    private TableColumn<Veiculo, Integer> colunaPotencia;

    @FXML
    private ChoiceBox<String> diaInicio;

    @FXML
    private ChoiceBox<String> mesInicio;

    @FXML
    private ChoiceBox<String> anoInicio;

    @FXML
    private ChoiceBox<String> diaFinal;

    @FXML
    private ChoiceBox<String> mesFinal;

    @FXML
    private ChoiceBox<String> anoFinal;

    private String[] opcaoDia = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
            "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };

    private String[] opcaoMes = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };

    private String[] opcaoAno = { "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" };

    @FXML
    private Button removerLocacao;

    @FXML
    private Button dadosLocacoes;

    @FXML
    private Button calcularPreco;

    @FXML
    private Button voltarMenu;

    @FXML
    private Button cadastrarLocacao;

    @FXML
    private VBox rootVBox2;

    private VetorVeiculos vetorVeiculos;
    private ListaLocacoes listaLocacoes;
    private VetorClientes vetorClientes;

    /**
     * Inicializa a lista de Veículos da locadora de veículos.
     * Inicializa a lista de Clientes da locadora de veículos.
     * Inicializa a lista de Locacoes da locadora de veículos.
     * Esconde os componentes da interface gráfica "codigoLocacaoLabel", "codigoLocacao"
     * Adiciona opções às listas de opções dos componentes "seguroLocacao",
     * "diaInicio", "diaFinal", "mesInicio", "mesFinal", "anoInicio", "anoFinal".
     * limpa os campos 
     * @param arg0
     * @param arg1
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        vetorVeiculos = LocadoraVeiculos.getVetorVeiculos();
        listaLocacoes = LocadoraVeiculos.getListaLocacoes();
        vetorClientes = LocadoraVeiculos.getVetorClientes();
        diaInicio.getItems().addAll(opcaoDia);
        diaFinal.getItems().addAll(opcaoDia);
        mesInicio.getItems().addAll(opcaoMes);
        mesFinal.getItems().addAll(opcaoMes);
        anoInicio.getItems().addAll(opcaoAno);
        anoFinal.getItems().addAll(opcaoAno);
        limparCampos(null);
        colunaAno.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("ano"));
        colunaLugares.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("lugares"));
        colunaPotencia.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("potencia"));
        colunaCategoria.setCellValueFactory(new Callback<CellDataFeatures<Veiculo, String>, ObservableValue<String>>() {    
            @Override
            public ObservableValue<String> call(CellDataFeatures<Veiculo, String> c) {
                return new SimpleObjectProperty<String>(c.getValue().getCategoria().getNome());
            }
        });
        colunaPlaca.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("placa"));
        colunaModelo.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("modelo"));
        colunaMarca.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("marca"));
    }


    /**
     * Método de cadastro de uma nova locação no sistema; Solicita ao usuário
     * informações de um cliente, um veículo, uma data de início e uma data de fim
     * de locação, bem como uma opção de seguro; Caso o cliente ou o veículo não
     * estejam cadastrados no sistema, uma mensagem de erro é exibida; Caso a data
     * de início seja posterior à data de fim, uma mensagem de erro é exibida; Caso
     * a data de início seja anterior à data atual, uma mensagem de erro é exibida;
     * Caso o veículo já esteja alugado na data de início, uma mensagem de erro é
     * exibida; Caso o veículo já esteja alugado na data de fim, uma mensagem de erro
     * é exibida; Caso o cliente já tenha alugado um veículo na data de início, uma
     * mensagem de erro é exibida; Caso o cliente já tenha alugado um veículo na data
     * de fim, uma mensagem de erro é exibida; Caso o cliente já tenha alugado um
     * veículo na data de início e na data de fim, uma mensagem de erro é exibida;
     * @param event
     */
    @FXML
    void cadastrarLocacao(ActionEvent event) {
        Cliente cliente = null;
        Veiculo veiculo = null;
        String cpf = null;
        String placa = null;
        Calendar dataAtual = Calendar.getInstance();
        Calendar dataInicio = null;
        Calendar dataFim = null;

        try {
            cpf = Utility.lerCPF(cpfCliente.getText());
            if (!vetorClientes.contemCPF(cpf) || listaLocacoes.contemCPF(cpf)) {
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("CPF de cliente inválido, não cadastrado no sistema ou já atrelado a uma locação!");
            alert.showAndWait();
        }

        try {
            placa = Utility.lerPlaca(placaVeiculo.getText());
            if (!vetorVeiculos.contemPlaca(placa) || listaLocacoes.contemPlaca(placa)) {
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Placa de veículo inválida, não cadastrada no sistema ou veículo indisponível!");
            alert.showAndWait();
        }

        cliente = vetorClientes.getCliente(cpf);

        veiculo = vetorVeiculos.getVeiculo(placa);

        try {
            dataInicio = Utility.lerData(Integer.parseInt(diaInicio.getValue()),
                    Integer.parseInt(mesInicio.getValue()), Integer.parseInt(anoInicio.getValue()));
            dataFim = Utility.lerData(Integer.parseInt(diaFinal.getValue()), Integer.parseInt(mesFinal.getValue()),
                    Integer.parseInt(anoFinal.getValue()));

            if (Utility.diferencaDias(dataInicio, dataFim) <= 0) {
                throw new InputMismatchException();
            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Data inválida! Tente novamente!");
            alert.showAndWait();
        }
        
        Locacao locacao = new Locacao(cliente, veiculo, dataInicio, dataFim);
        if(!(cpf.equals(null) && placa.equals(null) && dataInicio.before(dataAtual) && dataInicio.equals(null) && dataFim.equals(null))) {
            listaLocacoes.insereFim(locacao);
        }
        
        if (locacao != null) {
            if(listaLocacoes.contemCodigo(locacao.getCodigo())) {
                limparCampos(null);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Operação concluída!");
                alert.setHeaderText(null);
                alert.setContentText("Locação cadastrada com sucesso! Código da locação = " + locacao.getCodigo());
                alert.showAndWait();
            }
        }
    }

    /**
     * Método que remove uma locação do sistema; Caso o código da locação não seja
     * válido, uma mensagem de erro é exibida; Caso o código da locação não esteja
     * cadastrado no sistema, uma mensagem de erro é exibida; Caso o código da
     * locação seja válido e esteja cadastrado no sistema, a locação é removida do
     * sistema e uma mensagem de sucesso é exibida;
     * @param event
     */
    @FXML
    void removerLocacao(ActionEvent event) {
        String placa = null;

        try {
            placa = Utility.lerPlaca(placaVeiculo.getText());
            if (listaLocacoes.removePlaca(placa)) {
                limparCampos(null);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Operação concluída!");
                alert.setHeaderText(null);
                alert.setContentText("Locação removida com sucesso!");
                alert.showAndWait();
            } else {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Placa inválida ou não atrelada a um veículo!");
            alert.showAndWait();
        }
    }

    /**
     * Método que limpa os campos da tela;
     * @param event
     */
    @FXML
    void limparCampos(ActionEvent event) {
        ObservableList<Veiculo> observableListVeiculos = FXCollections.observableArrayList();
        Veiculo [] veiculos = new Veiculo[vetorVeiculos.tamanho()];
        veiculos = vetorVeiculos.getVeiculos();

        for (int i = 0; i < vetorVeiculos.tamanho(); i++) {
            observableListVeiculos.add(veiculos[i]);
        }
        tabelaVeiculos.setItems(observableListVeiculos);
        cpfCliente.clear();
        placaVeiculo.clear();
        previaTotal.clear();
        diaInicio.setValue("Dia");
        diaFinal.setValue("Dia");
        mesInicio.setValue("Mês");
        mesFinal.setValue("Mês");
        anoInicio.setValue("Ano");
        anoFinal.setValue("Ano");
    }

    @FXML
    void calcularPreco(ActionEvent event) {
        if (!(diaInicio.getValue().equals("Dia")) && !(diaFinal.getValue().equals("Dia")) &&
        !(mesInicio.getValue().equals("Mês")) && !(mesFinal.getValue().equals("Mês")) &&
        !(anoInicio.getValue().equals("Ano")) && !(anoFinal.getValue().equals("Ano"))) {

            Calendar dataUm = Utility.lerData(Integer.parseInt(diaInicio.getValue()),
            Integer.parseInt(mesInicio.getValue()), Integer.parseInt(anoInicio.getValue()));
            Calendar dataDois = Utility.lerData(Integer.parseInt(diaFinal.getValue()), Integer.parseInt(mesFinal.getValue()),
            Integer.parseInt(anoFinal.getValue()));

            float valorTotal = (Utility.diferencaDias(dataUm, dataDois)) * 250;

            String retorno = "" + valorTotal;
            previaTotal.setText(retorno);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Data inválida! Tente novamente!");
            alert.showAndWait();
        }
    }

    /**
     * Carrega o arquivo "MenuDadosLocacoes.fxml" e o atribui ao objeto "VBoxMenuDadosLocacoes"
     * Remove os elementos filhos do objeto "rootVBox" e adiciona o "VBoxMenuDadosLocacoes como um novo filho"
     * @param event Determina a ação de acessar o MenuClientes
     */
    @FXML
    void menuDadosLocacoes(ActionEvent event) {
        try {
            VBox VBoxMenuDadosLocacoes = FXMLLoader.load(getClass().getResource("MenuDadosLocacoes.fxml"));
            rootVBox2.getChildren().setAll(VBoxMenuDadosLocacoes);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Carrega o arquivo "Interface.fxml" e o atribui ao objeto "VBoxInterface"
     * Remove os elementos filhos do objeto "rootVBox" e adiciona o "VBoxInterface como um novo filho"
     * @param event Determina a ação de voltar ao menu principal
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