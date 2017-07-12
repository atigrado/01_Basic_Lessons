package DrumKit;

/**
 * Created by Artem Konyukhov on 28.06.2016.
 */
public class DrumKit {

    boolean topHat = true;
    boolean snare = true;

    void playsnare() {
        System.out.println("бах бах ба-бах");
    }

    void playTopHat() {
        System.out.println("динь динь ди-динь");
    }
}

class DrumKitTestDrive {
    public static void main(String[] args) {
        DrumKit d = new DrumKit();
        d.playsnare();
        d.snare = false;
        d.playTopHat();

        if (d.snare == true) {
            d.playsnare();
        }
    }
}