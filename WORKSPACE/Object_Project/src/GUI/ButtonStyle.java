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
	public void deleteButtonFormat(JButton btn) {	// ��ư�� �⺻ ������� ���� �ֱ� ���� �Լ��� ������ �޼ҵ�
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setDefaultCapable(false);
		btn.setFocusPainted(false);
		btn.setOpaque(false);
	}
}