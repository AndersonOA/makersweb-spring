/**
 * 
 */
package br.com.makersweb.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

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
@Table(name = "tb_usuario")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Usuario extends DefaultDomain implements Serializable {

	private static final long serialVersionUID = 5347168209229579649L;

	@Column(name = "nome", nullable = false, length = 150)
	private String nome;

	@Column(name = "email", nullable = false, unique = true, length = 255)
	private String email;

	@Column(name = "senha", length = 256)
	@ColumnTransformer(write = "SHA2(?, 256)")
	private String senha;

	@Column(name = "enable", columnDefinition = "BOOLEAN")
	private Boolean enable;

	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao;

	@Column(name = "data_ultimo_login")
	private LocalDateTime dataUltimoLogin;

	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "perfil_id")
	private Perfil perfils;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the enable
	 */
	public Boolean getEnable() {
		return enable;
	}

	/**
	 * @param enable
	 *            the enable to set
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	/**
	 * @return the dataCriacao
	 */
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * @param dataCriacao
	 *            the dataCriacao to set
	 */
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 * @return the dataUltimoLogin
	 */
	public LocalDateTime getDataUltimoLogin() {
		return dataUltimoLogin;
	}

	/**
	 * @param dataUltimoLogin
	 *            the dataUltimoLogin to set
	 */
	public void setDataUltimoLogin(LocalDateTime dataUltimoLogin) {
		this.dataUltimoLogin = dataUltimoLogin;
	}

	/**
	 * @return the perfils
	 */
	public Perfil getPerfils() {
		return perfils;
	}

	/**
	 * @param perfils
	 *            the perfils to set
	 */
	public void setPerfils(Perfil perfils) {
		this.perfils = perfils;
	}

}
