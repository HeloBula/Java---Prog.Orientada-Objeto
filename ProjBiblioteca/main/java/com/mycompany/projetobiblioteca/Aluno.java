  
package com.mycompany.projetobiblioteca;
/**
 * Classe aluno herda da classe usuário, implementando o método de calcular suas
 * multa.
 */
public class Aluno extends Usuario{
    private String curso;
    private int periodo;
    
    /**
     * Construtor da classe Aluno, usa o construtor da super classe Usuario e seta os
     * atributos especificos.
     * @param nome String que será passada para o cosntrutor da super classe
     * @param matricula Número que será passado para o cosntrutor da super classe
     * @param senha String que será passada para o cosntrutor da super classe
     * @param curso Stirng será amarzenada no atributo curso
     * @param periodo Número será armazenado no campo período do aluno
     */
    public Aluno(String nome, int matricula,String senha,String curso, int periodo){
        super(nome,matricula,senha);
        this.curso = curso;
        this.periodo = periodo;
    }
    
    /**
    * Método que calcula a multa considerando a taxa de R$5 por dia de atraso.
    * @return Valor a ser pago como multa
    * @param emprestado item do qual quero calcular a multa
    */
    @Override
    public double calculaMulta(Emprestimo emprestado) {
        double multa;
        long diasAtraso;
        diasAtraso = emprestado.calculaDias();
        if(diasAtraso > 0){
           multa = diasAtraso * 5; 
           return multa;
        }else if(diasAtraso == 0){//Não ta atrasado
            return 0;
        }
        else
            return -1;
    }

    /**
     * Retorna o curso.
     * @return O curso do aluno é retornado
     */
    public String getCurso() {
        return curso;
    }
    
    /**
     * Retorna o período.
     * @return O período no qual o aluno se encontra é retornado
     */
    public int getPeriodo() {
        return periodo;
    }
}
    
