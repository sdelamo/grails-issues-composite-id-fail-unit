import grails.transaction.Transactional

@Transactional
class PersistenceRolesToBeGrantedGORMService {

    List<String> findAllAuthorityByEmail(String email) {
        def c = PersistenceRolesToBeGranted.createCriteria()
        c.list {
            projections {
                property('authority')
            }
            eq('username', email)
        } as List<String>
    }
}