package Interface;

import java.net.URL;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

import ClassesBase.BibMetodos;
import ClassesBase.Cliente;
import ClassesBase.ListClientes;
import ClassesBase.ListLocacoes;
import ClassesBase.Locacao;
import ClassesBase.Veiculo;
import ClassesBase.ListVeiculos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class MenuLocacoesTela implements Initializable {

    @FXML
    private TextField cpfCliente;

    @FXML
    private TextField placaVeiculo;

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
    private ChoiceBox<String> seguroLocacao;

    private String[] opcaoSeguros = { "Sim", "Não" };

    @FXML
    private TextField codigoLocacao;

    @FXML
    private Label codigoLocacaoLabel;

    @FXML
    private Button removerLocacao;

    @FXML
    private Button verificarLocacao;

    @FXML
    private Button dadosLocacoes;

    @FXML
    private Button voltarMenu;

    @FXML
    private Button cadastrarLocacao;

    @FXML
    private VBox rootVBox2;

    private ListClientes listaClientes;
    private ListVeiculos listaVeiculos;
    private ListLocacoes listaLocacoes;

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
        listaClientes = LocadoraVeiculos.getListaClientes();
        listaVeiculos = LocadoraVeiculos.getListaVeiculos();
        listaLocacoes = LocadoraVeiculos.getListaLocacoes();
        codigoLocacaoLabel.setVisible(false);
        codigoLocacao.setVisible(false);
        seguroLocacao.getItems().addAll(opcaoSeguros);
        diaInicio.getItems().addAll(opcaoDia);
        diaFinal.getItems().addAll(opcaoDia);
        mesInicio.getItems().addAll(opcaoMes);
        mesFinal.getItems().addAll(opcaoMes);
        anoInicio.getItems().addAll(opcaoAno);
        anoFinal.getItems().addAll(opcaoAno);
        limparCampos(null);
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
        boolean seguro = false;
        String opcaoSeguro = null;

        try {
            cpf = BibMetodos.lerCPF(cpfCliente.getText());
            if (!listaClientes.existe(cpf)) {
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("CPF de cliente inválido ou não cadastrado no sistema!");
            alert.showAndWait();
        }

        try {
            placa = BibMetodos.lerPlaca(placaVeiculo.getText());
            if (!listaVeiculos.existe(placa)) {
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Placa de veículo inválida ou não cadastrada no sistema!");
            alert.showAndWait();
        }

        cliente = listaClientes.get(cpf);

        veiculo = listaVeiculos.get(placa);

        try {
            dataInicio = BibMetodos.lerData(Integer.parseInt(diaInicio.getValue()),
                    Integer.parseInt(mesInicio.getValue()), Integer.parseInt(anoInicio.getValue()));
            dataFim = BibMetodos.lerData(Integer.parseInt(diaFinal.getValue()), Integer.parseInt(mesFinal.getValue()),
                    Integer.parseInt(anoFinal.getValue()));

            if (((dataInicio.get(Calendar.DAY_OF_MONTH) <= dataAtual.get(Calendar.DAY_OF_MONTH)
            && dataInicio.get(Calendar.MONTH) <= dataAtual.get(Calendar.MONTH) 
            && dataInicio.get(Calendar.YEAR) <= dataAtual.get(Calendar.YEAR)) || 
            (dataFim.get(Calendar.DAY_OF_MONTH) < dataInicio.get(Calendar.DAY_OF_MONTH) 
            && dataFim.get(Calendar.MONTH) <= dataInicio.get(Calendar.MONTH) 
            && dataFim.get(Calendar.YEAR) <= dataInicio.get(Calendar.YEAR)))) {
                throw new InputMismatchException();
            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Data inválida! Tente novamente!");
            alert.showAndWait();
        }

        opcaoSeguro = seguroLocacao.getValue();

        try {
            if (opcaoSeguro.equals("Selecione...")) {
                throw new NullPointerException();
            } else if (opcaoSeguro.equals("Sim")) {
                seguro = true;
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Selecione a modalidade do seguro!");
            alert.showAndWait();
        }
        
        Locacao locacao = null;

        if(!(cpf.equals(null) || placa.equals(null) || opcaoSeguro.equals(null) || opcaoSeguro.equals("Selecione...") || dataInicio.before(dataAtual) || dataInicio.equals(null) || dataFim.equals(null))) {
            locacao = new Locacao(cliente, veiculo, dataInicio, dataFim, seguro);
            listaLocacoes.add(locacao);
        }
        
        if (locacao != null) {
            if(listaLocacoes.existe(locacao.getCodigo())) {
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
        int codigo = 0;

        if (codigoLocacao.isVisible()) {
            try {
                codigo = BibMetodos.lerInteiro(codigoLocacao.getText());
                if (listaLocacoes.remove(codigo)) {
                    limparCampos(null);
                    codigoLocacao.setVisible(false);
                    codigoLocacaoLabel.setVisible(false);
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
                alert.setContentText("Código inválido ou não existente no sistema!");
                alert.showAndWait();
            }
        } else {
            codigoLocacao.setVisible(true);
            codigoLocacaoLabel.setVisible(true);
        }
    }

    /**
     * Método que verifica se uma locação existe no sistema; Caso o código da
     * locação não seja válido, uma mensagem de erro é exibida; Caso o código da
     * locação seja válido e esteja cadastrado no sistema, uma mensagem de sucesso
     * é exibida;
     * @param event
     */
    @FXML
    void verificarLocacao(ActionEvent event) {
        int codigo = 0;

        if (codigoLocacao.isVisible()) {
            try {
                codigo = BibMetodos.lerInteiro(codigoLocacao.getText());
                if (listaLocacoes.existe(codigo)) {
                    limparCampos(null);
                    codigoLocacao.setVisible(false);
                    codigoLocacaoLabel.setVisible(false);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Operação concluída!");
                    alert.setHeaderText(null);
                    alert.setContentText("Locação " + codigo + " existe no sistema!");
                    alert.showAndWait();
                } else {
                    limparCampos(null);
                    codigoLocacao.setVisible(false);
                    codigoLocacaoLabel.setVisible(false);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Operação concluída!");
                    alert.setHeaderText(null);
                    alert.setContentText("A locação de código: " + codigo + ", não encontra-se cadastrada no sistema!");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro!");
                alert.setHeaderText(null);
                alert.setContentText("Código inválido!");
                alert.showAndWait();
            }
        } else {
            codigoLocacao.setVisible(true);
            codigoLocacaoLabel.setVisible(true);
        }
    }

    /**
     * Método que limpa os campos da tela;
     * @param event
     */
    @FXML
    void limparCampos(ActionEvent event) {
        codigoLocacao.clear();
        cpfCliente.clear();
        placaVeiculo.clear();
        seguroLocacao.setValue("Selecione...");
        diaInicio.setValue("Dia");
        diaFinal.setValue("Dia");
        mesInicio.setValue("Mês");
        mesFinal.setValue("Mês");
        anoInicio.setValue("Ano");
        anoFinal.setValue("Ano");
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