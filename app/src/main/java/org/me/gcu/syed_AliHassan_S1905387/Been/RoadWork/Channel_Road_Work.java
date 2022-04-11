package org.me.gcu.syed_AliHassan_S1905387.Been.RoadWork;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name="channel", strict=false)
public class Channel_Road_Work {

     @Element
     public String title;

     @Element
     public String description;

     @Element
     public String link;

     @Element
     public String lastBuildDate;

     @Element
     public String docs;

     @Element
     public String generator;

     @Element
     public String ttl;

     @ElementList(inline = true, required = false)
     public ArrayList<RssItemRoadWork> item;

     public String toString() {
          return "Channel_Road_Work [item=" + item + "]";
     }

}
