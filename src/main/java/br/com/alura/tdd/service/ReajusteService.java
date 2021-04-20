package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desenpenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desenpenho desenpenho) {
		
			BigDecimal percentual = desenpenho.percentualReajuste();
			BigDecimal reajuste  =  funcionario.getSalario().multiply(percentual);
			
			funcionario.reajustarSlario(reajuste);
		
	}

}
