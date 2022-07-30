// import java.util.Enumeration;// for Enumeration
// import gnu.io.CommPortIdentifier;// for CommPortIdentifier

public class pv1 {// create a new class
    public static void main(String[] args) {// create a new main method
        new SerialBean("COM6", 9600);// create a new SerialBean
        new SerialBean();// create a new SerialBean
        // listPortChoices();// list the port choices
    }
 
    // public static void listPortChoices() {
    // CommPortIdentifier portId;
    // Enumeration en = CommPortIdentifier.getPortIdentifiers();
    // // iterate through the ports.
    // while (en.hasMoreElements()) {
    // portId = (CommPortIdentifier) en.nextElement();
    // System.out.println("ser");
    // if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
    // System.out.println(portId.getName());
    // }
    // }
    // }
}