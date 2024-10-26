package com.daw_pokemon.web.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daw_pokemon.persistence.entities.Pokemon;
import com.daw_pokemon.service.dto.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	private PokemonService pokemonService;

	@GetMapping
	public ResponseEntity<List<Pokemon>> list() {
		return ResponseEntity.ok(this.pokemonService.getAll());
	}

	@GetMapping("/{idPokemon}")
	public ResponseEntity<Pokemon> findOne(@PathVariable("idPokemon") int idPokemon) {
		Optional<Pokemon> pokemon = this.pokemonService.getPokemon(idPokemon);

		if (pokemon.isEmpty()) {
			return ResponseEntity.notFound().build();

		} else {
			return ResponseEntity.ok(this.pokemonService.getPokemon(idPokemon).get());
		}
	}

	@PostMapping
	public ResponseEntity<Pokemon> save(@RequestBody Pokemon pokemon) {
		return new ResponseEntity<Pokemon>(this.pokemonService.save(pokemon), HttpStatus.CREATED);
	}

	@DeleteMapping("/{idPokemon}")
	public ResponseEntity<Pokemon> delete(@PathVariable("idPokemon") int idPokemon) {

		if (this.pokemonService.delete(idPokemon)) {
			return ResponseEntity.ok().build();

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{/numeroPokedex}")
	public ResponseEntity<List<Pokemon>> buscarPorNumeroPokedex(@RequestParam("numeroPokedex") Integer numeroPokedex) {
		return ResponseEntity.ok(this.pokemonService.findByNumeroPokedex(numeroPokedex));
	}
	
	@GetMapping("/fechaCaptura")
	public ResponseEntity<List<Pokemon>> buscarPorFechaCaptura(@RequestParam("fechaCaptura") LocalDateTime fechaCaptura) {
		return ResponseEntity.ok(this.pokemonService.findByFechaCapturaBetween(fechaCaptura));
	}
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Pokemon>> buscarPorTipo(@RequestParam("tipo") String tipo1, String tipo2) {
		return ResponseEntity.ok(this.pokemonService.findByTipo1orTipo2(tipo1, tipo2));
	}
	
	private static int PS_INCREMENTO = 20;
	
	 @PutMapping("/pocion/{id}")
	    public ResponseEntity<Pokemon> darPocion(@PathVariable Integer id) {
	        return pokemonService.aumentarPS(id, PS_INCREMENTO)
	                .map(pokemon -> ResponseEntity.ok().body(pokemon))
	                .orElse(ResponseEntity.notFound().build());
	    }
	
}
