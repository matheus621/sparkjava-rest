package com.matheus.sparkjavarest.services;

import java.util.Collection;
import java.util.HashMap;

import com.matheus.sparkjavarest.entities.Carro;

public class CarroServices {

	private int id = 0;
	
	private HashMap<String, Carro> carroHashMap = new HashMap<>();

	private Carro put;
	
	public Carro save(Carro carro) {
		carro.setId(getNextId());
		return carroHashMap.put(String.valueOf(carro.getId()), carro);
	}
	
	public Carro update(Carro carro, int id) {
		Carro carroToUpdate = findById(id);
		
		
		carroToUpdate.setNome(carro.getNome());
		carroToUpdate.setModelo(carro.getModelo());
		carroToUpdate.setFabricacao(carro.getFabricacao());
		
		
		return carroToUpdate;
	}
	
	public void remove(int id) {
		carroHashMap.remove(String.valueOf(id));
	}

	private int getNextId() {
		
		return ++this.id;
	}
	
	public Carro findById(int id) {
		return carroHashMap.get(String.valueOf(id));
	}
	
	public Collection<Carro> listAll(){
		return carroHashMap.values();
	}
	
	
}
