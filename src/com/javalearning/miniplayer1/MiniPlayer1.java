package com.javalearning.miniplayer1;

import javax.sound.midi.*;

public class MiniPlayer1 {
    public static void main(String[] args) {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            for (int i = 5; i < 61; i+=4) {
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(128, 1, i, 100, i + 2));
            }

            sequencer.setSequence(sequence);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static MidiEvent makeEvent(int cmd, int chan, int one, int two, int tick){
        MidiEvent event = null;
        try {
            ShortMessage shortMessage = new ShortMessage();
            shortMessage.setMessage(cmd, chan, one, two);
            event = new MidiEvent(shortMessage, tick);
        }catch (Exception e){

        }
        return event;
    }
}
