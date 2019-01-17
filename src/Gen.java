
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Wilfo
 */
public class Gen {

    int ID = 0;
    String nodo = "";
    Vector consecuente = new Vector();
    Vector tiempo = new Vector();
    int recurso=0;

    public Gen(int ID, String nodo, Vector Consecuente, Vector Tiempo,int recurso) {
        this.ID = ID;
        this.nodo = nodo;
        this.consecuente = Consecuente;
        this.tiempo = Tiempo;
        this.recurso=recurso;
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public int getId() {
        return this.ID;
    }

    public void setNodo(String nodo) {
        this.nodo = nodo;
    }

    public String getNodo() {
        return this.nodo;
    }

    public void setConsecuente(Vector consecuente) {
        this.consecuente = consecuente;
    }

    public Vector getConsecuente() {
        return this.consecuente;
    }

    public void setTiempo(Vector tiempo) {
        this.tiempo = tiempo;
    }

    public Vector getTiempo() {
        return this.tiempo;
    }

     public void setRescurso(int Recurso) {
        this.recurso = Recurso;
    }

    public int getRescurso() {
        return this.recurso;
    }


    @Override
    public String toString() {
        return nodo;
    }
}
