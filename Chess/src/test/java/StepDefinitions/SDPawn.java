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
    context.pawn = p;
}
@When("the pawn moves forward {int}")
public void the_pawn_moves_forward(Integer int1) {
    context.pawn.move(int1);
}
@Then("the pawn is at position \\({int}, {int})")
public void the_pawn_is_at_position(Integer int1, Integer int2) {
	int bx = context.pawn.getPosition().getX();
	int givenX = int1;
	int by = context.pawn.getPosition().getY();
	int givenY = int1;
	
    assertEquals(bx, givenX );
    assertEquals(by, givenY );

}

}
