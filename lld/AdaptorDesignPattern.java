package lld;
// Target interface (what client expects)
interface Report {
    String getJsonData();
}

// Adaptee (already exists, gives XML)
class XmlReportProvider {
    public String getXmlData() {
        return "<user><name>Alice</name><id>42</id></user>";
    }
}
//adapter
class XmlToJsonAdapter implements Report {
    private XmlReportProvider xmlProvider;

    public XmlToJsonAdapter(XmlReportProvider xmlProvider) {
        this.xmlProvider = xmlProvider;
    }

    @Override
    public String getJsonData() {
        // very simple conversion (hardcoded for learning)
        String xml = xmlProvider.getXmlData();

        // fake conversion just for demo
        return "{\"name\":\"Alice\", \"id\":42}";
    }
}

// Client (works only with Report interface)
class Client {
    public void printReport(Report report) {
        System.out.println(report.getJsonData());
    }
}

public class AdaptorDesignPattern {
    public static void main(String[] args) {

        XmlReportProvider xmlProvider = new XmlReportProvider();

        // wrap adaptee inside adapter
        Report adapter = new XmlToJsonAdapter(xmlProvider);

        Client client = new Client();
        client.printReport(adapter);
    }
}
