package com.escaravellovermello.controller;

import org.springframework.stereotype.Component;

import com.escaravellovermello.entity.Discount;
import com.escaravellovermello.model.DiscountModel;

@Component("discountConverter")
public class DiscountConverter {

	public DiscountModel entity2model (Discount discount) {
	 DiscountModel discountModel = new DiscountModel();
	 discountModel.setId(discount.getId());
	 discountModel.setName(discount.getName());
	 discountModel.setQuantity(discount.getQuantity());
	 discountModel.setType(discount.getType());
	 return discountModel;
	}
	
	public Discount model2entity(DiscountModel discountModel) {
		Discount discount = new Discount();
		discount.setId(discountModel.getId());
		discount.setName(discountModel.getName());
		discount.setQuantity(discountModel.getQuantity());
		discount.setType(discountModel.getType());
		return discount;
	}
}
