package study.spring.mybatis_spring.person;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
public class PersonMapperTest {

    @Autowired
    private PersonMapper mapper;

    /**
     * 1. Creating a new SqlSession
     * 2. SqlSession was not registered for synchronization because synchronization is not
     * 3. JDBC Connection will not be managed by Spring
     * 4. Execute query
     * 5. Closing non transactional SqlSession
     * 6. Creating a new SqlSession
     * 7. SqlSession was not registered for synchronization because synchronization is not
     * 8. JDBC Connection will not be managed by Spring
     * 9. Execute query
     * 10. Closing non transactional SqlSession
     */
    @Test
    void selectPerson() {
        mapper.selectPerson(1L);
    }

    /**
     * 1. Creating a new SqlSession
     * 2. SqlSession was not registered for synchronization because synchronization is not
     * 3. JDBC Connection will not be managed by Spring
     * 4. Execute query
     * 5. Closing non transactional SqlSession
     */
    @Test
    void selectPersonTwice() {
        mapper.selectPerson(1L);
        mapper.selectPerson(1L);
    }

    /**
     * 1. Creating a new SqlSession
     * 2. Registering transaction synchronization for SqlSession
     * 3. Execute query
     * 4. Releasing transactional SqlSession
     * 5. Transaction synchronization deregistering SqlSession
     * 6. Transaction synchronization closing SqlSession
     * 7. commit or rollback
     */
    @Test
    @Transactional
    void selectPersonWithTx() {
        mapper.selectPerson(1L);
    }

    /**
     * 1. Creating a new SqlSession
     * 2. Registering transaction synchronization for SqlSession
     * 3. Execute query
     * 4. Releasing transactional SqlSession
     * 5. Fetched SqlSession
     * 6. Execute query (동일 메서드, 동일 파라메터 전달 -> Mybatis 캐싱으로 인해 쿼리 수행하지 않고 캐싱에서 가져옴)
     * 7. Releasing transactional SqlSession
     * 8. Transaction synchronization deregistering SqlSession
     * 9. Transaction synchronization closing SqlSession
     * 10. commit or rollback
     */
    @Test
    @Transactional
    void selectPersonTwiceWithTx() {
        mapper.selectPerson(1L);
        mapper.selectPerson(1L);
    }


}
