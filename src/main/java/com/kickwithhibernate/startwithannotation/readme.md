**Hibernate Annotations** are based on the **JPA 2 specification** and supports all the features.

- All the JPA annotations are defined in the javax.persistence.* package.
- Hibernate EntityManager implements the interfaces and life cycle defined by the JPA specification.
- The core advantage of using hibernate annotation is that you don't need to create mapping (hbm) file.
- Here, hibernate annotations are used to provide the meta data.



# @Entity:
**package:** javax.persistence.Entity<br/>
**content:** Which java bean we want to persist in database, add @Entity annotation on it.

```
@Entity
public class User {....}
```

# @Table:
**package:** javax.persistence.Table<br/>
**content:** Specifies the primary table for the annotated entity. Additional tables may be specified using SecondaryTable or SecondaryTables annotation. <br/>
If no Table annotation is specified for an entity class, the default values apply.

```
@Entity
@Table(name="CUST", schema="RECORDS")
public class Customer { ... }
```

 # @Column:
**package:** javax.persistence.Column<br/>
**content:** It is used to specify the mapped column for a persistent property or field.

```
@Column(name = "email_address", nullable = true, length = 120)
private String emailAddress;
```

# @Id:
**package:** javax.persistence.Id<br/>
**content:** Specifies the primary key of an entity.

```
@Id
private Long id;
```

 # @GeneratedValue:
**package:** javax.persistence.GeneratedValue<br/>
**content:** Provides for the specification of generation strategies for the values of primary keys. <br/>
Default strategy is GenerationType.AUTO.

```
@Id
@GeneratedValue
private Long id;
```

# @Version:
**package:** javax.persistence.Version<br/>
**content:** Specifies the version field or property of an entity class that serves as its optimistic lock value. <br/>
The version is used to ensure integrity when performing the merge operation and for optimistic concurrency control.

```
@Version
private Long version;
```

# @OrderBy:
**package:** javax.persistence.OrderBy<br/>
**content:** Specifies the ordering of the elements of a collection valued association or element collection at the point when the association or collection is retrieved.

```
@OrderBy("createdOn desc")
private List<Book> books;
```

# @Transient:
**package:** javax.persistence.Transient<br/>
**content:** @Transient annotation is used to indicate that a field is not to be persisted in the database.

```
@Transient
private String confirmPassword;
```

# @Lob:
**package:** import javax.persistence.Lob <br/>
**content:** @Lob used to specifies that a persistent property or field should be persisted as a large object to a database-supported large object type.

```
@Lob
protected String report;

@Lob
protected byte[] pic;
```

# Hibernate Inheritance Mapping Annotations

# @Inheritance:
**package:** javax.persistence.Inheritance<br/>
**content:** Defines the inheritance strategy to be used for an entity class hierarchy. <br/>
        It is specified on the entity class that is the root of the entity class hierarchy. <br/>
        If the Inheritance annotation is not specified or if no inheritance type is specified for an entity class hierarchy, the SINGLE_TABLE mapping strategy is used.
```
@Inheritance(strategy= InheritanceType.JOINED)
public class Employee {}
```

# @DiscriminatorColumn:
**package:** javax.persistence.DiscriminatorColumn<br/>
**content:** It Is used to define the discriminator column for the SINGLE_TABLE and JOINED inheritance mapping strategies.<br/>
        The strategy and the discriminator column are only specified in the root of an entity class hierarchy or subhierarchy in which a different inheritance strategy is applied. <br/>
        If the DiscriminatorColumn annotation is missing, and a discriminator column is required, the name of the discriminator column defaults to "DTYPE" and the discriminator type to DiscriminatorType.STRING.

```
Example:
@Entity
@Table(name="CUST")
@Inheritance(strategy=SINGLE_TABLE)
@DiscriminatorColumn(name="DISC", discriminatorType=STRING,length=20)
public class Customer { ... }

@Entity
public class ValuedCustomer extends Customer { ... }
```

