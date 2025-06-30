package br.com.jpa.domain;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name = "TB_PRODUTO_QUANTIDADE")
public class ProdutoQuantidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_qtd_seq")
    @SequenceGenerator(name = "prod_qtd_seq", sequenceName = "sq_prod_qtd", initialValue = 1, allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Produto produto;

    @Column(name = "Quantidade", nullable = false)
    private Integer quantidade = 0; 

    @Column(name = "Valor_Total", nullable = false)
    private BigDecimal valorTotal = BigDecimal.ZERO;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_venda_fk",
            foreignKey = @ForeignKey(name = "fk_prod_qtd_venda"),
            referencedColumnName = "id", nullable = false)
    private Venda venda;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = (quantidade != null) ? quantidade : 0;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = (valorTotal != null) ? valorTotal : BigDecimal.ZERO;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public void adicionar(Integer qtd) {
        if (qtd == null || qtd <= 0) return;

        this.quantidade += qtd;
        BigDecimal novoValor = this.produto.getValor().multiply(BigDecimal.valueOf(qtd));
        this.valorTotal = this.valorTotal.add(novoValor);
    }

    public void remover(Integer qtd) {
        if (qtd == null || qtd <= 0 || qtd > this.quantidade) return;

        this.quantidade -= qtd;
        BigDecimal valorRemovido = this.produto.getValor().multiply(BigDecimal.valueOf(qtd));
        this.valorTotal = this.valorTotal.subtract(valorRemovido);
    }
}
