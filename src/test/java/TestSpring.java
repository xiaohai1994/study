import com.spring.AppContext;
import com.spring.User;
import com.spring.service.AnnotationConfigApplicationContext;
import org.junit.Test;


public class TestSpring {

    @Test
    public void test_Spring(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppContext.class);
//        User user = (User) annotationConfigApplicationContext.getBean("user");
//        user.println();

    }

}
