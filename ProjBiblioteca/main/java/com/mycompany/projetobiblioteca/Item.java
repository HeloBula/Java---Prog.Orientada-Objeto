
package com.mycompany.projetobiblioteca;

/**
 *Classe abstrata que implementa a interface emprestavel e será herdada pelos demais
 *itens.
 */
public abstract class Item implements Emprestavel{
    private String autor;
    private String titulo;
    private int anoPublicado;
    private int quantDisponivel;
    private int quantEmprestada;
    
    /**
     * Construtor dos itens, será usada junto com os demais construtores das classes
     * que a herdam.
     * @param autor  Parâmetro será salvo como autor do item
     * @param titulo Parâmetro será salvo como título do item
     * @param publicacao Parâmetro será salvo como data de publicação do item
     * @param disponivel Parâmetro será salvo como quantidade disponível do item
     * @param emprestado Parâmetro será salvo como quantidade emprestada do item
     */
    public Item(String autor,String titulo,int publicacao,int disponivel, int emprestado){
        this.autor = autor;
        this.titulo = titulo;
        anoPublicado = publicacao;
        quantDisponivel = disponivel;
        quantEmprestada = emprestado;
    }
    
    
   /**
    * Método controla as quantidades de empréstimo de cada item.
    */
    @Override
    public void Emprestar(){
        quantDisponivel--;
        quantEmprestada++;
    }
   
    /**
     * Método que controla as devoluções de cada item.
     */
    @Override
    public void Devolucao(){
        quantEmprestada--;
        quantDisponivel++;
    }

    /**
     * Retorna o titulo do Item.
     * @return O titulo do item é retornado
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Retorna o autor do Item.
     * @return O autor do item é retornado
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Retorna o ano de publicação do Item.
     * @return O ano que o item foi publicado é retornado
     */
    public int getAnoPublicado() {
        return anoPublicado;
    }

    /** 
     * Retorna a quantidade disponível desse item na biblioteca.
     * @return Quantidade disponivel do item é retornada
     */
    public int getQuantDisponivel() {
        return quantDisponivel;
    }

    /**
     * Retorna a quantidade desse item que já foi emprestada.
     * @return Quantidade já emprestada do item é retornada
     */
    public int getQuantEmprestada() {
        return quantEmprestada;
    }
}
