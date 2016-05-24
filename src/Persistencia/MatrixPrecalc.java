package Persistencia;
import org.la4j.Matrix;
import org.la4j.matrix.sparse.CCSMatrix;

import java.io.*;
import java.util.Vector;

/**
 * Created by Àlvar on 22/05/2016.
 */

public class MatrixPrecalc {

    private File[] matsprec;
    private Vector<String> paths;

    private void actualitzaPathsGuardats() {
        File dir = new File("Matrius_Precalculades");
        matsprec = dir.listFiles();
        paths = new Vector<>(matsprec.length);
        for (int i = 0; i < matsprec.length; ++i){
            paths.add(matsprec[i].getName().substring(0,(matsprec[i].getName().length())-4));
        }
    }

    public MatrixPrecalc() {
        actualitzaPathsGuardats();
    }

    public Matrix getMatrix(String path) throws IOException,NullPointerException {/* throw exception si no es carrega*/
        boolean trobat = false;
        int x = 0;
        while(!trobat && x < paths.size()){
            if(path == paths.get(x)) trobat = true;
            ++x;
        }
        if (trobat) {
            String s;
            FileReader f = new FileReader(matsprec[x]);
            BufferedReader b = new BufferedReader(f);
            s = b.readLine();
            int i=0;
            while(Character.isDigit(s.charAt(i))) ++i;
            int r = Integer.parseInt(s.substring(0,i));
            int c = Integer.parseInt(s.substring(i+1));
            while(Character.isDigit(s.charAt(i))) ++i;
            Matrix mat = new CCSMatrix(r,c);
            while((s = b.readLine())!=null) {
                i = 0;
                String fila = new String();
                while(Character.isDigit(s.charAt(i))) {
                    fila += s.charAt(i);
                    ++i;
                }
                while(s.charAt(i) != '%') {
                    String col = new String();
                    String rel = new String();
                    if (s.charAt(i) == '$') ++i;
                    while(Character.isDigit(s.charAt(i))) {
                        col += s.charAt(i);
                        ++i;
                    }
                    if (s.charAt(i) == '$') ++i;
                    while(s.charAt(i) != '$' && s.charAt(i) != '%') {
                        rel += s.charAt(i);
                        ++i;
                    }
                    mat.set(Integer.parseInt(fila), Integer.parseInt(col), Double.parseDouble(rel));
                }
            }
            return mat;
        }
        else return null;
    }

    public Void guardarMatrix(String path, CCSMatrix m) throws IOException {
        int nrows = m.getColumn(0).length();
        int ncols = m.getRow(0).length();
        BufferedWriter bw;
        File fitxer = new File("Matrius_Precalculades", path + ".txt");
        bw = new BufferedWriter(new FileWriter(fitxer));
        bw.write(Integer.toString(nrows)+"$"+Integer.toString(ncols));
        bw.newLine();
        for(int i = 0; i < nrows; ++i) {
            boolean fila_escrita = false;
            for (int j = 0; j < ncols; j++) {
                double d = m.get(i, j);
                if(d != 0) {
                    if(!fila_escrita) {
                        bw.write(Integer.toString(i));
                        fila_escrita = true;
                    }
                    bw.write("$");
                    bw.write(Integer.toString(j)+"$"+Double.toString(d));
                }
            }
            if(fila_escrita) {
                bw.write('%');
                bw.newLine();
            }
        }
        bw.close();
        actualitzaPathsGuardats();
        return null;
    }

    public Vector<String> llistaPaths() {
        return paths;
    }
}
