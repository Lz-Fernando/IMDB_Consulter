package src.model;

public class Filme implements Content, Comparable<Content> {
    private String title;
    private String year;
    private String rating;

    public Filme(String title, String year, String rating) {
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String rating() {
        return rating;
    }

    @Override
    public String year() {
        return year;
    }

    @Override
    public int compareTo(Content outro) {
        return this.title.compareTo(outro.title());
    }
}
