package Domini;

import Persistencia.ctr_usuari_pers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class ctr_usuari_dom {
    private ConjuntoUsuarios cjt = new ConjuntoUsuarios();
    private ctr_usuari_pers ctr_pers =new ctr_usuari_pers();
    private usuari_estandard user;
    private final int nusuaris = 6;
    private final int nrel = 3;

    public boolean loggin(String nom, String pass) {
        usuari_estandard user = cjt.getUsuario(nom);
        if (user == null) return false;
        if (user.checkPassword(pass)) {
            this.user = user;
            return true;
        }
        return false;
    }

    public void afegir_relacio(String nom, String path, String descripcio) {
        if (descripcio == null) user.addRelacion(nom, path);
        else user.addRelacion(nom, path, descripcio);
    }

    public boolean esborrar_relacio(String nom) {
        return user.deleteRelacion(nom);
    }

    public boolean modificar_relacio(String nom, String nomNou, String descripcio) {
        return user.modificar_relacio(nom, nomNou, descripcio);
    }
    public boolean modificar_usuari_estandard(String oldPass, String pass, String nom, String sexe, String data) throws ParseException{
        Date date = null;
        if(data!=null) date = transformar_data.stringToDate(data);
        return user.modificar_usuari(oldPass, pass, nom, sexe, date);
    }
    public boolean modificar_usuari_privilegiat(String username, String pass, String nom, String sexe, String data ) throws ParseException{
        Date date = null;
        if(data != null) date = transformar_data.stringToDate(data);
        return (aux((usuari_privilegiat) user)).modificar_usuari(username, pass, nom, sexe, date, cjt);
    }

    public ArrayList<ArrayList<String>> informacio_relacions() {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        Map<String, TipoRelacion> map = user.getRelacions();
        TipoRelacion auxiliar;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            ArrayList<String> result_aux = new ArrayList<String>(nrel);
            String key = (String) it.next();
            auxiliar = map.get(key);
            result_aux.add(auxiliar.getNombre());
            result_aux.add(auxiliar.getPath());
            result_aux.add(auxiliar.getDescripcion());
            result.add(result_aux);
        }
        return result;
    }

    public void borrar_usuari_estandard() {
        user.borrar_usuari(cjt);
    }

    public boolean crear_usuari(String username, String pass, boolean privilegiat) {
        usuari_estandard user;
        if (privilegiat) user = new usuari_privilegiat(username, pass);
        else user = new usuari_estandard(username, pass);
        return cjt.addUsuario(user);
    }

    public boolean borrar_usuari(String user_borrar) {
        return (aux((usuari_privilegiat) user)).borrar_usuari(user_borrar, cjt);
    }

    private usuari_privilegiat aux(usuari_privilegiat up) {
        return up;
    }

    public boolean donar_privilegis(String username) {
        usuari_estandard usuari = cjt.getUsuario(username);
        if ((usuari == null) || (usuari instanceof usuari_privilegiat)) return false;
        (aux((usuari_privilegiat) user)).donar_privilegis(usuari, cjt);
        return true;
    }

    public ArrayList<ArrayList<String>> informacio_usuaris() {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        Map<String, usuari_estandard> map = (aux((usuari_privilegiat) user)).informacio_usuaris(cjt);
        usuari_estandard auxiliar;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            ArrayList<String> result_aux = new ArrayList<String>(nusuaris);
            String key = (String) it.next();
            auxiliar = map.get(key);
            result_aux.add(auxiliar.getUsername());
            result_aux.add(auxiliar.getPassword());
            result_aux.add(auxiliar.getNombre());
            result_aux.add(auxiliar.getSexo());
            result_aux.add(transformar_data.dateToString(auxiliar.getFechaN()));
            result_aux.add(auxiliar.getClass().getSimpleName());
            result.add(result_aux);
        }
        return result;
    }

    public String consultar_relacio(String nom) {
        TipoRelacion rel = user.getRelacion(nom);
        if(rel!=null) return rel.getPath();
        return null;
    }
    public boolean exist_relacio(String nom){
        return user.getRelacion(nom) != null;
    }
    public String get_nom_relacio(String path){
        Map<String, TipoRelacion> map = user.getRelacions();
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            String key = (String)it.next();
            TipoRelacion aux = map.get(key);
            if(aux.getPath().equals(path)) return aux.getNombre();
        }
        return null;
    }
    public void carregar_usuaris() throws ParseException,NullPointerException,IOException{
        ArrayList<ArrayList<String>> a =null;
        a = ctr_pers.carregar_usuaris();
        ArrayList<String> aux;
        for (int i = 0; i < a.size(); ++i) {
            aux = a.get(i);
            usuari_estandard user;
            if((aux.get(0)).equals("usuari_estandard")) user = new usuari_estandard(aux.get(1), aux.get(2));
            else user = new usuari_privilegiat(aux.get(1), aux.get(2));
            String nom = aux.get(3);
            if(nom != null) user.setNombre(nom);
            String sex = aux.get(4);
            if(sex != null) user.setSexo(sex);
            String data = aux.get(5);
            if(data != null) user.setFechaN(transformar_data.stringToDate(data));
            for(int j = 6; j < aux.size(); j+=3){
                String desc = aux.get(j + 2);
                if(desc == null) user.addRelacion(aux.get(j), aux.get(j + 1));
                else user.addRelacion(aux.get(j), aux.get(j + 1), desc);
            }
            cjt.addUsuario(user);
        }
    }
    public void guardar_usuaris() throws FileNotFoundException,NullPointerException{
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        Map<String, usuari_estandard> users = cjt.getConjunto();
        Iterator it = users.keySet().iterator();
        usuari_estandard uaux;
        while(it.hasNext()){
            String key = (String) it.next();
            uaux = users.get(key);
            ArrayList<String> aaux = new ArrayList<String>();
            aaux.add(uaux.getClass().getSimpleName());
            aaux.add(uaux.getUsername());
            aaux.add(uaux.getPassword());
            aaux.add(uaux.getNombre());
            aaux.add(uaux.getSexo());
            aaux.add(transformar_data.dateToString(uaux.getFechaN()));
            Map<String, TipoRelacion> relacions = uaux.getRelacions();
            if(!relacions.isEmpty()){
                Iterator it2 = relacions.keySet().iterator();
                while (it2.hasNext()) {
                    String key2 = (String) it2.next();
                    TipoRelacion relacio = relacions.get(key2);
                    aaux.add(relacio.getNombre());
                    aaux.add(relacio.getPath());
                    aaux.add(relacio.getDescripcion());
                }
            }
            res.add(aaux);
        }
        ctr_pers.guardar_usuaris(res);
    }
    public String usuari_actual(){
        return user.getUsername();
    }

    public boolean privilegiat() {
        return (user != null)&&user.getClass().getSimpleName().equals("usuari_privilegiat");
    }
}
