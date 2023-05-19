
package com.mycompany.projetobiblioteca;

/**
* Classe CD, herda da classe Item.
*/
public class CD extends Item {
    private int volume;
    private String gravadora;
    
  /**
  * Construtor da classe CD, usa o construtor da super classe.
  * @param autor String será passada para o construtor da super classe
  * @param titulo String será passada para o construtor da super classe
  * @param publicacao Número será passada para o construtor da super classe
  * @param disponivel Número será passada para o construtor da super classe
  * @param emprestado Número será passada para o construtor da super classe
  * @param volume Número será setado no campo volume
  * @param gravadora String será setado no campo gravadora
  */ 
  public CD(String autor,String titulo,int publicacao,int disponivel, int emprestado,
  int volume, String gravadora){
    super(autor,titulo,publicacao,disponivel,emprestado);
    this.volume = volume;
    this.gravadora = gravadora;
    }

    /**
     * Retorna o númerod do volume do CD.
     * @return O volume do CD é retornado
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Retorna a gravadora do CD.
     * @return A gravadora do CD é retornada
     */
    public String getGravadora() {
        return gravadora;
    }
   
}