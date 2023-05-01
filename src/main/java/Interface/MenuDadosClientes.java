package Interface;

import java.util.List;

import ClassesBase.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class MenuDadosClientes {

    @FXML
    private Button btnBuscarCliente;

    @FXML
    private Button btnInfoCompletaCliente;

    @FXML
    private Button btnInfoResumidaCliente;

    @FXML
    private Button btnPesquisarInfoCliente;

    @FXML
    private TableColumn<Cliente, String> columnCnhInfo;

    @FXML
    private TableColumn<Cliente, String> columnCnhPesquisar;

    @FXML
    private TableColumn<Cliente, String> columnCpfInfo;

    @FXML
    private TableColumn<Cliente, String> columnCpfPesquisar;

    @FXML
    private TableColumn<Cliente, String> columnEstadoInfo;

    @FXML
    private TableColumn<Cliente, String> columnEstadoPesquisar;

    @FXML
    private TableColumn<Cliente, String> columnCidadeInfo;

    @FXML
    private TableColumn<Cliente, String> columnCidadePesquisar;

    @FXML
    private TableColumn<Cliente, String> columnBairroInfo;

    @FXML
    private TableColumn<Cliente, String> columnBairroPesquisar;

    @FXML
    private TableColumn<Cliente, String> columnEnderecoPesquisar;

    @FXML
    private TableColumn<Cliente, String> columnEnderecoInfo;

    @FXML
    private TableColumn<Cliente, String> columnNomeInfo;

    @FXML
    private TableColumn<Cliente, String> columnNomePesquisar;

    @FXML
    private TableColumn<Cliente, String> columnTelefoneInfo;

    @FXML
    private TableColumn<Cliente, String> columnTelefonePesquisar;

    @FXML
    private VBox rootVBox2;

    @FXML
    private Label labelCpfPesquisar;

    @FXML
    private TableView<Cliente> tableViewInfoCliente;

    @FXML
    private TableView<Cliente> tableViewPesquisarCliente;

    @FXML
    private TextField textFieldBuscarCliente;

    @FXML
    private Button voltarMenuClientes;

    private boolean mostrarEsconderInfoPesquisa = true;
    private boolean mostrarEsconderInfoCompleta = true;
    private boolean mostrarEsconderInfoResumo = true;

    private ListClientes listaClientes;

    /**
     * Método que adiciona as informações nas colunas da tabela.
     * A tabela é representada por um componente JavaFX chamado TableView, que exibe
     * uma lista de objetos em uma tabela. Cada coluna da tabela é representada por
     * um componente JavaFX chamado TableColumn.
     * O método setCellValueFactory é chamado no objeto columnCodigoInfo, que é uma
     * instância de TableColumn, O valor é obtido a partir de um atributo do objeto
     * exibido na linha da tabela correspondente.
     * O método setCellValueFactory recebe como argumento uma instância de
     * PropertyValueFactory, que é usada para especificar o nome do atributo a ser
     * exibido.
     * A classe PropertyValueFactory é usada para vincular um atributo de um objeto
     * a uma coluna de uma tabela.
     * A interface Callback é uma interface funcional que define um único método
     * abstrato, call, que deve ser implementado.
     * O método call é chamado para cada célula da coluna e retorna um objeto do
     * tipo ObservableValue, que é um tipo genérico que representa um valor
     * observável.
     * No código, o valor observável é um objeto do tipo SimpleObjectProperty, que é
     * uma classe que implementa a interface ObservableValue
     * O valor do objeto SimpleObjectProperty é a partir do atributo que está sendo
     * exibido na linha da tabela correspondente
     */
    @FXML
    void initialize() {
        listaClientes = LocadoraVeiculos.getListaClientes();
        esconderTabelas(null);
        columnNomeInfo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        columnNomePesquisar.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        columnCnhInfo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nCarteira"));
        columnCnhPesquisar.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nCarteira"));
        columnTelefoneInfo
                .setCellValueFactory(new Callback<CellDataFeatures<Cliente, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Cliente, String> c) {
                        return new SimpleObjectProperty<String>(
                                BibMetodos.escreverTelefone(c.getValue().getTelefone()));
                    }
                });
        columnTelefonePesquisar
                .setCellValueFactory(new Callback<CellDataFeatures<Cliente, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Cliente, String> c) {
                        return new SimpleObjectProperty<String>(
                                BibMetodos.escreverTelefone(c.getValue().getTelefone()));
                    }
                });
        columnCpfInfo.setCellValueFactory(new Callback<CellDataFeatures<Cliente, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Cliente, String> c) {
                return new SimpleObjectProperty<String>(BibMetodos.escreverCPF(c.getValue().getCpf()));
            }
        });
        columnCpfPesquisar
                .setCellValueFactory(new Callback<CellDataFeatures<Cliente, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Cliente, String> c) {
                        return new SimpleObjectProperty<String>(BibMetodos.escreverCPF(c.getValue().getCpf()));
                    }
                });

        columnEnderecoInfo
                .setCellValueFactory(new Callback<CellDataFeatures<Cliente, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Cliente, String> c) {
                        return new SimpleObjectProperty<String>(c.getValue().getEndereco().getLogradouroCompleto());
                    }
                });
        columnEnderecoPesquisar
                .setCellValueFactory(new Callback<CellDataFeatures<Cliente, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Cliente, String> c) {
                        return new SimpleObjectProperty<String>(c.getValue().getEndereco().getLogradouroCompleto());
                    }
                });
        columnEstadoInfo
                .setCellValueFactory(new Callback<CellDataFeatures<Cliente, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Cliente, String> c) {
                        return new SimpleObjectProperty<String>(c.getValue().getEndereco().getEstado());
                    }
                });
        columnEstadoPesquisar
                .setCellValueFactory(new Callback<CellDataFeatures<Cliente, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Cliente, String> c) {
                        return new SimpleObjectProperty<String>(c.getValue().getEndereco().getEstado());
                    }
                });
        columnCidadeInfo
                .setCellValueFactory(new Callback<CellDataFeatures<Cliente, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Cliente, String> c) {
                        return new SimpleObjectProperty<String>(c.getValue().getEndereco().getCidade());
                    }
                });
        columnCidadePesquisar
                .setCellValueFactory(new Callback<CellDataFeatures<Cliente, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Cliente, String> c) {
                        return new SimpleObjectProperty<String>(c.getValue().getEndereco().getCidade());
                    }
                });
        columnBairroInfo
                .setCellValueFactory(new Callback<CellDataFeatures<Cliente, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Cliente, String> c) {
                        return new SimpleObjectProperty<String>(c.getValue().getEndereco().getBairro());
                    }
                });
        columnBairroPesquisar
                .setCellValueFactory(new Callback<CellDataFeatures<Cliente, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Cliente, String> c) {
                        return new SimpleObjectProperty<String>(c.getValue().getEndereco().getBairro());
                    }
                });
    }

    /**
     * Busca por um cliente a partir de um CPF informado pelo usuário e é exibido na
     * tela. Se o cliente não existir ou o CPF for inválido, um alerta é exibido
     * para informar o erro.
     * @param event Determina a ação do botão.
     */ 
    @FXML
    void btnBuscarCliente(ActionEvent event) {
        String cpf = null;

        if (tableViewPesquisarCliente.isVisible()) {
            ObservableList<Cliente> observableListClientes = FXCollections.observableArrayList();

            try {
                cpf = BibMetodos.lerCPF(textFieldBuscarCliente.getText());
                if (listaClientes.existe(cpf)) {
                    Cliente cliente = listaClientes.get(cpf);

                    observableListClientes.add(cliente);
                    tableViewPesquisarCliente.setItems(observableListClientes);
                } else {
                    throw new NullPointerException();
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro!");
                alert.setHeaderText(null);
                alert.setContentText("CPF inválido ou não existente!");
                alert.showAndWait();
            }
        }
    }

    /**
     * Exibe informações completas de todos os clientes em uma tabela. Em caso de
     * falha, um alerta é exibido para informar o erro.
     * @param event Determina a ação do botão.
     */
    @FXML
    void btnInfoCompletaCliente(ActionEvent event) {
        if (btnBuscarCliente.isVisible() || !(columnCnhInfo.isVisible())) {
            btnBuscarCliente.setVisible(false);
            labelCpfPesquisar.setVisible(false);
            textFieldBuscarCliente.setVisible(false);
            columnEnderecoInfo.setVisible(true);
            columnCnhInfo.setVisible(true);
            columnTelefoneInfo.setVisible(true);
            columnBairroInfo.setVisible(true);
            columnEstadoInfo.setVisible(true);
            columnCidadeInfo.setVisible(true);
            tableViewPesquisarCliente.setVisible(false);

            mostrarEsconderInfoResumo = true;
            mostrarEsconderInfoPesquisa = true;
        }

        tableViewInfoCliente.setVisible(mostrarEsconderInfoCompleta);
        mostrarEsconderInfoCompleta = !mostrarEsconderInfoCompleta;

        if (tableViewInfoCliente.isVisible() && columnCnhInfo.isVisible()) {
            ObservableList<Cliente> observableListClientes = FXCollections.observableArrayList();

            try {
                List<Cliente> clientes = listaClientes.getListClientes();

                for (Cliente cliente : clientes) {
                    observableListClientes.add(cliente);
                }
            } catch (NullPointerException e) {
                System.out.println(e.getLocalizedMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            } catch (NumberFormatException e) {
                System.out.println(e.getLocalizedMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
            tableViewInfoCliente.setItems(observableListClientes);
        }
    }

    /**
     * Exibe informações resumidas de todos os clientes em uma tabela. Em caso de
     * falha, um alerta é exibido para informar o erro.
     * @param event Determina a ação do botão.
     */
    @FXML
    void btnInfoResumidaCliente(ActionEvent event) {
        if (btnBuscarCliente.isVisible() || columnCnhInfo.isVisible()) {
            btnBuscarCliente.setVisible(false);
            labelCpfPesquisar.setVisible(false);
            textFieldBuscarCliente.setVisible(false);
            columnEnderecoInfo.setVisible(false);
            columnCnhInfo.setVisible(false);
            columnTelefoneInfo.setVisible(false);
            columnBairroInfo.setVisible(false);
            columnEstadoInfo.setVisible(false);
            columnCidadeInfo.setVisible(false);
            tableViewPesquisarCliente.setVisible(false);

            mostrarEsconderInfoCompleta = true;
            mostrarEsconderInfoPesquisa = true;
        }

        tableViewInfoCliente.setVisible(mostrarEsconderInfoResumo);
        mostrarEsconderInfoResumo = !mostrarEsconderInfoResumo;

        if (tableViewInfoCliente.isVisible() && !(columnCnhInfo.isVisible())) {
            ObservableList<Cliente> observableListClientes = FXCollections.observableArrayList();

            try {
                List<Cliente> clientes = listaClientes.getListClientes();

                for (Cliente cliente : clientes) {
                    observableListClientes.add(cliente);
                }
            } catch (NullPointerException e) {
                System.out.println(e.getLocalizedMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            } catch (NumberFormatException e) {
                System.out.println(e.getLocalizedMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
            tableViewInfoCliente.setItems(observableListClientes);
        }
    }

    /**
     * Exibe uma tabela com os clientes que possuem o CPF informado.
     * @param event Determina a ação do botão.
     */
    @FXML
    void btnPesquisarInfoCliente(ActionEvent event) {
        if (tableViewInfoCliente.isVisible()) {
            tableViewInfoCliente.setVisible(false);

            mostrarEsconderInfoResumo = true;
            mostrarEsconderInfoCompleta = true;
        }

        tableViewPesquisarCliente.setVisible(mostrarEsconderInfoPesquisa);
        btnBuscarCliente.setVisible(mostrarEsconderInfoPesquisa);
        labelCpfPesquisar.setVisible(mostrarEsconderInfoPesquisa);
        textFieldBuscarCliente.setVisible(mostrarEsconderInfoPesquisa);
        mostrarEsconderInfoPesquisa = !mostrarEsconderInfoPesquisa;
    }

    /**
     * Carrega o arquivo "MenuClientes.fxml" e o atribui ao objeto "VBoxMenuClientes"
     * Remove os elementos filhos do objeto "rootVBox" e adiciona o "VBoxMenuClientes como um novo filho"
     * @param event Determina a ação de acessar o MenuClientes
     */
    @FXML
    void voltarMenuClientes(ActionEvent event) {
        try {
            VBox VBoxMenuClientes = FXMLLoader.load(getClass().getResource("MenuClientes.fxml"));
            rootVBox2.getChildren().setAll(VBoxMenuClientes);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Esconde as tabelas e os botões de pesquisa.
     * @param event Determina a ação de esconder as tabelas e os botões de pesquisa.
     */
    @FXML
    void esconderTabelas(ActionEvent event) {
        tableViewPesquisarCliente.setVisible(false);
        tableViewInfoCliente.setVisible(false);
        textFieldBuscarCliente.setVisible(false);
        labelCpfPesquisar.setVisible(false);
        btnBuscarCliente.setVisible(false);
    }
}
