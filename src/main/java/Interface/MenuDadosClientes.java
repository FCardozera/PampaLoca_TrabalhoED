package Interface;

import ClassesBase.*;
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


public class MenuDadosClientes {

    @FXML
    private TableColumn<Cliente, String> columnCnhInfo;

    @FXML
    private TableColumn<Cliente, String> columnCpfInfo;

    @FXML
    private TableColumn<Cliente, String> columnNomeInfo;

    @FXML
    private TableColumn<Cliente, String> columnTelefoneInfo;

    @FXML
    private VBox rootVBox2;

    @FXML
    private TableView<Cliente> tableViewInfoCliente;

    @FXML
    private Button voltarMenuClientes;

    private VetorClientes vetorClientes;

    @FXML
    void initialize() {
        vetorClientes = LocadoraVeiculos.getVetorClientes();
        columnNomeInfo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        columnCnhInfo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cnh"));
        columnTelefoneInfo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));
        columnCpfInfo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
        ObservableList<Cliente> observableListClientes = FXCollections.observableArrayList();
        Cliente [] clientes = new Cliente[vetorClientes.tamanho()];
        clientes = vetorClientes.getClientes();

        for (int i = 0; i < vetorClientes.tamanho(); i++) {
            observableListClientes.add(clientes[i]);
        }
        tableViewInfoCliente.setItems(observableListClientes);
    }

    @FXML
    void voltarMenuClientes(ActionEvent event) {
        try {
            VBox VBoxMenuClientes = FXMLLoader.load(getClass().getResource("MenuClientes.fxml"));
            rootVBox2.getChildren().setAll(VBoxMenuClientes);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
