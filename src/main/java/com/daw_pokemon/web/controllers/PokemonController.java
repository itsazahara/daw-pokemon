package com.daw_pokemon.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw_pokemon.service.dto.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
	
	@Autowired
	private PokemonService pokemonService;
	
	/*FALTA CONTINUAR EL CONTROLLER*/

}
