package week11;

import java.util.ArrayList;



public class Atividade_Com_ArvoreBinária {
    static NoA raiz = null;
    ArrayList<Integer> tamanho300 = new ArrayList();
    ArrayList<Integer> tamanho500 = new ArrayList();
    ArrayList<Integer> tamanho1000 = new ArrayList();
    ArrayList<Integer> tamanho3000 = new ArrayList();
    ArrayList<Integer> tamanho5000 = new ArrayList();
    ArrayList<Integer> tamanho10000 = new ArrayList();
    
    public static void main(String[]args){
        
            
        
        
        
        
        
        
    }
    
    public static void LerArquivos(){

    }

    public static void insereIterativo(int v) {
        NoA novo = new NoA(v);

        if (raiz == null) {
            raiz = novo;
        } else {
            boolean inseriu = false;
            NoA temp = raiz;

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

    public static void PreExibe(NoA temp) {
        if (temp != null) {
            System.out.println(temp.valor);
            PreExibe(temp.esq);
            PreExibe(temp.dir);
        }
    }

    public static void ExibeOrdenado(NoA temp) {
        if (temp != null) {
            ExibeOrdenado(temp.esq);
            System.out.println(temp.valor);
            ExibeOrdenado(temp.dir);
        }
    }

    public static void ExibeInverso(NoA temp) {
        if (temp != null) {
            ExibeInverso(temp.dir);
            System.out.println(temp.valor);
            ExibeInverso(temp.esq);
        }
    }

    public static void Exibe1Filho(NoA temp) {
        if (temp != null){
            Exibe1Filho(temp.esq);
            Exibe1Filho(temp.dir);
            
            if((temp.esq == null && temp.dir != null)||(temp.esq != null && temp.dir == null)){
                System.out.println(temp.valor);                
            }
        }
        
    }
    
    public static void ExibeFolhas(NoA temp){
        if (temp != null){
            ExibeFolhas(temp.esq);
            ExibeFolhas(temp.dir);
            
            if(temp.esq == null && temp.dir == null){
                System.out.println(temp.valor);                
            }
        }
    }

    public static void ExibeSubEsq(NoA temp){
        temp = temp.esq;
        System.out.println(" "+temp.valor);
        if(temp.esq == null && temp.dir == null)
            System.out.printf(null+" "+null);
        if(temp.esq == null && temp.dir != null)
            System.out.printf(null+" "+temp.dir.valor);
        if(temp.esq != null && temp.dir == null)
            System.out.println(temp.dir.valor+" "+null);
        else
            System.out.printf(temp.esq.valor+" "+temp.dir.valor);    
            
        System.out.printf("\n");
    }

    public static void ExibeSubDir(NoA temp){
        temp = temp.dir;
        System.out.println(" "+temp.valor);
        if(temp.esq == null && temp.dir == null)
            System.out.printf(null+" "+null);
        else
        if(temp.esq == null && temp.dir != null)
            System.out.printf(null+" "+temp.dir.valor);
        else
        if(temp.esq != null && temp.dir == null)
            System.out.println(temp.dir.valor+" "+null);
        else
            System.out.printf(temp.esq.valor+" "+temp.dir.valor+"\n");    
    }
        
    public static int contaFolhas(NoA temp) {
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

    public static int profundidade(NoA temp) {

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
