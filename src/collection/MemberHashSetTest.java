package collection;

public class MemberHashSetTest {
    public static void main(String[] args) {
        MemberHashSet manager = new MemberHashSet();
        Member member1 = new Member(1, "A");
        Member member2 = new Member(2, "B");
        Member member3 = new Member(3, "C");
        Member member4 = new Member(4, "D");
        Member member5 = new Member(4, "F");

        manager.addMember(member1);
        manager.addMember(member2);
        manager.addMember(member3);
        manager.addMember(member4);
        manager.addMember(member5);

        manager.showAllMember();

        manager.removeMember(2);

        manager.showAllMember();
    }
}
