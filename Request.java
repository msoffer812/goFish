package goFish;

//This is a wrapper class for a request, I find it simpler
public class Request {
	private int requestee;
	private String rank;
	
	public Request()
	{
		requestee=0;
		rank="";
	}
	public Request(String r, int req)
	{
		rank = r;
		requestee = req;
	}
	public String getRank()
	{
		return this.rank;
	}
	public int getReq()
	{
		return requestee;
	}
}
