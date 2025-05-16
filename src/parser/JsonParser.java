package src.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import src.model.Filme;

import java.lang.reflect.Type;
import java.util.List;

public class JsonParser {
    public List<Filme> converterJsonParaLista(String json) {
        Gson gson = new Gson();
        Type tipoLista = new TypeToken<List<Filme>>() {}.getType();

        return gson.fromJson(json, tipoLista);
    }
}
