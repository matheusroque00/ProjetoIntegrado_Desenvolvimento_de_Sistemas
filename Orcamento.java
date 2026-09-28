// ArrayList/List permitem guardar vários objetos Acabamento.
import java.util.ArrayList;
import java.util.List;

// Classe responsável pelo orçamento e seus cálculos.
public class Orcamento {
    // private = encapsulamento: os dados ficam protegidos dentro da classe.
    private String cliente;
    private Produto produto;
    private int quantidade;
    private Papel papel;
    private Impressao impressao;
    private Embalagem embalagem;
    private List<Acabamento> acabamentos;
    private double valorDesign;
    private boolean desconto;

    // Construtor recebe os dados e monta um orçamento.
    public Orcamento(String cliente, Produto produto, int quantidade,
                     Papel papel, Impressao impressao, Embalagem embalagem,
                     double valorDesign, boolean desconto) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.papel = papel;
        this.impressao = impressao;
        this.embalagem = embalagem;
        this.valorDesign = valorDesign;
        this.desconto = desconto;

        // Cria uma lista vazia de acabamentos.
        // ArrayList pode crescer conforme novos itens são adicionados.
        this.acabamentos = new ArrayList<>();
    }

    // Recebe um objeto Acabamento e coloca-o na lista.
    public void adicionarAcabamento(Acabamento acabamento) {
        acabamentos.add(acabamento);
    }

    // Calcula quantas folhas são necessárias.
    public int calcularFolhasNecessarias() {
        // Divisão inteira.
        int folhas = quantidade / produto.getAproveitamento();

        // % calcula o resto da divisão.
        // Se sobrou alguma unidade, precisamos de mais uma folha.
        if (quantidade % produto.getAproveitamento() != 0) {
            folhas++;
        }

        // return devolve o resultado.
        return folhas;
    }

    // Calcula papel + 2% de perda.
    public double calcularCustoPapel() {
        int folhas = calcularFolhasNecessarias();
        return (folhas * papel.getPreco()) * 1.02;
    }

    // Calcula o custo de impressão.
    public double calcularCustoImpressao() {
        return calcularFolhasNecessarias() * impressao.getPreco();
    }

    // Soma o custo de todos os acabamentos.
    public double calcularCustoAcabamentos() {
        double total = 0;

        // for-each percorre cada objeto da lista.
        for (Acabamento acabamento : acabamentos) {
            total = total + acabamento.getPreco() * quantidade;
        }

        return total;
    }

    // Soma os materiais utilizados.
    public double calcularCustoMateriais() {
        return calcularCustoPapel() + calcularCustoImpressao() + calcularCustoAcabamentos()+ embalagem.getPreco();
    }

    // Mão de obra = 20% dos materiais.
    public double calcularMaoDeObra() {
        return calcularCustoMateriais() * 0.20;
    }

    // Custo total = materiais + mão de obra + design.
    public double calcularCustoTotal() {
        return calcularCustoMateriais() + calcularMaoDeObra() + valorDesign;
    }

    // Aplica 20% de lucro e, se escolhido, 5% de desconto.
    public double calcularPrecoFinal() {
        double preco = calcularCustoTotal() * 1.20;

        if (desconto) {
            preco = preco * 0.95;
        }

        return preco;
    }

    // Divide o preço total pela quantidade.
    public double calcularValorUnitario() {
        return calcularPrecoFinal() / quantidade;
    }

    // Exibe o resultado final no console.
    public void imprimirResumo() {
        System.out.println("\n===================================================");
        System.out.println("               ORÇAMENTO GERADO                    ");
        System.out.println("===================================================");
        System.out.println("Cliente: " + cliente);
        System.out.println("Item/Peça: " + produto.getNome());
        System.out.println("Quantidade: " + quantidade + " un");
        System.out.println("Papel: " + papel.getNome());
        System.out.println("Tipo de Impressão: " + impressao.getTipo());
        System.out.println("Embalagem: " + embalagem.getNome());

        System.out.println("\nAcabamentos Escolhidos:");

        // isEmpty() verifica se a lista está vazia.
        if (acabamentos.isEmpty()) {
            System.out.println("  - Nenhum acabamento extra");
        } else {
            // Percorre cada acabamento.
            for (Acabamento acabamento : acabamentos) {
                System.out.printf("  - %s (R$ %.2f/un)%n",
                        acabamento.getNome(), acabamento.getPreco());
            }
        }

        System.out.println("---------------------------------------------------");
        System.out.println("DETALHAMENTO:");

        System.out.printf("Folhas necessárias: %d%n", calcularFolhasNecessarias());
        System.out.printf("Custo Papel (c/ 2%% perda): R$ %.2f%n", calcularCustoPapel());
        System.out.printf("Custo Impressão: R$ %.2f%n", calcularCustoImpressao());
        System.out.printf("Custo Acabamentos: R$ %.2f%n", calcularCustoAcabamentos());
        System.out.printf("Embalagem/Caixa: R$ %.2f%n", embalagem.getPreco());
        System.out.printf("Mão de Obra (20%%): R$ %.2f%n", calcularMaoDeObra());

        if (valorDesign > 0) {
            System.out.printf("Design / Arte: R$ %.2f%n", valorDesign);
        }

        System.out.println("---------------------------------------------------");
        System.out.printf("CUSTO TOTAL DE PRODUÇÃO: R$ %.2f%n", calcularCustoTotal());
        System.out.printf("PREÇO FINAL SUGERIDO: R$ %.2f%n", calcularPrecoFinal());
        System.out.printf("Valor Unitário: R$ %.2f%n", calcularValorUnitario());
        System.out.println("===================================================");
    }
}
