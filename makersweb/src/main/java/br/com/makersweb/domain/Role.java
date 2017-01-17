/**
 * 
 */
package br.com.makersweb.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "tb_role")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Role extends DefaultDomain implements Serializable {

	private static final long serialVersionUID = 6695475997837986006L;

	@Column(name = "role", nullable = false, length = 50)
	private String role;

	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_perfil_role", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
			@JoinColumn(name = "perfil_id") })
	private Set<Perfil> perfils;

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the perfils
	 */
	public Set<Perfil> getPerfils() {
		return perfils;
	}

	/**
	 * @param perfils
	 *            the perfils to set
	 */
	public void setPerfils(Set<Perfil> perfils) {
		this.perfils = perfils;
	}

}
