
public class DataDrivenTesting {

    public static void main(String[] args) {
        System.out.println("Scenario Outline - exemplu - Vezi in Login Test");

/*  ATENTIE :

    1. Daca rulam mai multe scenarii din clasa Login.feature o sa primim eroare pt ca se suprapun valorile.
    2. Normal acestea se ruleaza din fixierul EXCEL.
    SCENARIO            - nu se repeta scenariile la rulare
    SCENARIO OUTLINE    - repetam mai multe scenarii cand le rulam.

    3. Deci nu se mai foloseste tabelul de valori din Login.feature, se copiem valorile din fisierul EXCEL care este
       in clasa:
        - LoginDDTExcel

    Pentru acesta in clasa TestRunner o sa deselectam linia de comanda:
    features= {".//Features/LoginDDTExcel.feature"},

 */

/*
    Scenariul SELENIUM GRID
    Pentru acesta in clasa TestRunner o sa deselectam linia de comanda:
         features= {".//Features/Login.feature",".//Features/Registration.feature"},
 */

/*
    Pentru a lucra din pom.xml este neboie sa deselectam linia de comanda:
            features= {".//Features/Login.feature",".//Features/Registration.feature"},
    si sa lucram pe local:
            execution_env=local
 */




    }

}
