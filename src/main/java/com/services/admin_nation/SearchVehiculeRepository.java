package com.services.admin_nation;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchVehiculeRepository extends JpaRepository<Vehicule, String> {
 
	@Query(
	        value = "SELECT * FROM vehicule WHERE MATCH(matricule, marque,proprietaire) AGAINST (?1);",
	        nativeQuery = true)
	    public List<Vehicule> search_data(String keyword);
	@Query(
	        value = "SELECT count(id) from vehicule;",
	        nativeQuery = true)
	    public String n_b_data();
     
}
