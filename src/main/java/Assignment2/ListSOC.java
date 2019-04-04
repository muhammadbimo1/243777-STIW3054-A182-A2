package Assignment2;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.*;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListSOC implements Runnable {

    String textFromPage;
    //String textFromPage = "";

    public ListSOC(String textFromPage) {
        this.textFromPage = textFromPage;

    }
    @Override
    public void run() {
        PdfReader reader;
        String found = "";

            String pattern = "(\\d{1,3}.  STI[ANDJKW]\\d{4} .* \\d{1,2}/\\d{1,2}/\\d{4} \\d{2}:\\d{2})|(\\d{1,3}.  STQ[SM]\\d{4} .* \\d{1,2}/\\d{1,2}/\\d{4} \\d{2}:\\d{2})";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(textFromPage);
            while (m.find()){
                found += ("\n")+m.group();
            }
            System.out.println(found);

    }
}

