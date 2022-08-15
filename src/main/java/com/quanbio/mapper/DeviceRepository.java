package com.quanbio.mapper;

import com.quanbio.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeviceRepository extends JpaRepository<Device, Long> {

}
