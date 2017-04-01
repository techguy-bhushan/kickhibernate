package com.kickwithhibernate.entitymapping.collectionmapping.one2many.another;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by bhushan on 19/3/17.
 */
@Entity
public class Node implements Serializable {
    private static final long serialVersionUID = 2907865024015050297L;
    @Id
    @GeneratedValue
    private Long id;

    private Date updateDate;

    @OneToMany(targetEntity = NodeRecord.class, mappedBy = "node")
    List<NodeRecord> nodeRecords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<NodeRecord> getNodeRecord() {
        return nodeRecords;
    }

    public void setNodeRecords(List<NodeRecord> nodeRecord) {
        this.nodeRecords = nodeRecord;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
