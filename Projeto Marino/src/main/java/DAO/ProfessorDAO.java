package DAO;

import java.util.List;

import entidades.Professor;
import filtros.ProfessorFiltro;

public class ProfessorDAO extends DAO<Professor>{

	public ProfessorDAO() {
		super(Professor.class);
	}

	public List<Professor> findBy(ProfessorFiltro filtro) {
		return null;
	}
	
}
