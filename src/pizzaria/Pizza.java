package pizzaria;

public class Pizza {
    private static int idInicial = 1;
    private int id;
    private String sabor;
    private double valor;

    public Pizza(String sabor, double valor) {;
        this.id = idInicial++;
        this.sabor = sabor;
        this.valor = valor;
    }

    public Pizza(){}
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
   
}
