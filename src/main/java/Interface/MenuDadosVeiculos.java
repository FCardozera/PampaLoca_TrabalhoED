package Interface;

import javafx.util.Callback;
import java.util.List;
import ClassesBase.Carro;
import ClassesBase.BibMetodos;
import ClassesBase.Caminhao;
import ClassesBase.ListVeiculos;
import ClassesBase.Onibus;
import ClassesBase.Veiculo;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.beans.property.SimpleObjectProperty;

public class MenuDadosVeiculos {

    @FXML
    private Button btnBuscarVeiculo;

    @FXML
    private Button btnInfoCompletaVeiculos;

    @FXML
    private Button btnInfoResumidaVeiculos;

    @FXML
    private Button btnPesquisarInfoVeiculos;

    @FXML
    private Button voltarMenuVeiculos;

    @FXML
    private TableColumn<Veiculo, Integer> columnAnoInfo;

    @FXML
    private TableColumn<Veiculo, Integer> columnAnoPesquisar;

    @FXML
    private TableColumn<Veiculo, String> columnArInfo;

    @FXML
    private TableColumn<Veiculo, String> columnArPesquisar;

    @FXML
    private TableColumn<Veiculo, Double> columnCargaInfo;

    @FXML
    private TableColumn<Veiculo, Double> columnCargaPesquisar;

    @FXML
    private TableColumn<Veiculo, String> columnCategoriaInfo;

    @FXML
    private TableColumn<Veiculo, String> columnCategoriaPesquisar;

    @FXML
    private TableColumn<Veiculo, Integer> columnEixosInfo;

    @FXML
    private TableColumn<Veiculo, Integer> columnEixosPesquisar;

    @FXML
    private TableColumn<Veiculo, String> columnInternetInfo;

    @FXML
    private TableColumn<Veiculo, String> columnInternetPesquisar;

    @FXML
    private TableColumn<Veiculo, Float> columnMediaKmInfo;

    @FXML
    private TableColumn<Veiculo, Float> columnMediaKmPesquisar;

    @FXML
    private TableColumn<Veiculo, Integer> columnPassageirosInfo;

    @FXML
    private TableColumn<Veiculo, Integer> columnPassageirosPesquisar;

    @FXML
    private TableColumn<Veiculo, String> columnPlacaInfo;

    @FXML
    private TableColumn<Veiculo, String> columnPlacaPesquisar;

    @FXML
    private TableColumn<Veiculo, Integer> columnPortasInfo;

    @FXML
    private TableColumn<Veiculo, Integer> columnPortasPesquisar;

    @FXML
    private TableColumn<Veiculo, Double> columnValorDiariaInfo;

    @FXML
    private TableColumn<Veiculo, Double> columnValorDiariaPesquisar;

    @FXML
    private TableColumn<Veiculo, String> columnTipoVeiculoInfo;

    @FXML
    private TableColumn<Veiculo, String> columnTipoVeiculoPesquisar;

    @FXML
    private MenuItem onibus;

    @FXML
    private MenuItem caminhao;

    @FXML
    private MenuItem carro;

    @FXML
    private VBox rootVBox2;

    @FXML
    private Label labelPlacaPesquisar;

    @FXML
    private Label labelTipoVeiculo;

    @FXML
    private TableView<Veiculo> tableViewInfoVeiculo;

    @FXML
    private TableView<Veiculo> tableViewPesquisarVeiculo;

    @FXML
    private TextField textFieldBuscarVeiculo;

    @FXML
    private MenuButton tipoVeiculo;

    private boolean mostrarEsconderInfoPesquisa = true;
    private boolean mostrarEsconderInfoCompleta = true;
    private boolean mostrarEsconderInfoResumo = true;

