package br.com.jpa.domain;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.persistence.Table;

import br.com.jpa.dao.Persistente;

@Entity
@Table(name = "TB_Produto")
public class Produto implements Persistente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prod_seq")
	@SequenceGenerator(name="prod_seq", sequenceName="sq_produto", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "Nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "Código", nullable = false, unique = true)
	private String codigo;
	
	@Column(name = "Descrição", length = 200, nullable = false)
	private String descricao;
	
	@Column(name = "Valor", nullable = false)
	private BigDecimal valor;
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setId(Long id) {
	    this.id = id;
		
	}
	
	

}
