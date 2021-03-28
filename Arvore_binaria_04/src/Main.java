import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //criando a arvore
        RedBlackTree tree = new RedBlackTree();
        long tempoInicial = 0;
        long tempoFinal = 0;
        tree = ComporArvore(tree, 5000);

        //Verifique se os 10 primeiros números primos estão presentes.
        // Imprima e Remova-os da árvore
        tempoInicial = System.currentTimeMillis();
        tree = Primo(tree);
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo gasto A: "+(tempoFinal - tempoInicial));
        System.out.println("\n////////////\n");
        //Verifique se os múltiplos de 5 estão presentes.
        // Imprima e Remova-os da árvore
        tempoInicial = System.currentTimeMillis();
        tree = Multiplos5(tree);
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo gasto B: "+(tempoFinal - tempoInicial));
        System.out.println("\n////////////\n");

        //Insira 100 números criados aleatoriamente na árvore e imprima a árvore em-ordem.
        tempoInicial = System.currentTimeMillis();
        tree = ComporArvore(tree, 100);
        tree.inorder();
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo gasto C: "+(tempoFinal - tempoInicial));
        System.out.println("\n////////////\n");

        //Verifique se os múltiplos de 5 e os 10 primeiros números primos estão presentes.
        // Imprima e Remova-os da árvore.
        tempoInicial = System.currentTimeMillis();
        tree = Multiplos5(tree);
        tree = Primo(tree);
        tempoFinal = System.currentTimeMillis();
        System.out.println("\nTempo gasto D: "+(tempoFinal - tempoInicial));
        System.out.println("\n////////////\n");
    }
    static RedBlackTree ComporArvore(RedBlackTree tree, int tamanho){
        Random random = new Random();
        for(int i=0; i<tamanho; i++){
            tree.insert(random.nextInt(10000));
        }
        return(tree);
    }
    static RedBlackTree Primo(RedBlackTree tree){
        int[] primos = {2, 3, 5, 7, 9, 11, 13, 17, 19, 23};
        for(int i=0; i<10; i++){
            if(tree.searchTree(primos[i]) != null){
                System.out.print(primos[i] + ", ");
                tree.deleteNode(primos[i]);
            }
        }
        return(tree);
    }
    static RedBlackTree Multiplos5(RedBlackTree tree){
        for(int i = 0; i<10000; i = i + 5){
            if(tree.searchTree(i) != null){
                System.out.print(i + ", ");
                tree.deleteNode(i);
            }
        }
        return(tree);
    }
}

