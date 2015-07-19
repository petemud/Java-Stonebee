package core.phase

import core.Copyable
import core.Game

class Phase implements Copyable {
    final boolean outermost
    boolean pendingResolution

    Phase() {
        this(false)
    }

    Phase(boolean outermost) {
        this.pendingResolution = false
        this.outermost = outermost
    }

    /**
     * Called when phase occurs.
     * This method is used in sequence of events, cause only main phase can have death phase after it.
     */
    void occur(Game game) {
        checkTriggers(game)
        pendingResolution = true
    }

    private void checkTriggers(Game game) {
        def queue = new PriorityQueue<Phase>()
        game.triggers.each { if (it.getFrom(game).trigger(this, game)) queue.add(it.getFrom(game)) }
        queue.each { game.addPhase(it) }
    }

    public Phase copy() {
        Phase clone = new Phase(outermost)
        clone.pendingResolution = pendingResolution
        clone
    }
}