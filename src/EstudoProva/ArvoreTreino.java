package EstudoProva;

import static EstudoProva.ArvoreTreino.raiz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArvoreTreino{

    static Nó raiz;
    public static void main(String[] args) {

        insere(3);
        insere(5);
        insere(7);
        insere(1);
        insere(4);
        insere(6);
        insere(8);

        System.out.println("ARVORE DESBALANCEADA");
        PrinterArvore.PrintArvore(raiz);

        
        
        
        
        System.out.println("ARVORE BALANCEADA - ROTAÇÃO À ESQUERDA");
        rotacaoEsquerda(raiz,raiz);
        PrinterArvore.PrintArvore(raiz);
        
        
        
        raiz = null;
        insere(6);
        insere(7);
        insere(4);
        insere(2);
        insere(1);
        insere(3);
        insere(5);
        System.out.println("ARVORE DESBALANCEADA");
        PrinterArvore.PrintArvore(raiz);
        
        System.out.println("ARVORE BALANCEADA - ROTAÇÃO À DIREITA");
        rotacaoDireita(raiz,raiz);
        PrinterArvore.PrintArvore(raiz);
        
        
        
        
        System.out.println("EXEMPLOS DE BALANCEAMENTO EM SUB-ARVORES!!!!");
        
        raiz = null;
        insere(6);
        insere(5);
        insere(10);
        insere(7);
        insere(12);
        insere(11);
        insere(15);
        insere(14);
        insere(16);
        System.out.println("ARVORE DESBALANCEADA");
        PrinterArvore.PrintArvore(raiz);
        
        System.out.println("FEITO ROTAÇÃO À ESQUERDA, VEJA ABAIXO:");
        rotacaoEsquerda(raiz.dir,raiz);
        PrinterArvore.PrintArvore(raiz);
        System.out.println("AINDA ESTÁ DESBALANCEADA! FAZER OUTRA ROTAÇÃO À ESQUERDA");
        
        System.out.println("VEJA ABAIXO:");
        rotacaoEsquerda(raiz,raiz);
        PrinterArvore.PrintArvore(raiz);
        
        
        
        
        
        System.out.println("A DUPLA É ISSO MESMO, SÓ FALTA CRIAR UM MÉTODO Q ENTENDA ISSO E SAIBA OQ FAZER EM CADA SITUAÇÃO!");
        raiz = null;
        
        insere(7);
        insere(9);
        insere(3);
        insere(2);
        insere(5);
        insere(6);
        insere(4);
        PrinterArvore.PrintArvore(raiz);
        rotacaoEsquerda(raiz.esq,raiz);
        PrinterArvore.PrintArvore(raiz);
        rotacaoDireita(raiz,raiz);
        PrinterArvore.PrintArvore(raiz);
                
        
        

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

}

class PrinterArvore{

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
   // ESSE METODO EXISTE EXCLUISIVAMENTE PARA VERIFICAR SE O VALOR A SER REMOVIDO ESTA NA RAIZ DA ARVORE (inicio)
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
			
			// ISSO SERVE PARA RESOLVER O PROBLEMA DO N.DIR SER O NUMERO A SER REMOVIDO
			int novovalor = tmp.valor;
			// ESTA SENDO PASSADO POR PARAMETRO O VALOR DE N (PAI DE N.DIR)
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