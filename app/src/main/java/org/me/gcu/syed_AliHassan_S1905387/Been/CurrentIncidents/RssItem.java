package org.me.gcu.syed_AliHassan_S1905387.Been.CurrentIncidents;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name="item", strict=false)
public class RssItem {

        @Element
        public String title;

        @Element
        public String description;

        @Element
        public String link;

        @Element
        public String point;

        @ElementList
        public ArrayList<Author> author;

        public class Author {}

        @ElementList
        public ArrayList<Comments> comments;

        public class Comments {}

        @Element
        public String pubDate;

}
