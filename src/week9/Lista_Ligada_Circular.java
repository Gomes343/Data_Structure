package week9;

public class Lista_Ligada_Circular{
    
    static Nodes inicio = null;
    static Nodes fim = null;
    
    public static void main(String[]args){
        

        inserir(5);
        inserir(9);
        inserir(4);
        inserir(2);
        inserir(1);
        
        System.out.println("oi");     
        System.out.println(inicio);
        System.out.println(fim.prox);
        System.out.println(fim);
        System.out.println(inicio.ant);
    
       
        tamanho();
        removeValor(9);
        
        exibir();
        
        
        

    }
    
    
    static void inserir(int x) {
        Nodes novo = new Nodes(x);
        if (inicio == null){
            inicio = novo;
            fim = inicio;
            novo.prox = inicio;
            novo.ant = inicio;
        } else {
            Nodes temp = fim;
            temp.prox = novo;
            novo.ant = temp;
            fim = novo;
            inicio.ant = fim;
            fim.prox = inicio;
        }
    }

    static void removeValor(int x){
        if(inicio == null)
            System.out.println("Lista Vazia!");
        else{
            Nodes temp = inicio;
            while(temp.prox != inicio){
                if(temp.valor == x){
                    temp.prox.ant = temp.ant;
                    temp.ant.prox = temp.prox;
                    if(temp == inicio)
                        inicio = temp.prox;
                }
            temp = temp.prox;
            }
        }
    }
    
    static void exibir() {
        Nodes temp = inicio;
        if (inicio == null) 
            System.out.println("Lista Vazia, nada a exibir");
        else{ 
            for(int i = 0 ; i < tamanho() ; i++){
                System.out.println(temp.valor);
                temp = temp.prox;
            }
        }
    }

    static int tamanho(){
        Nodes temp = inicio;
        int cont = 1;
        if(inicio == null){
            return 0;
        }else{
            while(temp != fim){
                cont++;
                temp = temp.prox;
            }
        }
        return cont;
    }
}
