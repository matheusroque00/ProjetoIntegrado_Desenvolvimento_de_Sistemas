// Classe que representa um tipo de impressão.
public class Impressao {
    private String tipo;
    private double preco;

    // Construtor: recebe os dados necessários para criar uma Impressao.
    public Impressao(String tipo, double preco) {
        this.tipo = tipo;
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
