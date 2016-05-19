package Presentacio;

import Domini.ControladorCerques;
import Domini.ControladorGrafo;
import Domini.ctr_usuari_dom;
import javafx.util.Pair;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by albert.val.vila on 10/05/2016.
 */
public class CtrlPresentacio {
    private VistaCerques vcerques = null;
    private ControladorCerques cc;
    private ControladorGrafo cg;
//////////////////Constructor i metodes ini
    public CtrlPresentacio(){
        try {
            cg = new ControladorGrafo();
            cg.cargarGrafo();
            cc = new ControladorCerques(cg);
            ctr_dom = new ctr_usuari_dom();
        } catch (IOException e) {
            e.printStackTrace(); //no s'han pogut carregar les dades
        }
      //  if(vcerques==null) vcerques = new VistaCerques(this);

    }
    public void init() {

        //vcerques.ferVisible();
        inici i = new inici(this);
        i.vista();
    }


    //////////AccesControladorDomini
    public Vector<Integer> NomToID(String nom,String tipus) {
        return cc.getIDs(nom, tipus);
    }
    public Double CercaRellevancia(String path, Vector<Integer> vs){
        return cc.CercaRellevancia(path,vs);
    }
    public String TipusEquilvalent(char c){
        return cc.Entitatequivalent(c);
    }
    public Vector<Vector<Integer>> Clustering(String path,int numgrups,Vector<Integer> vs,int niteracions){
        return cc.Clustering(path,numgrups,vs,niteracions);
    }
    public  Vector<Pair<String,Vector<Vector<Integer>>>> UltimsClust(){
        return cc.getListClust();
    }
    public Vector<Vector<Integer>> FiltratClustering(int i,String etiq){
       return cc.FilterClustering(i,etiq);
    }
    public String IDToNom(Integer id,String tipus){
        return cc.getnomEntitat(id,tipus);
    }
    ///////////Metodes tractamentinputoutput

    public Vector<String> readTextArea(JTextArea t) {
        System.out.println(t.getLineCount());
        String[] s = t.getText().split("\\n");
        Vector<String> v = new Vector<>();
        for (int i = 0; i <s.length ; i++) {
            v.add(s[i]);
            System.out.println(s[i]);
        }
        return v;
    }
    public String[] convert(Vector<Integer> w) {
        Vector<String> v = new Vector<>();
        for (int i = 0; i <w.size() ; i++) {
            v.add(w.get(i).toString());
        }
        return v.toArray(new String[v.size()]);
    }
    public void checknorepe(Vector<Integer> w, Integer integer) throws Exception {
        System.out.println("check "+integer);
        boolean trobat=false;
        int i=0;
        while(!trobat && i<w.size()-1){
            if(integer.equals(w.get(i))) {
                System.out.println("excepcio");
                throw new Exception("Entitats Repetides");}
            ++i;
        }
    }
    public String[] MostraClustering(Vector<Vector<Integer>> c,String tipus) {
        Vector<String> v= new Vector<>();
        for (int i = 0; i < c.size() ; i++) {
            for (int j = 0; j <c.get(i).size() ; j++) {
                if(j==0 && i!=c.size()-1) v.add("Grup "+i+" :");
                else if(j==0) v.add("Elements No agrupats :");
                v.add(IDToNom(c.get(i).get(j),tipus));
            }
        }
        return v.toArray(new String[v.size()]);
    }
    //MULTIUSUARI A CERQUES

    public void vistacerques() {
        principal.setVisible(false);
        if(vcerques==null) vcerques = new VistaCerques(this);
        vcerques.ferVisible();
        principal.setVisible(false);
    }

    ///////MULTIUSUARI

    private ctr_usuari_dom ctr_dom;
    private crear_relacio crear_relacio;
    private crear_usuari crear_usuari;
    private gestio_privilegiat gestio_privilegiat;
    private gestio_relacions gestio_relacions;
    private gestio_usuari gestio_usuari;
    private inici inici;
    private loggin loggin;
    private modificar_relacio modificar_relacio;
    private modificar_usuari_estandard modificar_usuari_estandard;
    private modificar_usuari_privilegiat modificar_usuari_privilegiat;
    private relacions_directes relacions_directes;
    private principal principal;

