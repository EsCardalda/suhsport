package com.escaravellovermello.converter;

import org.springframework.stereotype.Component;

import com.escaravellovermello.entity.Client;
import com.escaravellovermello.model.ClientModel;

@Component("clientConverter")
public class ClientConverter {

	public Client model2entity(ClientModel clientModel) {
		Client client = new Client();
		client.setId(clientModel.getId());
		client.setFirstName(clientModel.getFirstName());
		client.setLastName1(clientModel.getLastName1());
		client.setLastName2(clientModel.getLastName2());
		client.setEmail(clientModel.getEmail());
		client.setPhone(clientModel.getPhone());
		client.setZipCode(clientModel.getZipCode());
		client.setRegistrationDate(clientModel.getRegistrationDate());
		client.setModificationDate(clientModel.getModificationDate());
		return client;
	}
	
	public ClientModel entity2model(Client client) {
		ClientModel clientModel = new ClientModel();
		clientModel.setId(client.getId());
		clientModel.setFirstName(client.getFirstName());
		clientModel.setLastName1(client.getLastName1());
		clientModel.setLastName2(client.getLastName2());
		clientModel.setEmail(client.getEmail());
		clientModel.setPhone(client.getPhone());
		clientModel.setZipCode(client.getZipCode());
		clientModel.setRegistrationDate(client.getRegistrationDate());
		clientModel.setModificationDate(client.getModificationDate());
		return clientModel;
	}	
}
