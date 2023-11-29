package study.spring.mybatis_spring.propagation.exist;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import study.spring.mybatis_spring.propagation.InnerService;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExistTransactionService {

	private final InnerService innerService;

	@Transactional
	public void required_required() {
		log.debug("ExistTransactionService.required");
		innerService.required();
	}

	@Transactional
	public void required_requiresNew() {
		log.debug("ExistTransactionService.required");
		innerService.requiresNew();
	}

	@Transactional
	public void required_nested() {
		log.debug("ExistTransactionService.required");
		innerService.nested();
	}

	@Transactional
	public void required_supports() {
		log.debug("ExistTransactionService.required");
		innerService.supports();
	}

	@Transactional
	public void required_notSupported() {
		log.debug("ExistTransactionService.required");
		innerService.notSupported();
	}

	@Transactional
	public void required_mandatory() {
		log.debug("ExistTransactionService.required");
		innerService.mandatory();
	}

	@Transactional
	public void required_never() {
		log.debug("ExistTransactionService.required");
		innerService.never();
	}

}
