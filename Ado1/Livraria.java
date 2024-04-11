package Ado1;

import java.util.ArrayList;
import java.util.Scanner;

public class Livraria {
    private ArrayList<Livro> colecaoLivros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        colecaoLivros.add(livro);
    }

    public boolean removerLivro(Livro livro) {
        for (Livro l : colecaoLivros) {
            if (l.getTitulo().equalsIgnoreCase(livro.getTitulo()) && l.getAutor().equalsIgnoreCase(livro.getAutor())) {
                colecaoLivros.remove(l);
                return true; // Livro encontrado e removido com sucesso
            }
        }
        return false; // Livro não encontrado na livraria
    }


    public void listarLivros() {
        if (colecaoLivros.isEmpty()) {
            System.out.println("A livraria está vazia.");
        } else {
            System.out.println("Livros na livraria:");
            for (Livro livro : colecaoLivros) {
                System.out.println(livro);
            }
        }
    }

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
                    livraria.removerLivro(livroRemover);
                    System.out.println("Livro removido com sucesso!");
                    break;
                case 3:
                    livraria.listarLivros();
                    break;
                case 4:
                    System.out.println("Saindo da livraria.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
