import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VetClinicList {
    public final static String LISTISEMPTY = "Patients list is empty!";
    List<String> patientList = new ArrayList<>();


    public boolean addPatient(String animal) {
        patientList.add(animal);
       // System.out.println("Patient has been successfully added!");
        return true;
    }

    public void showPatientList() {
        if (patientList.isEmpty()) {
            System.out.println(LISTISEMPTY);
        }
        int length = patientList.size();
        for (int i = 0; i < length; i++) {
            System.out.println(patientList.get(i));
        }
    }

    public String findByName(String name) {
        if (patientList.isEmpty()) {
            System.out.println(LISTISEMPTY);
        }
        for (int i = 0; i < patientList.size(); i++) {
            Pattern pattern = Pattern.compile(name);
            Matcher matcher = pattern.matcher(patientList.get(i));
            if (matcher.find())
                System.out.println(patientList.get(i));
        }
        return null;
    }

    public String findByAge(int age) {
        if (patientList.isEmpty()) {
            System.out.println(LISTISEMPTY);
        }
        String sAge = Integer.toString(age);
        for (int i = 0; i < patientList.size(); i++) {
            Pattern pattern = Pattern.compile(sAge);
            Matcher matcher = pattern.matcher(patientList.get(i));
            if (matcher.find())
                System.out.println(patientList.get(i));
        }
        return null;
    }

    public String findByKind(String kind) {
        if (patientList.isEmpty()) {
            System.out.println(LISTISEMPTY);
        }
        String patt = "(?i)" + kind;
        for (int i = 0; i < patientList.size(); i++) {
            Pattern pattern = Pattern.compile(patt);
            Matcher matcher = pattern.matcher(patientList.get(i));
            if (matcher.find())
                System.out.println(patientList.get(i));
        }
        return null;
    }

}

class Organise {
    public static void main(String[] args) {
        userInterface();

    }
    static void userInterface(){
        Scanner scanner = new Scanner(System.in);
        VetClinicList list = new VetClinicList();
        addPatients(list);
        System.out.println("Hello! You are welcoming to our online Vet-clinic! " +
                "\n What would you like to do?");
        System.out.println("1) Show all patients");
        System.out.println("2) Show patient by name");
        System.out.println("3) Show patient by kind");
        System.out.println("4) Show patient by age");
        System.out.println("5) Show animal kind catalogue");
        System.out.println("6) Close");
        while (true){
            int action = scanner.nextInt();
            switch (action){
                case 1:
                    list.showPatientList();
                    break;
                case 2:
                    System.out.println("Please, enter pet's name: ");
                    String name = scanner.next();
                    list.findByName(name);
                    break;

                case 3:
                    System.out.println("Please, enter pet's kind: ");
                    String kind = scanner.next();
                    list.findByKind(kind);
                    break;
                case 4:
                    System.out.println("Please, enter pet's name: ");
                    int age = scanner.nextInt();
                    list.findByAge(age);
                    break;
                case 5:
                    Stream.of(AnimalKind.values()).forEach(s -> System.out.println(s));
                    break;
                    case 6:
                    return;
                default:
                    System.out.println("No such option! Please, try again :)");
                    break;

            }
        }

    }
    static void addPatients(VetClinicList list){
        AnimalKind kindChin = AnimalKind.CHINCHILLA;
        Animal chinchilla = new Animal.AnimalBuilder(kindChin).setAge(2).setName("Orla").build();

        AnimalKind kindChick = AnimalKind.CHICKEN;
        Animal chicken = new Animal.AnimalBuilder(kindChick).setName("Dushka").build();

        AnimalKind kindDog = AnimalKind.DOG;
        Animal dog = new Animal.AnimalBuilder(kindDog).setAge(10).setName("Mike").build();
        Animal dog01 = new Animal.AnimalBuilder(kindDog).setAge(4).setName("Barbur").build();
        Animal dog02 = new Animal.AnimalBuilder(kindDog).setAge(7).setName("Satana").build();

        AnimalKind kindCat = AnimalKind.CAT;
        Animal cat = new Animal.AnimalBuilder(kindCat).setAge(5).setName("Murzic").build();
        Animal cat01 = new Animal.AnimalBuilder(kindCat).build();
        Animal cat02 = new Animal.AnimalBuilder(kindCat).setAge(6).build();
        Animal cat03 = new Animal.AnimalBuilder(kindCat).setName("Azur").build();

        AnimalKind kindParr = AnimalKind.PARROT;
        Animal parrot = new Animal.AnimalBuilder(kindParr).setAge(20).setName("Grizli").build();

        list.addPatient(chinchilla.toString(kindChin, chinchilla));
        list.addPatient(chicken.toString(kindChick, chicken));
        list.addPatient(dog.toString(kindDog, dog));
        list.addPatient(dog01.toString(kindDog, dog01));
        list.addPatient(dog02.toString(kindDog, dog02));
        list.addPatient(cat.toString(kindCat, cat));
        list.addPatient(cat01.toString(kindCat, cat01));
        list.addPatient(cat02.toString(kindCat, cat02));
        list.addPatient(cat03.toString(kindCat, cat03));
        list.addPatient(parrot.toString(kindParr, parrot));
    }
}
