package com.escaravellovermello.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.escaravellovermello.constant.ModelResult;
import com.escaravellovermello.constant.Utils;
import com.escaravellovermello.constant.ViewConstant;
import com.escaravellovermello.converter.ClientConverter;
import com.escaravellovermello.entity.Client;
import com.escaravellovermello.model.ClientModel;
import com.escaravellovermello.service.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {

	public static final Log LOG = LogFactory.getLog(ClientController.class);

	@Autowired
	@Qualifier("clientServiceImplementation")
	private ClientService clientService;
	
	@Autowired
	@Qualifier("clientConverter")
	private ClientConverter clientConverter;
	
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
	
	
	@PostMapping("/addclient")
	public ModelAndView addClient(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult) {
		ModelResult mr = ModelResult.ADD_FAIL;
		ModelAndView mav = new ModelAndView("redirect:"+ViewConstant.R_CLIENTS_LIST);
		
		//Errors before insert
		bindingResult = getErrosFromFields(client, bindingResult);
		if(bindingResult.hasErrors()) {
			LOG.info("METHOD: addClient() -- HAS ERROR: Error=" + bindingResult.toString());
			mav.setViewName(ViewConstant.CLIENT_FORM);
			return mav;
		}
			
		//Insert
		if (null != clientService.addClient(clientConverter.entity2model(client))) {
			mr = ModelResult.ADD_OK;
		}
		mav.addObject("result", mr.getValue());
		LOG.info("METHOD: addClient() -- PARAMS: ClientModel=" + client.toString() + " -- RESULT: " + mr);
		LOG.info("Redirect to " + ViewConstant.R_CLIENTS_LIST);
		return mav;
	}
	

	@GetMapping("/showclients")
	public ModelAndView showClients(@ModelAttribute("result") String result) {
		 ModelAndView mav = new ModelAndView(ViewConstant.CLIENTS);
		 mav.addObject("clients", clientService.listAllClients());
		 mav.addObject("result", result);
		 return mav;
	}
	
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:" + ViewConstant.R_CLIENTS_LIST;
	}
	
	@GetMapping("/removeclient")
	public ModelAndView removecontact(@RequestParam(name = "id", required = true) Integer id) {
		ModelAndView mav = new ModelAndView("redirect:"+ViewConstant.R_CLIENTS_LIST);
		ModelResult mr = ModelResult.REMOVE_FAIL;
		if(clientService.removeClient(id)) {
			mr = ModelResult.REMOVE_OK;
		}
		
		mav.addObject("result", mr.getValue());
		LOG.info("METHOD: removecontact() -- PARAMS: id=" + id +" --- RESULT: "+mr);
		return showClients(mr.getValue());
	}
	
	
	private BindingResult getErrosFromFields(Client client, BindingResult bindingResult) {
		if(!client.getEmail().isEmpty()) {
			String emailRegex = "^((\"[\\w-\\s]+\")|([\\w-]+(?:\\.[\\w-]+)*)|(\"[\\w-\\s]+\")([\\w-]+(?:\\.[\\w-]+)*))(@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$)|(@\\[?((25[0-5]\\.|2[0-4][0-9]\\.|1[0-9]{2}\\.|[0-9]{1,2}\\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\]?$)";
			bindingResult = Utils.validateFormWhithPattern(emailRegex,client.getEmail(), bindingResult, "client", "email", "Formato de email erróneo");
			if(!client.getEmail().isEmpty() && null != clientService.getClientByEmail(client.getEmail())){
				Utils.duplicatedField(bindingResult, "client", "email", "Ya existe un usuario con este email");
			}
		}
		
		if(!client.getPhone().isEmpty()) {
			bindingResult = Utils.validateFormWhithPattern("^(\\d{9})$", client.getPhone(), bindingResult, "client", "phone", "Formato de teléfono erróneo");
			if(null != clientService.getClientByPhone(client.getPhone())) {
				Utils.duplicatedField(bindingResult, "client", "phone", "Ya existe un usuario con este teléfono");
			}
		}
		
		if(client.getZipCode() != null) {
			bindingResult = Utils.validateFormWhithPattern("^(\\d{5})$", client.getZipCode().toString(), bindingResult, "client", "zipCode", "Formato de código postal erróneo");
		}
		return bindingResult;
	}
	

}
