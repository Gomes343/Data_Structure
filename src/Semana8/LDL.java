package Semana8;
public class LDL{
    
    static Nodes inicio = null;
    static Nodes fim = null;
    
    public static void main(String[] args) {

        inserir(99);
        inserir(30);
        inserir(6);


        System.out.println("Essa lista possui "+tamanho(inicio)+" elementos, são eles:");

       
        exibir();
        
        exibirInverso();
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

    static void exibir() {
        Nodes temp = inicio;
        if (inicio == null) 
            System.out.println("Lista Vazia, nada a exibir");
        else{ 
            while(temp != null){
                System.out.println(temp.valor);
                temp = temp.prox;
            }
        }
    }

    static void exibirInverso(){
        Nodes temp = fim;
        if(fim == null)
            System.out.println("Lista Vazia, nada a exibir");
        else
            while(temp != null){
                System.out.println(temp.valor);
                temp = temp.ant;
            }
    } 

    static int tamanho(Nodes temp) {
        if (temp != null)
            return 1 + tamanho(temp.prox);

        return 0;
    }

    static void removeInicio(){
        inicio = inicio.prox;
        inicio.ant = null;
    }
    
    static void removeFim(){
        fim = fim.ant;
        fim.ant.prox = null;
    }

    static void removeValor(int x){
        Nodes temp = inicio;
        boolean first = true;
        boolean nofirst = false;
        
        if(temp.prox == null && temp.valor == x){
            inicio = null;
            fim = null;
        }

        
        
        while(temp.prox != null){
            if(first == true && temp.valor == x){
                first = false;
                inicio = inicio.prox;
                inicio.ant = null;
                nofirst = false;
            }
            
            if(temp.valor == x && nofirst == true){
                temp.ant.prox = temp.prox;
                temp.prox.ant = temp.ant;
            }
            temp = temp.prox;
            first = false;
            nofirst = true;
        }
        
        if(temp.prox == null && temp.valor == x)
            temp.ant.prox = null;
            fim = fim.ant;

    }

}
