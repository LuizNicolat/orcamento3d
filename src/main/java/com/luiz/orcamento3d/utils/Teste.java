package com.luiz.orcamento3d.utils;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("O consumo é: "+ Utils.calculateKilowatsPerMinutes(270, 60)+" kw");
		System.out.println("O valor gasto de energia por "+Utils.convertMinutesToHoursAndMinutes(60)+"h foi de: R$"+Utils.totalValueFromKwUsed(270, 60));
		
	}

}
