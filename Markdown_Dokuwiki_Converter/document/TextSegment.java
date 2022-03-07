package lab7.task1.document;

/**
 * Represents a text segment of a document that needs to be parsed.
 */
public abstract class TextSegment implements Visitable{
    private String content;

    public TextSegment() {

    }

    TextSegment(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    // TODO add method for applying the visitor

    public abstract void accept(DocumentVisitor dvistor);
}
