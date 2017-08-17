package com.escaravellovermello.service;

import java.util.List;

import com.escaravellovermello.entity.Client;
import com.escaravellovermello.model.ClientModel;

public interface ClientService {
	public abstract ClientModel addClient(ClientModel clientModel);
	public abstract List<ClientModel> listAllClients();
	public abstract Client getClientById(Integer id);
	public abstract Client getClientByPhone(String phone);
	public abstract Client getClientByEmail(String email);
	public abstract ClientModel getClientModelById(Integer id);
	public abstract boolean removeClient(Integer id);
	
}
