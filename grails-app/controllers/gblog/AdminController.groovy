package gblog

import grails.plugin.springsecurity.annotation.Secured


@Secured(['ROLE_ADMIN'])
class AdminController {

    @Secured(['ROLE_ADMIN'])
    def index() {
        redirect(controller: 'post', action: 'index')
    }
}
