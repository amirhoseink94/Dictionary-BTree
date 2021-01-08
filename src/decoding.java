import java.util.*;
class decoding
{
	Data decoder(String s)
	{
		StringTokenizer decod=new StringTokenizer(s,";\"",false);
		String f=decod.nextToken();
		StringBuffer d=new StringBuffer();
		while(decod.hasMoreTokens())
		{
			d.append(decod.nextToken());
			d.append("/");
		}
		return new Data(f,d.toString());
	}
}
