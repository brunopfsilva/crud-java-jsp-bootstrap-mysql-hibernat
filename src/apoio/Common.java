package apoio;



public class Common {


	//urls
    public static final String URL_HOME = "http://localhost:8080/grupominer3x/dashboard.jsp";
    public static final String URL_LOGIN = "http://localhost:8080/grupominer3x/login.jsp";
    public static final String URL_LOGOFF = "http://localhost:8080/grupominer3x/login.jsp?msg=logoff";
    public static final String url_pool = "pool/pools.jsp";
    public static final String url_coin = "coin/coins.jsp";


    public static boolean isNullOrEmptyString(String content) {
        return (!(content != null && !content.trim().isEmpty()));
    }


}
