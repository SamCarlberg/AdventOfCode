
package adventofcode;

import java.util.HashSet;
import java.util.Set;

import static adventofcode.Tuple.tuple;

/**
 * Solves the problems for day three of the advent calendar:
 * <a href="http://adventofcode.com/day/3">adventofcode.com/day/3</a>
 *
 * @author Sam Carlberg
 */
public class Day3 extends Solver<Integer> {
    
    private static final char UP    = '^';
    private static final char DOWN  = 'v';
    private static final char LEFT  = '<';
    private static final char RIGHT = '>';

    public Day3() {
        super(3);
    }

    @Override
    protected Integer part1(String input) {
        Set<Tuple> visited = new HashSet<>();
        int x = 0;
        int y = 0;
        for (char c : input.toCharArray()) {
            switch (c) {
                case UP:    x++; break;
                case DOWN:  x--; break;
                case LEFT:  y--; break;
                case RIGHT: y++; break;
            }
            visited.add(tuple(x, y));
        }
        return visited.size();
    }

    @Override
    protected Integer part2(String input) {
        Set<Tuple> visited = new HashSet<>();
        int[] x = {0, 0}; // santa is 0, robo-santa is 1
        int[] y = {0, 0}; // santa is 0, robo-santa is 1
        char[] chars = input.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int s = i % 2; // which santa? normal santa is 0, robo-santa is 1
            switch (c) {
                case UP:    x[s]++; break;
                case DOWN:  x[s]--; break;
                case LEFT:  y[s]--; break;
                case RIGHT: y[s]++; break;
            }
            visited.add(tuple(x[s], y[s]));
        }
        return visited.size();
    }

    public static void main(String[] args) {
        new Day3().solve();
    }

}