package asd;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static java.lang.System.nanoTime;

import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.ENTER;
import static javafx.scene.input.KeyCode.UP;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.GRAY;
import static javafx.scene.paint.Color.PURPLE;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.WHITE;

public final class Amaze extends javafx.application.Application
{
    static Walls[][] w = new Walls[17][12];
    static Integer[] i = { 16, 0 };

    static int mark = 0;
    static boolean ui = true;
    static boolean menu = true;
    static boolean markers = false;

    static boolean top = true;
    static boolean topMid = true;
    static boolean lowMid = true;
    static boolean low = true;

    static Canvas c = new Canvas(1440, 720);
    static GraphicsContext gc = Amaze.c.getGraphicsContext2D();

    public static volatile long time = 0;
    public static volatile boolean moved = false;

    public static void main(String[] a) { javafx.application.Application.launch(); }

    @Override
    public void start(Stage s)
    {
        Amaze.w[0][0] = new Walls(4, 0, 0, 0);
        Amaze.w[1][0] = new Walls(1, 0, 1, 1);
        Amaze.w[2][0] = new Walls(1, 0, 1, 0);
        Amaze.w[3][0] = new Walls(1, 0, 1, 0);
        Amaze.w[4][0] = new Walls(1, 0, 0, 0);
        Amaze.w[5][0] = new Walls(1, 0, 1, 0);
        Amaze.w[6][0] = new Walls(1, 0, 1, 0);
        Amaze.w[7][0] = new Walls(1, 0, 1, 0);
        Amaze.w[8][0] = new Walls(1, 0, 1, 0);
        Amaze.w[9][0] = new Walls(1, 1, 0, 0);
        Amaze.w[10][0] = new Walls(1, 0, 1, 1);
        Amaze.w[11][0] = new Walls(1, 0, 1, 0);
        Amaze.w[12][0] = new Walls(1, 0, 0, 0);
        Amaze.w[13][0] = new Walls(1, 0, 1, 0);
        Amaze.w[14][0] = new Walls(1, 1, 1, 0);
        Amaze.w[15][0] = new Walls(1, 0, 0, 1);
        Amaze.w[16][0] = new Walls(1, 1, 1, 0);

        Amaze.w[0][1] = new Walls(1, 0, 1, 1);
        Amaze.w[1][1] = new Walls(1, 1, 1, 0);
        Amaze.w[2][1] = new Walls(1, 2, 0, 1);
        Amaze.w[3][1] = new Walls(1, 2, 0, 2);
        Amaze.w[4][1] = new Walls(0, 2, 1, 2);
        Amaze.w[5][1] = new Walls(1, 0, 0, 2);
        Amaze.w[6][1] = new Walls(1, 1, 0, 0);
        Amaze.w[7][1] = new Walls(1, 0, 1, 1);
        Amaze.w[8][1] = new Walls(1, 2, 0, 0);
        Amaze.w[9][1] = new Walls(0, 2, 0, 2);
        Amaze.w[10][1] = new Walls(1, 0, 1, 2);
        Amaze.w[11][1] = new Walls(1, 2, 0, 0);
        Amaze.w[12][1] = new Walls(0, 0, 0, 2);
        Amaze.w[13][1] = new Walls(1, 0, 1, 0);
        Amaze.w[14][1] = new Walls(1, 0, 1, 0);
        Amaze.w[15][1] = new Walls(0, 1, 0, 0);
        Amaze.w[16][1] = new Walls(4, 0, 0, 0);

        Amaze.w[0][2] = new Walls(4, 0, 0, 0);
        Amaze.w[1][2] = new Walls(1, 0, 0, 1);
        Amaze.w[2][2] = new Walls(0, 1, 0, 0);
        Amaze.w[3][2] = new Walls(0, 0, 1, 1);
        Amaze.w[4][2] = new Walls(1, 1, 0, 0);
        Amaze.w[5][2] = new Walls(0, 1, 0, 1);
        Amaze.w[6][2] = new Walls(0, 0, 1, 1);
        Amaze.w[7][2] = new Walls(1, 0, 1, 0);
        Amaze.w[8][2] = new Walls(0, 1, 1, 0);
        Amaze.w[9][2] = new Walls(0, 0, 1, 1);
        Amaze.w[10][2] = new Walls(1, 0, 1, 0);
        Amaze.w[11][2] = new Walls(0, 1, 1, 0);
        Amaze.w[12][2] = new Walls(0, 0, 1, 1);
        Amaze.w[13][2] = new Walls(1, 0, 1, 0);
        Amaze.w[14][2] = new Walls(1, 0, 1, 0);
        Amaze.w[15][2] = new Walls(0, 0, 1, 0);
        Amaze.w[16][2] = new Walls(1, 1, 0, 0);

        Amaze.w[0][3] = new Walls(4, 0, 0, 0);
        Amaze.w[1][3] = new Walls(0, 1, 1, 1);
        Amaze.w[2][3] = new Walls(0, 1, 0, 1);
        Amaze.w[3][3] = new Walls(1, 1, 0, 1);
        Amaze.w[4][3] = new Walls(0, 1, 0, 1);
        Amaze.w[5][3] = new Walls(0, 0, 1, 1);
        Amaze.w[6][3] = new Walls(1, 0, 1, 0);
        Amaze.w[7][3] = new Walls(1, 0, 0, 0);
        Amaze.w[8][3] = new Walls(1, 1, 1, 0);
        Amaze.w[9][3] = new Walls(1, 0, 0, 1);
        Amaze.w[10][3] = new Walls(1, 0, 1, 0);
        Amaze.w[11][3] = new Walls(1, 0, 1, 0);
        Amaze.w[12][3] = new Walls(1, 0, 0, 0);
        Amaze.w[13][3] = new Walls(1, 0, 1, 0);
        Amaze.w[14][3] = new Walls(1, 0, 1, 0);
        Amaze.w[15][3] = new Walls(1, 0, 1, 0);
        Amaze.w[16][3] = new Walls(0, 1, 1, 0);

        Amaze.w[0][4] = new Walls(1, 0, 1, 1);
        Amaze.w[1][4] = new Walls(1, 1, 1, 0);
        Amaze.w[2][4] = new Walls(0, 1, 0, 1);
        Amaze.w[3][4] = new Walls(0, 2, 0, 1);
        Amaze.w[4][4] = new Walls(0, 0, 1, 2);
        Amaze.w[5][4] = new Walls(1, 1, 1, 0);
        Amaze.w[6][4] = new Walls(1, 2, 0, 1);
        Amaze.w[7][4] = new Walls(0, 0, 1, 2);
        Amaze.w[8][4] = new Walls(1, 2, 1, 0);
        Amaze.w[9][4] = new Walls(0, 0, 1, 2);
        Amaze.w[10][4] = new Walls(1, 1, 1, 0);
        Amaze.w[11][4] = new Walls(1, 0, 0, 1);
        Amaze.w[12][4] = new Walls(0, 2, 1, 0);
        Amaze.w[13][4] = new Walls(1, 2, 1, 2);
        Amaze.w[14][4] = new Walls(1, 0, 0, 2);
        Amaze.w[15][4] = new Walls(1, 1, 0, 0);
        Amaze.w[16][4] = new Walls(4, 0, 0, 0);

        Amaze.w[0][5] = new Walls(4, 0, 0, 0);
        Amaze.w[1][5] = new Walls(1, 0, 0, 1);
        Amaze.w[2][5] = new Walls(0, 1, 0, 0);
        Amaze.w[3][5] = new Walls(0, 1, 0, 1);
        Amaze.w[4][5] = new Walls(1, 0, 0, 1);
        Amaze.w[5][5] = new Walls(1, 1, 0, 0);
        Amaze.w[6][5] = new Walls(0, 0, 1, 1);
        Amaze.w[7][5] = new Walls(1, 0, 1, 0);
        Amaze.w[8][5] = new Walls(1, 1, 1, 0);
        Amaze.w[9][5] = new Walls(1, 0, 1, 1);
        Amaze.w[10][5] = new Walls(1, 0, 1, 0);
        Amaze.w[11][5] = new Walls(0, 0, 1, 0);
        Amaze.w[12][5] = new Walls(1, 0, 1, 0);
        Amaze.w[13][5] = new Walls(1, 1, 0, 0);
        Amaze.w[14][5] = new Walls(0, 1, 0, 1);
        Amaze.w[15][5] = new Walls(0, 1, 0, 1);
        Amaze.w[16][5] = new Walls(4, 0, 0, 0);

        Amaze.w[0][6] = new Walls(4, 0, 0, 0);
        Amaze.w[1][6] = new Walls(0, 1, 1, 1);
        Amaze.w[2][6] = new Walls(0, 1, 0, 1);
        Amaze.w[3][6] = new Walls(0, 0, 1, 1);
        Amaze.w[4][6] = new Walls(0, 1, 1, 0);
        Amaze.w[5][6] = new Walls(0, 0, 0, 1);
        Amaze.w[6][6] = new Walls(1, 0, 1, 0);
        Amaze.w[7][6] = new Walls(1, 0, 0, 0);
        Amaze.w[8][6] = new Walls(1, 1, 1, 0);
        Amaze.w[9][6] = new Walls(1, 0, 0, 1);
        Amaze.w[10][6] = new Walls(1, 0, 1, 0);
        Amaze.w[11][6] = new Walls(1, 0, 1, 0);
        Amaze.w[12][6] = new Walls(1, 0, 1, 0);
        Amaze.w[13][6] = new Walls(0, 1, 1, 0);
        Amaze.w[14][6] = new Walls(0, 1, 0, 1);
        Amaze.w[15][6] = new Walls(0, 1, 0, 1);
        Amaze.w[16][6] = new Walls(4, 0, 0, 0);

        Amaze.w[0][7] = new Walls(1, 0, 1, 1);
        Amaze.w[1][7] = new Walls(1, 1, 1, 0);
        Amaze.w[2][7] = new Walls(0, 1, 0, 1);
        Amaze.w[3][7] = new Walls(1, 2, 1, 1);
        Amaze.w[4][7] = new Walls(1, 0, 0, 2);
        Amaze.w[5][7] = new Walls(0, 1, 1, 0);
        Amaze.w[6][7] = new Walls(1, 2, 0, 1);
        Amaze.w[7][7] = new Walls(0, 0, 1, 2);
        Amaze.w[8][7] = new Walls(1, 1, 1, 0);
        Amaze.w[9][7] = new Walls(0, 2, 0, 1);
        Amaze.w[10][7] = new Walls(1, 0, 1, 2);
        Amaze.w[11][7] = new Walls(1, 1, 1, 0);
        Amaze.w[12][7] = new Walls(1, 2, 1, 1);
        Amaze.w[13][7] = new Walls(1, 0, 0, 2);
        Amaze.w[14][7] = new Walls(0, 1, 1, 0);
        Amaze.w[15][7] = new Walls(0, 1, 0, 1);
        Amaze.w[16][7] = new Walls(4, 0, 0, 0);

        Amaze.w[0][8] = new Walls(4, 0, 0, 0);
        Amaze.w[1][8] = new Walls(1, 0, 0, 1);
        Amaze.w[2][8] = new Walls(0, 0, 0, 0);
        Amaze.w[3][8] = new Walls(1, 0, 1, 0);
        Amaze.w[4][8] = new Walls(0, 1, 1, 0);
        Amaze.w[5][8] = new Walls(1, 0, 1, 1);
        Amaze.w[6][8] = new Walls(0, 1, 0, 0);
        Amaze.w[7][8] = new Walls(1, 0, 0, 1);
        Amaze.w[8][8] = new Walls(1, 1, 0, 0);
        Amaze.w[9][8] = new Walls(0, 1, 0, 1);
        Amaze.w[10][8] = new Walls(1, 0, 0, 1);
        Amaze.w[11][8] = new Walls(1, 1, 0, 0);
        Amaze.w[12][8] = new Walls(1, 0, 0, 1);
        Amaze.w[13][8] = new Walls(0, 0, 1, 0);
        Amaze.w[14][8] = new Walls(1, 1, 1, 0);
        Amaze.w[15][8] = new Walls(0, 0, 1, 1);
        Amaze.w[16][8] = new Walls(1, 1, 0, 0);

        Amaze.w[0][9] = new Walls(4, 0, 0, 0);
        Amaze.w[1][9] = new Walls(0, 1, 1, 1);
        Amaze.w[2][9] = new Walls(0, 0, 1, 1);
        Amaze.w[3][9] = new Walls(1, 0, 0, 0);
        Amaze.w[4][9] = new Walls(1, 1, 1, 0);
        Amaze.w[5][9] = new Walls(1, 0, 0, 1);
        Amaze.w[6][9] = new Walls(0, 1, 1, 0);
        Amaze.w[7][9] = new Walls(0, 1, 0, 1);
        Amaze.w[8][9] = new Walls(0, 0, 1, 1);
        Amaze.w[9][9] = new Walls(0, 0, 1, 0);
        Amaze.w[10][9] = new Walls(0, 1, 0, 0);
        Amaze.w[11][9] = new Walls(0, 1, 0, 1);
        Amaze.w[12][9] = new Walls(0, 0, 1, 1);
        Amaze.w[13][9] = new Walls(1, 1, 0, 0);
        Amaze.w[14][9] = new Walls(1, 1, 0, 1);
        Amaze.w[15][9] = new Walls(1, 0, 0, 1);
        Amaze.w[16][9] = new Walls(0, 1, 1, 0);

        Amaze.w[0][10] = new Walls(1, 0, 1, 1);
        Amaze.w[1][10] = new Walls(1, 1, 1, 0);
        Amaze.w[2][10] = new Walls(1, 2, 0, 1);
        Amaze.w[3][10] = new Walls(0, 2, 1, 2);
        Amaze.w[4][10] = new Walls(1, 2, 1, 2);
        Amaze.w[5][10] = new Walls(0, 0, 1, 2);
        Amaze.w[6][10] = new Walls(1, 2, 0, 0);
        Amaze.w[7][10] = new Walls(0, 0, 1, 2);
        Amaze.w[8][10] = new Walls(1, 1, 1, 0);
        Amaze.w[9][10] = new Walls(1, 2, 0, 1);
        Amaze.w[10][10] = new Walls(0, 0, 1, 2);
        Amaze.w[11][10] = new Walls(0, 1, 1, 0);
        Amaze.w[12][10] = new Walls(1, 2, 1, 1);
        Amaze.w[13][10] = new Walls(0, 2, 1, 2);
        Amaze.w[14][10] = new Walls(0, 0, 0, 2);
        Amaze.w[15][10] = new Walls(0, 1, 0, 0);
        Amaze.w[16][10] = new Walls(4, 0, 0, 0);

        Amaze.w[0][11] = new Walls(4, 0, 0, 0);
        Amaze.w[1][11] = new Walls(4, 0, 0, 0);
        Amaze.w[2][11] = new Walls(0, 0, 1, 1);
        Amaze.w[3][11] = new Walls(1, 0, 1, 0);
        Amaze.w[4][11] = new Walls(1, 0, 1, 0);
        Amaze.w[5][11] = new Walls(1, 0, 1, 0);
        Amaze.w[6][11] = new Walls(0, 0, 1, 0);
        Amaze.w[7][11] = new Walls(1, 0, 1, 0);
        Amaze.w[8][11] = new Walls(1, 1, 1, 0);
        Amaze.w[9][11] = new Walls(0, 0, 1, 1);
        Amaze.w[10][11] = new Walls(1, 0, 1, 0);
        Amaze.w[11][11] = new Walls(1, 0, 1, 0);
        Amaze.w[12][11] = new Walls(1, 0, 1, 0);
        Amaze.w[13][11] = new Walls(1, 0, 1, 0);
        Amaze.w[14][11] = new Walls(0, 1, 1, 0);
        Amaze.w[15][11] = new Walls(0, 0, 1, 1);
        Amaze.w[16][11] = new Walls(1, 1, 1, 0);

        javafx.scene.Scene scene = new Scene(new StackPane(c), 1440, 720);
        scene.setOnKeyPressed(e -> this.keyEvent(e.getCode()));

        Amaze.redraw();

        s.setScene(scene);
        s.setMaximized(true);
        s.show();

        java.lang.Runnable r = new Clock();
        java.land.Thread t = new Thread(r);
        t.start();
    }

