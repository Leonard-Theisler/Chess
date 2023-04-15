package StepDefinitions;

import static org.junit.Assert.assertEquals;

import Pieces.King;
import Pieces.Position;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDKing {
	private Context context;
	
	public SDKing(Context context) {
		this.context = context;
	}
	
	@Given("a king on the board at \\({int}, {int})")
	public void a_king_on_the_board_at(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
	    King r = new King(p);
	    context.oldPos = p;
	    context.king = r;
	    context.board.setPieceAt(context.king, context.oldPos);
	}
	@Given("a white king on the board at \\({int}, {int})")
	public void a_white_king_on_the_board_at(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
	    King r = new King(p, true);
	    context.oldPos = p;
	    context.king = r;
	    context.board.setPieceAt(context.king, context.oldPos);
	}
	
	@Given("a black king on the board at \\({int}, {int})")
	public void a_black_king_on_the_board_at(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
	    King r = new King(p, false);
	    context.oldPos = p;
	    context.king = r;
	    context.board.setPieceAt(context.king, context.oldPos);
	}
	
	@When("the king moves to \\({int}, {int})")
	public void the_king_moves_to(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
		context.newPos = p;
	    context.board.movePiece(context.king, context.newPos, context.oldPos);
	}
	@When("the king tries to move to \\({int}, {int})")
	public void the_king_tries_to_move_to(Integer int1, Integer int2) {
		Position p = new Position(int1, int2);
		context.newPos = p;
	    context.board.movePiece(context.king, context.newPos, context.oldPos);
	}
	@Then("the king is at \\({int}, {int})")
	public void the_king_is_at(Integer int1, Integer int2) {
		Position pos = new Position(int1, int2);
   	    assertEquals(context.king, context.board.getPieceAt(pos));
	}
	
	@Then("the king is still at the old position")
	public void the_king_is_still_at_the_old_position() {
   	    assertEquals(context.king, context.board.getPieceAt(context.oldPos));

	}

}
