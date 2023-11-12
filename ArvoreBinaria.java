import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {
  private No raiz;

  public ArvoreBinaria() {
    raiz = null;
  }

  public void inserir(int valor) {
    raiz = inserirRec(raiz, valor);
  }

  private No inserirRec(No raiz, int valor) {
    if (raiz == null) {
      raiz = new No(valor);
      return raiz;
    }

    if (valor < raiz.getValor()) {
      raiz.setEsquerda(inserirRec(raiz.getEsquerda(), valor));
    } else if (valor > raiz.getValor()) {
      raiz.setDireita(inserirRec(raiz.getDireita(), valor));
    }

    return raiz;
  }

  public void imprimirPreOrdem() {
    imprimirPreOrdemRec(raiz);
    System.out.println();
  }

  private void imprimirPreOrdemRec(No raiz) {
    if (raiz != null) {
      System.out.print(raiz.getValor() + " ");
      imprimirPreOrdemRec(raiz.getEsquerda());
      imprimirPreOrdemRec(raiz.getDireita());
    }
  }

  public void imprimirEmOrdem() {
    imprimirEmOrdemRec(raiz);
    System.out.println();
  }

  private void imprimirEmOrdemRec(No raiz) {
    if (raiz != null) {
      imprimirEmOrdemRec(raiz.getEsquerda());
      System.out.print(raiz.getValor() + " ");
      imprimirEmOrdemRec(raiz.getDireita());
    }
  }

  public void imprimirPosOrdem() {
    imprimirPosOrdemRec(raiz);
    System.out.println();
  }

  private void imprimirPosOrdemRec(No raiz) {
    if (raiz != null) {
      imprimirPosOrdemRec(raiz.getEsquerda());
      imprimirPosOrdemRec(raiz.getDireita());
      System.out.print(raiz.getValor() + " ");
    }
  }

  public void imprimirEmNivel() {
    if (raiz == null)
      return;

    Queue<No> fila = new LinkedList<>();
    fila.add(raiz);

    while (!fila.isEmpty()) {
      No noTemp = fila.poll();
      System.out.print(noTemp.getValor() + " ");

      if (noTemp.getEsquerda() != null) {
        fila.add(noTemp.getEsquerda());
      }

      if (noTemp.getDireita() != null) {
        fila.add(noTemp.getDireita());
      }
    }
    System.out.println();
  }

  public void removerElementosAleatorios(int num) {
    for (int i = 0; i < num; i++) {
      raiz = deletarNo(raiz, raiz.getValor());
    }
  }

  private No deletarNo(No raiz, int valor) {
    if (raiz == null) {
      return raiz;
    }

    if (valor < raiz.getValor()) {
      raiz.setEsquerda(deletarNo(raiz.getEsquerda(), valor));
    } else if (valor > raiz.getValor()) {
      raiz.setDireita(deletarNo(raiz.getDireita(), valor));
    } else {
      if (raiz.getEsquerda() == null) {
        return raiz.getDireita();
      } else if (raiz.getDireita() == null) {
        return raiz.getEsquerda();
      }

      raiz.setValor(valorMinimo(raiz.getDireita()));
      raiz.setDireita(deletarNo(raiz.getDireita(), raiz.getValor()));
    }

    return raiz;
  }

  private int valorMinimo(No raiz) {
    int valorMinimo = raiz.getValor();
    while (raiz.getEsquerda() != null) {
      valorMinimo = raiz.getEsquerda().getValor();
      raiz = raiz.getEsquerda();
    }
    return valorMinimo;
  }

  public void imprimirArvoreGrafica() {
    imprimirArvoreGraficaRec(raiz, "", true);
  }

  private void imprimirArvoreGraficaRec(No no, String prefix, boolean isEsquerda) {
    if (no != null) {
      System.out.println(prefix + (isEsquerda ? "├── " : "└── ") + no.getValor());
      imprimirArvoreGraficaRec(no.getEsquerda(), prefix + (isEsquerda ? "│   " : "    "), true);
      imprimirArvoreGraficaRec(no.getDireita(), prefix + (isEsquerda ? "│   " : "    "), false);
    }
  }
}
