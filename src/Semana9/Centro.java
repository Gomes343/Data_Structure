package Semana9;

public class Centro{
    
    static Nodes inicio = null;
    static Nodes fim = null;
    
    public static void main(String[]args){
        

        inserir(5);
        inserir(9);
        inserir(4);
        inserir(2);
        inserir(99);
        inserir(1);
    
        exibir();
        
        System.out.println("====");
        
        centro(inicio,fim);

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

    static void centro(Nodes i, Nodes f){
        if(i.prox == f && f.ant == i){
            System.out.println("NÓ PAR: " + i.valor +" "+f.valor);
        }else{
            if(i.prox == f.ant){
                System.out.println("NÓ IMPAR: "+ i.prox.valor);
            }else{
                centro(i.prox,f.ant);
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
