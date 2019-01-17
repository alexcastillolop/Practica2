
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Wilfo
 */
public class MiSubTareas {

    Vector v = new Vector();

    

    public MiSubTareas(Vector c) {
        this.v = c;
    }

    public void setTareas(Vector d) {
        this.v = d;
    }

    public Vector getTareas() {
        return this.v;
    }
}
