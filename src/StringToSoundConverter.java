import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;

public class StringToSoundConverter {
    private final MorseEncoder encoder;
    private final SoundGenerator generator;

    public StringToSoundConverter(MorseEncoder encoder, SoundGenerator generator){
        this.encoder = encoder;
        this.generator = generator;
    }

    public void StringToSound(String str){
        generator.playMorse(encoder.toMorse(str));
    }

}
