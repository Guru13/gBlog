package gblog

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class PostController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Post.list(params), model:[postInstanceCount: Post.count()]
    }

    def blog() {
        redirect(action: 'list')
    }

    def list(){
        def posts = Post.list(max: 20, sort: 'publishDate', order: 'desc')
        [posts : posts]

    }
    @Secured(['ROLE_ADMIN'])
    def show(Post postInstance) {
        respond postInstance
    }
    def showpost(int id){
        if(id == null){
            redirect(action: 'list')
        }
        def posts = Post.list(max: 20, sort: 'publishDate', order: 'desc')

        def post = Post.findById(id)
        [post: post, posts: posts]
    }
    def comment = {

        if(params.id == null){
            redirect(action: 'list')
        }
        def post = Post.findById(params.id)
        if (post == null){
            flash.error = "sorry, there is no post with that id"
            redirect(action: 'list')
        }
        post.addToComments(new Comment(author: params.author, content: params.content)).save()

        if (post.errors.errorCount != 0){
            flash.error = "sorry ${params.author}, we could not save your comment"
        }
        redirect(action: 'showpost', id: params.id)
    }
    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new Post(params)
    }

    @Transactional
    @Secured(['ROLE_ADMIN'])
    def save(Post postInstance) {
        if (postInstance == null) {
            notFound()
            return
        }

        if (postInstance.hasErrors()) {
            respond postInstance.errors, view:'create'
            return
        }

        postInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'post.label', default: 'Post'), postInstance.id])
                redirect postInstance
            }
            '*' { respond postInstance, [status: CREATED] }
        }
    }
    @Secured(['ROLE_ADMIN'])
    def edit(Post postInstance) {
        respond postInstance
    }

    @Transactional
    @Secured(['ROLE_ADMIN'])
    def update(Post postInstance) {
        if (postInstance == null) {
            notFound()
            return
        }

        if (postInstance.hasErrors()) {
            respond postInstance.errors, view:'edit'
            return
        }

        postInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Post.label', default: 'Post'), postInstance.id])
                redirect postInstance
            }
            '*'{ respond postInstance, [status: OK] }
        }
    }

    @Transactional
    @Secured(['ROLE_ADMIN'])
    def delete(Post postInstance) {

        if (postInstance == null) {
            notFound()
            return
        }

        postInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Post.label', default: 'Post'), postInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
