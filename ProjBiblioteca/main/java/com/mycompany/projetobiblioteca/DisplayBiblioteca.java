
package com.mycompany.projetobiblioteca;
import java.util.Scanner;
/**
 *Servirá de menu para a biblioteca.
 */
public class DisplayBiblioteca{
    Biblioteca bibliotecaUnesp = new Biblioteca();
   /**
    * Método que oferece as opções disponiveis a serem feitas, nele são oferecidas as opções
    * de adicionar elementos, ou logar numa conta já existente.
    */ 
    public void Menu(){
        int opcao;
        Scanner scanner = new Scanner(System.in);
        Scanner leitor = new Scanner(System.in);
        
      do{  System.out.println("Bem-vindo!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar usuário\n2-Cadastrar Item\n3 - Logar na conta\n4-Encerrar");
        opcao = scanner.nextInt();
       if(opcao == 1)
       { String nomeAdmin, senhaAcesso;
           do{
           System.out.println("Insira o usuário Administrador: ");
           nomeAdmin = leitor.nextLine();
           System.out.println("Insira a senha do Administrador: ");
           senhaAcesso = leitor.nextLine();
          if(bibliotecaUnesp.validaAdmin(nomeAdmin, senhaAcesso)!= true){
              System.out.println("Administrador inválido!Tente de novo");
            }    
          }while(bibliotecaUnesp.validaAdmin(nomeAdmin, senhaAcesso)!= true);
           String nomeCad;
           int matricula;
           int escolha;
           String senha;
           System.out.println("Insira o nome do usuário a ser cadastrado:");
           nomeCad = leitor.nextLine();
           System.out.println("Insira o número de matricula:");
           matricula = scanner.nextInt();
           System.out.println("Cadastre a senha de acesso:");
           senha = leitor.nextLine();
           System.out.println("Escolha a categoria: 1- Aluno\n2- Professor\n3- Assesor Técnico");
           escolha = scanner.nextInt();
          if(escolha == 1){
              int periodo;
              String curso;
              System.out.println("Digite o curso:");
              curso = leitor.nextLine();
              System.out.println("Semestre:");
              periodo = scanner.nextInt();
              Usuario aluno = new Aluno(nomeCad,matricula,senha,curso,periodo);
             try{
              bibliotecaUnesp.CadastraUsuario(aluno);
             }catch(CadastroNaoPossivelException e){
                 System.out.println(e.getMessage());
             }
          }else if(escolha == 2)
          {
              String dep;
              String titulo;
              System.out.println("Digite o departamento:");
              dep = leitor.nextLine();
              System.out.println("Digite a Titulação:");
              titulo = leitor.nextLine();
              Usuario professor = new Professor(nomeCad,matricula,senha,dep,titulo);
              try{
              bibliotecaUnesp.CadastraUsuario(professor);
             }catch(CadastroNaoPossivelException e){
                 System.out.println(e.getMessage());
             }
          }else if(escolha == 3){
              String secao;
              System.out.println("Digite sua seção:");
              secao = leitor.nextLine();
              Usuario assesor = new AssesorTecnico(nomeCad,matricula,secao,senha);
               try{
              bibliotecaUnesp.CadastraUsuario(assesor);
             }catch(CadastroNaoPossivelException e){
                 System.out.println(e.getMessage());
             }
          }
       }
       
       if(opcao==2){
           String nomeAdmin, senhaAcesso;
           do{
           System.out.println("Insira o usuário Administrador: ");
           nomeAdmin = leitor.nextLine();
           System.out.println("Insira a senha do Administrador: ");
           senhaAcesso = leitor.nextLine();
          if(bibliotecaUnesp.validaAdmin(nomeAdmin, senhaAcesso)!= true){
              System.out.println("Administrador inválido!Tente de novo");
            }    
          }while(bibliotecaUnesp.validaAdmin(nomeAdmin, senhaAcesso)!= true);
          String titulo,autor;
          int ano,qtdDisponivel,tipo;
          Item itemCadastrar;
           System.out.println("Insira o titulo:");
           titulo = leitor.nextLine();
           System.out.println("Autor:");
           autor = leitor.nextLine();
           System.out.println("Ano de publicação:");
           ano = scanner.nextInt();
           System.out.println("Quantidade:");
           qtdDisponivel = scanner.nextInt();
          do{ System.out.println("Tipo de item  que deseja cadastrar?1-Livro,2-CD,3-Revista");
          tipo = scanner.nextInt();
            switch (tipo){
              case 1:
                  String editora,ISBN;
                  System.out.println("Editora:");
                  editora = leitor.nextLine();
                  System.out.println("ISBN:");
                  ISBN = leitor.nextLine();
                  itemCadastrar = new Livro(autor,titulo,ano,qtdDisponivel,0,editora,ISBN);
                  try{
                      bibliotecaUnesp.CadastraItem(itemCadastrar);
                      System.out.println("Item cadastrado!");break;
                  }catch(CadastroNaoPossivelException e){
                      System.out.println(e.getMessage());
                  }
             case 2: 
                 String gravadora;
                 int volume;
                 System.out.println("Gravadora:");
                 gravadora = leitor.nextLine();
                 System.out.println("Volume:");
                 volume = scanner.nextInt();
                 itemCadastrar = new CD(autor,titulo,ano,qtdDisponivel,0,volume,gravadora);
                 try{
                      bibliotecaUnesp.CadastraItem(itemCadastrar);
                  }catch(CadastroNaoPossivelException e){
                      System.out.println(e.getMessage());
                  }
                  System.out.println("Item cadastrado!");break;
            case 3:
                int vol,numero;
                 System.out.println("Numero:");
                 numero = scanner.nextInt();
                 System.out.println("Volume:");
                 vol = scanner.nextInt();
                 itemCadastrar = new Revista(autor,titulo,ano,qtdDisponivel,0,vol,numero);
                  try{
                      bibliotecaUnesp.CadastraItem(itemCadastrar);
                  }catch(CadastroNaoPossivelException e){
                      System.out.println(e.getMessage());
                  }
                  System.out.println("Item cadastrado!");break;
          }
          }while(tipo<1||tipo>3);
       }
       
       else if(opcao == 3)
       {
           String nome,senha;
         do{
           Scanner leitorSenha = new Scanner(System.in);  
           System.out.println("LOGIN:");
           System.out.println("(Para sair do método login, insira 1 em usuário)");
           System.out.println("Insira o usuário:");
           nome = leitor.nextLine();
           if(nome.equals("1")){
               Menu();
               return;
           }
           System.out.println("Senha:");
           senha = leitorSenha.nextLine();
           bibliotecaUnesp.Logar(nome,senha);
           if(bibliotecaUnesp.getContaLogada()!= null){
               MenuOperacao(); 
           }   
           }while(bibliotecaUnesp.getContaLogada()== null);  
        }if(opcao==4){
            System.out.println("Encerrando programa!");
        }else if(opcao<1||opcao>4)
           System.out.println("Opção Inválida!Escolha uma operação válida.");
      }while(opcao!=4);
    }
    
