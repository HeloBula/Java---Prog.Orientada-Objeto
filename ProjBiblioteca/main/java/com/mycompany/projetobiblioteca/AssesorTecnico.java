
package com.mycompany.projetobiblioteca;

/**
 *Classe herda da classe usuário, possui a implementação do método para calcular
 * a multa.
 */
public class AssesorTecnico extends Usuario {
    private String secao;

   /**
    * Construtor da classe Assesor, usa o construtor da super classe e seta os demais atributos.
    * @param nome String que será passada para o cosntrutor da super classe
    * @param matricula Número que será passado para o cosntrutor da super classe
    * @param secao String que será setada no atributo seção do assesor, ou seja, seçã em que trabalha
    * @param senha String que será passada para o cosntrutor da super classe
    */ 
    public AssesorTecnico(String nome, int matricula,String secao,String senha){
        super(nome,matricula,senha);
        this.secao = secao;
    }
    
    /**
     * Método que calcula o valor da multa. A taxa será uma 15% superior ao do Aluno,
     * ou seja, 15%*5 = 0,75 reais. Portanto multa será de R$5,75.
     */
    @Override
     public double calculaMulta(Emprestimo emprestado) {
        double multa;
        long diasAtraso;
        diasAtraso = emprestado.calculaDias();
        if(diasAtraso > 0){
           multa = diasAtraso * 5.75; 
           return multa;
        }else if(diasAtraso == 0){
            return 0;
        }
        else
            return -1;
    }

    /**
     * Retorna a seção na que usuário trabalha.
     * @return A seção é retornada
     */
    public String getSecao() {
        return secao;
    }
}
