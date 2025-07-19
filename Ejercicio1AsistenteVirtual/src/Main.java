import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static Calendar cal = Calendar.getInstance();
    public static void main(String[] args) {
        int hor = cal.get(Calendar.HOUR_OF_DAY);
        String nomb= saludo_ini(hor);
        ArrayList <String> usuarios = new ArrayList<>();
        usuarios=verificacion(nomb,usuarios);
        System.out.println("Bienvenido "+nomb);
        String seg="";
        do{
            System.out.println("1. Para saludar, 2. Para obtener la hora, 3. Para registrarse, 0. Para salir");



        }while(seg.equals("si"));





    }
    public static String saludo_ini (int hor){
        if (hor>1 && hor<12){
            System.out.println("Buenos dias, ingrese su nombre de usuario, en caso de no estar registrado se le creara uno.");
        }else  if (hor>=12 && hor<18){
            System.out.println("Buenas tardes, ingrese su nombre de usuario, en caso de no estar registrado se le creara uno.");
        } else if (hor>=18) {
            System.out.println("Buenas noches, ingrese su nombre de usuario, en caso de no estar registrado se le creara uno.");
        }
        String nomb=sc.next();
        return nomb;
    }
    public static ArrayList<String> verificacion(String nomb, ArrayList<String> usuarios){
        boolean existe=false;
        try{
            for(int i=0;i<usuarios.size();i++){
                if (usuarios.get(i).equals(nomb)){
                    existe=true;
                    break;
                }
            }
        }catch(Exception e) {
            System.out.println("Felicidades, eres el primer usuario");
        }
        if (existe==false){
            usuarios.add(nomb);
        }
        return  usuarios;
    }
}
