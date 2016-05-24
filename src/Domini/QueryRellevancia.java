package Domini;

import org.la4j.Matrix;

import java.util.Vector;

/**
 * Created by Albert on 08/04/2016.
 */
public class QueryRellevancia extends Query{
    public QueryRellevancia(String path, Vector<Integer> vs, Matrix[] m1,CtrlMatrius cm) {
        super(path, vs, m1,cm);
        this.m1 = m1;
    }

    public Double Cerca(){
        Double res=1.0;
        Integer aux;
        int i=0,iaux;
        while(i<vs.size()-1){ //penultim element
            aux = vs.get(i);
            iaux= i;
            ++i;
            while(vs.get(i)==null) ++i; // sabem que almenys l'ultim element no es null
            res*=cm.getMatrix(path.substring(iaux,i+1),m1).get(aux,vs.get(i));
            System.out.println("Estic calculant amb entitat1 :"+aux+"entitat2 :"+vs.get(i)+"path:"+path.substring(iaux,i+1));
          //  res *= m.ComputarMetrica(aux,vs.get(i),path.substring(iaux,i+1),m1); //haurem de tallar aquest path
        }
        return res;
    }
}
