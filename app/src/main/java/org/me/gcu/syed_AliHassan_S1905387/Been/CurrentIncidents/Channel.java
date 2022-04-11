package org.me.gcu.syed_AliHassan_S1905387.Been.CurrentIncidents;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name="channel", strict=false)
public class Channel {

    @Element
    public String title;

    @Element
    public String description;

    @ElementList
    public ArrayList<Language> language;

    public class Language {}

    @ElementList
    public ArrayList<Copyright> copyright =new ArrayList<>();

    public class Copyright {}

    @ElementList
    public ArrayList<ManagingEditor> managingEditor;

    public class ManagingEditor {}

    @ElementList
    public ArrayList<WebMaster> webMaster;

    public class WebMaster {}

    @Element
    public String lastBuildDate;

    @Element
    public String docs;

    @ElementList
    public ArrayList<Rating> rating;

    public class Rating {}

    @Element
    public String generator;

    @Element
    public String ttl;


    @ElementList(inline = true, required = false)
    public ArrayList<RssItem> item;

    public String toString() {
        return "Channel [item=" + item + "]";
    }

}
