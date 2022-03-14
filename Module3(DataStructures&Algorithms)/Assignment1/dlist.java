package Assignment1;

class dlist {
	private dlist prev;
    private int info;
    private dlist next;

    public void setprev(dlist tprev)
    {
        prev=tprev;
    }
    public dlist getprev()
    {
        return(prev);
    }
    public void setinfo(int tinfo)
    {
        info=tinfo;
    }
    public int getinfo()
    {
        return(info);
    }
    public void setnext(dlist tnext)
    {
        next=tnext;
    }
    public dlist getnext()
    {
        return(next);
    }

}
