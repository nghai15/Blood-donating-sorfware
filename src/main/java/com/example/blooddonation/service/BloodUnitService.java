package com.example.blooddonation.service;

import com.example.blooddonation.model.BloodUnit;
import com.example.blooddonation.repository.BloodUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List; 
import java.util.Optional;

@Service
public class BloodUnitService {

    @Autowired
    private BloodUnitRepository bloodUnitRepository;

    public BloodUnit saveBloodUnit(BloodUnit bloodUnit) {
        return bloodUnitRepository.save(bloodUnit);
    }

    public List<BloodUnit> getAllBloodUnits() {
        return bloodUnitRepository.findAll();
    }

    public Optional<BloodUnit> getBloodUnitById(Long id) {
        return bloodUnitRepository.findById(id);
    }

    public void deleteBloodUnit(Long id) {
        bloodUnitRepository.deleteById(id);
    }
}
