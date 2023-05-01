package ClassesBase;

import Bib.IVetor;

public class VetorCategoria implements IVetor{
    private Categoria [] categorias;
    private int tamanhoVetor = 0;
    private int tamanhoAtual = 0;

    public VetorCategoria(int tamanhoVetor) {
        categorias = new Categoria[tamanhoVetor];
        this.tamanhoVetor = tamanhoVetor;
    }

    public void adiciona(Object objeto) {
        this.garanteEspaco();
        if (objeto instanceof Cliente) {
            this.categorias[this.tamanhoAtual] = (Categoria) objeto;
            this.tamanhoAtual++;
        }
    }

    public int tamanho() {
        return tamanhoAtual;
        
    }

    public Categoria[] getCategoria() {
        return categorias;
    }

    public Categoria getCategoriaID(int identificador) {
        for (int i = 0; i < this.tamanhoAtual; i++) {
            if (categorias[i].getIdentificador() == identificador) {
                return categorias[i];
            }
        }
        return null;
    }

    public boolean contemId(int identificador) {
        for (int i = 0; i < this.tamanhoAtual; i++) {
            if (categorias[i].getIdentificador() == identificador) {
                return true;
            }
        }
        return false;
        
    }

    public boolean contem(Object objeto) {
        for (int i = 0; i < this.tamanhoAtual; i++) {
            if (categorias[i].equals(objeto)) {
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

    public boolean removeId(int identificador) {
        int index = -1;
        for (int i = 0; i < this.categorias.length; i++) {
            if (categorias[i].getIdentificador() == identificador) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < (tamanhoAtual - 1); i++) {
                this.categorias[i] = this.categorias[i + 1];
            }
            this.tamanhoAtual--;
            this.categorias[tamanhoAtual] = null;
            return true;
        }
        return false;
    }

    public boolean remove(Object objeto) {
        int index = -1;
        for (int i = 0; i < this.categorias.length; i++) {
            if (categorias[i].equals(objeto)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < (tamanhoAtual - 1); i++) {
                this.categorias[i] = this.categorias[i + 1];
            }
            this.tamanhoAtual--;
            this.categorias[tamanhoAtual] = null;
            return true;
        }
        return false;
    }

    public String imprimeVetor() {
        String imprime = null;

        if(!categorias[0].equals(null)) {
            for (Categoria categoria : categorias) {
                imprime += categoria.toString();
            }
        }
        return imprime;
        
    }
    
    private void garanteEspaco() {
        if (this.cheio()) {
            Categoria[] novaCategoria = new Categoria[this.categorias.length * 2];
            for (int i = 0; i < this.categorias.length; i++) {
                novaCategoria[i] = categorias[i];
            }
            this.categorias = novaCategoria;
        }
    }
}
