package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;
import Setup.Game;
import Setup.Board;
import Pieces.Bishop;
import Pieces.Position;


public class SDBishop {
	private Context context;
	
	public SDBishop(Context context) {
		this.context = context;
	}
	
	@Given("a bishop on the board at \\({int}, {int})")
	public void a_bishop_on_the_board_at(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
	    Bishop b = new Bishop(p);
	    context.oldPos = p;
	    context.bishop = b;
	    context.board.setPieceAt(context.bishop, context.oldPos);
	}
	
	@Given("a white bishop on the board at \\({int}, {int})")
	public void a_white_bishop_on_the_board_at(Integer int1, Integer int2) {
	    Position p = new Position(int1, int2);
	    Bishop b = new Bishop(p, true);
	    context.oldPos = p;
	    context.bishop = b;
	    context.board.setPieceAt(context.bishop, context.oldPos);
	}
	
	@When("the bishop moves to \\({int}, {int})")
	public void the_bishop_moves_to(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
		context.newPos = p;
	    context.board.movePiece(context.bishop, context.newPos, context.oldPos);
	}
	
	@When("the bishop tries to move to \\({int}, {int})")
	public void the_bishop_tries_to_move_to(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
		context.newPos = p;
	    context.board.movePiece(context.bishop, context.newPos, context.oldPos);
	}
	
	@Then("the bishop is at \\({int}, {int})")
	public void the_bishop_is_at_position(Integer int1, Integer int2) {	
		Position pos = new Position(int1, int2);
   	    assertEquals(context.bishop, context.board.getPieceAt(pos));

	}
	
	@Then("the bishop is still at the old position")
	public void the_bishop_is_at_position() {		
   	    assertEquals(context.bishop, context.board.getPieceAt(context.oldPos));

	}
	
}