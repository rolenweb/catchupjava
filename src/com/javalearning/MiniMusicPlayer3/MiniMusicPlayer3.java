package com.javalearning.MiniMusicPlayer3;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3 {
    static JFrame frame = new JFrame("My first music video");
    static MyDrawPanel myDrawPanel;

    public static void main(String[] args) {
        MiniMusicPlayer3 miniMusicPlayer3 = new MiniMusicPlayer3();
        miniMusicPlayer3.go();
    }

    private void setUpGui() {
        myDrawPanel = new MyDrawPanel();
        frame.setContentPane(myDrawPanel);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    private void go() {
        setUpGui();
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(myDrawPanel, new int[] {127});
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            int r = 0;
            for (int i = 0; i < 60; i+=4) {
                r = (int) ((Math.random() * 50) + 1);
                track.add(makeEvent(144, 1, r, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, r, 100, i + 2));
            }

            sequencer.setSequence(sequence);
            sequencer.start();
            sequencer.setTempoInBPM(120);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public MidiEvent makeEvent(int cmd, int chan, int one, int two, int tick){
        MidiEvent event = null;
        try {
            ShortMessage shortMessage = new ShortMessage();
            shortMessage.setMessage(cmd, chan, one, two);
            event = new MidiEvent(shortMessage, tick);
        }catch (Exception ex){}

        return event;
    }

    class MyDrawPanel extends JPanel implements ControllerEventListener {
        boolean msg = false;

        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics graphics){
            if (msg) {
                int r = (int) (Math.random() * 250);
                int gr = (int) (Math.random() * 250);
                int b = (int) (Math.random() * 250);

                graphics.setColor(new Color(r, gr, b));
                int ht = (int) ((Math.random() * 120) + 10);
                int width = (int) ((Math.random() * 120) + 10);

                int x = (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);

                graphics.fillRect(x, y, ht, width);
                msg = false;
            }
        }
    }
}
