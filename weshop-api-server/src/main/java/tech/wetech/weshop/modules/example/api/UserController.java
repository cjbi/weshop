package tech.wetech.weshop.modules.example.api;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.core.utils.BaseController;
import tech.wetech.weshop.modules.example.mapper.UserMapper;
import tech.wetech.weshop.modules.example.po.User;

import java.util.List;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{pageNum}/{pageSize}")
    public List<User> queryUserList(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAll();
    }

}
