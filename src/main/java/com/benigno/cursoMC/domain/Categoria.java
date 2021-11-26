package com.benigno.cursoMC.domain;

import java.io.Serializable;
import java.util.Objects;

public class Categoria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer Id;
	private String Nome;
	
	
	public Categoria() {
	}


	public Categoria(Integer id, String nome) {
		Id = id;
		Nome = nome;
	}


	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(Id, other.Id);
	}


	@Override
	public String toString() {
		return "Categoria [Id=" + Id + ", Nome=" + Nome + "]";
	}
	
		
	

}
