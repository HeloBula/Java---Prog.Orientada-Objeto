package com.mycompany.projbancounesp;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.ArrayList;

/**
 * Classe do Banco,seus atributos e métodos,incluindo lista de agências
 */
public class Banco {

    private String nome;
    private int numeroBanco;
    private String cnpj;
    private String enderecoBanco;
    private Conta contaLogada;
    private ArrayList<Agencia> agenciasDoBanco = new ArrayList<>();

    /**
     * Método que retorna o nome do banco
     * 
     * @return o nome do Banco é retornado
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método grava o nome do banco no seu atributo
     *
     * @param nome string que será armazenada no campo 'nome'
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que retorna o número do Banco
     * 
     * @return ´retorna o Número do Banco
     */
    public int getNumeroBanco() {
        return numeroBanco;
    }

    /**
     * Método grava o número do Banco
     *
     * @param numeroBanco número que será passado como atributo da classe Banco
     */
    public void setNumeroBanco(int numeroBanco) {
        this.numeroBanco = numeroBanco;
    }

    /**
     * Método que retorna o CNPJ do Banco
     * 
     * @return o CNPJ do Banco é retornado
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Método grava o CNPJ do Banco
     *
     * @param cnpj  número que será passado como atributo para classe Banco
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Método grava o endereço do Banco
     * 
     * @return o endereço do Banco é retornado
     */
    public String getEnderecoBanco() {
        return enderecoBanco;
    }

    /**
     * Método que grava o endereço do Banco
     *
     * @param enderecoBanco string que contém o local do Banco
     */
    public void setEnderecoBanco(String enderecoBanco) {
        this.enderecoBanco = enderecoBanco;
    }

    /**
     * Método no qual eu verifico se é possivel acessar a conta que o cliente
     * deseja
     *
     * @param numeroAgencia usado para achar a agência certa
     *
     * @param numeroConta usado para procurar a conta, comparando com as que
     * existem na agência
     *
     * @param senha será comparada com a senha cadastrada na conta
     *
     * @return Booleano que será usado para verificar se é possivel ou não logar
     */
    public boolean logarCliente(int numeroAgencia, int numeroConta, String senha) {
        for (Agencia agenciaBuscada : agenciasDoBanco) {
            if (agenciaBuscada.getCodigo() == numeroAgencia) {
                contaLogada = agenciaBuscada.buscarConta(numeroConta, senha);
                if (contaLogada != null) {
                    return TRUE;
                } else {
                    return FALSE;
                }
            }
        }
        System.out.println("Agência não encontrada! Tente novamente");
        return FALSE;//não achou a agência
    }

    /**
     * Método que realiza o saque da conta
     *
     * @param valor quantia que deseja retirar
     *
     * @return valor que foi retirado, como se fosse o dinheiro saindo do caixa
     * eletrônico
     */
    public double realizarSaque(double valor) {
        contaLogada.sacar(valor);
        return valor;
    }

    /**
     * Método usado para depositar uma quantia de dinheiro na conta
     *
     * @param valor quantia especificada a ser depositada
     */
    public void realizarDeposito(double valor) {
        contaLogada.depositar(valor);
    }

    /**
     * Método que mostra a quantia de dinheiro na Conta
     *
     * @return Retorna o valor presente na conta
     */
    public double saldo() {
        double saldoAtual;
        saldoAtual = contaLogada.getSaldo();
        return saldoAtual;
    }

    /**
     * Método para adicionar a Agência a lista de agência
     *
     * @param agenciaCad agência que deseja-se cadastrar
     */
    public void cadastrarAgencia(Agencia agenciaCad) {
        agenciasDoBanco.add(agenciaCad);
    }

    /**
     * Cadastra uma nova agência a partir da definição de seus atributos, e 
     * adiciona usando o outro método de cadastrar
     *
     * @param codigo número da agência para cadastrar
     *
     * @param nome Nome da agência que está sendo cadastrada
     *
     * @param endereco servirá de localização da agência
     */
    public void cadastrarAgencia(int codigo, String nome, String endereco) {
        Agencia agenciaNova = new Agencia();

        agenciaNova.setCodigo(codigo);
        agenciaNova.setNome(nome);
        agenciaNova.setEndereco(endereco);

        cadastrarAgencia(agenciaNova);
    }

