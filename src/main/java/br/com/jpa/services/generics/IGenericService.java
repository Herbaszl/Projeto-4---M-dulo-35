package br.com.jpa.services.generics;

import java.io.Serializable;
import java.util.Collection;

import br.com.jpa.dao.Persistente;
import br.com.jpa.exceptions.DAOException;
import br.com.jpa.exceptions.MaisDeUmRegistroException;
import br.com.jpa.exceptions.TableException;
import br.com.jpa.exceptions.TipoChaveNaoEncontradaException;

public interface IGenericService <T extends Persistente, E extends Serializable> {

    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public void excluir(T entity) throws DAOException;
    
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;

    public Collection<T> buscarTodos() throws DAOException;

}
