package edu.fra.uas.model;

import java.io.Serializable;
import org.slf4j.Logger;


public class Noten  implements Serializable {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Noten.class);

    private long id;
    private String fach;
    private int note;

    public Noten(){
        log.debug("Noten created without values");

    }


    public Noten(long id, String fach, int note) {
        this.id = id;
        this.fach = fach;
        this.note = note;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFach(String fach) {
        this.fach = fach;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public String getFach() {
        return fach;
    }

    public int getNote() {
        return note;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((fach == null) ? 0 : fach.hashCode());
        result = prime * result + note;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Noten other = (Noten) obj;
        if (id != other.id)
            return false;
        if (fach == null) {
            if (other.fach != null)
                return false;
        } else if (!fach.equals(other.fach))
            return false;
        if (note != other.note)
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "Noten [id=" + id + ", fach=" + fach + ", note=" + note + "]";
    }
}




