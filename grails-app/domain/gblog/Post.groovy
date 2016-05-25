package gblog

class Post {

    String title
    String content
    String author
    Date publishDate

    static hasMany = [comments : Comment]
    static constraints = {
        title nullable: false, size: 1..140
        content nullable: false, minSize: 20
        author nullable: false
        publishDate nullable: false
    }
    static mapping = {
        content type: 'text'
    }

}
