package DAO;

import java.util.List;

import entidades.Aluno;
import filtros.AlunoFiltro;

public class AlunoDAO extends DAO<Aluno> {
	
	public AlunoDAO() {
		super(Aluno.class);
	}

	public List<Aluno> findBy(AlunoFiltro filtro) {
		return null;
	}
	
}
