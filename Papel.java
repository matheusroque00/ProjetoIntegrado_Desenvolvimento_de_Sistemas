// Classe que representa um tipo de papel.
public class Papel {
    // Características do papel.
    private String nome;
    private double preco;

    // Construtor da classe.
    public Papel(String nome, double preco) {
        this.nome = nome; // guarda o nome no objeto
        this.preco = preco; // guarda o preço no objeto
    }

    // Métodos getters: permitem consultar os atributos private.
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    // Define como o objeto será convertido para texto.
    @Override
    public String toString() {
        return nome;
    }
}
