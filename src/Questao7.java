public class Questao7 {
    
    
    public String Dec2Bin(int n){
        
        if(n>0){
        int c = n%2;
        String f = Integer.toString(c);
        return f.concat(Dec2Bin(n/2));
        
        }
        String f = "Sre";
        return f;
    }
    
    public static void main(String[]args){
        
        Questao7 binario = new Questao7();
        
        binario.Dec2Bin(12);
        
        
        
    }
}
