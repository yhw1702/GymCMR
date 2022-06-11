package Health;

import java.awt.EventQueue;

public class HealthMain {

	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						JoinMember frame = new JoinMember();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
	}


