package src.main;

import src.api.APIClient;
import src.api.ImdbApiClient;
import src.exporter.HTMLExporter;
import src.model.Content;
import src.parser.ImdbFilmeJsonParser;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        APIClient apiClient = new ImdbApiClient();
        String apiKey = ImdbApiClient.carregarApiKey();
        String json = apiClient.getBody(apiKey);

        ImdbFilmeJsonParser jsonParser = new ImdbFilmeJsonParser();
        List<? extends Content> contents = jsonParser.parse(json);

        HTMLExporter htmlExporter = new HTMLExporter();
        htmlExporter.exportarParaHtml(contents, "contents.html");
    }
}
