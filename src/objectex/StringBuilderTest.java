package objectex;

public class StringBuilderTest {
    public static void main(String[] args) {
        String java = new String("java");
        String android = new String("android");

        StringBuilder builder = new StringBuilder(java);
        System.out.println(System.identityHashCode(builder));
        builder.append(android);

        java = builder.toString();
        System.out.println(java);
        System.out.println(System.identityHashCode(builder));
    }
}
