package Assignment2;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountDate implements Runnable, Patternmatch {

    String textFromPage;

    public CountDate(String textFromPage) {
        this.textFromPage = textFromPage;

    }
    @Override
    public void run() {
        match();
    }

    @Override
    public void match() {
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");

        String pattern = "(\\d{1,2}/\\d{1,2}/\\d{4})";
        List<Date> allMatches = new ArrayList<Date>();
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(textFromPage);
        while (m.find()){
            //Date date1=formatter1.parse(sDate1);
            try {
                allMatches.add(formatter1.parse(m.group()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Date minDate = Collections.min(allMatches);
        Date maxDate = Collections.max(allMatches);
        long diff = (maxDate.getTime() - minDate.getTime()) / (1000 * 60 * 60 * 24);
        System.out.println("the exam spans for " +(diff-7)+" Days.");
    }
}

