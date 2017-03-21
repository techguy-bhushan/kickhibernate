package com.kickwithhibernate.generatorclassesinhibernate.assigned;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by bhushan on 8/3/17.
 * Assigned : It is the default generator strategy if there is no <generator> element . In this case, application assigns the id.
 * Developer should assign the identifier value to entity object before saving into the database.
 * Assigned generator configuration in hibernate mapping file.
 * <id name="id" column="id">
 <generator class="assigned"/>
 </id>
 OR
 <id name="id" column="id">
 <generator class="org.hibernate.id.Assigned"/>
 </id>
 OR
 <id name="id" column="id"/>
 *But here we are using annotations so in this case use @Generated annotation and set it's value assigned
 */
@Entity
public class Assigned {
    @Id
    @GeneratedValue(generator = "assigned")
    @GenericGenerator(name = "assigned", strategy = "assigned")
    private long id;

    public Assigned() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
