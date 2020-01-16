public class EncapsulationDemo {
	public static void main(String[] args) {
		InnerClassDemo inner = new InnerClassDemo();
		inner.accessInner();

		AnonymouseOuterClass outer = new AnonymousOuterClass();
		outer.demo();
	}
}
