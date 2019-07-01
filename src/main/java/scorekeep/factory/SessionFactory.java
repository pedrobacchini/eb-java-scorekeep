package scorekeep.factory;
import scorekeep.config.Identifiers;
import scorekeep.model.SessionModel;
import scorekeep.exception.SessionNotFoundException;
import scorekeep.entity.Session;

import java.util.*;

public class SessionFactory {
  private final SessionModel model = new SessionModel();

  public SessionFactory(){
  }

  public Session newSession() {
    String id = Identifiers.random();
    Session session = new Session(id);
    model.saveSession(session);
    return session;
  }

  public Session getSession(String sessionId) throws SessionNotFoundException {
    return model.loadSession(sessionId);
  }

  public List<Session> getSessions() {
    return model.loadSessions();
  }
}