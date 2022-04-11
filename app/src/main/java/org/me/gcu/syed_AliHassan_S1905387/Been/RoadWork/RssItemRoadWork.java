package org.me.gcu.syed_AliHassan_S1905387.Been.RoadWork;


import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="item", strict=false)
public class RssItemRoadWork {

    @Element
    public String title;

    @Element
    public String description;

    @Element
    public String link;

    @Element
    public String point;

    @Element
    public String pubDate;

}
