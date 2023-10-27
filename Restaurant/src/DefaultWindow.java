import javax.swing.JFrame;



public class DefaultWindow {
	
	
	
	public static void main(String[] args) {
		loginPage first = new loginPage();
		JFrame firstFrame = first.initialize()  ;
		firstFrame.setVisible(true);
		
		
		while(!first.loginSucc) {
			
			
			System.out.println("waiting");
		}
		
		
		offPage offPage = new offPage(first.getUser()) ; 
		JFrame secondFrame = offPage.initialize()  ;
		firstFrame.setVisible(false);
		secondFrame.setVisible(true);
		
		
		
		
		
	}
	
	
	

	
	
	
	
	
	

	

	

	

	
	
	
	
	
	
	


}
