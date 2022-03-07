package lab7.task1.document;

public class BoldTextSegment extends TextSegment {

    public BoldTextSegment(String s){
        super(s);
    }
    @Override
    public void accept(DocumentVisitor dvistor){
        dvistor.visit(this);
    }
}
