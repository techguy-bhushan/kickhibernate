 **Associations**
Associations describe how two or more entities form a relationship based on a database joining semantics.

**@ManyToOne**

@ManyToOne is the most common association, having a direct equivalent in the relational database as well (e.g. foreign key), and so it establishes a relationship between a child entity and a parent.

**Bidirectional @OneToMany**

The bidirectional @OneToMany association also requires a @ManyToOne association on the child side. Although the Domain Model exposes two sides to navigate this association, behind the scenes, the relational database has only one foreign key for this relationship.

Every bidirectional association must have one owning side only (the child side), the other one being referred to as the inverse (or the mappedBy) side.

**@OneToOne**

The @OneToOne association can either be unidirectional or bidirectional. A unidirectional association follows the relational database foreign key semantics, the client-side owning the relationship. A bidirectional association features a mappedBy @OneToOne parent side too.



