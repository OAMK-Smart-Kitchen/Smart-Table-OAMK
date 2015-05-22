package SMARTTABLE;

import java.io.IOException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import SMARTTABLE.*;

import com.leapmotion.leap.CircleGesture;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.FingerList;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.GestureList;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.KeyTapGesture;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.ScreenTapGesture;
import com.leapmotion.leap.SwipeGesture;
import com.leapmotion.leap.Vector;

public class newSample implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		process();

	}

	private void process() {
		// TODO Auto-generated method stub

		// create a sample listener and controller
		SampleListener listener = new SampleListener();
		Controller controller = new Controller();

		// have the sample listener receive events from the controller
		controller.addListener(listener);

		// Keep this process running until Enter is pressed
		System.out.println("Press Enter to quit...");

		try {
			System.in.read();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// remove the sample listener when done
		controller.removeListener(listener);

	}

}

class SampleListener extends Listener {

	public SampleListener() {
		// TODO Auto-generated constructor stub
	}

	public void onInit(Controller controller) {
		System.out.println("Initialized");
	}

	public void onConnect(Controller controller) {
		System.out.println("Connected");
		controller.enableGesture(Gesture.Type.TYPE_SWIPE);
		// controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
		// controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
		controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
	}

	public void onDisconnect(Controller controller) {
		// Note: not dispatched when running in a debugger.
		System.out.println("Disconnected");
	}

	public void onExit(Controller controller) {
		System.out.println("Exited");
	}

