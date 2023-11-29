package study.spring.mybatis_spring.propagation.notexist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/*
 * 기존 트랜잭션이 없는 경우 테스트
 */
@RestController
@RequestMapping("/notExist")
@RequiredArgsConstructor
public class NotExistTransactionController {

	private final NotExistTransactionService notExistTransactionService;

	@GetMapping("/required")
	public String required() {
		notExistTransactionService.required();
		return "ok";
	}

	@GetMapping("/requiresNew")
	public String requiresNew() {
		notExistTransactionService.requiresNew();
		return "ok";
	}

	@GetMapping("/nested")
	public String nested() {
		try {
			notExistTransactionService.nested();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

	@GetMapping("/supports")
	public String supports() {
		try {
			notExistTransactionService.supports();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

	@GetMapping("/mandatory")
	public String mandatory() {
		try {
			notExistTransactionService.mandatory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

	@GetMapping("/notSupported")
	public String notSupported() {
		try {
			notExistTransactionService.notSupported();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

	@GetMapping("/never")
	public String never() {
		try {
			notExistTransactionService.never();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

}
