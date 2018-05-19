package com.kickhibernate.custombasictype;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.BitSet;

@Entity
public class Product {
    @Id
    private Integer id;

    @Type( type = "bitset" )
    private BitSet bitSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BitSet getBitSet() {
        return bitSet;
    }

    public void setBitSet(BitSet bitSet) {
        this.bitSet = bitSet;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", bitSet=" + bitSet +
                '}';
    }
}
