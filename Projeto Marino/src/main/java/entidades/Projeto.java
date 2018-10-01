package entidades;

import exceptions.AlunoExistenteException;
import exceptions.CpfNullException;
import exceptions.CpfProfessorNullException;
import exceptions.DisciplinaExistenteException;
import exceptions.DisciplinaNullException;
import exceptions.IdAlunoNullException;
import exceptions.IdDisciNullException;
import exceptions.IdProfessorNullException;
import exceptions.IdTurmaNullException;
import exceptions.NomeAlunoNullException;
import exceptions.NomeDisciNullException;
import exceptions.NomeProfessorNullException;
import exceptions.NomeTurmaNullException;
import exceptions.ProfessorExistenteException;
import exceptions.ProfessorNullException;
import exceptions.TelefoneNullException;
import exceptions.TelefoneProfessorNullException;
import exceptions.TurmaExistenteException;

public interface Projeto {

	// Aluno\\

	public void addAluno(String nome, Integer telefone, String cpf)
			throws NomeAlunoNullException, TelefoneNullException, CpfNullException, AlunoExistenteException;

	public void removeAluno(Long idAluno) throws IdAlunoNullException;

	public Aluno buscarAluno(String nome) throws NomeAlunoNullException;

	// Disciplina\\

	public void addDisciplina(Professor professor, String nome)
			throws NomeDisciNullException, ProfessorNullException, DisciplinaExistenteException;

	public void RemoveDisciplina(Long idResta) throws IdDisciNullException;

	public Disciplina buscarDisciplina(String nome) throws NomeDisciNullException;

	// Professor\\

	public void addProfessor(String nome, String cpf, int telefone, Disciplina disciplina)
			throws NomeProfessorNullException, CpfProfessorNullException, TelefoneProfessorNullException,
			DisciplinaNullException, ProfessorExistenteException;

	public void RemoveProfessor(Long idProfessor) throws IdProfessorNullException;

	public Professor buscarProfessor(String nome) throws IdProfessorNullException, NomeProfessorNullException;

	// Turma \\

	public void addTurma(String nome, Long idProfessor, Long idDisciplina)
			throws IdProfessorNullException, NomeTurmaNullException, IdDisciNullException, TurmaExistenteException;

	public void RemoveTurma(Long idTurma) throws IdTurmaNullException;

	public Turma buscarTurma(String nome) throws NomeTurmaNullException;

}