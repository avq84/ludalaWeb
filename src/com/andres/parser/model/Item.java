package com.andres.parser.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@XmlRootElement(namespace = "com.andres.parser.model.Channel")
public class Item {

    String title;
    String description;
    String link;
    Date pubDate;
    String source;
    Image mediaContent;
    String mediaText;
    String mediaCredit;

    public Item() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {return link;}

    public void setLink(String link) {
        this.link = link;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Image getMediaContent() {
        return mediaContent;
    }

    public void setMediaContent(Image mediaContent) {
        this.mediaContent = mediaContent;
    }

    public String getMediaText() {
        return mediaText;
    }

    public void setMediaText(String mediaText) {
        this.mediaText = mediaText;
    }

    public String getMediaCredit() {
        return mediaCredit;
    }

    public void setMediaCredit(String mediaCredit) {
        this.mediaCredit = mediaCredit;
    }
}
