package Week2;

public class Questao4 {
    
    
    public void ExibaDecrescente(int n){
        if(n>=0){
            System.out.println(n);
            ExibaDecrescente(n-1);
        }
        
    }
    
    public static void main(String[]args){
        
        Questao4 exiba = new Questao4();
        
        exiba.ExibaDecrescente(5);
        
        
    }
}

//Faça uma função recursiva que receba um número inteiro positivo N e exiba
//todos os números de N até 0 em ordem decrescente.

