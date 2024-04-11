package Ado1;

import java.util.Scanner;

public class TesteLivraria {
    public static void main(String[] args) {
        Livraria livraria = new Livraria();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Remover Livro");
            System.out.println("3. Listar Livros");
            System.out.println("4. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente

            switch (escolha) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    Livro novoLivro = new Livro(titulo, autor);
                    livraria.adicionarLivro(novoLivro);
                    System.out.println("Livro adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o título do livro a ser removido: ");
                    String tituloRemover = scanner.nextLine();
                    System.out.print("Digite o autor do livro a ser removido: ");
                    String autorRemover = scanner.nextLine();
                    Livro livroRemover = new Livro(tituloRemover, autorRemover);

                    // Chamando o método removerLivro da livraria
                    boolean livroRemovido = livraria.removerLivro(livroRemover);

                    if (livroRemovido) {
                        System.out.println("Livro removido com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado na livraria.");
                    }
                    break;
                case 3:
                    livraria.listarLivros();
                    break;
                case 4:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

