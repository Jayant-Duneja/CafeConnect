package com.Cockroach.model;
import com.Cockroach.CafeStudentId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "student_cafe")
@IdClass(CafeStudentId.class)
public class CafeStudent{
    @Id
    @Column(name = "cafe_id")
    private Long cafe_id;

    @Id
    @Column(name = "student_id")
    private Long student_id;

    // Other fields or relationships...

    public CafeStudent() {
        // Default constructor
    }

    public CafeStudent(Long cafeId, Long observerId) {
        this.cafe_id = cafeId;
        this.student_id = observerId;
    }

    public Long getCafeId() {
        return cafe_id;
    }

    public void setCafeId(Long cafeId) {
        this.cafe_id = cafeId;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long observerId) {
        this.student_id = observerId;
    }
}
