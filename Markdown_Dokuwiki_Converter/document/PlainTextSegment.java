package lab7.task1.document;

public class PlainTextSegment extends TextSegment{

    public PlainTextSegment(String s) {
        super(s);
    }

    @Override
    public void accept(DocumentVisitor dvistor){
        dvistor.visit(this);
    }
}
