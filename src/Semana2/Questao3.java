package Semana2;

public class Questao3 {
    
    
    public void ExibaCrescente(int n){
        if(n>=0){
            ExibaCrescente(n-1);
            System.out.println(n);
        }
        
    }
    
    public static void main(String[]args){
        
        Questao3 exiba = new Questao3();
        
        exiba.ExibaCrescente(5);
    }
}
//Faça uma função recursiva que receba um número inteiro positivo N e exiba 
//todos os números de 0 até N em ordem crescente.