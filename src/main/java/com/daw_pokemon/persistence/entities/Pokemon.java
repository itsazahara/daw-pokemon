package com.daw_pokemon.persistence.entities;

import java.time.LocalDateTime;

import com.daw_pokemon.persistence.entities.enumerados.Capturado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemon")

public class Pokemon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	
	@Column(name = "numero_pokedex")
	private Integer numeroPokedex;
	
	private String tipo1;
	private String tipo2;
	
	@Column(name = "puntos_salud")
	private Integer puntosSalud;
	
	@Column(name = "fecha_captura")
	private LocalDateTime fechaCaptura;
	
	@Enumerated(EnumType.STRING)
	private Capturado capturado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumeroPokedex() {
		return numeroPokedex;
	}

	public void setNumeroPokedex(Integer numeroPokedex) {
		this.numeroPokedex = numeroPokedex;
	}

	public String getTipo1() {
		return tipo1;
	}

	public void setTipo1(String tipo1) {
		this.tipo1 = tipo1;
	}

	public String getTipo2() {
		return tipo2;
	}

	public void setTipo2(String tipo2) {
		this.tipo2 = tipo2;
	}

	public Integer getPuntosSalud() {
		return puntosSalud;
	}

	public void setPuntosSalud(Integer puntosSalud) {
		this.puntosSalud = puntosSalud;
	}

	public LocalDateTime getFechaCaptura() {
		return fechaCaptura;
	}

	public void setFechaCaptura(LocalDateTime fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	public Capturado getCapturado() {
		return capturado;
	}

	public void setCapturado(Capturado capturado) {
		this.capturado = capturado;
	}

}
