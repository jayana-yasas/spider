package com.rambo.spider.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pd_cal_general_matrix")
public class PdCalGeneralMatrix {
    private int id;
    private String matrix;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "matrix")
    public String getMatrix() {
        return matrix;
    }

    public void setMatrix(String matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PdCalGeneralMatrix that = (PdCalGeneralMatrix) o;
        return id == that.id &&
                Objects.equals(matrix, that.matrix);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, matrix);
    }
}
