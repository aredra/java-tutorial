package exception;

public class IDFormatTest {
    private String userID;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) throws IDFormatExcetion{
        if (userID == null) {
            throw new IDFormatExcetion("ID can not be null");
        }
        else if (userID.length()<10) {
            throw new IDFormatExcetion("ID length < 10");
        }
        this.userID = userID;
    }

    public static void main(String[] args) {
        IDFormatTest user = new IDFormatTest();

        String myId = null;

        try {
            user.setUserID(myId);
        } catch (IDFormatExcetion idFormatExcetion) {
            System.out.println(idFormatExcetion);
        }
    }
}
