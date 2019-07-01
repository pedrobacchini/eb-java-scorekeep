package scorekeep.resource;

import java.util.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import scorekeep.config.Rules;
import scorekeep.factory.RulesFactory;

@RestController
@RequestMapping(value="/api/rules")
public class RulesController {
  private final RulesFactory rulesFactory = new RulesFactory();

  /* GET /rules */
  @RequestMapping(method=RequestMethod.GET)
  public Collection<Rules> rules() {
    return rulesFactory.getAllRules();
  }
  /* GET /rules/RULES */
  @RequestMapping(value="/{rulesId}",method=RequestMethod.GET)
  public Rules rules(@PathVariable String rulesId) {
    return rulesFactory.getRules(rulesId);
  }
}
