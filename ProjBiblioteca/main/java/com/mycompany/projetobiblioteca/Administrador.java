
package com.mycompany.projetobiblioteca;

/**
 *Classe Administrador, cujo terá um único objeto, sendo o primeiro usuário lido.
 */
public class Administrador {
    private String nome;
    private String senha;
    
   /**
    * Construtor da classe Administrador.
    * @param nome string que será salva como nome de usuário
    * @param senha string será usada para acessar esse cadastro
    */ 
    public Administrador(String nome,String senha){
        this.nome = nome;
        this.senha = senha;
    }
    
    /**
     * Retorna o nome do administrador.
     * @return O nome do administrador é retornado
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna a senha do administrador cadastrado.
     * @return A senha do administrador é retornada
     */
    public String getSenha() {
        return senha;
    }

}
