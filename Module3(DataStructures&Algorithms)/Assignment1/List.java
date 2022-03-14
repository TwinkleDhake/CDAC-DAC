package Assignment1;

public class List {
	 private int info;
	    private List  next;

	    public void setinfo(int tinfo)
	    {
	        info=tinfo;
	    }
	    public int getinfo()
	    {
	        return(info);
	    }

	    public void setnext(List  tnext)
	    {
	        next=tnext;
	    }
	    public List  getnext()
	    {
	        return(next);
	    }

}
