
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Wilfo
 */
public class Cromosoma {

    int ID = 0;
    Vector<Gen> gen = new Vector<Gen>();

    public Cromosoma(){}
    public Cromosoma(int ID, Vector<Gen> gen) {
        this.ID = ID;
        this.gen = gen;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Vector<Gen> getGenes() {
        return this.gen;
    }

    public void setGenes(Vector<Gen> genes) {
        this.gen = genes;
    }
}
