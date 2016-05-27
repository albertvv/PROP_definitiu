package Domini;

import java.util.Date;
import java.util.Map;

public class usuari_privilegiat extends usuari_estandard {
    public usuari_privilegiat(String user, String pass){super(user,pass);}
    public usuari_privilegiat(usuari_estandard standard_user){
        super(standard_user.getUsername(), standard_user.getPassword());
        setNombre(standard_user.getNombre());
        setSexo(standard_user.getSexo());
        setFechaN(standard_user.getFechaN());
        conjTRel = standard_user.getRelacions();
    }
    public boolean modificar_usuari(String username, String pass, String nom, String sexe, Date naix, ConjuntoUsuarios cjt){
        usuari_estandard user = cjt.getUsuario(username);
        if(user == null) return false;
        return modificar_usuari_aux(user, user.getPassword(), pass, nom, sexe, naix);
    }
    public boolean borrar_usuari(String username, ConjuntoUsuarios cjt){
        return cjt.deleteUsuario(username);
    }
    public void donar_privilegis(usuari_estandard ue, ConjuntoUsuarios cjt){
        usuari_privilegiat up = new usuari_privilegiat(ue);
        cjt.deleteUsuario(up.getUsername());
        cjt.addUsuario(up);
    }
    public Map<String, usuari_estandard> informacio_usuaris(ConjuntoUsuarios cjt){return cjt.getConjunto();}
}

