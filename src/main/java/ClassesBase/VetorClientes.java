package ClassesBase;

import Bib.*;

public class VetorClientes implements IVetor{
    private Cliente [] clientes;
    private int tamanhoVetor = 0;
    private int tamanhoAtual = 0;

    public VetorClientes(int tamanhoVetor) {
        clientes = new Cliente[tamanhoVetor];
        this.tamanhoVetor = tamanhoVetor;
    }
    
    public void adiciona(Object objeto) {
        this.garanteEspaco();
        if (objeto instanceof Cliente) {
            this.clientes[this.tamanhoAtual] = (Cliente) objeto;
            this.tamanhoAtual++;
        }
    }

    public int tamanho() {
        return tamanhoAtual;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public Cliente getCliente(String cpf) {
        for (int i = 0; i < this.tamanhoAtual; i++) {
            if (clientes[i].getCpf().equals(cpf)) {
                return clientes[i];
            }
        }
        return null;
    }

    public boolean contemCPF(String cpf) {
        for (int i = 0; i < this.tamanhoAtual; i++) {
            if (clientes[i].getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public boolean contem(Object objeto) {
        for (int i = 0; i < this.tamanhoAtual; i++) {
            if (clientes[i].equals(objeto)) {
                return true;
            }
        }
        return false;
    }

    public boolean cheio() {
        if (this.tamanhoAtual == this.tamanhoVetor) {
            return true;
        }
        return false;
    }

    public boolean remove(Object objeto) {
        int index = -1;
        for (int i = 0; i < this.clientes.length; i++) {
            if (clientes[i].equals(objeto)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < (tamanhoAtual - 1); i++) {
                this.clientes[i] = this.clientes[i + 1];
            }
            this.tamanhoAtual--;
            this.clientes[tamanhoAtual] = null;
            return true;
        }
        return false;
    }

    public boolean removeCPF(String cpf) {
        int index = -1;
        for (int i = 0; i < this.clientes.length; i++) {
            if (clientes[i].getCpf().equals(cpf)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < (tamanhoAtual - 1); i++) {
                this.clientes[i] = this.clientes[i + 1];
            }
            this.tamanhoAtual--;
            this.clientes[tamanhoAtual] = null;
            return true;
        }
        return false;
    }

    public String imprimeVetor() {
        String imprime = null;

        if(!clientes[0].equals(null)) {
            for (Cliente cliente : clientes) {
            imprime += cliente.toString();
            }
        }
        return imprime;
    }

    private void garanteEspaco() {
        if (this.cheio()) {
            Cliente[] novoClientes = new Cliente[this.clientes.length * 2];
            for (int i = 0; i < this.clientes.length; i++) {
                novoClientes[i] = clientes[i];
            }
            this.clientes = novoClientes;
        }
    }
    
}
