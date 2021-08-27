package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
	public List<Time> listaDeTimes = new ArrayList<>();
	public List<Jogador> listaDeJogadores = new ArrayList<>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) throws IdentificadorUtilizadoException {
		if (verificaTime(id)) {
			throw new IdentificadorUtilizadoException();
		};

		Time novoTime = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		listaDeTimes.add(novoTime);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if(!verificaTime(idTime)) {
			throw new TimeNaoEncontradoException();
		}
		if(verificaJogador(id)) {
			throw new IdentificadorUtilizadoException();
		}

		Jogador novoJogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		listaDeJogadores.add(novoJogador);
	}

	// set team captain
	public void definirCapitao(Long idJogador) {
		if(!verificaJogador(idJogador)) {
			throw new JogadorNaoEncontradoException();
		}
		for (Jogador jogador:listaDeJogadores) {
			if (jogador.getIdJogador().equals(idJogador)) {
				jogador.setCapitao();
			}
		}
	}

	// find id of team captain
	public Long buscarCapitaoDoTime(Long idTime) {
		if (!verificaTime(idTime)) {
			throw new TimeNaoEncontradoException();
		}
		for (Jogador jogador:listaDeJogadores) {
			if (jogador.getIdTime().equals(idTime) && jogador.isCapitao()) {
				return jogador.getIdJogador();
			}
		}
		throw new CapitaoNaoInformadoException();
	}

	public String buscarNomeJogador(Long idJogador) {
		for (Jogador jogador:listaDeJogadores) {
			if (jogador.getIdJogador().equals(idJogador)) {
				return jogador.getNome();
			}
		}
		throw new JogadorNaoEncontradoException();
	}

	public String buscarNomeTime(Long idTime) {
				for (Time time:listaDeTimes) {
			if (time.getId().equals(idTime)) {
				return time.getNome();
			}
		}
		throw new TimeNaoEncontradoException();
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		if (!verificaTime(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		BigDecimal maiorSalario = BigDecimal.valueOf(0.00);
		Jogador jogadorComMaiorSalario = null;

		for (Jogador jogador:listaDeJogadores) {
			if (jogador.getIdTime().equals(idTime)) {
				if (jogador.getSalario().compareTo(maiorSalario) > 0) {
					jogadorComMaiorSalario = jogador;
					maiorSalario = jogador.getSalario();
				}
			}
		}

		assert jogadorComMaiorSalario != null;
		return jogadorComMaiorSalario.getIdJogador();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		for (Jogador jogador:listaDeJogadores) {
			if (jogador.getIdJogador().equals(idJogador)) {
				return jogador.getSalario();
			}
		}
		throw new JogadorNaoEncontradoException();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if (!verificaTime(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		List<Long> jogadoresDoTime = new ArrayList<>();

		for (Jogador jogador:listaDeJogadores) {
			if (jogador.getIdTime().equals(idTime)) {
				jogadoresDoTime.add(jogador.getIdJogador());
			}
		}

		return jogadoresDoTime;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if (!verificaTime(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		Jogador melhorJogador = null;
		Integer nivelDeHabilidade = 0;

		for (Jogador jogador:listaDeJogadores) {
			if (jogador.getIdTime().equals(idTime)) {
				if (jogador.getNivelHabilidade() > nivelDeHabilidade) {
					melhorJogador = jogador;
					nivelDeHabilidade = jogador.getNivelHabilidade();
				}
			}
		}

		assert melhorJogador != null;
		return melhorJogador.getIdJogador();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		if (!verificaTime(idTime)) {
			throw new TimeNaoEncontradoException();
		}

		Jogador jogadorMaisVelho = null;
		int idadeJogadorMaisVelho = 0;

		for (Jogador jogador:listaDeJogadores) {
			if (jogador.getIdTime().equals(idTime)) {
				int idadeJogador = Period.between(jogador.getDataNascimento(), LocalDate.now()).getYears();
				if (idadeJogador > idadeJogadorMaisVelho) {
					jogadorMaisVelho = jogador;
					idadeJogadorMaisVelho = idadeJogador;
				}
			}
		}

		assert jogadorMaisVelho != null;
		return jogadorMaisVelho.getIdJogador();
	}

	public List<Long> buscarTimes() {
		List<Long> idTimes = new ArrayList<>();
		for (Time time:listaDeTimes) {
			idTimes.add(time.getId());
		}

		return idTimes;
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> topJogadores = new ArrayList<>();
		if (listaDeJogadores.size() == 0) {
			return topJogadores;
		}

		// top player by hability
		List<Jogador> jogadoresPorNivelDeHabilidade = listaDeJogadores.stream()
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed()
						.thenComparing(Jogador::getIdJogador)).collect(Collectors.toList());

		for (int i = 0; i < top; i++) {
			topJogadores.add(jogadoresPorNivelDeHabilidade.get(i).getIdJogador());
		}

		return topJogadores;
	}

	// check if team is registered
	public boolean verificaTime(Long id) {
		Optional<Time> result = listaDeTimes.stream()
				.filter(time -> Objects.equals(time.getId(), id))
				.findFirst();

		return result.isPresent();
	}

	// check if captain is registered
	public boolean verificaJogador(Long id) {
		Optional<Jogador> result = listaDeJogadores.stream()
				.filter(jogador -> Objects.equals(jogador.getIdJogador(), id))
				.findFirst();

		return result.isPresent();
	}

}
