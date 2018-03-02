package Week2;

public class Questao6 {


public int MenorValor(int v[],int n){
if(n>=0){

if(v[n] < MenorValor(v,n-1)){

return v[n];

}else{

return MenorValor(v,n-1);

} 
}

//Parte que pode ser excluida se o método for void
if(v[1] < v[0]){
return v[1];
}else{
return v[0];
} //porém, ela trata o fim do critério de parada.


}

public static void main(String[]args){

Questao6 menor = new Questao6();
int v[] = new int[5];
v[0] = 40;
v[1] = 99;
v[2] = 10;
v[3] = 3;
v[4] = 9; 

System.out.println(menor.MenorValor(v, 4));
}
}
//Escreva uma função recursiva que retorne o menor elemento em um vetor