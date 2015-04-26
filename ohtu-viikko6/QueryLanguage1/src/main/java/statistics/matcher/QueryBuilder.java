/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;

/**
 *
 * @author Johanna
 */
public class QueryBuilder {

    private ArrayList<Matcher> matchers;

    public QueryBuilder() {
        this.matchers = new ArrayList<Matcher>();
    }

    public QueryBuilder hasAtLeast(int value, String fieldName) {
        matchers.add(new HasAtLeast(value, fieldName));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String fieldName) {
        matchers.add(new HasFewerThan(value, fieldName));
        return this;
    }

    public QueryBuilder not(Matcher... matcher) {
        matchers.add(new Not(matcher));
        return this;
    }

    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder or(Matcher... matcher) {
        matchers.add(new Or(matcher));
        return this;
    }

    public Matcher build() {
        Matcher[] buildArray = new Matcher[matchers.size()];
        for (int i = 0; i < matchers.size(); i++) {
            buildArray[i] = matchers.get(i);
        }
        matchers = new ArrayList();
        return new And(buildArray);
    }
}
