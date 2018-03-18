**Naming strategies**

Part of the mapping of an object model to the relational database is mapping names from the object model to the corresponding database names. Hibernate looks at this as 2 stage process:

* The first stage is determining a proper logical name from the domain model mapping. A logical name can be either explicitly specified by the user (using @Column or @Table e.g.) or it can be implicitly determined by Hibernate through an ImplicitNamingStrategy contract.

* Second is the resolving of this logical name to a physical name which is defined by the PhysicalNamingStrategy contract.


**ImplicitNamingStrategy**

When an entity does not explicitly name the database table that it maps to, we need to implicitly determine that table name. Or when a particular attribute does not explicitly name the database column that it maps to, we need to implicitly determine that column name. There are examples of the role of the org.hibernate.boot.model.naming.ImplicitNamingStrategy contract to determine a logical name when the mapping did not provide an explicit name.



There are multiple ways to specify the ImplicitNamingStrategy to use. First, applications can specify the implementation using the _**hibernate.implicit_naming_strategy**_ configuration setting which accepts:

pre-defined "short names" for the out-of-the-box implementations

* default
for org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl - an alias for jpa

* jpa
for org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl - the JPA 2.0 compliant naming strategy

* legacy-hbm
for org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyHbmImpl - compliant with the original Hibernate NamingStrategy

* legacy-jpa
for org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl - compliant with the legacy NamingStrategy developed for JPA 1.0, which was unfortunately unclear in many respects regarding implicit naming rules.

* component-path
for org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl - mostly follows ImplicitNamingStrategyJpaCompliantImpl rules, except that it uses the full composite paths, as opposed to just the ending property part