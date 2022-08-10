package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import br.com.alura.rh.ValidacaoException;

public class Funcionario {

	private String nome;
	private String cpf;
	private Cargo cargo;
	private BigDecimal salario;
	private LocalDate dataUltimoReajuste;
	
	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	private void reajustarSalario(BigDecimal aumento) {
		BigDecimal precentualReajuste = aumento.divide(salario, RoundingMode.HALF_UP);
		
		if(precentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste não pode ser superior a 40% do salário!");
		}
		
		salario = salario.add(aumento);
		dataUltimoReajuste = LocalDate.now();
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}
	
}
