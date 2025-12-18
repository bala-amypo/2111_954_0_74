package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ShipmentEntity;
import com.example.demo.entity.VehicleEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.repository.VehicleRepository;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final VehicleRepository vehicleRepository;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository,
                               VehicleRepository vehicleRepository) {
        this.shipmentRepository = shipmentRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public ShipmentEntity createShipment(Long vehicleId, ShipmentEntity shipment) {

        VehicleEntity vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle not found"));

        if (shipment.getWeightKg() > vehicle.getCapacityKg()) {
            throw new IllegalArgumentException("Shipment weight exceeds vehicle capacity");
        }

        if (shipment.getScheduledDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Scheduled date cannot be in the past");
        }

        shipment.setVehicle(vehicle);
        return shipmentRepository.save(shipment);
    }

    @Override
    public ShipmentEntity getShipmentById(Long shipmentId) {
        return shipmentRepository.findById(shipmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Shipment not found"));
    }
}
