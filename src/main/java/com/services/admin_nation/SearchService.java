package com.services.admin_nation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
	 @Autowired
	 private SearchVehiculeRepository svr;
	
	List<Vehicule> search_vehicule(String keyName) {
		
		return svr.search_data(keyName);
	}
   
   String nb_vehicule() {
	   return svr.n_b_data();
   }

}
