package abstractex;

public class ComputerTest {
    public static void main(String[] args) {
        Computer desktop = new Desktop();
        desktop.display();
        desktop.typing();

        Computer note = new Notebook() {
            @Override
            public void display() {
                System.out.println("note is warning");
            }
        };

        note.display();
        note.typing();

        Computer notebook = new MyNotebook();
        notebook.display();
        notebook.typing();
    }
}
