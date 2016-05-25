package gblog

class Comment {
    String author
    String content

    static belongsTo = Post
    static constraints = {
        author nullable: false, size: 1..60
        content nullable: false, size: 1..10000
    }

    @Override
    String toString() {
        return content
    }
}
