package beans;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import DAO.AlmocoDAO;
import entidades.Almoco;
import services.AlunoService;

@Named
@ApplicationScoped
public class AlunoBean implements Serializable{
	
	@Inject	
	private AlunoService servico;	
	
	private Almoco almoco; 
	
	private Collection<Almoco> almocos;
	
	private Long idExcluir;
	
	public Almoco getAlmoco() {
		return almoco;
	}

	public void setAlmoco(Almoco almoco) {
		this.almoco = almoco;
	}

	public void setServico(AlunoService servico) {
		this.servico = servico;
	}

	public Collection<Almoco> getAlmocos() {
		return almocos;
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

	public Almoco getEntidade() {
		return almoco;
	}

	public void setEntidade(Almoco entidade) {
		this.almoco = entidade;
	}

	public void setAlmocos(Collection<Almoco> almocos) {
		this.almocos = almocos;
	}

	@PostConstruct
	public void init() {
		almoco = newEntidade();
		almocos = getServico().getAll();
	}

	public void remove(Long id) {
		Almoco almocoN = getServico().getByID(id);
		getServico().remove(almocoN);
		limpar();
	}

	public void save() {
		getServico().save(almoco);
		limpar();
	}

	public void editar(Long id) {
		this.getEntidade().setId(id);
		save();
	}

	public void limpar() {
		almocos = getServico().getAll();
		almoco = newEntidade();
	}

	protected Almoco newEntidade() {
		return new Almoco();
	}

	
}
