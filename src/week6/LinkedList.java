package week6;
public class LinkedList {
    
    static Nodes inicio = null;
    
    public static void main(String[] args) {

        inserir(5);
        inserir(9);
        inserir(3);
        inserir(12);

        System.out.println("Essa lista possui "+tamanho(inicio)+" elementos, são eles:");
        
        exibir(inicio);
        System.out.println("--------");
        
        
        removeInicio(inicio);
        exibir(inicio);
        
        System.out.println("--------");
        
        removeFim(inicio);
        exibir(inicio);
        
    }

    static void inserir(int x) {
        Nodes novo = new Nodes(x);
        if (inicio == null)
            inicio = novo;
        else {
            Nodes temp = inicio;
            while (temp.prox != null)
                temp = temp.prox;
            
            temp.prox = novo;
        }
    }

    static void exibir(Nodes temp) {
        if (inicio == null) 
            System.out.println("Lista Vazia, nada a exibir");
        else 
            if (temp != null) {
                System.out.println(temp.valor);
                exibir(temp.prox);
            }
    }

    static int tamanho(Nodes temp) {
        if (temp != null)
            return 1 + tamanho(temp.prox);

        return 0;
    }

    static void removeInicio(Nodes temp){
        inicio = temp.prox;
    }
    
    static void removeFim(Nodes temp){
        Nodes temp2 = null;
        while(temp.prox != null){
            temp2 = temp;
            temp = temp.prox;
        }
        temp2.prox = null;

    }

    static void removeValor(int x){
        Nodes temp2 = null;
        while(temp.prox != null){
            temp2 = temp;
            temp = temp.prox;
        }
        temp2.prox = null;

    }


}
