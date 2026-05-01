package entities;

import java.util.List;

public interface IPedido {
    int getNumero();
    String getCliente();
    void adicionarItem(IItemPedido item);
    List<IItemPedido> getItens();
    double getValorTotal();
}
