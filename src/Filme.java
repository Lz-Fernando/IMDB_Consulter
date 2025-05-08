package src;

public class Filme {
    private int id;
    private int rank;
    private String title;
    private int year;
    private String director;
    private String cast;
    private float rating;

    public Filme(int id, int rank, String title, int year, String director, String cast, float rating) {
        this.id = id;
        this.rank = rank;
        this.title = title;
        this.year = year;
        this.director = director;
        this.cast = cast;
        this.rating = rating;
    }

    public Filme(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
