package com.services.admin_nation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculeService {
	@Autowired
	private VehiculeRepository vr;
	
	public List<Vehicule> displayData(){
		return vr.findAll();
		
	}
	
	public void saveData(Vehicule v) {
		Vehicule r=new Vehicule(v.getId(),v.getMatricule(),v.getMarque(),v.getProprietaire());
		vr.save(r);
	}
	
	public Optional<Vehicule> findDataById(String id) {
		return vr.findById(id);
			
	}
	
	public void updateData(String id,String matricule, String marque) {
		Vehicule v= vr.getById(id);
		v.setMatricule(matricule);
		v.setMarque(marque);
		vr.save(v);
	}
	
	public void deleteData(String id) {
		 vr.deleteById(id);
			
	}

}
