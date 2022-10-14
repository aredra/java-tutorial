package collection;

import java.util.Comparator;
import java.util.TreeSet;

class MyComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2) * -1;
    }
}

public class MemberTreeSetTest {
    public static void main(String[] args) {
        MemberTreeSet manager = new MemberTreeSet();
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

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("A");
        treeSet.add("a");
        treeSet.add("B");
        treeSet.add("b");
        treeSet.add("C");
        treeSet.add("c");
        System.out.println(treeSet);

        TreeSet<String> treeSet2 = new TreeSet<>(new MyComparator());
        treeSet2.add("A");
        treeSet2.add("a");
        treeSet2.add("B");
        treeSet2.add("b");
        treeSet2.add("C");
        treeSet2.add("c");
        System.out.println(treeSet2);

    }
}
