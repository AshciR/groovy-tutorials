package io.richie.nullsafety

import spock.lang.Specification

class NullSafety extends Specification {

    /*
    Let's talk about the dreaded null pointer exception (NPE)
    we have in many languages. Whenever we try to
    access a null object in Java, a NPE exception will be thrown
     */

    def 'Should throw a NPE'() {

        given: 'We have a null value'
        String nullString = null

        when: 'We try to call a method on a null'
        nullString.size()

        then: 'A NPE to be thrown'
        thrown(NullPointerException)

    }

    /*
    Nasty things NPEs... They've been the bane of
    programmer's existence since the invention of null.
    Let's look how Java programmers been handling NPEs
    before Java 8.
     */

    def 'Should defensively code around NPE'() {
        String string = null

        when: 'We try to call a method on a null'
        Integer size = 0

        if (string != null) { // In Java we have to create if blocks to handle nulls
            size = string.size()
        }

        then: 'A NPE to be thrown'
        size == 0
    }

    /*
    We see above that we have to create if blocks to check for null values
    before we execute the code we actually care about.

    In that example it's not too bad because we only have 1 if statement.
    But let's look at a more complicated example.
     */

    def 'Should defensively code around multiple NPEs'() {
        given: 'We have a person who is not homeless'
        Person john = new Person(
                name: 'John',
                address: new Address(
                        street: '123 Rainbow Road', // He likes Mario Kart
                        city: 'Nintendo World'
                )
        )

        when: 'We find out what street they live on'
        String street = ''

        if (null != john) { // Level 1 null check
            if (john.address != null) { // Level 2 null check
                street = john.address.street
            }
        }

        then: 'The person should have the correct street address'
        street == '123 Rainbow Road'

    }

    /*
    If we extrapolate the above example to handle more null checks,
    we can see how ugly the if blocks can become.

    Fortunately, Groovy has a more precise way to handle this
    use case. Let's see.
     */

    def 'Groovy way to defensively code around multiple NPEs'() {
        given: 'We have a person who is not homeless'
        Person john = new Person(
                name: 'John',
                address: new Address(
                        street: '123 Rainbow Road', // He likes Mario Kart
                        city: 'Nintendo World'
                )
        )

        when: 'We find out what street they live on'
        String street = john?.address?.street // This is called a null safe operator

        then: 'The person should have the correct street address'
        street == '123 Rainbow Road'

    }

    /*
    Look how clean that looks! Groovy has a built in null safe operator.
    If any of the values in the chain produces a null value,
    the expression will return a null.
    This eliminates the nested if statements.
     */

    def 'Groovy way to defensively code around multiple NPEs part 2'() {
        given: 'We have a person who is not homeless'
        Person john = new Person(
                name: 'John',
                address: null // N.B. The address is null in this case.
        )

        when: 'We find out what street they live on'
        String street = john?.address?.street // This is called a null safe operator

        then: 'The person should have the correct street address'
        street == null

    }

    /*
    We saw above that null was returned. That works, but because
    we're great engineers, and we HATE null values, wouldn't it
    be great if we could provide a default value instead.

    This way, when other parts of our code or external clients
    call our methods, we mitigate the chances for NPEs.

    Let's look on how Groovy can achieve this.
     */

    def 'Should return a default value if null was found'() {
        given: 'We have a person who is not homeless'
        Person john = new Person(
                name: 'John',
                address: null // N.B. The address is null in this case.
        )

        when: 'We find out what street they live on'
        String street = john?.address?.street ?: 'Nowhere' // We're gonna default to 'Nowhere"

        then: 'The person should have the correct street address'
        street == 'Nowhere'
    }

    /*
    See how we fell back on a default value in the case where the value
    would have been null?
    We used the Groovy Elvis operator, ?:
    They call it Elvis, because it looks like Elvis Presley
    with his hair slicked back (turn your head sideways)
     */

    /*
    Takeaway: When you design methods, always think
    if there's a value you can provide your clients instead of nulls.
    Here are some examples for good programming practices:
    1. For Lists return [] instead of null
    2. For Maps return [:] instead of null
    3. For Strings return '' instead of null
    4. For Numbers return 0 instead of null

    You'll save them the headache from NPEs. :)
     */

}