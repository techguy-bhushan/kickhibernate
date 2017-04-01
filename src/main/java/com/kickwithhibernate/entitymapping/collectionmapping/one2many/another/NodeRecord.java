package com.kickwithhibernate.entitymapping.collectionmapping.one2many.another;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by bhushan on 19/3/17.
 */
@Entity
public class NodeRecord implements Serializable{
    private static final long serialVersionUID = -2259895475634369594L;
    @Id
    @GeneratedValue
    private Long id;

    private Date createdDate;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="node_id")
    private Node node;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
