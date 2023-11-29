package study.spring.mybatis_spring.propagation.exist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/exist")
@RequiredArgsConstructor
public class ExistTransactionController {

	private final ExistTransactionService existTransactionService;

	@GetMapping("/required")
	public String required() {
		existTransactionService.required_required();
		return "ok";
	}

	@GetMapping("/requiresNew")
	public String requiresNew() {
		existTransactionService.required_requiresNew();
		return "ok";
	}

	@GetMapping("/nested")
	public String nested() {
		try {
			existTransactionService.required_nested();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

	@GetMapping("/supports")
	public String supports() {
		try {
			existTransactionService.required_supports();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

	@GetMapping("/notSupported")
	public String notSupported() {
		try {
			existTransactionService.required_notSupported();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

	@GetMapping("/mandatory")
	public String mandatory() {
		try {
			existTransactionService.required_mandatory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

	@GetMapping("/never")
	public String never() {
		try {
			existTransactionService.required_never();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

}
