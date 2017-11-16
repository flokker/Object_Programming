package GUI;

import javax.swing.JButton;

public class ButtonStyle {
	public void deleteButtonFormat(JButton btn) {	// 버튼의 기본 모습들을 없애 주기 위한 함수를 포함한 메소드
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setDefaultCapable(false);
		btn.setFocusPainted(false);
		btn.setOpaque(false);
	}
}
