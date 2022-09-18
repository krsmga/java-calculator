/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kleber.silva
 */
public class Calc {
     public static void main(String args[])
    {
        //
    }
    public String calculadora(String text) {
        String resultado;
        List<Double> listNumber = new ArrayList<Double>();
        List<Character> listOper = new ArrayList<Character>(); 
        listNumber = obterNumeros(text);
        listOper = obterOperadores(text); 
        resultado = calcularValor(listNumber, listOper); 
        return resultado; 
    }
 
    private String calcularValor(List<Double> listNumber, List<Character> listOper) {
        String result = "";
        double total = 0.0;
        int j=0;
        for (int i = 0; i < listNumber.size()-1; i++) {
 
            if ( total==0.0) {
                double num1 = listNumber.get(i).doubleValue();
                double num2 = listNumber.get(i + 1).doubleValue();
                char operador = listOper.get(i).charValue();
                total = executarOperacao(num1, operador, num2);
            }
            else if (total>0.0) {
                double num2 = listNumber.get(i).doubleValue();
                char operador = listOper.get(j).charValue();
                total = executarOperacao(total, operador, num2);
                j++;
            }         
        } 
        result = ""+total;
        return result;
    }
 
    private double executarOperacao(double numero1, char operador, double numero2) {
        double resultado = 0.0;
 
        if (operador == '+') {
            resultado = numero1 + numero2;
        } else if (operador == '-') {
            resultado = numero1 - numero2;
        } else if (operador == '/') {
            resultado = numero1 / numero2;
        } else if (operador == '*') {
            resultado = numero1 * numero2;
        }
        return resultado;
    }
 
    private List<Double> obterNumeros(String text) {
 
        List<Double> listaNumeros = new ArrayList<Double>(); 
        String numeroEmString = "";
        for (int i = 0; i < text.length(); i++) {
 
            if (isOperador(text.charAt(i))) {
                Double numero = Double.valueOf(numeroEmString);
                listaNumeros.add(numero);
                numeroEmString = "";
            } else {
                numeroEmString = numeroEmString.concat("" + text.charAt(i));
            }
        }
        if(!numeroEmString.isEmpty())
        {
                Double numero = Double.valueOf(numeroEmString);
                listaNumeros.add(numero);             
        }
        return listaNumeros;
    }
 
    private List<Character> obterOperadores(String text) {
 
        List<Character> listaOperadores = new ArrayList<Character>(); 
 
        for (int i = 0; i < text.length(); i++) { 
            if (isOperador(text.charAt(i))) {
                listaOperadores.add(new Character(text.charAt(i)));
            }
        } 
        return listaOperadores;
    }
 
    private boolean isOperador(char caracter) {
        boolean isOperador = false;
        if (caracter == '-' || caracter == '+' || caracter == '/' || caracter == '*') {
            isOperador = true;
        }
        return isOperador;
    }
}
