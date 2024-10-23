package com.daw_pokemon.service.dto;

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
	
	public Optional<Pokemon> getPokemon(int idPokemon){
		return this.pokemonCrudRepository.findById(idPokemon);
	}
	
	public Pokemon crearPokemon(Pokemon pokemon) {
        return pokemonCrudRepository.save(pokemon);
    }
	
	/*FALTA MODIFICAR POKEMONS*/
	
	public boolean delete (int idPokemon) {
		boolean res = false;
		
		if (this.pokemonCrudRepository.findById(idPokemon).isPresent()) {
			this.pokemonCrudRepository.deleteById(idPokemon);
			res = true;
		}
		return res;
	}
	
	/*FALTA TERMINAR EL SERVICE*/
	

}
