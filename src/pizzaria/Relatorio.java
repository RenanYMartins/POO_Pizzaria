package pizzaria;

public class Relatorio {
    private DAOPedido daoPedido;
    private DAODiaDeTrabalho daoDiaDeTrabalho;

    public Relatorio(DAOPedido daoPedido, DAODiaDeTrabalho daoDiaDeTrabalho) {
        this.daoPedido = daoPedido;
        this.daoDiaDeTrabalho = daoDiaDeTrabalho;
    }

    public String gerarRelatorioPizzasPorCliente() {
        StringBuilder report = new StringBuilder();
        report.append("Relatório de Pizzas por Cliente:\n");
        report.append(daoPedido.listAllPedidos());
        return report.toString();
    }

    public String gerarRelatorioPedidosPorData() {
        StringBuilder report = new StringBuilder();
        report.append("Relatório de Pedidos por Data:\n");
        report.append(daoDiaDeTrabalho.listAll());
        return report.toString();
    }
}
