package com.softexpert.rafael.desafiobackend.service;

import com.softexpert.rafael.desafiobackend.model.DescontoDespesa;
import com.softexpert.rafael.desafiobackend.model.type.TipoDescontoDespesaEnum;
import com.softexpert.rafael.desafiobackend.model.type.TipoValorEnum;
import com.softexpert.rafael.desafiobackend.repository.DescontoDespesaRepository;
import com.softexpert.rafael.desafiobackend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescontoDespesaService {

    @Autowired
    DescontoDespesaRepository descontoDespesaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public DescontoDespesa addDescontoDespesa(DescontoDespesa descontoDespesa) {
        try {
            DescontoDespesa newDescontoDespesa;

            if (descontoDespesa.getTipoDescontoDespesa() == TipoDescontoDespesaEnum.desconto) {
                Double valorDesconto = (-1) * descontoDespesa.getValor();
                newDescontoDespesa = descontoDespesaRepository.save(new DescontoDespesa(descontoDespesa.getDescricao(), valorDesconto, descontoDespesa.getTipoValor(), descontoDespesa.getTipoDescontoDespesa(), descontoDespesa.getIdTransacao()));
            } else {
                newDescontoDespesa = descontoDespesaRepository.save(new DescontoDespesa(descontoDespesa.getDescricao(), descontoDespesa.getValor(), descontoDespesa.getTipoValor(), descontoDespesa.getTipoDescontoDespesa(), descontoDespesa.getIdTransacao()));
            }
            return newDescontoDespesa;
        } catch (Exception e) {
            throw e;
        }
    }

    public Double calculaTotalDescontosEDespesas(Double totaTransacao, int idTransacao) {
        List<DescontoDespesa> descDesp = descontoDespesaRepository.findByIdTransacao(idTransacao);

        for (DescontoDespesa dd : descDesp) {
            if (dd.getTipoValor().equals(TipoValorEnum.percentual)) {
                dd.setValor(dd.getValor() / 100 * totaTransacao);
                descontoDespesaRepository.save(dd);
            }
        }

        return descontoDespesaRepository.selectTotal(idTransacao) == null ? 0 : descontoDespesaRepository.selectTotal(idTransacao);
    }

}
