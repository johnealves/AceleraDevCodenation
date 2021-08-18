package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		if (salarioBase < 1039) {
			return Math.round(0.0);
		}

		double salaraioAposInss = calcularInss(salarioBase);

		if (salaraioAposInss <= 3000) {
			return Math.round(salaraioAposInss);
		} else if (salaraioAposInss <= 6000) {
			return Math.round(salaraioAposInss * 0.925);
		} else {
			return Math.round(salaraioAposInss * 0.85);
		}

	}

//	Faixa salarial	Percentual de desconto
//	Até R$ 3.000,00	ISENTO
//	De R$ 3.000,01 até R$ 6.000,00	7.5%
//	Acima de R$ 6.000,00	15%
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		if (salarioBase <= 1500) {
			return salarioBase * 0.92;
		} else if (salarioBase <= 4000) {
			return salarioBase * 0.91;
		} else {
			return salarioBase * 0.89;
		}
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/