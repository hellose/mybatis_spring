package study.spring.mybatis_spring.propagation.notexist;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotExistTransactionService {

	@Transactional
	public void required() {
		log.debug("NotExistTransactionService.required");
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void requiresNew() {
		log.debug("NotExistTransactionService.requiresNew");
	}

	@Transactional(propagation = Propagation.NESTED)
	public void nested() {
		log.debug("NotExistTransactionService.nested");
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void supports() {
		log.debug("NotExistTransactionService.supports");
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void notSupported() {
		log.debug("NotExistTransactionService.notSupported");
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void mandatory() {
		log.debug("NotExistTransactionService.mandatory");
	}

	@Transactional(propagation = Propagation.NEVER)
	public void never() {
		log.debug("NotExistTransactionService.never");
	}

}
