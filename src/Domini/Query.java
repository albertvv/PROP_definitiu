package Domini;

import java.util.Vector;

/**
 * Created by Albert on 08/04/2016.
 */
public abstract class Query {
    protected String path;
    protected Vector<Integer> vs; //fa falta que estigui a query?
    protected CtrlMatrius cm;
    protected Query(String path, Vector<Integer> vs, CtrlMatrius cm) {
        this.path = path;
        this.vs = vs;
        this.cm = cm;
    }

    protected Query(String path, CtrlMatrius cm) {
        this.path = path;
        this.cm = cm;
    }

    public String getPath() {
        return path;
    }
}
