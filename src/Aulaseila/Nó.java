package Aulaseila;

public class Nó {
    int valor;
    Nó dir;
    Nó esq;
    
    Nó(int v){
        this.valor = v;
        this.dir = null;
        this.esq = null;
    }
    
}