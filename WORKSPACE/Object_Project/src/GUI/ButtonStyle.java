package GUI;

import javax.swing.JButton;

/** This class consists of method that erasing the default form of JButton. 
* 
* <br>
* Default forms of JButton means border, filling, painting, capable, and opaque.
* 
* @author Myungho Bae
* @version 1.0
**/
public class ButtonStyle {
	/** Sets the all states of given JButton to 0
	* 
	* 
	* @param void
	* @return boolean
	**/		
	public void deleteButtonFormat(JButton btn) {	// 버튼의 기본 모습들을 없애 주기 위한 함수를 포함한 메소드
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setDefaultCapable(false);
		btn.setFocusPainted(false);
		btn.setOpaque(false);
	}
}