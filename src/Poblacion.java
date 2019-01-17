
import java.util.Random;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Wilfo
 */
public class Poblacion {

    /**
     * Función se encarga de generar todas las secuencias posibles
     * que sean validas.
     * @param source
     * @param partial
     * @param out
     */
    private void generateR(String source, String partial, Vector out) {
        String newPartial = new String(partial);
        String newSource;
        if (source.length() == 0) {
            out.addElement(newPartial);
            return;
        }
        for (int i = 0; i < source.length(); i++) {
            newPartial = partial.concat(source.substring(i, i + 1));
            newSource = source.substring(0, i);
            if (i < (source.length() + 1)) {
                newSource = newSource.concat(source.substring(i + 1, source.length()));
            }
            generateR(newSource, newPartial, out);
        }
    }

    /**
     * Llena cada secuencia en este vector
     * @param source
     * @return
     */
    public Vector generate(String source) {
        Vector out = new Vector();
        String partial = new String();
        generateR(source, partial, out);
        return out;
    }

    public Vector getAllPoblacion() {
        Vector v = generate("DCEH");
        Vector vecStore = new Vector();

        int cont = 1;

        for (int i = 0; i < v.size(); i++) {
            if (cont == 5) {
                break;
            }

            switch (cont) {
                case 1:
                    String cad = "AB" + v.elementAt(i) + "FG";
                    vecStore.addElement(cad);
//                 System.out.println("# "+(i+1)+" "+" AB - "+(String)v.elementAt(i)+" FG");
                    break;
                case 2:
                    String cad1 = "AB" + v.elementAt(i) + "GF";
                    vecStore.addElement(cad1);
//                    System.out.println("# " + (25 + i) + " AB - " + (String) v.elementAt(i) + " GF");
                    break;
                case 3:
                    String cad2 = "BA" + v.elementAt(i) + "FG";
                    vecStore.add(cad2);
//                    System.out.println("# " + (49 + i) + " BA - " + (String) v.elementAt(i) + " FG");
                    break;
                case 4:
                    String cad3 = "BA" + (String) v.elementAt(i) + "GF";
                    vecStore.add(cad3);
//                    System.out.println("# " + (73 + i) + " BA - " + (String) v.elementAt(i) + " GF");
                    break;
            }
            if ((i + 1) == v.size()) {
                cont++;
                i = 0;
            }
        }



        return vecStore;
    }

    /**
     * Busca en un vector si el nuevo valor se encuentra
     * devolviendo 1 si esta y 0 si no esta.
     * @param vec
     * @param val
     * @param n
     * @return
     */
    public int buscar(int[] vec, int val, int n) {
        if (n == vec.length) {
            return 0;
        } else if (vec[n] == val) {
            return 1;
        } else {
            return buscar(vec, val, n = n + 1);
        }
    }

    /**
     * Devuelve un vector con valores escogidos al azar
     * retorna 20 valores de la población inicial.
     * @return
     */
    public int[] generar() {
        Random p = new Random();
        int[] v = new int[20];
        int cont = 0;
        int n = 0;
        for (int k = 0; k <= cont; k++) {
            if (cont >= 1) {
                int k1 = p.nextInt(92);
                if (n >= 20) {
                    break;
                }

                if (buscar(v, k1, 0) == 0) {
                    v[n] = k1;
                    n++;
                    cont++;
                } else {
                    cont++;
                }

            } else {
                v[n] = p.nextInt(90) + 1;
                n++;
                cont++;
            }
        }

        return v;
    }

    public void PrintPoblacion(String msg, Vector v) {
        for (int k = 0; k < v.size(); k++) {
            System.out.println(k + " -> " + msg + " " + v.elementAt(k));
        }
    }

    public void PrintCromo(String msg, Cromosoma v) {
        for (int k = 0; k < v.gen.size(); k++) {
            System.out.println(k + " -> " + msg + " Nodo-> " + v.gen.elementAt(k).nodo + " Tiempo-> " + v.gen.elementAt(k).tiempo);
        }
    }

    public Vector getMuestra(int[] vecAzar, Vector Poblaci) {
        Vector vecaux = new Vector();
        for (int p = 0; p < vecAzar.length; p++) {
            vecaux.addElement(Poblaci.elementAt(vecAzar[p]));
        }
        return vecaux;
    }

