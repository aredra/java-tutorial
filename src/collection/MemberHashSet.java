package collection;

import java.util.HashSet;
import java.util.Iterator;

public class MemberHashSet {
    private HashSet<Member> hashSet;

    public MemberHashSet() {
        hashSet = new HashSet<Member>();
    }

    public void addMember(Member member) {
        hashSet.add(member);
    }

    public boolean removeMember(int memberId) {
        Iterator<Member> ir = hashSet.iterator();
        while(ir.hasNext()) {
            Member member = ir.next();
            if(member.getMemberId() == memberId) {
                hashSet.remove(member);
                return true;
            }
        }
        return false;
    }

    public void showAllMember() {
        for (Member el : hashSet) {
            System.out.println(el);
        }
    }
}