# @DiscriminatorValue:
**package:** javax.persistence.DiscriminatorValue <br/>
**content:** Is used to specify the value of the discriminator column for entities of the given type.<br/>
        The DiscriminatorValue annotation can only be specified on a concrete entity class.<br/>
        If the DiscriminatorValue annotation is not specified and a discriminator column is used, a provider-specific function will be used to generate a value representing the entity type. If the DiscriminatorType is STRING, the discriminator value default is the entity name.

```
@Entity
@Table(name="CUST")
@Inheritance(strategy=SINGLE_TABLE)
@DiscriminatorColumn(name="DISC", discriminatorType=STRING,length=20)
@DiscriminatorValue("CUSTOMER")
public class Customer { ... }

@Entity
@DiscriminatorValue("VCUSTOMER")
public class ValuedCustomer extends Customer { ... }
```

# @PrimaryKeyJoinColumn:
**package:** javax.persistence.PrimaryKeyJoinColumn <br/>
**content:** This annotation specifies a primary key column that is used as a foreign key to join to another table.<br/>
        It is used to join the primary table of an entity subclass in the JOINED mapping strategy to the primary table of its superclass.<br/>
        it is used within a SecondaryTable annotation to join a secondary table to a primary table.<br/>
        and it may be used in a OneToOne mapping in which the primary key of the referencing entity is used as a foreign key to the referenced entity.<br/>
        If no PrimaryKeyJoinColumn annotation is specified for a subclass in the JOINED mapping strategy, the foreign key columns are assumed to have the same names as the primary key columns of the primary table of the superclass.

```
//Example: Customer and ValuedCustomer subclass

@Entity
@Table(name="CUST")
@Inheritance(strategy=JOINED)
@DiscriminatorValue("CUST")
public class Customer { ... }

@Entity
@Table(name="VCUST")
@DiscriminatorValue("VCUST")
@PrimaryKeyJoinColumn(name="CUST_ID")
public class ValuedCustomer extends Customer { ... }
```

# @JoinColumn:
**package:** javax.persistence.JoinColumn <br/>
**content:** Specifies a column for joining an entity association or element collection.<br/>
        If the JoinColumn annotation itself is defaulted, a single join column is assumed and the default values apply.
```
@ManyToOne
@JoinColumn(name="ADDR_ID")
public Address getAddress() { return address; }
```

# @JoinTable:
**package:** javax.persistence.JoinTable <br/>
**content:** Used in the mapping of associations. It is specified on the owning side of an association.<br/>
        A join table is typically used in the mapping of many-to-many and unidirectional one-to-many associations.<br/>
        It may also be used to map bidirectional many-to-one/one-to-many associations, unidirectional many-to-one relationships, and one-to-one associations (both bidirectional and unidirectional).<br/>
        When a join table is used in mapping a relationship with an embeddable class on the owning side of the relationship, the containing entity rather than the embeddable class is considered the owner of the relationship.<br/>
        If the JoinTable annotation is missing, the default values of the annotation elements apply.<br/>
        The name of the join table is assumed to be the table names of the associated primary tables concatenated together (owning side first) using an underscore.
```
@JoinTable(
        name="CUST_PHONE",
        joinColumns=
        @JoinColumn(name="CUST_ID", referencedColumnName="ID"),
        inverseJoinColumns=
        @JoinColumn(name="PHONE_ID", referencedColumnName="ID")
)
```

# @MapsId:
**package:** javax.persistence.MapsId <br/>
**content:** Designates a ManyToOne or OneToOne relationship attribute that provides the mapping for an EmbeddedId primary key, an attribute within an EmbeddedId primary key, or a simple primary key of the parent entity.<br/>
        The value element specifies the attribute within a composite key to which the relationship attribute corresponds.<br/>
        If the entity's primary key is of the same Java type as the primary key of the entity referenced by the relationship, the value attribute is not specified.
        
```
// parent entity has simple primary key
@Entity
public class Employee {
    @Id long empId;
    String name;
    ...
}

// dependent entity uses EmbeddedId for composite key
@Embeddable
public class DependentId {
    String name;
    long empid;   // corresponds to primary key type of Employee
}


@Entity
public class Dependent {
    @EmbeddedId DependentId id;
    ...
    @MapsId("empid")  //  maps the empid attribute of embedded id
    @ManyToOne Employee emp;
}
```

