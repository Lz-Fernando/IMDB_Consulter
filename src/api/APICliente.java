package src.api;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APICliente {
    public static String carregarApiKey() {
        Dotenv dotenv = Dotenv.load();

        return dotenv.get("RAPIDAPI_KEY");
    }

    public static String buscarDadosDaApi(String apiKey) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://imdb-api4.p.rapidapi.com/get_movies_by_name"))
                    .header("x-rapidapi-key", apiKey)
                    .header("x-rapidapi-host", "imdb_api4.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao buscar dados da API", e);
        }
    }
}
