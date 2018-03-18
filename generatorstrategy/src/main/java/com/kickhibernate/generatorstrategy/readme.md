* All hibernate generator classes implements hibernate.id.IdentifierGenerator interface and overrides the generate(SessionImplementor,Object) method to generate the ‘identifier or primary key value.
* Hibernate framework provides many built-in generator classes:
* assigned,increment,sequence,hilo,native,identity,uuid,guid,select,foreign,sequence-identity.
* Follows the examples of generators in this package.</p>


        # @GeneratedValue is used only to get the generated value. The two arguments strategy and generator are used to define how the value is obtained.
        # @GenericGenerator is used to map a user defined sequence generator with your hibernate session.
