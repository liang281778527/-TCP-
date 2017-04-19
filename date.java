package socket;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class date {
	public Date d=null;
	public String time=null;
	
	public date()
	{
		d=new Date();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time=df.format(d);
	}
}
