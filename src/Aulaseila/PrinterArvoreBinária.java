package Aulaseila;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrinterArvoreBinária{

    static Nó raiz;
    public static void main(String[] args) {

        insere(8);
        insere(4);
        insere(12);
        insere(2);
        insere(6);
        insere(10);
        insere(14);
        insere(1);
        insere(5);
        
        BTreePrinter.printNode(raiz);


    }


    public static void insere(int v) {
        Nó novo = new Nó(v);

        if (raiz == null) {
            raiz = novo;
        } else {
            boolean inseriu = false;
            Nó temp = raiz;

            while (!inseriu) {
                if (novo.valor <= temp.valor) {
                    if (temp.esq == null) {
                        temp.esq = novo;
                        inseriu = true;
                    } else {
                        temp = temp.esq;
                    }
                } else {
                    if (temp.dir == null) {
                        temp.dir = novo;
                        inseriu = true;
                    } else {
                        temp = temp.dir;
                    }

                }
            }
        }
    }

    
    
}

class BTreePrinter{

    public static void printNode(Nó root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<Nó> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Nó> newNodes = new ArrayList<Nó>();
        for (Nó node : nodes) {
            if (node != null) {
                System.out.print(node.valor);
                newNodes.add(node.esq);
                newNodes.add(node.dir);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).esq != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).dir != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(Nó node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.esq), BTreePrinter.maxLevel(node.dir)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
