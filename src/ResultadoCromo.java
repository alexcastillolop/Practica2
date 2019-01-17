/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wilfo
 */
public class ResultadoCromo {
    Cromosoma cromorpta=new Cromosoma();
    Cromosoma cromoeje=new Cromosoma();
    int ID=0;
    public ResultadoCromo(int ID,Cromosoma cromorpta,Cromosoma cromoEjecutados){
        this.cromorpta=cromorpta;
        this.cromoeje=cromoEjecutados;
        this.ID=ID;
    }

    public void setID(int ID){
     this.ID=ID;
    }
    public int getID(){
     return this.ID;
    }

    public void setCromosomaRpta(Cromosoma cro){
     this.cromorpta=cro;
    }

    public void setCromosomaEje(Cromosoma croeje){
     this.cromoeje=croeje;
    }

    public Cromosoma getCromosomaRpta(){
     return this.cromorpta;
    }

    public Cromosoma getCromosomaEje(){
    return this.cromoeje;
    }

}
