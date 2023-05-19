
package com.mycompany.projetobiblioteca;
import java.util.ArrayList;

/**
 *Classe biblioteca será responsável por armazenar os usuários e itens que existem.
 * Possui métodos para cadastrar outros usuários e itens.
 */
public class Biblioteca {
    private ArrayList<Item> Itens = new ArrayList<>();
    private ArrayList<Usuario> Usuarios = new ArrayList<>();
    private Administrador admin;
    private Usuario contaLogada;
   
    /**
     * Método que cadastra o administrador responsável.
     * @param adm Administrador lido no arquivo
     */
    public void CadastraAdmin(Administrador adm){
        this.admin = adm;
    }
    
    /**
     * Método que servirá para comprovar se é o administrador realizando as ações de cadastro.
     * @param user Nome que será comparado ao usuário
     * @param senha String será compara a senha gravada do administrador
     * @return Retorna true se o login estiver correto e false se estiver errado
     */
    public boolean validaAdmin(String user, String senha){
        if(user.equals(getAdmin().getNome())){
            if(senha.equals(getAdmin().getSenha()))
            {
                return true;
            }else
                return false;
        }
        return false;
    }
    
  /**
   * Adiciona um usuário novo à lista de usuários, caso tente cadastrar um usuário pré-existente,
   * uma exceção será criada.
   * @param novoUser Usuário a ser adicionado
   * @throws CadastroNaoPossivelException é lançada se já existe o nome de usuário que deseja cadastrar
   */  
    public void CadastraUsuario(Usuario novoUser) throws CadastroNaoPossivelException{
      if(Usuarios == null){
        Usuarios.add(novoUser);
      }  
      for(Usuario i: Usuarios)
      {  
      if(novoUser.getNome().equals(i.getNome())){
           throw new CadastroNaoPossivelException("Usuário já cadastrado!Tente outro nome de usuário");  
        }
       }
       Usuarios.add(novoUser);
    }  
   /**
   * Adiciona um item novo à lista de itens disponiveis, caso tente cadastrar um item pré-existente, uma exceção será criada.
   * @param itemNovo Item a ser adicionado
   * @throws CadastroNaoPossivelException é lançada se já existe um item com mesmo nome do que se deseja cadastrar
   */  
    public void CadastraItem(Item itemNovo) throws CadastroNaoPossivelException{
       if(Itens == null){
           Itens.add(itemNovo);
           return;
       } 
       for(Item i : Itens){
        if(itemNovo.getTitulo().equals(i.getTitulo())){
           throw new CadastroNaoPossivelException("Item já cadastrado!");  
        }
       }
       Itens.add(itemNovo);
    }
   
    /**
     * Método que percorre a lista de usuários cadastrados, comparando por nome, para achar uma
     * conta específica.
     * @param nome string será usada na busca, comparada aos nomes dos usuários
     * @return A conta do usuário desejada é retornada ou null, caso não encontre
     */
    public Usuario buscaUsuario(String nome){
        for(Usuario i : Usuarios){
            if(i.getNome().equals(nome))
                return i;
        }
        return null;
    }
    
    /**
     * Método que loga o usuário, levando em conta o nome e comparando a senha.
     * @param nome Parâmetro será usado para comparar com as contas
     * @param senha String que será comparado com a senha da conta encontrada
     */
    public void Logar(String nome, String senha){
        Usuario auxBuscado;
        auxBuscado = buscaUsuario(nome);
        if(auxBuscado != null){
            if(senha.equals(auxBuscado.getSenha())){
                contaLogada = auxBuscado;
            }else
                System.out.println("Senha incorreta!");
        }else
            System.out.println("Usuário não encontrado!");
    }     
    
    /**
     * Método que imprimirá os dados de cada empréstimo ativo do usuário logado.
     */
    public void ImprimeEmprestimos(){
        if(getContaLogada().itensEmprestados.isEmpty()){
            System.out.println("Não há empréstimos ativos!");
        }else{
        for(Emprestimo i : contaLogada.itensEmprestados)
        {
            System.out.println("Título: "+ i.getItem().getTitulo());
            System.out.println("Autor: "+ i.getItem().getAutor());
            System.out.println("Publicação: "+ i.getItem().getAnoPublicado());
            System.out.println("Data de Empréstimo: "+ i.getDataEmprestimo());
            System.out.println("Data de Devolução: "+ i.getDataDevolucaoPrevista());
            System.out.println();
        }
      }  
    } 
    
    /**
     * Retorna qual é a conta logada, ou seja,a conta que sofrerá as ações.
     * @return A conta logada é retornada
     */
    public Usuario getContaLogada() {
        return contaLogada;
    }
    
    /**
     * Método que fará com que o apontamento a conta do usuário seja perdida quando
     * usuário resolver sair.
     */
    public void deslogar(){
        contaLogada = null;
    }
    
    /**
     * Método que busca o Item desejado a partir do nome fornecido.
     * @param nome String que será comparado com os itens existentes
     * @return O item desejado é retornado, ou o valor null, caso não acha ele na lista
     *
     */
    public Item buscaItem(String nome){
        for(Item i : Itens){
            if(i.getTitulo().equals(nome)){
                return i;
            }
        }
        return null;
    }

    /**
     * Retorna o administrador cadastrado.
     * @return O administardor é retornado
     */
    public Administrador getAdmin() {
        return admin;
    }
}
