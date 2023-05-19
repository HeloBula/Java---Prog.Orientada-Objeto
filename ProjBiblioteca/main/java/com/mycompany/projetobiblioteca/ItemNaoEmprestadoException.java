
package com.mycompany.projetobiblioteca;

/**
 *Classe que herda da classe Exception e será usada caso não conste esse item na lista de empréstimos.
 */
public class ItemNaoEmprestadoException extends Exception {
  /**Usa o construtor da classe Exception, passando a mensagem desejada.
   * @param mensagem String que será impressa no caso de exceções desse tipo  
   */
    public ItemNaoEmprestadoException(String mensagem){
        super(mensagem);
    }
}
