package learn.markdownnotetakingapp.service

import org.commonmark.node.Node
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer
import org.springframework.stereotype.Service

@Service
class MarkdownService {
    String convertToHtml(String markdown) {
        Parser parser = Parser.builder().build()
        Node document = parser.parse(markdown) as Node
        HtmlRenderer renderer = HtmlRenderer.builder().build()
        return renderer.render(document as Node)
    }
}
