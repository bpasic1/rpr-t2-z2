package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna, krajnja;
    private boolean pocetnaprip, krajnjaprip;

    public Interval(double pocetnat, double krajnjat, boolean pocprip, boolean krajprip){
        this.pocetna = pocetnat;
        this.krajnja = krajnjat;
        this.pocetnaprip = pocprip;
        this.krajnjaprip = krajprip;
        if(this.pocetna > this.krajnja)
            throw new IllegalArgumentException("Pocetna je veca od krajnje.");
    }

    public Interval(){
        pocetna = 0;
        krajnja = 0;
        pocetnaprip = false;
        krajnjaprip = false;
    }

    public boolean isNull(){
        return pocetna == 0 && krajnja == 0 && !pocetnaprip && !krajnjaprip;
    }

    public boolean isIn(double tacka){
        if(pocetnaprip && krajnjaprip)      //interval [..]
            if(tacka >= pocetna && tacka <= krajnja)
                return true;
            else
                return false;
        else if(!(pocetnaprip && krajnjaprip))  //interval (..)
            if(tacka > pocetna && tacka < krajnja)
                return true;
            else
                return false;
        else if(!pocetnaprip && krajnjaprip)    //interval (..]
            if(tacka > pocetna && tacka <= krajnja)
                return true;
            else
                return false;
        else                                    //interval [..)
            if(tacka >= pocetna && tacka < krajnja)
                return true;
            else
                return false;
    }

    public Interval intersect(Interval in){
        Interval novi = new Interval();
        if (pocetna > in.pocetna)
            novi.pocetna = pocetna;
        else
            novi.pocetna = in.pocetna;
        if(krajnja < in.krajnja)
            novi.krajnja = krajnja;
        else
            novi.krajnja = in.krajnja;
        return novi;
    }

    public static Interval intersect(Interval prvi, Interval drugi){
        Interval novi = new Interval();
        if (prvi.pocetna > drugi.pocetna)
            novi.pocetna = prvi.pocetna;
        else
            novi.pocetna = drugi.pocetna;
        if(prvi.krajnja < drugi.krajnja)
            novi.krajnja = prvi.krajnja;
        else
            novi.krajnja = drugi.krajnja;
        return novi;
    }

    public String toString(){
        if(this.pocetna == 0 && this.krajnja == 0 && !pocetnaprip && !krajnjaprip)
            return("()");
        if(this.pocetnaprip && this.krajnjaprip)
            return ("[" + pocetna + "," + krajnja + "]");
        if(this.pocetnaprip)
            return ("[" + pocetna + "," + krajnja + ")");
        if(this.krajnjaprip)
            return ("(" + pocetna + "," + krajnja + "]");
        return ("(" + pocetna + "," + krajnja + ")");
    }

    public boolean equals(Interval i){
        return (this.pocetna == i.pocetna) && (this.pocetnaprip == i.pocetnaprip) && (this.krajnja == i.krajnja) && (this.krajnjaprip == i.krajnjaprip);
    }
}
