// Classe que representa um produto/peça.
public class Produto {
    // Atributos privados: características do objeto.
    private String nome;
    private int aproveitamento;

    // Construtor: usado quando criamos um novo Produto.
    public Produto(String nome, int aproveitamento) {
        // this.nome = nome -> atributo = parâmetro recebido.
        this.nome = nome;
        this.aproveitamento = aproveitamento;
    }

    // Getter: permite consultar o nome sem acessar o atributo diretamente.
    public String getNome() {
        return nome;
    }

    // Getter do aproveitamento.
    public int getAproveitamento() {
        return aproveitamento;
    }

    // @Override sobrescreve o toString() herdado de Object.
    // Assim, ao imprimir o objeto, mostramos seu nome.
    @Override
    public String toString() {
        return nome;
    }
}
