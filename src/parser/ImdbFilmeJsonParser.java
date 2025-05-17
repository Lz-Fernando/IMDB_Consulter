package src.parser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import src.model.Content;
import src.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class ImdbFilmeJsonParser implements JsonParser{
    @Override
    public List<? extends Content> parse(String json) {
        List<Filme> filmes = new ArrayList<>();
        Gson gson = new Gson();
        JsonArray items = gson.fromJson(json, JsonArray.class);

        for (int i = 0; i < items.size(); i++) {
            JsonObject item = items.get(i).getAsJsonObject();
            String title = item.get("title").getAsString();
            String year = item.get("year").getAsString();
            String rating = item.get("rating").getAsString();

            filmes.add(new Filme(title, year, rating));
        }

        return filmes;
    }
}
