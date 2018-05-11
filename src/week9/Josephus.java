package week9;

import java.util.Scanner;

public class Josephus{
    
    static Nodes inicio = null;
    static Nodes fim = null;
    static int n = 0;
    static int salto = 1;
    
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Insira o número de elementos da lista: ");
        n = sc.nextInt();
        
        System.out.println("Insira o número de saltos da morte: ");
        salto = sc.nextInt();
        
        gerarValores();
        System.out.println("===");
        exibir();
        System.out.println("===");
        rodarJosephus();
        
        
    }
    
    static void rodarJosephus(){
        int cont = 0;
        Nodes temp = inicio;
        
        
        //EXIBINDO OS VALORES SEM ALTERAÇÃO
        for(int i = 0 ; i < n ; i++){
            System.out.print(temp.valor+" ");
            temp = temp.prox;
        }
        System.out.printf("\n");
        temp = inicio;
        
        
        //INICIO DO SALTO DA MORTE
        while(inicio.prox != fim || inicio != fim){
            
        System.out.print(temp.valor+" ");

            
            if(cont == salto-1){
                removePos(temp.prox);
                cont = 0;
            }else{
            cont++;
            }
            
            if(temp == fim)
                System.out.printf("\n");
            
        temp = temp.prox;
        }

    }
    
    static void gerarValores(){
        for(int i = 0 ; i < n ; i++){
            Nodes novo = new Nodes(i);
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
    }

    static void removePos(Nodes i){
        if(i == inicio){
            inicio = i.prox;
            inicio.ant = i.ant;

        }
        
        if(i == fim){
            fim = i.ant;
            fim.prox = i.prox;

        }
        
        if( i != inicio && i != fim){
        i.prox.ant = i.ant;
        i.ant.prox = i.prox;
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
