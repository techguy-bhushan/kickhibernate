package com.kickhibernate.onetoone.undirection;

import javax.persistence.*;

@Entity
public class CellPhone {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "Phone_Detail")
    private CellPhoneDetail cellPhoneDetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CellPhoneDetail getCellPhoneDetail() {
        return cellPhoneDetail;
    }

    public void setCellPhoneDetail(CellPhoneDetail cellPhoneDetail) {
        this.cellPhoneDetail = cellPhoneDetail;
    }

    @Override
    public String toString() {
        return "CellPhone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cellPhoneDetail=" + cellPhoneDetail +
                '}';
    }
}
