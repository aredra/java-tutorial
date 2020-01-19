package collection;

import java.util.TreeSet;
import java.util.Iterator;

public class MemberTreeSet {
    private TreeSet<Member> treeSet;

    public MemberTreeSet() {
        //Comparator는 꼭 생성할 때 선언필요
        treeSet = new TreeSet<Member>(new Member());
    }

    public void addMember(Member member) {
        treeSet.add(member);
    }

    public boolean removeMember(int memberId) {
        Iterator<Member> ir = treeSet.iterator();
        while(ir.hasNext()) {
            Member member = ir.next();
            if(member.getMemberId() == memberId) {
                treeSet.remove(member);
                return true;
            }
        }
        return false;
    }

    public void showAllMember() {
        for (Member el : treeSet) {
            System.out.println(el);
        }
    }
}
