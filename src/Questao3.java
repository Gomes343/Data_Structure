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
