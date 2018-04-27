package week8;

public class Começo_e_Fim {
    
    static Nodes inicio = null;
    static Nodes fim = null;
    static Nodes inicio2 = null;
    static Nodes fim2 = null;
    
    public static void main(String[]args){

    inserir(5);
    inserir(9);
    inserir(2);
    inserir(7); 
    inserir(1);
    inserir(4);
    inserir(0);
    inserir(6);
    inserir(8);
    
    
    exibir_começofim(inicio,fim);
    
    }
    
    static void exibir_começofim(Nodes i, Nodes f){
        if(i != f){
            System.out.println(i.valor+" "+f.valor);
            exibir_começofim(i.prox, f.ant);
        }else{
            System.out.println(i.valor);
        }
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
    
}
