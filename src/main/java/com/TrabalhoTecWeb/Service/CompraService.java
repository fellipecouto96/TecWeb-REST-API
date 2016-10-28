package com.TrabalhoTecWeb.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrabalhoTecWeb.Model.Compra;
import com.TrabalhoTecWeb.Model.CompraIngresso;
import com.TrabalhoTecWeb.Model.Ingresso;
import com.TrabalhoTecWeb.Repository.CompraRepository;
import com.TrabalhoTecWeb.Repository.CompraingressoRepository;
import com.TrabalhoTecWeb.Service.Exceptions.ApplicationException;
import com.TrabalhoTecWeb.Service.Exceptions.CampoObrigatorioNaoPreenchidoException;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private IngressoService ingressoService;

	@Autowired
	private ClientesService clienteService;

	@Autowired
	private CompraingressoRepository compraIngressoRepository;

	public Compra salvar(Compra compra) {
		validarIngressos(compra.getListaIngresso());
		clienteService.validarExistenciaCliente(compra.getCliente().getId());

		preencherValorCompra(compra);
		compra.setDataHoraCompra(new Date());

		compra = compraRepository.save(compra);

		salvarEntidadeCompraIngresso(compra);

		return compra;
	}
	/**
	 * Salva a entidade CompraIngresso
	 * @param compra
	 */
	private void salvarEntidadeCompraIngresso(Compra compra) {
		for (Ingresso ingresso : compra.getListaIngresso()) {
			CompraIngresso compraIngresso = new CompraIngresso();
			compraIngresso.setIngresso(ingressoService.obter(ingresso.getId()));
			compraIngresso.setCompra(compra);
			compraIngresso.setQuantidade(ingresso.getQuantidade());
			compraIngressoRepository.save(compraIngresso);
		}
	}

	/** 
	 * Calcula o valor total da compra, calculando a quantidade do ingresso pelo seu valor
	 * @param compra
	 */
	private void preencherValorCompra(Compra compra) {
		compra.setValorCompra(new BigDecimal("0"));
		for (Ingresso ingresso : compra.getListaIngresso()) {
			Ingresso ingressoBase = ingressoService.obter(ingresso.getId());
			BigDecimal valor = ingressoBase.getValor().multiply(new BigDecimal(ingresso.getQuantidade().toString()));
			compra.setValorCompra(compra.getValorCompra().add(valor));
		}
	}

	/**
	 * valida a lista de ingresso nos seguintes passos:<br>
	 * -Os campos Id e quantidade estão preenchidos<br>
	 * -O id informado referencia um ingresso valido no sistema<br>
	 * -Se a quantidade pedida na compra está disponivel para aquele ingresso
	 * 
	 * @param lista
	 * @return Lista de ingressos com toda a entidade carregada para criar as
	 *         entidades compra e compraIngresso
	 */
	private void validarIngressos(List<Ingresso> lista) {
		for (Ingresso ingresso : lista) {
			// valida se preencheu o id e a quantidade no ingresso
			validarCamposNecessariosIngresso(ingresso);

			// valida se o ingresso existe
			ingressoService.validarIngressoExistente(ingresso.getId());

			// obtem o ingresso da base para verificar se a quantidade
			// solicitada na
			// requisição ainda é valida para aquele ingresso
			Ingresso ingressoBase = ingressoService.obter(ingresso.getId());

			if (ingresso.getQuantidade() > ingressoBase.getQuantidade()) {
				throw new ApplicationException(
						"A quantidade de ingressos do setor ".concat(ingressoBase.getSetor()).concat(" do evento ")
								.concat(ingressoBase.getEvento().getNome()).concat(" não está disponível.").concat("Só existem ").
								concat(ingressoBase.getQuantidade().toString()).concat(" disponíveis."));
			}
		}
	}

	/**
	 * Valida se os campos id e quantidade estão preenchidos no ingresso
	 * 
	 * @param ingresso
	 */
	private void validarCamposNecessariosIngresso(Ingresso ingresso) {
		if (ingresso.getId() == null) {
			throw new CampoObrigatorioNaoPreenchidoException("É necessário informar o codigo do ingresso");
		}
		if (ingresso.getQuantidade() == null) {
			throw new CampoObrigatorioNaoPreenchidoException(
					"É necessário informar a quantidade de ingressos que se deseja comprar");
		}

	}

}
