public class Questao1 {
    
    
    public int Soma(int n){
        
        if(n>1){
            return (n+Soma(n-1));
        }
        return 1;
        
    }
    
    public static void main(String[]args){
        
        Questao1 soma = new Questao1();
        System.out.println(soma.Soma(6));
        
    }
}
