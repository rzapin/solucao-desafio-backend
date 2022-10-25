package com.softexpert.rafael.desafiobackend.model;

import com.softexpert.rafael.desafiobackend.model.type.TipoDescontoDespesaEnum;
import com.softexpert.rafael.desafiobackend.model.type.TipoValorEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "desconto_despesa")
public class DescontoDespesa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "tipo_valor")
    @Enumerated(EnumType.STRING)
    private TipoValorEnum tipoValor;

    @Column(name = "tipo_desconto_despesa")
    @Enumerated(EnumType.STRING)
    private TipoDescontoDespesaEnum tipoDescontoDespesa;

    public TipoDescontoDespesaEnum getTipoDescontoDespesa() {
        return tipoDescontoDespesa;
    }

    public void setTipoDescontoDespesa(TipoDescontoDespesaEnum tipoDescontoDespesa) {
        this.tipoDescontoDespesa = tipoDescontoDespesa;
    }

    @Column(name = "id_transacao")
    private int idTransacao;

    public DescontoDespesa(String descricao, Double valor, TipoValorEnum tipoValor, TipoDescontoDespesaEnum tipoDescontoDespesa, int idTransacao) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipoValor = tipoValor;
        this.tipoDescontoDespesa = tipoDescontoDespesa;
        this.idTransacao = idTransacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoValorEnum getTipoValor() {
        return tipoValor;
    }

    public void setTipoValor(TipoValorEnum tipoValor) {
        this.tipoValor = tipoValor;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }
}
