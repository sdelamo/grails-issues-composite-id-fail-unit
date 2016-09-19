import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Ignore
import spock.lang.Specification

@TestFor(PersistenceRolesToBeGrantedGORMService)
@Mock([PersistenceRolesToBeGranted])
class PersistenceRolesToBeGrantedGORMServiceSpec extends Specification {

    def "test findAllAuthorityByEmail"() {
    	given:
    	def p = new PersistenceRolesToBeGranted(username: 'sergio.delamo@shoptimix.com', authority: 'ROLE_ADMIN')
        p.save()

        expect:
        ['ROLE_ADMIN'] == service.findAllAuthorityByEmail('sergio.delamo@shoptimix.com')
    }
}