    /**
     * Método que será exibido caso o login seja efetuado com sucesso.
     * Apresenta as opções disponiveis para o usuário realizar
     */
    public void MenuOperacao(){
        Usuario userLogado = bibliotecaUnesp.getContaLogada();
        Scanner scanner = new Scanner(System.in);
        Scanner leString = new Scanner(System.in);
        int acao;
        Item itemBuscado;
        
        System.out.println("Olá, " + bibliotecaUnesp.getContaLogada().getNome());
     do{
        System.out.println("Escolha a opção desejada:");
        System.out.println("1- Buscar item\n2- Emprestar item\n3- Devolver item"
                + "\n4- Verificar meus empréstimos\n5-Sair");
        acao = scanner.nextInt();
        switch(acao){
            case 1:
                String titulo;
                System.out.println("Digite o nome do item buscado:");
                titulo = leString.nextLine();
                itemBuscado = bibliotecaUnesp.buscaItem(titulo);
                if(itemBuscado==null){
                    System.out.println("Item não encontrado!");
                }else
                {   System.out.println();
                    System.out.println("Titulo: " + itemBuscado.getTitulo());
                    System.out.println("Autor: " + itemBuscado.getAutor());
                    System.out.println("Ano de publicação: " + itemBuscado.getAnoPublicado());
                    System.out.println("Quantidade disponivel: " + itemBuscado.getQuantDisponivel());
                }break;
            case 2:
                String nome;
                System.out.println("Insira o nome do item buscado:");
                nome = leString.nextLine();
                itemBuscado = bibliotecaUnesp.buscaItem(nome);
              if(itemBuscado!=null){
              try{  
                userLogado.Emprestar(itemBuscado);
                System.out.println("Item Adicionado!");break;
              }catch(EmprestimoNaoPossivelException e){
                  System.out.println(e.getMessage());
              }
              }else
                    System.out.println("Item não encontrado!");break;
            case 3:
                String itemNome;
                System.out.println("Insira o nome do item a ser devolvido:");
                itemNome = leString.nextLine();
               try{
                   userLogado.Devolver(itemNome);break;
               }catch(ItemNaoEmprestadoException e){
                   System.out.println(e.getMessage());
               } 
            case 4: 
               bibliotecaUnesp.ImprimeEmprestimos();break;
        }
       }while(acao != 5);
       bibliotecaUnesp.deslogar();
       System.out.println("Usuário deslogado com sucesso!");
    }
}
