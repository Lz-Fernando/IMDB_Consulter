package src.main;

import src.model.Filme;
import src.parser.JsonParser;
import src.api.APICliente;
import src.exporter.HTMLExporter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        APICliente apiCliente = new APICliente();
        String apiKey = APICliente.carregarApiKey();
        String json = apiCliente.buscarDadosDaApi(apiKey);

        JsonParser jsonParser = new JsonParser();
        List<Filme> filmes = jsonParser.converterJsonParaLista(json);

        HTMLExporter htmlExporter = new HTMLExporter();
        htmlExporter.exportarParaHtml(filmes, "filmes.html");
    }
}
