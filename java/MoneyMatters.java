import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class MoneyMatters {
    private static class Friend {
        public int debt = 0;
        public final ArrayList<Integer> friendOf;

        public Friend(int debt) {
            this.debt = debt;
            this.friendOf = new ArrayList<Integer>();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte tests = Byte.parseByte(scan.nextLine());
        while (tests-- > 0) {
            String[] pf = scan.nextLine().split(" ");
            final int people = Integer.parseInt(pf[0]);
            int friendships = Integer.parseInt(pf[1]);
            final Friend[] friends = new Friend[people];

            for (int index = 0; index < people; index++) {
                final int debt = Integer.parseInt(scan.nextLine());
                friends[index] = new Friend(debt);
            }

            while (friendships-- > 0) {
                String[] ab = null;
                while ((ab = scan.nextLine().split(" ")).length < 2);
                final int friendA = Integer.parseInt(ab[0]);
                final int friendB = Integer.parseInt(ab[1]);
                friends[friendA].friendOf.add(friendB);
                friends[friendB].friendOf.add(friendA);
            }
            final boolean arrangeable = isPossibleToArrange(friends);
            System.out.println(arrangeable ? "POSSIBLE" : "IMPOSSIBLE");
        }

        scan.close();
    }

    private static boolean isPossibleToArrange(final Friend[] friends) {
        final HashSet<Integer> friendsVisited = new HashSet<Integer>();
        for (int index = 0; index < friends.length; index++) {
            if (!friendsVisited.contains(index)) {
                int remainingDebt = getRemainingDebt(friends, friendsVisited, index, 0);
                if (remainingDebt != 0) {
                    return false;
                }
            }
        }
        for (int index = 0; index < friends.length; index++) {
            if (friends[index].debt != 0) {

                return false;
            }
        }
        return true;
    }

    private static int getRemainingDebt(final Friend[] friends, final HashSet<Integer> friendsVisited, int index,
            int totalDebt) {
        friendsVisited.add(index);
        final int debt = friends[index].debt;
        friends[index].debt = 0;

        final Iterator<Integer> friendIterator = friends[index].friendOf.iterator();
        while (friendIterator.hasNext()) {
            final int friendId = friendIterator.next();
            if (!friendsVisited.contains(friendId)) {
                totalDebt += getRemainingDebt(friends, friendsVisited, friendId, totalDebt);

            }
        }
        return debt + totalDebt;

    }
}