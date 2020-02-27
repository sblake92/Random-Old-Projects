import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class HTMLManager {
  
	Queue<HTMLTag> fixPage = new LinkedList<HTMLTag>();
	Queue<HTMLTag> page = new LinkedList<HTMLTag>();
	
	public HTMLManager (Queue<HTMLTag> page){
		
		if(page == null)
			throw new IllegalArgumentException("argument is null");
		
		this.page.addAll(page);
	}
	
	public void add(HTMLTag tag){
		
		if (tag == null)
			throw new IllegalArgumentException("argument is null");
		
		page.add(tag);
	}
	
	public void removeAll(HTMLTag tag){
		
		if (tag == null)
			throw new IllegalArgumentException("argument is null");
		
		Stack<HTMLTag> stack = new Stack<HTMLTag>();
		int size = page.size();
		for (int i = 0; i < page.size(); i++){
		
			HTMLTag currentTag = page.remove();
			if(!currentTag.equals(tag)){
				stack.push(currentTag);
			}
		}
		page.clear();
		for (HTMLTag i : stack){
			page.add(i);
		}
	}
	
	public Queue<HTMLTag> getTags(){
		
		return this.page;
	}
	
	public void fixHTML(){
		
		Stack<HTMLTag> tagStack = new Stack<HTMLTag>();
		
		int size = page.size();
		for (int i = 0; i < size; i++){
			
			HTMLTag currentTag = page.remove();
			if (currentTag.isSelfClosing()){
				fixPage.add(currentTag);
			}else if (currentTag.isOpening()){
				tagStack.push(currentTag);
				fixPage.add(currentTag);
			}else if (currentTag.isClosing() && !tagStack.isEmpty()){
				if (currentTag.equals(tagStack.peek())){
					fixPage.add(currentTag);
					tagStack.pop();
				}else{
					fixPage.add(tagStack.pop().getMatching());
					page.add(currentTag);
				}
			}
		}
		page.clear();
		page.addAll(fixPage);
	}

}
