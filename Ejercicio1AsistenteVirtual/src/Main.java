import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static Calendar cal = Calendar.getInstance();
    public static void main(String[] args) {
        int hor = cal.get(Calendar.HOUR_OF_DAY);
        String error = "";

        String nomb = saludo_ini(hor);
        ArrayList <String> usuarios = new ArrayList<>();//Creamos el arreglo para guardar los nombres
        sc.nextLine();
        usuarios = verificacion(nomb,usuarios);//Verificamos que el nombre se guarde, es un poco incesesario siendo el primero, pero si integraramos base de datos seria necesario hacerlo desde un inicio

        System.out.println("Bienvenido/a " + nomb);
        String op = ""; String seg = "si";
        do{
            if(seg.equals("si")){
                System.out.println(" ");
                System.out.println("Digite el numero que desee ejecutar: ");
                System.out.println("1. Saludar");
                System.out.println("2. Ver la hora");
                System.out.println("3. Registrar nombre de usuario");
                System.out.println("4. Ver nombres de usuarios");
                System.out.println("0. Salir");
                System.out.println(" ");
                op = sc.nextLine();

                switch(op){
                    case "1":
                        System.out.println("¡Holaa! " +nomb+ " Soy tu asistente virtual, estare aqui para ayudarte siempre:)" );
                        break;
                    case "2":
                        int min = cal.get(Calendar.MINUTE);
                        if (hor<=11) {
                            System.out.println("¿Quieres saber la hora? " + nomb + ", tranqui. Son las..." + hor + ":" + min + "am");
                        }else if (hor==12){
                            System.out.println("¿Quieres saber la hora? " + nomb + ", tranqui. Son las..." + 12 + ":" + min + "pm");
                        }else{
                            System.out.println("¿Quieres saber la hora? " + nomb + ", tranqui. Son las..." + (hor - 12) + ":" + min + "pm");
                        }
                        break;
                    case "3":
                        System.out.println("¿Cual es el nombre del usuario que desea registrar?");
                        String nombre = sc.nextLine();
                        usuarios = verificacion(nombre,usuarios);
                        break;
                    case "4":
                        System.out.println("Nombres de usuarios");
                        nombRegistrados(usuarios);
                        break;
                    case "0":
                        System.out.println("Es una pena que te vayas:( "+nomb+", nos vemos la proxima ocacion!");
                        seg="no";
                        break;
                    default:
                        System.out.println("Opcion no permitida... intenta de nuevo");
                        error = "ja";

                }


            }else{
                System.out.println("Opcion no permitida... intenta de nuevo");
                seg = "si";
            }
            if (!op.equals("0") && !error.equals("ja")) {
                System.out.println("¿Quieres hacer otra cosa?:p (si/no)");
                seg = sc.nextLine().trim().toLowerCase();
            }
            error ="no";

        }while(!seg.equals("no"));
        System.out.println("Saliendo del sistema...");
    }

    //Saludo inicial, tiene diferentes tipos de saludo dependiendo de la hora del dia para ser mas agradable para el usuario
    public static String saludo_ini (int hor){
        if (hor>1 && hor<12){
            System.out.println("Buenos dias, ingrese su nombre de usuario, en caso de no estar registrado se le creara uno.");
        }else  if (hor>=12 && hor<18){
            System.out.println("Buenas tardes, ingrese su nombre de usuario, en caso de no estar registrado se le creara uno.");
        } else if (hor>=18) {
            System.out.println("Buenas noches, ingrese su nombre de usuario, en caso de no estar registrado se le creara uno.");
        }
        return sc.next();
    }
    //Verificacion para ver si un usuario esta registrado o no
    public static ArrayList<String> verificacion(String nomb, ArrayList<String> usuarios){
        boolean existe=false;
        try{
            for (String usuario : usuarios) {
                if (usuario.equals(nomb)) {
                    System.out.println("El nombre de usuario " + nomb + " ya existe:D");
                    existe = true;
                    break;
                }
            }
        }catch(Exception e) {
            System.out.println("Felicidades, eres el primer usuario");
        }
        if (!existe){
            usuarios.add(nomb);
        }
        return  usuarios;
    }
    //Registro, lista de usuarios
    public static void nombRegistrados(ArrayList<String> lista){
        for (String s : lista) {
            System.out.println(s);
        }
    }
}