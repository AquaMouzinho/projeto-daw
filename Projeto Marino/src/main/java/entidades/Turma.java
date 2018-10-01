package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity

public class Turma implements Identificavel {

	@Id
	@GeneratedValue(generator = "turma_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "turma_seq")
	private Long id;

	private String nome;

	private Long idProfessor;
	private Long idDisciplina;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
	}

	public Long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	//To String
	
	public Turma() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Turma(Long id, String nome, Long idProfessor, Long idDisciplina) {
		super();
		this.id = id;
		this.nome = nome;
		this.idProfessor = idProfessor;
		this.idDisciplina = idDisciplina;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", nome=" + nome + ", idProfessor=" + idProfessor + ", idDisciplina=" + idDisciplina
				+ "]";
	}

}
