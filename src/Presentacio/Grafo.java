package Domini;

import org.la4j.matrix.SparseMatrix;
import org.la4j.matrix.sparse.CCSMatrix;

import java.util.Vector;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;


public class Grafo {

    /*
     * REPRESENTACIO DEL GRAF:
     * Les entitats (nodes) es guarden en els vectors del seu tipus corresponent
     * Les relacions directes ({"PA", "PC", "PT"} i les simetriques) entre entitats de tipus diferent
     * es representen a la matriu d'adjacencia corresponent, on la fila i correspon a l'index del Paper i,
     * i la columna j correspon a Autor/Conferencia/Terme (segons la matriu). L'index d'una entitat es
     * el mateix a la matriu i al seu vector.
     * El sistema guarda la darrera ID emprada per a poder assignar la immediatament major si l'usuari
     * introdueix entitats sense assignar-les-hi una ID
     * Sota aquesta representacio, els noms de les entitats son unics (fins i tot entre tipus diferents), les ID
     * poden ser compartides entre 2-4 entitats sempre i quan aquestes siguin de tipus diferent.
     */


    //ATRIBUTS

    /*Vectors d'entitats*/
    private Vector<Paper>	    vectorPaper;
    private Vector<Autor>		vectorAutor;
    private Vector<Conferencia>	vectorConferencia;
    private Vector<Termino>		    vectorTermino;

    /*Matrius d'adjacencia*/
    private SparseMatrix        matrizPaperAutor;
    private SparseMatrix	    matrizPaperConferencia;
    private SparseMatrix	    matrizPaperTermino;

    /*Darrera ID emprada*/
    private Integer lastId;

    /*Diccionari*/
    private HashMap<Integer, Integer>   idPIndex;
    private HashMap<Integer, Integer>   idAIndex;
    private HashMap<Integer, Integer>   idCIndex;
    private HashMap<Integer, Integer>   idTIndex;


    //CONSTRUCTORA

    public Grafo() {
        vectorAutor 			= new Vector<Autor>();
        vectorConferencia		= new Vector<Conferencia>();
        vectorTermino 			= new Vector<Termino>();
        vectorPaper 			= new Vector<Paper>();

        matrizPaperAutor 		= new CCSMatrix(20000, 20000);
        matrizPaperConferencia  = new CCSMatrix(20000, 20000);
        matrizPaperTermino 		= new CCSMatrix(20000, 20000);

        idPIndex                = new HashMap<Integer, Integer>();
        idAIndex                = new HashMap<Integer, Integer>();
        idCIndex                = new HashMap<Integer, Integer>();
        idTIndex                = new HashMap<Integer, Integer>();

        lastId = -1;
    }


    //METODES PRIVATS

    /*----*/

    //METODES PUBLICS
    public boolean exists(String nom, Integer id, String tipus) throws Exception {
        if (id < 0) throw new Exception("id negativa");
        if (id != null) {
            switch (tipus) {
                case "Paper":       return idPIndex.containsKey(id);
                case "Autor":       return idAIndex.containsKey(id);
                case "Conferencia": return idCIndex.containsKey(id);
                case "Termino":     return idTIndex.containsKey(id);
            }
        }
        else throw new Exception("cal id");
        return false;
    }

    public String getNombre_i(Integer index, String tipus) throws Exception {
        if (index < 0) throw new Exception("index erroni");
        switch (tipus) {
            case "Paper":
                if (index >= vectorPaper.size()) throw new Exception("index erroni");
                if (vectorPaper.get(index) == null) throw new Exception("no existeix");
                return vectorPaper.get(index).getNombre();
            case "Autor":
                if (index >= vectorAutor.size()) throw new Exception("index erroni");
                if (vectorAutor.get(index) == null) throw new Exception("no existeix");
                return vectorAutor.get(index).getNombre();
            case "Conferencia":
                if (index >= vectorConferencia.size()) throw new Exception("index erroni");
                if (vectorConferencia.get(index) == null) throw new Exception("no existeix");
                return vectorConferencia.get(index).getNombre();
            case "Termino":
                if (index >= vectorTermino.size()) throw new Exception("index erroni");
                if (vectorTermino.get(index) == null) throw new Exception("no existeix");
                return vectorTermino.get(index).getNombre();
        }
        //no hauria de passar mai:
        return null;
    }

