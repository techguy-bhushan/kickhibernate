# Hibernate Query Language (HQL) :

Hibernate Query Language (HQL) is an object-oriented query language, it is database independent query language.
It's same as SQL (Structured Query Language) but it doesn't depends on the table of the database.
Instead of table name, we use class name in HQL, means HQL works with persistent objects and their properties..

HQL is a language with its own syntax and grammar.

# Query Interface :

It is an object-oriented representation of a Hibernate query. Query instance is obtained by calling `Session.createQuery()`.
 This interface exposes some extra functionality beyond that provided by Session.iterate() Session.find():
 a particular page of the result set may be selected by calling setMaxResults(), setFirstResult()
 Named query parameters are tokens of the form name in the query string. A value is bound to the integer parameter :foo by calling setParameter("foo", foo, Hibernate.INTEGER);

 The query interface provides many methods. There is given commonly used methods :

  *  public int executeUpdate() -> is used to execute the update or delete query.
  e.g:    `Query query=session.createQuery("delete from User where id=1");
           query.executeUpdate();`

  *  public List list() -> returns the result of the ralation as a list.

   e.g: `Query query=session.createQuery("from User"); //here User is entity class name.
      List list=query.list();`

  *  public Query setFirstResult(int rowNo) -> Specifies the row number from where record will be retrieved.

    e.g->  `Query query=session.createQuery("from User");
             query.setFirstResult(5);
             query.list()`

  *  public Query setMaxResult(int rowNo) -> specifies the no. of records to be retrieved from the relation (table).
     e.g->  `Query query=session.createQuery("from User");
             query.setMaxResult(10);
             query.list()`

  *  public Query setParameter(int position, Object value) ->it sets the value to the JDBC style query parameter.
      e.g. ->
            `Query q=session.createQuery("update User set name=:n where id=:i");
             q.setParameter("n","Jaby Koay");
             q.setParameter("i",1);`

  *  public Query setParameter(String name, Object value) -> it sets the value to a named query parameter.
  e.g. ->
              `String query = "from User s where s.name = ? and s.id = ?";
               List result = session.createQuery(hql)
               .setString(0, "Bhushan)
               .setParameter(1, 10)
               .list();`







