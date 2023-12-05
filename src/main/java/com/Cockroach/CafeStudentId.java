package com.Cockroach;

import java.io.Serializable;
import java.util.Objects;

public class CafeStudentId implements Serializable {

    private Long cafe_id;
    private Long student_id;

    // Constructors, getters, and setters...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CafeStudentId that = (CafeStudentId) o;
        return Objects.equals(cafe_id, that.cafe_id) &&
                Objects.equals(student_id, that.student_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cafe_id, student_id);
    }
}
