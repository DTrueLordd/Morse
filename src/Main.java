import javax.sound.midi.InvalidMidiDataException;
import javax.sound.sampled.LineUnavailableException;

public class Main {
    public static void main(String[] args) throws LineUnavailableException {
        StringToSoundConverter converter = new StringToSoundConverter(new MorseEncoder(), new SoundGenerator());
        converter.StringToSound("sos");



    }
}