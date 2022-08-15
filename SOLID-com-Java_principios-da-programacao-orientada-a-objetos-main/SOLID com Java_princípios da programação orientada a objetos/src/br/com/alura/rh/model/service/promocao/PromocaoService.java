package br.com.alura.rh.model.service.promocao;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class PromocaoService {
	
	public void promover(Funcionario funcionario, boolean metaBatida) {
		if(funcionario.getCargo() == Cargo.GERENTE) {
			throw new ValidacaoException("Gerentes não podem ser promovidos!");
		}
		
		if(metaBatida) {
			Cargo novoCargo = funcionario.getCargo().getProximoCargo();
			funcionario.promover(novoCargo);
		}else {
			throw new ValidacaoException("Funcionario não bateu a meta!");
		}
	}
	
}
