
package com.mycompany.projetobiblioteca;

/**
 *Classe que herda a classe abstrata Usuario.
 */
public class Professor extends Usuario {
    private String departamento;
    private String titulacao;
    
 /**
  * Construtor do Professor, onde são setados seus atributos.
  * @param nome Parâmetro será salvo como nome do usuário, passado para o construtor de Usuario
  * @param matricula Parâmetro será salvo como matricula do usuário, passado para o construtor de Usuario
  * @param senha Parâmetro será salvo como senha do usuário, passado para o construtor de Usuario
  * @param departamento Parâmetro será salvo como departamento do professor
  * @param titulo Parâmetro será salvo como titulo(mestre,doutor) do professor
  */   
  public Professor(String nome, int matricula,String senha,String departamento, String titulo){
        super(nome,matricula,senha);
        this.departamento = departamento;
        this.titulacao = titulo;
    }  
    
 /**
   * Método sobreescreve o da classe pai, calculando a multa.
   *  O cálculo da multa é realizado considerando
   * uma taxa de 25% à mais do que do aluno que é R$5, portanto 25% * 5 = 1,25
   * Portanto a multa diária é R$6,25.
   */
  @Override
   public double calculaMulta(Emprestimo emprestado) {
        double multa;
        long diasAtraso;
        diasAtraso = emprestado.calculaDias();
        if(diasAtraso > 0){
           multa = diasAtraso * 6.25; 
           return multa;
        }else if(diasAtraso == 0){
            return 0;
        }
        else
            return -1;
    }

    /**
     * Retorna o departamento no qual trabalha.
     * @return O departamento é retornado
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Retorna a titulação do Profesor.
     * @return O titulo do professor é retornado
     */
    public String getTitulacao() {
        return titulacao;
    }

   
}
