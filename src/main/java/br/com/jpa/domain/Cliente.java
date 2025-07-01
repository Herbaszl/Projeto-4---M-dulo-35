package br.com.jpa.domain;

import javax.persistence.*;

import br.com.jpa.dao.Persistente;

@Entity
@Table(name="TB_CLIENTE")
public class Cliente implements Persistente {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_seq")
	@SequenceGenerator(name="cliente_seq", sequenceName="sq_cliente", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "Nome", length= 50, nullable = false)
	private String nome; 
	
	@Column(name = "CPF", nullable = false, unique = true)
	private Long cpf;
	
	@Column(name = "TEL", nullable = false)
	private Long tel;
	
	@Column(name = "Endereco", length = 100, nullable = false)
	private String end;
	
	@Column (name = "Numero", nullable = false)
	private Integer numero;
	
	@Column (name = "Cidade", length = 100, nullable = false)
	private String cidade;
	
	@Column (name = "Estado", length =100, nullable = false)
	private String estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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


