package ClassesBase;

/**
 * A classe Cliente modela um cliente do sistema.
 * @author Mateus, João, Felipe
 */

public class Categoria {
    private String nome;
    private int identificador;

    public Categoria(String nome, int identificador) {
        this.nome = nome;
        this.identificador = identificador;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return "/nNome: " + this.nome + "/nIdentificador: " + this.identificador;
    }
}