    synchronized public void keyEvent(KeyCode kc)
    {
        Integer[] i_ = new Integer[] { -1, -1 };

        if (i[0] == 16 && i[1] == 0)
        {
            i_[0] = 16;
            i_[1] = 0;
        }

        if (Amaze.ui)
        {
            Amaze.moved = false;

            if (Amaze.markers)
            {
                switch (kc)
                {
                    case UP:
                        if (Amaze.mark != 0) { Amaze.mark--; }

                        break;
                    case DOWN:
                        if (Amaze.mark != 3) { Amaze.mark++; }

                        break;
                    case ESCAPE:
                        Amaze.markers = false;
                        break;
                    case ENTER:
                        switch (Amaze.mark)
                        {
                            case 0:
                                Amaze.top = !Amaze.top;

                                if (Amaze.top)
                                {
                                    for (int ii = 0; ii < 17; ii++)
                                    {
                                        if (Amaze.w[ii][1].w == 3)
                                        {
                                            Amaze.w[ii][1].w = 0;
                                            Amaze.w[ii - 1][1].w = 2;
                                        }

                                        if (Amaze.w[ii][1].e == 3)
                                        {
                                            Amaze.w[ii][1].e = 0;
                                            Amaze.w[ii - 1][1].e = 2;
                                        }
                                    }
                                }
                                else
                                {
                                    for (int ii = 16; ii > -1; ii--)
                                    {
                                        if (Amaze.w[ii][1].e == 2)
                                        {
                                            Amaze.w[ii][1].e = 0;
                                            Amaze.w[ii + 1][1].e = 3;
                                        }

                                        if (Amaze.w[ii][1].w == 2)
                                        {
                                            Amaze.w[ii][1].w = 0;
                                            Amaze.w[ii + 1][1].w = 3;
                                        }
                                    }
                                }

                                break;
                            case 1:
                                Amaze.topMid = !Amaze.topMid;

                                if (Amaze.topMid)
                                {
                                    for (int ii = 0; ii < 17; ii++)
                                    {
                                        if (Amaze.w[ii][4].w == 3)
                                        {
                                            Amaze.w[ii][4].w = 0;
                                            Amaze.w[ii - 1][4].w = 2;
                                        }

                                        if (Amaze.w[ii][4].e == 3)
                                        {
                                            Amaze.w[ii][4].e = 0;
                                            Amaze.w[ii - 1][4].e = 2;
                                        }
                                    }
                                }
                                else
                                {
                                    for (int ii = 16; ii > -1; ii--)
                                    {
                                        if (Amaze.w[ii][4].e == 2)
                                        {
                                            Amaze.w[ii][4].e = 0;
                                            Amaze.w[ii + 1][4].e = 3;
                                        }

                                        if (Amaze.w[ii][4].w == 2)
                                        {
                                            Amaze.w[ii][4].w = 0;
                                            Amaze.w[ii + 1][4].w = 3;
                                        }
                                    }
                                }

                                break;
                            case 2:
                                Amaze.lowMid = !Amaze.lowMid;

                                if (Amaze.lowMid)
                                {
                                    for (int ii = 0; ii < 17; ii++)
                                    {
                                        if (Amaze.w[ii][7].w == 3)
                                        {
                                            Amaze.w[ii][7].w = 0;
                                            Amaze.w[ii - 1][7].w = 2;
                                        }

                                        if (Amaze.w[ii][7].e == 3)
                                        {
                                            Amaze.w[ii][7].e = 0;
                                            Amaze.w[ii - 1][7].e = 2;
                                        }
                                    }
                                }
                                else
                                {
                                    for (int ii = 16; ii > -1; ii--)
                                    {
                                        if (Amaze.w[ii][7].e == 2)
                                        {
                                            Amaze.w[ii][7].e = 0;
                                            Amaze.w[ii + 1][7].e = 3;
                                        }

                                        if (Amaze.w[ii][7].w == 2)
                                        {
                                            Amaze.w[ii][7].w = 0;
                                            Amaze.w[ii + 1][7].w = 3;
                                        }
                                    }
                                }

                                break;
                            case 3:
                                Amaze.low = !Amaze.low;

                                if (Amaze.low)
                                {
                                    for (int ii = 0; ii < 17; ii++)
                                    {
                                        if (Amaze.w[ii][10].w == 3)
                                        {
                                            Amaze.w[ii][10].w = 0;
                                            Amaze.w[ii - 1][10].w = 2;
                                        }

                                        if (Amaze.w[ii][10].e == 3)
                                        {
                                            Amaze.w[ii][10].e = 0;
                                            Amaze.w[ii - 1][10].e = 2;
                                        }
                                    }
                                }
                                else
                                {
                                    for (int ii = 16; ii > -1; ii--)
                                    {
                                        if (Amaze.w[ii][10].e == 2)
                                        {
                                            Amaze.w[ii][10].e = 0;
                                            Amaze.w[ii + 1][10].e = 3;
                                        }

                                        if (Amaze.w[ii][10].w == 2)
                                        {
                                            Amaze.w[ii][10].w = 0;
                                            Amaze.w[ii + 1][10].w = 3;
                                        }
                                    }
                                }
                        }
                }
            }
            else
            {
                if (!Amaze.menu && kc.equals(UP)) { Amaze.menu = true; }
                else if (Amaze.menu && kc.equals(DOWN)) { Amaze.menu = false; }
                else if (Amaze.menu && kc.equals(ENTER)) { Amaze.ui = false; }
                else if (!Amaze.menu && kc.equals(ENTER)) { Amaze.markers = true; }
            }
        }
        else
        {
            int i0 = Amaze.i[0];
            int i1 = Amaze.i[1];

            switch (kc)
            {
                case UP:
                    if (Amaze.w[i0][i1].n == 0) { Amaze.i[1]--; }

                    break;
                case RIGHT:
                    if (Amaze.w[i0][i1].e == 0 || Amaze.w[i0][i1].e == 2)
                    {
                        if (Amaze.w[i0][i1].e != 0)
                        {
                            for (int ii = 16; ii > -1; ii--)
                            {
                                if (Amaze.w[ii][i1].e == 2)
                                {
                                    Amaze.w[ii][i1].e = 0;
                                    Amaze.w[ii + 1][i1].e = 3;
                                }

                                if (Amaze.w[ii][i1].w == 2)
                                {
                                    Amaze.w[ii][i1].w = 0;
                                    Amaze.w[ii + 1][i1].w = 3;
                                }
                            }

                            switch (Amaze.i[1])
                            {
                                case 1:
                                    Amaze.top = false;
                                    break;
                                case 4:
                                    Amaze.topMid = false;
                                    break;
                                case 7:
                                    Amaze.lowMid = false;
                                    break;
                                case 10:
                                    Amaze.low = false;
                            }
                        }

                        Amaze.i[0]++;
                    }

                    break;
                case DOWN:
                    if (Amaze.w[i0][i1].s == 0) { Amaze.i[1]++; }

                    break;
                case LEFT:
                    if (Amaze.w[i0][i1].w == 0 || Amaze.w[i0][i1].w == 3)
                    {
                        if (Amaze.w[i0][i1].w != 0)
                        {
                            for (int ii = 0; ii < 17; ii++)
                            {
                                if (Amaze.w[ii][i1].w == 3)
                                {
                                    Amaze.w[ii][i1].w = 0;
                                    Amaze.w[ii - 1][i1].w = 2;
                                }

                                if (Amaze.w[ii][i1].e == 3)
                                {
                                    Amaze.w[ii][i1].e = 0;
                                    Amaze.w[ii - 1][i1].e = 2;
                                }
                            }

                            switch (i1)
                            {
                                case 1:
                                    Amaze.top = true;
                                    break;
                                case 4:
                                    Amaze.topMid = true;
                                    break;
                                case 7:
                                    Amaze.lowMid = true;
                                    break;
                                case 10:
                                    Amaze.low = true;
                            }
                        }

                        Amaze.i[0]--;
                    }

                    break;
                case ESCAPE:
                    Amaze.ui = true;
            }
        }

        if (i_[0] == 16 && i_[1] == 0 && Amaze.i[0] == 16 && Amaze.i[1] == 0) { Amaze.moved = true; }
        else if (i[0] == 16 && i[1] == 11) { Amaze.moved = false; }

        Amaze.redraw();
    }

