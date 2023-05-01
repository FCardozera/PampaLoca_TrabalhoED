package ClassesBase;

public class Locacao{

    private static int codigoUnico = 1;
    private int codigo;
    private Cliente cliente;
    private Veiculo veiculo;

    public Locacao(Cliente cliente, Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.codigo = codigoUnico++;
    }

    public String toString() {
        return "/nLocação:/nCódigo: " + this.codigo + "\nCliente: " + this.cliente.toString() + 
        "\nVeículo: " + this.veiculo.toString();
    }

}
