package com.Cockroach.service;

import com.Cockroach.Observer.CafeConnectSubject;
import com.Cockroach.model.Cafe;
import com.Cockroach.model.CafeStudent;
import com.Cockroach.model.Student;
import com.Cockroach.repo.CafeStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CafeStudentService {
    private final CafeStudentRepo cafeStudentRepo;
    private static CafeConnectSubject cafeConnectSubject;

    @Autowired
    public CafeStudentService(CafeStudentRepo cafeStudentRepo, CafeConnectSubject cafeConnectSubject) {
        this.cafeStudentRepo = cafeStudentRepo;
        CafeStudentService.cafeConnectSubject = cafeConnectSubject;
    }
    public List<Long> getCafeByStudentId(Long student_id){
        return cafeStudentRepo.getCafeByStudentId(student_id);
    }
    public List<Long> getStudentByCafeId(Long cafe_id){
        try {
            List<Long> student_id_list = cafeStudentRepo.getStudentByCafeId(cafe_id);
            logMessage("Successfully retrieved students subscribed to a cafe.");
            return student_id_list;
        } catch (Exception e) {
            logMessage("Error retrieving students subscribed to a cafe. " + e.getMessage());
        }
        return null;
    }
    public void saveEntry(Long cafeId, Long studentId){
        try {
            cafeStudentRepo.save(new CafeStudent(cafeId, studentId));
            logMessage("Successfully saved entry for cafeId: " + cafeId + " and studentId: " + studentId);
        } catch (Exception e) {
            logMessage("Error saving entry: " + e.getMessage());
        }
    }
    @Transactional
    public void deleteEntry(Long cafeId, Long studentId){
        try {
            cafeStudentRepo.deleteEntry(cafeId, studentId);
            logMessage("Successfully deleted entry for cafeId: " + cafeId + " and studentId: " + studentId);
        } catch (Exception e) {
            logMessage("Error deleting entry: " + e.getMessage());
        }
    }
    private static void logMessage(String message) {
        // Trigger the event and notify observers
        CafeStudentService.cafeConnectSubject.setMessage(message);
    }
    public void notifyStudents(Long cafeId, String message){
        List<Long> student_id_list = getStudentByCafeId(cafeId);
        Cafe cafe = CafeService.getCafeById(String.valueOf(cafeId));
        String response = "";
        for(Long student_id : student_id_list){
            Student student = StudentService.getStudentById(student_id);
            logMessage("Cafe_Name : " + cafe.getName()  + "\n"+ "Sent the Message: " + message + "\n" +
                    "To Student : " + student.getStudent_name());
            logMessage("Notified all Observers");
            logMessage("------------------------------------------");
        }
    }
}
