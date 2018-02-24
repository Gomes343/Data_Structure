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

