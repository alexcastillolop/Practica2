
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Wilfo
 */
public class OrdenEjecGen {

    int ID = 0;
    String nodoprincipal = "";
    Vector vecGenEje = new Vector();

    public OrdenEjecGen(int ID, String nodoprincipal, Vector vecGenEje) {
        this.ID = ID;
        this.nodoprincipal = nodoprincipal;
        this.vecGenEje = vecGenEje;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getnodoprincipal() {
        return nodoprincipal;
    }

    public void setID(String nodoprincipal) {
        this.nodoprincipal = nodoprincipal;
    }

    public Vector getvecGenEje() {
        return vecGenEje;
    }

    public void setID(Vector vecGenEje) {
        this.vecGenEje = vecGenEje;
    }

    @Override
     public String toString() {
        return nodoprincipal;
    }
}
