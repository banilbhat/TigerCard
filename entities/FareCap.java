package entities;
public class FareCap {
    
    public FareCap(String from, String to, int rank, double dailyCap, double weeklyCap) {
        this.from = from;
        this.to = to;
        this.rank = rank;
        this.dailyCap = dailyCap;
        this.weeklyCap = weeklyCap;
        this.path = from + "-" + to;
    }
    public String from;
    public String to; 
    public int rank;
    public double dailyCap;
    public double weeklyCap;
    public  String path;
}
