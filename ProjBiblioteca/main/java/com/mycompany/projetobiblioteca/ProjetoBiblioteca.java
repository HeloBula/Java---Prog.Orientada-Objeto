
package com.mycompany.projetobiblioteca;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Inicio o programa lendo o arquivo de itens e salvando na lista da biblioteca, faço um try catch para caso haja um erro ao cadastrar.
 * Também realizo o primeiro cadastro sendo do usuário administrador, que poderá cadastrar outros itens e usuários
 */
public class ProjetoBiblioteca {

    public static void main(String[] args) {
       DisplayBiblioteca bibliotecaUnespPrograma = new DisplayBiblioteca();
       Scanner scaneadora = null;
       String caminhoArquivo = "C:\\Users\\helsi\\OneDrive\\Área de Trabalho\\Faculdade\\POO\\items.txt";
       File caminho = new File(caminhoArquivo);
       Item itemNovo;
       
       String caminhoAdmin = "C:\\Users\\helsi\\OneDrive\\Área de Trabalho\\Faculdade\\POO\\Admin.txt";
       File caminhoUsuarioADM = new File(caminhoAdmin);
       
    try{
        scaneadora = new Scanner(caminho);
    }catch(FileNotFoundException ex){
     Logger.getLogger(DisplayBiblioteca.class.getName()).log(Level.SEVERE,null,ex);
}
   while (scaneadora.hasNextLine()) {
        try{    String linha = scaneadora.nextLine();
            //Separa as strings através do #
            String[] campos = linha.split("#");
            if(campos[0].equals("Livro")){
              itemNovo = new Livro(campos[2],campos[1],Integer.valueOf(campos[3]),Integer.valueOf(campos[4]),0,campos[5],campos[6]); 
              bibliotecaUnespPrograma.bibliotecaUnesp.CadastraItem(itemNovo);
            }else if(campos[0].equals("Revista"))
            {
              itemNovo = new Revista(campos[2],campos[1],Integer.valueOf(campos[3]),Integer.valueOf(campos[4]),0,Integer.valueOf(campos[5]),Integer.valueOf(campos[6]));
              bibliotecaUnespPrograma.bibliotecaUnesp.CadastraItem(itemNovo);
            }else if(campos[0].equals("CD")){
              itemNovo = new CD(campos[2],campos[1],Integer.valueOf(campos[3]),Integer.valueOf(campos[4]),0,Integer.valueOf(campos[5]),campos[6]);
              bibliotecaUnespPrograma.bibliotecaUnesp.CadastraItem(itemNovo);
            }
        }catch(CadastroNaoPossivelException e){
            System.out.println(e.getMessage());
        }    
}
   
   try{
        scaneadora = new Scanner(caminhoUsuarioADM);
    }catch(FileNotFoundException ex){
     Logger.getLogger(DisplayBiblioteca.class.getName()).log(Level.SEVERE,null,ex);
    }
   while (scaneadora.hasNextLine()) {
          String linha = scaneadora.nextLine();
            //Separa as strings através do #
            String[] campos = linha.split("#");
            Administrador adm;
            adm = new Administrador(campos[0],campos[1]);
            bibliotecaUnespPrograma.bibliotecaUnesp.CadastraAdmin(adm);
        } 

         bibliotecaUnespPrograma.Menu();
   
    }
       
    }

