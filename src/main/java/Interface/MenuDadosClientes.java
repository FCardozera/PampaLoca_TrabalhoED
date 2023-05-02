package Interface;

import java.util.List;

import Bib.Utility;
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
    private Button btnPesquisarInfoCliente;

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

    private boolean mostrarEsconderInfoPesquisa = true;
    private boolean mostrarEsconderInfoCompleta = true;
    private boolean mostrarEsconderInfoResumo = true;

    private VetorClientes listaClientes;

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
        esconderTabelas(null);
        columnNomeInfo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        columnCnhInfo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nCarteira"));
        columnTelefoneInfo
                .setCellValueFactory(new Callback<CellDataFeatures<Cliente, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Cliente, String> c) {
                        return new SimpleObjectProperty<String>(
                                Utility.escreverTelefone(c.getValue().getTelefone()));
                    }
                });
        
        columnCpfInfo.setCellValueFactory(new Callback<CellDataFeatures<Cliente, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Cliente, String> c) {
                return new SimpleObjectProperty<String>(Utility.escreverCPF(c.getValue().getCpf()));
            }
        });
        
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
          
        tableViewInfoCliente.setVisible(false);

    }
}
