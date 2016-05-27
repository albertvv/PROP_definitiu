package Domini;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class transformar_data {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public static Date stringToDate(String s) throws ParseException{
        return formatter.parse(s);
    }
    public static String dateToString(Date data){
        if(data == null) return null;
        return formatter.format(data);
    }
}
