package Semana3;

public class Sort{

    public static void main(String[] args) {

        int N = 10000;
        
        int vet1[] = new int[N];
        int vet2[];
        int vet3[];


        for(int i=0; i<N; i++)
            vet1[i] = ((int) (Math.random()*N*N))+1;


        vet2 = vet1.clone();
        
        vet3 = vet1.clone();
        
        

        long inicio = System.currentTimeMillis();
        bubble_ruim(vet1,N);
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        System.out.println("Tempo Bubble Ruim: "+tempo);
        
        
        
        inicio = System.currentTimeMillis();
        bubble_bom(vet2,N);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Tempo Bubble BOM: "+tempo);

        
        
        inicio = System.currentTimeMillis();
        selection(vet3,N);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("Tempo Selection: "+tempo);
        
       //exibir(vet2);
       

        
        
    }
    
    
  
    
    static void bubble_ruim(int vet[], int N){
        for(int i=0; i<N; i++){
            for(int j=0; j<(N-1); j++){
                if(vet[j]>vet[j+1]){
                   troca(vet,j,j+1);
                }
            }
        }
    }
    
    
    static void bubble_bom(int vet[], int N){
       // implemente
       boolean t = true;
       int i = N-1;
       while(t){
           
           t=false;
           
           for(int j = 0 ; j<i ; j++){
               if(vet[j]>vet[j+1]){
                   troca(vet,j,j+1);
                   t=true;
               }               
           }
           i--;
       }
       
       
    }

  
    static void troca(int vet[],int i, int j){
        int aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
    }
    
    static void exibir(int v[]){
                
        for(int i = 0 ; i < v.length ; i++){
            System.out.println(v[i]);
        }
        
    }
    
    static void selection(int[] vet, int N) {
        for (int fixo = 0; fixo < (N - 1); fixo++) {
            int menor = fixo;
            for (int i = menor + 1; i < N; i++) {
                if (vet[i] < vet[menor]) {
                    menor = i;
                }
            }
            if (menor != fixo) {
                int t = vet[fixo];
                vet[fixo] = vet[menor];
                vet[menor] = t;
            }
        }
    }
    
}