# Hibernate Association Mapping Annotations

# @OneToOne:
**package:** javax.persistence.OneToOne <br/>
**content:** This annotation defines a single-valued association to another entity that has one-to-one multiplicity.<br/>
        It is not normally necessary to specify the associated target entity explicitly since it can usually be inferred from the type of the object being referenced.

```
@Entity
public class User {
    @OneToOne
    private UserProfile userProfile;
}
```

# @ManyToOne:
**package:** javax.persistence.ManyToOne <br/>
**content:** Defines a single-valued association to another entity class that has many-to-one multiplicity.<br/>
        It is not normally necessary to specify the target entity explicitly since it can usually be inferred from the type of the object being referenced. If the relationship is bidirectional, the non-owning OneToMany entity side must used the mappedBy element to specify the relationship field or property of the entity that is the owner of the relationship.<br/>
        The ManyToOne annotation may be used within an embeddable class to specify a relationship from the embeddable class to an entity class.<br/>
        If the relationship is bidirectional, the non-owning OneToMany entity side must use the mappedBy element of the OneToMany annotation to specify the relationship field or property of the embeddable field or property on the owning side of the relationship.<br/>
        The dot (".") notation syntax must be used in the mappedBy element to indicate the relationship attribute within the embedded attribute. The value of each identifier used with the dot notation is the name of the respective embedded field or property.
```
@ManyToOne(optional=false)
@JoinColumn(name="CUST_ID", nullable=false, updatable=false)
public Customer getCustomer() { return customer; }
```

# @OneToMany:
**package:** javax.persistence.OneToMany <br/>
**content:** defines a many-valued association with one-to-many multiplicity. If the collection is defined using generics to specify the element type, the associated target entity type need not be specified; otherwise the target entity class must be specified. If the relationship is bidirectional, the mappedBy element must be used to specify the relationship field or property of the entity that is the owner of the relationship.<br/>
        The OneToMany annotation may be used within an embeddable class contained within an entity class to specify a relationship to a collection of entities. If the relationship is bidirectional,
        the mappedBy element must be used to specify the relationship field or property of the entity that is the owner of the relationship.<br/>
        When the collection is a java.util.Map, the cascade element and the orphanRemoval element apply to the map value.

```
Example 1: One-to-Many association using generics

// In Customer class:
@OneToMany(cascade=ALL, mappedBy="customer")
public Set<Order> getOrders() { return orders; }

//In Order class:
@ManyToOne
@JoinColumn(name="CUST_ID", nullable=false)
public Customer getCustomer() { return customer; }
```

# @ManyToMany:
**package:** javax.persistence.ManyToMany <br/>
**content:** Defines a many-valued association with many-to-many multiplicity.<br/>
        Every many-to-many association has two sides, the owning side and the non-owning, or inverse, side. The join table is specified on the owning side. If the association is bidirectional, either side may be designated as the owning side. If the relationship is bidirectional, the non-owning side must use the mappedBy element of the ManyToMany annotation to specify the relationship field or property of the owning side.<br/>
        The join table for the relationship, if not defaulted, is specified on the owning side.<br/>
        The ManyToMany annotation may be used within an embeddable class contained within an entity class to specify a relationship to a collection of entities. If the relationship is bidirectional and the entity containing the embeddable class is the owner of the relationship, the non-owning side must use the mappedBy element of the ManyToMany annotation to specify the relationship field or property of the embeddable class.<br/>
        The dot (".") notation syntax must be used in the mappedBy element to indicate the relationship attribute within the embedded attribute.<br/>
        The value of each identifier used with the dot notation is the name of the respective embedded field or property.

```
// In Customer class:
@ManyToMany
@JoinTable(name="CUST_PHONES")
public Set<PhoneNumber> getPhones() { return phones; }

// In PhoneNumber class:
@ManyToMany(mappedBy="phones")
public Set<Customer> getCustomers() { return customers; }
```
