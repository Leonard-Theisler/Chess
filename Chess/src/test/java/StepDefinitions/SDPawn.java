package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;

import Pieces.Bishop;
import Pieces.Position;
import Pieces.Pawn;

public class SDPawn {
	private Context context;
	
	public SDPawn(Context context) {
		this.context = context;
	}
	public SDPawn() {
		
	}

@Given("a white pawn on the board at \\({int}, {int})")
public void a_pawn_on_the_board_at(Integer int1, Integer int2) {
	Position pos = new Position(int1, int2);
    Pawn p = new Pawn(pos, true);
    context.oldPos = pos;
    context.pawn = p;
    context.board.setPieceAt(context.pawn, context.oldPos);
}

@Given("a black pawn on the board at \\({int}, {int})")
public void a_black_pawn_on_the_board_at(Integer int1, Integer int2) {
	Position pos = new Position(int1, int2);
    Pawn p = new Pawn(pos, false);
    context.oldPos = pos; 
    context.pawn = p;
    context.board.setPieceAt(context.pawn, context.oldPos);
}

@Given("a white pawn on the board at initial position \\({int}, {int})")
public void a_white_pawn_on_the_board_at_initial_position(Integer int1, Integer int2) {
    Position pos = new Position(int1, int2);
    if (pos.isWhitePawnInitialPosition()) {
        Pawn p = new Pawn(pos, true);
        context.pawn = p;    
        context.oldPos = pos;
    }
}

@Given("a black pawn on the board at initial position \\({int}, {int})")
public void a_black_pawn_on_the_board_at_initial_position(Integer int1, Integer int2) {
    Position pos = new Position(int1, int2);
    if (pos.isBlackPawnInitialPosition()) {
        Pawn p = new Pawn(pos, false);
        context.pawn = p; 
        context.oldPos = pos;
    }
}

@When("the pawn moves forward {int}")
public void the_pawn_moves_forward(Integer int1) {
	if (context.pawn.getWhite()) {
		Position p = new Position(context.oldPos.getX(), context.oldPos.getY() + int1);
		context.newPos = p;
	}
	if (!context.pawn.getWhite()) {
		Position p = new Position(context.oldPos.getX(), context.oldPos.getY() - int1);
		context.newPos = p;
	}
    context.board.movePiece(context.pawn, context.newPos, context.oldPos);
}

@Then("the pawn is at position \\({int}, {int})")
public void the_pawn_is_at_position(Integer int1, Integer int2) {
	assertEquals(context.pawn, context.board.getPieceAt(context.newPos));


}

}
