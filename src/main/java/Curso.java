import java.util.Scanner;

public class Curso {

    public static void main (String [ ] args){
        Scanner in = new Scanner (System.in);
        int senhareal = 90010;
        int senhauser;


        do {
            System.out.println("digite a senha");
            senhauser = in.nextInt();


            if (senhauser != senhareal){
                System.out.println("senha incorreta");
            }


        }while (senhauser !=senhareal);
            System.out.println("voce passou");

        }


    }

