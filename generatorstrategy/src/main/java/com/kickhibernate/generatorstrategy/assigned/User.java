package com.kickhibernate.generatorstrategy.assigned;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
 *But here we are using annotations so in this case use @GenericGenerator annotation and set it's value assigned
 */
public class User {
    @Id
    @GeneratedValue(generator = "assigned")
    @GenericGenerator(name = "assigned", strategy = "assigned")
    private Long id;
    private String name;

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
}
