/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetofracao;

/**
 *
 * @author helsi
 */
public class ProjetoFracao {

    public static void main(String[] args) {
        Fracao numero1 =  new Fracao(1,2);
        Fracao numero2 = new Fracao(1,2);
        Fracao resultado;
        double resultado2;
        
        resultado = numero1.Soma(numero1, numero2);
        System.out.println(resultado.getNumerador() + "/" + resultado.getDenominador());
        
        resultado2 = numero1.Soma(numero1.getNumerador(), numero1.getDenominador(), numero2.getNumerador(), numero2.getDenominador());
        System.out.printf("Resultado:%f",resultado2);
        
    }
}
