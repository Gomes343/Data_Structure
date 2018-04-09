package week8;

import java.util.Scanner;

public class Primos {
    
    static Nodes inicio = null;
    static Nodes fim = null;
    static int n = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira a quantidades de valores que deverá ser analisado");
        n = sc.nextInt();
        
        System.out.println("Gerando valores");
        gerarValores();

        encontrarPrimos();
        
        exibir(inicio);

    }
    

    static void gerarValores(){

        for(int i = 0 ; i < n ; i++){
            Nodes novo = new Nodes(i);
            if(inicio == null){
                inicio = novo;
            }else{
                Nodes temp = inicio;
                while(temp.prox != null){
                    temp = temp.prox;
                }
                temp.prox = novo;
                novo.ant = temp;
            }
        }
        
    }

    static void encontrarPrimos() {
        Nodes temp = inicio;
        Nodes temp2 = temp.prox;



        while(temp.prox != null){
        if((temp.valor == 0)||(temp.valor == 1)){
            inicio = temp.prox;
            temp2 = temp.prox;
            temp = temp.prox;
        }else{
            temp2 = temp.prox;
            while(temp2 != null){
                System.out.println("a comparação "+temp2.valor+" % "+temp.valor);
                
                if((temp2.prox == null) && (temp2.valor % temp.valor == 0)){
                    temp2.ant.prox = null;
                }
                if(temp2.valor % temp.valor == 0 && temp2.prox != null){
                    temp2.ant.prox = temp2.prox;
                    temp2.prox.ant = temp2.ant;
                }
                temp2 = temp2.prox;
            }
            temp = temp.prox;
        }
    }
        
        
    }

    static void remove(Nodes temp){
        temp.ant.prox = temp.prox;
        temp.prox.ant = temp.ant;
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
        return n;
    }
}
