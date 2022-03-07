package lab7.task1;

import lab7.task1.document.DokuWikiVisitor;
import lab7.task1.document.MarkdownVisitor;
import lab7.task1.document.TextSegment;

import java.util.List;

/**
 * Uses visitors to parse documents and provide dokuwiki and markdown outputs.
 */
public class WikiGenerator {

    private final List<TextSegment> textSegments;

    public WikiGenerator(List<TextSegment> textSegments) {
        this.textSegments = textSegments;
    }

    public StringBuilder getDokuWikiDocument() {
        // apply dokuwiki visitor on the text segments
        DokuWikiVisitor doku = new DokuWikiVisitor();
        StringBuilder builder = new StringBuilder();
        for(TextSegment ts : textSegments){
            ts.accept(doku);
            builder.append(doku.getDocument());
        }
        return builder;
    }

    public StringBuilder getMarkdownDocument() {
        // apply Markdown visitor on the text segments
        MarkdownVisitor mkdown = new MarkdownVisitor();
        StringBuilder builder = new StringBuilder();
        for(TextSegment ts : textSegments){
            ts.accept(mkdown);
            builder.append(mkdown.getDocument());
        }
        return builder;
    }
}
