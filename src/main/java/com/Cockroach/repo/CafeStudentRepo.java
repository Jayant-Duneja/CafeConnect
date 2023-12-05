package com.Cockroach.repo;

import com.Cockroach.CafeStudentId;
import com.Cockroach.model.Cafe;
import com.Cockroach.model.CafeStudent;
import com.Cockroach.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CafeStudentRepo extends JpaRepository<CafeStudent, CafeStudentId>{

        @Query(value = "SELECT cafe_id FROM defaultdb.student_cafe WHERE student_id = :observerId ;", nativeQuery = true)
        List<Long> getCafeByStudentId(@Param("observerId") Long student_id);
        @Query(value = "SELECT student_id FROM defaultdb.student_cafe WHERE cafe_id = :cafeId ;", nativeQuery = true)
        List<Long> getStudentByCafeId(@Param("cafeId") Long cafe_id);
        @Modifying
        @Query(value =  "DELETE FROM defaultdb.student_cafe WHERE cafe_id = :cafeId AND student_id = :observerId ;", nativeQuery = true)
        void deleteEntry(@Param("cafeId") Long cafeId, @Param("observerId") Long observerId);
}
