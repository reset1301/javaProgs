package rrr.handmade_xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement
@XmlType(propOrder = {"keywords", "description", "releaseNotes", "screenshotCaptions", "additionalAssets", "trailers"})
public class JavaClassToXml {
    private Keywords keywords;
    private String description;
    private String releaseNotes;
    private ScreenshotCaptions screenshotCaptions;
    private AdditionalAssets additionalAssets;
    private List<String> trailers;

    public JavaClassToXml() {
        keywords = new Keywords();
        description = "it's a description";
        releaseNotes = "";
        screenshotCaptions = new ScreenshotCaptions();
        additionalAssets = new AdditionalAssets();
        trailers = new ArrayList<>();
        trailers.add("Trailer 1 do Visualizador de Realidade Misturada");
        trailers.add("1");
        trailers.add("");
        trailers.add("it's a trailers");
    }

    public List<String> getTrailers() {
        return trailers;
    }

    @XmlElementWrapper(name = "Trailers")
//    @XmlElement(name = "Trailer")
    public void setTrailers(List<String> trailers) {
        this.trailers = trailers;
    }

    public Keywords getKeywords() {
        return keywords;
    }

    @XmlElement(name = "Keywords")
    public void setKeywords(Keywords keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseNotes() {
        return releaseNotes;
    }

    @XmlElement
    public void setReleaseNotes(String releaseNotes) {
        this.releaseNotes = releaseNotes;
    }

    public ScreenshotCaptions getScreenshotCaptions() {
        return screenshotCaptions;
    }

    @XmlElement(name = "ScreenshotCaptions")
    public void setScreenshotCaptions(ScreenshotCaptions screenshotCaptions) {
        this.screenshotCaptions = screenshotCaptions;
    }

    public AdditionalAssets getAdditionalAssets() {
        return additionalAssets;
    }

    @XmlElement
    public void setAdditionalAssets(AdditionalAssets additionalAssets) {
        this.additionalAssets = additionalAssets;
    }
}
