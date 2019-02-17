package rrrr.route;

import lombok.Data;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.springframework.stereotype.Component;
import rrrr.MyProcessor;

@Data
@Component
public class FileCopierWithCamel extends RouteBuilder {
    XmlJsonDataFormat xmlJsonFormat = new XmlJsonDataFormat();

    @Override
    public void configure() throws Exception {
//        from("file:C:/111/?fileName=1.a&noop=true")
//                .to("file:C:/111/JS/?fileName=1.a");
        from("file://c:/111/JS/n1/?recursive=true&noop=true&maxDepth=1000")
                .choice()
                .when()
                .simple("${file:ext} == 'html'")
                .transform(simple("***** html *****\r\n${in.body}"))
                .to("file://c:/111/JS/n2")
                .when()
                .simple("${file:ext} == 'js'")
                .process(new MyProcessor())
                .to("file://c:/111/JS/n3")
                .when()
                .simple("${file:ext} == 'xml'")
                .marshal()
                .xmljson()
                //.marshal().json(JsonLibrary.Jackson)
                .to("file://c:/111/JS/n5")
                .otherwise()
                .to("file://c:/111/JS/n4")
                .endChoice();

    }
}
