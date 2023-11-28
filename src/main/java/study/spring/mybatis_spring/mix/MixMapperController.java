package study.spring.mybatis_spring.mix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mix")
public class MixMapperController {

	@Autowired
	MixMapperService mixMapperService;

	@GetMapping("/test1")
	public String test1() {
		mixMapperService.selectMemberThenPerson();
		return "ok";
	}

	@GetMapping("/test2")
	public String test2() {
		mixMapperService.selectMemberThenPersonTx();
		return "ok";
	}

	@GetMapping("/test3")
	public String test3() {
		try {
			mixMapperService.insertMemberThenPersonTxButRuntimeException1();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

	@GetMapping("/test4")
	public String test4() {
		try {
			mixMapperService.insertMemberThenPersonTxButRuntimeException2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

	@GetMapping("/test5")
	public String test5() {
		try {
			mixMapperService.insertMemberThenPersonTxButException1();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

	@GetMapping("/test6")
	public String test6() {
		try {
			mixMapperService.insertMemberThenPersonTxButException2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}

}
