package br.com.jpa.dao;

import br.com.jpa.dao.generics.GenericDao;
import br.com.jpa.domain.Cliente;

public class ClienteDao extends GenericDao<Cliente, Long> implements IClienteDao {
	
	public ClienteDao() {
		super(Cliente.class);
	}   
}
