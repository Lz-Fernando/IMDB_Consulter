package src.exporter;

import src.model.Content;

import java.io.PrintWriter;
import java.util.List;

public class HTMLExporter {
    public void exportarParaHtml(List<? extends Content> contents, String caminhoArquivo) {
        try (PrintWriter writer = new PrintWriter(caminhoArquivo)) {
            HtmlGenerator generator = new HtmlGenerator(writer);
            generator.generate(contents);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao exportar para HTML", e);
        }
    }
}
