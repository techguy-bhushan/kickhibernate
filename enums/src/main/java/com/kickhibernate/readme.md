Hibernate supports the mapping of Java enums as basic value types in a number of different ways.

**@Enumerated**

The original JPA-compliant way to map enums was via the @Enumerated and @MapKeyEnumerated for map keys annotations which works on the principle that the enum values are stored according to one of 2 strategies indicated by javax.persistence.EnumType:

**ORDINAL**
- stored according to the enum value’s ordinal position within the enum class, as indicated by java.lang.Enum#ordinal

**STRING**
- stored according to the enum value’s name, as indicated by java.lang.Enum#name
