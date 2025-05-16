package src.exporter;

import src.model.Filme;

import java.io.PrintWriter;
import java.util.List;

public class HTMLExporter {
    public void exportarParaHtml(List<Filme> filmes, String caminhoArquivo) {
        try (PrintWriter writer = new PrintWriter(caminhoArquivo)) {
            HTMLgenerator generator = new HTMLgenerator(writer);
            generator.generate(filmes);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao exportar para HTML", e);
        }
    }
}