    public String getNombre_ID(Integer id, String tipus) throws Exception {
        Integer index;
        if (id < 0) throw new Exception("id negativa");
        switch (tipus) {
            case "Paper":
                if ((index = idPIndex.get(id)) == null) return null;
                if (vectorPaper.get(index) == null) throw new Exception("no existeix");
                return vectorPaper.get(index).getNombre();
            case "Autor":
                if ((index = idAIndex.get(id)) == null) return null;
                if (vectorAutor.get(index) == null) throw new Exception("no existeix");
                return vectorAutor.get(index).getNombre();
            case "Conferencia":
                if ((index = idCIndex.get(id)) == null) return null;
                if (vectorConferencia.get(index) == null) throw new Exception("no existeix");
                return vectorConferencia.get(index).getNombre();
            case "Termino":
                if ((index = idTIndex.get(id)) == null) return null;
                if (vectorTermino.get(index) == null) throw new Exception("no existeix");
                return vectorTermino.get(index).getNombre();
        }
        //no hauria de pasar mai:
        return null;
    }

    //retorna les ids de les entitats de tipus=tipus amb Nombre=nom
    public Vector<Integer> getID(String nom, String tipus) throws Exception {
        int n;
        Vector<Integer> v = new Vector();
        if (nom == null) throw new Exception("nom erroni");
        switch (tipus) {
            case "Paper":
                n = vectorPaper.size();
                for (int i = 0; i < n; i++) {
                    if (vectorPaper.get(i) != null && vectorPaper.get(i).getNombre().equals(nom))
                        v.add(vectorPaper.get(i).getId());
                }
                break;
            case "Autor":
                n = vectorAutor.size();
                for (int i = 0; i < n; i++) {
                    if (vectorAutor.get(i) != null && vectorAutor.get(i).getNombre().equals(nom))
                        v.add(vectorAutor.get(i).getId());
                }
                break;
            case "Conferencia":
                n = vectorConferencia.size();
                for (int i = 0; i < n; i++) {
                    if (vectorConferencia.get(i) != null && vectorConferencia.get(i).getNombre().equals(nom))
                        v.add(vectorConferencia.get(i).getId());
                }
                break;
            case "Termino":
                n = vectorTermino.size();
                for (int i = 0; i < n; i++) {
                    if (vectorTermino.get(i) != null && vectorTermino.get(i).getNombre().equals(nom))
                        v.add(vectorTermino.get(i).getId());
                }
                break;
        }
        System.out.println("size del vector: " + v.size());
        return v;
    }
    public Integer getIndiceid (Integer id, String tipus) throws Exception {
        if (id < 0) throw new Exception("id negativa");
        if (id == null) throw new Exception("cal id");
        switch(tipus) {
            case "Paper":       return idPIndex.get(id);
            case "Autor":       return idAIndex.get(id);
            case "Conferencia": return idCIndex.get(id);
            case "Termino":     return idTIndex.get(id);
        }
        //no hauria de passar mai:
        return null;
    }

    public Integer getidIndice(Integer index, String tipus) throws Exception {
        if (index < 0)  throw new Exception("id negativa");
        switch(tipus) {
            case "Paper":
                if (index >= vectorPaper.size()) throw new Exception("index erroni");
                if (vectorPaper.get(index) == null) throw new Exception("no existeix");
                return vectorPaper.get(index).getId();
            case "Autor":
                if (index >= vectorAutor.size()) throw new Exception("index erroni");
                if (vectorAutor.get(index) == null) throw new Exception("no existeix");
                return vectorAutor.get(index).getId();
            case "Conferencia":
                if (index >= vectorConferencia.size()) throw new Exception("index erroni");
                if (vectorConferencia.get(index) == null) throw new Exception("no existeix");
                return vectorConferencia.get(index).getId();
            case "Termino":
                if (index >= vectorTermino.size()) throw new Exception("index erroni");
                if (vectorTermino.get(index) == null) throw new Exception("no existeix");
                return vectorTermino.get(index).getId();
        }
        //no hauria de passar mai:
        return null;
    }

