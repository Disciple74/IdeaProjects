package Task8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GameField extends JPanel {
    private int playerCount = 0;
    private static final int CELL_SIZE = 100;
    private static final int FIELD_SIZE = 300;
    private static final char SYMBOL_EMPTY = ' ';
    private static final char SYMBOL_X = 'X';
    private static final char SYMBOL_O = 'O';

    private static final int STATE_NOT_OVER = 0;
    private static final int STATE_PLAYER_WIN = 1;
    private static final int STATE_PLAYER_ONE_WIN = -1;
    private static final int STATE_PLAYER_TWO_WIN = -2;
    private static final int STATE_COMPUTER_WIN = 2;
    private static final int STATE_DRAW = 3;
    private int state = STATE_NOT_OVER;
    private char[][] field = new char[3][3];
    private Random random = new Random();

    public GameField(boolean gameType){
        initField();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int y = e.getY() / CELL_SIZE;
                int x = e.getX() / CELL_SIZE;
                if (!gameType) {
                    if (playerCount == 0) {
                        playerTurn(y, x, 'x');
                        playerCount++;
                    } else {
                        playerTurn(y, x, 'o');
                        playerCount--;
                    }
                } else playerTurn(y, x);
                if (GameField.this.state == STATE_NOT_OVER) {
                    if (gameType) {
                        computerTurn();
                        if (isWinO())
                            GameField.this.state = STATE_COMPUTER_WIN;
                    }
                }
                repaint();
                if (GameField.this.state != STATE_NOT_OVER){
                    removeAllListeners();
                }
            }
        });
    }



    private void initField(){
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                setSymbolEmptyAt(y,x);
            }
        }
    }

    private void playerTurn(int y, int x) {
        if (isEmptyAt(y, x)) {
            setSymbolXAt(y, x);
        }
        repaint();
        if (isWinX()) {
            GameField.this.state = STATE_PLAYER_WIN;
        }else if (isFull()) {
            GameField.this.state = STATE_DRAW;
        }
    }

    private void playerTurn(int y, int x, char symbol) {
        if (isEmptyAt(y, x)) {
            if (symbol == 'x') {
                setSymbolXAt(y, x);
            } else setSymbolOAt(y, x);
            repaint();

            if (symbol == 'x'){
                if (isWinX()) {
                    GameField.this.state = STATE_PLAYER_ONE_WIN;
                }else if (isFull()) {
                    GameField.this.state = STATE_DRAW;
                }
            } else if (isWinO()){
                    GameField.this.state = STATE_PLAYER_TWO_WIN;
                } else if (isFull()) {
                    GameField.this.state = STATE_DRAW;
                }
        }
    }

    private void computerTurn(){
        int x;
        int y;
        while (true){
            y = this.random.nextInt(3);
            x = this.random.nextInt(3);
            if(isEmptyAt(y,x)){
                setSymbolOAt(y,x);
                break;
            }
        }
    }

    private boolean isFull(){
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if(isEmptyAt(y,x)) return false;
            }
        }
        return true;
    }

    private boolean isWinO(){
        return isWin(SYMBOL_O);
    }
    private boolean isWinX(){
        return isWin(SYMBOL_X);
    }
    private boolean isWin(char symbol){
        if ((getSymbolAt(0, 0) == symbol)&&(getSymbolAt(0,1) == symbol)&&(getSymbolAt(0,2) == symbol)) return true;
        if ((getSymbolAt(1, 0) == symbol)&&(getSymbolAt(1,1) == symbol)&&(getSymbolAt(1,2) == symbol)) return true;
        if ((getSymbolAt(2, 0) == symbol)&&(getSymbolAt(2,1) == symbol)&&(getSymbolAt(2,2) == symbol)) return true;
        if ((getSymbolAt(0, 0) == symbol)&&(getSymbolAt(1,0) == symbol)&&(getSymbolAt(2,0) == symbol)) return true;
        if ((getSymbolAt(0, 1) == symbol)&&(getSymbolAt(1,1) == symbol)&&(getSymbolAt(2,1) == symbol)) return true;
        if ((getSymbolAt(0, 2) == symbol)&&(getSymbolAt(1,2) == symbol)&&(getSymbolAt(2,2) == symbol)) return true;
        if ((getSymbolAt(0, 0) == symbol)&&(getSymbolAt(1,1) == symbol)&&(getSymbolAt(2,2) == symbol)) return true;
        if ((getSymbolAt(2, 0) == symbol)&&(getSymbolAt(1,1) == symbol)&&(getSymbolAt(0,2) == symbol)) return true;
        return false;
    }

    private boolean isEmptyAt(int y, int x){
        return getSymbolAt(y,x) == SYMBOL_EMPTY;
    }
    private void setSymbolEmptyAt(int y, int x){
        this.field[y][x] = SYMBOL_EMPTY;
    }
    private void setSymbolXAt(int y, int x){
        this.field[y][x] = SYMBOL_X;
    }
    private void setSymbolOAt(int y, int x){
        this.field[y][x] = SYMBOL_O;
    }
    private char getSymbolAt(int y, int x){
        return this.field[y][x];
    }
    private void removeAllListeners(){
        for (MouseListener listener : getMouseListeners()){
            removeMouseListener(listener);
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (int i = 1; i < 3; i++) {
            graphics.drawLine(0, i*CELL_SIZE, FIELD_SIZE, i*CELL_SIZE);
            graphics.drawLine(i*CELL_SIZE, 0, i*CELL_SIZE, FIELD_SIZE);
        }
        graphics.setFont(new Font("Arial", Font.BOLD, 64));
        for (int y = 0; y < 3; y++){
            for (int x = 0; x < 3; x++){
                graphics.drawString(String.valueOf(getSymbolAt(y,x)), x * CELL_SIZE + 25, y* CELL_SIZE + 75);
            }
        }
        if (this.state != STATE_NOT_OVER)
        {
            graphics.setColor(new Color(20,20,20,150));
            graphics.fillRect(0,0, FIELD_SIZE, FIELD_SIZE);
            graphics.setFont(new Font("Arial", Font.BOLD, 28));
            graphics.setColor(new Color(230,230,230));
            switch (this.state){
                case STATE_PLAYER_WIN: {
                    graphics.drawString("Победа игрока!", 45, 150);
                    break;
                }
                case STATE_COMPUTER_WIN: {

                    graphics.drawString("Победа компуктера!", 45, 150);
                    break;
                }
                case STATE_DRAW: {
                    graphics.drawString("Ничья!", 45, 150);
                    break;
                }
                case STATE_PLAYER_ONE_WIN: {
                    graphics.setFont(new Font("Arial", Font.BOLD, 15));
                    graphics.drawString("Победа первого игрока!", 45, 150);
                    break;
                }
                case STATE_PLAYER_TWO_WIN: {
                    graphics.setFont(new Font("Arial", Font.BOLD, 15));
                    graphics.drawString("Победа второго игрока!", 45, 150);
                    break;
                }
                default: {
                    graphics.drawString("Внутренняя ошибка", 45, 150);
                    break;
                }
            }
        }
    }

}
