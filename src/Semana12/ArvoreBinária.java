package Semana12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.tree.TreeNode;

public class ArvoreBinária {

    static Nó raiz = null;
    static ArrayList<Nó> ar = new ArrayList();
    static ArrayList<Integer> ArrayDoNó = new ArrayList();
    static int cont;
    
    public static void main(String[] args) throws IOException {
        
        // QUESTÃO 1
        System.out.println("QUESTÃO 1");
        LerArquivos("Questao1");
        LocalizarPar(raiz);
        System.out.println("DELETANDO TODOS OS NUMEROS PARES");
        for(int i = 0 ; i < ar.size() ; i++){
            Nó temp = ar.get(i);       
            excluir(raiz,temp.valor);
        }        
        
        System.out.println("Folhas restantes: "+contaFolhas(raiz));
        System.out.println("\n \n");
        // FIM QUESTÃO 1
        
        //QUESTÃO 2
        raiz = null;
        LerArquivos("Questao2");
        System.out.println("QUESTÃO 2");
        Conta1Filho(raiz);
        System.out.println("Numero de Nós que possuem 1 filho: "+cont);
        System.out.println("\n \n");
        // FIM QUESTÃO 2
        
        //QUESTÃO 3
        raiz = null;
        ar.clear();
        System.out.println(ar.size());
        LerArquivos("Questao3");
        System.out.println("QUESTÃO 3");
        System.out.println("DELETANDO TODOS OS NUMEROS MULTIPLOS DE 5");
        LocalizarMultiplo5(raiz);
        for(int i = 0; i < ar.size() ; i++){
            Nó temp = ar.get(i);
            excluir(raiz,temp.valor);
        }
        System.out.println("Folhas restantes: "+contaFolhas(raiz));
        System.out.println("\n \n");
        // FIM QUESTÃO 3
        
        
        
        //QUESTÃO 4
        raiz = null;
        LerArquivos("Questao4");
        System.out.println("QUESTÃO 4");
        System.out.println("o valor é: "+Questao4(raiz.esq));
        System.out.println("\n \n");
        // FIM QUESTÃO 4
        
        
        
        //QUESTÃO 5
        raiz = null;
        //LerArquivos("Questao5");
        //System.out.println("QUESTÃO 5");
        //Nó_to_Array(raiz);
        //raiz = null;
        //Questao5(raiz);
        //System.out.println(profundidade(raiz));
        //insere(raiz,5);
        //System.out.println(raiz.valor);
        System.out.println("\n \n");
        // FIM QUESTÃO 5
        
        
        //QUESTÃO 6
        raiz = null;
        ar.clear();
        LerArquivos("Questao6");
        System.out.println("QUESTÃO 6");
        System.out.println("DELETANDO TODOS OS NUMEROS MULTIPLOS DE 3, 5 e 7");
        LocalizarMultiplo(raiz);
        for(int i = 0; i < ar.size() ; i++){
            Nó temp = ar.get(i);
            excluir(raiz,temp.valor);
        }
        System.out.println("Folhas restantes: "+contaFolhas(raiz));
        System.out.println("\n \n");
        // FIM QUESTÃO 6
        
        
    }
    public static void Questao5(Nó temp){
        insereIterativo(0);
        for(int i = 0 ; i < ArrayDoNó.size() ; i++){
            if(ArrayDoNó.get(i) % 2 == 0){
                insere(raiz.dir,ArrayDoNó.get(i));
            }else{
                insere(raiz.esq,ArrayDoNó.get(i));
            }
        }
    }
    public static int Questao4(Nó temp){
        while(temp.dir != null){
            temp = temp.dir;
        }
        return temp.valor;
    }
    public static void LerArquivos(String arq) throws FileNotFoundException, IOException{
        
        String currentDirectory = new File("").getAbsolutePath();
        BufferedReader buffRead = new BufferedReader(new FileReader(currentDirectory+"\\src\\week12\\" +arq+".txt"));
        String linha = buffRead.readLine();
        int x;
        while (linha != null) {
            x = Integer.parseInt(linha);
            insereIterativo(x);
            
            linha = buffRead.readLine();
        }
        buffRead.close();

    }

