package com.Cockroach.service;

import Observer.CafeConnectSubject;
import com.Cockroach.model.Cafe;
import com.Cockroach.repo.CafeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Observable;

@Service
public class CafeService {

    private static CafeRepo cafeRepository;
    private static CafeConnectSubject cafeConnectSubject;

    @Autowired
    public CafeService(CafeRepo cafeRepository, CafeConnectSubject cafeConnectSubject) {
        CafeService.cafeRepository = cafeRepository;
        CafeService.cafeConnectSubject = cafeConnectSubject;
    }

    public List<Cafe> getAllCafes() {
        try {
            List<Cafe> cafes = cafeRepository.findAll();
            logMessage("Successfully retrieved all cafes.");
            return cafes;
        } catch (Exception e) {
            logMessage("Error retrieving all cafes: " + e.getMessage());
        }
        return null;
    }

    public List<Cafe> getAllCafesCustomQuery() {
        try {
            List<Cafe> cafes = cafeRepository.findAllCafesCustomQuery();
            logMessage("Successfully retrieved all cafes using Custom Query.");
            return cafes;
        } catch (Exception e) {
            logMessage("Error retrieving all cafes using Custom Query: " + e.getMessage());
        }
        return null;
    }

    public void saveCafe(Cafe cafe) {
        try {
            cafeRepository.save(cafe);
            logMessage("Successfully saved a Cafe.");
        } catch (Exception e) {
            logMessage("Error while saving a Cafe: " + e.getMessage());
        }
    }

    public void deleteCafe(Long cafeId) {
        try {
            cafeRepository.deleteById(cafeId);
            logMessage("Successfully deleted the Cafe.");
        } catch (Exception e) {
            logMessage("Error while deleting a Cafe: " + e.getMessage());
        }
    }
    public static Cafe getCafeById(String cafeId) {
        try {
            Cafe cafe =  cafeRepository.findById(Long.valueOf(cafeId)).orElse(null);
            logMessage("Successfully got the Cafe for an ID");
            return cafe;
        } catch (Exception e) {
            logMessage("Error while retrieving a Cafe based on ID: " + e.getMessage());
        }
        return null;
    }
    private static void logMessage(String message) {
        // Trigger the event and notify observers
        CafeService.cafeConnectSubject.setMessage(message);
        System.out.println("Notified all Observers");
    }
}
