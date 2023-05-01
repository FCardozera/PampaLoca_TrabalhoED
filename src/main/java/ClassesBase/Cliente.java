package ClassesBase;

/**
 * A classe Cliente modela um cliente do sistema.
 * @author Mateus, João, Felipe
 */


public class Cliente{

    private String nome;
    private String cpf;
    private String cnh;
    private String telefone;


    public Cliente(String nome, String cpf, String cnh, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.telefone = telefone;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String getCnh(){
        return this.cnh;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setCnh(String cnh){
        this.cnh = cnh;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String toString(){
        return "/nNome: " + this.nome + "\nCPF: " + this.cpf + "\nCNH: " + this.cnh + "\nTelefone: " + this.telefone;
    }

}