package com.mycompany.projbancounesp;

import java.io.*;
import static java.lang.Boolean.TRUE;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Classe de armazenamento dos dados do Banco, e possui o menu para direcionar as
 * ações. Essa classe é a única ao qual o usuário tem contato direto.
 */


public class DisplayBanco {
    private Banco meuBanco;
    
    
 /**Construtor que cria o Banco com suas demais propriedades baseado nos arquivos lidos
  * 
  * @param Banco Caminho do arquivo com informações do Banco
  * 
  * @param agencia Caminho do arquivo com informações sobre Agências
  * 
  * @param conta Caminho do arquivo com informações sobre as Contas
  */   
 public DisplayBanco(String Banco, String agencia, String conta){  
   meuBanco = new Banco();
   File arquivoBanco = new File(Banco);
   File arquivoAgencia = new File(agencia);
   File arquivoConta = new File(conta);
   
   Scanner scaneadora = null;
   
  try{
    scaneadora = new Scanner(arquivoBanco);
}catch(FileNotFoundException ex){
     Logger.getLogger(DisplayBanco.class.getName()).log(Level.SEVERE,null,ex);
}
   while (scaneadora.hasNextLine()) {
            String linha = scaneadora.nextLine();
            //Separa as strings através do #
            String[] campos = linha.split("#");
            
            meuBanco.setNome(campos[0]);
            meuBanco.setCnpj(campos[2]);
            meuBanco.setNumeroBanco(Integer.valueOf(campos[1]));
            meuBanco.setEnderecoBanco(campos[3]);
}

 try{
    scaneadora = new Scanner(arquivoAgencia);
}catch(FileNotFoundException ex){
     Logger.getLogger(DisplayBanco.class.getName()).log(Level.SEVERE,null,ex);
}
   while (scaneadora.hasNextLine()) {
            String linha = scaneadora.nextLine();
            //Separa as strings através do #
            String[] campos = linha.split("#");
            
           meuBanco.cadastrarAgencia(Integer.parseInt(campos[1]),campos[0],campos[2]);
          
}
 
 try{
    scaneadora = new Scanner(arquivoConta);
}catch(FileNotFoundException ex){
     Logger.getLogger(DisplayBanco.class.getName()).log(Level.SEVERE,null,ex);
}
   while (scaneadora.hasNextLine()) {
            String linha = scaneadora.nextLine();
            //Separa as strings através do #
            String[] campos = linha.split("#");
            
            meuBanco.cadastrarConta(Integer.valueOf(campos[5]),Integer.valueOf(campos[6]),
                    campos[0], campos[3],campos[1],campos[2],campos[7],Double.valueOf(campos[4]));  
   
}
 
}
 
 /**Método para o usuário  poder logar na conta*/
 
public void login(){
    
    int numero,agencia;
    String senha;
    Scanner leitor = new Scanner(System.in);
    Scanner scaneador = new Scanner(System.in);
    
   do{
    System.out.println("Informe o número da sua Agência:");
    agencia = leitor.nextInt();
    System.out.println("Insira o número da conta:");
    numero = leitor.nextInt();
    System.out.println("Digite sua senha:");
    senha = scaneador.nextLine();
    
   }while( meuBanco.logarCliente(agencia, numero, senha)!= TRUE);
   
   if(meuBanco.logarCliente(agencia, numero, senha)== TRUE)
       telaUsuario();
 
}

/**Método que será acessado somente se ocorrer o login com sucesso. Nele são
 * disponibilizados as ações que podem ser feitas com a conta. Tais ações serão
 * realizadas chamando outros métodos.
 * Caso o usuário saia, o método reimprime o login
 */
private void telaUsuario(){
    int opcao;
    double valor;
    Scanner leitor = new Scanner(System.in);
    Scanner scanneadora = new Scanner(System.in);
 
do{    
    do{
        System.out.println("");    
    System.out.println("MENU:\n1-Consultar Saldo\n2-Fazer Depósito\n3-Sacar\n"
            + "4-Fazer Transferência\n5-PIX\n6-Sair");
        opcao = leitor.nextInt();
        
    if(opcao<1||opcao>6)
    {
        System.out.println("Opção inválida!Escolha uma operação válida");
    }  
}while(opcao<1||opcao>6);

switch(opcao){
    case 1:
        valor = meuBanco.saldo();
        System.out.println("Saldo disponível:"+valor);break;
    case 2:
        System.out.println("Insira o valor que deseja depositar:");
        valor = leitor.nextDouble();
        meuBanco.realizarDeposito(valor);break;
    case 3:
        System.out.println("Insira o valor que deseja sacar:"); 
        valor = leitor.nextDouble();
        meuBanco.realizarSaque(valor);break;
    case 4:
        int numeroAgencia,numeroConta;
        System.out.println("Número da conta para a qual deseja transferir:");
        numeroConta = leitor.nextInt();
        System.out.println("Agência do destinatário:");
        numeroAgencia = leitor.nextInt();
        System.out.println("Valor da transferência:");
        valor = leitor.nextDouble();
        meuBanco.transferencia(numeroAgencia, numeroConta, valor);break;
    case 5:
        String cpfDestinatario;
        System.out.println("Insira a chave Pix:");
        cpfDestinatario = scanneadora.nextLine();
        System.out.println("Insira o valor do PIX:");
        valor = leitor.nextDouble();
        meuBanco.pix(cpfDestinatario, valor);break;
    case 6:
        meuBanco.deslogarConta();
        System.out.println("");
        login();break;
    } 
  }while(opcao!=6);

}

}