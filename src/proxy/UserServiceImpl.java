package proxy;

/**
 * 实现类
 * @author liuyang
 *
 */
public class UserServiceImpl implements UserService{

	@Override
	public String getUserName() {
		return "大牛";
	}

	@Override
	public String getUserAge() {
		return "10";
	}

}
