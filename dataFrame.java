package socket;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dataFrame{
	public int num;
	public int length;
	public String time;
	public byte[] bytes;
	public byte check=0;
	
	public dataFrame(){
		num=0;
		length=-1;
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time=df.format(date);
		bytes=new byte[256];
		check=0;
	}
	
	public void cal(dataFrame d){
		for(int i=0;i<d.length;i++){
			check+=bytes[i]%256;
		}
	}
}
