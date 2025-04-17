public class Piano extends Instrument {
    @Override
    void play() {
        System.out.println("Playing piano");
    }
    public static void main(String[] args) {
        Instrument i1 = new Guitar();
        Instrument i2 = new Piano();
        i1.play(); // Output: Strumming guitar
        i2.play(); // Output: Playing piano
    }
}
