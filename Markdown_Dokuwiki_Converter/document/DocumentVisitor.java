package lab7.task1.document;

public interface DocumentVisitor {

    void visit(ItalicTextSegment itSeg);

    void visit(BoldTextSegment itSeg);

    void visit(UrlSegment itSeg);

    void visit(PlainTextSegment itSeg);

    StringBuilder getDocument();


}
