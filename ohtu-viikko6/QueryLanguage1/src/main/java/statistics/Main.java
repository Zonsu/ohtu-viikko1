package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        Matcher m = new And(new HasAtLeast(10, "goals"),
                new HasAtLeast(10, "assists"),
                new PlaysIn("PHI")
        );
        Matcher m2 = new Or(new HasAtLeast(40, "goals"),
                new HasAtLeast(60, "assists")
        );
        Matcher m3 = new Not(new HasFewerThan(40, "goals"),
                new PlaysIn("PHI")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        System.out.println("");
        for (Player player : stats.matches(m2)) {
            System.out.println(player);
        }
        System.out.println("");
        for (Player player : stats.matches(m3)) {
            System.out.println(player);
        }
        System.out.println("\n-----------------asdasd-----------------\n");
        
        QueryBuilder query = new QueryBuilder();

        System.out.println("");
        Matcher m4 = query.playsIn("NYR")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "assists").build();

        for (Player player : stats.matches(m4)) {
            System.out.println(player);
        }

        System.out.println("");
        Matcher m5 = query.or(
                query.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(15, "assists").build(),
                query.playsIn("EDM")
                .hasAtLeast(50, "points").build()
        ).build();
        for (Player player : stats.matches(m5)) {
            System.out.println(player);
        }

    }
}