    /**
     * Crio e insiro uma conta nova na agência escolhida
     *
     * @param numeroAgencia número da agência na qual o usuário deseja criar uma
     * conta
     *
     * @param numeroConta dados a serem 'setados' nos atributos da conta
     *
     * @param nome dados a serem 'setados' nos atributos da conta
     *
     * @param cpf dados a serem 'setados' nos atributos da conta
     *
     * @param dataNasc dados a serem 'setados' nos atributos da conta
     *
     * @param enderecoConta dados a serem 'setados' nos atributos da conta
     *
     * @param senha dados a serem 'setados' nos atributos da conta
     *
     * @param dinheiro dados a serem 'setados' nos atributos da conta
     *
     */
    public void cadastrarConta(int numeroAgencia, int numeroConta, String nome, String cpf,
            String dataNasc, String enderecoConta, String senha, double dinheiro) {
        for (Agencia agenciaBuscada : agenciasDoBanco) {
           if(agenciaBuscada.getCodigo() == numeroAgencia)
           {
                Conta contaNova = new Conta();

                contaNova.setNome(nome);
                contaNova.setNumero(numeroConta);
                contaNova.setCpf(cpf);
                contaNova.setDataNascimento(dataNasc);
                contaNova.setEndereco(enderecoConta);
                contaNova.setSenha(senha);
                contaNova.setSaldo(dinheiro);

                agenciaBuscada.cadastrarConta(contaNova);
           }
              

        }
    }

    /**
     * Método que busca a agência
     *
     * @param codigo número a ser comparado
     *
     * @return retorna a agência que queriamos achar na lista ou null,caso não seja
     * possível achar.
     */

    public Agencia buscarAgencia(int codigo) {
        for (Agencia agenciaBuscada : agenciasDoBanco) {
            if (agenciaBuscada.getCodigo() == codigo) {
                return agenciaBuscada;
            }
        }
        return null;
    }

   
    /**Método criado para achar a conta para qual será transferido o dinheiro na classe Banco,
     * sem a necessidade de saber a senha.
     * 
     * @param numeroContaBuscada número da conta à qual desejo fazer a transferencia
     * @param numeroAgencia agencia onde a conta buscada está
     * @return retorna a conta para qual o dinheiro será transferido
     */
    public Conta buscarConta(int numeroContaBuscada, int numeroAgencia) {
        Agencia agenciaDesejada;
        Conta contaAchada;
        
        agenciaDesejada = buscarAgencia(numeroAgencia);
        
       if(agenciaDesejada != null){ 
           contaAchada = agenciaDesejada.buscarConta(numeroContaBuscada);
           if(contaAchada != null)
           {
               return contaAchada;
           }else
               System.out.println("Conta não encontrada!");
       }
        System.out.println("Agência não encontrada!");
        return null;
       
    } 
    
    /**Método para transferir dinheiro da conta logada para outra conta,que
     * achamos através do método buscarConta.
     * Usei o método depositar como formar de mostrar que a outra conta receberá
     * o valor especificado
     * 
     * @param numeroAgencia agência do beneficiário receptor
     * @param numeroConta número da conta do receptor
     * @param valor quantidade de dinheiro que será transferida
     */
    public void transferencia(int numeroAgencia, int numeroConta, double valor)
    {
        Conta beneficiarioReceptor;
       
        beneficiarioReceptor = buscarConta(numeroConta, numeroAgencia);
        contaLogada.sacar(valor);
        beneficiarioReceptor.depositar(valor);
        System.out.println("Transferência realizada!");
    }
    
    /**Método de buscar uma conta pelo CPF que será utilizada no método pix
     * 
     * @param cpf número de cpf usado para transferir
     * 
     * @return retorna a conta para a qual desejo transferir ou null, caso não
     * encontre a conta
     * 
     */
    public Conta buscarPeloCpf(String cpf){
        Conta achou;
        for(Agencia i : agenciasDoBanco )
        {
           achou = i.buscarConta(cpf);
           //Verifico se achou
           if(achou != null)
           {
               return achou;
           }
        }
        System.out.println("Conta não encontrada!");        
        return null; 
    }
    
    
    
    /**Método de pagar com pix, no caso, a chave será sempre um CPF
     * 
     *@param chaveCPF CPF que será buscado comparando com o campo CPF de cada conta
     * 
     * @param valor quantia que será transferida via pix
     */
    public void pix(String chaveCPF, double valor){
        Conta destinatario;
        
        contaLogada.sacar(valor);
        
        destinatario = buscarPeloCpf(chaveCPF);
        destinatario.depositar(valor);
        
    }
    
    /** Método que desloga o usuário, para isso eu modifico o campo que guardava
     * a conta que sofria modificações para null, perdendo o 'apontamento'
     */
    public void deslogarConta(){
        contaLogada = null;
    }
    
}
