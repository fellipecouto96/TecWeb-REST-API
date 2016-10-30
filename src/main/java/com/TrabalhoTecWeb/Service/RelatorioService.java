package com.TrabalhoTecWeb.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrabalhoTecWeb.DTO.ClienteIngressoRelatorioClienteDTO;
import com.TrabalhoTecWeb.DTO.ClienteIngressoRelatorioDTO;
import com.TrabalhoTecWeb.DTO.RelatorioClienteDTO;
import com.TrabalhoTecWeb.DTO.RelatorioEventoDTO;
import com.TrabalhoTecWeb.Model.Cliente;
import com.TrabalhoTecWeb.Model.CompraIngresso;
import com.TrabalhoTecWeb.Model.Evento;
import com.TrabalhoTecWeb.Model.Ingresso;
import com.TrabalhoTecWeb.Repository.CompraingressoRepository;

@Service
public class RelatorioService {

	@Autowired
	CompraingressoRepository compraingressoRepository;
	
	public RelatorioEventoDTO gerarDadosRelatorio(Integer codEvento){
		List<CompraIngresso> listaResultado = compraingressoRepository.gerarDadosRelatorioEvento(codEvento);
		RelatorioEventoDTO dto = agruparListaResultado(listaResultado,codEvento);
		return dto;
	}

	private RelatorioEventoDTO agruparListaResultado(List<CompraIngresso> listaResultado, Integer codEvento) {
		if(listaResultado == null || listaResultado.isEmpty()){
			return null;
		}
		Map<Integer,RelatorioEventoDTO> mapaAgrupador= new HashMap<Integer,RelatorioEventoDTO>();
		for (CompraIngresso compraIngresso : listaResultado) {
			Integer idEvento = compraIngresso.getIngresso().getEvento().getId();
			if(mapaAgrupador.get(idEvento) == null){
				//não existe no mapa
				mapaAgrupador.put(idEvento, criarRelatorioEventoDTO(compraIngresso));
			}else{
				//existe no mapa
				 RelatorioEventoDTO relatorioEventoDTO = mapaAgrupador.get(idEvento);
				 relatorioEventoDTO.getListaClienteIngresso().add(criarListaIngressoCliente(compraIngresso));
			}
		}
		return mapaAgrupador.get(codEvento);
	}

	private RelatorioEventoDTO criarRelatorioEventoDTO(CompraIngresso compraIngresso) {
		RelatorioEventoDTO dto = new RelatorioEventoDTO();
		Evento evento = compraIngresso.getIngresso().getEvento();
		dto.setNomeEvento(evento.getNome());
		dto.setDataEvento(evento.getData().toString());
		dto.setHoraEvento(evento.getHora().toString());
		dto.setCepEvento(evento.getLocal().getCep());
		dto.setLogradouroEvento(evento.getLocal().getLogradouro());
		dto.setNumeroEvento(evento.getLocal().getNumero());
		dto.setBairroEvento(evento.getLocal().getBairro());
		dto.setCidadeEvento(evento.getLocal().getCidade());
		dto.setEstadoEvento(evento.getLocal().getEstado());
		dto.setComplementoEvento(evento.getLocal().getComplemento());
		List<ClienteIngressoRelatorioDTO> lista = new ArrayList<ClienteIngressoRelatorioDTO>();
		lista.add(criarListaIngressoCliente(compraIngresso));
		dto.setListaClienteIngresso(lista);
		return dto;
	}

	private ClienteIngressoRelatorioDTO criarListaIngressoCliente(CompraIngresso compraIngresso) {
		ClienteIngressoRelatorioDTO clienteIngressoRelatorio = new ClienteIngressoRelatorioDTO();
		Cliente cliente = compraIngresso.getCompra().getCliente();
		Ingresso ingresso = compraIngresso.getIngresso();
		clienteIngressoRelatorio.setIdCliente(cliente.getId());
		clienteIngressoRelatorio.setNomeCliente(cliente.getNome());
		clienteIngressoRelatorio.setTelefoneCliente(clienteIngressoRelatorio.getTelefoneCliente());
		clienteIngressoRelatorio.setEmailCliente(cliente.getEmail());
		clienteIngressoRelatorio.setCodIngresso(ingresso.getId());
		clienteIngressoRelatorio.setSetorIngresso(ingresso.getSetor());
		clienteIngressoRelatorio.setLoteIngresso(ingresso.getLote());
		clienteIngressoRelatorio.setMeiaEntrada(ingresso.getMeiaEntrada());
		clienteIngressoRelatorio.setValorIngresso(ingresso.getValor());
		clienteIngressoRelatorio.setQuantidadeIngressos(compraIngresso.getQuantidade());
		return clienteIngressoRelatorio;
		
	}
	
