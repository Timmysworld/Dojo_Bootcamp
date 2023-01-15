import java.util.HashMap;
import java.util.Set;
public class Hashmatique {
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Track 1", "I need Money...");
        trackList.put("track 2", "Many Men wish....");
        trackList.put("Track 3", "I got everything in my life except for a ....");
        trackList.put("Track 4", "Slam all in your face, wassup.....");

        //GETS SONG LYRICS BY TITLE
        System.out.println(trackList.get("Track 1"));


        Set<String> Tracks = trackList.keySet();
        for( String Songs : Tracks ){
            // GETS THE KEY
            // System.out.println(Tracks);

            // GETS THE VALUE
            // System.out.print(trackList.get(Songs));

            // GETS BOTH 
            System.out.println(String.format("Track: %s - Lyrics: %s", Songs, trackList.get(Songs)));
        }
    }
}
