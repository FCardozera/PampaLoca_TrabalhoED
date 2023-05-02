package Interface;

import javafx.util.Callback;
import ClassesBase.Veiculo;
import ClassesBase.VetorVeiculos;
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
import javafx.beans.property.SimpleObjectProperty;

public class MenuDadosVeiculos {

    @FXML
    private TableColumn<Veiculo, Integer> columnAnoPesquisar;

    @FXML
    private TableColumn<Veiculo, String> columnCategoriaPesquisar;

    @FXML
    private TableColumn<Veiculo, Integer> columnLugaresPesquisar;

    @FXML
    private TableColumn<Veiculo, String> columnMarcaPesquisar;

    @FXML
    private TableColumn<Veiculo, String> columnModeloVeiculoPesquisar;

    @FXML
    private TableColumn<Veiculo, String> columnPlacaPesquisar;

    @FXML
    private TableColumn<Veiculo, Integer> columnPotenciaPesquisar;

    @FXML
    private VBox rootVBox2;

    @FXML
    private TableView<Veiculo> tableViewPesquisarVeiculo;

    @FXML
    private Button voltarMenuVeiculos;

    private VetorVeiculos vetorVeiculos;

    @FXML
    void initialize() {
        vetorVeiculos = LocadoraVeiculos.getVetorVeiculos();
        columnAnoPesquisar.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("ano"));
        columnPlacaPesquisar.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("placa"));
        columnMarcaPesquisar.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("marca"));
        columnModeloVeiculoPesquisar.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("modelo"));
        columnPotenciaPesquisar.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("potencia"));
        columnLugaresPesquisar.setCellValueFactory(new PropertyValueFactory<Veiculo, Integer>("lugares"));
        columnCategoriaPesquisar.setCellValueFactory(new Callback<CellDataFeatures<Veiculo, String>, ObservableValue<String>>() {    
            @Override    
            public ObservableValue<String> call(CellDataFeatures<Veiculo, String> c) {
                return new SimpleObjectProperty<String>(c.getValue().getCategoria().getNome());
            }
        });
        ObservableList<Veiculo> observableListVeiculos = FXCollections.observableArrayList();
        Veiculo [] veiculos = new Veiculo[vetorVeiculos.tamanho()];
        veiculos = vetorVeiculos.getVeiculos();

        for (int i = 0; i < vetorVeiculos.tamanho(); i++) {
            observableListVeiculos.add(veiculos[i]);
        }
        tableViewPesquisarVeiculo.setItems(observableListVeiculos);
    }

    @FXML
    void voltarMenuVeiculos(ActionEvent event) {
        try {
            VBox VBoxMenuVeiculos = FXMLLoader.load(getClass().getResource("MenuVeiculos.fxml"));
            rootVBox2.getChildren().setAll(VBoxMenuVeiculos);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}