    public boolean addEntidad(String nombre, Integer id, String tag, String tipoEntidad) throws Exception {
        if (id == null) id = ++lastId;
        if (exists(nombre, id, tipoEntidad)) throw new Exception("ja existeix");
        Integer index;
        switch (tipoEntidad) {
            case "Paper":
                index = vectorPaper.size();
                Paper tmpPaper;
                if (tag != null) tmpPaper = new Paper(id, nombre, tag);
                else tmpPaper = new Paper(id, nombre);
                idPIndex.put(id, vectorPaper.size());
                vectorPaper.add(index, tmpPaper);
                System.out.println("xivato"+index+" * "+id);
                return true;
            case "Autor":
                index = vectorAutor.size();
                Autor tmpAutor;
                if (tag!= null) tmpAutor = new Autor(id, nombre, tag);
                else tmpAutor = new Autor(id, nombre);
                idAIndex.put(id, vectorAutor.size());
                vectorAutor.add(index, tmpAutor);
                return true;
            case "Conferencia":
                index = vectorConferencia.size();
                Conferencia tmpConf;
                if (tag != null) tmpConf = new Conferencia(id, nombre, tag);
                else tmpConf = new Conferencia(id, nombre);
                idCIndex.put(id, vectorConferencia.size());
                vectorConferencia.add(index, tmpConf);
                return true;
            case "Termino":
                index = vectorTermino.size();
                Termino tmpTerm = new Termino(id, nombre);
                idTIndex.put(id, vectorTermino.size());
                vectorTermino.add(index, tmpTerm);
                return true;
        }
        //no hauria de passar mai:
        return false;
    }

    public boolean deleteEntidad(String nombre, Integer id, String tipoEntidad) throws Exception {
        if (id < 0) throw new Exception("id negativa");
        if (!exists(nombre, id, tipoEntidad)) throw new Exception("no existeix");
        Integer i = getIndiceid(id, tipoEntidad);
        switch (tipoEntidad) {
            case "Paper":
                idPIndex.remove(id);
                vectorPaper.set(i, null);
                matrizPaperAutor.setRow(i, 0);
                matrizPaperConferencia.setRow(i, 0);
                matrizPaperTermino.setRow(i, 0);
                if (lastId.equals(i)) lastId--;
                return true;
            case "Autor":
                idAIndex.remove(id);
                vectorAutor.set(i, null);
                matrizPaperAutor.setColumn(i, 0);
                if (lastId.equals(i)) lastId--;
                return true;
            case "Conferencia":
                idCIndex.put(id, null);
                vectorConferencia.set(i, null);
                matrizPaperConferencia.setColumn(i, 0);
                if (lastId.equals(i)) lastId--;
                return true;
            case "Termino":
                idTIndex.remove(id);
                vectorTermino.set(i, null);
                matrizPaperTermino.setColumn(i, 0);
                if (lastId.equals(i)) lastId--;
                return true;
        }
        return false;
    }

    public boolean addRelacion(Integer id1, Integer id2, String tipoRelacion) throws Exception {
        if (id1 == null || id2 == null || id1 < 0 || id2 < 0) throw new Exception("id erronia");
        Integer index1, index2;
        switch (tipoRelacion) {
            case "AP":
                index1 = idAIndex.get(id1);
                index2 = idPIndex.get(id2);
                matrizPaperAutor.set(index2, index1, 1);
                return true;
            case "PA":
                index1 = idPIndex.get(id1);
                index2 = idAIndex.get(id2);
                matrizPaperAutor.set(index1, index2, 1);
                return true;
            case "CP":
                index1 = idCIndex.get(id1);
                index2 = idPIndex.get(id2);
                matrizPaperConferencia.set(index2, index1, 1);
                return true;
            case "PC":
                index1 = idPIndex.get(id1);
                index2 = idCIndex.get(id2);
                matrizPaperConferencia.set(index1, index2, 1);
                return true;
            case "TP":
                index1 = idTIndex.get(id1);
                index2 = idPIndex.get(id2);
                matrizPaperTermino.set(index2, index1, 1);
                return true;
            case "PT":
                index1 = idPIndex.get(id1);
                index2 = idTIndex.get(id2);
                matrizPaperTermino.set(index1, index2, 1);
                return true;
        }
        //no hauria de passar mai:
        return false;
    }

