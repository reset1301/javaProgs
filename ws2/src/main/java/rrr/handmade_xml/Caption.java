package rrr.handmade_xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class Caption {
    private String caption;
    private String uuid;

    public Caption(String caption, String uuid) {
        this.caption = caption;
        this.uuid = uuid;
    }

    public Caption() {
    }

    public String getCaption() {
        return caption;
    }

//    @XmlElement(name = "Caption")
    @XmlValue
    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getUuid() {
        return uuid;
    }

    @XmlAttribute(name = "UUID")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
