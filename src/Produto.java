public abstract class Produto {
    private final String nome;
    private final double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public final String getNome() {
        return nome;
    }

    public final double getPreco() {
        return preco;
    }
}