import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://www.wallpaper.com/technology");
        URLConnection con = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            Document document = Jsoup.parse(line);
            Elements elements = document.select("body");

            for (Element element : elements) {
                String link = String.valueOf(element.getElementsContainingText("data-fallback"))
                        .replaceAll("<body>", "").replaceAll("</body>", "")
                        .replaceAll("data-fallback=", "")
                        .replaceAll("\"", "").trim();
                if (link.contains("https")) {
                    String name = link.substring(link.lastIndexOf("/") + 1);
                    System.out.println("IMAGE NAME:  " + name);
                    System.out.println("IMAGE LINK:  " + link);
                    System.out.println();
                }
            }
        }
    }
}