    private ListVeiculos listaVeiculos;

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
        listaVeiculos = LocadoraVeiculos.getListaVeiculos();
        esconderTabelas(null);
        columnAnoInfo.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("ano"));
        columnAnoPesquisar.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("ano"));
        columnArInfo.setCellValueFactory(new Callback<CellDataFeatures<Veiculo, String>, ObservableValue<String>>() {    
            @Override    
            public ObservableValue<String> call(CellDataFeatures<Veiculo, String> c) {
                return new SimpleObjectProperty<String>(BibMetodos.temAdicional(c.getValue().getAr()));
            }
        });
        columnArPesquisar.setCellValueFactory(new Callback<CellDataFeatures<Veiculo, String>, ObservableValue<String>>() {    
            @Override    
            public ObservableValue<String> call(CellDataFeatures<Veiculo, String> c) {
                return new SimpleObjectProperty<String>(BibMetodos.temAdicional(c.getValue().getAr()));
            }
        });
        columnCargaInfo.setCellValueFactory(new PropertyValueFactory<Veiculo, Double>("cargaMax"));
        columnCargaPesquisar.setCellValueFactory(new PropertyValueFactory<Veiculo, Double>("cargaMax"));
        columnCategoriaInfo.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("categoria"));
        columnCategoriaPesquisar.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("categoria"));
        columnEixosInfo.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("numeroEixos"));
        columnEixosPesquisar.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("numeroEixos"));
        columnInternetInfo.setCellValueFactory(new Callback<CellDataFeatures<Veiculo, String>, ObservableValue<String>>() {    
            @Override    
            public ObservableValue<String> call(CellDataFeatures<Veiculo, String> c) {
                return new SimpleObjectProperty<String>(BibMetodos.temAdicional(c.getValue().getInternet()));
            }
        });
        columnInternetPesquisar.setCellValueFactory(new Callback<CellDataFeatures<Veiculo, String>, ObservableValue<String>>() {    
            @Override    
            public ObservableValue<String> call(CellDataFeatures<Veiculo, String> c) {
                return new SimpleObjectProperty<String>(BibMetodos.temAdicional(c.getValue().getInternet()));
            }
        });
        columnMediaKmInfo.setCellValueFactory(new PropertyValueFactory<Veiculo, Float>("mediaKm"));
        columnMediaKmPesquisar.setCellValueFactory(new PropertyValueFactory<Veiculo, Float>("mediaKm"));
        columnPassageirosInfo.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("numeroPass"));
        columnPassageirosPesquisar.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("numeroPass"));
        columnPlacaInfo.setCellValueFactory(new Callback<CellDataFeatures<Veiculo, String>, ObservableValue<String>>() {    
            @Override    
            public ObservableValue<String> call(CellDataFeatures<Veiculo, String> c) {
                return new SimpleObjectProperty<String>(BibMetodos.escreverPlaca(c.getValue().getPlaca()));
            }
        });
        columnPlacaPesquisar.setCellValueFactory(new Callback<CellDataFeatures<Veiculo, String>, ObservableValue<String>>() {    
            @Override    
            public ObservableValue<String> call(CellDataFeatures<Veiculo, String> c) {
                return new SimpleObjectProperty<String>(BibMetodos.escreverPlaca(c.getValue().getPlaca()));
            }
        });
        columnPortasInfo.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("numeroPortas"));
        columnPortasPesquisar.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("numeroPortas"));
        columnValorDiariaInfo.setCellValueFactory(new PropertyValueFactory<Veiculo, Double>("valorDiaria"));
        columnValorDiariaPesquisar.setCellValueFactory(new PropertyValueFactory<Veiculo, Double>("valorDiaria"));
        columnTipoVeiculoInfo.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("tipoVeiculo"));
        columnTipoVeiculoPesquisar.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("tipoVeiculo"));
    }

    
    /** 
     * Busca por um veículo a partir de uma placa informada pelo usuário e é exibido na
     * tela. Se o veículo não existir ou a placa for inválida, um alerta é exibido
     * para informar o erro.
     * @param event Determina a ação do botão.
     */
    @FXML
    void btnBuscarVeiculo(ActionEvent event) {
        String placa = null;

        if (tableViewPesquisarVeiculo.isVisible()) {
            ObservableList<Veiculo> observableListVeiculos = FXCollections.observableArrayList();

            try {
                placa = BibMetodos.lerPlaca(textFieldBuscarVeiculo.getText());
                if (listaVeiculos.existe(placa)) {
                    Veiculo veiculo = listaVeiculos.get(placa);

                    if(veiculo instanceof Carro) {
                        columnArPesquisar.setVisible(true);
                        columnCategoriaPesquisar.setVisible(false);
                        columnPortasPesquisar.setVisible(true);
                        columnPassageirosPesquisar.setVisible(true);
                        columnMediaKmPesquisar.setVisible(true);
                        columnEixosPesquisar.setVisible(false);
                        columnInternetPesquisar.setVisible(false);
                        columnCargaPesquisar.setVisible(false);
                    }
                    if(veiculo instanceof Caminhao) {
                        columnArPesquisar.setVisible(false);
                        columnCategoriaPesquisar.setVisible(false);
                        columnPortasPesquisar.setVisible(false);
                        columnPassageirosPesquisar.setVisible(false);
                        columnMediaKmPesquisar.setVisible(false);
                        columnEixosPesquisar.setVisible(true);
                        columnInternetPesquisar.setVisible(false);
                        columnCargaPesquisar.setVisible(true);
                    }
                    if(veiculo instanceof Onibus) {
                        columnArPesquisar.setVisible(true);
                        columnCategoriaPesquisar.setVisible(true);
                        columnPortasPesquisar.setVisible(false);
                        columnPassageirosPesquisar.setVisible(true);
                        columnMediaKmPesquisar.setVisible(false);
                        columnEixosPesquisar.setVisible(false);
                        columnInternetPesquisar.setVisible(true);
                        columnCargaPesquisar.setVisible(false);
                    }

                    observableListVeiculos.add(veiculo);
                    tableViewPesquisarVeiculo.setItems(observableListVeiculos);
                } else {
                    throw new NullPointerException();
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro!");
                alert.setHeaderText(null);
                alert.setContentText("Placa inválida ou não existente!");
                alert.showAndWait();
            }
        }

    }

    
    /** 
     * Exibe informações completas de todos os veículos em uma tabela. Em caso de
     * falha, um alerta é exibido para informar o erro.
     * @param event Determina a ação do botão.
     */
    @FXML
    void btnInfoCompletaVeiculos(ActionEvent event) {
        if (btnBuscarVeiculo.isVisible() || !(columnArInfo.isVisible()) || !(columnEixosInfo.isVisible())) {
            ObservableList<Veiculo> observableListVeiculos = FXCollections.observableArrayList();

            tableViewInfoVeiculo.setItems(observableListVeiculos);
            btnBuscarVeiculo.setVisible(false);
            labelPlacaPesquisar.setVisible(false);
            textFieldBuscarVeiculo.setVisible(false);
            tableViewPesquisarVeiculo.setVisible(false);
            labelTipoVeiculo.setVisible(true);
            tipoVeiculo.setVisible(true);
            columnTipoVeiculoInfo.setVisible(false);

            mostrarEsconderInfoResumo = true;
            mostrarEsconderInfoPesquisa = true;
        }

        tableViewInfoVeiculo.setVisible(mostrarEsconderInfoCompleta);
        mostrarEsconderInfoCompleta = !mostrarEsconderInfoCompleta;
    }

    
    /** 
     * Exibe informações resumidas de todos os veículos em uma tabela. Em caso de
     * falha, um alerta é exibido para informar o erro.
     * @param event Determina a ação do botão.
     */
    @FXML
    void btnInfoResumidaVeiculos(ActionEvent event) {
        if (btnBuscarVeiculo.isVisible() || columnArInfo.isVisible() || columnEixosInfo.isVisible()) {
            btnBuscarVeiculo.setVisible(false);
            labelPlacaPesquisar.setVisible(false);
            textFieldBuscarVeiculo.setVisible(false);
            tableViewPesquisarVeiculo.setVisible(false);
            columnArInfo.setVisible(false);
            columnCategoriaInfo.setVisible(false);
            columnPortasInfo.setVisible(false);
            columnPassageirosInfo.setVisible(false);
            columnMediaKmInfo.setVisible(false);
            columnEixosInfo.setVisible(false);
            columnInternetInfo.setVisible(false);
            columnCargaInfo.setVisible(false);
            labelTipoVeiculo.setVisible(false);
            columnTipoVeiculoInfo.setVisible(true);
            tipoVeiculo.setVisible(false);

            mostrarEsconderInfoCompleta = true;
            mostrarEsconderInfoPesquisa = true;
        }

        tableViewInfoVeiculo.setVisible(mostrarEsconderInfoResumo);
        mostrarEsconderInfoResumo = !mostrarEsconderInfoResumo;

        if (tableViewInfoVeiculo.isVisible()) {
            ObservableList<Veiculo> observableListVeiculos = FXCollections.observableArrayList();

            try {
                List<Veiculo> veiculos = listaVeiculos.getListVeiculos();

                for (Veiculo veiculo : veiculos) {
                    observableListVeiculos.add(veiculo);
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
            tableViewInfoVeiculo.setItems(observableListVeiculos);
        }
    }

    
    /** 
     * Exibe uma tabela com os veículos que possuem a placa informado.
     * @param event Determina a ação do botão.
     */
    @FXML
    void btnPesquisarInfoVeiculos(ActionEvent event) {
        if (tableViewInfoVeiculo.isVisible()) {
            tableViewInfoVeiculo.setVisible(false);
            labelTipoVeiculo.setVisible(false);
            tipoVeiculo.setVisible(false);

            mostrarEsconderInfoResumo = true;
            mostrarEsconderInfoCompleta = true;
        }

        tableViewPesquisarVeiculo.setVisible(mostrarEsconderInfoPesquisa);
        btnBuscarVeiculo.setVisible(mostrarEsconderInfoPesquisa);
        labelPlacaPesquisar.setVisible(mostrarEsconderInfoPesquisa);
        textFieldBuscarVeiculo.setVisible(mostrarEsconderInfoPesquisa);
        mostrarEsconderInfoPesquisa = !mostrarEsconderInfoPesquisa;

    }

    
    /** 
     * Carrega o arquivo "MenuVeiculos.fxml" e o atribui ao objeto "VBoxMenuVeiculos"
     * Remove os elementos filhos do objeto "rootVBox" e adiciona o "VBoxMenuVeiculos como um novo filho"
     * @param event Determina a ação de acessar o MenuClientes
     */
    @FXML
    void voltarMenuVeiculos(ActionEvent event) {
        try {
            VBox VBoxMenuVeiculos = FXMLLoader.load(getClass().getResource("MenuVeiculos.fxml"));
            rootVBox2.getChildren().setAll(VBoxMenuVeiculos);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    /** 
     * Exibe informações de veículos do tipo "Carro" em uma tabela.
     * @param event
     */
    @FXML
    void itemCarro(ActionEvent event) {
        if(!(tableViewPesquisarVeiculo.isVisible())) {
            columnArInfo.setVisible(true);
            columnCategoriaInfo.setVisible(false);
            columnPortasInfo.setVisible(true);
            columnPassageirosInfo.setVisible(true);
            columnMediaKmInfo.setVisible(true);
            columnEixosInfo.setVisible(false);
            columnInternetInfo.setVisible(false);
            columnCargaInfo.setVisible(false);
            tipoVeiculo.setText("Carro");
        }

        if(tableViewInfoVeiculo.isVisible()) {
            ObservableList<Veiculo> observableListVeiculos = FXCollections.observableArrayList();

            try {
            List<Veiculo> veiculos = listaVeiculos.getListVeiculos();

            for (Veiculo veiculo : veiculos) {
                if(veiculo instanceof Carro) {
                    observableListVeiculos.add(veiculo);
                }
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

            tableViewInfoVeiculo.setItems(observableListVeiculos);
        }
    }

    
    /** 
     * Exibe informações de veículos do tipo "Caminhão" em uma tabela.
     * @param event
     */
    @FXML
    void itemCaminhao(ActionEvent event) {
        if(!(tableViewPesquisarVeiculo.isVisible())) {
            columnArInfo.setVisible(false);
            columnCategoriaInfo.setVisible(false);
            columnPortasInfo.setVisible(false);
            columnPassageirosInfo.setVisible(false);
            columnMediaKmInfo.setVisible(false);
            columnEixosInfo.setVisible(true);
            columnInternetInfo.setVisible(false);
            columnCargaInfo.setVisible(true);
            tipoVeiculo.setText("Caminhão");
        }

        if (tableViewInfoVeiculo.isVisible()) {
            ObservableList<Veiculo> observableListVeiculos = FXCollections.observableArrayList();

            try {
                List<Veiculo> veiculos = listaVeiculos.getListVeiculos();

                for (Veiculo veiculo : veiculos) {
                    if(veiculo instanceof Caminhao) {
                        observableListVeiculos.add(veiculo);
                    }
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

            tableViewInfoVeiculo.setItems(observableListVeiculos);
        }
    }

    
    /** 
     * Exibe informações de veículos do tipo "Ônibus" em uma tabela.
     * @param event 
     */
    @FXML
    void itemOnibus(ActionEvent event) {
        if(!(tableViewPesquisarVeiculo.isVisible())) {
            columnArInfo.setVisible(true);
            columnCategoriaInfo.setVisible(true);
            columnPortasInfo.setVisible(false);
            columnPassageirosInfo.setVisible(true);
            columnMediaKmInfo.setVisible(false);
            columnEixosInfo.setVisible(false);
            columnInternetInfo.setVisible(true);
            columnCargaInfo.setVisible(false);
            tipoVeiculo.setText("Ônibus");
        }

        if (tableViewInfoVeiculo.isVisible()) {
            ObservableList<Veiculo> observableListVeiculos = FXCollections.observableArrayList();

            try {
                List<Veiculo> veiculos = listaVeiculos.getListVeiculos();

                for (Veiculo veiculo : veiculos) {
                    if(veiculo instanceof Onibus) {
                        observableListVeiculos.add(veiculo);
                    }
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

            tableViewInfoVeiculo.setItems(observableListVeiculos);
        }
    }

    
    /** 
     * Esconde as tabelas e os botões de pesquisa.
     * @param event Determina a ação de esconder as tabelas e os botões de pesquisa.
     */
    @FXML
    void esconderTabelas(ActionEvent event) {
        tableViewPesquisarVeiculo.setVisible(false);
        tableViewInfoVeiculo.setVisible(false);
        textFieldBuscarVeiculo.setVisible(false);
        labelPlacaPesquisar.setVisible(false);
        btnBuscarVeiculo.setVisible(false);
        labelTipoVeiculo.setVisible(false);
        tipoVeiculo.setVisible(false);
    }
}