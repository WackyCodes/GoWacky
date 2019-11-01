package wackycodes.gowacky.adaptor_model_fragment;

public class W_FragmentTwoModelClass {

    public String wPassengerName,wPassengerGender;
    public String  wPassengerStartingPoint,wPassengerEndPoint;
    public String  wCallToPassengerTV, wMessageToPassengerTV;
    public int  wPassengerOtpET, wPassengerAge;

    public W_FragmentTwoModelClass(String wPassengerName, String wPassengerGender, String wPassengerStartingPoint, String wPassengerEndPoint, String wCallToPassengerTV, String wMessageToPassengerTV, int wPassengerAge) {
        this.wPassengerName = wPassengerName;
        this.wPassengerGender = wPassengerGender;
        this.wPassengerStartingPoint = wPassengerStartingPoint;
        this.wPassengerEndPoint = wPassengerEndPoint;
        this.wCallToPassengerTV = wCallToPassengerTV;
        this.wMessageToPassengerTV = wMessageToPassengerTV;
        this.wPassengerAge = wPassengerAge;
//        this.wPassengerOtpET = wPassengerOtpET;
    }

    public String getwPassengerName() {
        return wPassengerName;
    }

    public void setwPassengerName(String wPassengerName) {
        this.wPassengerName = wPassengerName;
    }

    public String getwPassengerGender() {
        return wPassengerGender;
    }

    public void setwPassengerGender(String wPassengerGender) {
        this.wPassengerGender = wPassengerGender;
    }

    public String getwPassengerStartingPoint() {
        return wPassengerStartingPoint;
    }

    public void setwPassengerStartingPoint(String wPassengerStartingPoint) {
        this.wPassengerStartingPoint = wPassengerStartingPoint;
    }

    public String getwPassengerEndPoint() {
        return wPassengerEndPoint;
    }

    public void setwPassengerEndPoint(String wPassengerEndPoint) {
        this.wPassengerEndPoint = wPassengerEndPoint;
    }

    public String getwCallToPassengerTV() {
        return wCallToPassengerTV;
    }

    public void setwCallToPassengerTV(String wCallToPassengerTV) {
        this.wCallToPassengerTV = wCallToPassengerTV;
    }

    public String getwMessageToPassengerTV() {
        return wMessageToPassengerTV;
    }

    public void setwMessageToPassengerTV(String wMessageToPassengerTV) {
        this.wMessageToPassengerTV = wMessageToPassengerTV;
    }

    public int getwPassengerOtpET() {
        return wPassengerOtpET;
    }

    public void setwPassengerOtpET(int wPassengerOtpET) {
        this.wPassengerOtpET = wPassengerOtpET;
    }

    public int getwPassengerAge() {
        return wPassengerAge;
    }

    public void setwPassengerAge(int wPassengerAge) {
        this.wPassengerAge = wPassengerAge;
    }
}
