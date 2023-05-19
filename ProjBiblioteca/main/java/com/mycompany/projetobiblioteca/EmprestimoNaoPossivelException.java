
package com.mycompany.projetobiblioteca;

/**
 *Classe que herda da classe Exception e será usada caso haja problemas para emprestar o item.
 */
public class EmprestimoNaoPossivelException extends Exception{
  /**Usa o construtor da classe Exception, passando a mensagem desejada.
   * @param mensagem String que será impressa no caso de exceções desse tipo  
   */
   public EmprestimoNaoPossivelException(String mensagem){ 
        super(mensagem);
    }
}
