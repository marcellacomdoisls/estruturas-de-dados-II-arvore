public class Principal {
  public static void main(String[] args) {
    ArvoreBinaria arvore = new ArvoreBinaria();

    for (int i = 0; i < 20; i++) {
      int numeroAleatorio = (int) (Math.random() * 101);
      arvore.inserir(numeroAleatorio);
    }

    System.out.println("Árvore original:");
    arvore.imprimirArvoreGrafica();

    System.out.println("Sequência pré-ordem:");
    arvore.imprimirPreOrdem();

    System.out.println("Sequência em ordem:");
    arvore.imprimirEmOrdem();

    System.out.println("Sequência pós-ordem:");
    arvore.imprimirPosOrdem();

    System.out.println("Sequência em nível:");
    arvore.imprimirEmNivel();

    arvore.removerElementosAleatorios(5);

    System.out.println("Árvore após a remoção de 5 elementos:");
    arvore.imprimirArvoreGrafica();

    System.out.println("Sequência pré-ordem após a remoção:");
    arvore.imprimirPreOrdem();

    System.out.println("Sequência em ordem após a remoção:");
    arvore.imprimirEmOrdem();

    System.out.println("Sequência pós-ordem após a remoção:");
    arvore.imprimirPosOrdem();

    System.out.println("Sequência em nível após a remoção:");
    arvore.imprimirEmNivel();
  }
}
