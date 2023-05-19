
package com.mycompany.projetobiblioteca;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Classe abstrata que servirá como classe base dos usuários que usam a biblioteca.
 * Colocamos o método abstrato para calcular a multa que terá de ser implementada em cada classe
 * que a herdar.
 */
public abstract class Usuario {
    private String nome;
    private int matricula;
    private String senha;
    protected ArrayList<Emprestimo> itensEmprestados = new ArrayList<>();
    
    /**Construtor da classe pai que será herdado pelas classes filhos.
     * 
     * @param nome parâmetro será setado como nome do usuário
     * @param matricula parâmetro será setado como matricula do usuário
     * @param senha string que será salva como senha da conta
     */
    
    public Usuario(String nome, int matricula, String senha){
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
    }
    /**
     * Método abstrato que será implementado nas classes que herdarem.
     * @param emprestado Item emprestado do qual se quer calcular a multa
     * @return O valor a ser pago é retornado
     */
    protected abstract double calculaMulta(Emprestimo emprestado);
    
    /**
     * Método que adiciona um novo empréstimo à lista de empréstimos, se houver itens disponiveis.
     * @param itemDesejado O item que será colocado nos empréstimos
     * @throws EmprestimoNaoPossivelException é lançada caso tente emprestar um item que não está disponivel
     */
    public void Emprestar(Item itemDesejado) throws EmprestimoNaoPossivelException{
         if(itemDesejado.getQuantDisponivel() != 0){
          Emprestimo itemEmprestado = new Emprestimo(itemDesejado);
            itensEmprestados.add(itemEmprestado);
            itemDesejado.Emprestar();
         }else
             throw new EmprestimoNaoPossivelException("Não há quantidade disponível desse item");
           
    }
    
    /**
     * Método que removerá o empréstimo da lista quando o usuário devolver o item,
     * ele informará as multas se necessário.
     * @param nome Nome do item a ser buscado
     * @throws ItemNaoEmprestadoException lançada para caso o Item buscado não tenha sido emprestado
     */
    public void Devolver(String nome) throws ItemNaoEmprestadoException{
        for(Emprestimo i : itensEmprestados)
          {
            if(i.getItem().getTitulo().equals(nome)) 
            {  Item itemDevolucao;
               double valorPagar; 
               LocalDate dataDevolvida;
               dataDevolvida = LocalDate.now();
               i.setDataDevolucaoReal(dataDevolvida);
               itemDevolucao = i.getItem();
              valorPagar = calculaMulta(i);
              itemDevolucao.Devolucao();
              itensEmprestados.remove(i);
              if(valorPagar == 0){
                  System.out.println("Devolução feita no prazo!");
                  return;
              }else
                  System.out.println("Devolvido com atraso!\nValor a ser pago:" + valorPagar);  
            }
          }throw new ItemNaoEmprestadoException("Item não encontrado na lista de empréstimo!");
    }     
    
    /**
     * Método que retorna o nome do usuário.
     * @return O nome do usuário é retornado
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que retorna a senha cadastrada pelo usuário.
     * @return A senha do usuário é retornada
     */
    public String getSenha() {
        return senha;
    }

}
