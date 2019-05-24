package com.matheus.sparkjavarest.controller;

import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.server.Response;

import com.google.gson.Gson;
import com.matheus.sparkjavarest.entities.Carro;
import com.matheus.sparkjavarest.services.CarroServices;
import com.matheus.sparkjavarest.utils.Padrao;
import com.matheus.sparkjavarest.utils.Status;

import static spark.Spark.*;

public class CarroController {

	
	public static void main(String[] args) {
		
		CarroServices carroServices = new CarroServices();
		final String CONTENT_TYPE = "application/json";
		
		post("/carros", (request, response) -> {
			response.type(CONTENT_TYPE);
			
			Carro carro = new Gson().fromJson(request.body(), Carro.class);
			carro = carroServices.save(carro);
			
			
			return new Gson().toJson(new Padrao(Status.SUCCESS, new Gson().toJsonTree(carro)));	
			
		});
		
		get("/carros", (request, response) -> {
			response.type(CONTENT_TYPE);
			
			return new Gson().toJson(new Padrao(Status.SUCCESS, new Gson().toJsonTree(carroServices.listAll())));	
		});
	
		get("/carros/:id", (request, response) -> {
			response.type(CONTENT_TYPE);
			int id = Integer.parseInt(request.params(":id"));
			
			return new Gson().toJson(new Padrao(Status.SUCCESS, new Gson().toJsonTree(carroServices.findById(id))));	
		});
		
		put("/carros/:id", (request, response) -> {
			response.type(CONTENT_TYPE);
			int id = Integer.parseInt(request.params(":id"));
			
			Carro carro = new Gson().fromJson(request.body(), Carro.class);
			Carro carroPut = carroServices.update(carro, id);
			
			if(carroPut != null) {
				return new Gson().toJson(new Padrao(Status.SUCCESS, new Gson().toJsonTree(carroPut)));	
			}
			return new Gson().toJson(new Padrao(Status.ERROR,"Carro null"));	
		});
	
		delete("/carros/:id", (request, response) -> {
			response.type(CONTENT_TYPE);
			int id = Integer.parseInt(request.params(":id"));
			
			carroServices.remove(id);
			
			return new Gson().toJson(new Padrao(Status.SUCCESS,"Carro deletado com sucesso"));
		});
	}
	
}
