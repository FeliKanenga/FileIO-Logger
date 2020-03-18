import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

 class Visitors {
    private static String fullname;
    private static int age;
    private static String comments;
    private static String pov = "Security Guard";
    private static String data;

    private static final Logger logger = LogManager.getLogger(Visitors.class.getName());

    public static String save(){
        try{
            FileWriter myWriter = new FileWriter
                    ("files/Visitor"+
                            fullname.replace(" ","_").toLowerCase()+".txt");
            myWriter.write("Visitor's Full name : " + fullname +"\n"
                    + "Visitor's age : " + age + "\n"
                    +"Date of Visit: " + LocalDate.now() + "\n"
                    + "Time of Visit: " + LocalTime.now() + "\n"
                    + "Reason of Visit: " + comments + "\n"
                    + "name of the person who assisted the visitor: " + pov);
            myWriter.close();
            logger.info("Successfully wrote to the file.");

            return "Success";

        } catch (IOException e) {
            logger.error("An error occurred.");
            logger.error(e.getMessage());
            return "Failed";
        }


    }



    public static String load(String name){


        try {
            File file = new File("files/Visitor"+name.replace(" ","_")
                    .toLowerCase()+".txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                 data = myReader.nextLine();
                logger.info(data);

            }
            myReader.close();
            return "Success";
        }

        catch (FileNotFoundException e) {
            logger.error("An error occurred.");
            logger.error(e.getMessage());
            return "Failed";
        }


    }


    public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);

        System.out.println("Please enter your name ");
        fullname = scan.nextLine();

        System.out.println("Please enter your age ?");
        age = scan.nextInt();

        System.out.println("Please enter reason of visit");
        comments = scan.next();

        System.out.println("Thank you");
        String pov2 = scan.nextLine();

        save();

        System.out.println();
        System.out.println();

        System.out.println("Is there any document you would like to see, please enter y (yes) or n (no)");
        String answer = scan.nextLine().toLowerCase();

        if(answer.equals("y")){
            System.out.println();
            System.out.println("Enter the name of the person's detail you would like to see");
            String name = scan.next();
            load(name);
        }else {
            System.out.println("Thank you for using our program");
        }

    }













}
