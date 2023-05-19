
package com.mycompany.projetobiblioteca;

/**
 * Classe Revista,herda da classe Item.
 */
public class Revista extends Item {
    private int volume;
    private int numero;
    
 /**
  * Construtor da classe Revista, usa o construtor da super classe.
  * @param autor String será passada para o construtor da super classe
  * @param titulo String será passada para o construtor da super classe
  * @param publicacao Número será passada para o construtor da super classe
  * @param disponivel Número será passada para o construtor da super classe
  * @param emprestado Número será passada para o construtor da super classe
  * @param volume Número será setado no campo volume
  * @param numero Número será setado no campo numero
  */
   public Revista(String autor,String titulo,int publicacao,int disponivel, int emprestado,
  int volume, int numero){
    super(autor,titulo,publicacao,disponivel,emprestado);
    this.volume = volume;
    this.numero = numero;  
   } 

    /**
     * O volume da Revista é retornado.
     * @return O volume é retornado
     */
    public int getVolume() {
        return volume;
    }

    /**
     * O número da Revista é retornado.
     * @return O número é retornado
     */
    public int getNumero() {
        return numero;
    }
}
