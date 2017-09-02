package com.escaravellovermello.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.escaravellovermello.constant.ModelResult;
import com.escaravellovermello.constant.ViewConstant;
import com.escaravellovermello.converter.ClientConverter;
import com.escaravellovermello.model.ClientModel;
import com.escaravellovermello.service.ClientService;
import com.escaravellovermello.service.PaymentService;

@Controller()
@RequestMapping("/payments")
public class PaymentsController {

	public static final Log LOG = LogFactory.getLog(ClientController.class);

	@Autowired
	@Qualifier("clientServiceImplementation")
	private ClientService clientService;

	@Autowired
	@Qualifier("clientConverter")
	private ClientConverter clientConverter;

	@Autowired
	@Qualifier("paymentServiceImplementation")
	private PaymentService paymentService;

	@GetMapping("/paymentform/client")
	public ModelAndView showPayments(@ModelAttribute("client")ClientModel clientModel, @ModelAttribute("result") String result) {
		ModelAndView mav = new ModelAndView(ViewConstant.PAYMENTS_FORM);
		ClientModel clientModel2 = new ClientModel();

		if( clientModel.getId() != null ) {
			clientModel2 = clientService.getClientModelById(clientModel.getId());
			mav.addObject("payments", paymentService.listAllPaymentsByClientOrderByDate(clientConverter.model2entity(clientModel2)));
		}
		
		mav.addObject("clients", clientService.listAllClients());
		mav.addObject("result", result);
		LOG.info("Returning to " + ViewConstant.PAYMENTS_FORM + ". Show payments from user " + clientModel2.getId());
		return mav;
	}

	
	@GetMapping("/removepayment")
	public ModelAndView removecontact(@RequestParam(name = "id", required = true) Integer id) {
		ModelAndView mav = new ModelAndView("redirect:"+ViewConstant.R_PAYMENT_FORM);
		ModelResult mr = ModelResult.REMOVE_FAIL;
		if(paymentService.removePayment(id)) {
			mr = ModelResult.REMOVE_OK;
		}
		mav.addObject("result", mr.getValue());
		mav.addObject("clients", clientService.listAllClients());
		LOG.info("METHOD: removepayment() -- PARAMS: id=" + id +" --- RESULT: "+mr);
		return mav;
	}
}
