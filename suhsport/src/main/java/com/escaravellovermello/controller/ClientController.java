package com.escaravellovermello.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.escaravellovermello.constant.ViewConstant;
import com.escaravellovermello.model.ClientModel;
import com.escaravellovermello.service.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {

	public static final Log LOG = LogFactory.getLog(ClientController.class);
	
	@Autowired
	@Qualifier("clientServiceImplementation")
	private ClientService clientService;
	
	@GetMapping("/clientform")
	public String showClientForm(@RequestParam(name = "id", required=false, defaultValue="0") Integer id, Model model) {
		ClientModel clientModel = new ClientModel();
		if(id != 0) {
			clientModel = clientService.getClientModelById(id);
		}
		model.addAttribute("client", clientModel);
		LOG.info("Returning to " + ViewConstant.CLIENT_FORM +": "+clientModel.toString());
		return ViewConstant.CLIENT_FORM;
	}
	
	
}
