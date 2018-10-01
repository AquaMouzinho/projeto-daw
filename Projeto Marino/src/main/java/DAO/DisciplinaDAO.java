package DAO;

import java.util.List;

import entidades.Disciplina;
import filtros.DisciplinaFiltro;

public class DisciplinaDAO extends DAO<Disciplina>{

	public DisciplinaDAO() {
		super(Disciplina.class);
	}

	public List<Disciplina> findBy(DisciplinaFiltro filtro) {
		return null;
	}

}
