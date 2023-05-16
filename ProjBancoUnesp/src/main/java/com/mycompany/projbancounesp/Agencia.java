package com.mycompany.projbancounesp;

import java.util.ArrayList;

/**
 * Classe com os atributos das agências bancárias,
 * entre eles a lista com as contas.
 */
public class Agencia {

    private String nome;
    private int codigo;
    private String endereco;
    private ArrayList<Conta> contasDaAgencia = new ArrayList<>();

    /**
     *Método que retorna o nome da agência
     * 
     *@return o nome da agencia é retornado
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que atribui o nome para o atributo nome
     * 
     * @param nome é atribuido ao campo nome da agencia.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que retorna o número da agência
     * 
     * @return o codigo da agencia é retornado.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Método que 'seta' o número da agência
     * 
     * @param codigo número que será atribuido para campo codigo da agência
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Método que retorna o endereço da Agência
     * 
     * @return o endereço onde está localizada a agencia é retornado.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Método que 'seta' o endereço no atributo da Agência
     * 
     * @param endereco string que será salva no atributo endereço.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Método que cadastra uma conta na lista de contas da agência
     * 
     * @param contaCad conta a ser inserida nessa agencia, ela é adicionada com o coamndo
     * '.add'
     * 
     */
    public void cadastrarConta(Conta contaCad) {
        contasDaAgencia.add(contaCad);
    }

    /**
     * Método que procura na lista a conta desejada na lista de contas, através
     * do número e senha
     *
     * @param numeroContaBuscada número que servirá para comparar com o número
     * das contas na lista
     *
     * @param senha servirá para verificar se o acesso à conta é válido
     *
     * @return É retornada a conta desejada ou null, caso não seja possível achar
     */
    public Conta buscarConta(int numeroContaBuscada, String senha) {
        for (Conta i : contasDaAgencia)//declaro um objeto do tipo conta para ir rodando a lista
        {
            if (i.getNumero() == numeroContaBuscada) {
                if (i.validarSenha(senha)) {
                    return i;//retorno a Conta achada
                } else {
                    System.out.println("Senha Incorreta!");
                    return null;
                }                
            }            
        }
        System.out.println("Conta não encontrada!");        
        return null;        
    }
    
    /**Buscar a conta através somente do número
     * 
     * @param numeroContaDesejada número que vai servir de comparação
     * @return a conta desejada ou null,se não foi possível achar, é retornado
     */
    
   public Conta buscarConta(int numeroContaDesejada){
       
     for (Conta i : contasDaAgencia)//declaro um objeto do tipo conta para ir rodando a lista
        {
            if (i.getNumero() == numeroContaDesejada) {
                return i;}
        }
     return null;
    }   
    
    
    /**Método para achar a agência que contem o cpf do beneficiario do pix
     * 
     * 
     * @param cpf número que é o CPF do beneficiario
     * @return Conta que contém o cpf especificado é retornada
     */
    public Conta buscarConta(String cpf){
        for(Conta i: contasDaAgencia)
        {if(i.getCpf().equals(cpf))
            {
            return i;
            }
        }
        return null;
    }
    
    
}
