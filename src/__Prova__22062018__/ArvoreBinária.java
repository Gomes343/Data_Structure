package __Prova__22062018__;

import __Prova__22062018__.ArvoreBinária;
import static __Prova__22062018__.ArvoreBinária.raiz;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Este é basicamente o Arivo do Pacote: EstudoProva!
//a partir do básico dele

public class ArvoreBinária{

    static Nó raiz;
    
    public static void main(String[] args) throws IOException {

        raiz = null;
        String arquivo = "Questão1";
        LerArquivos(arquivo);
        System.out.println("\n===== QUESTÃO 1 =====");
        System.out.println("REMOVER TODOS OS VALORES MENORES OU IGUAIS A 1000");
        System.out.println("QT total excluida: "+Prova.ContadorValor(raiz, 1000));
        Prova.Questao1(raiz);
        System.out.println("Valor total de Folhas restantes: "+Prova.contaFolhas(raiz));

        
        
        raiz = null;
        arquivo = "Questão2";
        LerArquivos(arquivo);
        System.out.println("\n===== QUESTÃO 2 =====");
        System.out.println("REMOVER TODOS OS VALORES PARES E MULTIPLOS DE 4");
        Prova.Questao2(raiz);
        System.out.println("A profundidade após remoção é: "+profundidade(raiz));
        
          
        raiz = null;
        arquivo = "Questão3";
        LerArquivos(arquivo);
        System.out.println("\n===== QUESTÃO 3 =====");
        System.out.println("Encontrar o Valor, do nó mais a esquerda,"
                + "da sub-arvore da direita em relação ao número 1234");        
        System.out.println("o Valor é: "+Prova.Questao3(raiz));
        
        
        raiz = null;
        arquivo = "Questão4";
        LerArquivos(arquivo);
        System.out.println("\n===== QUESTÃO 4 =====");
        System.out.println("Após uma Rotação a direita, quantas folhas"
                + " sobram na esquerda?");        
        rotacaoDireita(raiz,raiz);
        System.out.println("As folhas da Sub-Arvore da Esquerda são: "+Prova.contaFolhas(raiz.esq));
        
        raiz = null;
        arquivo = "Questão5";
        LerArquivos(arquivo);
        System.out.println("\n===== QUESTÃO 5 =====");
        System.out.println("Após uma Rotação dupla à esquerda no Nó raiz"
                + " quantos nós restarão na sub arvore da direita?");        
        rotacaoDireita(raiz.dir,raiz);
        rotacaoEsquerda(raiz,raiz);
        System.out.println("valor total de Nó's: "+Prova.ContadorDeNó(raiz.dir));
        
        
        
        
        
        
        

    }
    
