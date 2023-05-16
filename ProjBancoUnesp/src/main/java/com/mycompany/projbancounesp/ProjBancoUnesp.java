
package com.mycompany.projbancounesp;

/**
 *Classe principal do projeto Banco Unesp, nela passo o caminho dos arquivos 
 *que serão usados como um mini banco de dados.
 *Crio uma instância da classe DisplayBanco na qual eu chamo o método login
 * que "inicia" o atendimento do banco.
 * 
 * @author Heloisa S. Bula, discente do 2º ano de Ciência da Computação
 */
public class ProjBancoUnesp {

    public static void main(String[] args) {
        String caminhoBanco = "C:\\Users\\helsi\\OneDrive\\Área de Trabalho\\Faculdade\\POO\\ProjBancoUnesp\\src\\main\\java\\com\\mycompany\\projbancounesp\\banco.txt";
        String caminhoAgencia = "C:\\Users\\helsi\\OneDrive\\Área de Trabalho\\Faculdade\\POO\\ProjBancoUnesp\\src\\main\\java\\com\\mycompany\\projbancounesp\\agencias.txt";
        String caminhoConta = "C:\\Users\\helsi\\OneDrive\\Área de Trabalho\\Faculdade\\POO\\ProjBancoUnesp\\src\\main\\java\\com\\mycompany\\projbancounesp\\contas.txt";
        
        DisplayBanco bancoUnesp = new DisplayBanco(caminhoBanco,caminhoAgencia,caminhoConta);
        
        bancoUnesp.login();
    }
}
