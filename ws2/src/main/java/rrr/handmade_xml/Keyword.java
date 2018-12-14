package rrr.handmade_xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class Keyword {
    private String keyword;
    private String attr;

    public Keyword() {
    }

    public Keyword(String keyword, String attr) {
        this.keyword = keyword;
        this.attr = attr;
    }

    public String getKeyword() {
        return keyword;
    }

//    @XmlElement(name = "Keyword")
    @XmlValue
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAttr() {
        return attr;
    }

    @XmlAttribute(name = "KeywordAttribute")
    public void setAttr(String attr) {
        this.attr = attr;
    }
}
