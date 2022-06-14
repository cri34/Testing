package JavaTesting.Resources;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class AppParameters {
    public static final String DOMAIN="127.0.0.1";

    public static final String PORT = "80";

    public static final String password="12345678";
    public static String salt="z2P283rgMEL0";
    public static String passwordAndSalt ="";
    public static String hashPasword="fb535794bef86ccd3a342f14d64b072704a4ec5f59b0fdf92e754d75d4d00cba";
    public static Random rand=new Random();
    public  static  AppParameters instance;
    private AppParameters(){

    }
    public static AppParameters getInstance() {
        if (instance == null)
            instance = new AppParameters();
        return instance;
    }
    public static String deployedURL(){
        return "https://"+DOMAIN+":"+PORT;
    }

    private static String generateRandomCharacters(int lenght){
        String randChars="";
        int[] minCodeAsciGroup={48,65,97};
        int[] maxIntervalNumber={10,26,26};
        int index=0;
        int randInterval=0;
        int numberCode=0;

        for (int i=0;i<lenght;i++){
            index=rand.nextInt(3);

            randInterval=rand.nextInt(maxIntervalNumber[index]);

            numberCode=minCodeAsciGroup[index];

            randChars+=(char)(numberCode + randInterval);

        }
       return randChars;

    }
public static String generateSalt(int lenght){
        salt=generateRandomCharacters(lenght);
        return salt;
    }

    public static String PasswordWithSalt(){
        passwordAndSalt =password + salt;
        return passwordAndSalt;
    }
  public static String doHashing(String toHash){

        try{
            MessageDigest digest=MessageDigest.getInstance("SHA-256");
            digest.update(toHash.getBytes());
            byte[] result=digest.digest();
            StringBuilder sb =new StringBuilder();
            for(byte a:result){
                sb.append(String.format("%02x",a));

            }
            hashPasword=sb.toString();
            return hashPasword;
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return "";
  }
  private void init(){
        generateSalt(10);
        PasswordWithSalt();
        doHashing(passwordAndSalt);

  }
    public static void main(String[] args) {
AppParameters a=new AppParameters();
a.init();
System.out.println("hashPassword = "+doHashing(PasswordWithSalt()));
System.out.println("salt = "+generateSalt(+12));
System.out.println("password = "+password);

    }
}
