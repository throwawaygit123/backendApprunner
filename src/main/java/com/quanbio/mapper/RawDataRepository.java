package com.quanbio.mapper;

import java.util.Optional;

import com.quanbio.model.RawData;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RawDataRepository extends JpaRepository<RawData, Long> {
	
	public boolean existsByPatientId(Long patientId);
	public Optional<RawData> findByPatientId(Long patientId);
	
}
