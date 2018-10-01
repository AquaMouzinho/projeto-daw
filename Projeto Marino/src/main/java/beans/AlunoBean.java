package beans;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entidades.Aluno;
import services.AlunoService;

@Named
@ApplicationScoped
public class AlunoBean implements Serializable {

	@Inject
	private AlunoService servico;

	private Aluno aluno;

	private Collection<Aluno> alunos;

	private Long idExcluir;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setServico(AlunoService servico) {
		this.servico = servico;
	}

	public Collection<Aluno> getAlunos() {
		return alunos;
	}

	public Long getIdExcluir() {
		return idExcluir;
	}

	public void setIdExcluir(Long idExcluir) {
		this.idExcluir = idExcluir;
	}

	public AlunoService getServico() {
		return servico;
	}

	public Aluno getEntidade() {
		return aluno;
	}

	public void setEntidade(Aluno entidade) {
		this.aluno = entidade;
	}

	public void setAlmocos(Collection<Aluno> alunos) {
		this.alunos = alunos;
	}

	@PostConstruct
	public void init() {
		aluno = newEntidade();
		alunos = getServico().getAll();
	}

	public void remove(Long id) {
		Aluno alunoN = getServico().getByID(id);
		getServico().remove(alunoN);
		limpar();
	}

	public void save() {
		getServico().save(aluno);
		limpar();
	}

	public void editar(Long id) {
		this.getEntidade().setId(id);
		save();
	}

	public void limpar() {
		alunos = getServico().getAll();
		aluno = newEntidade();
	}

	protected Aluno newEntidade() {
		return new Aluno();
	}

}
