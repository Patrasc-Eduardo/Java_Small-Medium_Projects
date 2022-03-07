package lab7.task1.document;

public class MarkdownVisitor implements DocumentVisitor{
    private StringBuilder doc = new StringBuilder();

    @Override
    public void visit(ItalicTextSegment itSeg) {
        doc.setLength(0);
        doc.append("_").append(itSeg.getContent()).append("_");
    }

    @Override
    public void visit(BoldTextSegment boldSeg) {
        doc.setLength(0);
        doc.append("__").append(boldSeg.getContent()).append("__");
    }

    @Override
    public void visit(UrlSegment urlSeg) {
        doc.setLength(0);
        doc.append("[").append(urlSeg.getDescription()).append("]")
                .append("(" + urlSeg.getUrl() + ")");
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
