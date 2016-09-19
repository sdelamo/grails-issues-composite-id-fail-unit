import grails.transaction.Transactional

@Transactional
class PersistenceRolesToBeGrantedGORMService {

    def findAll() {
        PersistenceRolesToBeGranted.findAll()
    }

    void save(String authority, String username) {

        def p = new PersistenceRolesToBeGranted(username: username, authority: authority)

        if ( !p.save() ) {
            println p.errors
        }
    }

    List<String> findAllAuthorityByEmail(String email) {
        def c = PersistenceRolesToBeGranted.createCriteria()
        c.list {
            projections {
                property('authority')
            }
            eq('username', email)
        } as List<String>
    }

    void deleteRolesToByGrantedByEmail(String email) {
        PersistenceRolesToBeGranted.executeUpdate('DELETE FROM PersistenceRolesToBeGranted WHERE username = :email', [email: email])
    }

    void remove(String roleName, String email) {
        def p = PersistenceRolesToBeGranted.findByUsernameAndAuthority(email, roleName)
        p?.delete()
    }
}