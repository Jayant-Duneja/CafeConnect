package com.Cockroach.service;

import com.Cockroach.Observer.CafeConnectSubject;
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

        this.cafeRepository = cafeRepository;
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
            logMessage("Successfully retrieved all cafes using a custom query.");
            return cafes;
        } catch (Exception e) {
            logMessage("Error retrieving all cafes using a custom query: " + e.getMessage());
        }
        return null;
    }

    public void saveCafe(Cafe cafe) {
        try {
            cafeRepository.save(cafe);
            logMessage("Successfully saved cafe with ID " + cafe.getCafe_id());
        } catch (Exception e) {
            logMessage("Error while saving cafe: " + e.getMessage());
        }
    }

    public void deleteCafe(Long cafeId) {
        try {
            cafeRepository.deleteById(cafeId);
            logMessage("Successfully deleted cafe with ID " + cafeId);
        } catch (Exception e) {
            logMessage("Error while deleting cafe with ID " + cafeId + ": " + e.getMessage());
        }
    }

    public static Cafe getCafeById(String cafeId) {
        try {
            Cafe cafe = cafeRepository.findById(Long.valueOf(cafeId)).orElse(null);
            if (cafe != null) {
                logMessage("Successfully retrieved cafe for ID " + cafeId);
            } else {
                logMessage("Cafe not found for ID " + cafeId);
            }
            return cafe;
        } catch (Exception e) {
            logMessage("Error while retrieving cafe based on ID " + cafeId + ": " + e.getMessage());
        }
        return null;
    }
    private static void logMessage(String message) {
        // Trigger the event and notify observers
        CafeService.cafeConnectSubject.setMessage(message);
    }
}
