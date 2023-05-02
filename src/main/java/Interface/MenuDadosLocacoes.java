package Interface;


import ClassesBase.*;
import Bib.*;
import java.text.SimpleDateFormat;
import ClassesBase.Locacao;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class MenuDadosLocacoes {

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
    private VBox rootVBox2;

    @FXML
    private TableView<Locacao> tableViewPesquisarLocacoes;

    @FXML
    private Button voltarMenuLocacoes;

    @FXML
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
   
    private ListaLocacoes listaLocacoes;

    @FXML
    void initialize() {
        listaLocacoes = LocadoraVeiculos.getListaLocacoes();
        columnCodigoPesquisar.setCellValueFactory(new PropertyValueFactory<Locacao, Integer>("codigo"));
        columnCpfPesquisar.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
            @Override    
            public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
                return new SimpleObjectProperty<String>(c.getValue().getCliente().getCpf());
            }
        });
        columnPlacaPesquisar.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
            @Override    
            public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
                return new SimpleObjectProperty<String>(c.getValue().getVeiculo().getPlaca());
            }
        });
        columnValorDiariaPesquisar.setCellValueFactory(new PropertyValueFactory<Locacao, Float>("valorTotal"));
        columnDataInicialPesquisar.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
            @Override    
            public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
                return new SimpleObjectProperty<String>(formato.format(c.getValue().getDataInicial().getTime()));
            }
        });
        columnDataFinalPesquisar.setCellValueFactory(new Callback<CellDataFeatures<Locacao, String>, ObservableValue<String>>() {    
            @Override    
            public ObservableValue<String> call(CellDataFeatures<Locacao, String> c) {
                return new SimpleObjectProperty<String>(formato.format(c.getValue().getDataFinal().getTime()));
            }
        });
        ObservableList<Locacao> observableListLocacao = FXCollections.observableArrayList();
        Noh inicio = listaLocacoes.getInicio();

        for (int i = 0; i < listaLocacoes.tamanho(); i++) {
            observableListLocacao.add(inicio.getLocacaoInfo());
            inicio = inicio.getProximo();
        }
        tableViewPesquisarLocacoes.setItems(observableListLocacao);
    }

    @FXML
    void voltarMenuLocacoes(ActionEvent event) {
        try {
            VBox VBoxMenuLocacoes = FXMLLoader.load(getClass().getResource("MenuLocacoes.fxml"));
            rootVBox2.getChildren().setAll(VBoxMenuLocacoes);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
