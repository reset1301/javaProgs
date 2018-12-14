package rrr.handmade_xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@XmlRootElement
public class ScreenshotCaptions {
    private String desktopImage = "Desktop_viewer_01.png";
    private List<Caption> captions;

    public ScreenshotCaptions() {
        captions = new ArrayList<>();
        captions.add(new Caption("", UUID.randomUUID().toString()));
        captions.add(new Caption("ter oportunidades de aprendizagem mais envolventes.", UUID.randomUUID().toString()));
        captions.add(new Caption("envolventes.", UUID.randomUUID().toString()));
        captions.add(new Caption(".", UUID.randomUUID().toString()));
        captions.add(new Caption("", UUID.randomUUID().toString()));
    }

    public String getDesktopImage() {
        return desktopImage;
    }

    @XmlAttribute(name = "DesktopImage")
    public void setDesktopImage(String desktopImage) {
        this.desktopImage = desktopImage;
    }

    public List<Caption> getCaptions() {
        return captions;
    }

    @XmlElement(name = "Caption")
    public void setCaptions(List<Caption> captions) {
        this.captions = captions;
    }
}
