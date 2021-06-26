package com.example.animelist;
//POJO
public class Anime {
    private int id;
    private String name;
    private String author;
    private int episodes;
    private String imageUrl;
    private String shortDesc;
    private String longDesc;
    private boolean isExpanded;

    public Anime(int id, String name, String author, int episodes, String imageUrl, String shortDesc, String longDesc) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.episodes = episodes;
        this.imageUrl = imageUrl;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        isExpanded = false;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", episodes=" + episodes +
                ", imageUrl='" + imageUrl + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                '}';
    }
}
