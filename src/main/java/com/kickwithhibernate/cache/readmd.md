# Cache in Hibernate :

Cache improve the performance of the application, Caching functionality is designed to reduce the amount of necessary database access.
It kind of middle man between our application and database to avoid the number of database hits as many as possible to give a better performance for performance critical applications.

Hibernate support 2 types of Cache :
* First level Cache -> Hibernate support it default. The first level cache type is the session cache.
                       The session cache caches object within the current session but this is not enough for long level i.e. session factory scope.
                       The first level cache data will not be available to entire application. An application can use many session object.

* Second Level Cache-> It's a optional in hibernate.
                       SessionFactory object holds the second level cache data.
                       The second level cache is responsible for caching objects across sessions.
                       When this is turned on, objects will first be searched in the cache and if they are not found, a database query will be fired.
                       The data stored in the second level cache will be available to entire application, But we need to enable it explicitly.

                     *  Second Level Cache implementations are provided by different vendors such as :
                     *  EH Cache
                     *  OS Cache
                     *  Swarm Cache
                     * JBoss Cache


There are four ways to use second level cache.

* read-only: caching will work for read only operation.
* nonstrict-read-write: caching will work for read and write but one at a time.
* read-write: caching will work for read and write, can be used simultaneously.
* transactional: caching will work for transaction.


Second level configuration :

* enable second level cache, by default it is configured to off - ‘false’ - by Hibernate
 <property name="cache.use_second_level_cache">true</property>

* For instance creation:
<property name="hibernate.cache.region.factory_class">
        org.hibernate.cache.ehcache.EhCacheRegionFactory</property>

* You may also want to turn on the Hibernate query cache. This is done by setting the following property in your hibernate config:
<property name="hibernate.cache.use_query_cache">true</property>

required maven dependency :
    <!--  Hibernate EHCache API https://mvnrepository.com/artifact/org.hibernate/hibernate-ehcache -->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-ehcache</artifactId>
        <version>4.3.8.Final</version>
    </dependency>
    <!-- EHCache Core APIs -->
    <dependency>
        <groupId>net.sf.ehcache</groupId>
        <artifactId>ehcache-core</artifactId>
        <version>2.6.9</version>
    </dependency>
