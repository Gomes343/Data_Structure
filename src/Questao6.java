public class Questao6 {
    
    
    public int MenorValor(int v[],int n){
        if(n>1){
            if(v[n]<v[n-1]){
                MenorValor(v,n-1);
            }else{
                if()
            }
            
        }
        return menor;        
    }
    
    public static void main(String[]args){
        
        Questao6 menor = new Questao6();
        int v[] = new int[5];
        v[0] = 4;
        v[1] = 3;
        v[2] = 2;
        v[3] = 9;
        v[4] = 5;   
        
        System.out.println(menor.MenorValor(v, 4));
    }
}
