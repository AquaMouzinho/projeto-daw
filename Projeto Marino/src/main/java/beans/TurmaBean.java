package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entidades.Almoco;
import entidades.Cidade;
import services.AlunoService;
import services.ProfessorService;

@Named
@ViewScoped
public class TurmaBean implements Serializable {
	
	@Inject
	private ProfessorService servico;	
	
	private Cidade cidade; 
	
	private Collection<Cidade> cidades;
	
	public Collection<Cidade> getCidades() {
		return cidades;
	}
	
	public ProfessorService getServico() {
		return servico;
	}
	
	public Cidade getEntidade() {
		return cidade;
	}
	
	public void setEntidade(Cidade entidade) {
		this.cidade = entidade;
	}
	

	public void setCidades(Collection<Cidade> cidades) {
		this.cidades = cidades;
	}

	@PostConstruct
	public void init() {
		cidade = newEntidade();
		cidades = getServico().getAll();
	}

	public void remove(Cidade entidade) {
		getServico().remove(entidade);
		limpar();
	}

	public void save() {
		getServico().save(cidade);
		limpar();
	}

	public void editar(Long id) {
		this.getEntidade().setId(id);
		save();
	}

	public void limpar() {
		cidades = getServico().getAll();
		cidade = newEntidade();
	}

	protected Cidade newEntidade() {
		return new Cidade();
	}
	}
	
	

