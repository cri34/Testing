package DomainEntities;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class PasswordUtilis {
    private static final Random rand= new SecureRandom();
    private static final String ALPHABET="0123456789abcdefghijklnopqrstvxz";
    public static String genSalt(){
        return genSalt(8);
    }
    public static String genSalt(int l){
        StringBuilder valor= new StringBuilder(l);
        for(int k =0;k<l;k++){
            valor.append(ALPHABET.charAt(rand.nextInt(ALPHABET.length()) ));
        }
        return new String(valor);
    }
    public static String genSecurePassword(String password,String salt)throws NoSuchAlgorithmException{

        return hashedPassword(password, salt);
    }
    public static String hashedPassword(String password,String salt) {
        MessageDigest md;
        String result="";
        try{
            md= MessageDigest.getInstance("SHA-256");
            md.update( (salt + password).getBytes());

            result= new String(md.digest());
        }catch(NoSuchAlgorithmException nsae){
            System.out.println("Algoritme hash erroneo");
            System.exit(1);
        }


        return result;
    }
    public static boolean verifyUserPassword(String passwordEntered, String userSalt, String securePassword){
        return securePassword.equals(hashedPassword(passwordEntered,userSalt));

    }
}
