
package com.mycompany.projetobiblioteca;

/**
 *Classe que herda da classe Exception e será usada caso haja algum erro para cadastrar item
 * ou usuário.
 */
public class CadastroNaoPossivelException extends Exception {
  /**
   * Usa o construtor da classe Exception, passando a mensagem desejada.
   * @param mensagem String que será impressa no caso de exceções desse tipo
   */  
    
    public CadastroNaoPossivelException(String mensagem){
        super(mensagem);
    }
}
