package src;

import java.io.IOException;

import java.io.PrintWriter;
import java.lang.reflect.Type;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.github.cdimascio.dotenv.Dotenv;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String apiKey = carregarApiKey();
        String json = buscarDadosDaApi(apiKey);
        List<Filme> filmes = converterjsonParaLista(json);

        exibirFilmes(filmes);
    }


    private static String carregarApiKey() {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("RAPIDAPI_KEY");

        return apiKey;
    }

    private static String buscarDadosDaApi(String apiKey) {
        String json;

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://imdb-api4.p.rapidapi.com/get_movies_by_name"))
                    .header("x-rapidapi-key", apiKey)
                    .header("x-rapidapi-host", "imdb_api4.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            json = response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return json;
    }

    private static List<Filme> converterjsonParaLista(String json) {
        Gson gson = new Gson();

        Type tipoLista = new TypeToken<List<Filme>>() {
        }.getType();
        List<Filme> filmes = gson.fromJson(json, tipoLista);

        return filmes;
    }

    private static void exibirFilmes(List<Filme> filmes) {
        try (PrintWriter writer = new PrintWriter("filmes.html")) {
            HTMLgenerator generator = new HTMLgenerator(writer);
            generator.generate(filmes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