    public boolean deleteRelacion(Integer id1, Integer id2, String tipoRelacion) throws Exception {
        if (id1 == null || id2 == null || id1 < 0 || id2 < 0) throw new Exception("id erronia");
        Integer index1, index2;
        switch (tipoRelacion) {
            case "AP":
                index1 = idAIndex.get(id1);
                index2 = idPIndex.get(id2);
                matrizPaperAutor.set(index2, index1, 0);
                return true;
            case "PA":
                index1 = idPIndex.get(id1);
                index2 = idAIndex.get(id2);
                matrizPaperAutor.set(index1, index2, 0);
                return true;
            case "CP":
                index1 = idCIndex.get(id1);
                index2 = idPIndex.get(id2);
                matrizPaperConferencia.set(index2, index1, 0);
                return true;
            case "PC":
                index1 = idPIndex.get(id1);
                index2 = idCIndex.get(id2);
                matrizPaperConferencia.set(index1, index2, 0);
                return true;
            case "TP":
                index1 = idTIndex.get(id1);
                index2 = idPIndex.get(id2);
                matrizPaperTermino.set(index2, index1, 0);
                return true;
            case "PT":
                index1 = idPIndex.get(id1);
                index2 = idTIndex.get(id2);
                matrizPaperConferencia.set(index1, index2, 0);
                return true;
        }
        //no hauria de passar mai:
        return false;
    }

    public boolean setID(Integer oldID, String tipus, Integer newID) throws Exception {
        if (oldID < 0 || newID < 0) throw new Exception("id negativa");
        Integer i = getIndiceid(oldID, tipus);
        if (exists(null, newID, tipus)) throw new Exception("ja existeix");
        switch (tipus) {
            case "Paper":
                oldID = vectorPaper.get(i).getId();
                idPIndex.remove(oldID);
                idPIndex.put(newID, i);
                if (newID > lastId) lastId = newID;
                vectorPaper.get(i).setId(newID);
                return true;
            case "Autor":
                oldID = vectorAutor.get(i).getId();
                idAIndex.remove(oldID);
                idAIndex.put(newID, i);
                if (newID > lastId) lastId = newID;
                vectorAutor.get(i).setId(newID);
                return true;
            case "Conferencia":
                oldID = vectorConferencia.get(i).getId();
                idCIndex.remove(oldID);
                idCIndex.put(newID, i);
                if (newID > lastId) lastId = newID;
                vectorConferencia.get(i).setId(newID);
                return true;
            case "Termino":
                oldID = vectorTermino.get(i).getId();
                idTIndex.remove(oldID);
                idTIndex.put(newID, i);
                if (newID > lastId) lastId = newID;
                vectorTermino.get(i).setId(newID);
                return true;
        }
        //no hauria de passar mai:
        return false;
    }

    public boolean setNom(Integer id, String tipus, String newNom) throws Exception {
        if (id == null || id < 0) throw new Exception("id erronia");
        if (newNom == null) throw new Exception("manca nom");
        Integer i = getIndiceid(id, tipus);
        switch (tipus) {
            case "Paper":
                vectorPaper.get(i).setNombre(newNom);
                return true;
            case "Autor":
                vectorAutor.get(i).setNombre(newNom);
                return true;
            case "Conferencia":
                vectorConferencia.get(i).setNombre(newNom);
                return true;
            case "Termino":
                vectorTermino.get(i).setNombre(newNom);
                return true;
        }
        //no hauria de passar mai:
        return false;
    }

    //Pre: tipus paper/conferencia/autor
    public boolean setTag(Integer id, String tipus, String newTag) throws Exception {
        if (id < 0 || id == null) throw new Exception("id erronia");
        if (newTag == null) throw new Exception("manca tag");
        Integer i = getIndiceid(id, tipus);
        switch (tipus) {
            case "Paper":
                vectorPaper.get(i).setEtiqueta(newTag);
                return true;
            case "Autor":
                vectorAutor.get(i).setEtiqueta(newTag);
                return true;
            case "Conferencia":
                vectorConferencia.get(i).setEtiqueta(newTag);
                return true;
        }
        //no hauria de passar mai:
        return false;
    }

