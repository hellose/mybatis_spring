package study.spring.mybatis_spring.propagation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InnerService {

	@Transactional
	public void required() {
		log.debug("InnerService.required");
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void requiresNew() {
		log.debug("InnerService.requiresNew");
	}

	@Transactional(propagation = Propagation.NESTED)
	public void nested() {
		log.debug("InnerService.nested");
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void supports() {
		log.debug("InnerService.supports");
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void notSupported() {
		log.debug("InnerService.notSupported");
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void mandatory() {
		log.debug("InnerService.mandatory");
	}

	@Transactional(propagation = Propagation.NEVER)
	public void never() {
		log.debug("InnerService.never");
	}

}
