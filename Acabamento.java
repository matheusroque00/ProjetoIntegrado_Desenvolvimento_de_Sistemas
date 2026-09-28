// Classe que representa um acabamento adicional.
public class Acabamento {
    private String nome;
    private double preco;

    public Acabamento(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return nome;
    }
}
