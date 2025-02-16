public class CucumberStructure {

    public static void main(String[] args) {
        System.out.println("Structura unui folder Cucumber contine urmatoarele: \n" +
        "1) 5 pachete principale formate din :\n" +
        "   1.1 factory \n " +
        "   1.2 pageObject \n " +
        "   1.3 stepDefinitions \n " +
        "   1.4 testRunner \n " +
        "   1.5 utilities \n " +
        "2) src/test/resources - contine :\n" +
        "   2.1 config.properties \n " +
        "   2.2 extent.properties \n " +
        "   2.3 log4j2.xml \n " +
        "3) Features - contine :\n" +
        "   3.1 Login.features \n " +
        "   3.2 LoginDDTExcel.feature \n " +
        "   3.3 Registration.feature \n " +
        "4) logs - contine :\n" +
        "   4.1 automation.log \n " +
        "5) reports - contine :\n" +
        "   5.1 myreports.html \n " +
        "6) testData - contine :\n" +
        "   6.1 date de logare in XML file \n " +
        "7) testData - contine :\n" +
        "   7.1 SparkReport/Report \n "
        );
    }
/*
    Pentru a avea un proiect Maven-Cucumber este necesar sa se genereze structura de mai sus.
    DECI PARCURGEM PASII:
    1)  Create Maven Project - Update pom.xml
    2)  Create Folder structure
    3)  Generate contents to Page Object class, Base class, Hooks class
        Hooks will call meter of Base class si ia totul din aceassta
        Base class - all are STATIC in this class
    4)  Features Files





 */


}
