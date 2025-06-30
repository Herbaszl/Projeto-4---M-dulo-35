package br.com.jpa.dao;
import br.com.jpa.dao.generics.*;
import br.com.jpa.domain.Venda;
import br.com.jpa.exceptions.*;

public interface IVendaDao extends IGenericDao<Venda, Long>{

	
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

	public Venda consultarComCollection(Long id);
}
