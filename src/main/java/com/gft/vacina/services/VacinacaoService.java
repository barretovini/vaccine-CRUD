package com.gft.vacina.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.vacina.entities.Vacinacao;
import com.gft.vacina.repositories.VacinacaoRepository;

@Service
public class VacinacaoService {

	@Autowired
	private VacinacaoRepository vacinacaoRepository;

	public Vacinacao salvarVacinacao(Vacinacao vacinacao) {

		if (vacinacao.getVacina().getDose() == 2) {
			if (vacinacao.getPessoa().getVacinado() == 2) {
				throw new RuntimeException("Pessoa já imunizada.");
			} else {
				// Primeira Dose da Vacina de duas doses
				if (vacinacao.getPessoa().getVacinado() == 0) {
					vacinacao.getPessoa().setVacinado(vacinacao.getPessoa().getVacinado() + 1);
					vacinacao.getPessoa().setVacina(vacinacao.getLote().getVacina());
					vacinacao.getLote().setQuantidadeRestante(vacinacao.getLote().getQuantidadeRestante() - 1);
					return vacinacaoRepository.save(vacinacao);
				} else {
					// Segunda Dose da Vacina de duas doses
					if (vacinacao.getPessoa().getVacina().getId() != vacinacao.getLote().getVacina().getId()) {
						throw new RuntimeException("A vacina da Segunda dose deve ser igual à da Primeira.");
					} else {
						vacinacao.getPessoa().setVacinado(vacinacao.getPessoa().getVacinado() + 1);
						vacinacao.getLote().setQuantidadeRestante(vacinacao.getLote().getQuantidadeRestante() - 1);
						return vacinacaoRepository.save(vacinacao);
					}
				}
			}
		} else {
			if (vacinacao.getPessoa().getVacinado() == 2) {
				throw new RuntimeException("Pessoa já imunizada.");
			} else {
				// Vacina de dose única
				vacinacao.getPessoa().setVacinado(vacinacao.getPessoa().getVacinado() + 2);
				vacinacao.getPessoa().setVacina(vacinacao.getLote().getVacina());
				vacinacao.getLote().setQuantidadeRestante(vacinacao.getLote().getQuantidadeRestante() - 1);
				return vacinacaoRepository.save(vacinacao);
			}
		}
	}

	public List<Vacinacao> listarVacinacao(int vacinado) {

		if (vacinado != 0)
			return findByPessoa_vacinado(vacinado);
		return listarTodasVacinacao();
	}

	private List<Vacinacao> listarTodasVacinacao() {
		return vacinacaoRepository.findAll();
	}

	private List<Vacinacao> findByPessoa_vacinado(int vacinado) {

		return vacinacaoRepository.findByPessoa_vacinado(vacinado);
	}

	public Vacinacao obterVacinacao(Long id) throws Exception {

		Optional<Vacinacao> vacinacao = vacinacaoRepository.findById(id);

		if (vacinacao.isEmpty()) {
			throw new Exception("Vacinação não encontrada");
		}

		return vacinacao.get();

	}

	public void excluirVacinacao(Long id) {

		vacinacaoRepository.deleteById(id);

	}

}