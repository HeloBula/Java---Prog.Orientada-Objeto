/**
 * Pacotes e imports necessários para manusear Tempo
 */
package com.mycompany.projetobiblioteca;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *Classe que será instanciada a cada objeto emprestado. As variáveis que são datas
 * coloquei em LocalDate para facilitar a manipulação.
 */
public class Emprestimo {
    private Item item;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    
    /**
     * Construtor da classe empréstimo
     * @param item Item recebido para fazer o empréstimo
     */
    public Emprestimo(Item item){
        dataEmprestimo = LocalDate.now();
        dataDevolucaoPrevista = dataEmprestimo.plusDays(10);
        this.item = item;
    }
    
    /**
     * Método que calcula os dias de atraso para serem usados no calculo da multa
     * por atraso
     * @return O número de dias é retornado
     */
    public long calculaDias(){
        long diasAtraso;
        if (getDataDevolucaoReal()!= null && getDataDevolucaoPrevista()!= null) {
           diasAtraso = ChronoUnit.DAYS.between(getDataDevolucaoPrevista(),getDataDevolucaoReal());
               if(diasAtraso > 0) 
                   return diasAtraso;
               else
                   return 0;
        }else
            System.out.println("Preencha as datas corretamente!");
                return -1;
    }
    
    /**
     * Retorna o item ao qual esse empréstimo se refere
     * @return O item é retornado
     */
    public Item getItem() {
        return item;
    }
    
    /**
     * Retorna a data na qual foi realizado o empréstimo
     * @return A data de empréstimo é retornada
     */
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * Retorna a data que deverá ser devolvido o item emprestado
     * @return A data de devolução calculada é retornada
     */
    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    /**
     * Retorna a data em que o usuário devolveu o item
     * @return A data de devolução real é retornada
     */
    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    /**
     * A data de devolução real é atualizada quando o usuário devolve o item
     * @param dataDevolucaoReal data na qual o usuário devolveu o item
     */
    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }
    
}
