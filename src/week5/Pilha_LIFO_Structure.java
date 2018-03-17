package week5;
public class Pilha_LIFO_Structure{
    
    int[] vet = new int[100];
    int topo = 0;
    
    public void empilhar(int x){
        if(topo == 0){
            vet[topo] = x;
        }else{
        topo++;
        vet[topo] = x;
        }
    }
    
    public void desempilhar(){
        if(topo >= 0){
            topo--;
        }else
            System.out.println("Erro - Não há o que desempilhar");
    }
    
    public int topo(){
        if(topo >= 0){
            return vet[topo];
        }else
            return 0; //se fosse void poderia retornar um texto
    }
    
    public int tamanho(){
        return topo+1;
    }
    
    public boolean vazio(){
        if(topo >= 0){
            return false;
        }else
            return true;
    }
    

    public static void main(String[]args){

        Pilha_LIFO_Structure p = new Pilha_LIFO_Structure();
        
        p.empilhar(5);
        System.out.println("Empilhando valor 5");
        System.out.println("O topo da pilha é o valor: "+p.topo());
        System.out.println("O tamanho da pilha é: "+p.tamanho());
        System.out.println("O Vazio retorna: "+p.vazio());
        p.desempilhar();
        System.out.println("Desempilhando...");
        System.out.println("O topo da pilha é o valor: "+p.topo());
        System.out.println("O tamanho da pilha é "+p.tamanho());
        System.out.println("O Vazio retorna: "+p.vazio());        
    

    }
}
