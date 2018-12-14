package rrr.handmade_xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AdditionalAssets {
    private String icon;

    public AdditionalAssets() {
        icon = "it's icon";
    }

    public String getIcon() {
        return icon;
    }

    @XmlElement
    public void setIcon(String icon) {
        this.icon = icon;
    }
}
