package exam;

public class BDXZ02 {

    public int minimumNumberOfGunShots(int num, int shotDegrade, int remDegrade, int[] health)
    {
        int shot = 0, idx;
        while (true) {
            idx = maxHealth(health);
            if (health[idx] <= 0) return shot;
            health[idx] -= shotDegrade;
            for (int i = 0; i < health.length; i++) {
                if (i != idx) {
                    health[i] -= remDegrade;
                }
            }
            shot++;
        }
    }

    int maxHealth(int[] health) {
        int idx = 0;
        for (int i = 0; i < health.length; i++) {
            if (health[i] > health[idx]) idx = i;
        }
        return idx;
    }
}
