package pizzaria;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int idInicial = 1;
    private int id;
    private List<Pizza> pizzasPedido;

    public Pedido() {
        this.id = idInicial++;
        this.pizzasPedido = new ArrayList<>();
    }

    public Pedido(int id, List<Pizza> pizzasPedido) {
        this.id = id;
        this.pizzasPedido = pizzasPedido;
    }

    public int getId() {
        return id;
    }

    public List<Pizza> getPizzasPedido() {
        return pizzasPedido;
    }

    public void adicionarPizza(Pizza p) {
        this.pizzasPedido.add(p);
    }
}
