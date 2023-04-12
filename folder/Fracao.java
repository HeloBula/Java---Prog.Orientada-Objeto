
package com.mycompany.projetofracao;

public class Fracao {
    private int numerador;
    private int denominador;
  //Construtor
    public Fracao(int numero1, int numero2){
        if(numero2 == 0||numero2<0)
            numero2 = 1;
        else
            numerador = numero1;
            denominador = numero2;
    }
    
    public Fracao Soma(Fracao numero1, Fracao numero2){
        int novoNumerador;
        int novoDenominador;
        if(numero1.getDenominador() != numero2.getDenominador())
        {  novoDenominador = numero1.getDenominador()*numero2.getDenominador();
            novoNumerador = (numero1.getNumerador()*numero2.getDenominador()+ numero1.getDenominador()*numero2.getNumerador());
        }else
        {
            novoDenominador = numero1.getDenominador();
            novoNumerador = numero1.getNumerador() + numero2.getNumerador();
        }
        Fracao resultado = new Fracao(novoNumerador,novoDenominador);
        return resultado;   
    }   

    public double Soma(double num1, double deno1, double num2, double deno2){
        double a, b;
        a = num1/deno1;
        b = num2/deno2;
        
        return a+b;
    }
    
    /**
     * @return the numerador
     */
    public int getNumerador() {
        return numerador;
    }

    /**
     * @param numerador the numerador to set
     */
    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    /**
     * @return the denominador
     */
    public int getDenominador() {
        return denominador;
    }

    /**
     * @param denominador the denominador to set
     */
    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
        
    
    
    
    
    
    
    
    
    
    
    
    
}
