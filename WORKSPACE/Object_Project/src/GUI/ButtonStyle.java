package GUI;

import javax.swing.JButton;

public class ButtonStyle {
	public void deleteButtonFormat(JButton btn) {	// ��ư�� �⺻ ������� ���� �ֱ� ���� �Լ��� ������ �޼ҵ�
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setDefaultCapable(false);
		btn.setFocusPainted(false);
		btn.setOpaque(false);
	}
}
