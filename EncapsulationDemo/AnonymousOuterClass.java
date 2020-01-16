public class AnonymousOuterClass {

	public void demo() {
		AnonymousInnerClassDemo anonyInner = new AnonymousInnerClass() {
			public void print() {
				System.out.println("Hello.. This is a demonstration of an Inner Class!");
			}
		};

		anonyInner.print();
	}
}
