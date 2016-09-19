class PersistenceRolesToBeGranted implements Serializable {

    String username

    String authority

    static constraints = {
        username nullable: false, email: true
        authority nullable: false
    }

    static mapping = {
        id composite: ['username', 'authority'], generator: 'assigned'
        version false
    }
}