**POJO Models**

* The Entity Class of the JPA 2.1 specification defines its requirements for an entity class. Applications that wish to remain portable across JPA providers should adhere to these requirements.

* The entity class must be annotated with the javax.persistence.Entity annotation (or be denoted as such in XML mapping)

* The entity class must have a public or protected no-argument constructor. It may define additional constructors as well.

* The entity class must be a top-level class.

* An enum or interface may not be designated as an entity.

* The entity class must not be final. No methods or persistent instance variables of the entity class may be final.

* If an entity instance is to be used remotely as a detached object, the entity class must implement the Serializable interface.

* Both abstract and concrete classes can be entities. Entities may extend non-entity classes as well as entity classes, and non-entity classes may extend entity classes.

* The persistent state of an entity is represented by instance variables, which may correspond to JavaBean-style properties. An instance variable must be directly accessed only from within the methods of the entity by the entity instance itself. The state of the entity is available to clients only through the entity’s accessor methods (getter/setter methods) or other business methods.

* Hibernate, however, is not as strict in its requirements. The differences from the list above include:

* The entity class must have a no-argument constructor, which may be public, protected or package visibility. It may define additional constructors as well.

* The entity class need not be a top-level class.

* Technically Hibernate can persist final classes or classes with final persistent state accessor (getter/setter) methods. However, it is generally not a good idea as doing so will stop Hibernate from being able to generate proxies for lazy-loading the entity.

* Hibernate does not restrict the application developer from exposing instance variables and reference them from outside the entity class itself. The validity of such a paradigm, however, is debatable at best.

