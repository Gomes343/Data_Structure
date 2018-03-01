package Week2;

public class Questao2 {
    
    
    public int Pot(int x,int n){
        
        if(n>=1){
            return (x*Pot(x,n-1));
        }
        
        return 1;
    }
    
    public static void main(String[]args){
        
        Questao2 pot = new Questao2();
        System.out.println(pot.Pot(7, 4));
        
    }
}
//Implemente, de forma recursiva, uma função int pot(int x, int n) que, dados
//dois números inteiros x e n, calcula o valor de x^n