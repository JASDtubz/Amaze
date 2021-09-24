package asd;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Amaze extends Application
{
    static Walls[][] w = new Walls[17][12];
    static Integer[] i = { 16, 0 };

    static int mark = 0;
    boolean ui = true;
    boolean menu = true;
    boolean markers = false;

    boolean top = true;
    boolean topMid = true;
    boolean lowMid = true;
    boolean low = true;

    Canvas c = new Canvas(1440, 720);
    GraphicsContext gc = c.getGraphicsContext2D();

    public static void main(String[] a) { launch(); }

    @Override
    public void start(Stage s)
    {
        w[0][0] = new Walls(4, 0, 0, 0);
        w[1][0] = new Walls(1, 0, 1, 1);
        w[2][0] = new Walls(1, 0, 1, 0);
        w[3][0] = new Walls(1, 0, 1, 0);
        w[4][0] = new Walls(1, 0, 0, 0);
        w[5][0] = new Walls(1, 0, 1, 0);
        w[6][0] = new Walls(1, 0, 1, 0);
        w[7][0] = new Walls(1, 0, 1, 0);
        w[8][0] = new Walls(1, 0, 1, 0);
        w[9][0] = new Walls(1, 1, 0, 0);
        w[10][0] = new Walls(1, 0, 1, 1);
        w[11][0] = new Walls(1, 0, 1, 0);
        w[12][0] = new Walls(1, 0, 0, 0);
        w[13][0] = new Walls(1, 0, 1, 0);
        w[14][0] = new Walls(1, 1, 1, 0);
        w[15][0] = new Walls(1, 0, 0, 1);
        w[16][0] = new Walls(1, 1, 1, 0);

        w[0][1] = new Walls(1, 0, 1, 1);
        w[1][1] = new Walls(1, 1, 1, 0);
        w[2][1] = new Walls(1, 2, 0, 1);
        w[3][1] = new Walls(1, 2, 0, 2);
        w[4][1] = new Walls(0, 2, 1, 2);
        w[5][1] = new Walls(1, 0, 0, 2);
        w[6][1] = new Walls(1, 1, 0, 0);
        w[7][1] = new Walls(1, 0, 1, 1);
        w[8][1] = new Walls(1, 2, 0, 0);
        w[9][1] = new Walls(0, 2, 0, 2);
        w[10][1] = new Walls(1, 0, 1, 2);
        w[11][1] = new Walls(1, 2, 0, 0);
        w[12][1] = new Walls(0, 0, 0, 2);
        w[13][1] = new Walls(1, 0, 1, 0);
        w[14][1] = new Walls(1, 0, 1, 0);
        w[15][1] = new Walls(0, 1, 0, 0);
        w[16][1] = new Walls(4, 0, 0, 0);

        w[0][2] = new Walls(4, 0, 0, 0);
        w[1][2] = new Walls(1, 0, 0, 1);
        w[2][2] = new Walls(0, 1, 0, 0);
        w[3][2] = new Walls(0, 0, 1, 1);
        w[4][2] = new Walls(1, 1, 0, 0);
        w[5][2] = new Walls(0, 1, 0, 1);
        w[6][2] = new Walls(0, 0, 1, 1);
        w[7][2] = new Walls(1, 0, 1, 0);
        w[8][2] = new Walls(0, 1, 1, 0);
        w[9][2] = new Walls(0, 0, 1, 1);
        w[10][2] = new Walls(1, 0, 1, 0);
        w[11][2] = new Walls(0, 1, 1, 0);
        w[12][2] = new Walls(0, 0, 1, 1);
        w[13][2] = new Walls(1, 0, 1, 0);
        w[14][2] = new Walls(1, 0, 1, 0);
        w[15][2] = new Walls(0, 0, 1, 0);
        w[16][2] = new Walls(1, 1, 0, 0);

        w[0][3] = new Walls(4, 0, 0, 0);
        w[1][3] = new Walls(0, 1, 1, 1);
        w[2][3] = new Walls(0, 1, 0, 1);
        w[3][3] = new Walls(1, 1, 0, 1);
        w[4][3] = new Walls(0, 1, 0, 1);
        w[5][3] = new Walls(0, 0, 1, 1);
        w[6][3] = new Walls(1, 0, 1, 0);
        w[7][3] = new Walls(1, 0, 0, 0);
        w[8][3] = new Walls(1, 1, 1, 0);
        w[9][3] = new Walls(1, 0, 0, 1);
        w[10][3] = new Walls(1, 0, 1, 0);
        w[11][3] = new Walls(1, 0, 1, 0);
        w[12][3] = new Walls(1, 0, 0, 0);
        w[13][3] = new Walls(1, 0, 1, 0);
        w[14][3] = new Walls(1, 0, 1, 0);
        w[15][3] = new Walls(1, 0, 1, 0);
        w[16][3] = new Walls(0, 1, 1, 0);

        w[0][4] = new Walls(1, 0, 1, 1);
        w[1][4] = new Walls(1, 1, 1, 0);
        w[2][4] = new Walls(0, 1, 0, 1);
        w[3][4] = new Walls(0, 2, 0, 1);
        w[4][4] = new Walls(0, 0, 1, 2);
        w[5][4] = new Walls(1, 1, 1, 0);
        w[6][4] = new Walls(1, 2, 0, 1);
        w[7][4] = new Walls(0, 0, 1, 2);
        w[8][4] = new Walls(1, 2, 1, 0);
        w[9][4] = new Walls(0, 0, 1, 2);
        w[10][4] = new Walls(1, 1, 1, 0);
        w[11][4] = new Walls(1, 0, 0, 1);
        w[12][4] = new Walls(0, 2, 1, 0);
        w[13][4] = new Walls(1, 2, 1, 2);
        w[14][4] = new Walls(1, 0, 0, 2);
        w[15][4] = new Walls(1, 1, 0, 0);
        w[16][4] = new Walls(4, 0, 0, 0);

        w[0][5] = new Walls(4, 0, 0, 0);
        w[1][5] = new Walls(1, 0, 0, 1);
        w[2][5] = new Walls(0, 1, 0, 0);
        w[3][5] = new Walls(0, 1, 0, 1);
        w[4][5] = new Walls(1, 0, 0, 1);
        w[5][5] = new Walls(1, 1, 0, 0);
        w[6][5] = new Walls(0, 0, 1, 1);
        w[7][5] = new Walls(1, 0, 1, 0);
        w[8][5] = new Walls(1, 1, 1, 0);
        w[9][5] = new Walls(1, 0, 1, 1);
        w[10][5] = new Walls(1, 0, 1, 0);
        w[11][5] = new Walls(0, 0, 1, 0);
        w[12][5] = new Walls(1, 0, 1, 0);
        w[13][5] = new Walls(1, 1, 0, 0);
        w[14][5] = new Walls(0, 1, 0, 1);
        w[15][5] = new Walls(0, 1, 0, 1);
        w[16][5] = new Walls(4, 0, 0, 0);

        w[0][6] = new Walls(4, 0, 0, 0);
        w[1][6] = new Walls(0, 1, 1, 1);
        w[2][6] = new Walls(0, 1, 0, 1);
        w[3][6] = new Walls(0, 0, 1, 1);
        w[4][6] = new Walls(0, 1, 1, 0);
        w[5][6] = new Walls(0, 0, 0, 1);
        w[6][6] = new Walls(1, 0, 1, 0);
        w[7][6] = new Walls(1, 0, 0, 0);
        w[8][6] = new Walls(1, 1, 1, 0);
        w[9][6] = new Walls(1, 0, 0, 1);
        w[10][6] = new Walls(1, 0, 1, 0);
        w[11][6] = new Walls(1, 0, 1, 0);
        w[12][6] = new Walls(1, 0, 1, 0);
        w[13][6] = new Walls(0, 1, 1, 0);
        w[14][6] = new Walls(0, 1, 0, 1);
        w[15][6] = new Walls(0, 1, 0, 1);
        w[16][6] = new Walls(4, 0, 0, 0);

        w[0][7] = new Walls(1, 0, 1, 1);
        w[1][7] = new Walls(1, 1, 1, 0);
        w[2][7] = new Walls(0, 1, 0, 1);
        w[3][7] = new Walls(1, 2, 1, 1);
        w[4][7] = new Walls(1, 0, 0, 2);
        w[5][7] = new Walls(0, 1, 1, 0);
        w[6][7] = new Walls(1, 2, 0, 1);
        w[7][7] = new Walls(0, 0, 1, 2);
        w[8][7] = new Walls(1, 1, 1, 0);
        w[9][7] = new Walls(0, 2, 0, 1);
        w[10][7] = new Walls(1, 0, 1, 2);
        w[11][7] = new Walls(1, 1, 1, 0);
        w[12][7] = new Walls(1, 2, 1, 1);
        w[13][7] = new Walls(1, 0, 0, 2);
        w[14][7] = new Walls(0, 1, 1, 0);
        w[15][7] = new Walls(0, 1, 0, 1);
        w[16][7] = new Walls(4, 0, 0, 0);

        w[0][8] = new Walls(4, 0, 0, 0);
        w[1][8] = new Walls(1, 0, 0, 1);
        w[2][8] = new Walls(0, 0, 0, 0);
        w[3][8] = new Walls(1, 0, 1, 0);
        w[4][8] = new Walls(0, 1, 1, 0);
        w[5][8] = new Walls(1, 0, 1, 1);
        w[6][8] = new Walls(0, 1, 0, 0);
        w[7][8] = new Walls(1, 0, 0, 1);
        w[8][8] = new Walls(1, 1, 0, 0);
        w[9][8] = new Walls(0, 1, 0, 1);
        w[10][8] = new Walls(1, 0, 0, 1);
        w[11][8] = new Walls(1, 1, 0, 0);
        w[12][8] = new Walls(1, 0, 0, 1);
        w[13][8] = new Walls(0, 0, 1, 0);
        w[14][8] = new Walls(1, 1, 1, 0);
        w[15][8] = new Walls(0, 0, 1, 1);
        w[16][8] = new Walls(1, 1, 0, 0);

        w[0][9] = new Walls(4, 0, 0, 0);
        w[1][9] = new Walls(0, 1, 1, 1);
        w[2][9] = new Walls(0, 0, 1, 1);
        w[3][9] = new Walls(1, 0, 0, 0);
        w[4][9] = new Walls(1, 1, 1, 0);
        w[5][9] = new Walls(1, 0, 0, 1);
        w[6][9] = new Walls(0, 1, 1, 0);
        w[7][9] = new Walls(0, 1, 0, 1);
        w[8][9] = new Walls(0, 0, 1, 1);
        w[9][9] = new Walls(0, 0, 1, 0);
        w[10][9] = new Walls(0, 1, 0, 0);
        w[11][9] = new Walls(0, 1, 0, 1);
        w[12][9] = new Walls(0, 0, 1, 1);
        w[13][9] = new Walls(1, 1, 0, 0);
        w[14][9] = new Walls(1, 1, 0, 1);
        w[15][9] = new Walls(1, 0, 0, 1);
        w[16][9] = new Walls(0, 1, 1, 0);

        w[0][10] = new Walls(1, 0, 1, 1);
        w[1][10] = new Walls(1, 1, 1, 0);
        w[2][10] = new Walls(1, 2, 0, 1);
        w[3][10] = new Walls(0, 2, 1, 2);
        w[4][10] = new Walls(1, 2, 1, 2);
        w[5][10] = new Walls(0, 0, 1, 2);
        w[6][10] = new Walls(1, 2, 0, 0);
        w[7][10] = new Walls(0, 0, 1, 2);
        w[8][10] = new Walls(1, 1, 1, 0);
        w[9][10] = new Walls(1, 2, 0, 1);
        w[10][10] = new Walls(0, 0, 1, 2);
        w[11][10] = new Walls(0, 1, 1, 0);
        w[12][10] = new Walls(1, 2, 1, 1);
        w[13][10] = new Walls(0, 2, 1, 2);
        w[14][10] = new Walls(0, 0, 0, 2);
        w[15][10] = new Walls(0, 1, 0, 0);
        w[16][10] = new Walls(4, 0, 0, 0);

        w[0][11] = new Walls(4, 0, 0, 0);
        w[1][11] = new Walls(4, 0, 0, 0);
        w[2][11] = new Walls(0, 0, 1, 1);
        w[3][11] = new Walls(1, 0, 1, 0);
        w[4][11] = new Walls(1, 0, 1, 0);
        w[5][11] = new Walls(1, 0, 1, 0);
        w[6][11] = new Walls(0, 0, 1, 0);
        w[7][11] = new Walls(1, 0, 1, 0);
        w[8][11] = new Walls(1, 1, 1, 0);
        w[9][11] = new Walls(0, 0, 1, 1);
        w[10][11] = new Walls(1, 0, 1, 0);
        w[11][11] = new Walls(1, 0, 1, 0);
        w[12][11] = new Walls(1, 0, 1, 0);
        w[13][11] = new Walls(1, 0, 1, 0);
        w[14][11] = new Walls(0, 1, 1, 0);
        w[15][11] = new Walls(0, 0, 1, 1);
        w[16][11] = new Walls(1, 1, 1, 0);

        Scene scene = new Scene(new StackPane(this.c), 1440, 720);
        scene.setOnKeyPressed(e -> this.keyEvent(e.getCode()));

        this.redraw();

        s.setScene(scene);
        s.setMaximized(true);
        s.show();
    }

    public void keyEvent(KeyCode kc)
    {
        if (ui)
        {
            if (markers)
            {
                switch (kc)
                {
                    case UP:
                        if (mark != 0) { mark--; }

                        break;
                    case DOWN:
                        if (mark != 3) { mark++; }

                        break;
                    case ESCAPE:
                        markers = false;
                        break;
                    case ENTER:
                        switch (mark)
                        {
                            case 0:
                                top = !top;

                                if (top)
                                {
                                    for (int ii = 0; ii < 17; ii++)
                                    {
                                        if (w[ii][1].w == 3)
                                        {
                                            w[ii][1].w = 0;
                                            w[ii - 1][1].w = 2;
                                        }

                                        if (w[ii][1].e == 3)
                                        {
                                            w[ii][1].e = 0;
                                            w[ii - 1][1].e = 2;
                                        }
                                    }
                                }
                                else
                                {
                                    for (int ii = 16; ii > -1; ii--)
                                    {
                                        if (w[ii][1].e == 2)
                                        {
                                            w[ii][1].e = 0;
                                            w[ii + 1][1].e = 3;
                                        }

                                        if (w[ii][1].w == 2)
                                        {
                                            w[ii][1].w = 0;
                                            w[ii + 1][1].w = 3;
                                        }
                                    }
                                }

                                break;
                            case 1:
                                topMid = !topMid;

                                if (topMid)
                                {
                                    for (int ii = 0; ii < 17; ii++)
                                    {
                                        if (w[ii][4].w == 3)
                                        {
                                            w[ii][4].w = 0;
                                            w[ii - 1][4].w = 2;
                                        }

                                        if (w[ii][4].e == 3)
                                        {
                                            w[ii][4].e = 0;
                                            w[ii - 1][4].e = 2;
                                        }
                                    }
                                }
                                else
                                {
                                    for (int ii = 16; ii > -1; ii--)
                                    {
                                        if (w[ii][4].e == 2)
                                        {
                                            w[ii][4].e = 0;
                                            w[ii + 1][4].e = 3;
                                        }

                                        if (w[ii][4].w == 2)
                                        {
                                            w[ii][4].w = 0;
                                            w[ii + 1][4].w = 3;
                                        }
                                    }
                                }

                                break;
                            case 2:
                                lowMid = !lowMid;

                                if (lowMid)
                                {
                                    for (int ii = 0; ii < 17; ii++)
                                    {
                                        if (w[ii][7].w == 3)
                                        {
                                            w[ii][7].w = 0;
                                            w[ii - 1][7].w = 2;
                                        }

                                        if (w[ii][7].e == 3)
                                        {
                                            w[ii][7].e = 0;
                                            w[ii - 1][7].e = 2;
                                        }
                                    }
                                }
                                else
                                {
                                    for (int ii = 16; ii > -1; ii--)
                                    {
                                        if (w[ii][7].e == 2)
                                        {
                                            w[ii][7].e = 0;
                                            w[ii + 1][7].e = 3;
                                        }

                                        if (w[ii][7].w == 2)
                                        {
                                            w[ii][7].w = 0;
                                            w[ii + 1][7].w = 3;
                                        }
                                    }
                                }

                                break;
                            case 3:
                                low = !low;

                                if (low)
                                {
                                    for (int ii = 0; ii < 17; ii++)
                                    {
                                        if (w[ii][10].w == 3)
                                        {
                                            w[ii][10].w = 0;
                                            w[ii - 1][10].w = 2;
                                        }

                                        if (w[ii][10].e == 3)
                                        {
                                            w[ii][10].e = 0;
                                            w[ii - 1][10].e = 2;
                                        }
                                    }
                                }
                                else
                                {
                                    for (int ii = 16; ii > -1; ii--)
                                    {
                                        if (w[ii][10].e == 2)
                                        {
                                            w[ii][10].e = 0;
                                            w[ii + 1][10].e = 3;
                                        }

                                        if (w[ii][10].w == 2)
                                        {
                                            w[ii][10].w = 0;
                                            w[ii + 1][10].w = 3;
                                        }
                                    }
                                }
                        }
                }
            }
            else
            {
                if (!menu && kc.equals(KeyCode.UP)) { menu = true; }
                else if (menu && kc.equals(KeyCode.DOWN)) { menu = false; }
                else if (menu && kc.equals(KeyCode.ENTER)) { ui = false; }
                else if (!menu && kc.equals(KeyCode.ENTER)) { markers = true; }
            }
        }
        else
        {
            int i0 = i[0];
            int i1 = i[1];

            switch (kc)
            {
                case UP:
                    if (w[i0][i1].n == 0) { i[1]--; }

                    break;
                case RIGHT:
                    if (w[i0][i1].e == 0 || w[i0][i1].e == 2)
                    {
                        if (w[i0][i1].e != 0)
                        {
                            for (int ii = 16; ii > -1; ii--)
                            {
                                if (w[ii][i1].e == 2)
                                {
                                    w[ii][i1].e = 0;
                                    w[ii + 1][i1].e = 3;
                                }

                                if (w[ii][i1].w == 2)
                                {
                                    w[ii][i1].w = 0;
                                    w[ii + 1][i1].w = 3;
                                }
                            }

                            switch (i[1])
                            {
                                case 1:
                                    top = false;
                                    break;
                                case 4:
                                    topMid = false;
                                    break;
                                case 7:
                                    lowMid = false;
                                    break;
                                case 10:
                                    low = false;
                            }
                        }

                        i[0]++;
                    }

                    break;
                case DOWN:
                    if (w[i0][i1].s == 0) { i[1]++; }

                    break;
                case LEFT:
                    if (w[i0][i1].w == 0 || w[i0][i1].w == 3)
                    {
                        if (w[i0][i1].w != 0)
                        {
                            for (int ii = 0; ii < 17; ii++)
                            {
                                if (w[ii][i1].w == 3)
                                {
                                    w[ii][i1].w = 0;
                                    w[ii - 1][i1].w = 2;
                                }

                                if (w[ii][i1].e == 3)
                                {
                                    w[ii][i1].e = 0;
                                    w[ii - 1][i1].e = 2;
                                }
                            }

                            switch (i1)
                            {
                                case 1:
                                    top = true;
                                    break;
                                case 4:
                                    topMid = true;
                                    break;
                                case 7:
                                    lowMid = true;
                                    break;
                                case 10:
                                    low = true;
                            }
                        }

                        i[0]--;
                    }

                    break;
                case ESCAPE:
                    ui = true;
            }
        }

        this.redraw();
    }

    public void redraw()
    {
        this.gc.setFill(Color.BLACK);
        this.gc.fillRect(0, 0, 1440, 720);
        this.gc.setFill(Color.GRAY);
        this.gc.fillRect(295, 60, 850, 600);
        this.gc.setFill(Color.BLUE);

        for (int x = 0; x < 17; x++)
        {
            for (int y = 0; y < 12; y++)
            {
                Walls wall = w[x][y];

                int xx = x * 50 + 295;
                int yy = y * 50 + 60;

                if (wall.n == 1) { this.gc.fillRect(xx, yy, 50, 2); }
                else if (wall.n == 4) { this.gc.fillRect(xx, yy, 50, 50); }

                if (wall.e == 1) { this.gc.fillRect(xx + 48, yy, 2, 50); }
                else if (wall.e == 2 || wall.e == 3)
                {
                    this.gc.setFill(Color.RED);
                    this.gc.fillRect(xx + 48, yy, 2, 50);
                    this.gc.setFill(Color.BLUE);
                }

                if (wall.s == 1) { this.gc.fillRect(xx, yy + 48, 50, 2); }

                if (wall.w == 1) { this.gc.fillRect(xx, yy, 2, 50); }
                else if (wall.w == 2 || wall.w == 3)
                {
                    this.gc.setFill(Color.RED);
                    this.gc.fillRect(xx, yy, 2, 50);
                    this.gc.setFill(Color.BLUE);
                }
            }
        }

        this.gc.setFill(Color.RED);
        this.gc.fillOval(top ? 307 : 357, 122, 25, 25);
        this.gc.fillOval(topMid ? 307 : 357, 272, 25, 25);
        this.gc.fillOval(lowMid ? 307 : 357, 422, 25, 25);
        this.gc.fillOval(low ? 307 : 357, 572, 25, 25);

        if (ui)
        {
            if (markers)
            {
                switch (mark)
                {
                    case 0:
                        this.gc.fillPolygon(new double[] { 245, 283, 245 }, new double[] { 122, 135, 148 }, 3);
                        break;
                    case 1:
                        this.gc.fillPolygon(new double[] { 245, 283, 245 }, new double[] { 272, 285, 298 }, 3);
                        break;
                    case 2:
                        this.gc.fillPolygon(new double[] { 245, 283, 245 }, new double[] { 422, 435, 448 }, 3);
                        break;
                    case 3:
                        this.gc.fillPolygon(new double[] { 245, 283, 245 }, new double[] { 572, 585, 598 }, 3);
                }

                i[0] = 16;
                i[1] = 0;
            }
            else
            {
                if (menu) { this.gc.fillPolygon(new double[] { 1316, 1354, 1354 }, new double[] { 248, 235, 261 }, 3); }
                else { this.gc.fillPolygon(new double[] { 1316, 1354, 1354 }, new double[] { 448, 435, 461 }, 3); }
            }
        }

        this.gc.setFill(Color.PURPLE);
        this.gc.fillOval(i[0] * 50 + 307, i[1] * 50 + 72, 25, 25);

        this.gc.setFill(Color.WHITE);
        this.gc.setFont(new Font("Impact", 32));
        this.gc.fillText("Start", 1057, 50);
        this.gc.fillText("Finish", 1057, 690);
        this.gc.fillText("Resume", 1195, 260);
        this.gc.fillText("Setup", 1195, 460);
    }
}

class Walls
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
