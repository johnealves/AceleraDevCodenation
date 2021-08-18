package br.com.codenation.calculadora;

public class Principal {

    public static void main(String[] args){
        CalculadoraSalario calc = new CalculadoraSalario();

        double salarioLiquido = calc.calcularSalarioLiquido(6000);
        System.out.println(salarioLiquido);
    }
}
