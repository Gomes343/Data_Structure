/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9;

/**
 *
 * @author cg080111
 */
import java.util.Scanner;

public class Livros {

        static NoLivro inicio = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        cadastrarLivro("LORENZI, F.; MATTOS, P. N.; CARVALHO, T. P."," Estruturas de dados","1ª edição","São Paulo","Thomson Learning",2007);
        cadastrarLivro("PEREIRA, S. L.","Estrutura de dados fundamentais: conceitos e aplicações","12ª edição","São Paulo","Érica",2008);
        cadastrarLivro("LAFORE, R.","Estrutura de dados & algoritmos em java","1ª edição","Rio de Janeiro","Ciência Moderna",2004);
        cadastrarLivro("SZWARCFITER, J. L.; MARKENZON, L.","Estruturas de dados e seus algoritmos","3ª edição","Rio de Janeiro","LTC",2010);
        cadastrarLivro("PREISS, B. R.","Estruturas de dados e algoritmos: pradrões de projetos orientados a objeto com java","1ª edição","Rio de Janeiro","Elsevier",2000);
        cadastrarLivro("WIRTH, N.","Algoritmos e estruturas de dados","1ª edição","Rio de Janeiro","LTC",2008);
        cadastrarLivro("CELES, W. ; CERQUEIRA, R.; RANGEL, J. L.","Introdução a estruturas de dados com técnicas de programação em C","1ª edição","Rio de Janeiro","Elsevier",2004);
        cadastrarLivro("GUIMARÃES, Â. M.; LAGES, N. A. C.","Algoritmos e estruturas de dados","1ª edição","Rio de Janeiro","LTC",2008);
        
        
        Scanner teclado = new Scanner(System.in);
        
        String opcao;
        NoLivro temp = inicio;
        System.out.println("\n\n\n\n\n\n\nLIVRO ATUAL");
        simples(temp);
        System.out.println("\n\n\n");
        do{
            System.out.print("\nINFORME A OPÇÃO DESEJADA\n"
                    + "\"a\" para avançar\n"
                    + "\"r\" para retroceder\n"
                    + "\"d\" para detalhar\n"
                    + "\"s\" para sair\n"
                    + "ESCOLHA:");
            
            opcao = teclado.nextLine();
            
            if(opcao.equals("a")){
                System.out.println("\n\n\n\n\n\n\nLIVRO ATUAL");
                temp = temp.prox;
                simples(temp);
                System.out.println("\n\n\n");
            }else if(opcao.equals("r")){
                System.out.println("\n\n\n\n\n\n\nLIVRO ATUAL");
                temp = temp.ant;
                simples(temp);
                System.out.println("\n\n\n");
            }else if(opcao.equals("d")){
                System.out.println("\n\n\n\n\n\n\nLIVRO ATUAL DETALHADO");
                detalhado(temp);
            }else if(!opcao.equals("s"))
                System.out.println("\n\n\n\n\n\n\n\n");
            
            
            
        }while(!opcao.equals("s"));
        
        
    }
    
    
    public static void simples(NoLivro t){
        System.out.println("Autor: "+t.autor);
        System.out.println("Título: "+t.titulo);
        System.out.println("");
    }
    
    public static void detalhado(NoLivro t){
        System.out.println("Autor: "+t.autor);
        System.out.println("Titulo: "+t.titulo);
        System.out.println("Edição: "+t.edicao);
        System.out.println("Local: "+t.local);
        System.out.println("Editora: "+t.editora);
        System.out.println("Ano: "+t.ano);
        System.out.println("");
    }

    
    public static void cadastrarLivro(String autor, String titulo, String edicao, String local, String editora, int ano){
        NoLivro novo = new NoLivro(autor, titulo, edicao, local, editora, ano);
        if(inicio == null){
            inicio = novo;
            inicio.prox = inicio;
            inicio.ant = inicio;
        }else{
            novo.prox = inicio;
            novo.ant = inicio.ant;
            inicio.ant.prox = novo;
            inicio.ant = novo;
        }
        
    }

        
    
}
