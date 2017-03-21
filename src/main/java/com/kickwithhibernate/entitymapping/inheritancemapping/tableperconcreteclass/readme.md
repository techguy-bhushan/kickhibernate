In case of Table Per Concrete class, there will be tables per class in the database having no relations to each other.
In One Table per Concrete class scheme, each concrete class is mapped as normal persistent class.This is the easiest method of Inheritance mapping to implement.

# Disadvantages
    Data that's belongs to a parent class is scattered across a number of subclass tables, which represents concrete classes.
    This hierarchy is not recommended for most cases.
    Changes to a parent class is reflected to large number of tables
    A query couched in terms of parent class is likely to cause a large number of select operations


For Annotation : We use @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) in parent class

