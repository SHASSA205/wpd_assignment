package org.me.gcu.syed_AliHassan_S1905387.Been.CurrentIncidents;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rss", strict = false)
public class RssFeed {
    @Element
    public Channel channel;

    @Override
    public String toString() {
        return "RssFeed [channel=" + channel + "]";
    }
}