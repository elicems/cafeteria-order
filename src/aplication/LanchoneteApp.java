package aplication;


import entities.IItemPedido;
import entities.ItemPedido;
import entities.Pedido;
import queue.Queue;

import java.util.Scanner;

public class LanchoneteApp {
    private static Queue fila = new Queue();
    private static int cont = 1;
    private static Scanner t = new Scanner(System.in);

    public static void main(String[] args){
        int opcao;
        do{
            System.out.println("\n1 - Novo pedido | 2 - Visualizar fila | 3 - Próximo (Atender) | 0 - Sair");
            opcao = Integer.parseInt(t.nextLine());
            switch (opcao){
                case 1 -> criarPedido();
                case 2 -> System.out.println(fila);
                case 3 -> atenderPedido();
            }
        }while (opcao != 0);
    }
    private static void criarPedido(){
        System.out.println("Nome do cliente: ");
        Pedido p = new Pedido(cont++,t.nextLine());
        int itemOpcao;

        do{
            System.out.println("\n---Menu---");
            System.out.printf("%-15s %-8s %-15s %-15s\n","Categoria","Código","Item","Valor unitário");
            System.out.printf("%-15s %-8d %-15s R$ %.2f\n","Lanches",1,"X-bacon",25.00);
            System.out.printf("%-15s %-8d %-15s R$ %.2f\n","",2,"X-salada",20.00);
            System.out.printf("%-15s %-8d %-15s R$ %.2f\n","",3,"X-burguer",18.00);
            System.out.printf("%-15s %-8d %-15s R$ %.2f\n","",4,"Hot-Dog",15.00);
            System.out.printf("%-15s %-8d %-15s R$ %.2f\n","",5,"Combo vegan",30.00);
            System.out.printf("%-15s %-8d %-15s R$ %.2f\n","Refrigerantes",6,"Coca-Cola",7.00);
            System.out.printf("%-15s %-8d %-15s R$ %.2f\n","",7,"Guaraná",6.00);
            System.out.printf("%-15s %-8d %-15s R$ %.2f\n","Batata frita",8,"Batata P",10.00);
            System.out.printf("%-15s %-8d %-15s R$ %.2f\n","",9,"Batata G",15.00);
            System.out.printf("%-15s %-8d %-15s R$ %.2f\n","Suco",10,"Suco laranja",9.00);
            System.out.printf("%-15s %-8d %-15s R$ %.2f\n","",11,"Suco Uva",9.00);
            System.out.printf("%-15s %-8d %-15s R$ %.2f\n","",12,"Suco Limão",8.00);

            itemOpcao = Integer.parseInt(t.nextLine());
            if(itemOpcao>0){
                System.out.print("Quantidade: ");
                int qtd = Integer.parseInt(t.nextLine());
                p.adicionarItem(mapearItem(itemOpcao,qtd));
            }
        }while (itemOpcao != 0);
        fila.enqueue(p);
        System.out.println("Pedido adicionado com sucesso");
    }
    private static void atenderPedido(){
        if(!fila.isEmpty()){
            Pedido obj  = (Pedido) fila.dequeue();
            System.out.println("Pedido atendido: " + obj.gerarResultadoDetalhado());
            }
        }
        private static IItemPedido mapearItem(int op,int qtd){
            return switch (op){
                case 1 -> new ItemPedido("X-bacon",qtd,25.0);
                case 2 -> new ItemPedido("X-salada",qtd,20.0);
                case 3 -> new ItemPedido("X-burguer",qtd,18.0);
                case 4 -> new ItemPedido("Hot-Dog",qtd,15.0);
                case 5 -> new ItemPedido("Combo vegan",qtd,30.0);
                case 6 -> new ItemPedido("Coca Cola",qtd,7.0);
                case 7 -> new ItemPedido("Guaraná",qtd,6.0);
                case 8 -> new ItemPedido("Batata P",qtd,10.0);
                case 9 -> new ItemPedido("Batata G",qtd,15.0);
                case 10 -> new ItemPedido("Suco laranja",qtd,9.0);
                case 11 -> new ItemPedido("Suco uva",qtd,9.0);
                case 12 -> new ItemPedido("Suco limão",qtd,8.0);
                default -> throw new IllegalStateException("Não foi possivel localizar essa opção");
            };
    }
}
