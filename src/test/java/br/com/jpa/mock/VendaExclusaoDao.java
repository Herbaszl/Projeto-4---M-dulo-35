package br.com.jpa.mock;

import br.com.jpa.dao.IVendaDao;
import br.com.jpa.dao.generics.GenericDao;
import br.com.jpa.domain.Venda;
import br.com.jpa.exceptions.DAOException;
import br.com.jpa.exceptions.TipoChaveNaoEncontradaException;

public class VendaExclusaoDao extends GenericDao<Venda, Long> implements IVendaDao  {
	
	public VendaExclusaoDao() {
		super(Venda.class);
	}

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {

		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");

	}

	@Override
	public Venda consultarComCollection(Long id) {

		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");

	
	}
}
