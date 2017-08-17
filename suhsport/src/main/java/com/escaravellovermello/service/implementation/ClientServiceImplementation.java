package com.escaravellovermello.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.escaravellovermello.converter.ClientConverter;
import com.escaravellovermello.entity.Client;
import com.escaravellovermello.model.ClientModel;
import com.escaravellovermello.repository.ClientRepository;
import com.escaravellovermello.service.ClientService;

@Service("clientServiceImplementation")
public class ClientServiceImplementation implements ClientService{

	@Autowired
	@Qualifier("clientRepository")
	private ClientRepository clientRepository;
	
	@Autowired
	@Qualifier("clientConverter")
	private ClientConverter clientConverter;
	
	@Override
	public ClientModel addClient(ClientModel clientModel) {
		Client client = clientRepository.save(clientConverter.model2entity(clientModel));
		return clientConverter.entity2model(client);
	}

	@Override
	public List<ClientModel> listAllClients() {
		List<Client> clientList = clientRepository.findAll();
		List<ClientModel> clientModelList = new ArrayList<>();
		for (Client client : clientList) {
			clientModelList.add(clientConverter.entity2model(client));				
		}	
		return clientModelList;
	}

	@Override
	public Client getClientById(Integer id) {
		return clientRepository.findById(id);
	}

	@Override
	public ClientModel getClientModelById(Integer id) {
		return clientConverter.entity2model(getClientById(id));
	}
	

	@Override
	public Client getClientByPhone(String phone) {
		return clientRepository.findByPhone(phone);
	}

	@Override
	public Client getClientByEmail(String email) {
		return clientRepository.findByEmail(email);
	}

	@Override
	public boolean removeClient(Integer id) {
		Client client = getClientById(id);
		if (client != null) {
			clientRepository.delete(client);
			return true;
		}	
		return false;
	}

}
