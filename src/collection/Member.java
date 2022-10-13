package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;

public class Member implements Comparable<Member>, Comparator<Member> {
    private int memberId;
    private String memberName;

    public Member() {}
    public Member(int memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public int getMemberId() {
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String toString() {
        return memberName+": "+memberId;
    }

    @Override
    public int hashCode() {
        return memberId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member) {
            Member member = (Member)obj;
            return (this.memberId == member.memberId);
        }
        return false;
    }

    @Override
    public int compareTo(Member o) {
        //양수일 경우 오름차순, 음수일 경우 내림차순
        //return (this.memberId - o.memberId);

        //이름 정렬 String의 경우는 이미 구현되어 있어 바로 사용
       return this.memberName.compareTo(o.getMemberName());
    }

    @Override
    //첫번째 파람 this, 두번째 파람 변수
    public int compare(Member o1, Member o2) {
        return o1.memberName.compareTo(o2.getMemberName());

        iterator - hasNext, next();
    }
}
