package entities;

public class ItemPedido implements IItemPedido{
    private String nome;
    private int quantidade;
    private double valorUnitario;

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public double getSubTotal() {
        return getValorUnitario() * getQuantidade();
    }
    @Override
    public String toString(){
        return String.format("%d %-15s (R$ %.2f cada)",quantidade,nome,valorUnitario);
    }
}
