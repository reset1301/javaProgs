package rrr;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
    private boolean keywords, keyword, title, image, description, screenshotCaptions, trailer;

    public SaxHandler() {
        super();
        keyword = keywords = title = image = description = screenshotCaptions = trailer = false;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing XML.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document.");
    }

    public void startElement(String uri, String name,
                             String qName, Attributes atts) {
        if (qName.equalsIgnoreCase("Keywords")) {
            keywords = true;
        } else if (qName.equalsIgnoreCase("Keyword")) {
            keyword = true;
        } else if (qName.equalsIgnoreCase("Description")) {
            description = true;
        } else if (qName.equalsIgnoreCase("ScreenshotCaptions")) {
            screenshotCaptions = true;
        } else if (qName.equalsIgnoreCase("Trailer")) {
            trailer = true;
            System.out.println("Trailer attr: " + atts.getValue("FileName"));
        } else if (qName.equalsIgnoreCase("Title")) {
            title = true;
        } else if (qName.equalsIgnoreCase("Images")) {
            image = true;
        }

//        if ("".equals(uri))
//            System.out.println("Start element: " + qName);
//        else
//            System.out.println("Start element: {" + uri + "}" + name);
    }


    public void endElement(String uri, String name, String qName) {
        if ("".equals(uri))
            System.out.println("End element: " + qName);
        else
            System.out.println("End element:   {" + uri + "}" + name);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (keywords) {
            System.out.println("keywords: "
                    + new String(ch, start, length));
            keywords = false;
        } else if (keyword) {
            System.out.println("keyword: " + new String(ch, start, length));
            keyword = false;
        } else if (title) {
            System.out.println("title: " + new String(ch, start, length));
            title = false;
        } else if (trailer) {
            System.out.println("trailer: " + new String(ch, start, length));
            trailer = false;
        }else if (image) {
            System.out.println("image: " + new String(ch, start, length));
            image = false;
        }else if (screenshotCaptions) {
            System.out.println("screenshotCaptions: " + new String(ch, start, length));
            screenshotCaptions = false;
        }
//        System.out.print("Characters:    \"");
//        for (int i = start; i < start + length; i++) {
//            switch (ch[i]) {
//                case '\\':
//                    System.out.print("\\\\");
//                    break;
//                case '"':
//                    System.out.print("\\\"");
//                    break;
//                case '\n':
//                    System.out.print("\\n");
//                    break;
//                case '\r':
//                    System.out.print("\\r");
//                    break;
//                case '\t':
//                    System.out.print("\\t");
//                    break;
//                default:
//                    System.out.print(ch[i]);
//                    break;
//            }
//        }
//        System.out.print("\"\n");
    }
}
