package com.Cockroach.service;

import com.Cockroach.model.Cafe;
import com.Cockroach.repo.CafeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeService {

    private final CafeRepo cafeRepository;

    @Autowired
    public CafeService(CafeRepo cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    public List<Cafe> getAllCafes() {
        return cafeRepository.findAll();
    }

    public List<Cafe> getAllCafesCustomQuery() {
        return cafeRepository.findAllCafesCustomQuery();
    }

    public void saveCafe(Cafe cafe) {
        cafeRepository.save(cafe);
    }

    public void deleteCafe(Long cafeId) {
        cafeRepository.deleteById(cafeId);
    }

    public Cafe getCafeById(Long cafeId) {
        return cafeRepository.findById(cafeId).orElse(null);
    }
}
