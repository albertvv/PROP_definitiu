package Domini;

import org.la4j.vector.SparseVector;

import java.util.Vector;

/**
 * Created by Albert on 09/04/2016.
 */
public class QueryRelimportant extends Query {
  //  private Integer entitat1;
    public QueryRelimportant(String path, Vector<Integer> entitat1, CtrlMatrius cm) {
        super(path,cm);
        this.vs = entitat1;
    }
    public Integer getID(){
        return vs.get(0);
    }
    public SparseVector Cerca(){  //vector ordenat de id de Entitats
      //  return m.ComputarMetrica(vs.get(0),path,m1);
        return (SparseVector) cm.getMatrix(path).getRow(vs.get(0));
    }

}
