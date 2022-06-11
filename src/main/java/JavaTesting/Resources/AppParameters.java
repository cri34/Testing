package JavaTesting.Resources;

public class AppParameters {
    public static final String DOMAIN="127.0.0.1";

    public static final String PORT = "80";

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

}
