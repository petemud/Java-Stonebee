package core.phase;

import core.Game;
import core.Link;
import core.card.creature.Minion;

/**
 * Ship's Cannon, Knife Juggler and Sword of Justice Queue and resolve here.
 * This phase is only used to activate triggers
 */
public class AfterSummonPhase extends Phase {
    private Link<? extends Minion> minion;

    public AfterSummonPhase(Link<? extends Minion> minion, boolean outermost) {
        super(outermost);
        this.minion = minion;
    }

    @Override
    public void occur(Game game) {
//        if (!minion.getFrom(game).getPlayer(game).play.contains(minion)) {
//            System.out.printf("After Summon Phase of %s aborted because he is not in play zone\n", minion.getFrom(game));
//            return;
//        }
        super.occur(game);
    }

    public Link<? extends Minion> getMinion() {
        return minion;
    }

    @Override
    public AfterSummonPhase copy() {
        AfterSummonPhase o = (AfterSummonPhase) super.copy();
        o.minion = minion.copy();
        return o;
    }
}
