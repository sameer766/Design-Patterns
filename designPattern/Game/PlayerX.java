package all_projects.src.designPattern.Game;

 abstract class Player {

     PieceTyppe pieceTyppe;

     Player( PieceTyppe pieceTyppe){
         this.pieceTyppe=pieceTyppe;
     }

     @Override
     public String toString() {
        return pieceTyppe.name();
     }
 }

class PlayerX extends  Player{

     PlayerX(){
         super(PieceTyppe.X);
     }

}
class PlayerY extends  Player{

    PlayerY(){
        super(PieceTyppe.O);
    }

}





