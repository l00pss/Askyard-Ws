package az.askyard.askyardws.business.concretes;

import az.askyard.askyardws.business.abstracts.DashboardService;
import az.askyard.askyardws.business.abstracts.UserService;
import az.askyard.askyardws.core.concretes.utilities.messages.success.PostSuccessMessages;
import az.askyard.askyardws.core.concretes.utilities.result.DataResult;
import az.askyard.askyardws.core.concretes.utilities.result.Result;
import az.askyard.askyardws.core.concretes.utilities.result.success.SuccessDataResult;
import az.askyard.askyardws.dataAccess.abstracts.PostRepository;
import az.askyard.askyardws.dataAccess.abstracts.UserRepository;
import az.askyard.askyardws.entities.concretes.dto.UserDashboard;
import az.askyard.askyardws.entities.concretes.post.Post;
import az.askyard.askyardws.entities.concretes.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardManager implements DashboardService {

    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public DashboardManager(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Result post(User user, Post post) {
        post.setAuthorOfPost(user);
        return new SuccessDataResult<>(this.postRepository.save(post), PostSuccessMessages.POSTED.getValue());
    }

    @Override
    public Result likePost(User user, Long postId) {
        return null;
    }

    @Override
    public Result unlikePost(User user, Long postId) {
        return null;
    }

    @Override
    public Result deletePost(User user, Long postId) {
        return null;
    }

    @Override
    public Result updatePost(User user, Long postId) {
        return null;
    }

    @Override
    public Result reportPost(User user, Long postId, String message) {
        return null;
    }

    @Override
    public Result commentToPost(User user, Long postId) {
        return null;
    }

    @Override
    public DataResult<List<UserDashboard>> getDashboard(User user) {
        List<UserDashboard> userDashboards = new ArrayList<>();

        return new SuccessDataResult<List<UserDashboard>>();
    }


}
