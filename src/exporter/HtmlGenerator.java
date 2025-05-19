package src.exporter;

import src.model.Content;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class HtmlGenerator {

    private final Writer writer;

    public HtmlGenerator(Writer writer) {
        this.writer = writer;
    }

    public void generate(List<? extends Content> contents) {
        try {
            writeHead();
            writeBody(contents);
            writeFooter();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar o HTML", e);
        }
    }

    private void writeHead() throws IOException {
        writer.write(
        """
                <!DOCTYPE html>
                <head>
                    <meta charset=\"utf-8\">
                    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
                    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
                        + "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					
                </head>
            """
        );
    }

    private void writeBody(List<? extends Content> contents) throws IOException {
        for (Content content : contents) {
            writer.write(String.format(
                """
                    <body>
                        <div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
                            <h4 class=\"card-header\">%s</h4>
                            <div class=\"card-body\">
                                <p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
                            </div>
                        </div>
                    </body>
                """, content.title(), content.rating(), content.year()
            ));
        }

    }

    private void writeFooter() throws IOException{
        writer.write(
        """
                </html>
            """
        );
    }
}
