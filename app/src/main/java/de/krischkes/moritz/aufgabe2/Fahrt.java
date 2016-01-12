package de.krischkes.moritz.aufgabe2;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Moritzkrischke on 12/01/16.
 */
@Table(name="Fahrten")
public class Fahrt extends Model{

    @Column(name="entfernung")
    private int entfernung;
    @Column(name="startort")
    private String startOrt;
    @Column(name="zielort")
    private String zielOrt;
    @Column(name="datum")
    private String datum;

    public Fahrt(){
        super();
    }

    public Fahrt(int entfernung, String startOrt, String zielOrt, String datum){
        this.setEntfernung(entfernung);
        this.setStartOrt(startOrt);
        this.setZielOrt(zielOrt);
        this.setDatum(datum);
    }

    public int getEntfernung() {
        return entfernung;
    }

    public void setEntfernung(int entfernung) {
        this.entfernung = entfernung;
    }

    public String getZielOrt() {
        return zielOrt;
    }

    public void setZielOrt(String zielOrt) {
        this.zielOrt = zielOrt;
    }

    public String getStartOrt() {
        return startOrt;
    }

    public void setStartOrt(String startOrt) {
        this.startOrt = startOrt;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
}
