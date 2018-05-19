 **Embeddable types**

Historically Hibernate called these components. JPA calls them embeddables. Either way the concept is the same: a composition of values. For example we might have a Name class that is a composition of first-name and last-name, or an Address class that is a composition of street, city, postal code, etc.

Most often, embeddable types are used to group multiple basic type mappings and reuse them across several entities.

JPA defines two terms for working with an embeddable type: @Embeddable and @Embedded. @Embeddable is used to describe the mapping type itself (e.g. Address). @Embedded is for referencing a given embeddable type (e.g. user.address).


Although from an object-oriented perspective, it’s much more convenient to work with embeddable types, this example doesn’t work as-is. When the same embeddable type is included multiple times in the same parent entity type, the JPA specification demands setting the associated column names explicitly.

This requirement is due to how object properties are mapped to database columns. By default, JPA expects a database column having the same name with its associated object property. When including multiple embeddables, the implicit name-based mapping rule doesn’t work anymore because multiple object properties could end-up being mapped to the same database column.

We have a few options to handle this issue.

 **AttributeOverride**

JPA defines the @AttributeOverride annotation to handle this scenario. see in give example in User.java

