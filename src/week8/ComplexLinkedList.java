package week8;
public class ComplexLinkedList {
    
    static Nodes inicio = null;
    static Nodes fim = null;
    
    public static void main(String[] args) {

        inserir(99);
        inserir(30);
        inserir(6);


        System.out.println("Essa lista possui "+tamanho(inicio)+" elementos, são eles:");
        exibir(inicio);
        

        
    }
    

    static void inserir(int x) {
        Nodes novo = new Nodes(x);
        if (inicio == null){
            inicio = novo;
            fim = novo;
        }
        else {
            Nodes temp = inicio;
            while (temp.prox != null)
                temp = temp.prox;
            
            temp.prox = novo;
            fim = novo;
            novo.ant = temp;
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

    static void removeValor( int x){
        Nodes temp = inicio;
        Nodes temp2 = temp;
        boolean first = true;
        boolean nofirst = false;
        
        if(temp.prox == null && temp.valor == x){
            inicio = null;
        }

        
        
        while(temp.prox != null){
            if(first == true && temp2.valor == x){
                first = false;
                inicio = inicio.prox;
                nofirst = false;
            }
            
            if(temp.valor == x && nofirst == true){
                temp2.prox = temp.prox;
            }
            temp2 = temp;
            temp = temp.prox;
            first = false;
            nofirst = true;
        }
        
        if(temp.prox == null && temp.valor == x)
            temp2.prox = null;

    }

    static void exibirInverso(Nodes temp){
        if(inicio == null)
            System.out.println("Lista Vazia, nada a exibir");
        else
            if (temp != null) {
                exibirInverso(temp.prox);
                System.out.println(temp.valor);
            }
    }
    
}
