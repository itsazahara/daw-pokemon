package com.daw_pokemon.persistence.crud;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daw_pokemon.persistence.entities.Pokemon;

public interface PokemonCrudRepository extends CrudRepository<Pokemon, Integer>{
	
	List<Pokemon> findByNumeroPokedex (Integer numeroPokedex);
	List<Pokemon> findByFechaCapturaBetween(LocalDateTime fechaCaptura);
	List<Pokemon> findByTipo1orTipo2(String tipo1, String tipo2);

}
