package com.kickwithhibernate.entitymapping.inheritancemapping.tableperconcreteclass.withxml;

/**
 * Created by bhushan on 12/3/17.
 */
public class PrintedBook extends Book {
    private double weight;
    private boolean bulkyPaperUsed;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isBulkyPaperUsed() {
        return bulkyPaperUsed;
    }

    public void setBulkyPaperUsed(boolean bulkyPaperUsed) {
        bulkyPaperUsed = bulkyPaperUsed;
    }
}
