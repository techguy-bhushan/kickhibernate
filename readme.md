# kickhibernate
Hinernate Tutorials

#Run:

* You need Java,Maven in your mechine
* Check hibernate.cfg.xml file, It is a configuration file, containing informations about the database and mapping file.
* Here i am using mysql database, if you need to test it with different database then need to change the dialect in file hibernate.cfg.xml
<br>`<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>` replace it with your dialect.
e.f if you are using oracle then you should write like:<br>
`<property name="hibernate.dialect">org.hibernate.dialect.OracleDialect</property>`
* IF you need to create a data base name `kickhib` if you want change the database name then you need to replace the connection.url in hibernate.cfg.xml
e.g:<br>`<property name="connection.url">jdbc:mysql://localhost:3306/mynewdb</property>`
* Also you need to replace the connection.password", connection.username value with name of your database username and password in hibernate.cfg.xml file
e.g:  <br>
`<property name="connection.password">password</property>
<property name="connection.username">root</property>`

* Open any package you will find a A class with main method, run that class.
