package com.escaravellovermello.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.escaravellovermello.converter.FeeConvert;
import com.escaravellovermello.entity.Fee;
import com.escaravellovermello.model.FeeModel;
import com.escaravellovermello.repository.FeeRepository;
import com.escaravellovermello.service.FeeService;

@Repository("feeServiceImplementation")
public class FeeServiceImplementacion implements FeeService {

	@Autowired
	@Qualifier("feeRepository")
	private FeeRepository feeRepoistory;
	
	@Autowired
	@Qualifier("feeConverter")
	private FeeConvert feeConverter;

	@Override
	public List<FeeModel> listAllFees() {
		List<FeeModel> feeModelList = new ArrayList<>();
		List<Fee> feeList = feeRepoistory.findAll();
		for (Fee fee : feeList) {
			feeModelList.add(feeConverter.entity2model(fee));
		}
		return feeModelList;
	}

}
