package entities;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements IPedido{
    private int numero;
    private String cliente;
    private List<IItemPedido> itens = new ArrayList<>();

    public Pedido(int numero,String cliente){
        this.numero = numero;
        this.cliente = cliente;
    }

    @Override
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String getCliente() {
        return cliente;
    }

    @Override
    public void adicionarItem(IItemPedido item) {
        itens.add(item);
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public List<IItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<IItemPedido> itens) {
        this.itens = itens;
    }

    @Override
    public double getValorTotal(){
        double valorTotal = 0;
        for (IItemPedido item:itens){
            valorTotal += item.getValorUnitario() * item.getQuantidade();
        }
        return valorTotal;
    }
    public String toString(){
        return String.format("Pedido #%03d | Cliente: %-10s | Total: R$ %.2f",numero,cliente,getValorTotal());
    }
    public String gerarResultadoDetalhado(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("-----------------------------\n");
        sb.append(String.format("Resumo do pedido #%03d\n",numero));
        sb.append("Cliente: ").append(cliente).append("\n");
        sb.append("------------------------------\n");
        for (IItemPedido item:itens){
            sb.append(item.toString()).append(" - Subtotal: R$")
                    .append(String.format("%.2f",item.getSubTotal())).append("\n");
        }
        sb.append("----------------------------\n");
        sb.append(String.format("Valor total: R$ %.2f\n",getValorTotal()));
        return sb.toString();
    }
}
