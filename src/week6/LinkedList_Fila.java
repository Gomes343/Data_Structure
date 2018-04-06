package week6;

import java.util.Scanner;

public class LinkedList_Fila{
    
    static int n = 5;
    static Nodes inicio = null;
    static Nodes c = null;
    static Nodes r = null;
    static boolean comecar = false;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("informe o tamanho da fila");
        System.out.println("5");
        n = 5; // ou sc.nextInt();
        exibir(c);
        enfileirar(5);
        enfileirar(667);
        enfileirar(3);
        enfileirar(6);
        enfileirar(88);
        enfileirar(0); //a mais
        enfileirar(2); //a mais
        System.out.println("tamanho da fila:"+tamanho(c));
        
        System.out.println("\n"+"\n"+"\n"+"\n");
        System.out.println("MOSTRANDO AS POSIÇÕES...");
        System.out.println("LUGAR DO CABEÇA: "+c);
        System.out.println("VALOR DO CABEÇA: "+c.valor);
        System.out.println("PRA QUEM O CABEÇA APONTA: "+c.prox);

        System.out.println("LUGAR DO RABO: "+r);
        System.out.println("VALOR DO RABO: "+r.valor);
        System.out.println("PRA QUEM O RABO APONTA: "+r.prox);
        
        System.out.println("desenfileirando tudo");
        System.out.println("==");
        desenfileirar();
        desenfileirar();
        desenfileirar();
        desenfileirar();
        desenfileirar();
        System.out.println("==");
        exibir(c);
        System.out.println("\n"+"\n");
        System.out.println("enfileirando valores novamente");
        enfileirar(6);
        enfileirar(5);
        enfileirar(4);
        enfileirar(1);
        exibir(c);
    }

    static void enfileirar(int x){
        
        Nodes novo = new Nodes(x);
        Nodes temp = inicio;

        if(tamanho(c) == n){
            System.out.println("impossível enfileirar, no limite da Fila.");
        }else{
        if(comecar == false){
            //inicio = novo;
            c = novo;
            r = novo;
            comecar = true;
        }else{
            temp = c;
            while (temp.prox != null){
                temp = temp.prox;
            }
            r = novo;
            temp.prox = novo;    
        }
        }
    }

    static void desenfileirar(){
        if(c.prox == null){
            comecar = false;
            c = null;
            r = null;
        }else{
            c = c.prox;
        }
    }
    
    static int cabeca(){
        if(comecar == true){
        return c.valor;
        }else{
            return 0;
        }
    }
    
    static int rabo(){
        if(comecar == true){
            return r.valor;
        }else{
            return 0;
        }
    }
    
    static int tamanho(Nodes temp) {
        if (temp != null){
            return 1 + tamanho(temp.prox);
        }
        
        return 0;
    }
    
    static void cheio(Nodes temp){
        if(tamanho(temp) == n){
            System.out.println("a Fila Está Cheia");
        }else{
            System.out.println("Não está Cheio");
        }
    }
    
    static void vazio(Nodes temp){
        if(temp == null){
            System.out.println("a Fila Está Vazia");
        }else{
            System.out.println("Não está Vazia");
        }
    }
    
    static void exibir(Nodes temp){
        if (comecar == false) 
            System.out.println("Fila Vazia ou não Iniciada, nada a exibir");
        else 
            if (temp != null) {
                System.out.println(temp.valor);
                exibir(temp.prox);
            }
    }

}
