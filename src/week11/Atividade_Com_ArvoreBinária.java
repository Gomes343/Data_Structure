package week11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;



public class Atividade_Com_ArvoreBinária {
    
    static NoA raiz = null;
    static String arq;
    static int contFilho = 0;
    static int somaFolhaPar = 0;
    static int contFolhaImpar = 0;
    static int contFilho10 = 0;
    
    public static void main(String[]args) throws IOException{
        
    arq = "300";
    LerArquivos(arq);
    PerguntasRespostas();    
    raiz = null;
    contFilho = 0;
    somaFolhaPar = 0;
    contFolhaImpar = 0;
    contFilho10 = 0;
    
    
    arq = "500";
    LerArquivos(arq);
    PerguntasRespostas();
    raiz = null;
    contFilho = 0;
    somaFolhaPar = 0;
    contFolhaImpar = 0;
    contFilho10 = 0;
    
    arq = "1000";
    LerArquivos(arq);
    PerguntasRespostas();
    raiz = null;
    contFilho = 0;
    somaFolhaPar = 0;
    contFolhaImpar = 0;
    contFilho10 = 0;
    
    arq = "3000";
    LerArquivos(arq);
    PerguntasRespostas();
    raiz = null;
    contFilho = 0;
    somaFolhaPar = 0;
    contFolhaImpar = 0;
    contFilho10 = 0;
    
    arq = "5000";
    LerArquivos(arq);
    PerguntasRespostas();
    raiz = null;    
    contFilho = 0;
    somaFolhaPar = 0;
    contFolhaImpar = 0;
    contFilho10 = 0;
    
    arq = "10000";
    LerArquivos(arq);
    PerguntasRespostas();
    raiz = null;
    contFilho = 0;
    somaFolhaPar = 0;
    contFolhaImpar = 0;
    contFilho10 = 0;
    }
    
    
    public static void PerguntasRespostas(){
        System.out.println("========== ARQUIVO "+arq+".txt ==========");
        System.out.println("Quantas Folhas existem?");
        System.out.println("R: "+contaFolhas(raiz));
        System.out.println("Qual a Profundidade?");
        System.out.println("R: "+profundidade(raiz));        
        System.out.println("Quantos Nós possuem apenas 1 filho?");
        Conta1Filho(raiz);
        System.out.println("R: "+contFilho);
        System.out.println("Qual a soma dos valores de todas folhas que possuem valor par?");
        SomaFolhaPar(raiz);
        System.out.println("R: "+somaFolhaPar);
        System.out.println("Quantas folhas possuem valor impar?");
        ContaFolhaImpar(raiz);
        System.out.println("R: "+contFolhaImpar);
        System.out.println("Quantos nós, que possuem 2 filhos, são multiplos de 10?");
        No2Filhos10(raiz);
        System.out.println("R: "+contFilho10);
        System.out.println(" \n \n \n ");
        
    }
    
    public static void LerArquivos(String arq) throws FileNotFoundException, IOException{
        
        String currentDirectory = new File("").getAbsolutePath();
        BufferedReader buffRead = new BufferedReader(new FileReader(currentDirectory+"\\src\\week11\\" +arq+".txt"));
        String linha = buffRead.readLine();
        int x;
        while (linha != null) {
            x = Integer.parseInt(linha);
            insereIterativo(x);
            
            linha = buffRead.readLine();
        }
        buffRead.close();

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
    
    public static void No2Filhos10(NoA temp){
        if(temp != null){
            No2Filhos10(temp.esq);
            No2Filhos10(temp.dir);
            
            if((temp.esq != null && temp.dir != null && temp.valor % 10 == 0)){
                contFilho10++;
            }
        }
    }
    public static void ContaFolhaImpar(NoA temp){
        if (temp != null){
            ContaFolhaImpar(temp.esq);
            ContaFolhaImpar(temp.dir);
            
            if(temp.esq == null && temp.dir == null && temp.valor % 2 == 1){
                contFolhaImpar++;         
            }
        }
    }
    
    public static void SomaFolhaPar(NoA temp){
        if (temp != null){
            SomaFolhaPar(temp.esq);
            SomaFolhaPar(temp.dir);
            
            if(temp.esq == null && temp.dir == null && temp.valor % 2 == 0){
                somaFolhaPar += temp.valor;
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
        
    
    public static void Conta1Filho(NoA temp){
        int cont = 0;
        if (temp != null){
            Conta1Filho(temp.esq);
            Conta1Filho(temp.dir);
            
            if((temp.esq == null && temp.dir != null)||(temp.esq != null & temp.dir == null)){
                contFilho++;
            }   
        }
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
