package br.com.jpa.dao;

import br.com.jpa.dao.generics.GenericDao;
import br.com.jpa.domain.Produto;

public class ProdutoDao extends GenericDao<Produto, Long> implements IProdutoDao {

	public ProdutoDao() {
		super(Produto.class);
	}

	
}
