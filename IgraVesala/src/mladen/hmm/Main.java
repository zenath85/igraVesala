package mladen.hmm;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner scanner = new Scanner(System.in);


        int pokusaj =6;
// Incijalizacija rece - idealno treba zameniti sa random reci iz fajla
        char  [] charArray =  {'m', 'l','a', 'd','e','b'};
        int duzina = charArray.length;

//SKRIVENA REC
        char [] skrivenArray = new char[duzina];
        for(int i =0; i <duzina;i++)
            skrivenArray[i]='_';



        System.out.println("DOBRO DOSLI U IGRU VESALA , CILJ IGRE JE POGODITI TRAZENU REC ");
        System.out.println("trenutno imate " + pokusaj+" pokusaja ");
        System.out.println();
        System.out.println("TRAZENA REC");
        stampajrec(skrivenArray);

        System.out.println();


        while(pokusaj>0){
            System.out.println();
            System.out.println();
            System.out.println("UNESTITE  SLOVO ");
            char unos = scanner.next("[a-zA-Z]").toLowerCase().charAt(0);


            int pogodjenaSlova =0;

            for (int i =0;i<charArray.length;i++)
                if(charArray[i]==unos) {
                    pogodjenaSlova++;
                    skrivenArray[i]=unos;
                }

            if(pogodjenaSlova==0){
                pokusaj--;
                System.out.println("TRAZENO SLOVO NE POSTOJI");
                System.out.println();
                System.out.println("Broj pokusaja je "+pokusaj);
            }
            else
                System.out.println("Broj pokusaja je "+pokusaj);


            stampajrec(skrivenArray);

            if(isWordCompleted(skrivenArray)) {
                System.out.println("USPESNO STE RESILI SKRIVENU REC");
                System.exit(0);


            }

        }

    }


 // Methoda koja stampa skrivenu rec

    public static void stampajrec (char passArra []){
        for (int i = 0; i<passArra.length;i++)
            System.out.print(passArra[i]+" ");
        System.out.println();
    } // end of method


// provera da li je trazena rec kompletirana

    public static boolean isWordCompleted(char passArra[]){
        for(int i =0; i<passArra.length;i++) {

            if (passArra[i]=='_')
            return false;
        }
        return true;



    } // kraj methode



}
