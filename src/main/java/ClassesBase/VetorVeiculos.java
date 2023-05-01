package ClassesBase;

import Bib.*;

public class VetorVeiculos implements IVetor{
    private Veiculo [] veiculos;
    private int tamanhoVetor = 0;
    private int tamanhoAtual = 0;

    public VetorVeiculos(int tamanhoVetor) {
        veiculos = new Veiculo[tamanhoVetor];
        this.tamanhoVetor = tamanhoVetor;
    }
    
    public void adiciona(Object objeto) {
        this.garanteEspaco();
        if (objeto instanceof Veiculo) {
            this.veiculos[this.tamanhoAtual] = (Veiculo) objeto;
            this.tamanhoAtual++;
        }
    }

    public int tamanho() {
        return tamanhoAtual;
    }

    public Veiculo[] getVeiculos() {
        return veiculos;
    }

    public Veiculo getVeiculo(String placa) {
        for (int i = 0; i < this.tamanhoAtual; i++) {
            if (veiculos[i].getPlaca().equals(placa)) {
                return veiculos[i];
            }
        }
        return null;
    }

    public boolean contemPlaca(String placa) {
        for (int i = 0; i < this.tamanhoAtual; i++) {
            if (veiculos[i].getPlaca().equals(placa)) {
                return true;
            }
        }
        return false;
    }

    public boolean contem(Object objeto) {
        for (int i = 0; i < this.tamanhoAtual; i++) {
            if (veiculos[i].equals(objeto)) {
                return true;
            }
        }
        return false;
    }

    private void garanteEspaco() {
        if (this.cheio()) {
            Veiculo[] novoVeiculos = new Veiculo[this.veiculos.length * 2];
            for (int i = 0; i < this.veiculos.length; i++) {
                novoVeiculos[i] = veiculos[i];
            }
            this.veiculos = novoVeiculos;
        }
    }

    public boolean cheio() {
        if (this.tamanhoAtual == this.tamanhoVetor) {
            return true;
        }
        return false;
    }

    public boolean removePlaca(String placa) {
        int index = -1;
        for (int i = 0; i < this.veiculos.length; i++) {
            if (veiculos[i].getPlaca().equals(placa)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < (tamanhoAtual - 1); i++) {
                this.veiculos[i] = this.veiculos[i + 1];
            }
            this.tamanhoAtual--;
            this.veiculos[tamanhoAtual] = null;
            return true;
        }
        return false;
    }

    public boolean remove(Object objeto) {
        int index = -1;
        for (int i = 0; i < this.veiculos.length; i++) {
            if (veiculos[i].equals(objeto)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < (tamanhoAtual - 1); i++) {
                this.veiculos[i] = this.veiculos[i + 1];
            }
            this.tamanhoAtual--;
            this.veiculos[tamanhoAtual] = null;
            return true;
        }
        return false;
    }

    public String imprimeVetor() {
        String imprime = null;

        if(veiculos[0] != null) {
            for (int i = 0; i < this.veiculos.length; i++) {
            imprime += veiculos[i].toString();
            }
        }
        return imprime;
    }
    
}
