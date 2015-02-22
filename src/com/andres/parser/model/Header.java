package com.andres.parser.model;

public class Header {
    String title;
    String link;
    String description;
    String language;
    String copyright;
    String pubDate;
    String ttl;
    Image image;

    public Header() {
    }

    public Header(String title, String link, String description, String language, String copyright, String pubDate, String ttl, Image image) {
        this.title = title;
        this.link = link;
        this.description=description;
        this.language = language;
        this.copyright = copyright;
        this.pubDate = pubDate;
        this.ttl = ttl;
        this.image = image;
    }
}
