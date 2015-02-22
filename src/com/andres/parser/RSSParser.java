package com.andres.parser;

import java.net.URL;

import com.andres.parser.model.Feed;
import com.andres.parser.model.Item;
import com.andres.parser.model.Image;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.ArrayList;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.jdom.Element;
import org.jdom.Text;

public class RSSParser {

    public static final String CONTENT = "content";
    public static final String TEXT = "text";
    public static final String CREDIT = "credit";

    public RSSParser(){}

    public String parse(String givenUrl){
        return parseObjectToJson(parseRssToObject(givenUrl));
    }

    public String parseObjectToJson(Feed feedObject){

        String jsonString = "";

        try {
            JSONObject jsonObject = new JSONObject(feedObject);
            jsonString = jsonObject.toString();
        }catch(Exception e){
            System.out.print(e.toString());
        }

        return jsonString;

    }

    public Feed parseRssToObject(String givenUrl){

        Feed feedObject = new Feed();

        try{
            URL url = new URL(givenUrl);
            HttpURLConnection httpcon = (HttpURLConnection)url.openConnection();
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(httpcon));
            List entries = feed.getEntries();

            feedObject.setTitle(feed.getTitle());
            feedObject.setLink(feed.getLink());
            feedObject.setDescription(feed.getDescription());
            feedObject.setLanguage(feed.getLanguage());
            feedObject.setCopyright(feed.getCopyright());
            feedObject.setPubDate(feed.getPublishedDate());
            feedObject.setImage(new Image(feed.getImage().getTitle(),feed.getImage().getLink(), feed.getImage().getUrl()));


            for (Object entry1 : entries) {
                SyndEntry entry = (SyndEntry) entry1;
                Item item = new Item();
                item.setTitle(entry.getTitle());
                item.setDescription(entry.getDescription().getValue());
                item.setLink(entry.getLink());
                item.setPubDate(entry.getPublishedDate());
                item.setSource(entry.getSource() != null ? entry.getSource().toString():"");
                ArrayList<Element> mediaList = (ArrayList<Element>) entry.getForeignMarkup();
                for (Element media : mediaList){
                    switch(media.getName()){
                        case CONTENT:
                            Image image = new Image(media.getAttributeValue("url"), Integer.parseInt(media.getAttributeValue("width")), Integer.parseInt(media.getAttributeValue("height")));
                            item.setMediaContent(image);
                            break;
                        case TEXT:
                            item.setMediaText(((Text) media.getContent().get(0)).getText());
                            break;
                        case CREDIT:
                            item.setMediaCredit(media.getAttributeValue("role"));
                            break;
                    }

                }
                feedObject.addItem(item);
            }
        }catch(Exception e){
            System.out.print(e.toString());
        }

        return feedObject;
    }

}