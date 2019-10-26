package rrrr;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    //    s1=args[0],s2=args[1],outputFile=args[2];
    public static void main(String[] args) throws IOException {
        System.out.println(null + "");

        String geoJsonString =
          "{\"type\":\"Point\",\"coordinates\":[]}";
//        String geoJsonString =
//          "{\"type\": \"Polygon\",\t\"coordinates\": [[[103.187599182129, 52.3042411804199], [103.188537597656, 52.3031234741211], [103.191513061523, 52.3033638000488], [103.193077087402, 52.3030433654785], [103.194808959961, 52.3037223815918], [103.202049255371, 52.3053817749023], [103.204521179199, 52.3081932067871], [103.210182189941, 52.3075408935547], [103.211013793945, 52.3072052001953]]]}";
//        String geoJsonString =
//          "{\"type\":\"MultiLineString\",\"coordinates\":[[[103.876764066667,52.6046430444444],[103.877041844445,52.6047819333333],[103.876764066667,52.6049208222222],[103.876486288889,52.6047819333333],[103.876764066667,52.6046430444444]]]}";
        GeoJsonObject geoJsonObject = new ObjectMapper().readValue(geoJsonString, GeoJsonObject.class);

        List<LngLatAlt> coords = getCoordsFromGeoJsonObject(geoJsonObject);

        String[] levels = "".split(";");
        StringBuffer riverLevels = new StringBuffer();
        if (levels != null) {
            for (String level : levels) {
                riverLevels
                  .append(Double.parseDouble(level))
                  .append("; ");
            }
        }
        System.out.println(riverLevels.toString());

        String mess = "<Msg Type=\"Query\"         QID=\"21\" \n\n\n\n\n\t\t  \tCmd=\"GetControlUnitReportsList\">\n" +
          " <Data UUID=\"{de57ae2d-82b6-4d4e-85eb-963422c5a45c}\" LastCount=\"10\"\n" +
          "StartTime=\"2000-01-01T00:00:00\" EndTime=\"2017-12-04T16:00:13\"/>\n" +
          "</Msg>";
        System.out.println(mess);
        System.out.println("====================");
        System.out.println(mess
          .replaceAll("\n", "")
          .replaceAll("\t", "")
          .replaceAll("  ", " ")
          .replaceAll("\r", "")
        );


        System.out.println("chem1: " + distance(52.5375259986, 103.906288146, 52.5359259986, 103.906288146));
        System.out.println("chem2: " + distance(52.5375259986, 103.906288146, 52.5373259986, 103.906288146));
        System.out.println("chem3: " + distance(52.5375259986, 103.906288146, 52.5371259986, 103.906288146));
        System.out.println("chem4: " + distance(52.5375259986, 103.906288146, 52.5375259986, 103.903288146));
        System.out.println("blast1: " + distance(52.5375259986, 103.906288146, 52.5375259986, 103.905288146));
        System.out.println("blast2: " + distance(52.5375259986, 103.906288146, 52.5335259986, 103.906288146));
        System.out.println("blast3: " + distance(52.5375259986, 103.906288146, 52.5375259986, 103.906088146));
        System.out.println("blast4: " + distance(52.5375259986, 103.906288146, 52.5345259986, 103.906288146));
        System.out.println("fire_liq1: " + distance(52.5375259986, 103.906288146, 52.5365259986, 103.906288146));
        System.out.println("fire_liq2: " + distance(52.5375259986, 103.906288146, 52.5359259986, 103.906288146));
        System.out.println("fire_liq3: " + distance(52.5375259986, 103.906288146, 52.5366259986, 103.906288146));
        System.out.println("fire_liq4: " + distance(52.5375259986, 103.906288146, 52.5372259986, 103.906288146));


//        ObjectMapper mapper = new ObjectMapper();
//        String json = "{\"type\": \"Polygon\",    \"coordinates\": [     [52.5359259986, 103.906288146], [52.5373259986, 103.906288146] ]  }";
//        String json = "{\"type\": \"Polygon\",    \"coordinates\": [     [52.5375259986, 103.905288146], [52.5335259986, 103.906288146], [52.5375259986, 103.906088146], [52.5345259986, 103.906288146] ]  }";
//        String json = "{\"type\":\"Point\", \"coordinates\":[52.5371259986, 103.906288146]}";
//        String json = "{\"type\":\"Point\", \"coordinates\":[52.5375259986, 103.903288146]}";
//        System.out.println(json);
//        GeoJson geoJson = mapper.readValue(json, GeoJson.class);
//        System.out.println(geoJson);
//        for (Double[] coord : geoJson.getCoordinates()) {
//            System.out.println(coord[0] + " " + coord[1]);
//        }


        System.out.println(Math.sqrt(2));
        System.out.println(Math.sqrt(9));
        System.out.println(Math.sqrt(16));
//        String polygon = "POLYGON ((103.906997680664 52.542797088623, 103.905296325684 52.5427780151367, 103.903732299805 52.5425796508789, 103.902275085449 52.5422248840332, 103.900733947754 52.5416526794434, 103.899826049805 52.5410957336426, 103.898742675781 52.5403099060059, 103.898223876953 52.5396308898926, 103.897636413574 52.5386619567871, 103.897521972656 52.5379371643066, 103.897499084473 52.5369682312012, 103.897727966309 52.536304473877, 103.89826965332 52.5352439880371, 103.89900970459 52.5345726013184, 103.90015411377 52.5337371826172, 103.90168762207 52.5330276489258, 103.903297424316 52.5325469970703, 103.904899597168 52.5323143005371, 103.906768798828 52.5322418212891, 103.908042907715 52.5323677062988, 103.909889221191 52.532657623291, 103.91130065918 52.5331954956055, 103.912666320801 52.5338020324707, 103.913597106934 52.5345993041992, 103.914405822754 52.5354309082031, 103.914939880371 52.5364418029785, 103.915061950684 52.5371437072754, 103.915092468262 52.5382766723633, 103.914604187012 52.5392570495605, 103.913993835449 52.5401573181152, 103.912818908691 52.5410919189453, 103.91153717041 52.5417747497559, 103.910057067871 52.5422973632813, 103.908493041992 52.5426330566406, 103.907791137695 52.5427131652832, 103.907730102539 52.5427169799805, 103.906997680664 52.542797088623))";
        String polygon = "POLYGON ((103.906112670898 52.5382919311523, 103.90584564209 52.538257598877, 103.905586242676 52.5382118225098, 103.905326843262 52.5380973815918, 103.905059814453 52.5379333496094, 103.904891967773 52.5377159118652, 103.904853820801 52.537483215332, 103.904937744141 52.5372467041016, 103.905128479004 52.5370750427246, 103.905372619629 52.5369300842285, 103.905670166016 52.5368232727051, 103.905990600586 52.5367774963379, 103.90625 52.536750793457, 103.906555175781 52.5367736816406, 103.906852722168 52.5368003845215, 103.907165527344 52.536922454834, 103.907371520996 52.5370140075684, 103.907600402832 52.5372085571289, 103.907691955566 52.5373802185059, 103.907730102539 52.5376052856445, 103.907638549805 52.5377616882324, 103.907508850098 52.5379524230957, 103.907218933105 52.5381088256836, 103.906959533691 52.5382194519043, 103.90657043457 52.5382766723633, 103.906494140625 52.5382881164551, 103.906509399414 52.5382804870605, 103.906394958496 52.5382957458496, 103.906112670898 52.5382919311523))";
        System.out.println(getRadiusFromPolygon(polygon));

        Map<String, Double> map = new ConcurrentHashMap<>();
        Double aDouble = new Double(5);
        for (int i = 0; i < 4; i++) {
            map.put(i + "", aDouble);
        }
        map.forEach((s, aDouble1) -> System.out.println(s + ": " + aDouble1));

        MessageType no_data_fuel_storage_poo = MessageType.valueOf("NO_DATA_FUEL_STORAGE_POO");
        System.out.println(no_data_fuel_storage_poo);

        Date dateFrom = new Date(System.currentTimeMillis() - 86400000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = dateFormat.format(dateFrom).replace(" ", "T") + ".000Z";
        System.out.println(strDate);
        String s = "17.11.2014 11:43:51.410 TRACE: 9.6.25.83:54650\t> Position [pos_ID=2, item=202129_KG, dateOperation=Mon Nov 17 10:43:53 MSK 2014, depart=0, quant=0.644, price=320.19, priceDisc=320.19, ck_Summa=206.20236, ck_NDS=0.0, discSumma=0.0, discPercent=0.0, minPrice=0.0, defDiscSumma=0.0, numOldPos=2, numKit=0, barCode=2400154006442, barCode1=, fixPrice=0.0, isGift=false]\n";
//        String s1="[a-zA-Z]{5}";
//        String s2="c:\\111\\Java\\log\\";
//        String outputFile="c:\\111\\dz2a_output.log";
        try {
            String s1 = args[0];
            String s2 = args[1];
            String outputFile = args[2];
            Pattern p = Pattern.compile(s1);
            File f = new File(outputFile);
            FileWriter fr = new FileWriter(f);
            File folder = new File(s2);
            String[] files = folder.list(new FilenameFilter() {
                @Override
                public boolean accept(File folder, String name) {
                    return name.contains("");
                }
            });
            for (String fileName : files) {
                System.out.println("File: " + fileName);
//            --
                File file = new File(s2 + fileName);
                FileReader fr1 = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr1);
                s = reader.readLine();
                while (s != null) {
//                System.out.println(s);
                    Matcher m = p.matcher(s);
                    while (m.find())
                        fr.write(m.group() + "\n");
                    s = reader.readLine();
                }
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("Params not input!");
            e.printStackTrace();
        }

    }

    private static List<LngLatAlt> getCoordsFromGeoJsonObject(GeoJsonObject geoJsonObject) {
        List<LngLatAlt> coords = new ArrayList<>();
        if (geoJsonObject instanceof Point) {
            LngLatAlt coordinates = ((Point) geoJsonObject).getCoordinates();
            coords.add(coordinates);
        }
        if (geoJsonObject instanceof Polygon) {
            List<List<LngLatAlt>> coordinates = ((Polygon) geoJsonObject).getCoordinates();
            coordinates.forEach(coord -> coords.addAll(coord));
        }
        if (geoJsonObject instanceof MultiLineString) {
            List<List<LngLatAlt>> coordinates = ((MultiLineString) geoJsonObject).getCoordinates();
            coordinates.forEach(coord -> coords.addAll(coord));
        }
        if (geoJsonObject instanceof MultiPolygon) {
            List<List<List<LngLatAlt>>> coordinates = ((MultiPolygon) geoJsonObject).getCoordinates();
            coordinates.forEach(cs -> cs.forEach(coord -> coords.addAll(coord)));
        }
        if (geoJsonObject instanceof MultiPoint) {
            List<LngLatAlt> coordinates = ((MultiPoint) geoJsonObject).getCoordinates();
            coords.addAll(coordinates);
        }
        if (geoJsonObject instanceof LineString) {
            List<LngLatAlt> coordinates = ((LineString) geoJsonObject).getCoordinates();
            coords.addAll(coordinates);
        }
        return coords;
    }

    public static Double getRadiusFromPolygon(String firePolygon) {
        firePolygon = firePolygon
          .replaceAll("[A-Za-z]", "")
          .replaceAll("\\(", "")
          .replaceAll("\\)", "");

        String[] coords = firePolygon.split(",");
        Double maxLatitude = Double.MIN_VALUE;
        Double maxLongitude = Double.MIN_VALUE;
        Double minLatitude = Double.MAX_VALUE;
        Double minLongitude = Double.MAX_VALUE;

        for (String c : coords) {
            Double lat = Double.parseDouble(c.trim().split(" ")[1]);
            Double lon = Double.parseDouble(c.trim().split(" ")[0]);
            if (lat > maxLatitude) {
                maxLatitude = lat;
            }
            if (lat < minLatitude) {
                minLatitude = lat;
            }
            if (lon > maxLongitude) {
                maxLongitude = lon;
            }
            if (lon < minLongitude) {
                minLongitude = lon;
            }
        }
        double hypotenuse = distance(maxLatitude, maxLongitude, minLatitude, minLongitude);
        return hypotenuse / (2 * Math.sqrt(2) * 1.12);
    }

    public static double distance(Double lat1, Double lon1, Double lat2, Double lon2) {
        if (lat1 == null || lon1 == null || lat2 == null || lon2 == null) {
            return Double.MAX_VALUE;
        }

//        pi / 180
        double p = 0.017453292519943295;
        double a = 0.5 - Math.cos((lat2 - lat1) * p) / 2 +
          Math.cos(lat1 * p) * Math.cos(lat2 * p) *
            (1 - Math.cos((lon2 - lon1) * p)) / 2;

//        R земли 6371 км * 2 * 1000 метров в км
        return 12742000 * Math.asin(Math.sqrt(a));
    }
}
