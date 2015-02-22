package com.andres.parser.model;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;


public class Feed {

    private String title;
    private String link;
    private String description;
    private String language;
    private String copyright;
    private Date pubDate;
    private String ttl;

    Image image;

    ArrayList<Item> items;

    public Feed() {
        image = null;
        items = new ArrayList<Item>();
    }

    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public void setLink(String link) {
        this.link = link;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    public void setLanguage(String language) {
        this.language = language;
    }

    @XmlElement
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @XmlElement
    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    @XmlElement
    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    @XmlElement
    public void setImage(Image image) {
        this.image = image;
    }

    @XmlElement(name = "item")
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public String getCopyright() {
        return copyright;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public String getTtl() {
        return ttl;
    }

    public Image getImage() {
        return image;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }
}
