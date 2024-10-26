package com.daw_pokemon.service.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw_pokemon.persistence.crud.PokemonCrudRepository;
import com.daw_pokemon.persistence.entities.Pokemon;

@Service
public class PokemonService {

	@Autowired
	private PokemonCrudRepository pokemonCrudRepository;

	public List<Pokemon> getAll() {
		return (List<Pokemon>) this.pokemonCrudRepository.findAll();
	}

	public Optional<Pokemon> getPokemon(int idPokemon) {
		return this.pokemonCrudRepository.findById(idPokemon);
	}

	public Pokemon create(Pokemon pokemon) {
		return this.pokemonCrudRepository.save(pokemon);
	}

	public Pokemon save(Pokemon pokemon) {
		return this.pokemonCrudRepository.save(pokemon);
	}

	public boolean delete(int idPokemon) {
		boolean res = false;

		if (this.pokemonCrudRepository.findById(idPokemon).isPresent()) {
			this.pokemonCrudRepository.deleteById(idPokemon);
			res = true;
		}
		return res;
	}

	public List<Pokemon> findByNumeroPokedex(Integer numeroPokedex) {
		return pokemonCrudRepository.findByNumeroPokedex(numeroPokedex);
	}

	public List<Pokemon> findByFechaCapturaBetween(LocalDateTime fechaCaptura) {
		return pokemonCrudRepository.findByFechaCapturaBetween(fechaCaptura);
	}

	public List<Pokemon> findByTipo1orTipo2(String tipo1, String tipo2) {
		return pokemonCrudRepository.findByTipo1orTipo2(tipo1, tipo2);
	}

	public Optional<Pokemon> aumentarPS(Integer id, Integer incremento) {
		return pokemonCrudRepository.findById(id).map(pokemon -> {
			pokemon.setPuntosSalud(pokemon.getPuntosSalud() + incremento);
			return pokemonCrudRepository.save(pokemon);
		});
	}

}
