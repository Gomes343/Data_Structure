package Week2;

public class Questao6 {


    public int MenorValor(int v[],int n){
    if(n>0){
        int x = MenorValor(v,n-1);
        if(x < v[n]){
        return x;
        }

        return v[n];

        }
    return v[n];
    }



    public static void main(String[]args){

    Questao6 menor = new Questao6();
    int v[] = new int[5];
    v[0] = 40;
    v[1] = 99;
    v[2] = 1;
    v[3] = 3;
    v[4] = 9; 
    
    System.out.println(menor.MenorValor(v, 4));
    }
}
//Escreva uma função recursiva que retorne o menor elemento em um vetor