    /**
     * Devuelve todos los cromosomas generados al azar
     * @param strCromo
     * @return
     */
    public Vector<Cromosoma> getAllCromosomaMuestra(Vector strCromo) {
        Vector<Cromosoma> aux = new Vector<Cromosoma>();
        int c = 0;
        while (c < strCromo.size()) {
            aux.add(getCromo(c + 1, strCromo.elementAt(c).toString()));
            c++;
        }

        return aux;
    }

    /**
     * Retorna un cromosoma a parir de  una cadena de texto
     * @param ID
     * @param strcadCromo
     * @return
     */
    public Cromosoma getCromo(int ID, String strcadCromo) {
        Cromosoma cro = null;
        Vector<Gen> vecGen = new Vector<Gen>();
        int cont = 0;
        while (cont < strcadCromo.length()) {
            vecGen.add(getGenbyNodo(strcadCromo.charAt(cont)));
            cont++;
        }
        cro = new Cromosoma(ID, vecGen);
        return cro;
    }

    /**
     * Devuelve un gen a partir del nodo que reciba
     * Ejemplo: A -> devolverá el respectivo gen con sus recursos y tiempos.
     * @param Nodo
     * @return
     */
    public Gen getGenbyNodo(char Nodo) {
        int val = Nodo;
        Gen geno = null;
        Vector conse = new Vector();
        Vector tiempo = new Vector();
        switch (val) {
            case 65:
                conse.add(0);
                tiempo.add(1);
                tiempo.add(2);
                geno = new Gen(1, "A", conse, tiempo, 2);
                break;
            case 66:
                conse.add(0);
                tiempo.add(1);
                geno = new Gen(2, "B", conse, tiempo, 1);
                break;
            case 67:
                conse.add(1);
                conse.add(2);
                tiempo.add(1);
                tiempo.add(2);
                tiempo.add(3);
                tiempo.add(4);
                tiempo.add(5);
                geno = new Gen(3, "C", conse, tiempo, 3);
                break;
            case 68:
                conse.add(2);
                tiempo.add(1);
                tiempo.add(2);
                tiempo.add(3);
                geno = new Gen(4, "D", conse, tiempo, 3);
                break;
            case 69:
                conse.add(2);
                tiempo.add(1);
                tiempo.add(2);
                geno = new Gen(5, "E", conse, tiempo, 2);
                break;
            case 70:
                conse.add(3);
                conse.add(5);
                tiempo.add(1);
                tiempo.add(2);
                tiempo.add(3);
                geno = new Gen(6, "F", conse, tiempo, 4);
                break;
            case 71:
                conse.add(5);
                tiempo.add(1);
                tiempo.add(2);
                tiempo.add(3);
                geno = new Gen(7, "G", conse, tiempo, 1);
                break;
            case 72:
                conse.add(2);
                tiempo.add(1);
                tiempo.add(2);
                geno = new Gen(8, "H", conse, tiempo, 3);
                break;

        }
        return geno;
    }

    public Vector<Cromosoma> getAllCromito(Vector<ResultadoCromo> v){
      Vector<Cromosoma> fd=new Vector<Cromosoma>();

      for(int k=0;k<v.size();k++){
        Cromosoma eje=v.elementAt(k).cromoeje;
        fd.add(eje);
      }

      return fd;
    }

    public Vector GetAllTime( Vector<Cromosoma> c){
     Vector su=new Vector();
        for(int h=0;h<c.size();h++){
            su.addElement(getTiempo(c.elementAt(h)));
        }
     return su;
     }

    public int getTiempo(Cromosoma cro) {
        int sum = 0;
        for (int k = 0; k < cro.gen.size(); k++) {
            sum+=cro.gen.elementAt(k).tiempo.size();
        }
        return sum;
    }

    public void printDetalleCromosoma(Cromosoma croEje,Cromosoma croyala,int Tiempo)
    {
        for(int l=0;l<croEje.gen.size();l++){
         System.out.println("Nodo-> "+croEje.gen.elementAt(l).nodo+" Ante->: "+croEje.gen.elementAt(l).consecuente+" T: "+croEje.gen.elementAt(l).tiempo.size()+" R: "+croEje.gen.elementAt(l).recurso);
        }

           System.out.println("Tiempo de Ejecución: "+Tiempo+" días.");
        System.out.println("*****************************TAREAS EJECUTAS DENTRO DE OTRAS************************");

        for(int k=0;k<croyala.gen.size();k++)
        System.out.println("Nodo-> "+croyala.gen.elementAt(k).nodo+" Ante->: "+croyala.gen.elementAt(k).consecuente+" T: "+croyala.gen.elementAt(k).tiempo.size()+" R: "+croyala.gen.elementAt(k).recurso);
    }
}
