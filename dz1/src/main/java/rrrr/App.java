package rrrr;

import com.google.gwt.http.client.*;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

/**
 * Hello world!
 */
public class App {
    public static void doGet(String url) {
        RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, url);

        try {
            rb.sendRequest(null, new RequestCallback() {

                @Override
                public void onResponseReceived(Request request, Response response) {
                    JSONValue jsonValue = JSONParser.parseStrict(response.getText());

                    JSONObject customerObject = jsonValue.isObject();
                    JSONArray jsonArray = customerObject.get("customers").isArray();

                    StringBuilder builder = new StringBuilder("** CUSTOMER DATA ** \n");
                    builder.append(jsonArray.get(0).isObject().get("FirstName").isString().stringValue()).append(" ");
                    builder.append(jsonArray.get(0).isObject().get("Surname").isString().stringValue());
                    builder.append("\n");
                    builder.append(jsonArray.get(1).isObject().get("FirstName").isString().stringValue()).append(" ");
                    builder.append(jsonArray.get(1).isObject().get("Surname").isString().stringValue());

                }

                @Override
                public void onError(Request request, Throwable exception) {
                    exception.printStackTrace();
                }
            });
        } catch (RequestException e) {
            e.printStackTrace();
        }
    }

    public void onModuleLoad() {
        doGet("/");
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Distance for 52.5375259986, 103.906288146, 52.0, 103.0: " + distance(52.5375259986, 103.906288146, 52.0, 103.0) + " (м)");
        System.out.println("Distance for 52.5375259986, 103.906288146, 52.53, 103.90: " + distance(52.5375259986, 103.906288146, 52.53, 103.90) + " (м)");

        System.out.println("Distance for 52.5375259986, 103.906288146, 52.536, 103.906288146: " + distance(52.5375259986, 103.906288146, 52.536, 103.906288146) + " (м)");
        System.out.println("Distance for 52.5375259986, 103.906288146, 52.537, 103.906: " + distance(52.5375259986, 103.906288146, 52.537, 103.906) + " (м)");
        System.out.println("Distance for 52.5375259986, 103.906288146, 52.538, 103.9062: " + distance(52.5375259986, 103.906288146, 52.538, 103.9062) + " (м)");

//       doGet("http://192.168.2.108/presumableDangerousFacilities");
//        String s = "aaa %s bbb";
//        System.out.println(s.replace("%s","ccc"));
//        System.out.println(s.replace("%s","ddd"));
        /*Double[] latitudes = {52.495002833020564, 52.495001749734556, 52.494998502486254, 52.49499309909858, 52.49498555258875,
          52.49497588113698, 52.49496410804264, 52.49495026166814, 52.49493437537061, 52.49491648742154, 52.49489664091457,
          52.49487488366166, 52.49485126807794, 52.494825851055424, 52.49479869382595, 52.49476986181366, 52.49473942447739,
          52.49470745514335, 52.49467403082847, 52.49463923205486, 52.4946031426558, 52.49456584957382, 52.49452744265121,
          52.49448801441363, 52.49444765984715, 52.49440647616945, 52.49436456259562, 52.49432202009913, 52.49427895116858,
          52.494235459560805, 52.49419165005088, 52.49414762817977, 52.4941035, 52.494059371820235, 52.49401534994912,
          52.4939715404392, 52.49392804883142, 52.49388497990087, 52.49384243740438, 52.49380052383055, 52.493759340152856,
          52.49371898558637, 52.49367955734879, 52.493641150426186, 52.493603857344205, 52.493567767945144, 52.49353296917153,
          52.493499544856654, 52.493467575522615, 52.493437138186344, 52.493408306174054, 52.49338114894458, 52.493355731922065,
          52.493332116338344, 52.493310359085434, 52.49329051257846, 52.49327262462939, 52.493256738331866, 52.493242891957365,
          52.49323111886302, 52.49322144741125, 52.493213900901424, 52.49320849751375, 52.49320525026545, 52.49320416697944,
          52.49320525026545, 52.49320849751375, 52.493213900901424, 52.49322144741125, 52.49323111886302, 52.493242891957365,
          52.493256738331866, 52.49327262462939, 52.49329051257846, 52.493310359085434, 52.493332116338344, 52.493355731922065,
          52.49338114894458, 52.493408306174054, 52.493437138186344, 52.493467575522615, 52.493499544856654, 52.49353296917153,
          52.493567767945144, 52.493603857344205, 52.493641150426186, 52.49367955734879, 52.49371898558637, 52.493759340152856,
          52.49380052383055, 52.49384243740438, 52.49388497990087, 52.49392804883142, 52.4939715404392, 52.49401534994912,
          52.494059371820235, 52.4941035, 52.49414762817977, 52.49419165005088, 52.494235459560805, 52.49427895116858,
          52.49432202009913, 52.49436456259562, 52.49440647616945, 52.49444765984715, 52.49448801441363, 52.49452744265121,
          52.49456584957382, 52.4946031426558, 52.49463923205486, 52.49467403082847, 52.49470745514335, 52.49473942447739,
          52.49476986181366, 52.49479869382595, 52.494825851055424, 52.49485126807794, 52.49487488366166, 52.49489664091457,
          52.49491648742154, 52.49493437537061, 52.49495026166814, 52.49496410804264, 52.49497588113698, 52.49498555258875,
          52.49499309909858, 52.494998502486254, 52.495001749734556, 52.495002833020564};
        Double avgLatit = 0.;

        for (Double val : latitudes) {
            avgLatit += val;
        }
        System.out.println(avgLatit / latitudes.length);

        double[] longitudes = {103.8283076,
          103.82839585635953,
          103.82848390010176,
          103.82857151912161,
          103.82865850233716,
          103.82874464019827,
          103.82882972519124,
          103.8289135523389,
          103.8289959196943,
          103.82907662882727,
          103.82915548530242,
          103.82923229914763,
          103.8293068853116,
          103.82937906410972,
          103.82944866165694,
          103.8295155102867,
          103.82957944895477,
          103.82964032362732,
          103.8296979876519,
          103.82975230211085,
          103.82980313615587,
          103.82985036732332,
          103.82989388182914,
          103.82993357484308,
          103.82996935074122,
          103.83000112333627,
          103.83002881608527,
          103.83005236227396,
          103.8300717051775,
          103.83008679819716,
          103.83009760497251,
          103.83010409946911,
          103.83010626604113,
          103.83010409946911,
          103.83009760497251,
          103.83008679819716,
          103.8300717051775,
          103.83005236227396,
          103.83002881608527,
          103.83000112333627,
          103.82996935074122,
          103.82993357484308,
          103.82989388182914,
          103.82985036732332,
          103.82980313615587,
          103.82975230211085,
          103.8296979876519,
          103.82964032362732,
          103.82957944895477,
          103.8295155102867,
          103.82944866165694,
          103.82937906410972,
          103.8293068853116,
          103.82923229914763,
          103.82915548530242,
          103.82907662882727,
          103.8289959196943,
          103.8289135523389,
          103.82882972519124,
          103.82874464019827,
          103.82865850233716,
          103.82857151912161,
          103.82848390010176,
          103.82839585635953,
          103.8283076,
          103.82821934364047,
          103.82813129989825,
          103.8280436808784,
          103.82795669766284,
          103.82787055980174,
          103.82778547480876,
          103.8277016476611,
          103.82761928030571,
          103.82753857117274,
          103.82745971469758,
          103.82738290085237,
          103.82730831468841,
          103.82723613589029,
          103.82716653834306,
          103.82709968971331,
          103.82703575104523,
          103.82697487637269,
          103.8269172123481,
          103.82686289788916,
          103.82681206384413,
          103.82676483267669,
          103.82672131817087,
          103.82668162515692,
          103.82664584925878,
          103.82661407666373,
          103.82658638391473,
          103.82656283772604,
          103.8265434948225,
          103.82652840180285,
          103.8265175950275,
          103.8265111005309,
          103.82650893395888,
          103.8265111005309,
          103.8265175950275,
          103.82652840180285,
          103.8265434948225,
          103.82656283772604,
          103.82658638391473,
          103.82661407666373,
          103.82664584925878,
          103.82668162515692,
          103.82672131817087,
          103.82676483267669,
          103.82681206384413,
          103.82686289788916,
          103.8269172123481,
          103.82697487637269,
          103.82703575104523,
          103.82709968971331,
          103.82716653834306,
          103.82723613589029,
          103.82730831468841,
          103.82738290085237,
          103.82745971469758,
          103.82753857117274,
          103.82761928030571,
          103.8277016476611,
          103.82778547480876,
          103.82787055980174,
          103.82795669766284,
          103.8280436808784,
          103.82813129989825,
          103.82821934364047,
          103.8283076};

        double avgLon = 0.;
        for (double val : longitudes) {
            avgLon += val;
        }
        System.out.println(avgLon / longitudes.length);

        double distance = distance(52.4941035, 103.8283076, avgLatit / latitudes.length, avgLon / longitudes.length);
        System.out.println(String.format("%.5f", distance));

        String polygon = "MULTIPOLYGON (((103.8283076 52.495002833020564, 103.82839585635953 52.495001749734556, 103.82848390010176 52.494998502486254, 103.82857151912161 52.49499309909858, 103.82865850233716 52.49498555258875, 103.82874464019827 52.49497588113698, 103.82882972519124 52.49496410804264, 103.8289135523389 52.49495026166814, 103.8289959196943 52.49493437537061, 103.82907662882727 52.49491648742154, 103.82915548530242 52.49489664091457, 103.82923229914763 52.49487488366166, 103.8293068853116 52.49485126807794, 103.82937906410972 52.494825851055424, 103.82944866165694 52.49479869382595, 103.8295155102867 52.49476986181366, 103.82957944895477 52.49473942447739, 103.82964032362732 52.49470745514335, 103.8296979876519 52.49467403082847, 103.82975230211085 52.49463923205486, 103.82980313615587 52.4946031426558, 103.82985036732332 52.49456584957382, 103.82989388182914 52.49452744265121, 103.82993357484308 52.49448801441363, 103.82996935074122 52.49444765984715, 103.83000112333627 52.49440647616945, 103.83002881608527 52.49436456259562, 103.83005236227396 52.49432202009913, 103.8300717051775 52.49427895116858, 103.83008679819716 52.494235459560805, 103.83009760497251 52.49419165005088, 103.83010409946911 52.49414762817977, 103.83010626604113 52.4941035, 103.83010409946911 52.494059371820235, 103.83009760497251 52.49401534994912, 103.83008679819716 52.4939715404392, 103.8300717051775 52.49392804883142, 103.83005236227396 52.49388497990087, 103.83002881608527 52.49384243740438, 103.83000112333627 52.49380052383055, 103.82996935074122 52.493759340152856, 103.82993357484308 52.49371898558637, 103.82989388182914 52.49367955734879, 103.82985036732332 52.493641150426186, 103.82980313615587 52.493603857344205, 103.82975230211085 52.493567767945144, 103.8296979876519 52.49353296917153, 103.82964032362732 52.493499544856654, 103.82957944895477 52.493467575522615, 103.8295155102867 52.493437138186344, 103.82944866165694 52.493408306174054, 103.82937906410972 52.49338114894458, 103.8293068853116 52.493355731922065, 103.82923229914763 52.493332116338344, 103.82915548530242 52.493310359085434, 103.82907662882727 52.49329051257846, 103.8289959196943 52.49327262462939, 103.8289135523389 52.493256738331866, 103.82882972519124 52.493242891957365, 103.82874464019827 52.49323111886302, 103.82865850233716 52.49322144741125, 103.82857151912161 52.493213900901424, 103.82848390010176 52.49320849751375, 103.82839585635953 52.49320525026545, 103.8283076 52.49320416697944, 103.82821934364047 52.49320525026545, 103.82813129989825 52.49320849751375, 103.8280436808784 52.493213900901424, 103.82795669766284 52.49322144741125, 103.82787055980174 52.49323111886302, 103.82778547480876 52.493242891957365, 103.8277016476611 52.493256738331866, 103.82761928030571 52.49327262462939, 103.82753857117274 52.49329051257846, 103.82745971469758 52.493310359085434, 103.82738290085237 52.493332116338344, 103.82730831468841 52.493355731922065, 103.82723613589029 52.49338114894458, 103.82716653834306 52.493408306174054, 103.82709968971331 52.493437138186344, 103.82703575104523 52.493467575522615, 103.82697487637269 52.493499544856654, 103.8269172123481 52.49353296917153, 103.82686289788916 52.493567767945144, 103.82681206384413 52.493603857344205, 103.82676483267669 52.493641150426186, 103.82672131817087 52.49367955734879, 103.82668162515692 52.49371898558637, 103.82664584925878 52.493759340152856, 103.82661407666373 52.49380052383055, 103.82658638391473 52.49384243740438, 103.82656283772604 52.49388497990087, 103.8265434948225 52.49392804883142, 103.82652840180285 52.4939715404392, 103.8265175950275 52.49401534994912, 103.8265111005309 52.494059371820235, 103.82650893395888 52.4941035, 103.8265111005309 52.49414762817977, 103.8265175950275 52.49419165005088, 103.82652840180285 52.494235459560805, 103.8265434948225 52.49427895116858, 103.82656283772604 52.49432202009913, 103.82658638391473 52.49436456259562, 103.82661407666373 52.49440647616945, 103.82664584925878 52.49444765984715, 103.82668162515692 52.49448801441363, 103.82672131817087 52.49452744265121, 103.82676483267669 52.49456584957382, 103.82681206384413 52.4946031426558, 103.82686289788916 52.49463923205486, 103.8269172123481 52.49467403082847, 103.82697487637269 52.49470745514335, 103.82703575104523 52.49473942447739, 103.82709968971331 52.49476986181366, 103.82716653834306 52.49479869382595, 103.82723613589029 52.494825851055424, 103.82730831468841 52.49485126807794, 103.82738290085237 52.49487488366166, 103.82745971469758 52.49489664091457, 103.82753857117274 52.49491648742154, 103.82761928030571 52.49493437537061, 103.8277016476611 52.49495026166814, 103.82778547480876 52.49496410804264, 103.82787055980174 52.49497588113698, 103.82795669766284 52.49498555258875, 103.8280436808784 52.49499309909858, 103.82813129989825 52.494998502486254, 103.82821934364047 52.495001749734556, 103.8283076 52.495002833020564)))";
        polygon = polygon.replaceAll("[A-Za-z]", "").replaceAll("\\(", "").replaceAll("\\)", "");
        System.out.println(polygon);

        String[] coords = polygon.split(",");
        double avgLongi = 0.;
        double avgLati = 0.;

        for (String c : coords) {
            avgLati += Double.parseDouble(c.trim().split(" ")[1]);
            avgLongi += Double.parseDouble(c.trim().split(" ")[0]);
        }
        avgLongi /= coords.length;
        avgLati /= coords.length;
        System.out.println(String.format("%.6f %.6f", avgLati, avgLongi));*/
        /*Boolean b = null;
        System.out.println(new Date());

        System.out.println(String.format("%.5f", 0.));
        System.out.println(String.format("%.5f", 10.));
        System.out.println(String.format("%.5f", 10.1));
        System.out.println(String.format("%.5f", 0.1));
        System.out.println(String.format("%.5f", 10.234));
        System.out.println(String.format("%.5f", -0.234));
        System.out.println(String.format("%.5f", -10.234));*/
       /* long startTime = System.currentTimeMillis();
        @Cleanup BufferedWriter writer = new BufferedWriter(new FileWriter("duplicateRuuid.dat"));
        Set<String> matches = new HashSet<>();
        List<String> ruuids = Files.readAllLines(Paths.get("C:/111/JavaProgs/tlssocket/ruuids.txt"));
        for (int i = 0; i < ruuids.size() - 1; i++) {
            for (int j = i + 1; j < ruuids.size(); j++) {
                if (ruuids.get(i).equalsIgnoreCase(ruuids.get(j))) {
//                    System.out.println("RUUID на строке " + (i + 1) + " равен RUUID на строке " + (j + 1) + " " + ruuids.get(i));
                    matches.add(ruuids.get(i));
                    writer.write(ruuids.get(i) + System.lineSeparator());
                }
            }
        }

//        ruuids = Files.readAllLines(Paths.get("duplicateRuuid.dat"));
//        Set<String> matches = new HashSet<>(ruuids);

        System.out.println("Всего совпадений: " + matches.size());
        System.out.println("\tЗаняло:    " + ((System.currentTimeMillis() - startTime) / 1000) + " секунд.");
        List<GetControlUnitReportsListResp> matchCU = new ArrayList<>();
        List<String> reports = Files.readAllLines(Paths.get("C:/111/PerfomanceLab/javaProgs/reports.txt"));
        StringBuilder sb = new StringBuilder();
        ObjectMapper xmlMapper = new XmlMapper();

        reports.forEach(line -> {
            sb.append(line);
            if (line.contains("GetControlUnitReportsList")) {
                sb.delete(0, sb.length());
                sb.append(line);
            }
            if (line.contains("</Msg>")) {
                try {
                    matchCU.add(xmlMapper.readValue(sb.toString(), GetControlUnitReportsListResp.class));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("Всего устройств: " + matchCU.size());
        System.out.println("\tЗаняло:    " + ((System.currentTimeMillis() - startTime) / 1000) + " секунд.");
        writer = new BufferedWriter(new FileWriter("duplicates.dat"));

        for (GetControlUnitReportsListResp cu : matchCU) {
//            System.out.println("Проверяем устройство: " + cu.getDataType().getUuid());
            if (cu.getDataType().getReports() != null) {
                for (GetControlUnitReportsListRespReport r : cu.getDataType().getReports()) {
                    if (matches.contains(r.getUuid())) {
                        writer.write(xmlMapper.writeValueAsString(cu) + System.lineSeparator());
                        System.out.println("Устройство: " + cu.getDataType().getUuid() + " с дубликатами.");
                        break;
                    }
                }
            }
        }
        System.out.println("\tЗаняло:    " + ((System.currentTimeMillis() - startTime) / 1000) + " секунд.");

        List<String> strReports = Files.readAllLines(Paths.get("C:/111/PerfomanceLab/javaProgs/reportsFromDuplicateCU.txt"));
        List<GetControlUnitReportResp> reportsList = new ArrayList<>();
        sb.delete(0, sb.length());

        strReports.forEach(line -> {
            sb.append(line);
            if (line.contains("GetControlUnitReport")) {
                sb.delete(0, sb.length());
                sb.append(line);
            }
            if (line.contains("</Msg>")) {
                try {
                    GetControlUnitReportResp rep = xmlMapper.readValue(sb.toString(), GetControlUnitReportResp.class);
                    if (matches.contains(rep.getDataType().getRuuid())) {
                        reportsList.add(rep);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("Одинаковых отчётов: " + reportsList.size());
        System.out.println("\tЗаняло:    " + ((System.currentTimeMillis() - startTime) / 1000) + " секунд.");

        writer = new BufferedWriter(new FileWriter("Content.dat"));
        for (GetControlUnitReportResp rep : reportsList) {
            writer.write(rep.getDataType().getReport().getContent() + System.lineSeparator() + System.lineSeparator());
        }

        System.out.println("\tЗаняло:    " + ((System.currentTimeMillis() - startTime) / 1000) + " секунд.");
*/
/*

        String dataStr = "2017-02-01T09:54:00";

        Date reportTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dataStr.replace("T", " "));
        Date dateFrom = new Date(new Date().getTime() - 7 * 3600 * 24 * 1000);
        System.out.println(reportTime.after(dateFrom));
*/


//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        MyProcessor myProcessor = new MyProcessor();
//        MyRouteBuilder myRouteBuilder = new MyRouteBuilder();
//        DefaultCamelContext camelContext = new DefaultCamelContext();
//        camelContext.addRoutes(myRouteBuilder);
//        camelContext.start();
//        Thread.sleep(10000);
//        camelContext.stop();
/*

        camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new JmsConsumerRoute());
        camelContext.start();
        Thread.sleep(5000);
        camelContext.stop();
*/

//        FileCopierWithCamel fileCopierWithCamel = new FileCopierWithCamel();
//        fileCopierWithCamel.getXmlJsonFormat().setEncoding("UTF-8");
//        fileCopierWithCamel.getXmlJsonFormat().setForceTopLevelObject(true);
//        fileCopierWithCamel.getXmlJsonFormat().setTrimSpaces(true);
////        fileCopierWithCamel.getXmlJsonFormat().setRootName ("Admin");
//        fileCopierWithCamel.getXmlJsonFormat().setSkipNamespaces(true);
//        fileCopierWithCamel.getXmlJsonFormat().setRemoveNamespacePrefixes(true);
////        fileCopierWithCamel.getXmlJsonFormat().setExpandableProperties  ("UTF-8");

        /*CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(fileCopierWithCamel);
        camelContext.setTracing(true);
        camelContext.start();
        Thread.sleep(10000);
        camelContext.stop();*/

//        String value = TestEnum.GET_EVENT.name();
//        System.out.println(TestEnum.GET_EVENT.name());
//        System.out.println(TestEnum.GET_EVENT.value);
//        TestEnum[] values = TestEnum.values();
//        for (TestEnum v:values             ) {
//            System.out.println(v.name()+" "+v.stats);
//        }

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String s=reader.readLine(),s1=reader.readLine();
//        System.out.println( "Hello World!" );


//        String s = "17.11.2014 16:03:35.801 TRACE: 9.6.25.83:59883\t> Position [pos_ID=1, item=152301_ST, dateOperation=Mon Nov 17 15:03:33 MSK 2014, depart=0, quant=1.0, price=46.09, priceDisc=46.09, ck_Summa=46.09, ck_NDS=0.0, discSumma=0.0, discPercent=0.0, minPrice=0.0, defDiscSumma=0.0, numOldPos=1, numKit=0, barCode=4600682477150, barCode1=, fixPrice=0.0, isGift=false]";
//        System.out.println(s);
//        s=s.replace(' ',';');
//        System.out.println(s);
//        ArrayList<String> a=new ArrayList();
//        int i=0;
//        for (String retval:s.split(", ")) {
//            a.add(retval);
//            i++;
//        }
//        for (String ss:a
//             ) {
//            System.out.println(ss);
//        }

//        1
//        System.out.println("Vvedi name of file");
//        String s=reader.readLine(),s1=reader.readLine();
//        String s="c:\\111\\main.log.2014-11-17",s1="c:\\111\\Java\\log\\v_";
/*
        try {


            String s = args[0], s1 = args[1];
//            String s="c:\\111\\output.txt";
//            String s1="c:\\111\\log\\";
//        try (BufferedReader reader1 = new BufferedReader(
//                new InputStreamReader(
//                        new FileInputStream(s), StandardCharsets.UTF_8))){
//            String line;
//            while ((line = reader1.readLine()) != null) {
//                System.out.println(line);
//                line=line.replace(' ',';');
//
//            }
//        } catch (IOException e) {
//            // log error
//        }
            RandomAccessFile raf = new RandomAccessFile(s, "r");
            long numSplits = 5; //from user input, extract it from args
            long sourceSize = raf.length();
            long bytesPerSplit = sourceSize / numSplits;
            long remainingBytes = sourceSize % numSplits;
            int maxReadBufferSize = 8 * 1024; //8KB
            for (int destIx = 1; destIx <= numSplits; destIx++) {
                BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(s1 + destIx + ".log"));
                if (bytesPerSplit > maxReadBufferSize) {
                    long numReads = bytesPerSplit / maxReadBufferSize;
                    long numRemainingRead = bytesPerSplit % maxReadBufferSize;
                    for (int i = 0; i < numReads; i++) {
                        readWrite(raf, bw, maxReadBufferSize);
                    }
                    if (numRemainingRead > 0) {
                        readWrite(raf, bw, numRemainingRead);
                    }
                } else {
                    readWrite(raf, bw, bytesPerSplit);
                }
                if (remainingBytes > 0 && destIx == numSplits) {
//                    BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(s1 + (numSplits + 1)+".log"));
                    readWrite(raf, bw, remainingBytes);
//                    bw.close();
                }
                bw.close();
            }

            raf.close();
        } catch (Exception e) {
            System.out.println("Params not input!");
            e.printStackTrace();
        }

    }

    static void readWrite(RandomAccessFile raf, BufferedOutputStream bw, long numBytes) throws IOException {
        byte[] buf = new byte[(int) numBytes];
        int val = raf.read(buf);
        if (val != -1) {
            bw.write(buf);
        }
*/
    }

    //    2
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

