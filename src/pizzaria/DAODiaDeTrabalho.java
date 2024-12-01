package pizzaria;

import java.util.ArrayList;
import java.util.List;

public class DAODiaDeTrabalho {
    private List<DiaDeTrabalho> databaseDiaDeTrabalho = new ArrayList<>();

    public void create(DiaDeTrabalho diaDeTrabalho) {
        databaseDiaDeTrabalho.add(diaDeTrabalho);
    }

    public DiaDeTrabalho read(int id) {
        for (DiaDeTrabalho dia : databaseDiaDeTrabalho) {
            if (dia.getId() == id) {
                return dia;
            }
        }
        return null;
    }

    public String listAll() {
        StringBuilder report = new StringBuilder();
        for (DiaDeTrabalho dia : databaseDiaDeTrabalho) {
            report.append("Dia de Trabalho ID: ").append(dia.getId()).append("\n");
            report.append("Data: ").append(dia.getData()).append("\n");
            report.append("Pedidos:\n");
            for (Pedido pedido : dia.getPedidos()) {
                report.append("  Pedido ID: ").append(pedido.getId()).append("\n");
                for (Pizza pizza : pedido.getPizzasPedido()) {
                    report.append("    - Sabor: ").append(pizza.getSabor())
                          .append(", Valor: R$ ").append(pizza.getValor()).append("\n");
                }
            }
            report.append("--------------------------------------\n");
        }
        return report.toString();
    }

    public boolean update(DiaDeTrabalho diaAtualizado) {
        DiaDeTrabalho diaExistente = read(diaAtualizado.getId());
        if (diaExistente != null) {
            diaExistente.getPedidos().clear();
            diaExistente.getPedidos().addAll(diaAtualizado.getPedidos());
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        DiaDeTrabalho dia = read(id);
        if (dia != null) {
            databaseDiaDeTrabalho.remove(dia);
            return true;
        }
        return false;
    }
}
