package week12;

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

    public static void main(String[] args) throws IOException {
        
        // QUESTÃO 1
        LerArquivos("Questao1");
        LocalizarPar(raiz);
        
        for(int i = 0 ; i < ar.size() ; i++){
            Nó temp = ar.get(i);       
            excluir(raiz,temp.valor);
        }
        
        PreExibe(raiz);
        
        System.out.println(contaFolhas(raiz));
        
        
        
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
