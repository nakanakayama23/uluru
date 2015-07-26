package uluru.lookupstation;


/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	LookUpStation ns = new LookUpStation("http://www.ekidata.jp/api/n/11302.xml");
    	
    	//getStationArrayで駅情報が入ったコレクションが帰ってくる
    	for (String station : ns.getStationArray()) {
    		System.out.println(station);
    	}
    }
}
