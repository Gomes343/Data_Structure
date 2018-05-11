package week10;

public class ArvoreB {

    static NoA raiz = null;
    static boolean b = false;
    public static void main(String[] args) {
        
        //https://www.devmedia.com.br/trabalhando-com-arvores-binarias-em-java/25749
        
        
        insereIterativo(8);
        insereIterativo(3);
        insereIterativo(1);
        insereIterativo(6);
        insereIterativo(4);
        insereIterativo(7);
        insereIterativo(10);
        insereIterativo(14);
        insereIterativo(13);
        
        //PreExibe(raiz);
        //ExibeOrdenado(raiz);
        //ExibeInverso(raiz);
        Exibe1Filho(raiz);
        
        
    }
    
    public static void insereIterativo(int v){
        NoA novo = new NoA(v);
        
        if(raiz == null){
            raiz = novo;
        }else{
            boolean inseriu = false;
            NoA temp = raiz;
            
            while(!inseriu){
                if(novo.valor <= temp.valor){
                    if(temp.esq == null){
                        temp.esq = novo;
                        inseriu = true;
                    }else{
                        temp = temp.esq;
                    }
                }else{
                    if(temp.dir == null){
                        temp.dir = novo;
                        inseriu = true;
                    }else{
                        temp = temp.dir;
                    }
                    
                }
            }
        }
    }
    
    public static void PreExibe(NoA temp){
        if(temp != null){
            System.out.println(temp.valor);
            PreExibe(temp.esq);
            PreExibe(temp.dir);
        }
    }
    
    public static void ExibeOrdenado(NoA temp){
        if(temp != null){
        ExibeOrdenado(temp.esq);
        System.out.println(temp.valor);
        ExibeOrdenado(temp.dir);
        }
    }

    public static void ExibeInverso(NoA temp){
        if(temp != null){
            ExibeInverso(temp.dir);
            System.out.println(temp.valor);
            ExibeInverso(temp.esq);
        }
    }
    
    public static void Exibe1Filho(NoA temp){
        if(temp != null){
            ExibeOrdenado(temp.esq);
            if(temp.dir == null || temp.esq == null){
                System.out.println(temp.valor);                
            }
            ExibeOrdenado(temp.dir);
        }
    }
}
