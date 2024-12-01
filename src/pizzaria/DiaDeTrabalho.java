package pizzaria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiaDeTrabalho {
    private static int idInicial = 1;
    private int id;
    private Date data;
    private List<Pedido> pedidos;

    public DiaDeTrabalho(Date data) {
        this.id = idInicial++;
        this.data = data;
        this.pedidos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void adicionarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
}
