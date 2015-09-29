package edu.ustc.mix.core.security.cache;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.util.CollectionUtils;

import edu.ustc.mix.core.util.RedisUtils;
import edu.ustc.mix.core.util.SerializeUtils;

public class RedisSessionDAO extends AbstractSessionDAO {
	
	@Override
	public void update(Session session) throws UnknownSessionException {
		
		if(null == session || null == session.getId()) {
			return;
		}
		
		RedisUtils.put(session.getId().toString().getBytes(), SerializeUtils.serialize(session), 60 * 30);
	}
	
	@Override
	public void delete(Session session) {
		
		if(null == session || null == session.getId()) {
			return;
		}
		
		RedisUtils.remove(session.getId().toString().getBytes());
	}
	
	@Override
	public Collection<Session> getActiveSessions() {
		
		Set<Session> sessions = new HashSet<Session>();
		
		Set<String> keys = RedisUtils.keys("*");
		if(!CollectionUtils.isEmpty(keys)) {
			for(String key : keys) {
				Session session = (Session) SerializeUtils.deserialize((byte[]) RedisUtils.get(key.getBytes()));
				sessions.add(session);
			}
		}
		
		return sessions;
	}
	
	@Override
	protected Serializable doCreate(Session session) {
		
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		update(session);
		
		return sessionId;
	}
	
	@Override
	protected Session doReadSession(Serializable sessionId) {
		
		if(null == sessionId) {
			return null;
		}
		
		return  (Session) SerializeUtils.deserialize((byte[]) RedisUtils.get(sessionId.toString().getBytes()));
	}
}
