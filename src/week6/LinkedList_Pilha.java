package week6;
public class LinkedList_Pilha{
    
    static Nodes inicio = null;
    
    public static void main(String[] args) {


        exibir(inicio);
        desempilhar();
        System.out.println("---------");
        exibir(inicio);

    }

    static void empilhar(int x) {
        Nodes novo = new Nodes(x);
        if (inicio == null){
            inicio = novo;
        }
        else {
            Nodes temp = inicio;
            while (temp.prox != null)
                temp = temp.prox;
            
            temp.prox = novo;
        }
    }

    static void desempilhar(){
        Nodes temp = inicio;
        Nodes temp2 = inicio;
        if(vazio()==true)
            System.out.println("Erro - Não há o que desempilhar");
        else{
        
        while(temp.prox != null){
            temp2 = temp;
            temp = temp.prox;
        }
        temp2.prox = null;
        }
    }
    
    static void topo(Nodes p){
        Nodes temp = inicio;
        while (temp.prox != null){
            temp = temp.prox;
        }
        System.out.println("Topo é: " + p.valor);
    }

    static int tamanho(Nodes temp) {
        if (temp != null)
            return 1 + tamanho(temp.prox);

        return 0;
    }

    static boolean vazio(){
        if(inicio == null)
            return true;
        else
            return false;
    }

    static void exibir(Nodes temp) {
        if (vazio() == true) 
            System.out.println("Lista Vazia, nada a exibir");
        else 
            if (temp != null) {
                System.out.println(temp.valor);
                exibir(temp.prox);
            }
    }


    


}
