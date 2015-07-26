package uluru.lookupstation;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LookUpStation {
	
	ArrayList<String> stationArray = new ArrayList<String>();
	
	public LookUpStation(String url) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document doc;
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
		
		NodeList nl = doc.getElementsByTagName("station_join");
        for (int i = 0; i < nl.getLength(); i++ ) {
        	stationArray.add(getTagContent((Element)nl.item(i), "station_name1"));
        }
        //路線の両端をチェック
        if (! stationArray.contains(getTagContent((Element)nl.item(0), "station_name2")))
        	stationArray.add(0, getTagContent((Element)nl.item(0), "station_name2"));
        if (! stationArray.contains(getTagContent((Element)nl.item(nl.getLength()-1), "station_name2")))
        	stationArray.add(getTagContent((Element)nl.item(nl.getLength()-1), "station_name2"));
	}
	
	public ArrayList<String> getStationArray() {
		return stationArray;
	}
	
	public String getTagContent(Element e, String tagName) { 
		return e.getElementsByTagName(tagName).item(0).getFirstChild().getNodeValue();
	}
}
