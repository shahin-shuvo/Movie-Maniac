
package speech;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


public class saytext {

    public saytext() {
        
    }
    
    private static final String VOICENAME="kevin16";
    public static void speak(String say)
    {
        
       
        Voice voice;
        VoiceManager vm=VoiceManager.getInstance();
        voice=vm.getVoice(VOICENAME);
        voice.allocate();
        try {
            voice.speak(say);
        } catch (Exception e) {
        }
    }
    public static void main(String args[]) {
    }
    
}