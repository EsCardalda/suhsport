package com.escaravellovermello.converter;

import org.springframework.stereotype.Component;

import com.escaravellovermello.entity.Fee;
import com.escaravellovermello.model.FeeModel;

@Component("feeConverter")
public class FeeConvert {

	public FeeModel entity2model(Fee fee) {
		FeeModel feeModel = new FeeModel();
		feeModel.setId(fee.getId());
		feeModel.setActive(fee.isActive());
		feeModel.setChildren(fee.isChildren());
		feeModel.setDays(fee.getDays());
		feeModel.setMorning_afternoon(fee.getMorning_afternoon());
		feeModel.setName(fee.getName());
		feeModel.setPrice(fee.getPrice());
		return feeModel;
	}
	
	public Fee model2entity(FeeModel feeModel) {
		Fee fee = new Fee();
		fee.setId(feeModel.getId());
		fee.setActive(feeModel.isActive());
		fee.setChildren(feeModel.isChildren());
		fee.setDays(feeModel.getDays());
		fee.setMorning_afternoon(feeModel.getMorning_afternoon());
		fee.setName(feeModel.getName());
		fee.setPrice(feeModel.getPrice());
		return fee;
	}
}