    synchronized public static void redraw()
    {
        Amaze.gc.setFill(BLACK);
        Amaze.gc.fillRect(0, 0, 1440, 720);
        Amaze.gc.setFill(GRAY);
        Amaze.gc.fillRect(295, 60, 850, 600);
        Amaze.gc.setFill(BLUE);

        for (int x = 0; x < 17; x++)
        {
            for (int y = 0; y < 12; y++)
            {
                Walls wall = Amaze.w[x][y];

                int xx = x * 50 + 295;
                int yy = y * 50 + 60;

                if (wall.n == 1) { Amaze.gc.fillRect(xx, yy, 50, 2); }
                else if (wall.n == 4) { Amaze.gc.fillRect(xx, yy, 50, 50); }

                if (wall.e == 1) { Amaze.gc.fillRect(xx + 48, yy, 2, 50); }
                else if (wall.e == 2 || wall.e == 3)
                {
                    Amaze.gc.setFill(RED);
                    Amaze.gc.fillRect(xx + 48, yy, 2, 50);
                    Amaze.gc.setFill(BLUE);
                }

                if (wall.s == 1) { Amaze.gc.fillRect(xx, yy + 48, 50, 2); }

                if (wall.w == 1) { Amaze.gc.fillRect(xx, yy, 2, 50); }
                else if (wall.w == 2 || wall.w == 3)
                {
                    Amaze.gc.setFill(RED);
                    Amaze.gc.fillRect(xx, yy, 2, 50);
                    Amaze.gc.setFill(BLUE);
                }
            }
        }

        Amaze.gc.setFill(RED);
        Amaze.gc.fillOval(Amaze.top ? 307 : 357, 122, 25, 25);
        Amaze.gc.fillOval(Amaze.topMid ? 307 : 357, 272, 25, 25);
        Amaze.gc.fillOval(Amaze.lowMid ? 307 : 357, 422, 25, 25);
        Amaze.gc.fillOval(Amaze.low ? 307 : 357, 572, 25, 25);

        if (Amaze.ui)
        {
            if (Amaze.markers)
            {
                switch (Amaze.mark)
                {
                    case 0:
                        Amaze.gc.fillPolygon(new double[] { 245, 283, 245 }, new double[] { 122, 135, 148 }, 3);
                        break;
                    case 1:
                        Amaze.gc.fillPolygon(new double[] { 245, 283, 245 }, new double[] { 272, 285, 298 }, 3);
                        break;
                    case 2:
                        Amaze.gc.fillPolygon(new double[] { 245, 283, 245 }, new double[] { 422, 435, 448 }, 3);
                        break;
                    case 3:
                        Amaze.gc.fillPolygon(new double[] { 245, 283, 245 }, new double[] { 572, 585, 598 }, 3);
                }

                Amaze.i[0] = 16;
                Amaze.i[1] = 0;
            }
            else
            {
                if (Amaze.menu)
                {
                    Amaze.gc.fillPolygon(new double[] { 1316, 1354, 1354 }, new double[] { 248, 235, 261 }, 3);
                }
                else { Amaze.gc.fillPolygon(new double[] { 1316, 1354, 1354 }, new double[] { 448, 435, 461 }, 3); }
            }
        }

        Amaze.gc.setFill(PURPLE);
        Amaze.gc.fillOval(i[0] * 50 + 307, i[1] * 50 + 72, 25, 25);

        Amaze.gc.setFill(WHITE);
        Amaze.gc.setFont(new Font("Impact", 32));
        Amaze.gc.fillText("Start", 1057, 50);
        Amaze.gc.fillText("Finish", 1057, 690);
        Amaze.gc.fillText("Resume", 1195, 260);
        Amaze.gc.fillText("Setup", 1195, 460);
        Amaze.gc.fillText(String.valueOf(time), 100, 100);
    }
}

final class Walls
{
    public int n, e, s, w;

    public Walls(int n, int e, int s, int w)
    {
        this.n = n;
        this.e = e;
        this.s = s;
        this.w = w;
    }
}

final class Clock implements Runnable
{
    @Override
    public void run()
    {
        while (true)
        {
            if (Amaze.moved)
            {
                long l = java.lang.System.nanoTime();

                java.lang.System.out.println("B");

                while (Amaze.moved) { Amaze.time = nanoTime() - l; }
            }
        }
    }
}
