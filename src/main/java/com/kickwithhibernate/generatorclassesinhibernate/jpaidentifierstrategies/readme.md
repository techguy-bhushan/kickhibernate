JPA defines the 4 identifier strategies and hibernate provide the implementation of them, here they are:

        #AUTO	  : Indicates that the persistence provider should pick an appropriate strategy for the particular database. The AUTO generation strategy may expect a database  resource to exist, or it may attempt to create one.
        #IDENTITY :	Indicates that the persistence provider must assign primary keys for the entity using a database identity column.
        #SEQUENCE :	Indicates that the persistence provider must assign primary keys for the entity using a database sequence.
        #TABLE	  : Indicates that the persistence provider must assign primary keys for the entity using an underlying database table to ensure uniqueness.
