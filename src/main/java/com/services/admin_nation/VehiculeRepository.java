package com.services.admin_nation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface VehiculeRepository extends JpaRepository<Vehicule, String> {

}
