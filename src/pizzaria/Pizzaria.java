package pizzaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizzaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DAOPedido daoPedido = new DAOPedido();
        boolean continuarPedidos = true;
        Scanner scanner = new Scanner(System.in);  // Instancia o Scanner aqui

        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new PizzaPortuguesa(52.00));
        pizzas.add(new PizzaCalabresa(52.00));
        pizzas.add(new PizzaMussarela(52.00));

        while (continuarPedidos) {
            System.out.println("Iniciando novo pedido.");
            List<Pizza> pizzasSelecionadas = exibirMenu(pizzas, scanner);  // Passa o scanner como argumento

            if (pizzasSelecionadas.isEmpty()) {
                System.out.println("Nenhuma pizza selecionada para este pedido.");
            } else {
                Pedido novoPedido = new Pedido(daoPedido.getNextId(), pizzasSelecionadas);
                daoPedido.create(novoPedido);
                System.out.println("Pedido adicionado com sucesso!");
            }

            System.out.println("Deseja adicionar outro pedido? (1 - Sim, 0 - Não)");
            int opcao = scanner.nextInt();
            continuarPedidos = (opcao == 1);
        }

        System.out.println("Finalizando sistema de pedidos.");
        System.out.println("Relatório de todos os pedidos:");
        System.out.println(daoPedido.listAllPedidos());

        scanner.close();  
    }

    public static List<Pizza> exibirMenu(List<Pizza> pizzas, Scanner scanner) {
        List<Pizza> pizzasPedido = new ArrayList<>();
        int opcao = 0;
        boolean continuar = true;

        System.out.println("_________________MENU_________________");

        while (continuar) {
            System.out.println("\nEntre com a opcao desejada: ");
            for (int i = 0; i < pizzas.size(); i++) {
                Pizza pizza = pizzas.get(i);
                System.out.println((i + 1) + ". " + pizza.getSabor() + " - " + pizza.getValor());
            }
            System.out.println("0 - Finalizar pedido");
            System.out.print("Sua opcao: ");
            opcao = scanner.nextInt();

            if (opcao == 0) {
                continuar = false;
            } else if (opcao > 0 && opcao <= pizzas.size()) {
                Pizza pizzaEscolhida = pizzas.get(opcao - 1);
                pizzasPedido.add(pizzaEscolhida);
                System.out.printf("%s adicionada ao pedido!\n", pizzaEscolhida.getSabor());
            } else if (opcao != 0) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        return pizzasPedido;
    }
}
