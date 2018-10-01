package beans;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entidades.Professor;
import services.ProfessorService;

@Named
@ApplicationScoped
public class ProfessorBean implements Serializable {
	
	@Inject
	private ProfessorService service;
	
	private Professor professor; 
	
	private Collection <Professor> professores;
	
	public String getUserLogin() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Principal userPrincipal = externalContext.getUserPrincipal();
		if (userPrincipal == null) {
			return "";
		}
		return userPrincipal.getName();
	}
	
	public void efetuarLogout() throws IOException, ServletException {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		session.invalidate();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		request.logout();
		ec.redirect(ec.getApplicationContextPath());
	}
	
	public boolean isUserInRole(String role) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		return externalContext.isUserInRole(role);
	}
	
	@PostConstruct
	public void init() {
		professor = newEntidade();
		professores = getService().getAll();
	}

	public void remove(Professor entidade) {
		getService().remove(entidade);
		limpar();
	}

	public void save() {
		getService().save(professor);
		limpar();
	}

	public void editar(Long id) {
		this.getProfessor().setId(id);
		save();
	}

	public void limpar() {
		professores = getService().getAll();
		professor = newEntidade();
	}

	protected Professor newEntidade() {
		return new Professor();
	}

	public ProfessorService getService() {
		return service;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Collection<Professor> getBebidas() {
		return professores;
	}
}
