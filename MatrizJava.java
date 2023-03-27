/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matriz.java;
import java.util.Scanner;

public class MatrizJava {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int matrizA[][], matrizB[][],matrizC[][];
        int L1,C1,L2,C2;
        int i, j,k;
        
        System.out.println("Digite o número de linhas da matriz A:");
        L1 = leitor.nextInt();
        System.out.println("Digite o número de colunas da matriz A:");
        C1 = leitor.nextInt();
        System.out.println("Digite o número de linhas da matriz B:");
        L2 = leitor.nextInt();
        System.out.println("Digite o número de colunas da matriz B:");
        C2 = leitor.nextInt();
        
        matrizA = new int[L1][C1];
        matrizB = new int[L2][C2];
        matrizC = new int[L1][C2];
        
        
        if(C1 == L2)
        { System.out.println("Preencha a matriz");
            for(i=0;i<L1;i++)
          { for(j=0;j<C1;j++)
            {
              matrizA[i][j] = leitor.nextInt();
            }
          }
          System.out.println("Preencha a segunda matriz");
          for(i=0;i<L2;i++)
          { for(j=0;j<C2;j++)
            {
              matrizB[i][j] = leitor.nextInt();
            }
          }   
         for(i=0;i<L1;i++)//para calcular a matriz nova
          { for(j=0;j<C2;j++)
            {  for(k=0;k<L2;k++)
            {  
                matrizC[i][j] = matrizC[i][j] + matrizA[i][k]*matrizB[k][j];
            }
            }
         }
         System.out.println("Matriz Resultante: ");
         
         for(i=0;i<L1;i++)//para imprimir a matriz nova
         { for(j=0;j<C2;j++)
          {
              System.out.printf("%d ",matrizC[i][j]);
          }
         System.out.printf("\n");
         }
       }
    }
}   
