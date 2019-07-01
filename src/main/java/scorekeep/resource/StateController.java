package scorekeep.resource;

import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import scorekeep.factory.StateFactory;
import scorekeep.model.StateModel;
import scorekeep.entity.State;
import scorekeep.exception.GameNotFoundException;
import scorekeep.exception.SessionNotFoundException;
import scorekeep.exception.StateNotFoundException;

@RestController
@RequestMapping(value="/api/state/{sessionId}/{gameId}")
public class StateController {
  private final StateFactory stateFactory = new StateFactory();
  private final StateModel model = new StateModel();
  private final GameController gameController = new GameController();

  /* GET /state/SESSION/GAME */
  @RequestMapping(method=RequestMethod.GET)
  public List<State> getStates(@PathVariable String sessionId, @PathVariable String gameId) throws SessionNotFoundException, GameNotFoundException {
    return stateFactory.getStates(sessionId, gameId);
  }
  /* GET /state/SESSION/GAME/STATE */
  @RequestMapping(value="/{stateId}", method=RequestMethod.GET)
  public State getState(@PathVariable String sessionId, @PathVariable String gameId, @PathVariable String stateId) throws SessionNotFoundException, GameNotFoundException, StateNotFoundException {
    return stateFactory.getState(sessionId, gameId, stateId);
  }
}
