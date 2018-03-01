package Week2;

public class Questao5 {
    
    
    public int SomaVet(int v[],int n){
        if(n>=0){
            return (v[n]+SomaVet(v,n-1));
        }
        return 0;        
    }
    
    public static void main(String[]args){
        
        Questao5 vet = new Questao5();
        int v[] = new int[5];
        v[0] = 4;
        v[1] = 3;
        v[2] = 2;
        v[3] = 9;
        v[4] = 5;
               
        
        
        System.out.println(vet.SomaVet(v, 4));

    }
}
//Crie uma função recursiva que retorne a soma dos elementos de um vetor 
//de N inteiros 