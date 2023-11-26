package study.spring.mybatis_spring.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/test1")
    public String test1() {
        personService.selectPerson();
        return "ok";
    }

    @GetMapping("/test2")
    public String test2() {
        personService.selectPersonTwice();
        return "ok";
    }

    @GetMapping("/test3")
    public String test3() {
        personService.selectPersonWithTx();
        return "ok";
    }

    @GetMapping("/test4")
    public String test4() {
        personService.selectPersonTwiceWithTx();
        return "ok";
    }
}
