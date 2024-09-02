package shop.mtcoding.springv3.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> { // 인터페이스는 세상에 존재하는게 아니기 때문에 new 할 수 없음
    // 인터페이셔 안에는 무조건 public 이니까 생략 가능
    @Query("select u from User u where u.username=:username") // JPQL
    User findByUsername(@Param("username") String username); // 쿼리만 잘붙여주고 리턴타입만 잘붙여주면 끝
}
