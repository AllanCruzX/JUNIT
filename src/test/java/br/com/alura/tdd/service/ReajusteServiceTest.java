package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desenpenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach
	public void inicializar() {
		System.out.println("in�cio");
		service = new ReajusteService();
		funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	@AfterEach
	public void finalizar() {
		System.out.println("Fim");
	}
	
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("ANTES DE TODOS");
	}
	
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("DEPOIS DE TODOS");
	}

	@Test
	public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
		
		service.concederReajuste(funcionario, Desenpenho.A_DESEJAR);
		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());

	}
	
	@Test
	public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForBom() {
		service.concederReajuste(funcionario, Desenpenho.BOM);
		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());

	}
	
	@Test
	public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForOtimo() {
		service.concederReajuste(funcionario, Desenpenho.OTIMO);
		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());

	}

}
