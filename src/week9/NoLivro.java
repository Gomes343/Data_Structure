/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9;

public class NoLivro {
    
    String autor, titulo, edicao, local, editora;
    int ano;
    NoLivro prox, ant;

    public NoLivro(String autor, String titulo, String edicao, String local, String editora, int ano) {
        this.autor = autor;
        this.titulo = titulo;
        this.edicao = edicao;
        this.local = local;
        this.editora = editora;
        this.ano = ano;
        this.prox = null;
        this.ant = null;
    }
    
}
