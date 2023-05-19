
package com.mycompany.projetobiblioteca;

/**
 *Classe Livro, herda da classe Item.
 */
public class Livro extends Item {
    private String editora;
    private String ISBN;
    
 /**
  * Construtor da classe Livro, usa o construtor da super classe.
  * @param autor String será passada para o construtor da super classe
  * @param titulo String será passada para o construtor da super classe
  * @param publicacao Número será passada para o construtor da super classe
  * @param disponivel Número será passada para o construtor da super classe
  * @param emprestado Número será passada para o construtor da super classe
  * @param editora String será setada como editora do Livro
  * @param ISBN Número individual de cada Livro, sendo setado no campo referente
  */
  public Livro(String autor,String titulo,int publicacao,int disponivel, int emprestado,
  String editora, String ISBN){
    super(autor,titulo,publicacao,disponivel,emprestado);
    this.editora = editora;
    this.ISBN = ISBN;
    }

    /**
     * Retorna a editora do livro.
     * @return A editora do livro é retornada
     */
    public String getEditora() {
        return editora;
    }

    /**
     * Retorna o núemro ISBN do livro.
     * @return O ISBN do livro é retornado
     */
    public String getISBN() {
        return ISBN;
    }

}