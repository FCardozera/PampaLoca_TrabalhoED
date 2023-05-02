package Interface;


import ClassesBase.*;
import Bib.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import ClassesBase.Locacao;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class MenuDadosLocacoes {


    @FXML
    private Button btnPesquisarLocacao;

    @FXML
    private TableColumn<Locacao, Integer> columnCodigoPesquisar;

    @FXML
    private TableColumn<Locacao, String> columnCpfPesquisar;

    @FXML
    private TableColumn<Locacao, String> columnDataFinalPesquisar;

    @FXML
    private TableColumn<Locacao, String> columnDataInicialPesquisar;

    @FXML
    private TableColumn<Locacao, String> columnPlacaPesquisar;

    @FXML
    private TableColumn<Locacao, Float> columnValorDiariaPesquisar;

    @FXML
    private ImageView imgFundo;

    @FXML
    private VBox rootVBox2;

    @FXML
    private TableView<?> tableViewPesquisarLocacoes;

    @FXML
    private Button voltarMenuLocacoes;

    @FXML
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
   
    private VetorClientes listaClientes;
    private VetorVeiculos listaVeiculos;
    private VetorCategoria listaCategorias;

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
        listaClientes = LocadoraVeiculos.getVetorClientes();
        listaVeiculos = LocadoraVeiculos.getVetorVeiculos();
        listaCategorias = LocadoraVeiculos.getVetorCategoria();
        esconderTabelas(null);

        
        // columnCodigoInfo.setCellValueFactory(new PropertyValueFactory<Locacao, Integer>("codigo"));
        columnCodigoPesquisar.setCellValueFactory(new PropertyValueFactory<Locacao, Integer>("codigo"));
        // columnCodigoAvancada.setCellValueFactory(new PropertyValueFactory<Locacao, Integer>("codigo"));
        // columnAnoInfo.setCellValueFactory(new Callback<CellDataFeatures<Locacao, Integer>, ObservableValue<Integer>>() {    
        //     @Override    
        //     public ObservableValue<Integer> call(CellDataFeatures<Locacao, Integer> c) {
        //         return new SimpleObjectProperty<Integer>(c.getValue().getVeiculo().getAno());
        //     }
        // });
        // columnAnoPesquisar.setCellValueFactory(new Callback<CellDataFeatures<Locacao, Integer>, ObservableValue<Integer>>() {    
        //     @Override    
        //     public ObservableValue<Integer> call(CellDataFeatures<Locacao, Integer> c) {
        //         return new SimpleObjectProperty<Integer>(c.getValue().getVeiculo().getAno());
        //     }
        // });
        // columnAnoAvancada.setCellValueFactory(new Callback<CellDataFeatures<Locacao, Integer>, ObservableValue<Integer>>() {    
        //     @Override    
        //     public ObservableValue<Integer> call(CellDataFeatures<Locacao, Integer> c) {
        //         return new SimpleObjectProperty<Integer>(c.getValue().getVeiculo().getAno());
        //     }
        // });
        // columnCpfInfo.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(BibMetodos.escreverCPF(c.getValue().getCliente().getCpf()));
        //     }
        // });
        columnCpfPesquisar.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
            @Override    
            public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
                return new SimpleObjectProperty<String>(Utility.escreverCPF(c.getValue().getCliente().getCpf()));
            }
        });
        // columnCpfAvancada.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(Utility.escreverCPF(c.getValue().getCliente().getCpf()));
        //     }
        // });
        // columnNomeInfo.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(c.getValue().getCliente().getNome());
        //     }
        // });
        // columnNomePesquisar.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(c.getValue().getCliente().getNome());
        //     }
        // });
        // columnNomeAvancada.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(c.getValue().getCliente().getNome());
        //     }
        // });
        // columnPlacaInfo.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(BibMetodos.escreverPlaca(c.getValue().getVeiculo().getPlaca()));
        //     }
        // });
        columnPlacaPesquisar.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
            @Override    
            public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
                return new SimpleObjectProperty<String>(Utility.escreverPlaca(c.getValue().getVeiculo().getPlaca()));
            }
        });
        // columnPlacaAvancada.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(Utility.escreverPlaca(c.getValue().getVeiculo().getPlaca()));
        //     }
        // });
        // columnSeguroInfo.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(BibMetodos.temAdicional(c.getValue().getSeguro()));
        //     }
        // });
        // columnSeguroPesquisar.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(BibMetodos.temAdicional(c.getValue().getSeguro()));
        //     }
        // });
        // columnSeguroAvancada.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(BibMetodos.temAdicional(c.getValue().getSeguro()));
        //     }
        // });
        // columnTipoVeiculoInfo.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(c.getValue().getVeiculo().getTipoVeiculo());
        //     }
        // });
        // columnTipoVeiculoPesquisar.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(c.getValue().getVeiculo().getTipoVeiculo());
        //     }
        // });
        // columnTipoVeiculoAvancada.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(c.getValue().getVeiculo().getTipoVeiculo());
        //     }
        // });
        // columnValorDiariaInfo.setCellValueFactory(new Callback<CellDataFeatures<Locacao, Double>, ObservableValue<Double>>() {    
        //     @Override    
        //     public ObservableValue<Double> call(CellDataFeatures<Locacao, Double> c) {
        //         return new SimpleObjectProperty<Double>(c.getValue().getVeiculo().getValorDiaria());
        //     }
        // });
        columnValorDiariaPesquisar.setCellValueFactory(new PropertyValueFactory<Locacao, Float>("valorTotal"));
    

        
        // columnValorDiariaAvancada.setCellValueFactory(new Callback<CellDataFeatures<Locacao, Double>, ObservableValue<Double>>() {    
        //     @Override    
        //     public ObservableValue<Double> call(CellDataFeatures<Locacao, Double> c) {
        //         return new SimpleObjectProperty<Double>(c.getValue().getVeiculo().getValorDiaria());
        //     }
        // });
        // columnDataInicialInfo.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(formato.format(c.getValue().getDataInicial().getTime()));
        //     }
        // });
        columnDataInicialPesquisar.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
            @Override    
            public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
                return new SimpleObjectProperty<String>(formato.format(c.getValue().getDataInicial().getTime()));
            }
        });
        // columnDataInicialAvancada.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(formato.format(c.getValue().getDataInicial().getTime()));
        //     }
        // });
        // columnDataFinalInfo.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(formato.format(c.getValue().getDataFinal().getTime()));
        //     }
        // });
        columnDataFinalPesquisar.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
            @Override    
            public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
                return new SimpleObjectProperty<String>(formato.format(c.getValue().getDataFinal().getTime()));
            }
        });
        // columnDataFinalAvancada.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
        //     @Override    
        //     public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
        //         return new SimpleObjectProperty<String>(formato.format(c.getValue().getDataFinal().getTime()));
        //     }
        // });
    }

    /**
     * Declara uma variável "codigoLocacao" e atribui a ela o valor 0
     * Verifica se "tableViewPesquisarLocacoes" está visível, se sim, continua o
     * código
     * Cria uma lista de objetos do tipo "Locacao" chamado "observableListLocacoes"
     * Tenta ler um int da variável textFieldBuscarLocacao e armazena o valor na
     * variável codigoLocacao
     * Verifica se existe uma locação com o código lido na lista de locações. Se
     * existir, adiciona a locação à lista observável e atribui a lista observável
     * ao componente tableViewPesquisarLocacoes. Se não existir, lança uma exceção.
     * Permite que o usuário pesquise por uma locação específica e exiba os detalhes
     * da locação em uma tabela.
     * 
     * @param event realiza a ação do evento
     */
    @FXML
    void btnPesquisarLocacao(ActionEvent event) {
        int codigoLocacao = 0;

        if (tableViewPesquisarLocacoes.isVisible()) {
            ObservableList<Locacao> observableListLocacoes = FXCollections.observableArrayList();

            try {
                codigoLocacao = Utility.lerInteiro(textFieldBuscarLocacao.getText());
                if (listaLocacoes.existe(codigoLocacao)) {
                    Locacao locacao = listaLocacoes.get(codigoLocacao);
                    observableListLocacoes.add(locacao);
                    tableViewPesquisarLocacoes.setItems(observableListLocacoes);
                } else {
                    throw new NullPointerException();
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro!");
                alert.setHeaderText(null);
                alert.setContentText("Código de locação inválido ou não existente!");
                alert.showAndWait();
            }
        }
    }

    /**
     * Permite que o usuário visualize todas as locações realizadas no sistema em
     * uma tabela.
     * Verifica se o componente da interface gráfica chamado "btnBuscarLocacao" está
     * visível. Se estiver, o código esconde esse componente e os componentes
     * "labelCodigoPesquisar", "textFieldBuscarLocacao" e
     * "tableViewPesquisarLocacoes".
     * Exibe ou esconde a tabela "tableViewInfoLocacoes" de acordo com o valor da
     * variável "mostrarEsconderInfoCompleta". Inverte o valor da variável
     * "mostrarEsconderInfoCompleta".
     * Se o componente "tableViewInfoLocacoes" estiver visível: Cria uma lista
     * observável de objetos do tipo Locacao chamada "observableListLocacoes", Tenta
     * obter a lista completa de locações da classe "ListLocacoes" e armazena a
     * lista em uma variável do tipo "List", Percorre a lista de locações e adiciona
     * cada elemento à lista observável, Atribui a lista observável ao componente
     * "tableViewInfoLocacoes".
     * 
     * @param event realiza a ação do evento
     */
    // @FXML
    // void btnInfoCompletasLocacao(ActionEvent event) {
    //     if (btnBuscarLocacao.isVisible() || tableViewConsultaAvancada.isVisible() || btnConsultaPeriodo.isVisible() || btnConsultaVeiculo.isVisible() || btnBuscarPeriodoAvancada.isVisible() || btnBuscarCpfAvancada.isVisible() || btnBuscarPlacaAvancada.isVisible() || btnBuscarDataEspecificaAvancada.isVisible()) {
    //         btnBuscarLocacao.setVisible(false);
    //         labelCodigoPesquisar.setVisible(false);
    //         textFieldBuscarLocacao.setVisible(false);
    //         textFieldBuscarCpfAvancada.setVisible(false);
    //         textFieldBuscarPlacaAvancada.setVisible(false);
    //         tableViewPesquisarLocacoes.setVisible(false);
    //         tableViewConsultaAvancada.setVisible(false);
    //         btnBuscarCpfAvancada.setVisible(false);
    //         btnBuscarDataEspecificaAvancada.setVisible(false);
    //         btnBuscarPeriodoAvancada.setVisible(false);
    //         btnBuscarPlacaAvancada.setVisible(false);
    //         btnConsultaCliente.setVisible(false);
    //         btnConsultaData.setVisible(false);
    //         btnConsultaDataEspecifica.setVisible(false);
    //         btnConsultaPeriodo.setVisible(false);
    //         btnConsultaVeiculo.setVisible(false);
    //         choiceBoxDiaEspecifico.setVisible(false);
    //         choiceBoxDiaPeriodoDe.setVisible(false);
    //         choiceBoxDiaPeriodoPara.setVisible(false);
    //         choiceBoxMesEspecifico.setVisible(false);
    //         choiceBoxMesPeriodoDe.setVisible(false);
    //         choiceBoxMesPeriodoPara.setVisible(false);
    //         choiceBoxAnoEspecifico.setVisible(false);
    //         choiceBoxAnoPeriodoDe.setVisible(false);
    //         choiceBoxAnoPeriodoPara.setVisible(false);
    //         labelCpfAvancada.setVisible(false);
    //         labelDataAvancada.setVisible(false);
    //         labelDeAvancada.setVisible(false);
    //         labelParaAvancada.setVisible(false);
    //         labelPlacaAvancada.setVisible(false);
    //         textBuscarAvancada.setVisible(false);
            
    //         mostrarEsconderInfoPesquisa = true;
    //         mostrarEsconderConsultaAvancada = true;
    //         mostrarEsconderConsultaCliente = true;
    //         mostrarEsconderConsultaDataDia = true;
    //         mostrarEsconderConsultaDataPeriodo = true;
    //         mostrarEsconderConsultaVeiculo = true;
    //         mostrarEsconderConsultaData = true;
    //     }

    //     tableViewInfoLocacoes.setVisible(mostrarEsconderInfoCompleta);
    //     mostrarEsconderInfoCompleta = !mostrarEsconderInfoCompleta;

    //     if (tableViewInfoLocacoes.isVisible()) {
    //         ObservableList<Locacao> observableListLocacoes = FXCollections.observableArrayList();

    //         try {
    //             List<Locacao> locacoes = listaLocacoes.getListLocacoes();

    //             for (Locacao locacao : locacoes) {
    //                 observableListLocacoes.add(locacao);
    //             }
    //         } catch (NullPointerException e) {
    //             System.out.println(e.getLocalizedMessage());
    //             Alert alert = new Alert(Alert.AlertType.ERROR);
    //             alert.setTitle("ERRO");
    //             alert.setHeaderText(null);
    //             alert.setContentText(e.getMessage());
    //             alert.showAndWait();
    //         } catch (NumberFormatException e) {
    //             System.out.println(e.getLocalizedMessage());
    //             Alert alert = new Alert(Alert.AlertType.ERROR);
    //             alert.setTitle("ERRO");
    //             alert.setHeaderText(null);
    //             alert.setContentText(e.getMessage());
    //             alert.showAndWait();
    //         }
    //         tableViewInfoLocacoes.setItems(observableListLocacoes);
    //     }
    // }

    /**
     * Verifica se o componente da interface gráfica chamado "tableViewInfoLocacoes"
     * está visível. Se estiver, o código esconde esse componente e inverte o valor
     * da variável "mostrarEsconderInfoCompleta".
     * Exibe ou esconde o componente da interface gráfica chamado
     * "tableViewPesquisarLocacoes" de acordo com o valor da variável
     * "mostrarEsconderInfoPesquisa". Em seguida, inverte o valor da variável
     * "mostrarEsconderInfoPesquisa".
     * Exibe ou esconde os componentes da interface gráfica "btnBuscarLocacao",
     * "labelCodigoPesquisar", e "textFieldBuscarLocacao" de acordo com o valor da
     * variável "mostrarEsconderInfoPesquisa".
     * Ele permite que o usuário pesquise por uma locação específica por meio de um
     * código de locação. Se a locação for encontrada, ela é exibida em uma tabela.
     * 
     * @param event realiza a ação do evento
     */
    // @FXML
    // void btnPesquisarLocacao(ActionEvent event) {
    //     tableViewPesquisarLocacoes.setVisible(mostrarEsconderInfoPesquisa);
        // if (tableViewInfoLocacoes.isVisible() || tableViewConsultaAvancada.isVisible() || btnConsultaPeriodo.isVisible() || btnConsultaVeiculo.isVisible() || btnBuscarPeriodoAvancada.isVisible() || btnBuscarCpfAvancada.isVisible() || btnBuscarPlacaAvancada.isVisible() || btnBuscarDataEspecificaAvancada.isVisible()) {
        //     tableViewInfoLocacoes.setVisible(false);
        //     tableViewConsultaAvancada.setVisible(false);
        //     textFieldBuscarCpfAvancada.setVisible(false);
        //     textFieldBuscarPlacaAvancada.setVisible(false);
        //     btnBuscarCpfAvancada.setVisible(false);
        //     btnBuscarDataEspecificaAvancada.setVisible(false);
        //     btnBuscarPeriodoAvancada.setVisible(false);
        //     btnBuscarPlacaAvancada.setVisible(false);
        //     btnConsultaCliente.setVisible(false);
        //     btnConsultaData.setVisible(false);
        //     btnConsultaDataEspecifica.setVisible(false);
        //     btnConsultaPeriodo.setVisible(false);
        //     btnConsultaVeiculo.setVisible(false);
        //     choiceBoxDiaEspecifico.setVisible(false);
        //     choiceBoxDiaPeriodoDe.setVisible(false);
        //     choiceBoxDiaPeriodoPara.setVisible(false);
        //     choiceBoxMesEspecifico.setVisible(false);
        //     choiceBoxMesPeriodoDe.setVisible(false);
        //     choiceBoxMesPeriodoPara.setVisible(false);
        //     choiceBoxAnoEspecifico.setVisible(false);
        //     choiceBoxAnoPeriodoDe.setVisible(false);
        //     choiceBoxAnoPeriodoPara.setVisible(false);
        //     labelCpfAvancada.setVisible(false);
        //     labelDataAvancada.setVisible(false);
        //     labelDeAvancada.setVisible(false);
        //     labelParaAvancada.setVisible(false);
        //     labelPlacaAvancada.setVisible(false);
        //     textBuscarAvancada.setVisible(false); 
        //     mostrarEsconderInfoCompleta = true;
        //     mostrarEsconderConsultaAvancada = true;
        //     mostrarEsconderConsultaCliente = true;
        //     mostrarEsconderConsultaDataDia = true;
        //     mostrarEsconderConsultaDataPeriodo = true;
        //     mostrarEsconderConsultaVeiculo = true;
        //     mostrarEsconderConsultaData = true;
        // tableViewPesquisarLocacoes.setVisible(mostrarEsconderInfoPesquisa);
        // btnBuscarLocacao.setVisible(mostrarEsconderInfoPesquisa);
        // labelCodigoPesquisar.setVisible(mostrarEsconderInfoPesquisa);
        // textFieldBuscarLocacao.setVisible(mostrarEsconderInfoPesquisa);

    /**
     * Verifica se as variáveis estão visíveis, caso algum esteja visível o código
     * as deixa invisíveis.
     * Depois o código deixa as variáveis visíveis dependendo do valor da variável
     * mostrarEsconderConsultaAvancada.
     * E então a variável mostrarEsconderConsultaAvancada é invertida (caso esteja
     * como verdadeira, passa a ser falsa e vice-versa).
     * 
     * @param event realiza a ação do evento
     */
    // @FXML
    // void btnConsultaAvancada(ActionEvent event) {
    //     if (tableViewInfoLocacoes.isVisible() || btnBuscarLocacao.isVisible() || btnConsultaPeriodo.isVisible() || tableViewConsultaAvancada.isVisible() || btnBuscarCpfAvancada.isVisible() || btnBuscarDataEspecificaAvancada.isVisible() || btnBuscarPeriodoAvancada.isVisible() || btnBuscarPlacaAvancada.isVisible()) {
    //         tableViewInfoLocacoes.setVisible(false);
    //         btnBuscarLocacao.setVisible(false);
    //         labelCodigoPesquisar.setVisible(false);
    //         textFieldBuscarLocacao.setVisible(false);
    //         textFieldBuscarCpfAvancada.setVisible(false);
    //         textFieldBuscarPlacaAvancada.setVisible(false);
    //         tableViewPesquisarLocacoes.setVisible(false);
    //         tableViewConsultaAvancada.setVisible(false);
    //         btnBuscarCpfAvancada.setVisible(false);
    //         btnBuscarDataEspecificaAvancada.setVisible(false);
    //         btnBuscarPeriodoAvancada.setVisible(false);
    //         btnBuscarPlacaAvancada.setVisible(false);
    //         btnConsultaCliente.setVisible(false);
    //         btnConsultaData.setVisible(false);
    //         btnConsultaDataEspecifica.setVisible(false);
    //         btnConsultaPeriodo.setVisible(false);
    //         btnConsultaVeiculo.setVisible(false);
    //         choiceBoxDiaEspecifico.setVisible(false);
    //         choiceBoxDiaPeriodoDe.setVisible(false);
    //         choiceBoxDiaPeriodoPara.setVisible(false);
    //         choiceBoxMesEspecifico.setVisible(false);
    //         choiceBoxMesPeriodoDe.setVisible(false);
    //         choiceBoxMesPeriodoPara.setVisible(false);
    //         choiceBoxAnoEspecifico.setVisible(false);
    //         choiceBoxAnoPeriodoDe.setVisible(false);
    //         choiceBoxAnoPeriodoPara.setVisible(false);
    //         labelCpfAvancada.setVisible(false);
    //         labelDataAvancada.setVisible(false);
    //         labelDeAvancada.setVisible(false);
    //         labelParaAvancada.setVisible(false);
    //         labelPlacaAvancada.setVisible(false);

    //         mostrarEsconderInfoCompleta = true;
    //         mostrarEsconderInfoPesquisa = true;
    //         mostrarEsconderConsultaCliente = true;
    //         mostrarEsconderConsultaDataDia = true;
    //         mostrarEsconderConsultaDataPeriodo = true;
    //         mostrarEsconderConsultaVeiculo = true;
    //         mostrarEsconderConsultaData = true;
    //     }

    //     btnConsultaCliente.setVisible(mostrarEsconderConsultaAvancada);
    //     textBuscarAvancada.setVisible(mostrarEsconderConsultaAvancada);
    //     btnConsultaData.setVisible(mostrarEsconderConsultaAvancada);
    //     btnConsultaVeiculo.setVisible(mostrarEsconderConsultaAvancada);
    //     mostrarEsconderConsultaAvancada = !mostrarEsconderConsultaAvancada;
    // }

    /**
     * Verifica se as variáveis estão visíveis, caso algum esteja visível o código
     * as deixa invisíveis.
     * Depois o código deixa as variáveis visíveis dependendo do valor da variável
     * mostrarEsconderConsultaAvancada.
     * E então a variável mostrarEsconderConsultaAvancada é invertida (caso esteja
     * como verdadeira, passa a ser falsa e vice-versa).
     * Por fim cria uma lista de objetos do tipo Locacao e é atribuida como conteudo
     * da tabela
     * 
     * @param event realiza a ação do evento
     */
    // @FXML
    // void btnConsultaCliente(ActionEvent event) {
    //     if (tableViewInfoLocacoes.isVisible() || btnBuscarLocacao.isVisible() || btnConsultaPeriodo.isVisible() ||  tableViewConsultaAvancada.isVisible() || btnConsultaVeiculo.isVisible() || btnBuscarDataEspecificaAvancada.isVisible() || btnBuscarPeriodoAvancada.isVisible() || btnBuscarPlacaAvancada.isVisible()) {
    //         tableViewInfoLocacoes.setVisible(false);
    //         btnBuscarLocacao.setVisible(false);
    //         labelCodigoPesquisar.setVisible(false);
    //         textFieldBuscarLocacao.setVisible(false);
    //         textFieldBuscarPlacaAvancada.setVisible(false);
    //         tableViewPesquisarLocacoes.setVisible(false);
    //         btnBuscarDataEspecificaAvancada.setVisible(false);
    //         btnBuscarPeriodoAvancada.setVisible(false);
    //         btnBuscarPlacaAvancada.setVisible(false);
    //         btnConsultaCliente.setVisible(false);
    //         btnConsultaData.setVisible(false);
    //         btnConsultaDataEspecifica.setVisible(false);
    //         btnConsultaPeriodo.setVisible(false);
    //         btnConsultaVeiculo.setVisible(false);
    //         choiceBoxDiaEspecifico.setVisible(false);
    //         choiceBoxDiaPeriodoDe.setVisible(false);
    //         choiceBoxDiaPeriodoPara.setVisible(false);
    //         choiceBoxMesEspecifico.setVisible(false);
    //         choiceBoxMesPeriodoDe.setVisible(false);
    //         choiceBoxMesPeriodoPara.setVisible(false);
    //         choiceBoxAnoEspecifico.setVisible(false);
    //         choiceBoxAnoPeriodoDe.setVisible(false);
    //         choiceBoxAnoPeriodoPara.setVisible(false);
    //         labelDataAvancada.setVisible(false);
    //         labelDeAvancada.setVisible(false);
    //         labelParaAvancada.setVisible(false);
    //         labelPlacaAvancada.setVisible(false);

    //         mostrarEsconderInfoCompleta = true;
    //         mostrarEsconderInfoPesquisa = true;
    //         mostrarEsconderConsultaAvancada = true;
    //         mostrarEsconderConsultaDataDia = true;
    //         mostrarEsconderConsultaDataPeriodo = true;
    //         mostrarEsconderConsultaVeiculo = true;
    //         mostrarEsconderConsultaData = true;
    //     }
    //     ObservableList<Locacao> observableListLocacoes = FXCollections.observableArrayList();

    //     tableViewConsultaAvancada.setItems(observableListLocacoes);
    //     tableViewConsultaAvancada.setVisible(mostrarEsconderConsultaCliente);
    //     labelCpfAvancada.setVisible(mostrarEsconderConsultaCliente);
    //     btnBuscarCpfAvancada.setVisible(mostrarEsconderConsultaCliente);
    //     textFieldBuscarCpfAvancada.setVisible(mostrarEsconderConsultaCliente);
    //     mostrarEsconderConsultaCliente = !mostrarEsconderConsultaCliente;
    // }

    /**
     * Verifica se as variáveis estão visíveis, caso algum esteja visível o código
     * as deixa invisíveis.
     * Depois o código deixa as variáveis visíveis dependendo do valor da variável
     * mostrarEsconderConsultaAvancada.
     * E então a variável mostrarEsconderConsultaAvancada é invertida (caso esteja
     * como verdadeira, passa a ser falsa e vice-versa).
     * Por fim cria uma lista de objetos do tipo Locacao e é atribuida como conteudo
     * da tabela
     * 
     * @param event realiza a ação do evento
     */
    // @FXML
    // void btnConsultaVeiculo(ActionEvent event) {
    //     if (tableViewInfoLocacoes.isVisible() || btnBuscarLocacao.isVisible() || btnConsultaPeriodo.isVisible() || tableViewConsultaAvancada.isVisible() || btnConsultaVeiculo.isVisible() || btnBuscarDataEspecificaAvancada.isVisible() || btnBuscarPeriodoAvancada.isVisible() || btnBuscarCpfAvancada.isVisible()) {
    //         tableViewInfoLocacoes.setVisible(false);
    //         btnBuscarLocacao.setVisible(false);
    //         labelCodigoPesquisar.setVisible(false);
    //         textFieldBuscarLocacao.setVisible(false);
    //         textFieldBuscarCpfAvancada.setVisible(false);
    //         tableViewPesquisarLocacoes.setVisible(false);
    //         btnBuscarDataEspecificaAvancada.setVisible(false);
    //         btnBuscarPeriodoAvancada.setVisible(false);
    //         btnBuscarCpfAvancada.setVisible(false);
    //         btnConsultaDataEspecifica.setVisible(false);
    //         btnConsultaPeriodo.setVisible(false);
    //         choiceBoxDiaEspecifico.setVisible(false);
    //         choiceBoxDiaPeriodoDe.setVisible(false);
    //         choiceBoxDiaPeriodoPara.setVisible(false);
    //         choiceBoxMesEspecifico.setVisible(false);
    //         choiceBoxMesPeriodoDe.setVisible(false);
    //         choiceBoxMesPeriodoPara.setVisible(false);
    //         choiceBoxAnoEspecifico.setVisible(false);
    //         choiceBoxAnoPeriodoDe.setVisible(false);
    //         choiceBoxAnoPeriodoPara.setVisible(false);
    //         labelDataAvancada.setVisible(false);
    //         labelDeAvancada.setVisible(false);
    //         labelParaAvancada.setVisible(false);
    //         labelCpfAvancada.setVisible(false);

    //         mostrarEsconderInfoCompleta = true;
    //         mostrarEsconderInfoPesquisa = true;
    //         mostrarEsconderConsultaAvancada = true;
    //         mostrarEsconderConsultaDataDia = true;
    //         mostrarEsconderConsultaDataPeriodo = true;
    //         mostrarEsconderConsultaCliente = true;
    //         mostrarEsconderConsultaData = true;
    //     }
    //     ObservableList<Locacao> observableListLocacoes = FXCollections.observableArrayList();

    //     tableViewConsultaAvancada.setItems(observableListLocacoes);
    //     tableViewConsultaAvancada.setVisible(mostrarEsconderConsultaVeiculo);
    //     labelPlacaAvancada.setVisible(mostrarEsconderConsultaVeiculo);
    //     btnBuscarPlacaAvancada.setVisible(mostrarEsconderConsultaVeiculo);
    //     textFieldBuscarPlacaAvancada.setVisible(mostrarEsconderConsultaVeiculo);
    //     mostrarEsconderConsultaVeiculo = !mostrarEsconderConsultaVeiculo;
    // }

    /**
     * Verifica se as variáveis estão visíveis, caso algum esteja visível o código
     * as deixa invisíveis.
     * Depois o código deixa as variáveis visíveis dependendo do valor da variável
     * mostrarEsconderConsultaAvancada.
     * E então a variável mostrarEsconderConsultaAvancada é invertida (caso esteja
     * como verdadeira, passa a ser falsa e vice-versa).
     * 
     * @param event
     */
    // @FXML
    // void btnConsultaData(ActionEvent event) {
    //     if (tableViewInfoLocacoes.isVisible() || btnConsultaPeriodo.isVisible() || btnBuscarLocacao.isVisible() || tableViewConsultaAvancada.isVisible() || btnConsultaVeiculo.isVisible() || btnBuscarDataEspecificaAvancada.isVisible() || btnBuscarPeriodoAvancada.isVisible() || btnBuscarCpfAvancada.isVisible()) {
    //         tableViewInfoLocacoes.setVisible(false);
    //         tableViewConsultaAvancada.setVisible(false);
    //         btnBuscarLocacao.setVisible(false);
    //         labelCodigoPesquisar.setVisible(false);
    //         textFieldBuscarLocacao.setVisible(false);
    //         textFieldBuscarCpfAvancada.setVisible(false);
    //         textFieldBuscarPlacaAvancada.setVisible(false);
    //         tableViewPesquisarLocacoes.setVisible(false);
    //         btnBuscarDataEspecificaAvancada.setVisible(false);
    //         btnBuscarPeriodoAvancada.setVisible(false);
    //         btnBuscarCpfAvancada.setVisible(false);
    //         btnBuscarPlacaAvancada.setVisible(false);
    //         btnConsultaCliente.setVisible(false);
    //         btnConsultaData.setVisible(false);
    //         btnConsultaVeiculo.setVisible(false);
    //         choiceBoxDiaEspecifico.setVisible(false);
    //         choiceBoxDiaPeriodoDe.setVisible(false);
    //         choiceBoxDiaPeriodoPara.setVisible(false);
    //         choiceBoxMesEspecifico.setVisible(false);
    //         choiceBoxMesPeriodoDe.setVisible(false);
    //         choiceBoxMesPeriodoPara.setVisible(false);
    //         choiceBoxAnoEspecifico.setVisible(false);
    //         choiceBoxAnoPeriodoDe.setVisible(false);
    //         choiceBoxAnoPeriodoPara.setVisible(false);
    //         labelDataAvancada.setVisible(false);
    //         labelDeAvancada.setVisible(false);
    //         labelParaAvancada.setVisible(false);
    //         labelCpfAvancada.setVisible(false);
    //         labelPlacaAvancada.setVisible(false);

    //         mostrarEsconderInfoCompleta = true;
    //         mostrarEsconderInfoPesquisa = true;
    //         mostrarEsconderConsultaAvancada = true;
    //         mostrarEsconderConsultaDataDia = true;
    //         mostrarEsconderConsultaDataPeriodo = true;
    //         mostrarEsconderConsultaCliente = true;
    //         mostrarEsconderConsultaVeiculo = true;
    //     }

    //     btnConsultaDataEspecifica.setVisible(mostrarEsconderConsultaData);
    //     btnConsultaPeriodo.setVisible(mostrarEsconderConsultaData);
    //     mostrarEsconderConsultaData = !mostrarEsconderConsultaData;
    // }

    /**
     * Verifica se as variáveis estão visíveis, caso algum esteja visível o código
     * as deixa invisíveis.
     * Depois o código deixa as variáveis visíveis dependendo do valor da variável
     * mostrarEsconderConsultaAvancada.
     * E então a variável mostrarEsconderConsultaAvancada é invertida (caso esteja
     * como verdadeira, passa a ser falsa e vice-versa).
     * Por fim cria uma lista de objetos do tipo Locacao e é atribuida como conteudo
     * da tabela
     * 
     * @param event realiza a ação do evento
     */
    // @FXML
    // void btnConsultaDataEspecifica(ActionEvent event) {
    //     if (tableViewInfoLocacoes.isVisible() || btnConsultaPeriodo.isVisible() || btnBuscarLocacao.isVisible() || tableViewConsultaAvancada.isVisible() || btnConsultaVeiculo.isVisible() || btnBuscarPeriodoAvancada.isVisible() || btnBuscarCpfAvancada.isVisible()) {
    //         tableViewInfoLocacoes.setVisible(false);
    //         btnBuscarLocacao.setVisible(false);
    //         labelCodigoPesquisar.setVisible(false);
    //         textFieldBuscarLocacao.setVisible(false);
    //         textFieldBuscarCpfAvancada.setVisible(false);
    //         textFieldBuscarPlacaAvancada.setVisible(false);
    //         tableViewPesquisarLocacoes.setVisible(false);
    //         btnBuscarPeriodoAvancada.setVisible(false);
    //         btnBuscarCpfAvancada.setVisible(false);
    //         btnBuscarPlacaAvancada.setVisible(false);
    //         btnConsultaCliente.setVisible(false);
    //         btnConsultaData.setVisible(false);
    //         btnConsultaVeiculo.setVisible(false);
    //         btnConsultaDataEspecifica.setVisible(false);
    //         btnConsultaPeriodo.setVisible(false);
    //         choiceBoxDiaPeriodoDe.setVisible(false);
    //         choiceBoxDiaPeriodoPara.setVisible(false);
    //         choiceBoxMesPeriodoDe.setVisible(false);
    //         choiceBoxMesPeriodoPara.setVisible(false);
    //         choiceBoxAnoPeriodoDe.setVisible(false);
    //         choiceBoxAnoPeriodoPara.setVisible(false);
    //         labelDeAvancada.setVisible(false);
    //         labelParaAvancada.setVisible(false);
    //         labelCpfAvancada.setVisible(false);
    //         labelPlacaAvancada.setVisible(false);

    //         mostrarEsconderInfoCompleta = true;
    //         mostrarEsconderInfoPesquisa = true;
    //         mostrarEsconderConsultaAvancada = true;
    //         mostrarEsconderConsultaData = true;
    //         mostrarEsconderConsultaDataPeriodo = true;
    //         mostrarEsconderConsultaCliente = true;
    //         mostrarEsconderConsultaVeiculo = true;
    //     }
    //     ObservableList<Locacao> observableListLocacoes = FXCollections.observableArrayList();

    //     tableViewConsultaAvancada.setItems(observableListLocacoes);
    //     tableViewConsultaAvancada.setVisible(mostrarEsconderConsultaDataDia);
    //     btnBuscarDataEspecificaAvancada.setVisible(mostrarEsconderConsultaDataDia);
    //     choiceBoxDiaEspecifico.setVisible(mostrarEsconderConsultaDataDia);
    //     choiceBoxMesEspecifico.setVisible(mostrarEsconderConsultaDataDia);
    //     choiceBoxAnoEspecifico.setVisible(mostrarEsconderConsultaDataDia);
    //     labelDataAvancada.setVisible(mostrarEsconderConsultaDataDia);
    //     mostrarEsconderConsultaDataDia = !mostrarEsconderConsultaDataDia;
    // }

    /**
     * Verifica se as variáveis estão visíveis, caso algum esteja visível o código
     * as deixa invisíveis.
     * Depois o código deixa as variáveis visíveis dependendo do valor da variável
     * mostrarEsconderConsultaAvancada.
     * E então a variável mostrarEsconderConsultaAvancada é invertida (caso esteja
     * como verdadeira, passa a ser falsa e vice-versa).
     * Por fim cria uma lista de objetos do tipo Locacao e é atribuida como conteudo
     * da tabela
     * 
     * @param event realiza a ação do evento
     */
    // @FXML
    // void btnConsultaPeriodo(ActionEvent event) {
    //     if (tableViewInfoLocacoes.isVisible() || btnConsultaPeriodo.isVisible() || btnBuscarLocacao.isVisible() || tableViewConsultaAvancada.isVisible() || btnConsultaVeiculo.isVisible() || btnBuscarDataEspecificaAvancada.isVisible() || btnBuscarCpfAvancada.isVisible()) {
    //         tableViewInfoLocacoes.setVisible(false);
    //         btnBuscarLocacao.setVisible(false);
    //         labelCodigoPesquisar.setVisible(false);
    //         textFieldBuscarLocacao.setVisible(false);
    //         textFieldBuscarCpfAvancada.setVisible(false);
    //         textFieldBuscarPlacaAvancada.setVisible(false);
    //         tableViewPesquisarLocacoes.setVisible(false);
    //         btnBuscarCpfAvancada.setVisible(false);
    //         btnBuscarPlacaAvancada.setVisible(false);
    //         btnConsultaCliente.setVisible(false);
    //         btnConsultaData.setVisible(false);
    //         btnConsultaVeiculo.setVisible(false);
    //         btnConsultaDataEspecifica.setVisible(false);
    //         btnConsultaPeriodo.setVisible(false);
    //         labelCpfAvancada.setVisible(false);
    //         labelPlacaAvancada.setVisible(false);
    //         btnBuscarDataEspecificaAvancada.setVisible(false);
    //         choiceBoxDiaEspecifico.setVisible(false);
    //         choiceBoxMesEspecifico.setVisible(false);
    //         choiceBoxAnoEspecifico.setVisible(false);
    //         labelDataAvancada.setVisible(false);

    //         mostrarEsconderInfoCompleta = true;
    //         mostrarEsconderInfoPesquisa = true;
    //         mostrarEsconderConsultaAvancada = true;
    //         mostrarEsconderConsultaData = true;
    //         mostrarEsconderConsultaDataDia = true;
    //         mostrarEsconderConsultaCliente = true;
    //         mostrarEsconderConsultaVeiculo = true;
    //     }
    //     ObservableList<Locacao> observableListLocacoes = FXCollections.observableArrayList();

    //     tableViewConsultaAvancada.setItems(observableListLocacoes);
    //     tableViewConsultaAvancada.setVisible(mostrarEsconderConsultaDataPeriodo);
    //     labelDeAvancada.setVisible(mostrarEsconderConsultaDataPeriodo);
    //     labelParaAvancada.setVisible(mostrarEsconderConsultaDataPeriodo);
    //     choiceBoxDiaPeriodoDe.setVisible(mostrarEsconderConsultaDataPeriodo);
    //     choiceBoxDiaPeriodoPara.setVisible(mostrarEsconderConsultaDataPeriodo);
    //     choiceBoxMesPeriodoDe.setVisible(mostrarEsconderConsultaDataPeriodo);
    //     choiceBoxMesPeriodoPara.setVisible(mostrarEsconderConsultaDataPeriodo);
    //     choiceBoxAnoPeriodoDe.setVisible(mostrarEsconderConsultaDataPeriodo);
    //     choiceBoxAnoPeriodoPara.setVisible(mostrarEsconderConsultaDataPeriodo);
    //     btnBuscarPeriodoAvancada.setVisible(mostrarEsconderConsultaDataPeriodo);
    //     mostrarEsconderConsultaDataPeriodo = !mostrarEsconderConsultaDataPeriodo;
    // }

    /**
     * Cria uma lista observável de locações, que será exibida em uma tabela.
     * Tenta ler o CPF inserido pelo usuário e verifica se esse CPF está cadastrado
       no sistema.
     * Se não estiver, é exibida uma mensagem de erro.
     * Percorre a lista de locações e adiciona todas aquelas que foram realizadas
       pelo cliente cujo CPF foi
       informado pelo usuário à lista observável. Se não houver nenhuma locação para
       o cliente, é exibida outra mensagem de erro. Se tudo ocorrer bem, a tabela é
       atualizada com as locações encontradas.
     * 
     * @param event inicia o evento
     */
    // @FXML
    // void btnBuscarCpfAvancada(ActionEvent event) {
    //     String cpf = null;
    //     int contaLocacoes = 0;

    //     if (tableViewConsultaAvancada.isVisible()) {
    //         ObservableList<Locacao> observableListLocacoes = FXCollections.observableArrayList();

    //         try {
    //             cpf = BibMetodos.lerCPF(textFieldBuscarCpfAvancada.getText());
    //             try {
    //                 if (!(listaClientes.existe(cpf))) {
    //                     throw new NullPointerException();
    //                 }
    //             } catch (Exception e) {
    //                 Alert alert = new Alert(Alert.AlertType.ERROR);
    //                 alert.setTitle("Erro!");
    //                 alert.setHeaderText(null);
    //                 alert.setContentText("O CPF inserido não está cadastrado no sistema!");
    //                 alert.showAndWait();
    //             }
    //             for (Locacao locacao : listaLocacoes.getListLocacoes()) {
    //                 if(locacao.getCliente().getCpf().equals(cpf)) {
    //                     observableListLocacoes.add(locacao);
    //                     contaLocacoes++;
    //                 }
    //             }
    //             if (contaLocacoes != 0) {
    //                 tableViewConsultaAvancada.setItems(observableListLocacoes);
    //             } else {
    //                 throw new NullPointerException();
    //             }
    //         } catch (Exception e) {
    //             Alert alert = new Alert(Alert.AlertType.ERROR);
    //             alert.setTitle("Erro!");
    //             alert.setHeaderText(null);
    //             alert.setContentText("CPF inválido ou não existem locações cadastradas para este cliente!");
    //             alert.showAndWait();
    //         }
    //     }
    // }

    // /**
    //  * Método que busca por locações cadastradas para um veículo específico,
    //  * identificado por sua placa.
    //  * 
    //  * @param event inicia o evento
    //  */
    // @FXML
    // void btnBuscarPlacaAvancada(ActionEvent event) {
    //     String placa = null;
    //     int contaLocacoes = 0;

    //     if (tableViewConsultaAvancada.isVisible()) {
    //         ObservableList<Locacao> observableListLocacoes = FXCollections.observableArrayList();

    //         try {
    //             placa = BibMetodos.lerPlaca(textFieldBuscarPlacaAvancada.getText());
    //             try {
    //                 if (!(listaVeiculos.existe(placa))) {
    //                     throw new NullPointerException();
    //                 }
    //             } catch (Exception e) {
    //                 Alert alert = new Alert(Alert.AlertType.ERROR);
    //                 alert.setTitle("Erro!");
    //                 alert.setHeaderText(null);
    //                 alert.setContentText("A placa inserida não está cadastrada no sistema!");
    //                 alert.showAndWait();
    //             }
    //             for (Locacao locacao : listaLocacoes.getListLocacoes()) {
    //                 if(locacao.getVeiculo().getPlaca().equals(placa)) {
    //                     observableListLocacoes.add(locacao);
    //                     contaLocacoes++;
    //                 }
    //             }
    //             if (contaLocacoes != 0) {
    //                 tableViewConsultaAvancada.setItems(observableListLocacoes);
    //             } else {
    //                 throw new NullPointerException();
    //             }
    //         } catch (Exception e) {
    //             Alert alert = new Alert(Alert.AlertType.ERROR);
    //             alert.setTitle("Erro!");
    //             alert.setHeaderText(null);
    //             alert.setContentText("Placa inválida ou não existem locações cadastradas para este veículo!");
    //             alert.showAndWait();
    //         }
    //     }
    // }

    // /**
    //  * Método que busca por locações cadastradas em uma data especificada pelo
    //  * usuário.
    //  * 
    //  * @param event inicia o evento
    //  */
    // @FXML
    // void btnBuscarDataEspecificaAvancada(ActionEvent event) {
    //     Calendar data = null;
    //     int contaLocacoes = 0;

    //     if (tableViewConsultaAvancada.isVisible()) {
    //         ObservableList<Locacao> observableListLocacoes = FXCollections.observableArrayList();

    //         try {
    //             data = BibMetodos.lerData(Integer.parseInt(choiceBoxDiaEspecifico.getValue()), Integer.parseInt(choiceBoxMesEspecifico.getValue()), Integer.parseInt(choiceBoxAnoEspecifico.getValue()));

    //             for (Locacao locacao : listaLocacoes.getListLocacoes()) {
    //                 if((locacao.getDataInicial().get(Calendar.DAY_OF_MONTH) == data.get(Calendar.DAY_OF_MONTH) 
    //                 && locacao.getDataInicial().get(Calendar.MONTH) == data.get(Calendar.MONTH) 
    //                 && locacao.getDataInicial().get(Calendar.YEAR) == data.get(Calendar.YEAR)) || 
    //                 (locacao.getDataFinal().get(Calendar.DAY_OF_MONTH) == data.get(Calendar.DAY_OF_MONTH) 
    //                 && locacao.getDataFinal().get(Calendar.MONTH) == data.get(Calendar.MONTH) 
    //                 && locacao.getDataFinal().get(Calendar.YEAR) == data.get(Calendar.YEAR))) {
    //                     observableListLocacoes.add(locacao);
    //                     contaLocacoes++;
    //                 }
    //             }
    //             if (contaLocacoes != 0) {
    //                 tableViewConsultaAvancada.setItems(observableListLocacoes);
    //             } else {
    //                 throw new NullPointerException();
    //             }
    //         } catch (Exception e) {
    //             Alert alert = new Alert(Alert.AlertType.ERROR);
    //             alert.setTitle("Erro!");
    //             alert.setHeaderText(null);
    //             alert.setContentText("Data inválida ou não existem locações cadastradas nesta data!");
    //             alert.showAndWait();
    //         }
    //     }
    // }

    // /**
    //  * Método que busca por locações cadastradas entre duas datas especificadas pelo
    //  * usuário.
    //  * 
    //  * @param event inicia o evento
    //  */
    // @FXML
    // void btnBuscarPeriodoAvancada(ActionEvent event) {
    //     Calendar dataInicial = null, dataFinal = null;
    //     int contaLocacoes = 0;

    //     if (tableViewConsultaAvancada.isVisible()) {
    //         ObservableList<Locacao> observableListLocacoes = FXCollections.observableArrayList();

    //         try {
    //             dataInicial = BibMetodos.lerData(Integer.parseInt(choiceBoxDiaPeriodoDe.getValue()), Integer.parseInt(choiceBoxMesPeriodoDe.getValue()), Integer.parseInt(choiceBoxAnoPeriodoDe.getValue()));
    //             dataFinal = BibMetodos.lerData(Integer.parseInt(choiceBoxDiaPeriodoPara.getValue()), Integer.parseInt(choiceBoxDiaPeriodoPara.getValue()), Integer.parseInt(choiceBoxDiaPeriodoPara.getValue()));


    //             for (Locacao locacao : listaLocacoes.getListLocacoes()) {
    //                 if(dataInicial.after(locacao.getDataInicial()) || dataFinal.before(locacao.getDataFinal())) {
    //                     observableListLocacoes.add(locacao);
    //                     contaLocacoes++;
    //                 }
    //             }
    //             if (contaLocacoes != 0) {
    //                 tableViewConsultaAvancada.setItems(observableListLocacoes);
    //             } else {
    //                 throw new NullPointerException();
    //             }
    //         } catch (Exception e) {
    //             Alert alert = new Alert(Alert.AlertType.ERROR);
    //             alert.setTitle("Erro!");
    //             alert.setHeaderText(null);
    //             alert.setContentText("Data inválida ou não existem locações cadastradas nesta data!");
    //             alert.showAndWait();
    //         }
    //     }
    // }

    /**
     * Volta para o arquivo "MenuLocacoes.fxml" e o atribui ao objeto
     * "VBoxMenuLocacoes"
     * Remove os elementos filhos do objeto "rootVBox" e adiciona o
     * "VBoxMenuLocacoes como um novo filho"
     * 
     * @param event Determina a ação de acessar o MenuLocacoes
     */
    @FXML
    void voltarMenuLocacoes(ActionEvent event) {
        try {
            VBox VBoxMenuLocacoes = FXMLLoader.load(getClass().getResource("MenuLocacoes.fxml"));
            rootVBox2.getChildren().setAll(VBoxMenuLocacoes);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void esconderTabelas(ActionEvent event) {
        tableViewPesquisarLocacoes.setVisible(false);
    }
}
