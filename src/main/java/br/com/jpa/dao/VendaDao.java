package br.com.jpa.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.jpa.dao.generics.GenericDao;
import br.com.jpa.domain.Cliente;
import br.com.jpa.domain.Produto;
import br.com.jpa.domain.ProdutoQuantidade;
import br.com.jpa.domain.Venda;
import br.com.jpa.exceptions.DAOException;
import br.com.jpa.exceptions.TipoChaveNaoEncontradaException;

public class VendaDao extends GenericDao<Venda, Long> implements IVendaDao {

    public VendaDao() {
        super(Venda.class);
    }

    @Override
    public Venda cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
        try {
            openConnection();

            Cliente clienteManaged = entityManager.find(Cliente.class, entity.getCliente().getId());
            if (clienteManaged == null) {
                throw new DAOException("Cliente não encontrado ou ID nulo para associação na venda.", null);
            }
            entity.setCliente(clienteManaged);

            entity.getProdutos().forEach(item -> {
                if (item.getProduto().getId() != null) {
                    Produto produtoManaged = entityManager.find(Produto.class, item.getProduto().getId());
                    if (produtoManaged == null) {
                        throw new RuntimeException("Produto não encontrado com ID: " + item.getProduto().getId());
                    }
                    item.setProduto(produtoManaged);
                } else {
                }
                
                item.setVenda(entity); 
            });
            
            entityManager.persist(entity);

            entityManager.getTransaction().commit();
            closeConnection();
            return entity;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            closeConnection();
            throw new DAOException("ERRO SALVANDO VENDA", e);
        }
    }

    @Override
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        super.alterar(venda);
    }

    @Override
    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        super.alterar(venda);
    }

    @Override
    public void excluir(Venda entity) throws DAOException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public Venda consultarComCollection(Long id) {
        openConnection();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Venda> query = builder.createQuery(Venda.class);
        Root<Venda> root = query.from(Venda.class);
        root.fetch("cliente");
        root.fetch("produtos");
        query.select(root).where(builder.equal(root.get("id"), id));
        TypedQuery<Venda> tpQuery = entityManager.createQuery(query);
        Venda venda = tpQuery.getSingleResult();
        closeConnection();
        return venda;
    }
}