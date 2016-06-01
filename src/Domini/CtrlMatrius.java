package Domini;

import Persistencia.MatrixPrecalc;
import org.la4j.Matrix;
import org.la4j.matrix.sparse.CCSMatrix;
import org.la4j.matrix.sparse.CRSMatrix;

import java.io.IOException;
import java.util.Vector;

/**
 * Created by albert.val.vila on 24/05/2016.
 */
public class CtrlMatrius {
    private MatrixPrecalc mp;
    private Metrica m;
    private Matrix[] m1; // matrius adj graf
    public CtrlMatrius(Matrix[] m1){
        this.m1 = m1;
        mp = new MatrixPrecalc();
        m = new Metrica();
    }
    public Matrix getMatrix(String path){
        System.out.println("entro");
        try {
            System.out.println("try");
            return mp.getMatrix(path);
        } catch (NullPointerException | IOException e) {
            System.out.println("catch");
            Matrix  mat =  m.ComputarMetrica(path,m1);
            System.out.println("guarda");
            System.out.println(mat.getColumn(0).length());
            System.out.println(mat.getRow(0).length());
            guardarMatriu(path,  mat); //problema :S
            System.out.println("figuarda");
            return mat;
        }
    }
    public void guardarMatriu(String path, Matrix m){
        try {
            mp.guardarMatrix(path,m);
        } catch (IOException e) {
            e.printStackTrace(); //ja ho canviaré
        }
    }
    public Vector<String> getLlistaMatrius(){
        return mp.llistaPaths();
    }

    public void recalcula_matriu(String f) throws IOException {
        System.out.println("Recalculo");
        mp.guardarMatrix(f,m.ComputarMetrica(f,m1));
    }
}
