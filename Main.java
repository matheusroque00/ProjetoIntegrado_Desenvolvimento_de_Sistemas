// Importa Scanner, usado para ler o que o usuário digita.
import java.util.Scanner;

// Main é a classe onde o programa começa.
public class Main {

    // main = ponto inicial da execução.
    public static void main(String[] args) {

        // Cria um objeto Scanner ligado ao teclado.
        Scanner scanner = new Scanner(System.in);

        // ================= DADOS =================
        // Papel[] = array de objetos Papel.
        // Cada new Papel(...) cria um objeto.
        Papel[] papeis = {
                new Papel("Markatto Concetto Bianco 250 (21x29,4)", 0.95),
                new Papel("OffSet 180 (21x29,4)", 0.24),
                new Papel("OffSet 230 (21x29,4)", 0.21),
                new Papel("Vegetal 180 (33x48)", 2.30),
                new Papel("Color Plus 180 (33x48)", 1.90)
        };

        // Array de objetos Impressao.
        Impressao[] impressoes = {
                new Impressao("A3 preenchida frente e verso", 5.00),
                new Impressao("A3 preenchida frente", 3.00),
                new Impressao("A3 detalhe frente", 2.00),
                new Impressao("A4 preenchida frente e verso", 4.00),
                new Impressao("A4 detalhe frente e verso", 2.50),
                new Impressao("A4 preenchida frente", 2.80),
                new Impressao("A4 detalhe frente", 1.50)
        };

        // Array de objetos Acabamento.
        Acabamento[] acabamentos = {
                new Acabamento("Cinta de papel (offset/kraft)", 0.25),
                new Acabamento("Cinta de papel (markatto)", 0.25),
                new Acabamento("Fita cetim 22mm com tag", 1.10),
                new Acabamento("Fita cetim 7mm com tag", 0.53),
                new Acabamento("Lacre de cera + tag", 2.75),
                new Acabamento("Ilhós", 0.20)
        };

        // Array de objetos Produto.
        // O segundo número é o aproveitamento por folha.
        Produto[] produtos = {
                new Produto("Convite encarte com vinco 21x15", 4),
                new Produto("Convite encarte 21x15", 4),
                new Produto("Convite encarte acrilico gravado em laser", 1),
                new Produto("Convite com ilhós e foto 21x15", 2),
                new Produto("Folha impressão extra 21x15", 4),
                new Produto("Convite individual", 36),
                new Produto("Envelope capa - vegetal", 8),
                new Produto("Envelope carta forrado 22x16", 4),
                new Produto("Envelope carta forrado 10x15", 8),
                new Produto("Envelope carta forrado 10x7", 16),
                new Produto("Envelope carta forrado 22x16 colorido", 4),
                new Produto("Envelope carta colorido forrado em papel vegetal 22x16", 4),
                new Produto("Envelope carta forrado impresso full 22x16", 4),
                new Produto("Envelope carta simples 22x16", 4),
                new Produto("Envelope carta simples 10x15", 8),
                new Produto("Envelope carta impressão interna 22x16", 4),
                new Produto("Envelope carta impressão interna 10x15", 8),
                new Produto("Envelope carta impressão interna 10x7", 16),
                new Produto("Envelope carta impressão interna colorido 22x16", 4),
                new Produto("Envelope/convite com uma dobra", 1),
                new Produto("Envelope/convite com 2 dobras arredondado", 1),
                new Produto("Envelope luva 18x18", 4),
                new Produto("Envelope luva 20x10 - colorido", 8),
                new Produto("Envelope A4 empresarial", 2),
                new Produto("Envelope A4 empresarial + TAG", 2),
                new Produto("Envelope caderninho", 16),
                new Produto("Lágrimas de alegria envelope", 6),
                new Produto("Tag lagrimas 6x12cm", 17),
                new Produto("Manual padrinhos duas dobras 21x14", 4),
                new Produto("Manual padrinhos uma dobra", 6),
                new Produto("Manual padrinhos 6 folhas 8x8", 3),
                new Produto("Menu individual 20x9cm frente e verso", 6),
                new Produto("Plaquinha bar 20x25", 1),
                new Produto("Setorização de mesa 11x9", 4),
                new Produto("setorização de mesa 3 lados 20x9", 2),
                new Produto("Tag bem casado 5x5cm", 20),
                new Produto("Ventarola Full", 1),
                new Produto("Ventarola Simples", 1),
                new Produto("Cartão 8x8cm", 20),
                new Produto("Cartão 5x7cm", 30),
                new Produto("Cartão 10x15cm", 4),
                new Produto("CARTÃO 20x25", 3),
                new Produto("Cone de petálas com cordinha", 6),
                new Produto("Cone de petálas", 6),
                new Produto("Caderno de votos 14x10cm", 4),
                new Produto("caderno de votos 20x10cm", 2),
                new Produto("marca páginas 18x5cm", 14),
                new Produto("Adesivo fosco 10x14", 4),
                new Produto("Adesivo fosco 5x5", 24),
                new Produto("Missal frente e verso", 1)
        };

        // Array de objetos Embalagem.
        Embalagem[] embalagens = {
                new Embalagem("Caixa P", 5.00),
                new Embalagem("Caixa M", 10.00),
                new Embalagem("Caixa G", 20.00),
                new Embalagem("Caixa MDF 10x10x5", 7.15),
                new Embalagem("Caixa MDF 15x15x5", 4.00),
                new Embalagem("Caixa MDF 15x15x10", 9.60),
                new Embalagem("Caixa MDF 20x20x10", 12.50)
        };

        // ================= ENTRADA =================
        System.out.println("======================================");
        System.out.println("      CALCULADORA DE ORÇAMENTOS");
        System.out.println("======================================");

        // nextLine() lê uma linha de texto.
        System.out.print("Nome do Cliente: ");
        String cliente = scanner.nextLine();

        // ================= PRODUTO =================
        System.out.println("\nLista de produtos");

        // for percorre o array e mostra o nome de cada um.
        // i começa em 0, vai até length (tamanho do array) e aumenta 1 por vez.

        for (int i = 0; i < produtos.length; i++) {
            System.out.println((i + 1) + ". " + produtos[i].getNome());
        }

        int opcaoProduto;
        
        do {
        System.out.print("Escolha o número da peça: ");
        opcaoProduto = scanner.nextInt();

        if (opcaoProduto < 1 || opcaoProduto > produtos.length) {
        System.out.println("Opção inválida! Escolha um número da lista.");
    }

}       while (opcaoProduto < 1 || opcaoProduto > produtos.length);


        // Array começa no índice 0.
        // Por isso usamos opção - 1.
        Produto produtoSelecionado = produtos[opcaoProduto - 1];

        System.out.print("Digite a quantidade desejada: ");
        int quantidade = scanner.nextInt();

        // ================= PAPEL =================
        System.out.println("\nLista de papeis");

        for (int i = 0; i < papeis.length; i++) {

        System.out.println(
        (i + 1) + ". " 
        + papeis[i].getNome()
        + " (R$ "
        + papeis[i].getPreco()
        + ")"
    );
}

        int opcaoPapel;

        do {
        System.out.print("Escolha o papel: ");
        opcaoPapel = scanner.nextInt();

        if (opcaoPapel < 1 || opcaoPapel > papeis.length) {
        System.out.println("Opção inválida! Escolha um número da lista.");
    }

}       while (opcaoPapel < 1 || opcaoPapel > papeis.length);

        Papel papelSelecionado = papeis[opcaoPapel - 1];

        // ================= IMPRESSÃO =================
        System.out.println("\nTipo de impressão");

        for (int i = 0; i < impressoes.length; i++) {

        System.out.println(
        (i + 1) + ". " 
        + impressoes[i].getTipo()
        + " (R$ "
        + impressoes[i].getPreco()
        + ")"
    );
}
        int opcaoImpressao;

        do {
        System.out.print("Escolha a impressão: ");
        opcaoImpressao = scanner.nextInt();

        if (opcaoImpressao < 1 || opcaoImpressao > impressoes.length) {
        System.out.println("Opção inválida! Escolha um número da lista.");
    }

}       while (opcaoImpressao < 1 || opcaoImpressao > impressoes.length);

        Impressao impressaoSelecionada =
        impressoes[opcaoImpressao - 1];


        // ================= EMBALAGEM =================
        System.out.println("\nEmbalagem");

        for (int i = 0; i < embalagens.length; i++) {

        System.out.println(
        (i + 1) + ". " 
        + embalagens[i].getNome()
        + " (R$ "
        + embalagens[i].getPreco()
        + ")"
    );
}
        int opcaoEmbalagem;

        do {
        System.out.print("Opção de embalagem: ");
        opcaoEmbalagem = scanner.nextInt();

        if (opcaoEmbalagem < 1 || opcaoEmbalagem > embalagens.length) {
        System.out.println("Opção inválida! Escolha um número da lista.");
    }

}       while (opcaoEmbalagem < 1 || opcaoEmbalagem > embalagens.length);

        Embalagem embalagemSelecionada =
        embalagens[opcaoEmbalagem - 1];

        // ================= DESIGN =================
        System.out.print("\nCobrar taxa de Design? (1-Sim / 2-Não): ");
        int opcaoDesign = scanner.nextInt();

        while (opcaoDesign < 1 || opcaoDesign > 2) {
        System.out.println("Opção inválida! Digite 1 para Sim ou 2 para Não.");

        System.out.print("Cobrar taxa de Design? (1-Sim / 2-Não): ");
        opcaoDesign = scanner.nextInt();
}

        // Começa em zero. Só muda se o usuário escolher cobrar design.
        double valorDesign = 0;

        if (opcaoDesign == 1) {
        System.out.print("Digite o valor do design: R$ ");
        valorDesign = scanner.nextDouble();
}

        // ================= DESCONTO =================
        System.out.print("Aplicar desconto de 5%? (1-Sim / 2-Não): ");
        int opcaoDesconto = scanner.nextInt();

        while (opcaoDesconto < 1 || opcaoDesconto > 2) {

        System.out.println("Opção inválida! Digite 1 para Sim ou 2 para Não.");

        System.out.print("Aplicar desconto de 5%? (1-Sim / 2-Não): ");
        opcaoDesconto = scanner.nextInt();
}
        // == compara valores e produz true ou false.
        boolean desconto = opcaoDesconto == 1;


        // ================= OBJETO ORÇAMENTO =================
        // new cria um objeto.
        // Aqui estamos juntando todas as escolhas em um Orcamento.
        Orcamento orcamento = new Orcamento(
                cliente,
                produtoSelecionado,
                quantidade,
                papelSelecionado,
                impressaoSelecionada,
                embalagemSelecionada,
                valorDesign,
                desconto
        );

        // ================= ACABAMENTOS =================
        int opcaoAcabamento;

        // do-while executa pelo menos uma vez.
        do {

        System.out.println("\nAcabamento extra");

        for (int i = 0; i < acabamentos.length; i++) {

        System.out.println(
            (i + 1) + ". "
            + acabamentos[i].getNome()
            + " (R$ "
            + acabamentos[i].getPreco()
            + ")"
        );
    }
            System.out.println("0. Finalizar escolha de acabamentos");
            System.out.print("Opção: ");
            opcaoAcabamento = scanner.nextInt();

            // && significa "E".
            // A opção precisa ser maior que 0 E menor/igual ao tamanho.
            if (opcaoAcabamento > 0 &&
                    opcaoAcabamento <= acabamentos.length) {

                Acabamento acabamentoSelecionado =
                        acabamentos[opcaoAcabamento - 1];

                // Chama um método do objeto Orcamento.
                orcamento.adicionarAcabamento(acabamentoSelecionado);

                System.out.println("-> Acabamento adicionado!");

            } else if (opcaoAcabamento != 0) {
                System.out.println("Opção inválida!");
            }

        } while (opcaoAcabamento != 0);

        // ================= RESULTADO =================
        // O Main pede ao objeto Orcamento para imprimir o resultado.
        orcamento.imprimirResumo();

        // Fecha o Scanner.
        scanner.close();
    }
}
