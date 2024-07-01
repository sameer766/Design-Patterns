package all_projects.src.designPattern.Game;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public enum PieceTyppe {
    X, O
}


class Piece {

}

class Board{

     public Player a[][];

    Board(int size){
        a=new Player[size][size];


    }


    public void printBoard() {
        for(int i=0; i< a.length; i++){
            for(int j=0; j<a[0].length; j++) {
                if (a[i][j] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(a[i][j]);
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public List<Map<Integer, Integer>> getFreeCell() {
        List<Map<Integer, Integer>> list=new LinkedList<>();
        for(int i=0; i< a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == null) {
                    int finalI = i;
                    int finalJ = j;
                    list.add(new HashMap() {{
                        put(finalI, finalJ);
                    }});
                }
            }
        }
        return list;
    }

    public boolean addPiece(Player player, int row, int col) {
        if(a[row][col] != null){
            return false;
        }
        a[row][col] = player;
        return true;
    }
}

class Game{

    Game(){
        initializeGame();
        }



        Board board;
    List<Player> playerList=new ArrayList<>();
    private void initializeGame() {

        Player playerX=new PlayerX();
        Player playeYX=new PlayerY();

        playerList.add(playerX);
        playerList.add(playeYX);

       board =  new Board(3);

    }

    public PieceTyppe startGame(){

        Deque<Player> players=new ArrayDeque<>();
        players.addFirst(playerList.get(0));
        players.addLast(playerList.get(1));

        boolean winner= false;
        while (!winner){
            Player player = players.removeFirst();
            board.printBoard();
            List<Map<Integer, Integer>> free = board.getFreeCell();
            if(free.isEmpty()){
                return null;
            }
            Scanner scanner=new Scanner(System.in);
            System.out.println("enter row and column separate by , ");
            String line = scanner.nextLine();
            String[] split = line.split(",");

            int row= Integer.parseInt(split[0]);
            int col= Integer.parseInt(split[1]);


            boolean b = board.addPiece(player, row, col);

            if(!b){
                System.out.println("incorrec pos");
                players.addFirst(player);
                continue;
            }
            players.addLast(player);

            boolean thereWinner = isThereWinner(row, col, player);
            if(thereWinner){
                return player.pieceTyppe;
            }

        }
        System.out.println("tie");


        return null;
    }

    boolean isThereWinner(int row, int col, Player player){
        Player[][] a = board.a;
        int i = 0;
        for(; i< a[0].length; i++){
           if(a[row][i] != player){
              break;
           }

        }
        if(i==a[0].length){
            return true;
        }
        i=0;
        for(; i< a.length; i++){
            if(a[i][col] != player){
                break;
            }

        }
        if(i==a.length){
            return true;
        }
        i=0;
        int j=0;
        for(; i< a.length; i++,j++){
            if(board.a[i][j] != player){
                break;
            }
        }
        if(i==a.length){
            return true;
        }
        if (j == a[0].length) {
            return true;
        }
        i=0;
        j=a[0].length-1;

        for(; i< a.length; i++,j--){
            if(board.a[i][j] != player){
                break;
            }
        }
        if(i==a.length-1){
            return true;
        }
        if (j < 0 ) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Game game=new Game();
        PieceTyppe pieceTyppe = game.startGame();

        System.out.println("winner is "+pieceTyppe);
    }


}