    public static void printBinaryTree(Nó root, int level){
    if(root==null)
         return;
    printBinaryTree(root.dir, level+1);
    if(level!=0){
        for(int i=0;i<level-1;i++)
            System.out.print("|\t");
            System.out.println("|-------"+root.valor);
    }
    else
        System.out.println(root.valor);
    printBinaryTree(root.esq, level+1);
}    

    public static Nó BuscarValor(Nó temp, int v) {
        if (temp == null) {
            return null;
        }

        if (temp.valor == v) {
            return temp;
        }

        if (v < temp.valor) {
            return BuscarValor(temp.esq, v);
        } else {
            return BuscarValor(temp.dir, v);
        }
    }

    public static int MaiorValor(Nó temp) {
        if (raiz == null) {
            return -1;
        } else {
            if (temp == null) {
                return 0;
            } else {
                if (temp != null && temp.esq == null && temp.dir == null) {
                    return temp.valor;
                } else {
                    int esq = MaiorValor(temp.esq);
                    int dir = MaiorValor(temp.dir);
                    if (esq >= dir) {
                        return esq;
                    } else {
                        return dir;
                    }
                }
            }
        }
    }

    public static void RemoveValor(int v) {
        Nó temp = raiz;
        //Buscar o Valor
        Nó encontrar = BuscarValor(temp, v);
        if (encontrar != null) {
            System.out.println("está na árvore");
        } else {
            System.out.println("Não está na árvore");
        }
    }
    
    public static boolean localizar(Nó aux, int num) {
        boolean loc = false;
        if (aux != null) {
            if (aux.valor == num) {
                loc = true;
            } else if (num < aux.valor) {
                loc = localizar(aux.esq, num);
            } else {
                loc = localizar(aux.dir, num);
            }
        }
        return loc;
    }
    
    public static Nó excluir(Nó aux, int num) {
        Nó temp, temp2, rotativo = null;
        if (aux.valor == num){
            if (aux.esq == aux.dir){
                return null;
            }else
                if (aux.esq == null){
                return aux.dir;
            } else 
                if (aux.dir == null) {
                return aux.esq;
            } else{
                temp2 = aux.dir;
                temp = aux.dir;
                while (temp.esq != null) {
                	rotativo = temp;
                    temp = temp.esq;
                }
                aux.valor = temp.valor;
                //temp = null;
                //rotativo.esq = null;
                return aux;
            }
        } else if (aux.valor < num) {
            aux.dir = excluir(aux.dir, num);
        } else {
            aux.esq = excluir(aux.esq, num);
        }
        return aux;
    }

    public static void insere(Nó temp, int v) {
        Nó novo = new Nó(v);

        if (temp == null) {
            temp = novo;
        } else {
            boolean inseriu = false;
            Nó temp2 = temp;

            while (!inseriu) {
                if (novo.valor <= temp2.valor) {
                    if (temp2.esq == null) {
                        temp2.esq = novo;
                        inseriu = true;
                    } else {
                        temp2 = temp2.esq;
                    }
                } else {
                    if (temp2.dir == null) {
                        temp2.dir = novo;
                        inseriu = true;
                    } else {
                        temp2 = temp2.dir;
                    }

                }
            }
        }
    }
    
