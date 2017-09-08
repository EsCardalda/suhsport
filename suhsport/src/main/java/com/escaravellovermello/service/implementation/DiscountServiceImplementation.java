package com.escaravellovermello.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.escaravellovermello.controller.DiscountConverter;
import com.escaravellovermello.entity.Discount;
import com.escaravellovermello.model.DiscountModel;
import com.escaravellovermello.repository.DiscountRepository;
import com.escaravellovermello.service.DiscountService;

@Service("discountServiceImplementation")
public class DiscountServiceImplementation implements DiscountService{

	@Autowired
	@Qualifier("discountConverter")
	private DiscountConverter discountConverter;
	
	@Autowired
	@Qualifier("discountRepository")
	private DiscountRepository discountRepository;
			
	@Override
	public List<DiscountModel> listAllDiscounts() {
		List<DiscountModel> discountModeList = new ArrayList<>();
		List<Discount> discountList = discountRepository.findAll();
		for (Discount discount : discountList) {
			discountModeList.add(discountConverter.entity2model(discount));
		}
		return discountModeList;
	}

	
}
