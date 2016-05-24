package Domini;

import Persistencia.MatrixPrecalc;
import org.la4j.Matrix;
import org.la4j.matrix.sparse.CCSMatrix;

import java.io.IOException;

/**
 * Created by albert.val.vila on 24/05/2016.
 */
public class CtrlMatrius {
    private MatrixPrecalc mp;
    private Metrica m;
    CtrlMatrius(){
        mp = new MatrixPrecalc();
        m = new Metrica();
    }
    public Matrix getMatrix(String path,Matrix[] m1){
        System.out.println("entro");
        try {
            System.out.println("try");
            return mp.getMatrix(path);
        } catch (NullPointerException | IOException e) {
            System.out.println("catch");
            Matrix  mat =m.ComputarMetrica(path,m1);
            guardarMatriu(path, (CCSMatrix) mat); //problema :S
            return mat;
        }
    }
    public void guardarMatriu(String path, CCSMatrix m){
        try {
            mp.guardarMatrix(path,m);
        } catch (IOException e) {
            e.printStackTrace(); //ja ho canviaré
        }
    }
}
