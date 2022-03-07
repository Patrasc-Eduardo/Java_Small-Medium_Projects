package lab7.task1.document;

public class ItalicTextSegment extends TextSegment {
    public ItalicTextSegment(String str) {
        super(str);
    }
    @Override
    public void accept(DocumentVisitor dvistor){
        dvistor.visit(this);
    }
}
