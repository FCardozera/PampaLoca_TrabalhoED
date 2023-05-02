package Bib;

import java.util.Calendar;
import java.util.InputMismatchException;
import ClassesBase.Categoria;
import ClassesBase.Veiculo;
import ClassesBase.VetorCategoria;
import ClassesBase.VetorVeiculos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



/**
 * Classe que servirá como uma biblioteca para métodos que serão utilizados no projeto.
 * @author Grupo Felipe, João e Mateus.
 */
public class Utility {

    /**
     * Método que vai ler Double e verificar se é válido.
     * @param dados Mensagem exibida para o usuário.
     * @return Um número Double válido.
     */
    public static double lerDouble(String dados) {
        double aux = 0;

        try {
            aux = Double.parseDouble(dados);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return aux;
    }

    /**
     * Método que vai ler Float e verificar se é válido.
     * @param dados Mensagem exibida para o usuário.
     * @return Um número Float válido.
     */
    public static float lerFloat(String dados) {
        float aux = 0;

        try {
            aux = Float.parseFloat(dados);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return aux;
    }

    /**
     * Método que vai ler Inteiro e verificar se é válido.
     * @param dados Mensagem exibida para o usuário.
     * @return Um número Inteiro válido.
     */
    public static int lerInteiro(String dados) {
        int aux = 0;

        try {
            aux = Integer.parseInt(dados);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return aux;
    }

    /**
     * Método que vai ler CPF e verificar se é válido.
     * @param dados Mensagem exibida para o usuário.
     * @return Um CPF válido.
     */
    public static String lerCPF(String dados) {
        String cpf = null;

        cpf = formataDadosNumero(dados);
        if(cpf.length() == 11) {
            return cpf;
        } else {
            throw new InputMismatchException();
        }
    }

    /**
     * Método que vai ler o número da CNH e verificar se é válido.
     * @param dados Mensagem exibida para o usuário.
     * @return Um CNH válido.
     */
    public static String lerNCarteira(String dados) {
        String nCarteira = null;

        nCarteira = formataDadosNumero(dados);
        if(nCarteira.length() == 11) {
            return nCarteira;
        } else {
            throw new InputMismatchException();
        }
    }

    /**
     * Método que vai ler o número de telefone e verificar se é válido.
     * @param dados Mensagem exibida para o usuário.
     * @return Um Telefone válido.
     */
    public static String lerTelefone(String dados) {
        String telefone = null;

        telefone = formataDadosNumero(dados);
        if(telefone.length() == 11) {
            return telefone;
        } else {
            throw new InputMismatchException();
        }
    }

    /**
     * Lê um nome, seja de cidade ou usuário.
     * @param dados Mensagem a ser exibida para o usuário.
     * @return Retorna um nome apenas com caracteres válidos.
     */
    public static String lerNome(String dados) {
        String nome = null;

        nome = formataDadosNumero(dados);
        if(nome.length() > 0) {
            throw new InputMismatchException();
        }

        nome = formataDadosLetras(dados);
        return nome;
    }

    public static Categoria lerCategoria(String dados, VetorCategoria vetorCategoria) throws InputMismatchException {
        int categoriaID = 0;
        categoriaID = lerInteiro(dados);

        if (vetorCategoria.contemId(categoriaID)) {
            return vetorCategoria.getCategoriaID(categoriaID);
        } else {
            throw new InputMismatchException();
        }
    }

    /**
     * Método que vai ler a placa do veículo e verificar se é válida.
     * @param dados Mensagem exibida para o usuário.
     * @return Uma placa válida.
     */
    public static String lerPlaca(String dados) {
        String placa = null;

        placa = formataPlaca(dados);

        if(placa.length() != 7){
            throw new InputMismatchException();
        } else if(!placa.substring(0, 3).matches("[A-Z]*")){
            throw new InputMismatchException();
        } else if(!placa.substring(3, 4).matches("[0-9]*")){
            throw new InputMismatchException();
        } else if(!placa.substring(4, 5).matches("[A-Z0-9]*")) {
            throw new InputMismatchException();
        } else if(!placa.substring(5, 7).matches("[0-9]*")) {
            throw new InputMismatchException();
        }
        return placa;
    }

    /**
     * Método que escreve o CPF do cliente formatado da maneira correta de leitura.
     * @param cpf CPF a ser escrito na tela.
     * @return CPF formatado corretamente.
     */
    public static String escreverCPF(String cpf) {
        return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9));
    }

    /**
     * Método que escreve a placa de veículos formatada da maneira correta.
     * @param placa Placa a ser escrita.
     * @return String com a placa formatada.
     */
    public static String escreverPlaca(String placa) {
        return (placa.substring(0, 3) + "-" + placa.substring(3));
    }

    /**
     * Método que escreve os telefones da maneira formatada.
     * @param telefone Telefone a ser escrito.
     * @return String com o telefone formatado.
     */
    public static String escreverTelefone(String telefone) {
        return ("(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 7) + "-" + telefone.substring(7));
    }

    /**
     * Método que formata e valida uma placa de veículo.
     * @param placa Placa a ser formatada.
     * @return Placa formatada e validada.
     */
    private static String formataPlaca(String placa){
        return placa.replaceAll("[^a-zA-Z0-9]", "");
     }

    /**
     * Método que formatará os dados recebidos, retirando caracteres especiais.
     * @param dado Dado a ser formatado.
     * @return A String com apenas números.
     */
    private static String formataDadosNumero(String dado) {
        return dado.replaceAll("[^0-9]+", "");
    }

    /**
     * Método que formatará os dados recebidos, retirando caracteres especiais.
     * @param dado Dado a ser formatado.
     * @return A String com apenas letras.
     */
    private static String formataDadosLetras(String dado) {
        return dado.replaceAll("[^A-z\\s\u00C0-\u00FF]+", "");
    }

    /**
     * Método que lê uma data específica e retorna a mesma.
     * @param dia O dia.
     * @param mes O mês.
     * @param ano O ano.
     * @return Retorna a data no objeto Calendar.
     */
    public static Calendar lerData(int dia, int mes, int ano) {
        Calendar data = Calendar.getInstance();

        data.clear();
        data.set(ano, (mes - 1), dia);
        return data;
    }

    public static long diferencaDias(Calendar dataUm, Calendar dataDois) {
        long tempo1 = dataUm.getTimeInMillis();
        long tempo2 = dataDois.getTimeInMillis();

        long diferenca = tempo2 - tempo1;
        long dias = diferenca / (24 * 60 * 60 * 1000);
        return dias;
    }
    
    public static VetorCategoria lerArquivoCategoria(String nomeArquivo) {
        VetorCategoria vetorCategoria = new VetorCategoria(15);
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha = null;
            leitor.readLine();
            while ((linha = leitor.readLine()) != null) {
                String[] valores = linha.split(";");
                int identificador = Integer.parseInt(valores[0]);
                String nome = valores[1];
                Categoria categoria = new Categoria(identificador, nome);
                vetorCategoria.adiciona(categoria);
            }
            leitor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vetorCategoria;
    }
    
    public static VetorVeiculos lerArquivoVeiculos(String nomeArquivo, VetorCategoria vetorCategoria) {
        VetorVeiculos vetorVeiculos = new VetorVeiculos(15);
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha = null;
            leitor.readLine();
            while ((linha = leitor.readLine()) != null) {
                String[] valores = linha.split(";");
                String placa = lerPlaca(valores[0]);
                String modelo = valores[1];
                String marca = valores[2];
                int ano = Integer.parseInt(valores[3]);
                int potencia = Integer.parseInt(valores[4]);
                int lugares = Integer.parseInt(valores[5]);
                int identificadorCategoria = Integer.parseInt(valores[6]);
                Categoria categoria = vetorCategoria.getCategoriaID(identificadorCategoria);
                Veiculo veiculo = new Veiculo(placa, modelo, marca, ano, potencia, lugares, categoria);
                vetorVeiculos.adiciona(veiculo);
            }
            leitor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vetorVeiculos;
    }
}