	public void onFrame(Controller controller) {
		// Get the most recent frame and report some basic information
		Frame frame = controller.frame();
		/*
		 * System.out.println("Frame id: " + frame.id() + ", timestamp: " +
		 * frame.timestamp() + ", hands: " + frame.hands().count() +
		 * ", fingers: " + frame.fingers().count() + ", tools: " +
		 * frame.tools().count() + ", gestures " + frame.gestures().count());
		 */

		if (!frame.hands().isEmpty()) {
			// Get the first hand
			Hand hand = frame.hands().get(0);

			// Check if the hand has any fingers
			FingerList fingers = hand.fingers();
			if (!fingers.isEmpty()) {
				// Calculate the hand's average finger tip position
				Vector avgPos = Vector.zero();
				for (Finger finger : fingers) {
					avgPos = avgPos.plus(finger.tipPosition());
				}
				avgPos = avgPos.divide(fingers.count());
				/*
				 * System.out.println("Hand has " + fingers.count() +
				 * " fingers, average finger tip position: " + avgPos);
				 */
			}

			// Get the hand's sphere radius and palm position
			/*
			 * System.out.println("Hand sphere radius: " + hand.sphereRadius() +
			 * " mm, palm position: " + hand.palmPosition());
			 */

			// Get the hand's normal vector and direction
			Vector normal = hand.palmNormal();
			Vector direction = hand.direction();

			// Calculate the hand's pitch, roll, and yaw angles
			/*
			 * System.out.println("Hand pitch: " +
			 * Math.toDegrees(direction.pitch()) + " degrees, " + "roll: " +
			 * Math.toDegrees(normal.roll()) + " degrees, " + "yaw: " +
			 * Math.toDegrees(direction.yaw()) + " degrees");
			 */
		}

		GestureList gestures = frame.gestures();

		for (int i = 0; i < gestures.count(); i++) {
			Gesture gesture = gestures.get(i);

			switch (gesture.type()) {
			case TYPE_CIRCLE:
				CircleGesture circle = new CircleGesture(gesture);

				// Calculate clock direction using the angle between circle
				// normal and pointable
				String clockwiseness;
				if (circle.pointable().direction().angleTo(circle.normal()) <= Math.PI / 4) {
					// Clockwise if angle is less than 90 degrees
					clockwiseness = "clockwise";
					main.window.get_home().requestFocus();
				} else {
					clockwiseness = "counterclockwise";
					main.window.get_home().requestFocus();
					
				}

				// Calculate angle swept since last frame
				/*double sweptAngle = 0;
				if (circle.state() != Gesture.State.STATE_START) {
					CircleGesture previousUpdate = new CircleGesture(controller
							.frame(1).gesture(circle.id()));
					sweptAngle = (circle.progress() - previousUpdate.progress())
							* 2 * Math.PI;
				}
*/
				/*
				 * System.out.println("Circle id: " + circle.id() + ", " +
				 * circle.state() + ", progress: " + circle.progress() +
				 * ", radius: " + circle.radius() + ", angle: " +
				 * Math.toDegrees(sweptAngle) + ", " + clockwiseness);
				 */

				System.out.println(clockwiseness);
				break;

			case TYPE_SWIPE:
				SwipeGesture swipe = new SwipeGesture(gesture);
				double swipeX = swipe.direction().getX();
				double swipeY = swipe.direction().getY();

				if (Math.abs(swipeX) > 0.8) {
					if (swipeX > 0) {
					// it is horizontal movement
					
						// it is going to left

						/*Component current = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
						
						int index = getComponentIndex(current);
						for (int j = 0; j < current.getParent()
								.getComponentCount(); j++) {
							System.out.println(current.getParent()
									.getComponent(j).getName());
						}
						System.out.println("this is right side = " + index
								+ current.getName());
						
						if (index == current.getParent().getComponentCount() - 1) {
							if(!current.getParent().getComponent(1).getName().equalsIgnoreCase(null)){
								current.getParent().getComponent(0).transferFocus();
							}
							else{
								current.getParent().getComponent(1).transferFocus();
							}
								
							System.out.println("여기다!");
						} else {
							
							if(!current.getParent().getComponent(index+1).getName().equalsIgnoreCase(null)){
								current.getParent().getComponent(index).transferFocus();
							}
							else{
								current.getParent().getComponent(0).transferFocus();
							}

							System.out.println("아닌데 여기다!");
						}

						switch (main.where_panel) {
						case "Main_panel":
							main.window.m_panel.Change_bg(index + 1);
							break;

						default:
							break;
						}*/
						
						main.window.get_bt1().transferFocus();
						main.window.m_panel.Change_bg(2);
						System.out.println("Right!");

						/*
						 * frame.getComponent(0).transferFocus();
						 */} else {

							/*	Component current = main.frame
										.getMostRecentFocusOwner();

								int index = getComponentIndex(current);
								for (int j = 0; j < current.getParent()
										.getComponentCount(); j++) {
									System.out.println(current.getParent()
											.getComponent(j).getName());
								}
								System.out.println("this is left side = " + index
										+ current.getName());
								if (index ==  0) {
									current.getParent().getComponent(current.getParent().getComponentCount()-2).transferFocus();

									System.out.println("여기다!");
								} else {
									current.getParent().getComponent(index-2)
											.transferFocus();
									System.out.println("아닌데 여기다!");
								}

								switch (main.where_panel) {
								case "Main_panel":
									main.window.m_panel.Change_bg(index + 1);
									break;

								default:
									break;
								}*/
							 
								main.window.get_bt2().transferFocusBackward();
								main.window.m_panel.Change_bg(1);
								System.out.println("left!");
					}
				}

				else if (Math.abs(swipeY) > 0.8) {

					// it is vertical movement
					if (swipeY > 0) {
						// it is going to left
						System.out.println("Up!");
						main.window.get_bt2().transferFocus();
						main.window.m_panel.Change_bg(3);
						
					} else {

						System.out.println("Down!");
						main.window.get_bt3().transferFocus();
						main.window.m_panel.Change_bg(4);
					}

				}

				else {
					System.out.println("THE OTHER SWIPE!");
				}

				// boolean isHorizontal = Math.abs(swipe.direction().) >
				// Math.abs(swipe.direction())
				/*
				 * System.out.println("Swipe id: " + swipe.id() + ", " +
				 * swipe.state() + ", position: " + swipe.position() +
				 * ", direction: " + swipe.direction() + ", speed: " +
				 * swipe.speed());
				 */
				break;

			case TYPE_SCREEN_TAP:
				ScreenTapGesture screenTap = new ScreenTapGesture(gesture);
				System.out.println("Screen Tap id: " + screenTap.id() + ", "
						+ screenTap.state() + ", position: "
						+ screenTap.position() + ", direction: "
						+ screenTap.direction());
				break;

			case TYPE_KEY_TAP:
				KeyTapGesture keyTap = new KeyTapGesture(gesture);
				System.out.println("Key Tap id: " + keyTap.id() + ", "
						+ keyTap.state() + ", position: " + keyTap.position()
						+ ", direction: " + keyTap.direction());

			/*	switch (main.swipe_direction) {
				case 1:
					main.window.j1.doClick();
					break;
				case 2:
					main.window.j2.doClick();
					break;

				case 3:
					main.window.j3.doClick();
					break;
				case 4:
					main.window.j4.doClick();
					break;
				default:
					System.out.println("dd " + main.swipe_direction);
					break;
				}*/
				Component c = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
				JButton J1 = (JButton)c;
				J1.doClick();

				break;
			default:
				System.out.println("Unknown gesture type.");
				break;
			}
		}

		if (!frame.hands().isEmpty() || !gestures.isEmpty()) {
			// System.out.println();
		}
	}

	public static final int getComponentIndex(Component component) {
		if (component != null && component.getParent() != null) {
			Container c = component.getParent();
			for (int i = 0; i < c.getComponentCount(); i++) {
				if (c.getComponent(i) == component)
					return i;
			}
		}
		return -1;
	}
}
