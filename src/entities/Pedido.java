package entities;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements IPedido{
    private int numero;
    private String cliente;
    private List<IItemPedido> itens = new ArrayList<>();

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
}
