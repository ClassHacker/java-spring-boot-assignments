/*package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HoldingServices {

	@Autowired
	private HoldingRepository holdingRepo;
	
	public Holding createHoldings(Holding holding) {
		Optional<Holding> db = holdingRepo.findById(holding.getHoldingId());
		if(db.isPresent())
			return db.get();
		return holdingRepo.save(holding);
	}
	
}

*/