    public static void insereIterativo(int v) {
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

    public static void LocalizarMultiplo5(Nó temp){
        if (temp != null){
            LocalizarMultiplo5(temp.esq);
            LocalizarMultiplo5(temp.dir);
            if(temp.valor % 5 == 0){
                ar.add(temp);
            }
        }
    }
    
    public static void LocalizarMultiplo(Nó temp){
        if (temp != null){
            LocalizarMultiplo5(temp.esq);
            LocalizarMultiplo5(temp.dir);
            if(temp.valor % 5 == 0 || temp.valor % 2 == 0 || temp.valor % 3 == 0){
                ar.add(temp);
            }
        }
    }
    
    public static void LocalizarPar(Nó temp){
        if (temp != null){
            LocalizarPar(temp.esq);
            LocalizarPar(temp.dir);
            if(temp.valor % 2 == 0){
                ar.add(temp);
            }
        }
    }
    
    public static void PreExibe(Nó temp) {
        if (temp != null) {
            System.out.println(temp.valor);
            PreExibe(temp.esq);
            PreExibe(temp.dir);
        }
    }
    
    public static void Nó_to_Array(Nó temp){
        if(temp != null) {
            Nó_to_Array(temp.esq);
            Nó_to_Array(temp.dir);
            ArrayDoNó.add(temp.valor);
        }
    }

    public static void ExibeOrdenado(Nó temp) {
        if (temp != null) {
            ExibeOrdenado(temp.esq);
            System.out.println(temp.valor);
            ExibeOrdenado(temp.dir);
        }
    }

    public static void ExibeInverso(Nó temp) {
        if (temp != null) {
            ExibeInverso(temp.dir);
            System.out.println(temp.valor);
            ExibeInverso(temp.esq);
        }
    }

    
    public static void Exibe1Filho(Nó temp) {
        if (temp != null) {
            Exibe1Filho(temp.esq);
            Exibe1Filho(temp.dir);

            if ((temp.esq == null && temp.dir != null) || (temp.esq != null && temp.dir == null)) {
                System.out.println(temp.valor);
            }
        }

    }

    public static void ExibeFolhas(Nó temp) {
        if (temp != null) {
            ExibeFolhas(temp.esq);
            ExibeFolhas(temp.dir);

            if (temp.esq == null && temp.dir == null) {
                System.out.println(temp.valor);
            }
        }
    }

    public static void ExibeSubEsq(Nó temp) {
        temp = temp.esq;
        System.out.println(" " + temp.valor);
        if (temp.esq == null && temp.dir == null) {
            System.out.printf(null + " " + null);
        }
        if (temp.esq == null && temp.dir != null) {
            System.out.printf(null + " " + temp.dir.valor);
        }
        if (temp.esq != null && temp.dir == null) {
            System.out.println(temp.dir.valor + " " + null);
        } else {
            System.out.printf(temp.esq.valor + " " + temp.dir.valor);
        }

        System.out.printf("\n");
    }

    public static void ExibeSubDir(Nó temp) {
        temp = temp.dir;
        System.out.println(" " + temp.valor);
        if (temp.esq == null && temp.dir == null) {
            System.out.printf(null + " " + null);
        } else if (temp.esq == null && temp.dir != null) {
            System.out.printf(null + " " + temp.dir.valor);
        } else if (temp.esq != null && temp.dir == null) {
            System.out.println(temp.dir.valor + " " + null);
        } else {
            System.out.printf(temp.esq.valor + " " + temp.dir.valor + "\n");
        }
    }

    public static int contaFolhas(Nó temp) {
        if (temp == null) {
            return 0;
        } else {
            if (temp.esq != null || temp.dir != null) {
                return contaFolhas(temp.esq) + contaFolhas(temp.dir);
            } else {
                if (temp.esq == null && temp.dir == null) {
                    return 1;
                }
            }
        }
        return 0;
    }
    
    public static int Conta1Filho(Nó temp) {
        if (temp != null) {
            Conta1Filho(temp.esq);
            Conta1Filho(temp.dir);

            if ((temp.esq == null && temp.dir != null) || (temp.esq != null && temp.dir == null)) {
                cont++;
            }
        }
        return 0;
    }

    public static int profundidade(Nó temp) {

        if (raiz == null) {
            return -1;

        } else {
            if ((temp == null) || (temp.esq == null && temp.dir == null)) {
                return 0;
            } else {
                int ld = profundidade(temp.dir);
                int le = profundidade(temp.esq);

                if (ld > le) {
                    return ld + 1;
                } else {
                    return le + 1;
                }

            }
        }
    }

}
