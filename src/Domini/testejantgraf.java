package Domini;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Àlvar on 31/05/2016.
 */
public class testejantgraf {
    public static void main (String[] args) {

        System.out.println("Escriu el tipus d'entitat per obtenir id: 'Paper', 'Autor', 'Conferencia' o 'Termino'");
        Scanner sc = new Scanner(System.in);
        String tipus = sc.nextLine();
        System.out.println("Escriu el nom de la entitat");
        String nom = sc.nextLine();
        Grafo g = new Grafo();
        Vector<Integer> vid =  g.getID(nom,tipus);
        if(vid.size() == 0) System.out.println("No s'ha retornat cap ID");
        else {
            System.out.println("Els IDs son: ");
            for (int i = 0; i < vid.size(); i++) {
                System.out.println(vid.get(i));
            }
        }
    }
}
