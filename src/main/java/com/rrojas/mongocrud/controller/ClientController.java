package com.rrojas.mongocrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrojas.mongocrud.model.Client;
import com.rrojas.mongocrud.repository.ClientRepository;

@RestController
@RequestMapping("/api")
public class ClientController {
	
	@Autowired
	ClientRepository clientRepository;
	
	
	@PostMapping("/createClient")
	public String saveClient(@RequestBody Client client) {
		clientRepository.save(client);
		return "Add successfully";
	}
	
	
	@GetMapping("/clients")
	public List<Client> getClients(){
		return clientRepository.findAll();
	}
}
