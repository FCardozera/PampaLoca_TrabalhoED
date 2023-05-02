package ClassesBase;

import Bib.*;

public class ListaLocacoes implements ILista {
    private Noh inicio;

    public ListaLocacoes() {
        this.inicio = null;
    }

    public void insereInicio(Object objeto) {
        Noh novo = new Noh(objeto);

        if (inicio == null) {
            inicio = novo;
        } else {
            novo.setProximo(inicio);
            inicio = novo;
        }
    }

    public Noh getInicio() {
        return inicio;
    }

    public void insereFim(Object objeto) {
        Noh novo = new Noh(objeto);

        if (inicio == null) {
            inicio = novo;
        } else {
            Noh ultimo;
            for (Noh i = inicio; i != null; i = i.getProximo()) {
                ultimo = i;
                ultimo.setProximo(novo);
            }
        }
    }

    public boolean estaVazia() {
        if (inicio == null) {
            return true;
        }
        return false;
    }

    public Locacao getLocacao(int codigo) {
        Noh p;

        p = inicio;
        while (p != null && p.getLocacaoInfo().getCodigo() != codigo) {
            p = p.getProximo();
        }
        if (p == null) {
            return null;
        }
        return p.getLocacaoInfo();
    }

    public boolean contemCPF(String cpf) {
        Noh p;

        p = inicio;
        while (p != null && p.getLocacaoInfo().getCliente().getCpf() != cpf) {
            p = p.getProximo();
        }
        if (p == null) {
            return false;
        }
        return true;
    }

    public boolean contemPlaca(String placa) {
        Noh p;

        p = inicio;
        while (p != null && p.getLocacaoInfo().getVeiculo().getPlaca() != placa) {
            p = p.getProximo();
        }
        if (p == null) {
            return false;
        }
        return true;
    }

    public boolean contemCodigo(int codigo) {
        Noh p;

        p = inicio;
        while (p != null && p.getLocacaoInfo().getCodigo() != codigo) {
            p = p.getProximo();
        }
        if (p == null) {
            return false;
        }
        return true;
    }

    public boolean removePlaca(String placa) {
        Noh ant, p;

        ant = null;
        p = inicio;
        while (p != null && p.getLocacaoInfo().getVeiculo().getPlaca() != placa) {
            ant = p;
            p = p.getProximo();
        }
        if (p == null) {
            return false;
        }
        if (ant == null) {
            inicio = p.getProximo();
        } else {
            ant.setProximo(p.getProximo());
        }
        return true;
    }

    public boolean removeCodigo(int codigo) {
        Noh ant, p;

        ant = null;
        p = inicio;
        while (p != null && p.getLocacaoInfo().getCodigo() != codigo) {
            ant = p;
            p = p.getProximo();
        }
        if (p == null) {
            return false;
        }
        if (ant == null) {
            inicio = p.getProximo();
        } else {
            ant.setProximo(p.getProximo());
        }
        return true;
    }

    public boolean remove(Object objeto) {
        Noh ant, p;

        ant = null;
        p = inicio;
        while (p != null && p.getInfo() != objeto) {
            ant = p;
            p = p.getProximo();
        }
        if (p == null) {
            return false;
        }
        if (ant == null) {
            inicio = p.getProximo();
        } else {
            ant.setProximo(p.getProximo());
        }
        return true;
    }

    public int tamanho() {
        int tamanho = 0;
        if (inicio == null) {
            return tamanho;
        } else {
            for (Noh i = inicio; i != null; i = i.getProximo()) {
                if (i != null) {
                    tamanho++;
                }
            }
            return tamanho;
        }
    }

    public String imprimeLista() {
        String retorno = "";

        if (inicio == null) {
            retorno = "Lista Vazia!";
            return retorno;
        } else {
            for (Noh i = inicio; i != null; i = i.getProximo()) {
                if (i != null) {
                    retorno += "[" + i.getInfo().toString() + "] ";
                }
            }
            return retorno;
        }
    }
}
