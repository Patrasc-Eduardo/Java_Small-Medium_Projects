package lab7.task1.document;

public class DokuWikiVisitor implements DocumentVisitor{

    private StringBuilder doc = new StringBuilder();

    @Override
    public void visit(ItalicTextSegment itSeg) {
        doc.setLength(0);
        doc.append("//").append(itSeg.getContent()).append("//");
    }

    @Override
    public void visit(BoldTextSegment boldSeg) {
        doc.setLength(0);
        doc.append("**").append(boldSeg.getContent()).append("**");
    }

    @Override
    public void visit(UrlSegment urlSeg) {
        doc.setLength(0);
        doc.append("[[").append(urlSeg.getUrl()).append(" |").
        append(urlSeg.getDescription()).append("]]");
    }

    @Override
    public void visit(PlainTextSegment plainSeg) {
        doc.setLength(0);
        doc.append(plainSeg.getContent());
    }

    @Override
    public StringBuilder getDocument() {
        return doc;
    }
}
