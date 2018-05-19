**SessionFactory:**
The SessionFactory is a factory of session and client of ConnectionProvider.
It holds second level cache (optional) of data. The org.hibernate.SessionFactory interface provides factory method to get the object of Session.
  
  
 **Session**        
The session object provides an interface between the application and data stored in the database.
It is a short-lived object and wraps the JDBC connection. It is factory of Transaction, Query and Criteria.
It holds a first-level cache (mandatory) of data. The org.hibernate.Session interface provides methods to insert, update and delete the object.


Here in this example, we are mapping our entity with help of xml configuration.

        Here we have a java class `Employee` and it mapping in employee.hbm.xml,This mapping file instructs Hibernate how to map the defined class or classes to the database tables.
        If you will check the hibernate.cfg.xml you will find the lines
 `<mapping resource="employee.hbm.xml"></mapping>`

        hibernate.cfg.xml is our configuration file where we are register our employee.hbm.xml

<p> Basic used element in xml file </p>

# hibernate-mapping :
This is as the root element which contains one or more then one  <class> elements. As per Java doc It is an instance of this XML document may contain mappings for an arbitrary
        number of classes. The class mappings may contain associations to classes mapped in the same document or in another document. No class may be
        mapped more than once.<br>
`<hibernate-mapping>
<class>
        --------
        --------
</class>
<class>
        --------
        -------
</class>
</hibernate-mapping>`

# class :
This element represent the mapping java class which we need to persist in data base,this is Root entity mapping.Poorly named as entities do not have to be represented by
classes at all.<br>
`e.g:
<class name="com.kickwithhibernate.startwithxml.Employee">
        --------------
        ------------
</class>`

 # id :
This element represent the primary key of Entity class, As per Java Doc, Declares the id type, column and generation algorithm for an entity class.
        If a name attribut is given, the id is exposed to the application through the named property of the class. If not, the id is only exposed to the application
        via Session.getIdentifier()<br>

`e.g:
<id name="id">
<generator class="increment"></generator>
</id>`
        here `<generator class="increment">` represent the generate ID strategy


 # property
This represent the property of an entity class. JavaBeans style properties are mapped to table columns. You can add the column attribute, it's refers to the column in the database table </p>
        e.g:
`<property name="firstName"></property>`
