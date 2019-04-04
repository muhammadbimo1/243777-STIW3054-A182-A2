package Assignment2;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.*;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountCourse implements Runnable,Patternmatch {

    String textFromPage;
    //String textFromPage = "";

    public CountCourse(String textFromPage) {
        this.textFromPage = textFromPage;

    }
     @Override
    public void run() {
match();
        }

    @Override
    public void match() {
        String pattern = "\\w{4}\\d";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(textFromPage);
        int count = 0;
        while (m.find())
            count++;
        System.out.println("Course count "+count);
    }
}

