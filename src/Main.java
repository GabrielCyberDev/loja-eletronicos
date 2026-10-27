import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Catálogo: polimorfismo (cada posição guarda um tipo diferente de Produto)
        Produto[] catalogo = {
                new Televisao(), new Radio(), new Videogame(), new Tablet(), new Celular()
        };

        final int MAX_LINHAS = 100;
        Produto[] compras = new Produto[MAX_LINHAS]; // vetor de compras (tipo Produto)
        int[] quantidades = new int[MAX_LINHAS];     // quantidade de cada compra
        int totalLinhas = 0;

        System.out.println("=== Bem-vindo à Loja de Eletrônicos! ===");

        int opcao;
        do {
            System.out.println();
            System.out.println("Produtos disponíveis:");
            for (int i = 0; i < catalogo.length; i++) {
                System.out.printf("%d - %s - R$ %.2f%n", (i + 1), catalogo[i].getNome(), catalogo[i].getPreco());
            }
            System.out.println("0 - Finalizar compra");
            System.out.print("Escolha uma opção: ");

            // Tratamento de entrada inválida (letras, por exemplo)
            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Entrada inválida! Digite apenas números.");
                opcao = -1;
                continue;
            }

            opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= catalogo.length) {
                System.out.print("Quantas unidades deseja? ");
                if (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.println("Quantidade inválida! Compra não registrada.");
                    continue;
                }
                int quantidade = scanner.nextInt();

                if (quantidade <= 0) {
                    System.out.println("Quantidade inválida! Informe um valor maior que zero.");
                } else if (totalLinhas >= MAX_LINHAS) {
                    System.out.println("Carrinho cheio! Finalize a compra.");
                } else {
                    compras[totalLinhas] = catalogo[opcao - 1];
                    quantidades[totalLinhas] = quantidade;
                    totalLinhas++;
                    System.out.println(quantidade + "x " + catalogo[opcao - 1].getNome() + " adicionado(s) ao carrinho.");
                }
            } else if (opcao != 0) {
                System.out.println("Opção inválida! Esse produto não existe.");
            }
        } while (opcao != 0);

        // Resumo da compra
        System.out.println();
        System.out.println("===== RESUMO DA COMPRA =====");
        double total = 0;
        if (totalLinhas == 0) {
            System.out.println("Nenhum produto comprado.");
        }
        for (int i = 0; i < totalLinhas; i++) {
            double subtotal = compras[i].getPreco() * quantidades[i];
            total += subtotal;
            System.out.printf("%s - Quantidade: %d - Subtotal: R$ %.2f%n",
                    compras[i].getNome(), quantidades[i], subtotal);
        }
        System.out.printf("PREÇO FINAL DA COMPRA: R$ %.2f%n", total);
        System.out.println("Obrigado pela preferência!");

        scanner.close();
    }
}