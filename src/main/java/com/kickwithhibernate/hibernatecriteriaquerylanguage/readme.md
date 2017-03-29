# Hibernate Criteria Query Language

The Hibernate Criteria Query Language (HCQL) is used to fetch the records based on the specific criteria with help of  Criteria interface.

The Session is a factory for Criteria, Criterion instances are usually obtained via the factory methods on Restrictions. eg.

 `List users = session.createCriteria(User.class)
     .add( Restrictions.like("name", "Bhushan%") ))
     .addOrder( Order.asc("id") )
     .list();`


The object of Criteria can be obtained by calling the session.createCriteria()

The Criteria interface provides many methods to specify criteria:-

* public Criteria add(Criterion c) is used to add restrictions.
* public Criteria addOrder(Order o) specifies ordering.
* public Criteria setFirstResult(int firstResult) specifies the first number of record to be retreived.
* public Criteria setMaxResult(int totalResult) specifies the total number of records to be retreived.
* public List list() returns list containing object.
* public Criteria setProjection(Projection projection) specifies the projection.



# Restrictions class :

Restrictions class provides methods that can be used as Criterion. Restrictions class have following methods:

* public static SimpleExpression lt(String propertyName,Object value) -> Sets the less than constraint to the given property.
* public static SimpleExpression le(String propertyName,Object value) Sets the less than or equal constraint to the given property.
* public static SimpleExpression gt(String propertyName,Object value) Sets the greater than constraint to the given property.
* public static SimpleExpression ge(String propertyName,Object value) Sets the greater than or equal than constraint to the given property.
* public static SimpleExpression ne(String propertyName,Object value) Sets the not equal constraint to the given property.
* public static SimpleExpression eq(String propertyName,Object value) Sets the equal constraint to the given property.
* public static Criterion between(String propertyName, Object low, Object high) Sets the between constraint.
* public static SimpleExpression like(String propertyName, Object value) Sets the like constraint to the given property.


Order class

The Order class represents an order. The commonly used methods of Restrictions class are as follows:

public static Order asc(String propertyName) applies the ascending order on the basis of given property.
public static Order desc(String propertyName) applies the descending order on the basis of given property.
