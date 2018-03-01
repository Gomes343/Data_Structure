package Week2;

public class Questao6 {
    
    
    public int MenorValor(int v[],int n,int m){
        if(n>2){
            if(m<MenorValor(v,n-1,m)){
                return m;
            }else{
                return MenorValor(v,n-1,m);
            }
        }    
        return v[2];
    }
    
    public static void main(String[]args){
        
        Questao6 menor = new Questao6();
        int v[] = new int[5];
        v[0] = 4;
        v[1] = 3;
        v[2] = 2;
        v[3] = 9;
        v[4] = 5;   
        int m = v[4];
        
        System.out.println(menor.MenorValor(v, 4, m));
    }
}
//Escreva uma função recursiva que retorne o menor elemento em um vetor