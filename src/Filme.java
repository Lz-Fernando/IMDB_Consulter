package src;

public record Filme(
        int id,
        int rank,
        String title,
        int year,
        String director,
        String cast,
        float rating
) {}
