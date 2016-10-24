import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.gorm.Domain
import grails.test.mixin.hibernate.HibernateTestMixin
import spock.lang.Specification

@TestFor(PersistenceRolesToBeGrantedGORMService)
@Domain(PersistenceRolesToBeGranted)
@TestMixin(HibernateTestMixin)
class PersistenceRolesToBeGrantedGORMServiceSpec extends Specification {

    def "test findAllAuthorityByEmail"() {
    	given:
    	def p = new PersistenceRolesToBeGranted(username: 'sergio.delamo@shoptimix.com', authority: 'ROLE_ADMIN')
        p.save()

        expect:
        ['ROLE_ADMIN'] == service.findAllAuthorityByEmail('sergio.delamo@shoptimix.com')
    }
}
