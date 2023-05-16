package com.mycompany.projbancounesp;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Classe com dados de cada conta
 */
public class Conta {

    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private int numero;
    private String senha;
    private double saldo;

    /**
     * Acessa o nome do proprietário da conta
     *
     * @return retorna o nome do titular da conta
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que salva o nome do proptietário da conta
     *
     * @param nome parametro atribuido ao nome do proprietário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que retorna o CPF cadastrado na conta
     *
     * @return CPF do titular da conta é retornado
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Método que salva o CPF do proprietário da conta
     *
     * @param cpf CPF do proprietário da conta será fixado
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Acessa o número da conta
     *
     * @return o numero da conta é retornado
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Método grava o número da conta no atributo
     *
     * @param numero fixa-se o parâmetro no atributo número da conta
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Acessa a senha gravada no atributo da conta
     *
     * @return a senha do cliente é retornada
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Salva a senha no atributo da conta
     *
     * @param senhas senha a ser salva no campo senha
     */
    public void setSenha(String senhas) {
        this.senha = senhas;
    }

    /**
     * Acessa o saldo da conta
     *
     * @return o saldo atual é retornado
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Atribui o valor ao campo saldo da conta
     *
     * @param saldo valor que será salvo no campo saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Acessa a data de nascimento do proprietário da conta
     *
     * @return a data de nascimento do titular é retornada
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Atribui uma data ao campo dataNascimento da classe Conta
     *
     * @param dataNascimento uma data que será atribuida a conta
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Acessa o endereço onde o titular da conta reside
     *
     * @return o endereco do titular cadastrado é retornado
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Atribui o endereço ao atributo referente
     *
     * @param endereco Logradouro que será salvo no atributo endereço
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Ascrecenta o valor definido no parâmetro à quantia já salva no campo
     * saldo
     *
     * @param valor quantia que será acrescida ao saldo
     */
    public void depositar(double valor) {
        saldo = saldo + valor;
    }

    /**
     * Retira o valor definido no parâmetro, caso seja possível, da quantia já
     * salva no campo saldo
     *
     * @param valor quantia que será retirada do saldo
     */
    public void sacar(double valor) {
        if (valor > 0) {
            if (getSaldo() >= valor) {
                saldo = saldo - valor;
            } else {
                System.out.println("Saldo insuficiente!");
            }
        } else {
            System.out.println("Não foi possível realizar operação; insira um valor válido(positivo)");
        }
    }

    /**
     * Método que verifica se a senha informada é a correta
     *
     * @param senhaComparacao usado na comparação para verificar se está de
     * acordo com a senha cadastrada pelo usuário
     *
     * @return O valor retornado será verdadeiro, caso a senha seja compatível;
     * ou falso se a senhaComparacao não for a cadastrada no atributo da conta
     */
    public boolean validarSenha(String senhaComparacao) {
        if (senhaComparacao.equals(this.senha)) {
            return TRUE;
        } else {
            return FALSE;
        }
    }

    /**
     * Método que permite alterar a senha cadastrada
     *
     * @param senhaAtual usada para verificar validade da operacao
     *
     * @param senhaNova será gravada caso a senha atual esteja correta
     */
    public void setSenha(String senhaAtual, String senhaNova) {
        if (senhaAtual.equals(getSenha())) {
            this.senha = senhaNova;
        } else {
            System.out.println("Senha incorreta!Não foi possível alterar a senha");
        }
    }

}
