package org.me.gcu.syed_AliHassan_S1905387.Been;

import org.me.gcu.syed_AliHassan_S1905387.Been.RoadWork.Channel_Road_Work;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rss", strict = false)
public class RoadWorkRssFeed {

    @Element
    public Channel_Road_Work channel;

    @Override
    public String toString() {
        return "RssFeed [channel=" + channel + "]";
    }
}