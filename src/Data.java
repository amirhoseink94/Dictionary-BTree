class Data implements Comparable{
    private String mean;
    private String data;
    Data(String data,String mean)
    {
        this.data=new String(data);
        this.mean=new String(mean);
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data =new  String(data);
    }
    public String getMean() {
        return mean;
    }
    public void setMean(String mean) {
        this.mean =new String(mean);
    }
    public int compareTo(Object o) {
        Data dp=(Data)o;
        return data.compareTo(dp.getData());  //To change body of implemented methods use File | Settings | File Templates.
    }
}
