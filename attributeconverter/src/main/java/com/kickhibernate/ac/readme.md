**AttributeConverters**

Although Hibernate has long been offering custom types, as a JPA 2.1 provider, it also supports `AttributeConverter`s as well.

With a custom AttributeConverter, the application developer can map a given JDBC type to an entity basic type.

In the following example, the java.util.Period is going to be mapped to a VARCHAR database column.