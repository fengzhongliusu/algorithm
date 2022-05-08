package leetcode;

import java.util.*;

/**
 * Created by cshuo on 2021/7/5
 */
public class LC1125 {
    public static void main(String[] args) {
        LC1125 test = new LC1125();
        String[] req = new String[] {"vgzp","urfys","nvkjkzxrfn","pqznypwpcv","bdfmsjlddbinqo","xvgkyzqpmzwcxol","twlau","vybgxpyq","edpuw","w"};
        List<List<String>> people = new ArrayList<>();

        people.add(Arrays.asList("xvgkyzqpmzwcxol"));
        people.add(Arrays.asList("w"));
        people.add(Arrays.asList("urfys","w"));
        people.add(Arrays.asList("urfys"));
        people.add(Arrays.asList("bdfmsjlddbinqo"));
        people.add(Arrays.asList("xvgkyzqpmzwcxol"));
        people.add(Arrays.asList());
        people.add(Arrays.asList());
        people.add(Arrays.asList("w"));
        people.add(Arrays.asList("vgzp","w"));
        people.add(Arrays.asList("nvkjkzxrfn","bdfmsjlddbinqo","edpuw"));
        people.add(Arrays.asList("urfys"));
        people.add(Arrays.asList("bdfmsjlddbinqo","xvgkyzqpmzwcxol","twlau"));
        people.add(Arrays.asList("nvkjkzxrfn","bdfmsjlddbinqo","vybgxpyq"));
        people.add(Arrays.asList("vgzp","edpuw"));
        people.add(Arrays.asList("urfys","xvgkyzqpmzwcxol"));
        people.add(Arrays.asList("bdfmsjlddbinqo","w"));
        people.add(Arrays.asList("nvkjkzxrfn","bdfmsjlddbinqo","w"));
        people.add(Arrays.asList("bdfmsjlddbinqo","vybgxpyq"));
        people.add(Arrays.asList("urfys","bdfmsjlddbinqo"));
        people.add(Arrays.asList("vgzp"));
        people.add(Arrays.asList("nvkjkzxrfn","xvgkyzqpmzwcxol"));
        people.add(Arrays.asList("nvkjkzxrfn"));
        people.add(Arrays.asList("vgzp","edpuw"));
        people.add(Arrays.asList());
        people.add(Arrays.asList("bdfmsjlddbinqo"));
        people.add(Arrays.asList("vgzp","nvkjkzxrfn","xvgkyzqpmzwcxol"));
        people.add(Arrays.asList("vgzp","bdfmsjlddbinqo","edpuw","w"));
        people.add(Arrays.asList("xvgkyzqpmzwcxol","vybgxpyq","w"));
        people.add(Arrays.asList("pqznypwpcv","vybgxpyq"));
        people.add(Arrays.asList("vybgxpyq"));
        people.add(Arrays.asList("twlau"));
        people.add(Arrays.asList("vgzp"));
        people.add(Arrays.asList("vgzp","twlau","edpuw"));
        people.add(Arrays.asList("nvkjkzxrfn","bdfmsjlddbinqo"));
        people.add(Arrays.asList("bdfmsjlddbinqo"));
        people.add(Arrays.asList("vgzp"));
        people.add(Arrays.asList("urfys"));
        people.add(Arrays.asList("nvkjkzxrfn"));
        people.add(Arrays.asList("nvkjkzxrfn","edpuw"));
        people.add(Arrays.asList("vgzp","nvkjkzxrfn"));
        people.add(Arrays.asList());
        people.add(Arrays.asList("vgzp","nvkjkzxrfn"));
        people.add(Arrays.asList("xvgkyzqpmzwcxol"));
        people.add(Arrays.asList());
        people.add(Arrays.asList("nvkjkzxrfn","xvgkyzqpmzwcxol","vybgxpyq"));
        people.add(Arrays.asList("vybgxpyq"));
        people.add(Arrays.asList("nvkjkzxrfn"));
        people.add(Arrays.asList("nvkjkzxrfn","edpuw"));
        people.add(Arrays.asList("vgzp"));


        int [] res = test.smallestSufficientTeam2(req, people);
        System.out.println();
        for (int i: res) {
            System.out.print(i + ", ");
        }
    }

    private class Score implements Comparable {
        public double score;
        public int idx;

        public Score(int idx, double score) {
            this.score = score;
            this.idx = idx;
        }

        @Override
        public int compareTo(Object o) {
            double oScore = ((Score) o).score;
            return Double.compare(score, oScore);
        }

        @Override
        public String toString() {
            return idx + "-" + score;
        }
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> wordCnt = new HashMap<>();
        for(List<String> strList: people) {
            for (String s: strList) {
                int prevCnt = wordCnt.getOrDefault(s, 0);
                wordCnt.put(s, prevCnt + 1);
            }
        }

        List<Score> scores = new ArrayList<>();
        double score;
        for (int i = 0; i < people.size(); i++) {
            score = 0;
            List<String> pIdx = people.get(i);
            for (String s: pIdx) {
                score += 1.0 / wordCnt.get(s);
            }
            scores.add(new Score(i, score));
        }

        Collections.sort(scores);

        Iterator<Score> itr = scores.iterator();
        while (itr.hasNext()) {
            Score cur = itr.next();
            List<String> curList = people.get(cur.idx);
            boolean canRm = true;
            List<Integer> curCnt = new ArrayList<>();
            for (String s: curList) {
                int tmpCnt = wordCnt.get(s);
                if (tmpCnt < 2) {
                    canRm = false;
                    break;
                }
                curCnt.add(tmpCnt);
            }
            if (canRm) {
                for (int i = 0; i < curList.size(); i++) {
                    wordCnt.put(curList.get(i), curCnt.get(i) - 1);
                }
                itr.remove();
            }
        }
        int[] res = new int[scores.size()];
        for (int i = 0; i < scores.size(); i++) {
            res[i] = scores.get(i).idx;
        }
        return res;
    }

    List<Integer> sol = new ArrayList<>();

    public int[] smallestSufficientTeam2(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> idx = new HashMap<>();

        int n = 0;
        for (String s : req_skills)
            idx.put(s, n++);///skills are represented by 0, 1, 2....

        int[] pe = new int[people.size()];
        for (int i = 0; i < pe.length; i++) {
            for (String p : people.get(i)) {
                int skill = idx.get(p);
                pe[i] += 1 << skill;
            }
        } // each person is transferred to a number, of which the bits of 1 means the guy has the skill
        search(0, pe, new ArrayList<Integer>(), n);
        int[] ans = new int[sol.size()];
        for (int i = 0; i < sol.size(); i++) ans[i] = sol.get(i);
        return ans;
    }

    public void search(int cur, int[] pe, List<Integer> onesol, int n) {
        if (cur == (1<<n) - 1) {  // when all bits are 1, all skills are coverred
            if (sol.size() == 0 || onesol.size() < sol.size()) {
                sol = new ArrayList<>(onesol);
            }
            return;
        }
        if (sol.size() != 0 && onesol.size() >= sol.size()) return;    //pruning

        int zeroBit = 0;
        while (((cur>>zeroBit)&1) == 1) zeroBit++;

        for (int i = 0; i < pe.length; i++) {
            int per = pe[i];
            if (((per>>zeroBit)&1) == 1) {
                onesol.add(i); // when a person can cover a zero bit in the current number, we can add him
                search(cur|per, pe, onesol, n);
                onesol.remove(onesol.size() - 1);  //search in a backtracking way
            }
        }
    }
}
