import javax.sound.sampled.*;

public class SoundGenerator {
    private static final float sampleRate = 44100f;
    private static final float dot_duration = 100;
    private static final float dash_duration = dot_duration*3;
    private static double frequency = 800;
    private int numSamples;
    private byte[] buffer;

    private AudioFormat format;
    private SourceDataLine line;

    public SoundGenerator() throws LineUnavailableException {
        this.format = new AudioFormat(sampleRate, 16,1,true, false);
        this.line = AudioSystem.getSourceDataLine(format);
    }


   private void playSound(float duration){
        numSamples = (int) (sampleRate * duration/1000);
        buffer = new byte[numSamples*2];
        for (int i = 0; i < numSamples; i++) {  double time = i / sampleRate;
            double angle = 2.0 * Math.PI * frequency * time;
            short sample = (short) (Math.sin(angle) * Short.MAX_VALUE);
            buffer[2 * i] = (byte) (sample & 0xFF);
            buffer[2 * i + 1] = (byte) ((sample >> 8) & 0xFF);
        }


        try {
            line.open(format);
            line.start();

            line.write(buffer, 0, buffer.length); // отправляем звук в колонку
            line.drain(); // ждём завершения воспроизведения
            line.close();

        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }

    }

    private void pause(float duration){
        try {
            Thread.sleep((long)duration);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private void playDot(){
        playSound(dot_duration);
        pause(dot_duration);
    }

    private void playDash(){
        playSound(dash_duration);
        pause(dot_duration);
    }


    public void playMorse(String str){
        char c;
        for(int i = 0; i<str.length(); i++){
            c = str.charAt(i);
            switch (c){
                case '.':
                    playDot();
                    break;
                case '-':
                    playDash();
                    break;
                case '/':
                    pause(dot_duration*7);
                    break;
            }

        }
    }

}
