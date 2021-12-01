package com.javalearning.sound;

import javax.sound.midi.*;

public class MiniMusicApp {
    public static void main(String[] args) {
        MiniMusicApp mini = new MiniMusicApp();
        mini.play();
    }

    private void play() {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            ShortMessage firstMessage = new ShortMessage();
            firstMessage.setMessage(144, 1, 100, 100);
            MidiEvent noteOn = new MidiEvent(firstMessage, 1);
            track.add(noteOn);

            ShortMessage secondMessage = new ShortMessage();
            secondMessage.setMessage(128, 1, 100, 100);
            MidiEvent noteOff = new MidiEvent(secondMessage, 16);
            track.add(noteOff);

            player.setSequence(seq);

            player.start();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
