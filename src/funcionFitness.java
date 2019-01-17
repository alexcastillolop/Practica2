
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Wilfo
 * correo:wilfolightfire18@hotmail.com
 * Blog: http://neurocodigo.wordpress.com
 * Universidad:Universidad San Antonio de Machala
 */
public class funcionFitness {

    Vector<Gen> genVec = new Vector<Gen>();
    Cromosoma cromofit = new Cromosoma(1, genVec);
    //mantiene el valor recien ejecutado para poder meterlo dentro de las subtareas
  String auxC="";
    /// Funcionales
    /**
     *Esta función devuelve uno si la tarea se puede ejecutar.
     * Devuelve 0 si la tarea no se puede ejecutar
     * Definición:Para que una tarea se pueda ejecutar sus consecuentes ya se deben haber ejecutado.
     * @param cromo conjunto de genes que lo conforman
     * @param gen (1,"D",IDPADRE=(1,2),(1,2),2)
     * @param pos permite recorrer  cada consecuente (4,3) para saber si puede ejecutarse o no la tarea
     * @param k permite recorrer cad gen en el cromosoma
     * @param c
     * @return
     */
    public int isValidThisAlle(Cromosoma cromo, Gen gen, int pos, int k, int c) {

        if (c >= gen.consecuente.size()) {
            if (pos >= gen.consecuente.size()) {
                return 1;
            } else {
                return 0;
            }
        } else if (cromo.gen.elementAt(k).ID == gen.consecuente.elementAt(pos)) {
            pos++;
            c++;
            return isValidThisAlle(cromo, gen, pos, 0, c);
        } else {
            
            if (k == cromo.gen.size() - 1) {
                k = 0;
                c++;
            }
            k++;
            return isValidThisAlle(cromo, gen, pos, k, c);

        }
    }

    /**
     * Esta función devuelve los indices del vector cuya suma <= recurso dado
     * @param cromo contiene un conjunto de genes
     * @param pos(posición) actual de donde se desea empezar a buscar hacia adelante
     * @param recurso el cual dsipone la fabrica o el cromosoma
     * @return
     */
    public Vector getIndice(Cromosoma cromo, int pos, int recurso) {
        Vector vecaux = new Vector();
        int sum = cromo.gen.elementAt(pos).recurso;
        vecaux.add(pos);
        pos++;
        while (pos < cromo.gen.size() - 1) {

            int val = cromo.gen.elementAt(pos).recurso;
            if ((sum + val) <= recurso) {
                vecaux.add(pos);
                sum = sum + val;
            } else if (sum == recurso) {
                break;
            }

            pos++;
        }
        return vecaux;

    }

    /**
     * Esta función tiene como objetivo eliminar los tiempos de la tarea de cada gen,
     * si estos genes ya no tenen tiempo se elimina el gen dando como resultado un
     * nuevo cromosoma con indices menos
     * @param cromo
     * @param vecInd conjunto de indices a eliminar
     * @return
     */
    public Cromosoma nuevoCromosoma(Cromosoma cromo, Vector vecInd,int cont) {
        //Al incializar cont=1 no se elimina el nodo que ejecuta las tareas
//        int cont = 1;
        int pos = 0;
        while (cont < vecInd.size()) {
            System.out.println("Entre a nuevo cromosoma: ");
            int ind = Integer.parseInt(vecInd.elementAt(cont).toString());
            System.out.println("Ind vale " + ind);
            if (cromo.gen.elementAt(ind).tiempo.size() >= 2) {
                System.out.println("comparando tiempo.size()>2: ");
                auxC=auxC+cromo.gen.elementAt(ind - pos).nodo;
                cromo.gen.elementAt(ind - pos).tiempo.remove(0);

            } else {
                System.out.println("Elimino gen  ");
                //añado al vector los que se han ejecutado
                cromofit.gen.add(cromo.gen.elementAt(ind - pos));
                auxC=auxC+cromo.gen.elementAt(ind - pos).nodo;
                cromo.gen.remove(ind - pos);

                pos++;
            }
            cont++;
        }
        return cromo;

    }
    //No probadas aun

    public Vector delNotAllowedIndices(Cromosoma crom, Vector indices) {
        int cont = 0;
        Vector vecaux = new Vector();
        int inicial = Integer.parseInt(indices.elementAt(0).toString());
        while (cont < indices.size()) {
            int ind = Integer.parseInt(indices.elementAt(cont).toString());
            if (crom.gen.elementAt(ind).consecuente.firstElement().equals(crom.gen.elementAt(inicial).consecuente.firstElement())) {
                vecaux.add(ind);
            }
            cont++;
        }
        return vecaux;
    }

    public int delNotAllowedIndices2(Cromosoma crom, int IDPadre) {
        int cont = 0;
        int eval = 0;
        while (cont < crom.gen.size()) {
            int ind = crom.gen.elementAt(cont).ID;

            if (ind == IDPadre) {
                eval = 1;
                break;
            }
            cont++;
        }
        return eval;
    }

    //si funciona
    public Vector filterIndices(Cromosoma vcroomo, Vector vecInd) {
        int cont = 0;
        Vector vec = new Vector();
        Gen genoma = null;
        while (cont < vecInd.size()) {
            int val = Integer.parseInt(vecInd.elementAt(cont).toString());
            genoma = vcroomo.gen.elementAt(val);
            if ((genoma.ID == 1) || (genoma.ID == 2)) {
                vec.addElement(val);
            }
            cont++;
        }
        return vec;
    }

    public Vector filtrarIndiceporGen(Cromosoma cromoaux, Cromosoma croGenEjec, Vector indElimi) {

        Vector vecaux = new Vector();
        int cont = 0;
        while (cont < indElimi.size()) {
            int val = Integer.parseInt(indElimi.elementAt(cont).toString());
            Gen genito = cromoaux.gen.elementAt(val);
            int resul = isValidThisAlle(croGenEjec, genito, 0, 0, 0);
            if (resul == 1) {
                vecaux.addElement(val);
            }

            cont++;
        }
        return vecaux;
    }

    public void printVector(String msj,Vector v){
        System.out.println("******************"+msj+" **********************");
     for(int k=0;k<v.size();k++)
    System.out.println("Dato: "+v.elementAt(k));

    }
     public void printVectorNodo(String msj,Cromosoma v){
        System.out.println("******************"+msj+" **********************");
     for(int k=0;k<v.gen.size();k++)
    System.out.println("Nodo: "+v.gen.elementAt(k).nodo+" Tiempos "+v.gen.elementAt(k).tiempo.size());

    }

    public void printNodoGen(String msj,Vector<Gen> ge){

        System.out.println("******************"+msj+" **********************");
     for(int k=0;k<ge.size();k++)
      System.out.println("Nodo: "+ge.elementAt(k).nodo+" Tiempos "+ge.elementAt(k).tiempo.size());
    }

}