    boolean loggin(String nom, String pass){
        return ctr_dom.loggin(nom, pass);
    }
    void afegir_relacio(String nom, String path, String descripcio){
        ctr_dom.afegir_relacio(nom, path, descripcio);
    }
    boolean esborrar_relacio(String nom){
        return ctr_dom.esborrar_relacio(nom);
    }
    boolean modificar_relacio(String nom, String nomNou, String descripcio){
        return ctr_dom.modificar_relacio(nom, nomNou, descripcio);
    }
    boolean modificar_usuari_estandard(String oldPass, String pass, String nom, String sexe, String data){
        return ctr_dom.modificar_usuari_estandard(oldPass, pass, nom, sexe, data);
    }
    boolean modificar_usuari_privilegiat(String username, String pass, String nom, String sexe, String data ){
        return ctr_dom.modificar_usuari_privilegiat(username, pass, nom, sexe, data);
    }
    ArrayList<ArrayList<String>> informacio_relacions(){
        return ctr_dom.informacio_relacions();
    }
    void borrar_usuari_estandard(){
        ctr_dom.borrar_usuari_estandard();
    }
    boolean crear_usuari(String username, String pass, boolean privilegiat){
        return ctr_dom.crear_usuari(username, pass, privilegiat);
    }
    boolean borrar_usuari(String user_borrar){
        return ctr_dom.borrar_usuari(user_borrar);
    }
    boolean donar_privilegis(String username){
        return ctr_dom.donar_privilegis(username);
    }
    ArrayList<ArrayList<String>> informacio_usuaris(){
        return ctr_dom.informacio_usuaris();
    }
    void afegir_element(String nom, Integer id, String etiq, String tipus){
        ctr_dom.afegir_element(nom, id, etiq, tipus);
    }
    void afegir_relacio_graf(Integer primer, Integer segon, String tipus){
        ctr_dom.afegir_relacio_graf(primer, segon, tipus);
    }
    void esborrar_element(String nom, Integer id, String tipus){
        ctr_dom.esborrar_element(nom, id, tipus);
    }
    void esborrar_relacio_graf(Integer primer, Integer segon, String tipus){
        ctr_dom.esborrar_relacio_graf(primer, segon, tipus);
    }
    void carregar_usuaris() throws FileNotFoundException,NullPointerException{
        ctr_dom.carregar_usuaris();
    }
    void guardar_usuaris() throws FileNotFoundException,NullPointerException{
        ctr_dom.guardar_usuaris();
    }
    String usuari_actual(){
        return ctr_dom.usuari_actual();
    }
    void crear_relacio(){
        crear_relacio = new crear_relacio(this);
        crear_relacio.vista();
    }
    void crear_usuari(){
        crear_usuari = new crear_usuari(this);
        crear_usuari.vista();
    }
    void gestio_privilegiat(){
        gestio_privilegiat = new gestio_privilegiat(this);
        gestio_privilegiat.vista();
    }
    void gestio_relacions(){
        gestio_relacions = new gestio_relacions(this);
        gestio_relacions.vista();
    }
    void gestio_usuari(){
        gestio_usuari = new gestio_usuari(this);
        gestio_usuari.vista();
    }
    void inici(){
        inici = new inici(this);
        inici.vista();
    }
    void loggin(){
        loggin = new loggin(this);
        loggin.vista();
    }
    void modificar_relacio(){
        modificar_relacio = new modificar_relacio(this);
        modificar_relacio.vista();
    }
    void modificar_usuari_estandard(){
        modificar_usuari_estandard = new modificar_usuari_estandard(this);
        modificar_usuari_estandard.vista();
    }
    void modificar_usuari_privilegiat(){
        modificar_usuari_privilegiat = new modificar_usuari_privilegiat(this);
        modificar_usuari_privilegiat.vista();
    }
//    void relacions_directes(){
//        relacions_directes = new relacions_directes(this);
//        relacions_directes.vista();
//    }
    void carregar_ctr_dom(ctr_usuari_dom ctr){
        ctr_dom = ctr;
    }
    boolean privilegiat(){return ctr_dom.privilegiat();}
    void principal(){
        principal = new principal(this);
        principal.vista();}

    public boolean cargar_graf() {
        return true;
    }

    public boolean guardar_graf() {
        return true;
    }

}
