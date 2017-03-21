We can map collection elements of Persistent class in Hibernate. You need to declare the type of collection in Persistent class from one of the following types:

    java.util.List
    java.util.Set
    java.util.SortedSet
    java.util.Map
    java.util.SortedMap
    java.util.Collection
    or write the implementation of org.hibernate.usertype.UserCollectionType



Basically defines a many-valued association with one-to-many multiplicity. If the collection is defined using generics to specify the element type,
the associated target entity type need not be specified; otherwise the target entity class must be specified. If the relationship is bidirectional,
the mappedBy element must be used to specify the relationship field or property of the entity that is the owner of the relationship.
The OneToMany annotation may be used within an embeddable class contained within an entity class to specify a relationship to a collection of entities.
If the relationship is bidirectional, the mappedBy element must be used to specify the relationship field or property of the entity that is the owner of the relationship.
 When the collection is a java.util.Map, the cascade element and the orphanRemoval element apply to the map value.

Example 1: One-to-Many association using generics

    // In Customer class:

    @OneToMany(cascade=ALL, mappedBy="customer")
    public Set<Order> getOrders() { return orders; }

    In Order class:

    @ManyToOne
    @JoinColumn(name="CUST_ID", nullable=false)
    public Customer getCustomer() { return customer; }
