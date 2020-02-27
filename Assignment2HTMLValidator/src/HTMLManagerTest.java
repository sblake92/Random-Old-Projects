// CSE 143
// This testing program stub creates a queue of HTML tags 
// in a valid sequence.
// You may use this as a starting point for testing
// your removeAll method.
import java.util.*;

public class HTMLManagerTest {
	public static void main(String[] args) {
		// <b>Hi</b><br/>
		
		Queue<HTMLTag> tags = new LinkedList<HTMLTag>();
		tags.add(new HTMLTag("b", HTMLTagType.OPENING));      // <b>
		tags.add(new HTMLTag("b", HTMLTagType.OPENING));      // <b>
		tags.add(new HTMLTag("b", HTMLTagType.OPENING));      // <b>
		tags.add(new HTMLTag("i", HTMLTagType.OPENING));      // <i>
		tags.add(new HTMLTag("br", HTMLTagType.SELF_CLOSING));// <br/>
		tags.add(new HTMLTag("b", HTMLTagType.CLOSING));     // </b>
		tags.add(new HTMLTag("i", HTMLTagType.CLOSING));     // </i>
		tags.add(new HTMLTag("i", HTMLTagType.CLOSING));     // </i>
		tags.add(new HTMLTag("i", HTMLTagType.CLOSING));     // </i>
		tags.add(new HTMLTag("i", HTMLTagType.CLOSING));     // </i>
		
		
		HTMLManager manager = new HTMLManager(tags);

		// YOUR TESTS GO HERE
		
		System.out.println(manager.getTags());
		manager.removeAll(new HTMLTag("b", HTMLTagType.OPENING));
		System.out.println(manager.getTags());
		
	}
}