package com.Cockroach.service;

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
    @Autowired
    public CafeStudentService(CafeStudentRepo cafeStudentRepo) {
        this.cafeStudentRepo = cafeStudentRepo;
    }
    public List<Long> getCafeByStudentId(Long student_id){
        return cafeStudentRepo.getCafeByStudentId(student_id);
    }
    public List<Long> getStudentByCafeId(Long cafe_id){
        return cafeStudentRepo.getStudentByCafeId(cafe_id);
    }
    public void saveEntry(Long cafeId, Long studentId){
        cafeStudentRepo.save(new CafeStudent(cafeId, studentId));
    }
    @Transactional
    public void deleteEntry(Long cafeId, Long studentId){
        cafeStudentRepo.deleteEntry(cafeId, studentId);
    }
    public void notifyStudents(Long cafeId, String message){
        List<Long> student_id_list = getStudentByCafeId(cafeId);
        Cafe cafe = CafeService.getCafeById(String.valueOf(cafeId));
        String response = "";
        for(Long student_id : student_id_list){
            Student student = StudentService.getStudentById(student_id);
            System.out.println("Cafe_Name : " + cafe.getName()  + "\n"+ "Sent the Message: " + message + "\n" +
                   "To Student : " + student.getStudent_name());
            System.out.println("------------------------------------------");
        }
    }
}
