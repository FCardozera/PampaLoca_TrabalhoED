package Interface;

import ClassesBase.Categoria;
import ClassesBase.VetorCategoria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class MenuDadosCategoria {

    @FXML
    private TableColumn<Categoria, Integer> columnIdentificadorInfo;

    @FXML
    private TableColumn<Categoria, String> columnNomeCategoriaInfo;

    @FXML
    private VBox rootVBox2;

    @FXML
    private TableView<Categoria> tableViewInfoCategorias;

    @FXML
    private Button voltarMenuCategorias;

    private VetorCategoria vetorCategoria;

    @FXML
    void initialize() {
        vetorCategoria = LocadoraVeiculos.getVetorCategoria();
        columnIdentificadorInfo.setCellValueFactory(new PropertyValueFactory<Categoria, Integer>("identificador"));
        columnNomeCategoriaInfo.setCellValueFactory(new PropertyValueFactory<Categoria, String>("nome"));
        ObservableList<Categoria> observableListCategorias = FXCollections.observableArrayList();
        Categoria [] categorias = new Categoria[vetorCategoria.tamanho()];
        categorias = vetorCategoria.getCategoria();

        for (int i = 0; i < vetorCategoria.tamanho(); i++) {
            observableListCategorias.add(categorias[i]);
        }
        tableViewInfoCategorias.setItems(observableListCategorias);
    }

    @FXML
    void voltarMenuCategorias(ActionEvent event) {
        try {
            VBox VBoxMenuCategorias = FXMLLoader.load(getClass().getResource("MenuCategoria.fxml"));
            rootVBox2.getChildren().setAll(VBoxMenuCategorias);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
