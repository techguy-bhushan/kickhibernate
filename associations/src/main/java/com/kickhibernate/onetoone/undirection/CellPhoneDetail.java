package com.kickhibernate.onetoone.undirection;

import javax.persistence.*;

@Entity
public class CellPhoneDetail {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private CellPhoneType cellPhoneType;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CellPhoneType getCellPhoneType() {
        return cellPhoneType;
    }

    public void setCellPhoneType(CellPhoneType cellPhoneType) {
        this.cellPhoneType = cellPhoneType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CellPhoneDetail{" +
                "id=" + id +
                ", cellPhoneType=" + cellPhoneType +
                ", description='" + description + '\'' +
                '}';
    }
}
