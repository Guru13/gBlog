import users.*
import gblog.*
class BootStrap {

    def init = { servletContext ->
        def userRole = new Role(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(failOnError: true)

        def userUser = new User(username: 'user', password: 'user', enabled: true).save(failOnError: true)
        def adminUser = new User(username: 'admin', password: 'admin', enabled: true).save(failOnError: true)

        UserRole.create userUser, userRole
        UserRole.create adminUser, adminRole


       def post =  new Post(
                        title: "First post about Grails",
                        content: 'Grails is a powerful web framework, for the Java platform aimed at multiplying' +
                                ' developers productivity thanks to a Convention-over-Configuration, sensible' +
                                ' defaults and opinionated APIs. It integrates smoothly with the JVM, allowing' +
                                ' you to be immediately productive whilst providing powerful features, including' +
                                ' integrated ORM, Domain-Specific Languages, runtime and compile-time meta-programming' +
                                ' and Asynchronous programming.',
                        author: 'Guru13',
                        publishDate: new Date())
        post.save()
        println post.errors
    }
    def destroy = {
    }
}
