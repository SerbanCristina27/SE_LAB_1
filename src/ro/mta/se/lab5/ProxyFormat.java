package ro.mta.se.lab5;

/**
 * Created by User on 11/27/2016.
 */
public class ProxyFormat implements IProxyFormat{
    private String format;

    public String getFormat() {
        return format;
    }

    public boolean valid(){
        return true;
    }
}
