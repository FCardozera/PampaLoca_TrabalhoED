package Bib;

public interface ILista {
    public void insereInicio(Object objeto);
    public void insereFim(Object objeto);
    public boolean estaVazia();
    public boolean remove(Object objeto);
    public int tamanho();
    public String imprimeLista();
}
