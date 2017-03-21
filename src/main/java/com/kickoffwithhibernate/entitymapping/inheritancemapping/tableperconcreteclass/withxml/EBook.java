package com.kickoffwithhibernate.entitymapping.inheritancemapping.tableperconcreteclass.withxml;

/**
 * Created by bhushan on 12/3/17.
 */
public class EBook extends Book {
    private boolean available;
    private boolean free;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
