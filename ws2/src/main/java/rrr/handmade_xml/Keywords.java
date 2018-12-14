package rrr.handmade_xml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Keywords {
    private String attr1;
    private String attr2;
    private List<Keyword> keyword;

    public Keywords() {
        keyword = new ArrayList<>();
        keyword.add(new Keyword("","Attr value"));
        keyword.add(new Keyword("Mixed","Attr"));
        keyword.add(new Keyword("",""));
        keyword.add(new Keyword("it's value","Attr value"));
        keyword.add(new Keyword("Mixed Reality Viewer","Attr value"));
        attr1 = "it's attrs1 value";
        attr2 = "";
    }

    public List<Keyword> getKeyword() {
        return keyword;
    }

    @XmlElement(name = "Keyword")
//    @XmlValue
    public void setKeyword(List<Keyword> keyword) {
        this.keyword = keyword;
    }

    @XmlAttribute(name = "KeywordPhrase")
    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    @XmlAttribute(name = "KeywordAttr2")
    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }
}
