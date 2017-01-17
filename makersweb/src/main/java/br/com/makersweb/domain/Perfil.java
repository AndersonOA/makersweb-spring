/**
 * 
 */
package br.com.makersweb.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author anderson.aristides
 *
 */
@Entity
@Table(name = "tb_perfil")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Perfil extends DefaultDomain implements Serializable {

	private static final long serialVersionUID = 1928914461850599686L;

	@Column(name = "perfil", nullable = false, length = 50)
	private String perfil;

	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "perfils")
	private Set<Role> role;

	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfils")
	private Set<Usuario> usuarios;

	/**
	 * @return the perfil
	 */
	public String getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil
	 *            the perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	/**
	 * @return the role
	 */
	public Set<Role> getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Set<Role> role) {
		this.role = role;
	}

	/**
	 * @return the usuarios
	 */
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios
	 *            the usuarios to set
	 */
	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
