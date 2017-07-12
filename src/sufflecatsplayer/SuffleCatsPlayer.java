package sufflecatsplayer;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SuffleCatsPlayer {

    public static void main(String[] args) throws AWTException {

        int x = 530;
        int w = 310;
        int h = 4;

        int y1 = 380;
        int y2 = 325;
        int y3 = 275;

        int centerx = 685;
        int centery = 650;
//        int x = 685;
//        int y1 = 650;
//        int w = 40;
//        int h = 40;

        Robot r = new Robot();

        new Thread() {
            public void run() {
                while (true) {

                    for (int y : new int[]{y1, y2, y3}) {

                        BufferedImage image = r.createScreenCapture(new Rectangle(x, y, w, h));

                        //if(y==y1){jLabel1.setText(Integer.toString(image.getRGB(0, 0)));}
                        boolean card = false;
                        int tempx = 0;
                        int tempy = 0;
                        outerloop:
                        for (int j = 0; j < h; j++) {
                            for (int i = 0; i < w; i++) {

                                if (image.getRGB(i, j) == -133660 || image.getRGB(i, j) == -134493) {
                                    tempx = x + i;
                                    tempy = y + j;
                                    card = true;
                                    break outerloop;
                                }
                            }
                        }
                        int playing = r.getPixelColor(centerx, centery).getRGB();
                        if (playing == -1314049 || playing == -3422) {
                            card = false;
                        }

                        execute:
                        if (card) {
                            if (y == y2) {
                                int windoww = 200;
                                int windowh = h;
                                int windowx = ((y1 - centery) * (tempx - centerx) / (tempy - centery)) + centerx - (windoww / 2);
                                int windowy = y1 - (windowh / 2);

                                BufferedImage window = r.createScreenCapture(new Rectangle(windowx, windowy, windoww, windowh));
                                //jLabel2.setIcon(new ImageIcon(window));
                                for (int n = 0; n < windowh; n++) {
                                    for (int m = 0; m < windoww; m++) {
                                        if (-14520000 < window.getRGB(m, n) && window.getRGB(m, n) < -14500000) {
                                            break execute;
                                        }
                                    }
                                }
                            } else if (y == y3) {
                                int windoww1 = 200;
                                int windowh1 = h;
                                int windowx1 = ((y1 - centery) * (tempx - centerx) / (tempy - centery)) + centerx - (windoww1 / 2);
                                int windowy1 = y1 - (windowh1 / 2);

                                BufferedImage window1 = r.createScreenCapture(new Rectangle(windowx1, windowy1, windoww1, windowh1));
                                //jLabel2.setIcon(new ImageIcon(window1));
                                for (int n = 0; n < windowh1; n++) {
                                    for (int m = 0; m < windoww1; m++) {
                                        if (-14520000 < window1.getRGB(m, n) && window1.getRGB(m, n) < -14500000) {
                                            break execute;
                                        }
                                    }
                                }

                                int windoww2 = 200;
                                int windowh2 = h;
                                int windowx2 = ((y2 - centery) * (tempx - centerx) / (tempy - centery)) + centerx - (windoww2 / 2);
                                int windowy2 = y2 - (windowh2 / 2);

                                BufferedImage window2 = r.createScreenCapture(new Rectangle(windowx2, windowy2, windoww2, windowh2));
                                //jLabel2.setIcon(new ImageIcon(window2));
                                for (int n = 0; n < windowh2; n++) {
                                    for (int m = 0; m < windoww2; m++) {
                                        if (-14520000 < window2.getRGB(m, n) && window2.getRGB(m, n) < -14500000) {
                                            break execute;
                                        }
                                    }
                                }
                            }

                            //jLabel2.setText(Integer.toString(firstx)+" - "+Integer.toString(firsty));
                            r.mouseMove(centerx, centery);
                            r.mousePress(InputEvent.BUTTON1_MASK);
                            r.mouseMove(tempx, tempy);
                            r.mouseRelease(InputEvent.BUTTON1_MASK);
                            try {
                                Thread.sleep(350);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

//                            BufferedImage point = r.createScreenCapture(new Rectangle(685, 650, 1, 1));
//                            if (point.getRGB(0, 0) == -1314049) {
//                                card = card;
//                            }
                        //jLabel1.setText(Integer.toString(r.getPixelColor(685, 650).getRGB()));
                    }
                }
            }

        }.start();

        JOptionPane.showConfirmDialog(null, "Close this after the game.", "Close!", JOptionPane.CLOSED_OPTION);
        System.exit(0);

    }

}