    public static void LerArquivos(String arq) throws FileNotFoundException, IOException{
        
        String currentDirectory = new File("").getAbsolutePath();
        BufferedReader buffRead = new BufferedReader(new FileReader(currentDirectory+"\\src\\__Prova__22062018__\\" +arq+".txt"));
        String linha = buffRead.readLine();
        int x;
        while (linha != null) {
            x = Integer.parseInt(linha);
            insere(x);
            
            linha = buffRead.readLine();
        }
        buffRead.close();

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
    
    public static void rotacaoDireita(Nó temp, Nó pai){
        if( temp == raiz && pai == raiz){
            Nó x = temp;
            Nó y = x.esq;
            x.esq = y.dir;
            y.dir = x;
            raiz = y;
        }else{
            Nó x = temp;
            Nó y = x.esq;
            x.esq = y.dir;
            y.dir = x;
            pai.dir = y;
        }
        
    }
    
    public static void rotacaoEsquerda(Nó temp,Nó pai){
        if( temp == raiz && pai == raiz){
            Nó x = temp;
            Nó y = x.dir;
            x.dir = y.esq;
            y.esq = x;
            raiz = y;
        }else{
            Nó x = temp;
            Nó y = x.dir;
            x.dir = y.esq;
            y.esq = x;
            
            if(pai.dir == temp)
                pai.dir = y;
            
            if(pai.esq == temp)
                pai.esq = y;
        }
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

class Prova{
    
    public static void Questao1(Nó n){
        if(n != null){
            Questao1(n.esq);
            Questao1(n.dir);
            if(n.valor <= 1000)
                Remoção.remover(n.valor);
        }
    }
    
    public static void Questao2(Nó n){
        if(n != null){
            Questao2(n.esq);
            Questao2(n.dir);
            if(n.valor % 2 == 0 || n.valor % 4 == 0)
                Remoção.remover(n.valor);
        }
    }
    
    public static int Questao3(Nó n){
        Nó objetivo;
        int ValorNó = 0;
        if(n != null){
            if(n.valor == 1234){ 
               objetivo = Remoção.noMaisAEsquerda(n.dir); 
               return ValorNó += objetivo.valor;
            }else
                if(1234 > n.valor)    
                    return ValorNó += Questao3(n.dir);
                else
                    return ValorNó += Questao3(n.esq);                    
        }
        return 0;
    }
    
    public static int ContadorDeNó(Nó n){
        //utilizado para tQuestão 5
        int qt = 0;
        if(n != null){
            qt++;
            
            return qt+=ContadorDeNó(n.esq) + ContadorDeNó(n.dir);
        }
        return qt;
    }
    
    public static int ContadorValor(Nó n, int range){
        //utilizado apenas para testar se a questão 1 está correta
        int qt = 0;
        if(n != null){
            if(n.valor <= range)
                qt++;
            
            return qt+=ContadorValor(n.dir,range) + ContadorValor(n.esq,range);
        }
        return qt;
    }
    
    public  static int contaFolhas(Nó n){
          int x=0;
          
          if(n.esq != null )
               x+=contaFolhas(n.esq);
          if(n.dir != null)
              x+=contaFolhas(n.dir);
          
          if((n.esq == null)&&(n.dir == null))
              x++;
              
          return x;
      }   
    
}




class PrinterArvore{

static void ExibeDeitado(Nó n, int x){

        if(n.dir != null)
            ExibeDeitado(n.dir, x+1);
        else
            System.out.println();

        for(int i=1; i<=x; i++)
            System.out.print("|  ");
        
        if((n.esq == null)&&(n.dir == null))
            System.out.print("["+n.valor+"]");
        else
            System.out.print(n.valor);
   
        if(n.esq != null)
            ExibeDeitado(n.esq, x+1);
        else
            System.out.println();
        
    }

    public static void PrintArvore(Nó root){
        int maxLevel = ProfundidadeMax(root);

        PrintArvoreInterno(Collections.singletonList(root), 1, maxLevel);
    }

    private static void PrintArvoreInterno(List<Nó> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        PrintarEspaçosBrancos(firstSpaces);

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

            PrintarEspaçosBrancos(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                PrintarEspaçosBrancos(firstSpaces - i);
                if (nodes.get(j) == null) {
                    PrintarEspaçosBrancos(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).esq != null)
                    System.out.print("/");
                else
                    PrintarEspaçosBrancos(1);

                PrintarEspaçosBrancos(i + i - 1);

                if (nodes.get(j).dir != null)
                    System.out.print("\\");
                else
                    PrintarEspaçosBrancos(1);

                PrintarEspaçosBrancos(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        PrintArvoreInterno(newNodes, level + 1, maxLevel);
    }

    private static void PrintarEspaçosBrancos(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int ProfundidadeMax(Nó node) {
        if (node == null)
            return 0;

        return Math.max(ProfundidadeMax(node.esq), ProfundidadeMax(node.dir)) + 1;
    }

    private static boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}


class Remoção{

   static void remover(int x){
	   if(raiz.valor == x){
		   if((raiz.esq == null) && (raiz.dir==null))
				raiz = null;
			else 
				if((raiz.esq != null) && (raiz.dir != null))
					removeDoisFilhos(raiz,x);
				else
					if(raiz.esq == null)
						raiz = raiz.dir;
					else
						raiz = raiz.esq;
	   }
	   else
			removeNo(raiz, x);
   } 
        
    static void removeNo(Nó n, int x){
        
        int f = contaFilhos(n,x);
              
        switch(f){
			case -1: System.out.println("O nó não existe na árvore"); break;
			case  0: removeFolha(n,x); break;
			case  1: removeUmFilho(n,x); break; 
			case  2: removeDoisFilhos(n,x); break;
		}
    }
    
    static int contaFilhos(Nó n, int x){
        int nro_filhos = 0;
        
        if(n.valor == x){
            if(n.esq != null)
                nro_filhos++;
            if(n.dir != null)
                nro_filhos++;
        }else{

			if(x < n.valor)
				if(n.esq != null)
                    nro_filhos+=contaFilhos(n.esq,x);    
                else
					return -1;
                    
			if(x > n.valor)
                if(n.dir != null)
                    nro_filhos+=contaFilhos(n.dir,x);
                else
                    return -1;
        }    
        return nro_filhos;
    }
    
    static void removeFolha(Nó n, int x) {
        
        if(n.esq != null){
            if (n.esq.valor == x) {
                n.esq = null;
            }else{ 
                if(n.valor > x){
                    removeFolha(n.esq, x);
                }
            }
        }

        if(n.dir != null){
            if (n.dir.valor == x) {
                n.dir = null;
            }else{ 
                if(n.valor < x){
                    removeFolha(n.dir, x);
                }
            }
        }
    }               
        
    static void removeUmFilho(Nó n, int x) {
        boolean removeu = false;
        
        if (n.esq != null) {
            if (n.esq.valor == x) {
                removeu = true;
                if (n.esq.esq != null) {
                    n.esq = n.esq.esq;
                } else if (n.esq.dir != null) {
                    n.esq = n.esq.dir;
                }
            }
        }

        if (n.dir != null) {
            if (n.dir.valor == x) {
                removeu = true;
                if (n.dir.esq != null) {
                    n.dir = n.dir.esq;
                } else if (n.dir.dir != null) {
                    n.dir = n.dir.dir;
                }
            }

        }

        if (!removeu) {
            if (x < n.valor) {
                removeUmFilho(n.esq, x);
            } else {
                removeUmFilho(n.dir, x);
            }
        }
    }
		
    static void removeDoisFilhos(Nó n, int x){
         if(n.valor == x){
			
			Nó tmp = noMaisAEsquerda(n.dir);
			
			int novovalor = tmp.valor;
	
			removeNo(n,tmp.valor);
			n.valor = novovalor;
			
		} else{
			if(x<n.valor)
				removeDoisFilhos(n.esq, x);
			else
				removeDoisFilhos(n.dir, x);
		}		
    }
    
    static Nó noMaisAEsquerda(Nó n){
		Nó retorno = null;
		if(n.esq!=null){
			
			retorno = noMaisAEsquerda(n.esq);
		}
			else
				retorno = n;
		
		return retorno;
		
	}
    
    
    
    
/*
	// ESSE MÉTODO REMOVE TODAS AS FOLHAS EXISTENTES NA ÁRVORE ATUAL (NOTE QUE A REMOÇÃO DE FOLHAS IRÁ GERAR UMA NOVA ÁRVORE COM OUTRAS FOLHAS) 
    static void removeFolhas(Nó n) {
		if (n.esq != null) {
			if (temFilho(n.esq)) {
				removeFolhas(n.esq);
			} else {
				n.esq = null;
			}
		}
		
		if (n.dir != null) {
			if (temFilho(n.dir)) {
				removeFolhas(n.dir);
			} else {
				n.dir = null;
			}	
		}
    }

	// MÉTODO QUE VERIFICA SE UM NÓ TEM FILHOS OU NÃO
      static boolean temFilho(Nó n){
          if((n.esq==null) && (n.dir==null))
              return false;
          else
              return true;
      }*/
}