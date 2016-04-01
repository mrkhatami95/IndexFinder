import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import javax.swing.plaf.synth.SynthButtonUI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Formatter;

/**
 * Created by MR on 3/30/2015.
 */
public class LinkFinder
{
    public static void main(String[] args)
    {
        //int page = 10;
        boolean flag = false;
        //String query = "آموزش";
        File file = new File("d:\\log.txt");
        try
        {
            long startTime = System.currentTimeMillis();
            /*to get all yahoo (home page) images.
		    doc = Jsoup.connect("http://yahoo.com").get();
		    Elements images = doc2.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
		    for (Element image : images) {

			    System.out.println("\nsrc : " + image.attr("src"));
			    System.out.println("height : " + image.attr("height"));
			    System.out.println("width : " + image.attr("width"));
			    System.out.println("alt : " + image.attr("alt"));
            }
		}*/
            Document doc = Jsoup.connect("https://en-maktoob.yahoo.com/?p=us").get();
            Elements links = doc.select("a[href]");
            FileWriter File = new FileWriter(file);
            //BufferedWriter writer = new BufferedWriter(File);
            for(Element link : links)
            {
                File.write(link.toString());
                File.write("\n");
                if(link.attr("href").equals("https://weather.yahoo.com/ir/tehran/tehran-12843228/"))
                {
                    System.out.println("specific link is there!");
                    flag = true;
                }
                else continue;
            }
            if(!flag) System.out.println("this site was not friendly!");
            long time = System.currentTimeMillis() - startTime;
            System.out.println("finish at : " + time/1000 + " sec");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
