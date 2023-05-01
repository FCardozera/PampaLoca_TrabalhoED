package ClassesBase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import Bib.Utility;

public class Locacao{

    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
    private static int codigoUnico = 1;
    private static final float valorDiaria = 250F;
    private float valorTotal;
    private int codigo;
    private Cliente cliente;
    private Veiculo veiculo;
    private Calendar dataInicial, dataFinal;

    public Locacao(Cliente cliente, Veiculo veiculo, Calendar dataInicial, Calendar dataFinal) {
        long dias = Utility.diferencaDias(dataInicial, dataFinal);
        this.valorTotal = valorDiaria * dias;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.codigo = codigoUnico++;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Calendar getDataFinal() {
        return dataFinal;
    }

    public Calendar getDataInicial() {
        return dataInicial;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setDataFinal(Calendar dataFinal) {
        this.dataFinal = dataFinal;
    }

    public void setDataInicial(Calendar dataInicial) {
        this.dataInicial = dataInicial;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String toString() {
        return "/nLocação:/nCódigo: " + this.codigo + "\nCliente: " + this.cliente.toString() + 
        "\nVeículo: " + this.veiculo.toString() + ", Data Inicial: " + formato.format(dataInicial.getTime()) +
        ", Data Final:" + formato.format(dataFinal.getTime()) + "\n";
    }

}
