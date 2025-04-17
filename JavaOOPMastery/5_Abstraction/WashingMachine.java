public class WashingMachine extends Appliance {
    @Override
    void turnOn() {
        System.out.println("Washing machine is now ON.");
    }
    public static void main(String[] args) {
        WashingMachine wm = new WashingMachine();
        wm.turnOn(); // Output: Washing machine is now ON.
    }
}