	public Collection<RelatorioClienteDTO> gerarDadosRelatorioCliente(Integer codCliente){
		List<CompraIngresso> listaResultado = compraingressoRepository.gerarDadosRelatorioCliente(codCliente);
		Collection<RelatorioClienteDTO> dto = agruparListaResultadoCliente(listaResultado,codCliente);
		return dto;
	}
	
	private Collection<RelatorioClienteDTO> agruparListaResultadoCliente(List<CompraIngresso> listaResultado, Integer codCliente) {
		if(listaResultado == null || listaResultado.isEmpty()){
			return null;
		}
		Map<Integer,RelatorioClienteDTO> mapaAgrupador= new HashMap<Integer,RelatorioClienteDTO>();
		for (CompraIngresso compraIngresso : listaResultado) {
			Integer idEvento = compraIngresso.getIngresso().getEvento().getId();
			if(mapaAgrupador.get(idEvento) == null){
				//não existe no mapa
				mapaAgrupador.put(idEvento, criarRelatorioClienteDTO(compraIngresso));
			}else{
				//existe no mapa
				RelatorioClienteDTO relatorioClienteDTO = mapaAgrupador.get(idEvento);
				 relatorioClienteDTO.getListaClienteIngresso().add(criarListaIngressoRelatorioCliente(compraIngresso));
			}
		}
		return mapaAgrupador.values();
	}
	private RelatorioClienteDTO criarRelatorioClienteDTO(CompraIngresso compraIngresso) {
		RelatorioClienteDTO dto = new RelatorioClienteDTO();
		Evento evento = compraIngresso.getIngresso().getEvento();
		dto.setNomeEvento(evento.getNome());
		dto.setDataEvento(evento.getData().toString());
		dto.setHoraEvento(evento.getHora().toString());
		dto.setCepEvento(evento.getLocal().getCep());
		dto.setLogradouroEvento(evento.getLocal().getLogradouro());
		dto.setNumeroEvento(evento.getLocal().getNumero());
		dto.setBairroEvento(evento.getLocal().getBairro());
		dto.setCidadeEvento(evento.getLocal().getCidade());
		dto.setEstadoEvento(evento.getLocal().getEstado());
		dto.setComplementoEvento(evento.getLocal().getComplemento());
		List<ClienteIngressoRelatorioClienteDTO> lista = new ArrayList<ClienteIngressoRelatorioClienteDTO>();
		lista.add(criarListaIngressoRelatorioCliente(compraIngresso));
		dto.setListaClienteIngresso(lista);
		return dto;
	}
	private ClienteIngressoRelatorioClienteDTO criarListaIngressoRelatorioCliente(CompraIngresso compraIngresso) {
		ClienteIngressoRelatorioClienteDTO clienteIngressoRelatorio = new ClienteIngressoRelatorioClienteDTO();
		Ingresso ingresso = compraIngresso.getIngresso();
		clienteIngressoRelatorio.setCodIngresso(ingresso.getId());
		clienteIngressoRelatorio.setSetorIngresso(ingresso.getSetor());
		clienteIngressoRelatorio.setLoteIngresso(ingresso.getLote());
		clienteIngressoRelatorio.setMeiaEntrada(ingresso.getMeiaEntrada());
		clienteIngressoRelatorio.setValorIngresso(ingresso.getValor());
		clienteIngressoRelatorio.setQuantidadeIngressos(compraIngresso.getQuantidade());
		return clienteIngressoRelatorio;
		
	}
}
