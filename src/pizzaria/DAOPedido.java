package pizzaria;

import java.util.ArrayList;
import java.util.List;

public class DAOPedido {

    private List<Pedido> databasePedido = new ArrayList<>();

    public void create(Pedido pedido) {
        databasePedido.add(pedido);
    }

    public Pedido read(int id) {
        for (Pedido p : databasePedido) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public String listAll() {
        StringBuilder report = new StringBuilder();
        for (Pedido pedido : databasePedido) {
            report.append("Pedido ID: ").append(pedido.getId()).append("\n");
            report.append("Pizzas:\n");
            for (Pizza pizza : pedido.getPizzasPedido()) {
                report.append("  - Sabor: ").append(pizza.getSabor())
                      .append(", Valor: R$ ").append(pizza.getValor()).append("\n");
            }
            report.append("--------------------------------------\n");
        }
        return report.toString();
    }

    public boolean update(Pedido pedidoAtualizado) {
        Pedido pedidoExistente = read(pedidoAtualizado.getId());
        if (pedidoExistente != null) {
            pedidoExistente.getPizzasPedido().clear();
            pedidoExistente.getPizzasPedido().addAll(pedidoAtualizado.getPizzasPedido());
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        Pedido pedido = read(id);
        if (pedido != null) {
            databasePedido.remove(pedido);
            return true;
        }
        return false;
    }

    public String listAllPedidos() {
        StringBuilder report = new StringBuilder();
        for (Pedido pedido : databasePedido) {
            report.append("Pedido ID: ").append(pedido.getId()).append("\n");
            for (Pizza pizza : pedido.getPizzasPedido()) {
                report.append("  - Sabor: ").append(pizza.getSabor())
                      .append(", Valor: R$ ").append(pizza.getValor()).append("\n");
            }
            report.append("--------------------------------------\n");
        }
        return report.toString();
    }

    public int getNextId() {
        if (databasePedido.isEmpty()) {
            return 1; 
        }
        int maxId = 0;
        for (Pedido pedido : databasePedido) {
            if (pedido.getId() > maxId) {
                maxId = pedido.getId();
            }
        }
        return maxId + 1;
    }
}
