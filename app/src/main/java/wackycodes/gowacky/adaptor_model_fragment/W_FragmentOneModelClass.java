package wackycodes.gowacky.adaptor_model_fragment;

public class W_FragmentOneModelClass {

    // variable declaration...
    public int wAvailableSeats,wVehicleReachTime;
    private int wVehicleType,wVehicleImage;

    public W_FragmentOneModelClass( int wVehicleType, int wVehicleImage, int wAvailableSeats, int wVehicleReachTime) {
        this.wAvailableSeats = wAvailableSeats;
        this.wVehicleReachTime = wVehicleReachTime;
        this.wVehicleType = wVehicleType;
        this.wVehicleImage = wVehicleImage;
    }

    public int getwAvailableSeats() {
        return wAvailableSeats;
    }

    public void setwAvailableSeats(int wAvailableSeats) {
        this.wAvailableSeats = wAvailableSeats;
    }

    public int getwVehicleReachTime() {
        return wVehicleReachTime;
    }

    public void setwVehicleReachTime(int wVehicleReachTime) {
        this.wVehicleReachTime = wVehicleReachTime;
    }

    public int getwVehicleType() {
        return wVehicleType;
    }

    public void setwVehicleType(int wVehicleType) {
        this.wVehicleType = wVehicleType;
    }

    public int getwVehicleImage() {
        return wVehicleImage;
    }

    public void setwVehicleImage(int wVehicleImage) {
        this.wVehicleImage = wVehicleImage;
    }
}
