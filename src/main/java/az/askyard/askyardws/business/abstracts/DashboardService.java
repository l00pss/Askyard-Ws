package az.askyard.askyardws.business.abstracts;

import az.askyard.askyardws.core.concretes.utilities.result.DataResult;
import az.askyard.askyardws.core.concretes.utilities.result.Result;
import az.askyard.askyardws.entities.concretes.dto.UserDashboard;
import az.askyard.askyardws.entities.concretes.post.Post;
import az.askyard.askyardws.entities.concretes.user.User;

import java.util.List;

public interface DashboardService {

    Result post(User user, Post post);

    Result likePost(User user,Long postId);

    Result unlikePost(User user,Long postId);

    Result deletePost(User user,Long postId);

    Result updatePost(User user,Long postId);

    Result reportPost(User user,Long postId,String message);

    Result commentToPost(User user,Long postId);

    DataResult<List<UserDashboard>> getDashboard(User user);

}
