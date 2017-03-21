# HibernateUtil :
                This is a helper class will get Hibernate up and running. This class creates a SessionFactory object which in turn can open up new Session's.
                This will return a SessionFactory instance, which will a singleton instance, means application will use the same singe instance of session factory in whole application


In this class you will get like SessionFactory, Session


# Configuration :
                   An instance of Configuration allows the application to specify properties and mapping documents to be used when creating a SessionFactory.
                    Usually an application will create a single Configuration, build a single instance of SessionFactory and then instantiate Session in threads servicing client requests.
                    The Configuration is meant only as an initialization-time object. SessionFactory are immutable and do not retain any association back to theConfiguration.<br>
                    A new Configuration will use the properties specified in hibernate.properties by default.

# SessionFactory :
                 The SessionFactory is a factory of session and client of ConnectionProvider.
                  It holds second level cache (optional) of data. The org.hibernate.SessionFactory interface provides factory method to get the object of Session.
                  The main contract here is the creation of Session instances.  Usually an application has a single SessionFactoryinstance and threads servicing client requests obtain Session instances from this factory.
                  The internal state of a SessionFactory is immutable. Once it is created this internal state is set. This internal state includes all of the metadata about Object/Relational Mapping.


# Session :
                The session object provides an interface between the application and data stored in the database.
                    It is a short-lived object and wraps the JDBC connection. It is factory of Transaction, Query and Criteria.
                    It holds a first-level cache (mandatory) of data. The org.hibernate.Session interface provides methods to insert, update and delete the object.
                    It also provides factory methods for Transaction, Query and Criteria.
