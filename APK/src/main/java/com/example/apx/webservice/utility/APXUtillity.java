package com.example.apx.webservice.utility;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.apx.webservice.domain.api.Account;

@Service
public class APXUtillity {

	public List<Account> sortAccounts(List<Account> accounts, boolean holdingId){
		Account a = null;
		if(holdingId==true) {
			for(int i =0; i<accounts.size();i++) {
				{
					for(int j = 0; j<accounts.get(i).getHolding().size();j++) {
						if(accounts.get(i).getHolding().get(j).getHid()>accounts.get(i+1).getHolding().get(j).getHid()) {
							a = accounts.get(i);
							accounts.set(i,accounts.get(i+1) );
							accounts.set(i+1, a);
						}
					}//for2
				}//for1
			}	
		}
		return accounts;
	}
}
