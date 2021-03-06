package Domini;

import Persistencia.MatrixPrecalc;
import org.la4j.Matrix;
import org.la4j.matrix.sparse.CCSMatrix;
import org.la4j.matrix.sparse.CRSMatrix;

import java.io.IOException;

/**
 * Created by Àlvar on 22/05/2016.
 */
public class DriverMtrixPrecalc {
    public static void main(String[] args) throws IOException {
        MatrixPrecalc mp = new MatrixPrecalc();
        CRSMatrix m = new CRSMatrix(5,5);
        m.set(4,4,0.9567);
        m.set(4,0,0.382);
        m.set(0,0,0.5);
        mp.guardarMatrix("hey", m);
    }
}
