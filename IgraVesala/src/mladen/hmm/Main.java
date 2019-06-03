package mladen.hmm;

import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main extends Exception {

    public static void main(String[] args) throws Exception {
	// write your code here



        // Ubacivanje  Reci u Array listu tj spisak svih dostupnih reci

        File file = new File("C:\\Users\\A392662\\Desktop\\JavaProjekti\\IgraVesala\\src\\mladen\\hmm\\BazaReci");
        Scanner scanner1 = new Scanner(file);
        ArrayList<String> listaReci = new ArrayList<>();
        int lineNumber = 1;
        while (scanner1.hasNext()){
            listaReci.add(scanner1.nextLine());
            lineNumber++;
        }
        scanner1.close();

// Incijalizacija rece - UZIMA SE RANDOM REC IZ BazeReci

        Random random = new Random();
        int izvucanaRec =(random.nextInt(lineNumber)) ;
        char [] charArray =listaReci.get(izvucanaRec).toCharArray();



        Scanner scanner = new Scanner(System.in);
        int pokusaj =6;
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

        int pogodjenaSlova =0;


        while(pokusaj>0){
            System.out.println();
            System.out.println();
            System.out.println("UNESTITE  SLOVO ");
            char unos = scanner.next("[a-zA-Z]").toLowerCase().charAt(0);


            for (int i =0;i<charArray.length;i++)
                if(charArray[i]==unos) {
                    pogodjenaSlova++;
                    skrivenArray[i]=unos;
                }

            System.out.println("Broj Pogodjenih SLOVA "+pogodjenaSlova);

            if(pogodjenaSlova==0){
                pokusaj--;
                System.out.println("TRAZENO SLOVO NE POSTOJI");
                System.out.println();
                System.out.println("Broj pokusaja je "+pokusaj);
                pogodjenaSlova=0;
            }
            else
            System.out.println("Broj pokusaja je "+pokusaj);

            stampajrec(skrivenArray);


            if(pogodjenaSlova==duzina) {
                System.out.println("USPESNO STE RESILI SKRIVENU REC");
                System.exit(0);


            }
            pogodjenaSlova=0;
        }

    } // END OF MAIN


 // Methoda koja stampa skrivenu rec

    public static void stampajrec (char passArra []){
        for (int i = 0; i<passArra.length;i++)
            System.out.print(passArra[i]+" ");
        System.out.println();
    } // end of method


// provera da li je trazena rec kompletirana





}// END OF CLASS
