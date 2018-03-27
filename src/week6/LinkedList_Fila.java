package week6;
public class LinkedList_Fila{
    
    static int n = 5;
    static Nodes inicio = null;
    static Nodes c = null;
    static Nodes r = null;
    static boolean comecar = false;
    
    public static void main(String[] args) {

        exibir(c);
        enfileirar(5);
        enfileirar(667);
        enfileirar(3);
        
        System.out.println("LUGAR DO CABEÇA: "+c);
        System.out.println("VALOR DO CABEÇA: "+c.valor);
        System.out.println("PRA QUEM O CABEÇA APONTA: "+c.prox);

        
        System.out.println("LUGAR DO RABO: "+r);
        System.out.println("VALOR DO RABO: "+r.valor);
        System.out.println("PRA QUEM O RABO APONTA: "+r.prox);
        
        
        exibir(c);
        System.out.println("==");
        desenfileirar();
        System.out.println("==");
        exibir(c);
        
    }

    static void enfileirar(int x){
        
        Nodes novo = new Nodes(x);
        Nodes temp = inicio;

        
        if(comecar == false){
            //inicio = novo;
            c = novo;
            r = novo;
            comecar = true;
        }else{
            temp = c;
            while (temp.prox != null){
                temp = temp.prox;
            }
            r = novo;
            temp.prox = novo;    
        }
    }

    static void desenfileirar(){
        if(c.prox == null){
            comecar = false;
            c = null;
            r = null;
        }else{
            c = c.prox;
        }
    }
    
    static int cabeca(){
        if(comecar == true){
        return c.valor;
        }else{
            return 0;
        }
    }
    
    static int rabo(){
        if(comecar == true){
            return r.valor;
        }else{
            return 0;
        }
    }
    
    static void tamanho(Nodes temp) {

    }
    
    static void cheio(){
        
    }
    
    static void vazio(){
        
    }
    
    static void exibir(Nodes temp){
        if (comecar == false) 
            System.out.println("Fila Vazia ou não Iniciada, nada a exibir");
        else 
            if (temp != null) {
                System.out.println(temp.valor);
                exibir(temp.prox);
            }
    }


}