    public Vector<Entidad> getRelacion(Integer id, String tipoEntidad) throws Exception {
        if (id == null || id < 0) throw new Exception("id erronia");
        Vector<Entidad> vR = new Vector();
        int i, j, n;
        switch (tipoEntidad) {
            case "Paper":
                i = idPIndex.get(id);
                n = vectorAutor.size();
                for (j = 0; j < n; ++j) {
                    if (!matrizPaperAutor.isZeroAt(i, j) && vectorAutor.get(j) != null)
                        vR.addElement(vectorAutor.get(j));
                }
                n = vectorConferencia.size();
                for (j = 0; j < n; ++j) {
                    if (!matrizPaperConferencia.isZeroAt(i, j) && vectorConferencia.get(j) != null)
                        vR.addElement(vectorConferencia.get(j));
                }
                n = vectorTermino.size();
                for (j = 0; j < n; ++j) {
                    if (!matrizPaperTermino.isZeroAt(i, j) && vectorTermino.get(j) != null)
                        vR.addElement(vectorTermino.get(j));
                }
                return vR;
            case "Autor":
                j = idAIndex.get(id);
                n = vectorPaper.size();
                for (i = 0; i < n; ++i) {
                    if (!matrizPaperAutor.isZeroAt(i, j) && vectorPaper.get(i) != null)
                        vR.addElement(vectorPaper.get(i));
                }
                return vR;
            case "Conferencia":
                j = idCIndex.get(id);
                n = vectorPaper.size();
                for (i = 0; i < n; ++i) {
                    if (!matrizPaperConferencia.isZeroAt(i, j) && vectorPaper.get(i) != null)
                        vR.addElement(vectorPaper.get(i));
                }
                return vR;
            case "Termino":
                j = idTIndex.get(id);
                n = vectorPaper.size();
                for (i = 0; i < n; ++i) {
                    if (!matrizPaperTermino.isZeroAt(i, j) && vectorPaper.get(i) != null)
                        vR.addElement(vectorPaper.get(i));
                }
                return vR;
        }
        //no hauria de passar mai:
        return null;
    }

    public Entidad getEntidad(Integer id, String tipoEntidad) throws Exception {
        if (id < 0 || id == null) throw new Exception("id erronia");
        Integer i = getIndiceid(id, tipoEntidad);
        if (i != null) {
            switch (tipoEntidad) {
                case "Paper":
                    if (vectorPaper.get(i) == null) throw new Exception("no existeix");
                    return vectorPaper.get(i);
                case "Autor":
                    if (vectorAutor.get(i) == null) throw new Exception("no existeix");
                    return vectorAutor.get(i);
                case "Conferencia":
                    if (vectorConferencia.get(i) == null) throw new Exception("no existeix");
                    return vectorConferencia.get(i);
                case "Termino":
                    if (vectorTermino.get(i) == null) throw new Exception("no existeix");
                    return vectorTermino.get(i);
            }
        }
        //no hauria de passar mai:
        return null;
    }

    public SparseMatrix getMatriz(String tipoColumna) {
        switch (tipoColumna) {
            case "Autor":
                return matrizPaperAutor;
            case "Conferencia":
                return matrizPaperConferencia;
            case "Termino":
                return matrizPaperTermino;
        }
        //no hauria de passar mai:
        return null;
    }

    public boolean addPaper(Paper p) throws Exception {
        if (exists(p.getNombre(), p.getId(), "Paper")) return false;
        Integer i = vectorPaper.size();
        idPIndex.put(p.getId(), i);
        vectorPaper.add(i, p);
        if (lastId < p.getId()) lastId = p.getId();
        return true;
    }

    public boolean addAutor(Autor a) throws Exception {
        if (exists(a.getNombre(), a.getId(), "Autor")) return false;
        Integer i = vectorAutor.size();
        idAIndex.put(a.getId(), i);
        vectorAutor.add(i, a);
        if (lastId < a.getId()) lastId = a.getId();
        return true;
    }

    public boolean addConferencia(Conferencia c) throws Exception {
        if (exists(c.getNombre(), c.getId(), "Conferencia")) return false;
        Integer i = vectorConferencia.size();
        idCIndex.put(c.getId(), i);
        vectorConferencia.add(i, c);
        if (lastId < c.getId()) lastId = c.getId();
        return true;
    }

    public boolean addTermino(Termino t) throws Exception {
        if (exists(t.getNombre(), t.getId(), "Termino")) return false;
        Integer i = vectorTermino.size();
        idTIndex.put(t.getId(), i);
        vectorTermino.add(i, t);
        if (lastId < t.getId()) lastId = t.getId();
        return true;
    }

    public Vector<Paper> getPapers() { return vectorPaper; }

    public Vector<Autor> getAutors() { return vectorAutor; }

    public Vector<Conferencia> getConferencias() { return vectorConferencia; }

    public Vector<Termino> getTerminos() { return vectorTermino; }

    public Integer getLastID() { return lastId; }
}