package ClassesBase;

public class Veiculo{
    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private int potencia;
    private int lugares;
    private Categoria categoria;



    public Veiculo(String placa, String modelo, String marca, int ano, int potencia, int lugares, Categoria categoria) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.potencia = potencia;
        this.lugares = lugares;
        this.categoria = categoria;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo(){
        return modelo;
    }

    public String getMarca(){
        return marca;
    }

    public int getAno(){
        return ano;
    }

    public int getPotencia(){
        return potencia;
    }

    public int getLugares(){
        return lugares;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }

     public void setMarca(String marca){
        this.marca = marca;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public void setPotencia(int potencia){
        this.potencia = potencia;
    }

    public void setLugares(int lugares){
        this.lugares = lugares;
    }


    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    public String toString() {
        return "/nPlaca: " + this.placa + "\nModelo: " + this.modelo + "\nAno: " + this.ano + "\nPotência: " + this.potencia
        + "\nLugares: " + this.lugares + "\nMarca: " + this.marca + "\nCategoria: " + this.categoria.toString();
    }
}