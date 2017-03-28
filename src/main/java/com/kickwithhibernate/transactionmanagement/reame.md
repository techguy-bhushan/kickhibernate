# Transaction

Transaction worked on ACID(Atomicity, Consistency, Isolation and Durability) properties, If one step fail then whole transaction fails.

Transaction Interface in hibernate:

Transaction interface that defines the unit of work.
It's allows the application to define units of work, while maintaining abstraction from the underlying transaction implementation (eg. JTA, JDBC).

A transaction is associated with a {@link Session} and is usually initiated by a call to
Session.beginTransaction().
A single session might span multiple transactions since the notion of a session (a conversation between the application and the datastore) is of coarser granularity than
the notion of a transaction.  However, it is intended that there be at most one uncommitted transaction associated with a particular  Session at any time.

The methods of Transaction interface are as follows:

    void begin() -> Starts a new transaction. Note that this is not necessarily symmetrical since usually multiple calls to  #commit or #rollback will error.

    void commit() -> Ends the unit of work unless we are in FlushMode.NEVER. It throws HibernateException Indicates a problem committing the transaction.

    void rollback() -> Forces this transaction to rollback. It throws HibernateException Indicates a problem rolling back the transaction.

    void setTimeout(int seconds)  -> It Set the transaction timeout for any transaction started by a subsequent call to {@link #begin} on this instance.

    boolean isActive() -> Checks, Is this transaction still active?

    void registerSynchronization(Synchronization s) ->  Register a user synchronization callback for this transaction.

    boolean wasCommitted() -> checks, Was this transaction committed?

    boolean wasRolledBack() -> checks Was this transaction rolled back or set to rollback only?
