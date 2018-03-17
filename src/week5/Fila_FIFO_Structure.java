package week5;
public class Fila_FIFO_Structure {
    
    int n = 5;
    int[] vet = new int[n];
    int rabo = 0;
    int cabeca = 0;
    boolean b = true;
    

    public void enfileirar(int x){
        if(this.cheio() == true){
            System.out.println("A FILA ESTÁ CHEIA!");
        }else{
            if(rabo == (n-1)){
                rabo = 0;
                vet[rabo] = x;
            }else{
                if(b == true){
                vet[rabo] = x;
                b = false;
                }else{
                    rabo = rabo+1;
                    vet[rabo] = x;
                }
            }
        }
    }
    
    public void desenfileirar(){
        if(cabeca == -1 || rabo == -1){ //tratamento da exceção
            System.out.println("ERRO - Não há mais oque desenfileirar");
        }
        cabeca++;
    }

    public int cabeca(){
        return vet[cabeca];
    }
    
    public int rabo(){
       return vet[rabo]; 
    }

    public int tamanho(){
        if(cabeca > rabo){
            int a = (n - cabeca) + 1;
            int b = rabo;
            return a+b;
        }else{
            return (rabo - cabeca) + 1;
        }
    }

    public boolean cheio(){
        if(this.tamanho() == n){
            return true;
        }
        return false;
    }

    public boolean vazio(){
        if(cabeca == -1 || rabo == -1){
            return true;
        }else{
            return false;
        }
    }
    
    public void exibidor(){
        System.out.println("INICIANDO A FILA!");
        System.out.println(vet[0]+" "+vet[1]+" "+vet[2]+" "+vet[3]+" "+vet[4]);    
        System.out.println(" ----- ");
        System.out.println("a Cabeça é: "+this.cabeca());
        System.out.println("o rabo é: "+this.rabo());
        System.out.println("o tamanho é: "+this.tamanho());
        
        
    }
    
    public static void main(String[]args){

        Fila_FIFO_Structure f = new Fila_FIFO_Structure();
        
  
        f.enfileirar(10);
        f.enfileirar(6);
        f.enfileirar(12);
        f.exibidor();

        System.out.println(" \n ");
        System.out.println("MUDANDO CENÁRIO!");
        System.out.println(" \n ");
        System.out.println("Adicionando 78 e desenfileirando 2 vezes");
        f.enfileirar(78);
        f.desenfileirar();
        f.desenfileirar();
        f.exibidor();
        
        System.out.println(" \n ");
        System.out.println("MUDANDO CENÁRIO!");
        System.out.println(" \n ");
        System.out.println("Adicionando 98 e 54 e desenfileirando 1 vez");
        f.enfileirar(98);
        f.enfileirar(54);
        f.desenfileirar();
        f.exibidor();
        
        
        System.out.println(" \n ");
        System.out.println("MUDANDO CENÁRIO!");
        System.out.println(" \n ");
        System.out.println("Adicionando 2 e 4 ");
        f.enfileirar(2);
        f.enfileirar(4);
        f.exibidor();
        
        
        System.out.println(" \n ");
        System.out.println("MUDANDO CENÁRIO!");
        System.out.println(" \n ");
        System.out.println("TENTANDO ADICIONAR 999 MESMO ESTANDO CHEIO!");
        f.enfileirar(999);
        f.exibidor();
        System.out.println("nada mudou!");
        
    }
}